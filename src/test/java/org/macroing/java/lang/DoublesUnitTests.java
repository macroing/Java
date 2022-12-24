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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

@SuppressWarnings("static-method")
public final class DoublesUnitTests {
	public DoublesUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testAbs() {
		assertEquals(1.0D, Doubles.abs(+1.0D));
		assertEquals(1.0D, Doubles.abs(-1.0D));
	}
	
	@Test
	public void testAcos() {
		assertEquals(Math.acos(0.5D), Doubles.acos(0.5D));
	}
	
	@Test
	public void testAddLessThan() {
		assertEquals(1.0D, Doubles.addLessThan(0.0D, 0.1D, 1.0D));
		assertEquals(1.0D, Doubles.addLessThan(1.0D, 0.0D, 1.0D));
	}
	
	@Test
	public void testAsin() {
		assertEquals(Math.asin(0.5D), Doubles.asin(0.5D));
	}
	
	@Test
	public void testAsinpi() {
		assertEquals(Math.asin(0.5D) / Math.PI, Doubles.asinpi(0.5D));
	}
	
	@Test
	public void testAtan() {
		assertEquals(Math.atan(0.5D), Doubles.atan(0.5D));
	}
	
	@Test
	public void testAtan2() {
		assertEquals(Math.atan2(0.5D, 0.5D), Doubles.atan2(0.5D, 0.5D));
	}
	
	@Test
	public void testAtan2pi2() {
		assertEquals(Math.atan2(0.5D, 0.5D) / (Math.PI * 2.0D), Doubles.atan2pi2(0.5D, 0.5D));
	}
	
	@Test
	public void testBlerp() {
		assertEquals(0.5D, Doubles.blerp(0.0D, 1.0D, 0.0D, 1.0D, 0.5D, 0.5D));
		assertEquals(1.5D, Doubles.blerp(0.0D, 1.0D, 2.0D, 3.0D, 0.5D, 0.5D));
		assertEquals(0.5D, Doubles.blerp(0.0D, 1.0D, 2.0D, 3.0D, 0.5D, 0.0D));
		assertEquals(2.5D, Doubles.blerp(0.0D, 1.0D, 2.0D, 3.0D, 0.5D, 1.0D));
	}
	
	@Test
	public void testCeil() {
		assertEquals(Math.ceil(0.5D), Doubles.ceil(0.5D));
	}
	
	@Test
	public void testCos() {
		assertEquals(Math.cos(0.5D), Doubles.cos(0.5D));
	}
	
	@Test
	public void testEqualsDoubleDouble() {
		assertTrue(Doubles.equals(1.0D, 1.0D));
		
		assertFalse(Doubles.equals(1.0D, 2.0D));
	}
	
	@Test
	public void testEqualsDoubleDoubleDouble() {
		assertTrue(Doubles.equals(1.0D, 1.0D, 1.0D));
		
		assertFalse(Doubles.equals(1.0D, 1.0D, 2.0D));
		assertFalse(Doubles.equals(1.0D, 2.0D, 1.0D));
		assertFalse(Doubles.equals(2.0D, 1.0D, 1.0D));
	}
	
	@Test
	public void testErf() {
		assertEquals(+0.9953221395812188000D, Doubles.erf(+2.00D));
		assertEquals(+0.8427006897475899000D, Doubles.erf(+1.00D));
		assertEquals(+9.999999717180685E-10D, Doubles.erf(+0.00D));
		assertEquals(+0.2763262613535272000D, Doubles.erf(+0.25D));
		assertEquals(+9.999999717180685E-10D, Doubles.erf(-0.00D));
		assertEquals(-0.2763262613535272000D, Doubles.erf(-0.25D));
		assertEquals(-0.8427006897475899000D, Doubles.erf(-1.00D));
		assertEquals(-0.9953221395812188000D, Doubles.erf(-2.00D));
	}
	
