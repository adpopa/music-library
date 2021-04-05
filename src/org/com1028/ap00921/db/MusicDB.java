/**
 * MusicDB.java
 */
package org.com1028.ap00921.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.com1028.ap00921.classes.Album;
import org.com1028.ap00921.classes.Artist;
import org.com1028.ap00921.classes.Single;

/**
 * @author ap00921 - Alex Daniel Popa - URn: 6440987
 *
 */
public class MusicDB {
	
	//database location
	private static final String URL = "jdbc:hsqldb:file:db_data/myDBMusic;ifexists=true;shutdown=true";
	//username
	private static final String USER = "SA";
	//password
	private static final String PASS = "";
	
	// Local Variables
	private Connection connect;
	private Statement statement;

	// Default Constructor
	public MusicDB() {
		super();
		this.connect = null;
		this.statement = null;
		this.openConnection();
	}

	public void openConnection() {
		try {
			if (this.connect == null || this.connect.isClosed()) {
				// the DB Path
				this.connect = DriverManager.getConnection(URL, USER, PASS);
			}
			if (this.statement == null || this.statement.isClosed()) {
				this.statement = this.connect.createStatement();
			}
			} catch (SQLException e) {
			System.out.println("ERRRO - Failed to create a connection to the database");
			throw new RuntimeException(e);
		}
	}
	
	public void closeConnection() {
		try {
				if (this.statement != null) {
				this.statement.close();
			}
			if (this.connect != null) {
				this.connect.close();
			}
			System.out.println("Closed the connection to the database");
		} catch (Exception e) {
			System.out.print("ERROR-Failed to close the connection to the database");
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 
	 * @return list of song stored in the database
	 */
	public List<Single> getSongs() {
		List<Single> songs = new ArrayList<Single>();
		try {
			// This is our prepared query, that selects everything from book
			// table
			String query = "SELECT * FROM song";

			// Executes the query and stores the results.
			ResultSet results = this.statement.executeQuery(query);

			
			while (results.next()) {
				/*
				 * Assign results from query to their own variable. We can
				 * reference columns by their name of index value e.g. 0
				 */
				Single single = new Single();
				
				single.setTitle(results.getString(2));
				single.setArtist(results.getString(3));
				single.setAlbum(results.getString(4));
				single.setLength(results.getInt(6));
				
				songs.add(single);
			}
		} catch (SQLException e) {
			System.out.println("SQLException happened while retrieving records- abort programme");
			throw new RuntimeException(e);
		}
		return songs;
	}
	
	/**
	 * 
	 * @return list of albums stored in the database
	 */
	public List<Album> getAlbums() {
		List<Album> albums = new ArrayList<Album>();
		try {
			// This is our prepared query, that selects everything from book
			// table
			String query = "SELECT * FROM album";

			// Executes the query and stores the results.
			ResultSet results = this.statement.executeQuery(query);

			
			while (results.next()) {
				/*
				 * Assign results from query to their own variable. We can
				 * reference columns by their name of index value e.g. 0
				 */
				Album album = new Album();
				
				album.setTitle(results.getString(2));
				album.setArtist(results.getString(4));
				album.setNumberOfSongs(results.getInt(6));
				
				albums.add(album);
			}
		} catch (SQLException e) {
			System.out.println("SQLException happened while retrieving records- abort programme");
			throw new RuntimeException(e);
		}
		return albums;
	}
	
	/**
	 * 
	 * @return list of artists stored in the database
	 */
	public List<Artist> getArtists() {
		List<Artist> artists = new ArrayList<Artist>();
		try {
			// This is our prepared query, that selects everything from book
			// table
			String query = "SELECT * FROM artist";

			// Executes the query and stores the results.
			ResultSet results = this.statement.executeQuery(query);

			
			while (results.next()) {
				/*
				 * Assign results from query to their own variable. We can
				 * reference columns by their name of index value e.g. 0
				 */
				Artist artist = new Artist();
				
				artist.setId(Integer.valueOf(results.getString(1)));
				artist.setName(results.getString(2));
				
				artists.add(artist);
			}
		} catch (SQLException e) {
			System.out.println("SQLException happened while retrieving records- abort programme");
			throw new RuntimeException(e);
		}
		return artists;
	}

	/**
	 * Method to write in the database the whole 
	 * 
	 * @param album
	 * @param songs
	 * @param artist
	 */
	public void writeAlbum(Album album, List<Single> songs,Artist artist) {
		String date = dateAdded();
		try {
			// Prepared statements allow us to use variables in them more
			// efficiently
			PreparedStatement preparedStatement = this.connect
					.prepareStatement("INSERT INTO album (title, genre, artist, year, numberOfSongs, format, dateAdded) VALUES (?, ?, ?, ?, ?, ?, ?)");

			preparedStatement.setString(1, album.getTitle());
			preparedStatement.setString(2, album.getGenre().toString());
			preparedStatement.setString(3, album.getArtist());
			preparedStatement.setInt   (4, album.getYear());
			preparedStatement.setInt   (5, album.getNumberOfSongs());
			preparedStatement.setString(6, album.getFormat().toString());
			preparedStatement.setString(7, date);

			// This executes the query. Please note there are different execute
			// types.
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("SQLException happened while writing an album");
			throw new RuntimeException(e);
		}
		
		try {
			// Prepared statements allow us to use variables in them more
			// efficiently
			for(Single song : songs) {
				PreparedStatement preparedStatement = this.connect
						.prepareStatement("INSERT INTO song (title, album, artist, genre, length) VALUES (?, ?, ?, ?, ?)");
				
				
				preparedStatement.setString(1, song.getTitle());
				preparedStatement.setString(2, song.getAlbum());
				preparedStatement.setString(3, song.getArtist());
				preparedStatement.setString(4, song.getGenre().toString());
				preparedStatement.setInt   (5, song.getLength());

				// This executes the query. Please note there are different execute
				// types.
				preparedStatement.executeUpdate();
			}

		} catch (SQLException e) {
			System.out.println("SQLException happened while writing a song");
			throw new RuntimeException(e);
		}
		
		try {
			// Prepared statements allow us to use variables in them more
			// efficiently
			PreparedStatement preparedStatement = this.connect
					.prepareStatement("INSERT INTO artist (name) VALUES (?)");

			preparedStatement.setString(1, artist.getName());

			// This executes the query. Please note there are different execute
			// types.
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("SQLException happened while writing an artist");
		}
		
	}
	
	/**
	 * 
	 * @return current date as "dd/MM/yyyy HH:mm:ss"
	 */
	private String dateAdded() {
	    Format dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	    Calendar cal = Calendar.getInstance();

	    return dateFormat.format(cal.getTime());
	}
	
}
