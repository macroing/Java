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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.IllegalFormatException;

import org.junit.jupiter.api.Test;

@SuppressWarnings("static-method")
public final class IntsUnitTests {
	public IntsUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testAbs() {
		assertEquals(1, Ints.abs(+1));
		assertEquals(1, Ints.abs(-1));
	}
	
	@Test
	public void testCanMultiplyExact() {
		assertTrue(Ints.canMultiplyExact(1, 2));
		
		assertFalse(Ints.canMultiplyExact(Integer.MAX_VALUE, Integer.MAX_VALUE));
	}
	
	@Test
	public void testFloorMod() {
		assertEquals(+1, Ints.floorMod(+4, +3));
		assertEquals(-2, Ints.floorMod(+4, -3));
		assertEquals(+2, Ints.floorMod(-4, +3));
		assertEquals(-1, Ints.floorMod(-4, -3));
	}
	
	@Test
	public void testLerpIntIntDouble() {
//		Interpolation:
		assertEquals(100, Ints.lerp(100, 200, +0.0D));
		assertEquals(150, Ints.lerp(100, 200, +0.5D));
		assertEquals(200, Ints.lerp(100, 200, +1.0D));
		
//		Extrapolation:
		assertEquals(  0, Ints.lerp(100, 200, -1.0D));
		assertEquals(300, Ints.lerp(100, 200, +2.0D));
	}
	
	@Test
	public void testLerpIntIntFloat() {
//		Interpolation:
		assertEquals(100, Ints.lerp(100, 200, +0.0F));
		assertEquals(150, Ints.lerp(100, 200, +0.5F));
		assertEquals(200, Ints.lerp(100, 200, +1.0F));
		
//		Extrapolation:
		assertEquals(  0, Ints.lerp(100, 200, -1.0F));
		assertEquals(300, Ints.lerp(100, 200, +2.0F));
	}
	
	@Test
	public void testMaxIntInt() {
		assertEquals(2, Ints.max(1, 2));
	}
	
	@Test
	public void testMaxIntIntInt() {
		assertEquals(3, Ints.max(1, 2, 3));
	}
	
	@Test
	public void testMaxIntIntIntInt() {
		assertEquals(4, Ints.max(1, 2, 3, 4));
	}
	
	@Test
	public void testMinIntInt() {
		assertEquals(1, Ints.min(1, 2));
	}
	
	@Test
	public void testMinIntIntInt() {
		assertEquals(1, Ints.min(1, 2, 3));
	}
	
	@Test
	public void testMinIntIntIntInt() {
		assertEquals(1, Ints.min(1, 2, 3, 4));
	}
	
	@Test
	public void testRequireExact() {
		assertThrows(NullPointerException.class, () -> Ints.requireExact(1, 1, null));
		
		assertThrows(IllegalArgumentException.class, () -> Ints.requireExact(1, 2, "value"));
		
		assertEquals(1, Ints.requireExact(1, 1, "value"));
	}
	
	@Test
	public void testRequireRangeFormat() {
		assertThrows(NullPointerException.class, () -> Ints.requireRangeFormat(0, 0, 0, null));
		assertThrows(NullPointerException.class, () -> Ints.requireRangeFormat(0, 0, 0, "", (Object[])(null)));
		
		assertThrows(IllegalFormatException.class, () -> Ints.requireRangeFormat(0, 1, 2, "%s"));
		
		assertThrows(IllegalArgumentException.class, () -> Ints.requireRangeFormat(0, 1, 2, "%s", "value"));
		assertThrows(IllegalArgumentException.class, () -> Ints.requireRangeFormat(0, 2, 1, "%s", "value"));
		assertThrows(IllegalArgumentException.class, () -> Ints.requireRangeFormat(3, 1, 2, "%s", "value"));
		assertThrows(IllegalArgumentException.class, () -> Ints.requireRangeFormat(3, 2, 1, "%s", "value"));
		
		assertEquals(0, Ints.requireRangeFormat(0, 0, 1, "%s", "value"));
	}
	
	@Test
	public void testRequireRangeIntIntIntString() {
		assertThrows(NullPointerException.class, () -> Ints.requireRange(0, 0, 0, null));
		
		assertThrows(IllegalArgumentException.class, () -> Ints.requireRange(0, 1, 2, "value"));
		assertThrows(IllegalArgumentException.class, () -> Ints.requireRange(0, 2, 1, "value"));
		assertThrows(IllegalArgumentException.class, () -> Ints.requireRange(3, 1, 2, "value"));
		assertThrows(IllegalArgumentException.class, () -> Ints.requireRange(3, 2, 1, "value"));
		
		assertEquals(0, Ints.requireRange(0, 0, 1, "value"));
	}
	