	@Test
	public void testErfInv() {
		assertEquals(+3.12341301695557450D, Doubles.erfInv(+2.00D));
		assertEquals(+3.12341301695557450D, Doubles.erfInv(+1.00D));
		assertEquals(+0.00000000000000000D, Doubles.erfInv(+0.00D));
		assertEquals(+0.08885598780483887D, Doubles.erfInv(+0.10D));
		assertEquals(+0.22531207402846837D, Doubles.erfInv(+0.25D));
		assertEquals(+1.16308710137503770D, Doubles.erfInv(+0.90D));
		assertEquals(-0.00000000000000000D, Doubles.erfInv(-0.00D));
		assertEquals(-0.08885598780483887D, Doubles.erfInv(-0.10D));
		assertEquals(-0.22531207402846837D, Doubles.erfInv(-0.25D));
		assertEquals(-1.16308710137503770D, Doubles.erfInv(-0.90D));
		assertEquals(-3.12341301695557450D, Doubles.erfInv(-1.00D));
		assertEquals(-3.12341301695557450D, Doubles.erfInv(-2.00D));
	}
	
	@Test
	public void testExp() {
		assertEquals(Math.exp(0.5D), Doubles.exp(0.5D));
	}
	
	@Test
	public void testFiniteOrDefault() {
		assertEquals(0.0D, Doubles.finiteOrDefault(Double.NaN, 0.0D));
		assertEquals(0.0D, Doubles.finiteOrDefault(Double.NEGATIVE_INFINITY, 0.0D));
		assertEquals(0.0D, Doubles.finiteOrDefault(Double.POSITIVE_INFINITY, 0.0D));
		assertEquals(0.0D, Doubles.finiteOrDefault(0.0D, 1.0D));
	}
	
	@Test
	public void testFloor() {
		assertEquals(Math.floor(0.5D), Doubles.floor(0.5D));
	}
	
	@Test
	public void testFractionalPartDouble() {
		assertEquals(0.5D, Doubles.fractionalPart(-1.5D));
		assertEquals(0.8D, Doubles.fractionalPart(-1.2D));
		assertEquals(0.5D, Doubles.fractionalPart(+1.5D));
		assertEquals(0.8D, Doubles.fractionalPart(+1.8D));
	}
	
	@Test
	public void testFractionalPartDoubleBoolean() {
		assertEquals(0.5D, Doubles.fractionalPart(-1.5D, false));
		assertEquals(0.5D, Doubles.fractionalPart(-1.5D, true));
		assertEquals(0.8D, Doubles.fractionalPart(-1.2D, false));
		assertEquals(0.8D, Doubles.fractionalPart(-1.8D, true));
		assertEquals(0.5D, Doubles.fractionalPart(+1.5D, false));
		assertEquals(0.5D, Doubles.fractionalPart(+1.5D, true));
		assertEquals(0.8D, Doubles.fractionalPart(+1.8D, false));
	}
	
	@Test
	public void testGamma() {
		assertEquals(0.0000000000000005551115123125786D, Doubles.gamma(5));
	}
	
	@Test
	public void testIsFinite() {
		assertFalse(Doubles.isFinite(Double.NaN));
		assertFalse(Doubles.isFinite(Double.NEGATIVE_INFINITY));
		assertFalse(Doubles.isFinite(Double.POSITIVE_INFINITY));
		
		assertTrue(Doubles.isFinite(0.0D));
	}
	
	@Test
	public void testIsInfinite() {
		assertTrue(Doubles.isInfinite(Double.NEGATIVE_INFINITY));
		assertTrue(Doubles.isInfinite(Double.POSITIVE_INFINITY));
		
		assertFalse(Doubles.isInfinite(Double.NaN));
		assertFalse(Doubles.isInfinite(0.0D));
	}
	
	@Test
	public void testIsNaN() {
		assertTrue(Doubles.isNaN(Double.NaN));
		
		assertFalse(Doubles.isNaN(Double.NEGATIVE_INFINITY));
		assertFalse(Doubles.isNaN(Double.POSITIVE_INFINITY));
		assertFalse(Doubles.isNaN(0.0D));
	}
	
	@Test
	public void testIsZero() {
		assertTrue(Doubles.isZero(+0.0D));
		assertTrue(Doubles.isZero(-0.0D));
		
		assertFalse(Doubles.isZero(Double.NaN));
		assertFalse(Doubles.isZero(1.0D));
	}
	
