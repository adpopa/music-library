/**
 * Music.java
 */
package org.com1028.ap00921.classes;

/**
 * @author ap00921 - Alex Daniel Popa - URN: 6440987
 *
 */
public class Music {

	private String title = null;
	
	private Genre genre = null;
	
	private String artist = null;
	
	private int year = 0;

	/**
	 * @param title
	 * @param genre
	 * @param artist
	 * @param year
	 */
	public Music(String title, Genre genre, String artist, int year) {
		this.title = title;
		this.genre = genre;
		this.artist = artist;
		this.year = year;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the genre
	 */
	public Genre getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * @param string the artist to set
	 */
	public void setArtist(String string) {
		this.artist = string;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
}
