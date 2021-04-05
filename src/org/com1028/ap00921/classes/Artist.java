/**
 * Artist.java
 */
package org.com1028.ap00921.classes;

/**
 * @author ap00921 - Alex Daniel Popa - URN: 6440987
 *
 */
public class Artist {
	
	private String name = null;
	
	private int id = 0;

	/**
	 * @param name
	 * @param albums
	 * @param songs
	 */
	public Artist(String name) {
		this.name = name;
	}

	public Artist() {
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
}
