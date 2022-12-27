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
package org.macroing.java.util.function;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

@SuppressWarnings("static-method")
public final class FloatPredicateUnitTests {
	public FloatPredicateUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testAnd() {
		final FloatPredicate a = value -> value > 10.0F;
		final FloatPredicate b = value -> value < 20.0F;
		final FloatPredicate c = a.and(b);
		
		assertFalse(c.test(10.0F));
		assertFalse(c.test(20.0F));
		
		assertTrue(c.test(15.0F));
		
		assertThrows(NullPointerException.class, () -> a.and(null));
	}
	
	@Test
	public void testNegate() {
		final FloatPredicate a = value -> value > 10.0F;
		final FloatPredicate b = a.negate();
		
		assertFalse(b.test(20.0F));
		
		assertTrue(b.test(10.0F));
	}
	
	@Test
	public void testOr() {
		final FloatPredicate a = value -> value <= 10.0F;
		final FloatPredicate b = value -> value >= 20.0F;
		final FloatPredicate c = a.or(b);
		
		assertTrue(c.test(10.0F));
		assertTrue(c.test(20.0F));
		
		assertFalse(c.test(15.0F));
		
		assertThrows(NullPointerException.class, () -> a.or(null));
	}
}