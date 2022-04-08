/**
 * Copyright 2021 - 2022 J&#246;rgen Lundgren
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
public final class OptionalBooleanUnitTests {
	public OptionalBooleanUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testEmpty() {
		final OptionalBoolean optionalBoolean = OptionalBoolean.empty();
		
		assertFalse(optionalBoolean.isPresent());
	}
	
	@Test
	public void testEquals() {
		final OptionalBoolean a = OptionalBoolean.empty();
		final OptionalBoolean b = OptionalBoolean.empty();
		final OptionalBoolean c = OptionalBoolean.of(false);
		final OptionalBoolean d = OptionalBoolean.of(false);
		final OptionalBoolean e = OptionalBoolean.of(true);
		final OptionalBoolean f = OptionalBoolean.of(true);
		final OptionalBoolean g = null;
		
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
	public void testGetAsBoolean() {
		assertFalse(OptionalBoolean.of(false).getAsBoolean());
		
		assertTrue(OptionalBoolean.of(true).getAsBoolean());
		
		assertThrows(NoSuchElementException.class, () -> OptionalBoolean.empty().getAsBoolean());
	}
	
	@Test
	public void testHashCode() {
		final OptionalBoolean a = OptionalBoolean.empty();
		final OptionalBoolean b = OptionalBoolean.empty();
		final OptionalBoolean c = OptionalBoolean.of(false);
		final OptionalBoolean d = OptionalBoolean.of(false);
		final OptionalBoolean e = OptionalBoolean.of(true);
		final OptionalBoolean f = OptionalBoolean.of(true);
		
		assertEquals(a.hashCode(), b.hashCode());
		assertEquals(c.hashCode(), d.hashCode());
		assertEquals(e.hashCode(), f.hashCode());
	}
	
	@Test
	public void testIfPresent() {
		final OptionalBoolean a = OptionalBoolean.empty();
		final OptionalBoolean b = OptionalBoolean.of(false);
		final OptionalBoolean c = OptionalBoolean.of(true);
		
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
		assertTrue(OptionalBoolean.of(false).isPresent());
		assertTrue(OptionalBoolean.of(true).isPresent());
		
		assertFalse(OptionalBoolean.empty().isPresent());
	}
	
	@Test
	public void testOf() {
		final OptionalBoolean optionalBoolean = OptionalBoolean.of(false);
		
		assertTrue(optionalBoolean.isPresent());
	}
	
	@Test
	public void testOrElse() {
		assertTrue(OptionalBoolean.empty().orElse(true));
		assertTrue(OptionalBoolean.of(true).orElse(false));
	}
	
	@Test
	public void testOrElseGet() {
		assertTrue(OptionalBoolean.of(true).orElseGet(null));
		assertTrue(OptionalBoolean.of(true).orElseGet(() -> false));
		assertTrue(OptionalBoolean.empty().orElseGet(() -> true));
		
		assertThrows(NullPointerException.class, () -> OptionalBoolean.empty().orElseGet(null));
	}
	
	@Test
	public void testOrElseThrow() {
		assertTrue(OptionalBoolean.of(true).orElseThrow(null));
		assertTrue(OptionalBoolean.of(true).orElseThrow(() -> null));
		assertTrue(OptionalBoolean.of(true).orElseThrow(() -> new RuntimeException()));
		
		assertThrows(NullPointerException.class, () -> OptionalBoolean.empty().orElseThrow(null));
		assertThrows(NullPointerException.class, () -> OptionalBoolean.empty().orElseThrow(() -> null));
		assertThrows(RuntimeException.class, () -> OptionalBoolean.empty().orElseThrow(() -> new RuntimeException()));
	}
	
	@Test
	public void testToString() {
		assertEquals("OptionalBoolean.empty", OptionalBoolean.empty().toString());
		assertEquals("OptionalBoolean[false]", OptionalBoolean.of(false).toString());
	}
}