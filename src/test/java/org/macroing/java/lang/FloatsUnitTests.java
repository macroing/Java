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
package org.macroing.java.lang;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

@SuppressWarnings("static-method")
public final class FloatsUnitTests {
	public FloatsUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testAbs() {
		assertEquals(1.0F, Floats.abs(+1.0F));
		assertEquals(1.0F, Floats.abs(-1.0F));
	}
	
	@Test
	public void testAcos() {
		assertEquals((float)(Math.acos(0.5F)), Floats.acos(0.5F));
	}
	
	@Test
	public void testAsin() {
		assertEquals((float)(Math.asin(0.5F)), Floats.asin(0.5F));
	}
	
	@Test
	public void testAsinpi() {
		assertEquals((float)(Math.asin(0.5F)) / (float)(Math.PI), Floats.asinpi(0.5F));
	}
	
	@Test
	public void testAtan() {
		assertEquals((float)(Math.atan(0.5F)), Floats.atan(0.5F));
	}
	
	@Test
	public void testAtan2() {
		assertEquals((float)(Math.atan2(0.5F, 0.5F)), Floats.atan2(0.5F, 0.5F));
	}
	
	@Test
	public void testAtan2pi2() {
		assertEquals((float)(Math.atan2(0.5F, 0.5F)) / ((float)(Math.PI) * 2.0F), Floats.atan2pi2(0.5F, 0.5F));
	}
	
	@Test
	public void testBlerp() {
		assertEquals(0.5F, Floats.blerp(0.0F, 1.0F, 0.0F, 1.0F, 0.5F, 0.5F));
		assertEquals(1.5F, Floats.blerp(0.0F, 1.0F, 2.0F, 3.0F, 0.5F, 0.5F));
		assertEquals(0.5F, Floats.blerp(0.0F, 1.0F, 2.0F, 3.0F, 0.5F, 0.0F));
		assertEquals(2.5F, Floats.blerp(0.0F, 1.0F, 2.0F, 3.0F, 0.5F, 1.0F));
	}
	
	@Test
	public void testCeil() {
		assertEquals((float)(Math.ceil(0.5F)), Floats.ceil(0.5F));
	}
	
	@Test
	public void testCos() {
		assertEquals((float)(Math.cos(0.5F)), Floats.cos(0.5F));
	}
	
	@Test
	public void testEqualsFloatFloat() {
		assertTrue(Floats.equals(1.0F, 1.0F));
		
		assertFalse(Floats.equals(1.0F, 2.0F));
	}
	
	@Test
	public void testEqualsFloatFloatFloat() {
		assertTrue(Floats.equals(1.0F, 1.0F, 1.0F));
		
		assertFalse(Floats.equals(1.0F, 1.0F, 2.0F));
		assertFalse(Floats.equals(1.0F, 2.0F, 1.0F));
		assertFalse(Floats.equals(2.0F, 1.0F, 1.0F));
	}
	
	@Test
	public void testExp() {
		assertEquals((float)(Math.exp(0.5F)), Floats.exp(0.5F));
	}
	
	@Test
	public void testFloor() {
		assertEquals((float)(Math.floor(0.5F)), Floats.floor(0.5F));
	}
	
	@Test
	public void testIsInfinite() {
		assertTrue(Floats.isInfinite(Float.NEGATIVE_INFINITY));
		assertTrue(Floats.isInfinite(Float.POSITIVE_INFINITY));
		
		assertFalse(Floats.isInfinite(Float.NaN));
		assertFalse(Floats.isInfinite(0.0F));
	}
	
	@Test
	public void testIsNaN() {
		assertTrue(Floats.isNaN(Float.NaN));
		
		assertFalse(Floats.isNaN(Float.NEGATIVE_INFINITY));
		assertFalse(Floats.isNaN(Float.POSITIVE_INFINITY));
		assertFalse(Floats.isNaN(0.0F));
	}
	