	@Test
	public void testLerp() {
//		Interpolation:
		assertEquals(1.0D, Doubles.lerp(1.0D, 2.0D, +0.0D));
		assertEquals(1.5D, Doubles.lerp(1.0D, 2.0D, +0.5D));
		assertEquals(2.0D, Doubles.lerp(1.0D, 2.0D, +1.0D));
		
//		Extrapolation:
		assertEquals(0.0D, Doubles.lerp(1.0D, 2.0D, -1.0D));
		assertEquals(3.0D, Doubles.lerp(1.0D, 2.0D, +2.0D));
	}
	
	@Test
	public void testLog() {
		assertEquals(Math.log(0.5D), Doubles.log(0.5D));
	}
	
	@Test
	public void testMaxDoubleDouble() {
		assertEquals(2.0D, Doubles.max(1.0D, 2.0D));
	}
	
	@Test
	public void testMaxDoubleDoubleDouble() {
		assertEquals(3.0D, Doubles.max(1.0D, 2.0D, 3.0D));
	}
	
	@Test
	public void testMaxDoubleDoubleDoubleDouble() {
		assertEquals(4.0D, Doubles.max(1.0D, 2.0D, 3.0D, 4.0D));
	}
	
	@Test
	public void testMaxOrDefault() {
		assertEquals(2.0D, Doubles.maxOrDefault(1.0D, 2.0D, 3.0D));
		assertEquals(2.0D, Doubles.maxOrDefault(Double.NaN, 2.0D, 3.0D));
		assertEquals(1.0D, Doubles.maxOrDefault(1.0D, Double.NaN, 3.0D));
		assertEquals(3.0D, Doubles.maxOrDefault(Double.NaN, Double.NaN, 3.0D));
	}
	
	@Test
	public void testMinDoubleDouble() {
		assertEquals(1.0D, Doubles.min(1.0D, 2.0D));
	}
	
	@Test
	public void testMinDoubleDoubleDouble() {
		assertEquals(1.0D, Doubles.min(1.0D, 2.0D, 3.0D));
	}
	
	@Test
	public void testMinDoubleDoubleDoubleDouble() {
		assertEquals(1.0D, Doubles.min(1.0D, 2.0D, 3.0D, 4.0D));
	}
	
	@Test
	public void testMinOrDefault() {
		assertEquals(1.0D, Doubles.minOrDefault(1.0D, 2.0D, 3.0D));
		assertEquals(2.0D, Doubles.minOrDefault(Double.NaN, 2.0D, 3.0D));
		assertEquals(1.0D, Doubles.minOrDefault(1.0D, Double.NaN, 3.0D));
		assertEquals(3.0D, Doubles.minOrDefault(Double.NaN, Double.NaN, 3.0D));
	}
	
	@Test
	public void testNextDown() {
		assertEquals(Math.nextDown(0.5D), Doubles.nextDown(0.5D));
	}
	
	@Test
	public void testNextUp() {
		assertEquals(Math.nextUp(0.5D), Doubles.nextUp(0.5D));
	}
	
	@Test
	public void testNormalize() {
		assertEquals(-1.0D, Doubles.normalize(  0.0D, 100.0D, 200.0D));
		assertEquals(+0.0D, Doubles.normalize(100.0D, 100.0D, 200.0D));
		assertEquals(+0.5D, Doubles.normalize(150.0D, 100.0D, 200.0D));
		assertEquals(+1.0D, Doubles.normalize(200.0D, 100.0D, 200.0D));
		assertEquals(+2.0D, Doubles.normalize(300.0D, 100.0D, 200.0D));
	}
	
	@Test
	public void testPositiveModulo() {
		assertEquals(-0.0D, Doubles.positiveModulo(-2.0D, -1.0D));
		assertEquals(-2.0D, Doubles.positiveModulo(-2.0D, -3.0D));
		
		assertEquals(+0.0D, Doubles.positiveModulo(-2.0D, +1.0D));
		
		assertEquals(+0.0D, Doubles.positiveModulo(+2.0D, -1.0D));
		
		assertEquals(+0.0D, Doubles.positiveModulo(+2.0D, +1.0D));
		assertEquals(+2.0D, Doubles.positiveModulo(+2.0D, +3.0D));
	}
	
	@Test
	public void testPow() {
		assertEquals(Math.pow(2.0D, 2.0D), Doubles.pow(2.0D, 2.0D));
	}
	
