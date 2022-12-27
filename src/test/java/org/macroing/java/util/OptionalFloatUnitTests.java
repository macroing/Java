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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

@SuppressWarnings("static-method")
public final class OptionalFloatUnitTests {
	public OptionalFloatUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testEmpty() {
		final OptionalFloat optionalFloat = OptionalFloat.empty();
		
		assertFalse(optionalFloat.isPresent());
	}
	
	@Test
	public void testEquals() {
		final OptionalFloat a = OptionalFloat.empty();
		final OptionalFloat b = OptionalFloat.empty();
		final OptionalFloat c = OptionalFloat.of(0.0F);
		final OptionalFloat d = OptionalFloat.of(0.0F);
		final OptionalFloat e = OptionalFloat.of(1.0F);
		final OptionalFloat f = OptionalFloat.of(1.0F);
		final OptionalFloat g = null;
		
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
	public void testGetAsFloat() {
		assertEquals(0.0F, OptionalFloat.of(0.0F).getAsFloat());
		assertEquals(1.0F, OptionalFloat.of(1.0F).getAsFloat());
		
		assertThrows(NoSuchElementException.class, () -> OptionalFloat.empty().getAsFloat());
	}
	
	@Test
	public void testHashCode() {
		final OptionalFloat a = OptionalFloat.empty();
		final OptionalFloat b = OptionalFloat.empty();
		final OptionalFloat c = OptionalFloat.of(0.0F);
		final OptionalFloat d = OptionalFloat.of(0.0F);
		final OptionalFloat e = OptionalFloat.of(1.0F);
		final OptionalFloat f = OptionalFloat.of(1.0F);
		
		assertEquals(a.hashCode(), b.hashCode());
		assertEquals(c.hashCode(), d.hashCode());
		assertEquals(e.hashCode(), f.hashCode());
	}
	
	@Test
	public void testIfPresent() {
		final OptionalFloat a = OptionalFloat.empty();
		final OptionalFloat b = OptionalFloat.of(0.0F);
		final OptionalFloat c = OptionalFloat.of(1.0F);
		
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
		assertTrue(OptionalFloat.of(0.0F).isPresent());
		assertTrue(OptionalFloat.of(1.0F).isPresent());
		
		assertFalse(OptionalFloat.empty().isPresent());
	}
	
	@Test
	public void testOf() {
		final OptionalFloat optionalFloat = OptionalFloat.of(0.0F);
		
		assertTrue(optionalFloat.isPresent());
	}
	
	@Test
	public void testOrElse() {
		assertEquals(0.0F, OptionalFloat.empty().orElse(0.0F));
		assertEquals(0.0F, OptionalFloat.of(0.0F).orElse(1.0F));
	}
	
	@Test
	public void testOrElseGet() {
		assertEquals(0.0F, OptionalFloat.of(0.0F).orElseGet(null));
		assertEquals(0.0F, OptionalFloat.of(0.0F).orElseGet(() -> 1.0F));
		assertEquals(0.0F, OptionalFloat.empty().orElseGet(() -> 0.0F));
		
		assertThrows(NullPointerException.class, () -> OptionalFloat.empty().orElseGet(null));
	}
	
	@Test
	public void testOrElseThrow() {
		assertEquals(0.0F, OptionalFloat.of(0.0F).orElseThrow(null));
		assertEquals(0.0F, OptionalFloat.of(0.0F).orElseThrow(() -> null));
		assertEquals(0.0F, OptionalFloat.of(0.0F).orElseThrow(() -> new RuntimeException()));
		
		assertThrows(NullPointerException.class, () -> OptionalFloat.empty().orElseThrow(null));
		assertThrows(NullPointerException.class, () -> OptionalFloat.empty().orElseThrow(() -> null));
		assertThrows(RuntimeException.class, () -> OptionalFloat.empty().orElseThrow(() -> new RuntimeException()));
	}
	
	@Test
	public void testToString() {
		assertEquals("OptionalFloat.empty", OptionalFloat.empty().toString());
		assertEquals("OptionalFloat[1.0]", OptionalFloat.of(1.0F).toString());
	}
}