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
public final class OptionalByteUnitTests {
	public OptionalByteUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testEmpty() {
		final OptionalByte optionalByte = OptionalByte.empty();
		
		assertFalse(optionalByte.isPresent());
	}
	
	@Test
	public void testEquals() {
		final OptionalByte a = OptionalByte.empty();
		final OptionalByte b = OptionalByte.empty();
		final OptionalByte c = OptionalByte.of((byte)(0));
		final OptionalByte d = OptionalByte.of((byte)(0));
		final OptionalByte e = OptionalByte.of((byte)(1));
		final OptionalByte f = OptionalByte.of((byte)(1));
		final OptionalByte g = null;
		
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
	public void testGetAsByte() {
		assertEquals((byte)(0), OptionalByte.of((byte)(0)).getAsByte());
		assertEquals((byte)(1), OptionalByte.of((byte)(1)).getAsByte());
		
		assertThrows(NoSuchElementException.class, () -> OptionalByte.empty().getAsByte());
	}
	
	@Test
	public void testHashCode() {
		final OptionalByte a = OptionalByte.empty();
		final OptionalByte b = OptionalByte.empty();
		final OptionalByte c = OptionalByte.of((byte)(0));
		final OptionalByte d = OptionalByte.of((byte)(0));
		final OptionalByte e = OptionalByte.of((byte)(1));
		final OptionalByte f = OptionalByte.of((byte)(1));
		
		assertEquals(a.hashCode(), b.hashCode());
		assertEquals(c.hashCode(), d.hashCode());
		assertEquals(e.hashCode(), f.hashCode());
	}
	
	@Test
	public void testIfPresent() {
		final OptionalByte a = OptionalByte.empty();
		final OptionalByte b = OptionalByte.of((byte)(0));
		final OptionalByte c = OptionalByte.of((byte)(1));
		
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
		assertTrue(OptionalByte.of((byte)(0)).isPresent());
		assertTrue(OptionalByte.of((byte)(1)).isPresent());
		
		assertFalse(OptionalByte.empty().isPresent());
	}
	
	@Test
	public void testOf() {
		final OptionalByte optionalByte = OptionalByte.of((byte)(0));
		
		assertTrue(optionalByte.isPresent());
	}
	
	@Test
	public void testOrElse() {
		assertEquals((byte)(0), OptionalByte.empty().orElse((byte)(0)));
		assertEquals((byte)(0), OptionalByte.of((byte)(0)).orElse((byte)(1)));
	}
	
	@Test
	public void testOrElseGet() {
		assertEquals((byte)(0), OptionalByte.of((byte)(0)).orElseGet(null));
		assertEquals((byte)(0), OptionalByte.of((byte)(0)).orElseGet(() -> (byte)(1)));
		assertEquals((byte)(0), OptionalByte.empty().orElseGet(() -> (byte)(0)));
		
		assertThrows(NullPointerException.class, () -> OptionalByte.empty().orElseGet(null));
	}
	
	@Test
	public void testOrElseThrow() {
		assertEquals((byte)(0), OptionalByte.of((byte)(0)).orElseThrow(null));
		assertEquals((byte)(0), OptionalByte.of((byte)(0)).orElseThrow(() -> null));
		assertEquals((byte)(0), OptionalByte.of((byte)(0)).orElseThrow(() -> new RuntimeException()));
		
		assertThrows(NullPointerException.class, () -> OptionalByte.empty().orElseThrow(null));
		assertThrows(NullPointerException.class, () -> OptionalByte.empty().orElseThrow(() -> null));
		assertThrows(RuntimeException.class, () -> OptionalByte.empty().orElseThrow(() -> new RuntimeException()));
	}
	
	@Test
	public void testToString() {
		assertEquals("OptionalByte.empty", OptionalByte.empty().toString());
		assertEquals("OptionalByte[1]", OptionalByte.of((byte)(1)).toString());
	}
}