	@Test
	public void testIsZero() {
		assertTrue(Floats.isZero(+0.0F));
		assertTrue(Floats.isZero(-0.0F));
		
		assertFalse(Floats.isZero(Float.NaN));
		assertFalse(Floats.isZero(1.0F));
	}
	
	@Test
	public void testLerp() {
//		Interpolation:
		assertEquals(1.0F, Floats.lerp(1.0F, 2.0F, +0.0F));
		assertEquals(1.5F, Floats.lerp(1.0F, 2.0F, +0.5F));
		assertEquals(2.0F, Floats.lerp(1.0F, 2.0F, +1.0F));
		
//		Extrapolation:
		assertEquals(0.0F, Floats.lerp(1.0F, 2.0F, -1.0F));
		assertEquals(3.0F, Floats.lerp(1.0F, 2.0F, +2.0F));
	}
	
	@Test
	public void testMaxFloatFloat() {
		assertEquals(2.0F, Floats.max(1.0F, 2.0F));
	}
	
	@Test
	public void testMaxFloatFloatFloat() {
		assertEquals(3.0F, Floats.max(1.0F, 2.0F, 3.0F));
	}
	
	@Test
	public void testMaxFloatFloatFloatFloat() {
		assertEquals(4.0F, Floats.max(1.0F, 2.0F, 3.0F, 4.0F));
	}
	
	@Test
	public void testMinFloatFloat() {
		assertEquals(1.0F, Floats.min(1.0F, 2.0F));
	}
	
	@Test
	public void testMinFloatFloatFloat() {
		assertEquals(1.0F, Floats.min(1.0F, 2.0F, 3.0F));
	}
	
	@Test
	public void testMinFloatFloatFloatFloat() {
		assertEquals(1.0F, Floats.min(1.0F, 2.0F, 3.0F, 4.0F));
	}
	
	@Test
	public void testNextDown() {
		assertEquals(Math.nextDown(0.5F), Floats.nextDown(0.5F));
	}
	
	@Test
	public void testNextUp() {
		assertEquals(Math.nextUp(0.5F), Floats.nextUp(0.5F));
	}
	
	@Test
	public void testPow() {
		assertEquals((float)(Math.pow(2.0F, 2.0F)), Floats.pow(2.0F, 2.0F));
	}
	
	@Test
	public void testRint() {
		assertEquals(0.0F, Floats.rint(0.00F));
		assertEquals(0.0F, Floats.rint(0.25F));
		assertEquals(0.0F, Floats.rint(0.50F));
		assertEquals(1.0F, Floats.rint(0.75F));
		assertEquals(1.0F, Floats.rint(1.00F));
	}
	
	@Test
	public void testSaturateFloat() {
		assertEquals(0.0F, Floats.saturate(-1.0F));
		assertEquals(0.5F, Floats.saturate(+0.5F));
		assertEquals(1.0F, Floats.saturate(+2.0F));
	}
	
	@Test
	public void testSaturateFloatFloatFloat() {
		assertEquals(2.0F, Floats.saturate(1.0F, 2.0F, 3.0F));
		assertEquals(2.0F, Floats.saturate(1.0F, 3.0F, 2.0F));
		
		assertEquals(2.5F, Floats.saturate(2.5F, 2.0F, 3.0F));
		assertEquals(2.5F, Floats.saturate(2.5F, 3.0F, 2.0F));
		
		assertEquals(3.0F, Floats.saturate(4.0F, 2.0F, 3.0F));
		assertEquals(3.0F, Floats.saturate(4.0F, 3.0F, 2.0F));
	}
	
	@Test
	public void testSin() {
		assertEquals((float)(Math.sin(0.5F)), Floats.sin(0.5F));
	}
	
	@Test
	public void testSqrt() {
		assertEquals((float)(Math.sqrt(0.5F)), Floats.sqrt(0.5F));
	}
	
	@Test
	public void testToDegrees() {
		assertEquals((float)(Math.toDegrees(0.5F)), Floats.toDegrees(0.5F));
	}
	
	@Test
	public void testToRadians() {
		assertEquals((float)(Math.toRadians(0.5F)), Floats.toRadians(0.5F));
	}
}