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
package org.macroing.java.util.function;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

@SuppressWarnings("static-method")
public final class BytePredicateUnitTests {
	public BytePredicateUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testAnd() {
		final BytePredicate a = value -> value > 10;
		final BytePredicate b = value -> value < 20;
		final BytePredicate c = a.and(b);
		
		assertFalse(c.test((byte)(10)));
		assertFalse(c.test((byte)(20)));
		
		assertTrue(c.test((byte)(15)));
		
		assertThrows(NullPointerException.class, () -> a.and(null));
	}
	
	@Test
	public void testNegate() {
		final BytePredicate a = value -> value > 10;
		final BytePredicate b = a.negate();
		
		assertFalse(b.test((byte)(20)));
		
		assertTrue(b.test((byte)(10)));
	}
	
	@Test
	public void testOr() {
		final BytePredicate a = value -> value <= 10;
		final BytePredicate b = value -> value >= 20;
		final BytePredicate c = a.or(b);
		
		assertTrue(c.test((byte)(10)));
		assertTrue(c.test((byte)(20)));
		
		assertFalse(c.test((byte)(15)));
		
		assertThrows(NullPointerException.class, () -> a.or(null));
	}
}