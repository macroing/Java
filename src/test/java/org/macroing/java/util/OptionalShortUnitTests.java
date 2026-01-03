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
public final class OptionalShortUnitTests {
	public OptionalShortUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testEmpty() {
		final OptionalShort optionalShort = OptionalShort.empty();
		
		assertFalse(optionalShort.isPresent());
	}
	
	@Test
	public void testEquals() {
		final OptionalShort a = OptionalShort.empty();
		final OptionalShort b = OptionalShort.empty();
		final OptionalShort c = OptionalShort.of((short)(0));
		final OptionalShort d = OptionalShort.of((short)(0));
		final OptionalShort e = OptionalShort.of((short)(1));
		final OptionalShort f = OptionalShort.of((short)(1));
		final OptionalShort g = null;
		
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
	public void testGetAsShort() {
		assertEquals((short)(0), OptionalShort.of((short)(0)).getAsShort());
		assertEquals((short)(1), OptionalShort.of((short)(1)).getAsShort());
		
		assertThrows(NoSuchElementException.class, () -> OptionalShort.empty().getAsShort());
	}
	
	@Test
	public void testHashCode() {
		final OptionalShort a = OptionalShort.empty();
		final OptionalShort b = OptionalShort.empty();
		final OptionalShort c = OptionalShort.of((short)(0));
		final OptionalShort d = OptionalShort.of((short)(0));
		final OptionalShort e = OptionalShort.of((short)(1));
		final OptionalShort f = OptionalShort.of((short)(1));
		
		assertEquals(a.hashCode(), b.hashCode());
		assertEquals(c.hashCode(), d.hashCode());
		assertEquals(e.hashCode(), f.hashCode());
	}
	
	@Test
	public void testIfPresent() {
		final OptionalShort a = OptionalShort.empty();
		final OptionalShort b = OptionalShort.of((short)(0));
		final OptionalShort c = OptionalShort.of((short)(1));
		
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
		assertTrue(OptionalShort.of((short)(0)).isPresent());
		assertTrue(OptionalShort.of((short)(1)).isPresent());
		
		assertFalse(OptionalShort.empty().isPresent());
	}
	
	@Test
	public void testOf() {
		final OptionalShort optionalShort = OptionalShort.of((short)(0));
		
		assertTrue(optionalShort.isPresent());
	}
	
	@Test
	public void testOrElse() {
		assertEquals((short)(0), OptionalShort.empty().orElse((short)(0)));
		assertEquals((short)(0), OptionalShort.of((short)(0)).orElse((short)(1)));
	}
	
	@Test
	public void testOrElseGet() {
		assertEquals((short)(0), OptionalShort.of((short)(0)).orElseGet(null));
		assertEquals((short)(0), OptionalShort.of((short)(0)).orElseGet(() -> (short)(1)));
		assertEquals((short)(0), OptionalShort.empty().orElseGet(() -> (short)(0)));
		
		assertThrows(NullPointerException.class, () -> OptionalShort.empty().orElseGet(null));
	}
	
	@Test
	public void testOrElseThrow() {
		assertEquals((short)(0), OptionalShort.of((short)(0)).orElseThrow(null));
		assertEquals((short)(0), OptionalShort.of((short)(0)).orElseThrow(() -> null));
		assertEquals((short)(0), OptionalShort.of((short)(0)).orElseThrow(() -> new RuntimeException()));
		
		assertThrows(NullPointerException.class, () -> OptionalShort.empty().orElseThrow(null));
		assertThrows(NullPointerException.class, () -> OptionalShort.empty().orElseThrow(() -> null));
		assertThrows(RuntimeException.class, () -> OptionalShort.empty().orElseThrow(() -> new RuntimeException()));
	}
	
	@Test
	public void testToString() {
		assertEquals("OptionalShort.empty", OptionalShort.empty().toString());
		assertEquals("OptionalShort[1]", OptionalShort.of((short)(1)).toString());
	}
}