package org.com1028.ap00921.classes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LengthTest {
	
	/**
	 * 141685sec = 1d 15h 21m 25s
	 */
	@Test
	public void testCalculateLength(){
		Length length = new Length();
		
		int seconds = 141685;
		
		length.calculateLength(seconds);
		
		/*testing getters*/
		assertEquals(1, length.getDays(),0);
		assertEquals(15, length.getHours(),0);
		assertEquals(21, length.getMinutes(),0);
		assertEquals(25, length.getSeconds(),0);
	}
	
	/**
	 * First input can't be 0
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testCalculateReverseLength_firstInputIs0() {
		Length length = new Length();
		
		length.calculateReverseLength(0, 10);	
	}
	
	/**
	 * Second input can't be 0
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testCalculateReverseLength_secondInputIs0() {
		Length length = new Length();
		
		length.calculateReverseLength(10, 0);	
	}
	
	/**
	 * 43min 10sec = 2590sec
	 */
	@Test 
	public void testCalculateReverseLength() {
		Length length = new Length();
		
		int seconds = length.calculateReverseLength(43, 10);
		
		assertEquals(2590, seconds,0);		
	}
	
	/**
	 * 3days 23hours 30min 1s = 343801sec
	 */
	@Test
	public void testToStringList1() {
		Length length = new Length();
		
		int seconds = 343801;
		
		length.calculateLength(seconds);
		
		assertEquals("3d 23h 30m 1s", length.toStringList());
	}
	
	/**
	 * 23hours 30min 1s = 84601sec
	 */
	@Test
	public void testToStringList2() {
		Length length = new Length();
		
		int seconds = 84601;
		
		length.calculateLength(seconds);
		
		assertEquals("23h 30m 1s", length.toStringList());
	}
	
	/**
	 * 30min 1s = 1801sec
	 */
	@Test
	public void testToStringList3() {
		Length length = new Length();
		
		int seconds = 1801;
		
		length.calculateLength(seconds);
		
		assertEquals("30m 1s", length.toStringList());
	}
	
	/**
	 * Can't create a string if seconds < 60
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testToStringList4() {
		Length length = new Length();
		
		int seconds = 50;
		
		length.calculateLength(seconds);
		
		length.toStringList();
	}
	
	/**
	 * 120sec = "2min"
	 */
	@Test
	public void testToStringAlbum() {
		Length length = new Length();
		
		int seconds = 120;
		
		length.calculateLength(seconds);
		
		assertEquals("2min",length.toStringAlbum());
	}
	
	/**
	 * 163sec = "2:40"
	 */
	@Test
	public void testToStringSingle() {
		Length length = new Length();
		
		int seconds = 160;
		
		length.calculateLength(seconds);
		
		assertEquals("2:40",length.toStringSingle());
	}
	
	
	
	
}
