/**
 * Copyright 2021 - 2023 J&#246;rgen Lundgren
 * 
 * This file is part of org.macroing.java.
 * 
 * org.macroing.java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * org.macroing.java is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with org.macroing.java. If not, see <http://www.gnu.org/licenses/>.
 */
package org.macroing.java.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

@SuppressWarnings("static-method")
public final class TimerUnitTests {
	public TimerUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testConstructor() {
		final Timer timer = new Timer();
		
		assertTrue(timer.getMillisecondsFrom() >= 0L && timer.getMillisecondsFrom() <= System.currentTimeMillis());
	}
	
	@Test
	public void testConstructorLong() {
		final Timer timer = new Timer(1000L);
		
		assertEquals(1000L, timer.getMillisecondsFrom());
	}
	
	@Test
	public void testEquals() {
		final Timer a = new Timer(1000L);
		final Timer b = new Timer(1000L);
		final Timer c = new Timer(2000L);
		final Timer d = null;
		
		assertEquals(a, a);
		assertEquals(a, b);
		assertEquals(b, a);
		
		assertNotEquals(a, c);
		assertNotEquals(c, a);
		assertNotEquals(a, d);
		assertNotEquals(d, a);
	}
	
	@Test
	public void testGetHours() {
		final Timer timer = new Timer();
		
		assertEquals(0L, timer.getHours());
	}
	
	@Test
	public void testGetHoursLong() {
		final Timer timer = new Timer(0L);
		
		assertEquals(1L, timer.getHours(3600000L));
	}
	
	@Test
	public void testGetMilliseconds() {
		final Timer timer = new Timer();
		
		final long milliseconds = timer.getMilliseconds();
		
		assertTrue(milliseconds >= 0L && milliseconds <= 1000L);
	}
	
	@Test
	public void testGetMillisecondsFrom() {
		final Timer timer = new Timer(1000L);
		
		assertEquals(1000L, timer.getMillisecondsFrom());
	}
	
	@Test
	public void testGetMillisecondsLong() {
		final Timer timer = new Timer(0L);
		
		assertEquals(3661500L, timer.getMilliseconds(3600000L + 60000L + 1000L + 500L));
	}
	
	@Test
	public void testGetMillisecondsRemaining() {
		final Timer timer = new Timer();
		
		final long millisecondsRemaining = timer.getMillisecondsRemaining();
		
		assertTrue(millisecondsRemaining >= 0L && millisecondsRemaining <= 1000L);
	}
	
	@Test
	public void testGetMillisecondsRemainingLong() {
		final Timer timer = new Timer(0L);
		
		assertEquals(500L, timer.getMillisecondsRemaining(3600000L + 60000L + 1000L + 500L));
	}
	
	@Test
	public void testGetMinutes() {
		final Timer timer = new Timer();
		
		assertEquals(0L, timer.getMinutes());
	}
	
	@Test
	public void testGetMinutesLong() {
		final Timer timer = new Timer(0L);
		
		assertEquals(61L, timer.getMinutes(3600000L + 60000L + 1000L + 500L));
	}
	
	@Test
	public void testGetMinutesRemaining() {
		final Timer timer = new Timer();
		
		assertEquals(0L, timer.getMinutesRemaining());
	}
	
	@Test
	public void testGetMinutesRemainingLong() {
		final Timer timer = new Timer(0L);
		
		assertEquals(1L, timer.getMinutesRemaining(3600000L + 60000L + 1000L + 500L));
	}
	
	@Test
	public void testGetSeconds() {
		final Timer timer = new Timer();
		
		assertEquals(0L, timer.getSeconds());
	}
	
	@Test
	public void testGetSecondsLong() {
		final Timer timer = new Timer(0L);
		
		assertEquals(3661L, timer.getSeconds(3600000L + 60000L + 1000L + 500L));
	}
	
	@Test
	public void testGetSecondsRemaining() {
		final Timer timer = new Timer();
		
		assertEquals(0L, timer.getSecondsRemaining());
	}
	
	@Test
	public void testGetSecondsRemainingLong() {
		final Timer timer = new Timer(0L);
		
		assertEquals(1L, timer.getSecondsRemaining(3600000L + 60000L + 1000L + 500L));
	}
	
	@Test
	public void testGetTime() {
		final Timer timer = new Timer();
		
		assertTrue(timer.getTime().matches("[0-9]{2}:[0-9]{2}:[0-9]{2}"));
	}
	
	@Test
	public void testGetTimeLong() {
		final Timer timer = new Timer(0L);
		
		assertEquals("01:01:01", timer.getTime(3600000L + 60000L + 1000L));
	}
	
	@Test
	public void testHashCode() {
		final Timer a = new Timer(1000L);
		final Timer b = new Timer(1000L);
		
		assertEquals(a.hashCode(), b.hashCode());
	}
	
	@Test
	public void testRestart() {
		final Timer timer = new Timer();
		
		final long millisecondsFromA = timer.getMillisecondsFrom();
		
		timer.restart();
		
		final long millisecondsFromB = timer.getMillisecondsFrom();
		
		assertTrue(millisecondsFromB >= millisecondsFromA);
	}
	
	@Test
	public void testRestartLong() {
		final Timer timer = new Timer(1000L);
		
		assertEquals(1000L, timer.getMillisecondsFrom());
		
		timer.restart(2000L);
		
		assertEquals(2000L, timer.getMillisecondsFrom());
	}
	
	@Test
	public void testToString() {
		assertEquals("new Timer(1000L)", new Timer(1000L).toString());
	}
}