	@Test
	public void testRequireRangeMultiplyExact() {
		assertThrows(NullPointerException.class, () -> Ints.requireRangeMultiplyExact(0, 0, 0, 0, "a", null));
		assertThrows(NullPointerException.class, () -> Ints.requireRangeMultiplyExact(0, 0, 0, 0, null, "b"));
		
		assertThrows(IllegalArgumentException.class, () -> Ints.requireRangeMultiplyExact(0, 1, 1, 2, "a", "b"));
		assertThrows(IllegalArgumentException.class, () -> Ints.requireRangeMultiplyExact(0, 1, 2, 1, "a", "b"));
		assertThrows(IllegalArgumentException.class, () -> Ints.requireRangeMultiplyExact(3, 1, 1, 2, "a", "b"));
		assertThrows(IllegalArgumentException.class, () -> Ints.requireRangeMultiplyExact(3, 1, 2, 1, "a", "b"));
		assertThrows(IllegalArgumentException.class, () -> Ints.requireRangeMultiplyExact(Integer.MAX_VALUE, Integer.MAX_VALUE, 2, 1, "a", "b"));
		
		assertEquals(0, Ints.requireRangeMultiplyExact(0, 1, 0, 1, "a", "b"));
	}
	
	@Test
	public void testReverseBits() {
		final int a = 1234;
		final int b = Ints.reverseBits(a);
		final int c = Ints.reverseBits(b);
		
		final String stringA = Integer.toBinaryString(a);
		final String stringB = Integer.toBinaryString(b);
		final String stringC = Integer.toBinaryString(c);
		
		assertEquals(a, c);
		
		assertEquals("10011010010", stringA);
		assertEquals("1001011001000000000000000000000", stringB);
		assertEquals("10011010010", stringC);
	}
	
	@Test
	public void testSaturateAndScaleToIntDouble() {
		assertEquals(  0, Ints.saturateAndScaleToInt(-1.0D));
		assertEquals(  0, Ints.saturateAndScaleToInt(+0.0D));
		assertEquals(128, Ints.saturateAndScaleToInt(+0.5D));
		assertEquals(255, Ints.saturateAndScaleToInt(+1.0D));
		assertEquals(255, Ints.saturateAndScaleToInt(+2.0D));
	}
	
	@Test
	public void testSaturateAndScaleToIntDoubleDouble() {
		assertEquals(  0, Ints.saturateAndScaleToInt(-1.0D, 300.0D));
		assertEquals(  0, Ints.saturateAndScaleToInt(+0.0D, 300.0D));
		assertEquals(150, Ints.saturateAndScaleToInt(+0.5D, 300.0D));
		assertEquals(300, Ints.saturateAndScaleToInt(+1.0D, 300.0D));
		assertEquals(300, Ints.saturateAndScaleToInt(+2.0D, 300.0D));
	}
	
	@Test
	public void testSaturateAndScaleToIntFloat() {
		assertEquals(  0, Ints.saturateAndScaleToInt(-1.0F));
		assertEquals(  0, Ints.saturateAndScaleToInt(+0.0F));
		assertEquals(128, Ints.saturateAndScaleToInt(+0.5F));
		assertEquals(255, Ints.saturateAndScaleToInt(+1.0F));
		assertEquals(255, Ints.saturateAndScaleToInt(+2.0F));
	}
	
	@Test
	public void testSaturateAndScaleToIntFloatFloat() {
		assertEquals(  0, Ints.saturateAndScaleToInt(-1.0F, 300.0F));
		assertEquals(  0, Ints.saturateAndScaleToInt(+0.0F, 300.0F));
		assertEquals(150, Ints.saturateAndScaleToInt(+0.5F, 300.0F));
		assertEquals(300, Ints.saturateAndScaleToInt(+1.0F, 300.0F));
		assertEquals(300, Ints.saturateAndScaleToInt(+2.0F, 300.0F));
	}
	
	@Test
	public void testSaturateInt() {
		assertEquals(  0, Ints.saturate(-  1));
		assertEquals(128, Ints.saturate(+128));
		assertEquals(255, Ints.saturate(+256));
	}
	
	@Test
	public void testSaturateIntIntInt() {
		assertEquals(20, Ints.saturate(10, 20, 30));
		assertEquals(20, Ints.saturate(10, 30, 20));
		
		assertEquals(25, Ints.saturate(25, 20, 30));
		assertEquals(25, Ints.saturate(25, 30, 20));
		
		assertEquals(30, Ints.saturate(40, 20, 30));
		assertEquals(30, Ints.saturate(40, 30, 20));
	}
}