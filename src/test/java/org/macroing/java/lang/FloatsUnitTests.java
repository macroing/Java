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
package org.macroing.java.lang;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
	public void testAddLessThan() {
		assertEquals(1.0F, Floats.addLessThan(0.0F, 0.1F, 1.0F));
		assertEquals(1.0F, Floats.addLessThan(1.0F, 0.0F, 1.0F));
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
	public void testErf() {
		assertEquals(+0.99532217F, Floats.erf(+2.00F));
		assertEquals(+0.84270070F, Floats.erf(+1.00F));
		assertEquals(+0.00000000F, Floats.erf(+0.00F));
		assertEquals(+0.27632612F, Floats.erf(+0.25F));
		assertEquals(+0.00000000F, Floats.erf(-0.00F));
		assertEquals(-0.27632612F, Floats.erf(-0.25F));
		assertEquals(-0.84270070F, Floats.erf(-1.00F));
		assertEquals(-0.99532217F, Floats.erf(-2.00F));
	}
	
	@Test
	public void testErfInv() {
		assertEquals(+3.12320570000000000F, Floats.erfInv(+2.00F));
		assertEquals(+3.12320570000000000F, Floats.erfInv(+1.00F));
		assertEquals(+0.00000000000000000F, Floats.erfInv(+0.00F));
		assertEquals(+0.22531207402846837F, Floats.erfInv(+0.25F));
		assertEquals(-0.00000000000000000F, Floats.erfInv(-0.00F));
		assertEquals(-0.22531207402846837F, Floats.erfInv(-0.25F));
		assertEquals(-3.12320570000000000F, Floats.erfInv(-1.00F));
		assertEquals(-3.12320570000000000F, Floats.erfInv(-2.00F));
	}
	
	@Test
	public void testExp() {
		assertEquals((float)(Math.exp(0.5F)), Floats.exp(0.5F));
	}
	
	@Test
	public void testFiniteOrDefault() {
		assertEquals(0.0F, Floats.finiteOrDefault(Float.NaN, 0.0F));
		assertEquals(0.0F, Floats.finiteOrDefault(Float.NEGATIVE_INFINITY, 0.0F));
		assertEquals(0.0F, Floats.finiteOrDefault(Float.POSITIVE_INFINITY, 0.0F));
		assertEquals(0.0F, Floats.finiteOrDefault(0.0F, 1.0F));
	}
	
	@Test
	public void testFloor() {
		assertEquals((float)(Math.floor(0.5F)), Floats.floor(0.5F));
	}
	
	@Test
	public void testFractionalPartFloat() {
		assertEquals(0.5F, Floats.fractionalPart(-1.5F));
		assertEquals(0.9F, Floats.fractionalPart(-1.1F));
		assertEquals(0.5F, Floats.fractionalPart(+1.5F));
		assertEquals(0.9F, Floats.fractionalPart(+1.9F));
	}
	
	@Test
	public void testFractionalPartFloatBoolean() {
		assertEquals(0.5F, Floats.fractionalPart(-1.5F, false));
		assertEquals(0.5F, Floats.fractionalPart(-1.5F, true));
		assertEquals(0.9F, Floats.fractionalPart(-1.1F, false));
		assertEquals(0.9F, Floats.fractionalPart(-1.9F, true));
		assertEquals(0.5F, Floats.fractionalPart(+1.5F, false));
		assertEquals(0.5F, Floats.fractionalPart(+1.5F, true));
		assertEquals(0.9F, Floats.fractionalPart(+1.9F, false));
	}
	
	@Test
	public void testGamma() {
		assertEquals(0.0000002980233F, Floats.gamma(5));
	}
	
	@Test
	public void testIsFinite() {
		assertFalse(Floats.isFinite(Float.NaN));
		assertFalse(Floats.isFinite(Float.NEGATIVE_INFINITY));
		assertFalse(Floats.isFinite(Float.POSITIVE_INFINITY));
		
		assertTrue(Floats.isFinite(0.0F));
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
	public void testLog() {
		assertEquals((float)(Math.log(0.5F)), Floats.log(0.5F));
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
	public void testMaxOrDefault() {
		assertEquals(2.0F, Floats.maxOrDefault(1.0F, 2.0F, 3.0F));
		assertEquals(2.0F, Floats.maxOrDefault(Float.NaN, 2.0F, 3.0F));
		assertEquals(1.0F, Floats.maxOrDefault(1.0F, Float.NaN, 3.0F));
		assertEquals(3.0F, Floats.maxOrDefault(Float.NaN, Float.NaN, 3.0F));
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
	public void testMinOrDefault() {
		assertEquals(1.0F, Floats.minOrDefault(1.0F, 2.0F, 3.0F));
		assertEquals(2.0F, Floats.minOrDefault(Float.NaN, 2.0F, 3.0F));
		assertEquals(1.0F, Floats.minOrDefault(1.0F, Float.NaN, 3.0F));
		assertEquals(3.0F, Floats.minOrDefault(Float.NaN, Float.NaN, 3.0F));
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
	public void testNormalize() {
		assertEquals(-1.0F, Floats.normalize(  0.0F, 100.0F, 200.0F));
		assertEquals(+0.0F, Floats.normalize(100.0F, 100.0F, 200.0F));
		assertEquals(+0.5F, Floats.normalize(150.0F, 100.0F, 200.0F));
		assertEquals(+1.0F, Floats.normalize(200.0F, 100.0F, 200.0F));
		assertEquals(+2.0F, Floats.normalize(300.0F, 100.0F, 200.0F));
	}
	
	@Test
	public void testPositiveModulo() {
		assertEquals(-0.0F, Floats.positiveModulo(-2.0F, -1.0F));
		assertEquals(-2.0F, Floats.positiveModulo(-2.0F, -3.0F));
		
		assertEquals(+0.0F, Floats.positiveModulo(-2.0F, +1.0F));
		
		assertEquals(+0.0F, Floats.positiveModulo(+2.0F, -1.0F));
		
		assertEquals(+0.0F, Floats.positiveModulo(+2.0F, +1.0F));
		assertEquals(+2.0F, Floats.positiveModulo(+2.0F, +3.0F));
	}
	
	@Test
	public void testPow() {
		assertEquals((float)(Math.pow(2.0F, 2.0F)), Floats.pow(2.0F, 2.0F));
	}
	
	@Test
	public void testPow2() {
		assertEquals(4.0F, Floats.pow2(2.0F));
	}
	
	@Test
	public void testPow5() {
		assertEquals(32.0F, Floats.pow5(2.0F));
	}
	
	@Test
	public void testPowR() {
		assertEquals( 1.0F, Floats.powR(2.0F, 0));
		assertEquals( 2.0F, Floats.powR(2.0F, 1));
		assertEquals( 4.0F, Floats.powR(2.0F, 2));
		assertEquals( 8.0F, Floats.powR(2.0F, 3));
		assertEquals(16.0F, Floats.powR(2.0F, 4));
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
	public void testSinh() {
		assertEquals((float)(Math.sinh(0.5F)), Floats.sinh(0.5F));
	}
	
	@Test
	public void testSmoothstep() {
		assertEquals(+0.00000F, Floats.smoothstep(  0.0F, 100.0F, 200.0F));
		assertEquals(+0.00000F, Floats.smoothstep(100.0F, 100.0F, 200.0F));
		assertEquals(+0.15625F, Floats.smoothstep(125.0F, 100.0F, 200.0F));
		assertEquals(+0.50000F, Floats.smoothstep(150.0F, 100.0F, 200.0F));
		assertEquals(+1.00000F, Floats.smoothstep(200.0F, 100.0F, 200.0F));
		assertEquals(+1.00000F, Floats.smoothstep(300.0F, 100.0F, 200.0F));
	}
	
	@Test
	public void testSolveQuadraticSystem() {
		assertArrayEquals(new float[] {-2.0F, -0.3333333432674408F}, Floats.solveQuadraticSystem(3.0F, +7.0F, 2.0F));
		assertArrayEquals(new float[] {+0.3333333432674408F, +2.0F}, Floats.solveQuadraticSystem(3.0F, -7.0F, 2.0F));
		assertArrayEquals(new float[] {-1.0F, -1.0F}, Floats.solveQuadraticSystem(1.0F, 2.0F, 1.0F));
		assertArrayEquals(new float[] {Float.NaN, Float.NaN}, Floats.solveQuadraticSystem(1.0F, 1.0F, 1.0F));
	}
	
	@Test
	public void testSqrt() {
		assertEquals((float)(Math.sqrt(0.5F)), Floats.sqrt(0.5F));
	}
	
	@Test
	public void testTan() {
		assertEquals((float)(Math.tan(0.5F)), Floats.tan(0.5F));
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