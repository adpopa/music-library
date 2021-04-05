/**
 * Length.java
 */
package org.com1028.ap00921.classes;

/**
 * @author ap00921 - Alex Daniel Popa - URN: 6440987
 *
 */
public class Length {

	private static final int DAY = 86400;
	private static final int HOUR = 3600;
	private static final int MINUTE = 60;

	private int days = 0;
	private int hours = 0;
	private int minutes = 0;
	private int seconds = 0;

	/**
	 * Method to calculate the amount of days, hours, minutes and seconds from a
	 * number of seconds by repetitive subtraction
	 * 
	 * @param length
	 * @throws IllegalArgumentException
	 */
	public void calculateLength(int length) {
		int l = length;
		while (l >= DAY) {
			this.days++;
			l -= DAY;
		}
		while (l >= HOUR) {
			this.hours++;
			l -= HOUR;
		}
		while (l >= MINUTE) {
			this.minutes++;
			l -= MINUTE;
		}
		this.seconds = l;

	}

	/**
	 * Method to calculate the number of seconds within a time period consisted
	 * of minutes and seconds
	 * 
	 * @param min
	 * @param sec
	 * @return number of seconds from minutes added with the seconds
	 * @throws IllegalArgumentException
	 */
	public int calculateReverseLength(int min, int sec) throws IllegalArgumentException {
		if (min == 0) {
			throw new IllegalArgumentException("First input can't be 0");
		} else if (sec == 0) {
			throw new IllegalArgumentException("Second input can't be 0");
		} else {
			return min * MINUTE + sec;
		}

	}

	/**
	 * Method to create the appropriate string without the zero values of days,
	 * or hours if they don't exist
	 * 
	 * @return appropiate string
	 * @throws IllegalArgumentException
	 */
	public String toStringList() throws IllegalArgumentException {
		if (days > 0) {
			return days + "d " + hours + "h " + minutes + "m " + seconds + "s";
		}
		if (hours > 0) {
			return hours + "h " + minutes + "m " + seconds + "s";
		}
		if (minutes > 0) {
			return minutes + "m " + seconds + "s";
		} else {
			throw new IllegalArgumentException("Too few seconds to create the string");
		}
	}

	/**
	 * 
	 * @return string representing the album time in minutes
	 */
	public String toStringAlbum() {
		return minutes + "min";
	}

	/**
	 * 
	 * @return string representing the song time as mm:ss
	 */
	public String toStringSingle() {
		return minutes + ":" + String.format("%02d", seconds);
	}

	/**
	 * @return the days
	 */
	public int getDays() {
		return days;
	}

	/**
	 * @return the hours
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * @return the minutes
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * @return the seconds
	 */
	public int getSeconds() {
		return seconds;
	}

}
