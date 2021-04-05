/**
 * DBFactory.java
 */
package org.com1028.ap00921.db;

/**
 * @author ap00921 - Alex Daniel Popa - URn: 6440987
 *
 */
public class DBFactory {
	
	private static final MusicDB musicDB = new MusicDB();

	public static MusicDB getMusicDB() {
		return DBFactory.musicDB;
	}

}
