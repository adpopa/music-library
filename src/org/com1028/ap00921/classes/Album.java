/**
 * Album.java
 */
package org.com1028.ap00921.classes;

/**
 * @author ap00921 - Alex Daniel Popa - URN: 6440987
 *
 */
public class Album extends Music {
	
	private Format format = null;
	
	private int numberOfSongs = 0;
	
	private String dateAdded = null;

	/**
	 * @param title
	 * @param genre
	 * @param artist
	 * @param year
	 * @param format
	 * @param numberOfSongs
	 */
	public Album(String title, Genre genre, String artist, int year, Format format,int numberOfSongs, String dateAdded) {
		super(title, genre, artist, year);
		this.format = format;
		this.numberOfSongs = numberOfSongs;
		this.dateAdded = dateAdded;
	}

	public Album() {
		super(null, null, null, 0);
	}

	/**
	 * @return the format
	 */
	public Format getFormat() {
		return format;
	}

	/**
	 * @param format the format to set
	 */
	public void setFormat(Format format) {
		this.format = format;
	}

	/**
	 * @return the numberOfSongs
	 */
	public int getNumberOfSongs() {
		return numberOfSongs;
	}

	/**
	 * numberOfSongs to set
	 */
	public void setNumberOfSongs(int numberOfSongs) {
		this.numberOfSongs = numberOfSongs;
	}

	/**
	 * @return the dateAdded
	 */
	public String getDateAdded() {
		return dateAdded;
	}

	/**
	 * @param dateAdded the dateAdded to set
	 */
	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	
}