	@Test
	public void testPow2() {
		assertEquals(4.0D, Doubles.pow2(2.0D));
	}
	
	@Test
	public void testPow5() {
		assertEquals(32.0D, Doubles.pow5(2.0D));
	}
	
	@Test
	public void testPowR() {
		assertEquals( 1.0D, Doubles.powR(2.0D, 0));
		assertEquals( 2.0D, Doubles.powR(2.0D, 1));
		assertEquals( 4.0D, Doubles.powR(2.0D, 2));
		assertEquals( 8.0D, Doubles.powR(2.0D, 3));
		assertEquals(16.0D, Doubles.powR(2.0D, 4));
	}
	
	@Test
	public void testRint() {
		assertEquals(0.0D, Doubles.rint(0.00D));
		assertEquals(0.0D, Doubles.rint(0.25D));
		assertEquals(0.0D, Doubles.rint(0.50D));
		assertEquals(1.0D, Doubles.rint(0.75D));
		assertEquals(1.0D, Doubles.rint(1.00D));
	}
	
	@Test
	public void testSaturateDouble() {
		assertEquals(0.0D, Doubles.saturate(-1.0D));
		assertEquals(0.5D, Doubles.saturate(+0.5D));
		assertEquals(1.0D, Doubles.saturate(+2.0D));
	}
	
	@Test
	public void testSaturateDoubleDoubleDouble() {
		assertEquals(2.0D, Doubles.saturate(1.0D, 2.0D, 3.0D));
		assertEquals(2.0D, Doubles.saturate(1.0D, 3.0D, 2.0D));
		
		assertEquals(2.5D, Doubles.saturate(2.5D, 2.0D, 3.0D));
		assertEquals(2.5D, Doubles.saturate(2.5D, 3.0D, 2.0D));
		
		assertEquals(3.0D, Doubles.saturate(4.0D, 2.0D, 3.0D));
		assertEquals(3.0D, Doubles.saturate(4.0D, 3.0D, 2.0D));
	}
	
	@Test
	public void testSin() {
		assertEquals(Math.sin(0.5D), Doubles.sin(0.5D));
	}
	
	@Test
	public void testSinh() {
		assertEquals(Math.sinh(0.5D), Doubles.sinh(0.5D));
	}
	
	@Test
	public void testSmoothstep() {
		assertEquals(+0.00000D, Doubles.smoothstep(  0.0D, 100.0D, 200.0D));
		assertEquals(+0.00000D, Doubles.smoothstep(100.0D, 100.0D, 200.0D));
		assertEquals(+0.15625D, Doubles.smoothstep(125.0D, 100.0D, 200.0D));
		assertEquals(+0.50000D, Doubles.smoothstep(150.0D, 100.0D, 200.0D));
		assertEquals(+1.00000D, Doubles.smoothstep(200.0D, 100.0D, 200.0D));
		assertEquals(+1.00000D, Doubles.smoothstep(300.0D, 100.0D, 200.0D));
	}
	
	@Test
	public void testSolveQuadraticSystem() {
		assertArrayEquals(new double[] {-2.0D, -0.3333333333333333D}, Doubles.solveQuadraticSystem(3.0D, +7.0D, 2.0D));
		assertArrayEquals(new double[] {+0.3333333333333333D, +2.0D}, Doubles.solveQuadraticSystem(3.0D, -7.0D, 2.0D));
		assertArrayEquals(new double[] {-1.0D, -1.0D}, Doubles.solveQuadraticSystem(1.0D, 2.0D, 1.0D));
		assertArrayEquals(new double[] {Double.NaN, Double.NaN}, Doubles.solveQuadraticSystem(1.0D, 1.0D, 1.0D));
	}
	
	@Test
	public void testSqrt() {
		assertEquals(Math.sqrt(0.5D), Doubles.sqrt(0.5D));
	}
	
	@Test
	public void testTan() {
		assertEquals(Math.tan(0.5D), Doubles.tan(0.5D));
	}
	
	@Test
	public void testToDegrees() {
		assertEquals(Math.toDegrees(0.5D), Doubles.toDegrees(0.5D));
	}
	
	@Test
	public void testToRadians() {
		assertEquals(Math.toRadians(0.5D), Doubles.toRadians(0.5D));
	}
}