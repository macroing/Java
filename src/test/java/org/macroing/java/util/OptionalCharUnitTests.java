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

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

@SuppressWarnings("static-method")
public final class OptionalCharUnitTests {
	public OptionalCharUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testEmpty() {
		final OptionalChar optionalChar = OptionalChar.empty();
		
		assertFalse(optionalChar.isPresent());
	}
	
	@Test
	public void testEquals() {
		final OptionalChar a = OptionalChar.empty();
		final OptionalChar b = OptionalChar.empty();
		final OptionalChar c = OptionalChar.of('A');
		final OptionalChar d = OptionalChar.of('A');
		final OptionalChar e = OptionalChar.of('B');
		final OptionalChar f = OptionalChar.of('B');
		final OptionalChar g = null;
		
		assertEquals(a, a);
		assertEquals(a, b);
		assertEquals(b, a);
		
		assertEquals(c, c);
		assertEquals(c, d);
		assertEquals(d, c);
		
		assertEquals(e, e);
		assertEquals(e, f);
		assertEquals(f, e);
		
		assertNotEquals(a, c);
		assertNotEquals(c, a);
		
		assertNotEquals(c, e);
		assertNotEquals(e, c);
		
		assertNotEquals(e, g);
		assertNotEquals(g, e);
	}
	
	@Test
	public void testGetAsChar() {
		assertEquals('A', OptionalChar.of('A').getAsChar());
		assertEquals('B', OptionalChar.of('B').getAsChar());
		
		assertThrows(NoSuchElementException.class, () -> OptionalChar.empty().getAsChar());
	}
	
	@Test
	public void testHashCode() {
		final OptionalChar a = OptionalChar.empty();
		final OptionalChar b = OptionalChar.empty();
		final OptionalChar c = OptionalChar.of('A');
		final OptionalChar d = OptionalChar.of('A');
		final OptionalChar e = OptionalChar.of('B');
		final OptionalChar f = OptionalChar.of('B');
		
		assertEquals(a.hashCode(), b.hashCode());
		assertEquals(c.hashCode(), d.hashCode());
		assertEquals(e.hashCode(), f.hashCode());
	}
	
	@Test
	public void testIfPresent() {
		final OptionalChar a = OptionalChar.empty();
		final OptionalChar b = OptionalChar.of('B');
		final OptionalChar c = OptionalChar.of('C');
		
		final StringBuilder stringBuilder = new StringBuilder();
		
		a.ifPresent(null);
		a.ifPresent(value -> stringBuilder.append("A"));
		b.ifPresent(value -> stringBuilder.append("B"));
		c.ifPresent(value -> stringBuilder.append("C"));
		
		final String string = stringBuilder.toString();
		
		assertEquals("BC", string);
		
		assertThrows(NullPointerException.class, () -> b.ifPresent(null));
	}
	
	@Test
	public void testIsPresent() {
		assertTrue(OptionalChar.of('A').isPresent());
		assertTrue(OptionalChar.of('B').isPresent());
		
		assertFalse(OptionalChar.empty().isPresent());
	}
	
	@Test
	public void testOf() {
		final OptionalChar optionalChar = OptionalChar.of('A');
		
		assertTrue(optionalChar.isPresent());
	}
	
	@Test
	public void testOrElse() {
		assertEquals('A', OptionalChar.empty().orElse('A'));
		assertEquals('A', OptionalChar.of('A').orElse('B'));
	}
	
	@Test
	public void testOrElseGet() {
		assertEquals('A', OptionalChar.of('A').orElseGet(null));
		assertEquals('A', OptionalChar.of('A').orElseGet(() -> 'B'));
		assertEquals('A', OptionalChar.empty().orElseGet(() -> 'A'));
		
		assertThrows(NullPointerException.class, () -> OptionalChar.empty().orElseGet(null));
	}
	
	@Test
	public void testOrElseThrow() {
		assertEquals('A', OptionalChar.of('A').orElseThrow(null));
		assertEquals('A', OptionalChar.of('A').orElseThrow(() -> null));
		assertEquals('A', OptionalChar.of('A').orElseThrow(() -> new RuntimeException()));
		
		assertThrows(NullPointerException.class, () -> OptionalChar.empty().orElseThrow(null));
		assertThrows(NullPointerException.class, () -> OptionalChar.empty().orElseThrow(() -> null));
		assertThrows(RuntimeException.class, () -> OptionalChar.empty().orElseThrow(() -> new RuntimeException()));
	}
	
	@Test
	public void testToString() {
		assertEquals("OptionalChar.empty", OptionalChar.empty().toString());
		assertEquals("OptionalChar[A]", OptionalChar.of('A').toString());
	}
}