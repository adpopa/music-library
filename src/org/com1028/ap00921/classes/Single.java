/**
 * Single.java
 */
package org.com1028.ap00921.classes;

/**
 * @author ap00921 - Alex Daniel Popa - URN: 6440987
 *
 */
public class Single extends Music {

	private int length = 0;
	
	private String album = null;

	/**
	 * @param title
	 * @param genre
	 * @param artist
	 * @param year
	 * @param length
	 * @param album
	 */
	public Single(String title, Genre genre, String artist, int year, int length, String album) {
		super(title, genre, artist, year);
		this.length = length;
		this.album = album;
	}

	public Single() {
		super(null, null, null, 0);
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * @return the album
	 */
	public String getAlbum() {
		return album;
	}

	/**
	 * @param album the album to set
	 */
	public void setAlbum(String album) {
		this.album = album;
	}
	
}
