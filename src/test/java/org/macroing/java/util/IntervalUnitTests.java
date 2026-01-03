/**
 * Copyright 2021 - 2026 J&#246;rgen Lundgren
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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

@SuppressWarnings("static-method")
public final class IntervalUnitTests {
	public IntervalUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testConstructorTT() {
		final Interval<Integer> interval = new Interval<>(Integer.valueOf(10), Integer.valueOf(20));
		
		assertEquals(Integer.valueOf(10), interval.getEndpointA());
		assertEquals(Integer.valueOf(20), interval.getEndpointB());
		
		assertFalse(interval.isIncludingEndpointA());
		assertFalse(interval.isIncludingEndpointB());
		
		assertThrows(NullPointerException.class, () -> new Interval<>(Integer.valueOf(10), null));
		assertThrows(NullPointerException.class, () -> new Interval<>(null, Integer.valueOf(20)));
	}
	
	@Test
	public void testConstructorTTBoolean() {
		final Interval<Integer> interval = new Interval<>(Integer.valueOf(10), Integer.valueOf(20), true);
		
		assertEquals(Integer.valueOf(10), interval.getEndpointA());
		assertEquals(Integer.valueOf(20), interval.getEndpointB());
		
		assertTrue(interval.isIncludingEndpointA());
		assertTrue(interval.isIncludingEndpointB());
		
		assertThrows(NullPointerException.class, () -> new Interval<>(Integer.valueOf(10), null, true));
		assertThrows(NullPointerException.class, () -> new Interval<>(null, Integer.valueOf(20), true));
	}
	
	@Test
	public void testConstructorTTBooleanBoolean() {
		final Interval<Integer> interval = new Interval<>(Integer.valueOf(10), Integer.valueOf(20), true, false);
		
		assertEquals(Integer.valueOf(10), interval.getEndpointA());
		assertEquals(Integer.valueOf(20), interval.getEndpointB());
		
		assertTrue(interval.isIncludingEndpointA());
		
		assertFalse(interval.isIncludingEndpointB());
		
		assertThrows(NullPointerException.class, () -> new Interval<>(Integer.valueOf(10), null, true, false));
		assertThrows(NullPointerException.class, () -> new Interval<>(null, Integer.valueOf(20), true, false));
	}
	
	@Test
	public void testContains() {
		final Interval<Integer> a = new Interval<>(Integer.valueOf(20), Integer.valueOf(30), false, false);//21 - 29
		final Interval<Integer> b = new Interval<>(Integer.valueOf(30), Integer.valueOf(20), false, false);//21 - 29
		final Interval<Integer> c = new Interval<>(Integer.valueOf(20), Integer.valueOf(30), false,  true);//21 - 30
		final Interval<Integer> d = new Interval<>(Integer.valueOf(30), Integer.valueOf(20), false,  true);//20 - 29
		final Interval<Integer> e = new Interval<>(Integer.valueOf(20), Integer.valueOf(30),  true, false);//20 - 29
		final Interval<Integer> f = new Interval<>(Integer.valueOf(30), Integer.valueOf(20),  true, false);//21 - 30
		final Interval<Integer> g = new Interval<>(Integer.valueOf(20), Integer.valueOf(30),  true,  true);//20 - 30
		final Interval<Integer> h = new Interval<>(Integer.valueOf(30), Integer.valueOf(20),  true,  true);//20 - 30
		
		assertTrue(a.contains(Integer.valueOf(21)));
		assertTrue(a.contains(Integer.valueOf(29)));
		assertTrue(b.contains(Integer.valueOf(21)));
		assertTrue(b.contains(Integer.valueOf(29)));
		assertTrue(c.contains(Integer.valueOf(21)));
		assertTrue(c.contains(Integer.valueOf(30)));
		assertTrue(d.contains(Integer.valueOf(20)));
		assertTrue(d.contains(Integer.valueOf(29)));
		assertTrue(e.contains(Integer.valueOf(20)));
		assertTrue(e.contains(Integer.valueOf(29)));
		assertTrue(f.contains(Integer.valueOf(21)));
		assertTrue(f.contains(Integer.valueOf(30)));
		assertTrue(g.contains(Integer.valueOf(20)));
		assertTrue(g.contains(Integer.valueOf(30)));
		assertTrue(h.contains(Integer.valueOf(20)));
		assertTrue(h.contains(Integer.valueOf(30)));
		
		assertFalse(a.contains(Integer.valueOf(20)));
		assertFalse(a.contains(Integer.valueOf(30)));
		assertFalse(b.contains(Integer.valueOf(20)));
		assertFalse(b.contains(Integer.valueOf(30)));
		assertFalse(c.contains(Integer.valueOf(20)));
		assertFalse(c.contains(Integer.valueOf(31)));
		assertFalse(d.contains(Integer.valueOf(19)));
		assertFalse(d.contains(Integer.valueOf(30)));
		assertFalse(e.contains(Integer.valueOf(19)));
		assertFalse(e.contains(Integer.valueOf(30)));
		assertFalse(f.contains(Integer.valueOf(20)));
		assertFalse(f.contains(Integer.valueOf(31)));
		assertFalse(g.contains(Integer.valueOf(19)));
		assertFalse(g.contains(Integer.valueOf(31)));
		assertFalse(h.contains(Integer.valueOf(19)));
		assertFalse(h.contains(Integer.valueOf(31)));
		
		assertThrows(NullPointerException.class, () -> a.contains(null));
	}
	
	@Test
	public void testEquals() {
		final Interval<Integer> a = new Interval<>(Integer.valueOf(10), Integer.valueOf(20), false, false);
		final Interval<Integer> b = new Interval<>(Integer.valueOf(10), Integer.valueOf(20), false, false);
		final Interval<Integer> c = new Interval<>(Integer.valueOf(10), Integer.valueOf(20), false,  true);
		final Interval<Integer> d = new Interval<>(Integer.valueOf(10), Integer.valueOf(20),  true, false);
		final Interval<Integer> e = new Interval<>(Integer.valueOf(10), Integer.valueOf(20),  true,  true);
		final Interval<Integer> f = new Interval<>(Integer.valueOf(10), Integer.valueOf(30), false, false);
		final Interval<Integer> g = new Interval<>(Integer.valueOf(30), Integer.valueOf(20), false, false);
		final Interval<Integer> h = null;
		
		assertEquals(a, a);
		assertEquals(a, b);
		assertEquals(b, a);
		
		assertNotEquals(a, c);
		assertNotEquals(c, a);
		assertNotEquals(a, d);
		assertNotEquals(d, a);
		assertNotEquals(a, e);
		assertNotEquals(e, a);
		assertNotEquals(a, f);
		assertNotEquals(f, a);
		assertNotEquals(a, g);
		assertNotEquals(g, a);
		assertNotEquals(a, h);
		assertNotEquals(h, a);
	}
	
	@Test
	public void testGetEndpointA() {
		final Interval<Integer> a = new Interval<>(Integer.valueOf(10), Integer.valueOf(20));
		final Interval<Integer> b = new Interval<>(Integer.valueOf(20), Integer.valueOf(10));
		
		assertEquals(Integer.valueOf(10), a.getEndpointA());
		assertEquals(Integer.valueOf(20), b.getEndpointA());
	}
	
	@Test
	public void testGetEndpointB() {
		final Interval<Integer> a = new Interval<>(Integer.valueOf(10), Integer.valueOf(20));
		final Interval<Integer> b = new Interval<>(Integer.valueOf(20), Integer.valueOf(10));
		
		assertEquals(Integer.valueOf(20), a.getEndpointB());
		assertEquals(Integer.valueOf(10), b.getEndpointB());
	}
	
	@Test
	public void testHashCode() {
		final Interval<Integer> a = new Interval<>(Integer.valueOf(20), Integer.valueOf(30), false, false);
		final Interval<Integer> b = new Interval<>(Integer.valueOf(20), Integer.valueOf(30), false, false);
		
		assertEquals(a.hashCode(), b.hashCode());
	}
	
	@Test
	public void testIsClosed() {
		final Interval<Integer> a = new Interval<>(Integer.valueOf(20), Integer.valueOf(30), false, false);
		final Interval<Integer> b = new Interval<>(Integer.valueOf(20), Integer.valueOf(30), false,  true);
		final Interval<Integer> c = new Interval<>(Integer.valueOf(20), Integer.valueOf(30),  true, false);
		final Interval<Integer> d = new Interval<>(Integer.valueOf(20), Integer.valueOf(30),  true,  true);
		
		assertTrue(d.isClosed());
		
		assertFalse(a.isClosed());
		assertFalse(b.isClosed());
		assertFalse(c.isClosed());
	}
	
	@Test
	public void testIsExcludingEndpointA() {
		final Interval<Integer> a = new Interval<>(Integer.valueOf(20), Integer.valueOf(30), false, false);
		final Interval<Integer> b = new Interval<>(Integer.valueOf(20), Integer.valueOf(30), false,  true);
		final Interval<Integer> c = new Interval<>(Integer.valueOf(20), Integer.valueOf(30),  true, false);
		final Interval<Integer> d = new Interval<>(Integer.valueOf(20), Integer.valueOf(30),  true,  true);
		
		assertTrue(a.isExcludingEndpointA());
		assertTrue(b.isExcludingEndpointA());
		
		assertFalse(c.isExcludingEndpointA());
		assertFalse(d.isExcludingEndpointA());
	}
	
	@Test
	public void testIsExcludingEndpointB() {
		final Interval<Integer> a = new Interval<>(Integer.valueOf(20), Integer.valueOf(30), false, false);
		final Interval<Integer> b = new Interval<>(Integer.valueOf(20), Integer.valueOf(30), false,  true);
		final Interval<Integer> c = new Interval<>(Integer.valueOf(20), Integer.valueOf(30),  true, false);
		final Interval<Integer> d = new Interval<>(Integer.valueOf(20), Integer.valueOf(30),  true,  true);
		
		assertTrue(a.isExcludingEndpointB());
		assertTrue(c.isExcludingEndpointB());
		
		assertFalse(b.isExcludingEndpointB());
		assertFalse(d.isExcludingEndpointB());
	}
	
	@Test
	public void testIsGreaterThan() {
		final Interval<Integer> a = new Interval<>(Integer.valueOf(20), Integer.valueOf(30), false, false);//21 - 29
		final Interval<Integer> b = new Interval<>(Integer.valueOf(30), Integer.valueOf(20), false, false);//21 - 29
		final Interval<Integer> c = new Interval<>(Integer.valueOf(20), Integer.valueOf(30), false,  true);//21 - 30
		final Interval<Integer> d = new Interval<>(Integer.valueOf(30), Integer.valueOf(20), false,  true);//20 - 29
		final Interval<Integer> e = new Interval<>(Integer.valueOf(20), Integer.valueOf(30),  true, false);//20 - 29
		final Interval<Integer> f = new Interval<>(Integer.valueOf(30), Integer.valueOf(20),  true, false);//21 - 30
		final Interval<Integer> g = new Interval<>(Integer.valueOf(20), Integer.valueOf(30),  true,  true);//20 - 30
		final Interval<Integer> h = new Interval<>(Integer.valueOf(30), Integer.valueOf(20),  true,  true);//20 - 30
		
		assertTrue(a.isGreaterThan(Integer.valueOf(30)));
		assertTrue(b.isGreaterThan(Integer.valueOf(30)));
		assertTrue(c.isGreaterThan(Integer.valueOf(31)));
		assertTrue(d.isGreaterThan(Integer.valueOf(30)));
		assertTrue(e.isGreaterThan(Integer.valueOf(30)));
		assertTrue(f.isGreaterThan(Integer.valueOf(31)));
		assertTrue(g.isGreaterThan(Integer.valueOf(31)));
		assertTrue(h.isGreaterThan(Integer.valueOf(31)));
		
		assertFalse(a.isGreaterThan(Integer.valueOf(29)));
		assertFalse(b.isGreaterThan(Integer.valueOf(29)));
		assertFalse(c.isGreaterThan(Integer.valueOf(30)));
		assertFalse(d.isGreaterThan(Integer.valueOf(29)));
		assertFalse(e.isGreaterThan(Integer.valueOf(29)));
		assertFalse(f.isGreaterThan(Integer.valueOf(30)));
		assertFalse(g.isGreaterThan(Integer.valueOf(30)));
		assertFalse(h.isGreaterThan(Integer.valueOf(30)));
		
		assertThrows(NullPointerException.class, () -> a.isGreaterThan(null));
	}
	
	@Test
	public void testIsHalfOpen() {
		final Interval<Integer> a = new Interval<>(Integer.valueOf(20), Integer.valueOf(30), false, false);
		final Interval<Integer> b = new Interval<>(Integer.valueOf(20), Integer.valueOf(30), false,  true);
		final Interval<Integer> c = new Interval<>(Integer.valueOf(20), Integer.valueOf(30),  true, false);
		final Interval<Integer> d = new Interval<>(Integer.valueOf(20), Integer.valueOf(30),  true,  true);
		
		assertTrue(b.isHalfOpen());
		assertTrue(c.isHalfOpen());
		
		assertFalse(a.isHalfOpen());
		assertFalse(d.isHalfOpen());
	}
	
	@Test
	public void testIsIncludingEndpointA() {
		final Interval<Integer> a = new Interval<>(Integer.valueOf(20), Integer.valueOf(30), false, false);
		final Interval<Integer> b = new Interval<>(Integer.valueOf(20), Integer.valueOf(30), false,  true);
		final Interval<Integer> c = new Interval<>(Integer.valueOf(20), Integer.valueOf(30),  true, false);
		final Interval<Integer> d = new Interval<>(Integer.valueOf(20), Integer.valueOf(30),  true,  true);
		
		assertTrue(c.isIncludingEndpointA());
		assertTrue(d.isIncludingEndpointA());
		
		assertFalse(a.isIncludingEndpointA());
		assertFalse(b.isIncludingEndpointA());
	}
	
	@Test
	public void testIsIncludingEndpointB() {
		final Interval<Integer> a = new Interval<>(Integer.valueOf(20), Integer.valueOf(30), false, false);
		final Interval<Integer> b = new Interval<>(Integer.valueOf(20), Integer.valueOf(30), false,  true);
		final Interval<Integer> c = new Interval<>(Integer.valueOf(20), Integer.valueOf(30),  true, false);
		final Interval<Integer> d = new Interval<>(Integer.valueOf(20), Integer.valueOf(30),  true,  true);
		
		assertTrue(b.isIncludingEndpointB());
		assertTrue(d.isIncludingEndpointB());
		
		assertFalse(a.isIncludingEndpointB());
		assertFalse(c.isIncludingEndpointB());
	}
	
	@Test
	public void testIsLessThan() {
		final Interval<Integer> a = new Interval<>(Integer.valueOf(20), Integer.valueOf(30), false, false);//21 - 29
		final Interval<Integer> b = new Interval<>(Integer.valueOf(30), Integer.valueOf(20), false, false);//21 - 29
		final Interval<Integer> c = new Interval<>(Integer.valueOf(20), Integer.valueOf(30), false,  true);//21 - 30
		final Interval<Integer> d = new Interval<>(Integer.valueOf(30), Integer.valueOf(20), false,  true);//20 - 29
		final Interval<Integer> e = new Interval<>(Integer.valueOf(20), Integer.valueOf(30),  true, false);//20 - 29
		final Interval<Integer> f = new Interval<>(Integer.valueOf(30), Integer.valueOf(20),  true, false);//21 - 30
		final Interval<Integer> g = new Interval<>(Integer.valueOf(20), Integer.valueOf(30),  true,  true);//20 - 30
		final Interval<Integer> h = new Interval<>(Integer.valueOf(30), Integer.valueOf(20),  true,  true);//20 - 30
		
		assertTrue(a.isLessThan(Integer.valueOf(20)));
		assertTrue(b.isLessThan(Integer.valueOf(20)));
		assertTrue(c.isLessThan(Integer.valueOf(20)));
		assertTrue(d.isLessThan(Integer.valueOf(19)));
		assertTrue(e.isLessThan(Integer.valueOf(19)));
		assertTrue(f.isLessThan(Integer.valueOf(20)));
		assertTrue(g.isLessThan(Integer.valueOf(19)));
		assertTrue(h.isLessThan(Integer.valueOf(19)));
		
		assertFalse(a.isLessThan(Integer.valueOf(21)));
		assertFalse(b.isLessThan(Integer.valueOf(21)));
		assertFalse(c.isLessThan(Integer.valueOf(21)));
		assertFalse(d.isLessThan(Integer.valueOf(20)));
		assertFalse(e.isLessThan(Integer.valueOf(20)));
		assertFalse(f.isLessThan(Integer.valueOf(21)));
		assertFalse(g.isLessThan(Integer.valueOf(20)));
		assertFalse(h.isLessThan(Integer.valueOf(20)));
		
		assertThrows(NullPointerException.class, () -> a.isLessThan(null));
	}
	
	@Test
	public void testIsOpen() {
		final Interval<Integer> a = new Interval<>(Integer.valueOf(20), Integer.valueOf(30), false, false);
		final Interval<Integer> b = new Interval<>(Integer.valueOf(20), Integer.valueOf(30), false,  true);
		final Interval<Integer> c = new Interval<>(Integer.valueOf(20), Integer.valueOf(30),  true, false);
		final Interval<Integer> d = new Interval<>(Integer.valueOf(20), Integer.valueOf(30),  true,  true);
		
		assertTrue(a.isOpen());
		
		assertFalse(b.isOpen());
		assertFalse(c.isOpen());
		assertFalse(d.isOpen());
	}
	
	@Test
	public void testOfIntInt() {
		final Interval<Integer> interval = Interval.of(10, 20);
		
		assertEquals(Integer.valueOf(10), interval.getEndpointA());
		assertEquals(Integer.valueOf(20), interval.getEndpointB());
		
		assertFalse(interval.isIncludingEndpointA());
		assertFalse(interval.isIncludingEndpointB());
	}
	
	@Test
	public void testOfIntIntBoolean() {
		final Interval<Integer> interval = Interval.of(10, 20, true);
		
		assertEquals(Integer.valueOf(10), interval.getEndpointA());
		assertEquals(Integer.valueOf(20), interval.getEndpointB());
		
		assertTrue(interval.isIncludingEndpointA());
		assertTrue(interval.isIncludingEndpointB());
	}
	
	@Test
	public void testOfIntIntBooleanBoolean() {
		final Interval<Integer> interval = Interval.of(10, 20, true, false);
		
		assertEquals(Integer.valueOf(10), interval.getEndpointA());
		assertEquals(Integer.valueOf(20), interval.getEndpointB());
		
		assertTrue(interval.isIncludingEndpointA());
		
		assertFalse(interval.isIncludingEndpointB());
	}
	
	@Test
	public void testToString() {
		assertEquals("(10,20)", new Interval<>(Integer.valueOf(10), Integer.valueOf(20), false, false).toString());
		assertEquals("(10,20]", new Interval<>(Integer.valueOf(10), Integer.valueOf(20), false,  true).toString());
		assertEquals("[10,20)", new Interval<>(Integer.valueOf(10), Integer.valueOf(20),  true, false).toString());
		assertEquals("[10,20]", new Interval<>(Integer.valueOf(10), Integer.valueOf(20),  true,  true).toString());
	}
}