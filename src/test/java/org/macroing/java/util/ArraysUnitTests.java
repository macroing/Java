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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

@SuppressWarnings("static-method")
public final class ArraysUnitTests {
	public ArraysUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testEqualsBooleanArrayBooleanArray() {
		final boolean[] a = new boolean[] {false, true, false};
		final boolean[] b = new boolean[] {false, true, false};
		final boolean[] c = new boolean[] {false, true, false, true};
		final boolean[] d = new boolean[] {false, false, false};
		
		assertTrue(Arrays.equals(a, a));
		assertTrue(Arrays.equals(a, b));
		
		assertFalse(Arrays.equals(a, c));
		assertFalse(Arrays.equals(a, d));
		
		assertThrows(NullPointerException.class, () -> Arrays.equals(new boolean[0], null));
		assertThrows(NullPointerException.class, () -> Arrays.equals(null, new boolean[0]));
	}
	
	@Test
	public void testEqualsBooleanArrayBooleanArrayIntIntInt() {
		assertTrue(Arrays.equals(new boolean[] {false, true, false, true, false}, new boolean[] {false, true, false}, 2, 0, 3));
		
		assertFalse(Arrays.equals(new boolean[] {false, true, false, true, false}, new boolean[] {false, true, false}, 1, 0, 3));
		
		assertThrows(NullPointerException.class, () -> Arrays.equals(new boolean[0], null, 0, 0, 0));
		assertThrows(NullPointerException.class, () -> Arrays.equals(null, new boolean[0], 0, 0, 0));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new boolean[1], new boolean[1], -1, +0, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new boolean[1], new boolean[1], +1, +0, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new boolean[1], new boolean[1], +0, -1, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new boolean[1], new boolean[1], +0, +1, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new boolean[1], new boolean[1], +0, +0, -1));
	}
	
	@Test
	public void testEqualsByteArrayByteArray() {
		final byte[] a = new byte[] {(byte)(0), (byte)(1), (byte)(2)};
		final byte[] b = new byte[] {(byte)(0), (byte)(1), (byte)(2)};
		final byte[] c = new byte[] {(byte)(0), (byte)(1), (byte)(2), (byte)(3)};
		final byte[] d = new byte[] {(byte)(0), (byte)(0), (byte)(0)};
		
		assertTrue(Arrays.equals(a, a));
		assertTrue(Arrays.equals(a, b));
		
		assertFalse(Arrays.equals(a, c));
		assertFalse(Arrays.equals(a, d));
		
		assertThrows(NullPointerException.class, () -> Arrays.equals(new byte[0], null));
		assertThrows(NullPointerException.class, () -> Arrays.equals(null, new byte[0]));
	}
	
	@Test
	public void testEqualsByteArrayByteArrayIntIntInt() {
		assertTrue(Arrays.equals(new byte[] {(byte)(0), (byte)(1), (byte)(2), (byte)(3), (byte)(4)}, new byte[] {(byte)(2), (byte)(3), (byte)(4)}, 2, 0, 3));
		
		assertFalse(Arrays.equals(new byte[] {(byte)(0), (byte)(1), (byte)(2), (byte)(3), (byte)(4)}, new byte[] {(byte)(2), (byte)(3), (byte)(4)}, 1, 0, 3));
		
		assertThrows(NullPointerException.class, () -> Arrays.equals(new byte[0], null, 0, 0, 0));
		assertThrows(NullPointerException.class, () -> Arrays.equals(null, new byte[0], 0, 0, 0));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new byte[1], new byte[1], -1, +0, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new byte[1], new byte[1], +1, +0, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new byte[1], new byte[1], +0, -1, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new byte[1], new byte[1], +0, +1, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new byte[1], new byte[1], +0, +0, -1));
	}
	
	@Test
	public void testEqualsCharArrayCharArray() {
		final char[] a = new char[] {'A', 'B', 'C'};
		final char[] b = new char[] {'A', 'B', 'C'};
		final char[] c = new char[] {'A', 'B', 'C', 'D'};
		final char[] d = new char[] {'A', 'A', 'A'};
		
		assertTrue(Arrays.equals(a, a));
		assertTrue(Arrays.equals(a, b));
		
		assertFalse(Arrays.equals(a, c));
		assertFalse(Arrays.equals(a, d));
		
		assertThrows(NullPointerException.class, () -> Arrays.equals(new char[0], null));
		assertThrows(NullPointerException.class, () -> Arrays.equals(null, new char[0]));
	}
	
	@Test
	public void testEqualsCharArrayCharArrayIntIntInt() {
		assertTrue(Arrays.equals(new char[] {'A', 'B', 'C', 'D', 'E'}, new char[] {'C', 'D', 'E'}, 2, 0, 3));
		
		assertFalse(Arrays.equals(new char[] {'A', 'B', 'C', 'D', 'E'}, new char[] {'C', 'D', 'E'}, 1, 0, 3));
		
		assertThrows(NullPointerException.class, () -> Arrays.equals(new char[0], null, 0, 0, 0));
		assertThrows(NullPointerException.class, () -> Arrays.equals(null, new char[0], 0, 0, 0));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new char[1], new char[1], -1, +0, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new char[1], new char[1], +1, +0, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new char[1], new char[1], +0, -1, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new char[1], new char[1], +0, +1, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new char[1], new char[1], +0, +0, -1));
	}
	
	@Test
	public void testEqualsDoubleArrayDoubleArray() {
		final double[] a = new double[] {0.0D, 1.0D, 2.0D};
		final double[] b = new double[] {0.0D, 1.0D, 2.0D};
		final double[] c = new double[] {0.0D, 1.0D, 2.0D, 3.0D};
		final double[] d = new double[] {0.0D, 0.0D, 0.0D};
		
		assertTrue(Arrays.equals(a, a));
		assertTrue(Arrays.equals(a, b));
		
		assertFalse(Arrays.equals(a, c));
		assertFalse(Arrays.equals(a, d));
		
		assertThrows(NullPointerException.class, () -> Arrays.equals(new double[0], null));
		assertThrows(NullPointerException.class, () -> Arrays.equals(null, new double[0]));
	}
	
	@Test
	public void testEqualsDoubleArrayDoubleArrayIntIntInt() {
		assertTrue(Arrays.equals(new double[] {0.0D, 1.0D, 2.0D, 3.0D, 4.0D}, new double[] {2.0D, 3.0D, 4.0D}, 2, 0, 3));
		
		assertFalse(Arrays.equals(new double[] {0.0D, 1.0D, 2.0D, 3.0D, 4.0D}, new double[] {2.0D, 3.0D, 4.0D}, 1, 0, 3));
		
		assertThrows(NullPointerException.class, () -> Arrays.equals(new double[0], null, 0, 0, 0));
		assertThrows(NullPointerException.class, () -> Arrays.equals(null, new double[0], 0, 0, 0));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new double[1], new double[1], -1, +0, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new double[1], new double[1], +1, +0, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new double[1], new double[1], +0, -1, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new double[1], new double[1], +0, +1, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new double[1], new double[1], +0, +0, -1));
	}
	
	@Test
	public void testEqualsFloatArrayFloatArray() {
		final float[] a = new float[] {0.0F, 1.0F, 2.0F};
		final float[] b = new float[] {0.0F, 1.0F, 2.0F};
		final float[] c = new float[] {0.0F, 1.0F, 2.0F, 3.0F};
		final float[] d = new float[] {0.0F, 0.0F, 0.0F};
		
		assertTrue(Arrays.equals(a, a));
		assertTrue(Arrays.equals(a, b));
		
		assertFalse(Arrays.equals(a, c));
		assertFalse(Arrays.equals(a, d));
		
		assertThrows(NullPointerException.class, () -> Arrays.equals(new float[0], null));
		assertThrows(NullPointerException.class, () -> Arrays.equals(null, new float[0]));
	}
	
	@Test
	public void testEqualsFloatArrayFloatArrayIntIntInt() {
		assertTrue(Arrays.equals(new float[] {0.0F, 1.0F, 2.0F, 3.0F, 4.0F}, new float[] {2.0F, 3.0F, 4.0F}, 2, 0, 3));
		
		assertFalse(Arrays.equals(new float[] {0.0F, 1.0F, 2.0F, 3.0F, 4.0F}, new float[] {2.0F, 3.0F, 4.0F}, 1, 0, 3));
		
		assertThrows(NullPointerException.class, () -> Arrays.equals(new float[0], null, 0, 0, 0));
		assertThrows(NullPointerException.class, () -> Arrays.equals(null, new float[0], 0, 0, 0));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new float[1], new float[1], -1, +0, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new float[1], new float[1], +1, +0, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new float[1], new float[1], +0, -1, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new float[1], new float[1], +0, +1, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new float[1], new float[1], +0, +0, -1));
	}
	
	@Test
	public void testEqualsIntArrayIntArray() {
		final int[] a = new int[] {0, 1, 2};
		final int[] b = new int[] {0, 1, 2};
		final int[] c = new int[] {0, 1, 2, 3};
		final int[] d = new int[] {0, 0, 0};
		
		assertTrue(Arrays.equals(a, a));
		assertTrue(Arrays.equals(a, b));
		
		assertFalse(Arrays.equals(a, c));
		assertFalse(Arrays.equals(a, d));
		
		assertThrows(NullPointerException.class, () -> Arrays.equals(new int[0], null));
		assertThrows(NullPointerException.class, () -> Arrays.equals(null, new int[0]));
	}
	
	@Test
	public void testEqualsIntArrayIntArrayIntIntInt() {
		assertTrue(Arrays.equals(new int[] {0, 1, 2, 3, 4}, new int[] {2, 3, 4}, 2, 0, 3));
		
		assertFalse(Arrays.equals(new int[] {0, 1, 2, 3, 4}, new int[] {2, 3, 4}, 1, 0, 3));
		
		assertThrows(NullPointerException.class, () -> Arrays.equals(new int[0], null, 0, 0, 0));
		assertThrows(NullPointerException.class, () -> Arrays.equals(null, new int[0], 0, 0, 0));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new int[1], new int[1], -1, +0, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new int[1], new int[1], +1, +0, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new int[1], new int[1], +0, -1, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new int[1], new int[1], +0, +1, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new int[1], new int[1], +0, +0, -1));
	}
	
	@Test
	public void testEqualsLongArrayLongArray() {
		final long[] a = new long[] {0L, 1L, 2L};
		final long[] b = new long[] {0L, 1L, 2L};
		final long[] c = new long[] {0L, 1L, 2L, 3L};
		final long[] d = new long[] {0L, 0L, 0L};
		
		assertTrue(Arrays.equals(a, a));
		assertTrue(Arrays.equals(a, b));
		
		assertFalse(Arrays.equals(a, c));
		assertFalse(Arrays.equals(a, d));
		
		assertThrows(NullPointerException.class, () -> Arrays.equals(new long[0], null));
		assertThrows(NullPointerException.class, () -> Arrays.equals(null, new long[0]));
	}
	
	@Test
	public void testEqualsLongArrayLongArrayIntIntInt() {
		assertTrue(Arrays.equals(new long[] {0L, 1L, 2L, 3L, 4L}, new long[] {2L, 3L, 4L}, 2, 0, 3));
		
		assertFalse(Arrays.equals(new long[] {0L, 1L, 2L, 3L, 4L}, new long[] {2L, 3L, 4L}, 1, 0, 3));
		
		assertThrows(NullPointerException.class, () -> Arrays.equals(new long[0], null, 0, 0, 0));
		assertThrows(NullPointerException.class, () -> Arrays.equals(null, new long[0], 0, 0, 0));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new long[1], new long[1], -1, +0, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new long[1], new long[1], +1, +0, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new long[1], new long[1], +0, -1, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new long[1], new long[1], +0, +1, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new long[1], new long[1], +0, +0, -1));
	}
	
	@Test
	public void testEqualsShortArrayShortArray() {
		final short[] a = new short[] {(short)(0), (short)(1), (short)(2)};
		final short[] b = new short[] {(short)(0), (short)(1), (short)(2)};
		final short[] c = new short[] {(short)(0), (short)(1), (short)(2), (short)(3)};
		final short[] d = new short[] {(short)(0), (short)(0), (short)(0)};
		
		assertTrue(Arrays.equals(a, a));
		assertTrue(Arrays.equals(a, b));
		
		assertFalse(Arrays.equals(a, c));
		assertFalse(Arrays.equals(a, d));
		
		assertThrows(NullPointerException.class, () -> Arrays.equals(new short[0], null));
		assertThrows(NullPointerException.class, () -> Arrays.equals(null, new short[0]));
	}
	
	@Test
	public void testEqualsShortArrayShortArrayIntIntInt() {
		assertTrue(Arrays.equals(new short[] {(short)(0), (short)(1), (short)(2), (short)(3), (short)(4)}, new short[] {(short)(2), (short)(3), (short)(4)}, 2, 0, 3));
		
		assertFalse(Arrays.equals(new short[] {(short)(0), (short)(1), (short)(2), (short)(3), (short)(4)}, new short[] {(short)(2), (short)(3), (short)(4)}, 1, 0, 3));
		
		assertThrows(NullPointerException.class, () -> Arrays.equals(new short[0], null, 0, 0, 0));
		assertThrows(NullPointerException.class, () -> Arrays.equals(null, new short[0], 0, 0, 0));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new short[1], new short[1], -1, +0, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new short[1], new short[1], +1, +0, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new short[1], new short[1], +0, -1, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new short[1], new short[1], +0, +1, +1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.equals(new short[1], new short[1], +0, +0, -1));
	}
	
	@Test
	public void testGenerateBooleanArray() {
		assertArrayEquals(new boolean[] {false, true, true}, Arrays.generateBooleanArray(3, index -> index > 0));
		
		assertThrows(IllegalArgumentException.class, () -> Arrays.generateBooleanArray(-1, index -> index > 0));
		assertThrows(NullPointerException.class, () -> Arrays.generateBooleanArray(0, null));
	}
	
	@Test
	public void testGenerateByteArray() {
		assertArrayEquals(new byte[] {(byte)(0), (byte)(1), (byte)(2)}, Arrays.generateByteArray(3, index -> (byte)(index)));
		
		assertThrows(IllegalArgumentException.class, () -> Arrays.generateByteArray(-1, index -> (byte)(index)));
		assertThrows(NullPointerException.class, () -> Arrays.generateByteArray(0, null));
	}
	
	@Test
	public void testGenerateCharArray() {
		assertArrayEquals(new char[] {'A', 'B', 'C'}, Arrays.generateCharArray(3, index -> (char)('A' + index)));
		
		assertThrows(IllegalArgumentException.class, () -> Arrays.generateCharArray(-1, index -> (char)('A' + index)));
		assertThrows(NullPointerException.class, () -> Arrays.generateCharArray(0, null));
	}
	
	@Test
	public void testGenerateDoubleArray() {
		assertArrayEquals(new double[] {0.0D, 1.0D, 2.0D}, Arrays.generateDoubleArray(3, index -> index));
		
		assertThrows(IllegalArgumentException.class, () -> Arrays.generateDoubleArray(-1, index -> index));
		assertThrows(NullPointerException.class, () -> Arrays.generateDoubleArray(0, null));
	}
	
	@Test
	public void testGenerateFloatArray() {
		assertArrayEquals(new float[] {0.0F, 1.0F, 2.0F}, Arrays.generateFloatArray(3, index -> index));
		
		assertThrows(IllegalArgumentException.class, () -> Arrays.generateFloatArray(-1, index -> index));
		assertThrows(NullPointerException.class, () -> Arrays.generateFloatArray(0, null));
	}
	
	@Test
	public void testGenerateIntArray() {
		assertArrayEquals(new int[] {0, 1, 2}, Arrays.generateIntArray(3, index -> index));
		
		assertThrows(IllegalArgumentException.class, () -> Arrays.generateIntArray(-1, index -> index));
		assertThrows(NullPointerException.class, () -> Arrays.generateIntArray(0, null));
	}
	
	@Test
	public void testGenerateLongArray() {
		assertArrayEquals(new long[] {0L, 1L, 2L}, Arrays.generateLongArray(3, index -> index));
		
		assertThrows(IllegalArgumentException.class, () -> Arrays.generateLongArray(-1, index -> index));
		assertThrows(NullPointerException.class, () -> Arrays.generateLongArray(0, null));
	}
	
	@Test
	public void testGenerateShortArray() {
		assertArrayEquals(new short[] {(short)(0), (short)(1), (short)(2)}, Arrays.generateShortArray(3, index -> (short)(index)));
		
		assertThrows(IllegalArgumentException.class, () -> Arrays.generateShortArray(-1, index -> (short)(index)));
		assertThrows(NullPointerException.class, () -> Arrays.generateShortArray(0, null));
	}
	
	@Test
	public void testHashCodeBooleanArray() {
		final boolean[] a = {false, true, false};
		final boolean[] b = {false, true, false};
		
		assertEquals(Arrays.hashCode(a), Arrays.hashCode(b));
		
		assertThrows(NullPointerException.class, () -> Arrays.hashCode((boolean[])(null)));
	}
	
	@Test
	public void testHashCodeByteArray() {
		final byte[] a = {(byte)(0), (byte)(1), (byte)(2)};
		final byte[] b = {(byte)(0), (byte)(1), (byte)(2)};
		
		assertEquals(Arrays.hashCode(a), Arrays.hashCode(b));
		
		assertThrows(NullPointerException.class, () -> Arrays.hashCode((byte[])(null)));
	}
	
	@Test
	public void testHashCodeCharArray() {
		final char[] a = {'A', 'B', 'C'};
		final char[] b = {'A', 'B', 'C'};
		
		assertEquals(Arrays.hashCode(a), Arrays.hashCode(b));
		
		assertThrows(NullPointerException.class, () -> Arrays.hashCode((char[])(null)));
	}
	
	@Test
	public void testHashCodeDoubleArray() {
		final double[] a = {0.0D, 1.0D, 2.0D};
		final double[] b = {0.0D, 1.0D, 2.0D};
		
		assertEquals(Arrays.hashCode(a), Arrays.hashCode(b));
		
		assertThrows(NullPointerException.class, () -> Arrays.hashCode((double[])(null)));
	}
	
	@Test
	public void testHashCodeFloatArray() {
		final float[] a = {0.0F, 1.0F, 2.0F};
		final float[] b = {0.0F, 1.0F, 2.0F};
		
		assertEquals(Arrays.hashCode(a), Arrays.hashCode(b));
		
		assertThrows(NullPointerException.class, () -> Arrays.hashCode((float[])(null)));
	}
	
	@Test
	public void testHashCodeIntArray() {
		final int[] a = {0, 1, 2};
		final int[] b = {0, 1, 2};
		
		assertEquals(Arrays.hashCode(a), Arrays.hashCode(b));
		
		assertThrows(NullPointerException.class, () -> Arrays.hashCode((int[])(null)));
	}
	
	@Test
	public void testHashCodeLongArray() {
		final long[] a = {0L, 1L, 2L};
		final long[] b = {0L, 1L, 2L};
		
		assertEquals(Arrays.hashCode(a), Arrays.hashCode(b));
		
		assertThrows(NullPointerException.class, () -> Arrays.hashCode((long[])(null)));
	}
	
	@Test
	public void testHashCodeShortArray() {
		final short[] a = {(short)(0), (short)(1), (short)(2)};
		final short[] b = {(short)(0), (short)(1), (short)(2)};
		
		assertEquals(Arrays.hashCode(a), Arrays.hashCode(b));
		
		assertThrows(NullPointerException.class, () -> Arrays.hashCode((short[])(null)));
	}
	
	@Test
	public void testIndexOfFloatArrayFloatArrayBooleanBoolean() {
		assertEquals(-1, Arrays.indexOf(new float[1], new float[0], false, false));
		assertEquals(-1, Arrays.indexOf(new float[0], new float[1], false, false));
		assertEquals(+1, Arrays.indexOf(new float[] {1.0F, 2.0F}, new float[] {0.0F, 1.0F, 2.0F, 3.0F}, false, false));
		assertEquals(+2, Arrays.indexOf(new float[] {2.0F, 3.0F}, new float[] {0.0F, 1.0F, 2.0F, 3.0F}, true, false));
		assertEquals(+1, Arrays.indexOf(new float[] {2.0F, 3.0F}, new float[] {0.0F, 1.0F, 2.0F, 3.0F}, true, true));
		assertEquals(-1, Arrays.indexOf(new float[] {3.0F, 4.0F}, new float[] {0.0F, 1.0F, 2.0F, 3.0F}, false, false));
		assertEquals(-1, Arrays.indexOf(new float[] {3.0F, 4.0F}, new float[] {0.0F, 1.0F, 2.0F, 3.0F}, true, true));
		
		assertThrows(NullPointerException.class, () -> Arrays.indexOf(new float[0], null, false, false));
		assertThrows(NullPointerException.class, () -> Arrays.indexOf(null, new float[0], false, false));
		assertThrows(IllegalArgumentException.class, () -> Arrays.indexOf(new float[2], new float[5], true, false));
	}
	
	@Test
	public void testIndexOfIntArrayIntArrayBooleanBoolean() {
		assertEquals(-1, Arrays.indexOf(new int[1], new int[0], false, false));
		assertEquals(-1, Arrays.indexOf(new int[0], new int[1], false, false));
		assertEquals(+1, Arrays.indexOf(new int[] {1, 2}, new int[] {0, 1, 2, 3}, false, false));
		assertEquals(+2, Arrays.indexOf(new int[] {2, 3}, new int[] {0, 1, 2, 3}, true, false));
		assertEquals(+1, Arrays.indexOf(new int[] {2, 3}, new int[] {0, 1, 2, 3}, true, true));
		assertEquals(-1, Arrays.indexOf(new int[] {3, 4}, new int[] {0, 1, 2, 3}, false, false));
		assertEquals(-1, Arrays.indexOf(new int[] {3, 4}, new int[] {0, 1, 2, 3}, true, true));
		
		assertThrows(NullPointerException.class, () -> Arrays.indexOf(new int[0], null, false, false));
		assertThrows(NullPointerException.class, () -> Arrays.indexOf(null, new int[0], false, false));
		assertThrows(IllegalArgumentException.class, () -> Arrays.indexOf(new int[2], new int[5], true, false));
	}
	
	@Test
	public void testIndexOfIntIntArray() {
		assertEquals(+1, Arrays.indexOf(1, new int[] {0, 1, 2}));
		assertEquals(-1, Arrays.indexOf(3, new int[] {0, 1, 2}));
		
		assertThrows(NullPointerException.class, () -> Arrays.indexOf(0, null));
	}
	
	@Test
	public void testMergeBooleanArrays() {
		assertArrayEquals(new boolean[] {false, false, false, true, true, true, false, false, false}, Arrays.merge(new boolean[] {false, false, false}, new boolean[] {true, true, true}, new boolean[] {false, false, false}));
		
		assertThrows(NullPointerException.class, () -> Arrays.merge((boolean[])(null)));
		assertThrows(NullPointerException.class, () -> Arrays.merge((boolean[][])(null)));
	}
	
	@Test
	public void testMergeByteArrays() {
		assertArrayEquals(new byte[] {(byte)(1), (byte)(2), (byte)(3), (byte)(4), (byte)(5), (byte)(6), (byte)(7), (byte)(8), (byte)(9)}, Arrays.merge(new byte[] {(byte)(1), (byte)(2), (byte)(3)}, new byte[] {(byte)(4), (byte)(5), (byte)(6)}, new byte[] {(byte)(7), (byte)(8), (byte)(9)}));
		
		assertThrows(NullPointerException.class, () -> Arrays.merge((byte[])(null)));
		assertThrows(NullPointerException.class, () -> Arrays.merge((byte[][])(null)));
	}
	
	@Test
	public void testMergeCharArrays() {
		assertArrayEquals(new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'}, Arrays.merge(new char[] {'A', 'B', 'C'}, new char[] {'D', 'E', 'F'}, new char[] {'G', 'H', 'I'}));
		
		assertThrows(NullPointerException.class, () -> Arrays.merge((char[])(null)));
		assertThrows(NullPointerException.class, () -> Arrays.merge((char[][])(null)));
	}
	
	@Test
	public void testMergeDoubleArrays() {
		assertArrayEquals(new double[] {1.0D, 2.0D, 3.0D, 4.0D, 5.0D, 6.0D, 7.0D, 8.0D, 9.0D}, Arrays.merge(new double[] {1.0D, 2.0D, 3.0D}, new double[] {4.0D, 5.0D, 6.0D}, new double[] {7.0D, 8.0D, 9.0D}));
		
		assertThrows(NullPointerException.class, () -> Arrays.merge((double[])(null)));
		assertThrows(NullPointerException.class, () -> Arrays.merge((double[][])(null)));
	}
	
	@Test
	public void testMergeFloatArrays() {
		assertArrayEquals(new float[] {1.0F, 2.0F, 3.0F, 4.0F, 5.0F, 6.0F, 7.0F, 8.0F, 9.0F}, Arrays.merge(new float[] {1.0F, 2.0F, 3.0F}, new float[] {4.0F, 5.0F, 6.0F}, new float[] {7.0F, 8.0F, 9.0F}));
		
		assertThrows(NullPointerException.class, () -> Arrays.merge((float[])(null)));
		assertThrows(NullPointerException.class, () -> Arrays.merge((float[][])(null)));
	}
	
	@Test
	public void testMergeIntArrays() {
		assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, Arrays.merge(new int[] {1, 2, 3}, new int[] {4, 5, 6}, new int[] {7, 8, 9}));
		
		assertThrows(NullPointerException.class, () -> Arrays.merge((int[])(null)));
		assertThrows(NullPointerException.class, () -> Arrays.merge((int[][])(null)));
	}
	
	@Test
	public void testMergeLongArrays() {
		assertArrayEquals(new long[] {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L}, Arrays.merge(new long[] {1L, 2L, 3L}, new long[] {4L, 5L, 6L}, new long[] {7L, 8L, 9L}));
		
		assertThrows(NullPointerException.class, () -> Arrays.merge((long[])(null)));
		assertThrows(NullPointerException.class, () -> Arrays.merge((long[][])(null)));
	}
	
	@Test
	public void testMergeShortArrays() {
		assertArrayEquals(new short[] {(short)(1), (short)(2), (short)(3), (short)(4), (short)(5), (short)(6), (short)(7), (short)(8), (short)(9)}, Arrays.merge(new short[] {(short)(1), (short)(2), (short)(3)}, new short[] {(short)(4), (short)(5), (short)(6)}, new short[] {(short)(7), (short)(8), (short)(9)}));
		
		assertThrows(NullPointerException.class, () -> Arrays.merge((short[])(null)));
		assertThrows(NullPointerException.class, () -> Arrays.merge((short[][])(null)));
	}
	
	@Test
	public void testRepeatBooleanArrayInt() {
		assertArrayEquals(new boolean [] {}, Arrays.repeat(new boolean[] {}, 3));
		assertArrayEquals(new boolean [] {}, Arrays.repeat(new boolean[] {false,  true}, 0));
		assertArrayEquals(new boolean [] {false, false, false}, Arrays.repeat(new boolean[] {false}, 3));
		assertArrayEquals(new boolean [] {false, true, false, true, false, true}, Arrays.repeat(new boolean[] {false,  true}, 3));
		
		assertThrows(NullPointerException.class, () -> Arrays.repeat((boolean[])(null), 1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new boolean[0], -1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new boolean[2], Integer.MAX_VALUE));
	}
	
	@Test
	public void testRepeatByteArrayInt() {
		assertArrayEquals(new byte [] {}, Arrays.repeat(new byte[] {}, 3));
		assertArrayEquals(new byte [] {}, Arrays.repeat(new byte[] {(byte)(1), (byte)(2)}, 0));
		assertArrayEquals(new byte [] {(byte)(1), (byte)(1), (byte)(1)}, Arrays.repeat(new byte[] {(byte)(1)}, 3));
		assertArrayEquals(new byte [] {(byte)(1), (byte)(2), (byte)(1), (byte)(2), (byte)(1), (byte)(2)}, Arrays.repeat(new byte[] {(byte)(1), (byte)(2)}, 3));
		
		assertThrows(NullPointerException.class, () -> Arrays.repeat((byte[])(null), 1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new byte[0], -1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new byte[2], Integer.MAX_VALUE));
	}
	
	@Test
	public void testRepeatCharArrayInt() {
		assertArrayEquals(new char [] {}, Arrays.repeat(new char[] {}, 3));
		assertArrayEquals(new char [] {}, Arrays.repeat(new char[] {'A',  'B'}, 0));
		assertArrayEquals(new char [] {'A', 'A', 'A'}, Arrays.repeat(new char[] {'A'}, 3));
		assertArrayEquals(new char [] {'A', 'B', 'A', 'B', 'A', 'B'}, Arrays.repeat(new char[] {'A',  'B'}, 3));
		
		assertThrows(NullPointerException.class, () -> Arrays.repeat((char[])(null), 1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new char[0], -1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new char[2], Integer.MAX_VALUE));
	}
	
	@Test
	public void testRepeatDoubleArrayInt() {
		assertArrayEquals(new double [] {}, Arrays.repeat(new double[] {}, 3));
		assertArrayEquals(new double [] {}, Arrays.repeat(new double[] {1.0D, 2.0D}, 0));
		assertArrayEquals(new double [] {1.0D, 1.0D, 1.0D}, Arrays.repeat(new double[] {1.0D}, 3));
		assertArrayEquals(new double [] {1.0D, 2.0D, 1.0D, 2.0D, 1.0D, 2.0D}, Arrays.repeat(new double[] {1.0D, 2.0D}, 3));
		
		assertThrows(NullPointerException.class, () -> Arrays.repeat((double[])(null), 1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new double[0], -1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new double[2], Integer.MAX_VALUE));
	}
	
	@Test
	public void testRepeatFloatArrayInt() {
		assertArrayEquals(new float [] {}, Arrays.repeat(new float[] {}, 3));
		assertArrayEquals(new float [] {}, Arrays.repeat(new float[] {1.0F, 2.0F}, 0));
		assertArrayEquals(new float [] {1.0F, 1.0F, 1.0F}, Arrays.repeat(new float[] {1.0F}, 3));
		assertArrayEquals(new float [] {1.0F, 2.0F, 1.0F, 2.0F, 1.0F, 2.0F}, Arrays.repeat(new float[] {1.0F, 2.0F}, 3));
		
		assertThrows(NullPointerException.class, () -> Arrays.repeat((float[])(null), 1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new float[0], -1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new float[2], Integer.MAX_VALUE));
	}
	
	@Test
	public void testRepeatIntArrayInt() {
		assertArrayEquals(new int [] {}, Arrays.repeat(new int[] {}, 3));
		assertArrayEquals(new int [] {}, Arrays.repeat(new int[] {1, 2}, 0));
		assertArrayEquals(new int [] {1, 1, 1}, Arrays.repeat(new int[] {1}, 3));
		assertArrayEquals(new int [] {1, 2, 1, 2, 1, 2}, Arrays.repeat(new int[] {1, 2}, 3));
		
		assertThrows(NullPointerException.class, () -> Arrays.repeat((int[])(null), 1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new int[0], -1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new int[2], Integer.MAX_VALUE));
	}
	
	@Test
	public void testRepeatLongArrayInt() {
		assertArrayEquals(new long [] {}, Arrays.repeat(new long[] {}, 3));
		assertArrayEquals(new long [] {}, Arrays.repeat(new long[] {1L, 2L}, 0));
		assertArrayEquals(new long [] {1L, 1L, 1L}, Arrays.repeat(new long[] {1L}, 3));
		assertArrayEquals(new long [] {1L, 2L, 1L, 2L, 1L, 2L}, Arrays.repeat(new long[] {1L, 2L}, 3));
		
		assertThrows(NullPointerException.class, () -> Arrays.repeat((long[])(null), 1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new long[0], -1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new long[2], Integer.MAX_VALUE));
	}
	
	@Test
	public void testRepeatShortArrayInt() {
		assertArrayEquals(new short [] {}, Arrays.repeat(new short[] {}, 3));
		assertArrayEquals(new short [] {}, Arrays.repeat(new short[] {(short)(1), (short)(2)}, 0));
		assertArrayEquals(new short [] {(short)(1), (short)(1), (short)(1)}, Arrays.repeat(new short[] {(short)(1)}, 3));
		assertArrayEquals(new short [] {(short)(1), (short)(2), (short)(1), (short)(2), (short)(1), (short)(2)}, Arrays.repeat(new short[] {(short)(1), (short)(2)}, 3));
		
		assertThrows(NullPointerException.class, () -> Arrays.repeat((short[])(null), 1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new short[0], -1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new short[2], Integer.MAX_VALUE));
	}
	
	@Test
	public void testRequireNonNullBooleanArrayArrayString() {
		assertThrows(NullPointerException.class, () -> Arrays.requireNonNull(new boolean[0][0], null));
		assertThrows(NullPointerException.class, () -> Arrays.requireNonNull((boolean[][])(null), "arrays"));
		assertThrows(NullPointerException.class, () -> Arrays.requireNonNull(new boolean[][] {new boolean[0], null}, "arrays"));
		
		final boolean[][] arrays = new boolean[0][0];
		
		assertSame(arrays, Arrays.requireNonNull(arrays, "arrays"));
	}
	
	@Test
	public void testRequireNonNullByteArrayArrayString() {
		assertThrows(NullPointerException.class, () -> Arrays.requireNonNull(new byte[0][0], null));
		assertThrows(NullPointerException.class, () -> Arrays.requireNonNull((byte[][])(null), "arrays"));
		assertThrows(NullPointerException.class, () -> Arrays.requireNonNull(new byte[][] {new byte[0], null}, "arrays"));
		
		final byte[][] arrays = new byte[0][0];
		
		assertSame(arrays, Arrays.requireNonNull(arrays, "arrays"));
	}
	
	@Test
	public void testRequireNonNullCharArrayArrayString() {
		assertThrows(NullPointerException.class, () -> Arrays.requireNonNull(new char[0][0], null));
		assertThrows(NullPointerException.class, () -> Arrays.requireNonNull((char[][])(null), "arrays"));
		assertThrows(NullPointerException.class, () -> Arrays.requireNonNull(new char[][] {new char[0], null}, "arrays"));
		
		final char[][] arrays = new char[0][0];
		
		assertSame(arrays, Arrays.requireNonNull(arrays, "arrays"));
	}
	
	@Test
	public void testRequireNonNullDoubleArrayArrayString() {
		assertThrows(NullPointerException.class, () -> Arrays.requireNonNull(new double[0][0], null));
		assertThrows(NullPointerException.class, () -> Arrays.requireNonNull((double[][])(null), "arrays"));
		assertThrows(NullPointerException.class, () -> Arrays.requireNonNull(new double[][] {new double[0], null}, "arrays"));
		
		final double[][] arrays = new double[0][0];
		
		assertSame(arrays, Arrays.requireNonNull(arrays, "arrays"));
	}
	
	@Test
	public void testRequireNonNullFloatArrayArrayString() {
		assertThrows(NullPointerException.class, () -> Arrays.requireNonNull(new float[0][0], null));
		assertThrows(NullPointerException.class, () -> Arrays.requireNonNull((float[][])(null), "arrays"));
		assertThrows(NullPointerException.class, () -> Arrays.requireNonNull(new float[][] {new float[0], null}, "arrays"));
		
		final float[][] arrays = new float[0][0];
		
		assertSame(arrays, Arrays.requireNonNull(arrays, "arrays"));
	}
	
	@Test
	public void testRequireNonNullIntArrayArrayString() {
		assertThrows(NullPointerException.class, () -> Arrays.requireNonNull(new int[0][0], null));
		assertThrows(NullPointerException.class, () -> Arrays.requireNonNull((int[][])(null), "arrays"));
		assertThrows(NullPointerException.class, () -> Arrays.requireNonNull(new int[][] {new int[0], null}, "arrays"));
		
		final int[][] arrays = new int[0][0];
		
		assertSame(arrays, Arrays.requireNonNull(arrays, "arrays"));
	}
	
	@Test
	public void testRequireNonNullLongArrayArrayString() {
		assertThrows(NullPointerException.class, () -> Arrays.requireNonNull(new long[0][0], null));
		assertThrows(NullPointerException.class, () -> Arrays.requireNonNull((long[][])(null), "arrays"));
		assertThrows(NullPointerException.class, () -> Arrays.requireNonNull(new long[][] {new long[0], null}, "arrays"));
		
		final long[][] arrays = new long[0][0];
		
		assertSame(arrays, Arrays.requireNonNull(arrays, "arrays"));
	}
	
	@Test
	public void testRequireNonNullShortArrayArrayString() {
		assertThrows(NullPointerException.class, () -> Arrays.requireNonNull(new short[0][0], null));
		assertThrows(NullPointerException.class, () -> Arrays.requireNonNull((short[][])(null), "arrays"));
		assertThrows(NullPointerException.class, () -> Arrays.requireNonNull(new short[][] {new short[0], null}, "arrays"));
		
		final short[][] arrays = new short[0][0];
		
		assertSame(arrays, Arrays.requireNonNull(arrays, "arrays"));
	}
	
	@Test
	public void testSpliceBooleanArrayInt() {
		assertArrayEquals(new boolean[] {false, true}, Arrays.splice(new boolean[] {false, true, true, true}, +2));
		assertArrayEquals(new boolean[] {false, true}, Arrays.splice(new boolean[] {false, true, true, true}, -2));
		assertArrayEquals(new boolean[] {false}, Arrays.splice(new boolean[] {false, true, true, true}, -3));
		
		assertThrows(NullPointerException.class, () -> Arrays.splice((boolean[])(null), 0));
	}
	
	@Test
	public void testSpliceBooleanArrayIntInt() {
		assertArrayEquals(new boolean[] {false, true}, Arrays.splice(new boolean[] {false, true, true, true}, +2, +2));
		assertArrayEquals(new boolean[] {false, true}, Arrays.splice(new boolean[] {false, true, true, true}, -2, +2));
		assertArrayEquals(new boolean[] {false, true}, Arrays.splice(new boolean[] {false, true, true, true}, -3, -1));
		
		assertThrows(NullPointerException.class, () -> Arrays.splice((boolean[])(null), 0, 0));
	}
	
	@Test
	public void testSpliceBooleanArrayIntIntBooleanArray() {
		assertArrayEquals(new boolean[] {false, true, false, true, true, true, true, true}, Arrays.splice(new boolean[] {false, true, true, true}, +2, +2, new boolean[] {false, true, true, true, true, true}));
		assertArrayEquals(new boolean[] {false, true, false, true, true, true, true, true}, Arrays.splice(new boolean[] {false, true, true, true}, -2, +2, new boolean[] {false, true, true, true, true, true}));
		assertArrayEquals(new boolean[] {false, false, true, true, true, true, true, false}, Arrays.splice(new boolean[] {false, true, true, false}, -3, -1, new boolean[] {false, true, true, true, true, true}));
		
		assertThrows(NullPointerException.class, () -> Arrays.splice(new boolean[0], 0, 0, null));
		assertThrows(NullPointerException.class, () -> Arrays.splice(null, 0, 0, new boolean[0]));
	}
	
	@Test
	public void testSpliceByteArrayInt() {
		assertArrayEquals(new byte[] {0, 1}, Arrays.splice(new byte[] {0, 1, 2, 3}, +2));
		assertArrayEquals(new byte[] {0, 1}, Arrays.splice(new byte[] {0, 1, 2, 3}, -2));
		assertArrayEquals(new byte[] {0}, Arrays.splice(new byte[] {0, 1, 2, 9}, -3));
		
		assertThrows(NullPointerException.class, () -> Arrays.splice((byte[])(null), 0));
	}
	
	@Test
	public void testSpliceByteArrayIntInt() {
		assertArrayEquals(new byte[] {0, 1}, Arrays.splice(new byte[] {0, 1, 2, 3}, +2, +2));
		assertArrayEquals(new byte[] {0, 1}, Arrays.splice(new byte[] {0, 1, 2, 3}, -2, +2));
		assertArrayEquals(new byte[] {0, 9}, Arrays.splice(new byte[] {0, 1, 2, 9}, -3, -1));
		
		assertThrows(NullPointerException.class, () -> Arrays.splice((byte[])(null), 0, 0));
	}
	
	@Test
	public void testSpliceByteArrayIntIntByteArray() {
		assertArrayEquals(new byte[] {0, 1, 4, 5, 6, 7, 8, 9}, Arrays.splice(new byte[] {0, 1, 2, 3}, +2, +2, new byte[] {4, 5, 6, 7, 8, 9}));
		assertArrayEquals(new byte[] {0, 1, 4, 5, 6, 7, 8, 9}, Arrays.splice(new byte[] {0, 1, 2, 3}, -2, +2, new byte[] {4, 5, 6, 7, 8, 9}));
		assertArrayEquals(new byte[] {0, 3, 4, 5, 6, 7, 8, 9}, Arrays.splice(new byte[] {0, 1, 2, 9}, -3, -1, new byte[] {3, 4, 5, 6, 7, 8}));
		
		assertThrows(NullPointerException.class, () -> Arrays.splice(new byte[0], 0, 0, null));
		assertThrows(NullPointerException.class, () -> Arrays.splice(null, 0, 0, new byte[0]));
	}
	
	@Test
	public void testSpliceCharArrayInt() {
		assertArrayEquals(new char[] {'A', 'B'}, Arrays.splice(new char[] {'A', 'B', 'C', 'D'}, +2));
		assertArrayEquals(new char[] {'A', 'B'}, Arrays.splice(new char[] {'A', 'B', 'C', 'D'}, -2));
		assertArrayEquals(new char[] {'A'}, Arrays.splice(new char[] {'A', 'B', 'C', 'J'}, -3));
		
		assertThrows(NullPointerException.class, () -> Arrays.splice((char[])(null), 0));
	}
	
	@Test
	public void testSpliceCharArrayIntInt() {
		assertArrayEquals(new char[] {'A', 'B'}, Arrays.splice(new char[] {'A', 'B', 'C', 'D'}, +2, +2));
		assertArrayEquals(new char[] {'A', 'B'}, Arrays.splice(new char[] {'A', 'B', 'C', 'D'}, -2, +2));
		assertArrayEquals(new char[] {'A', 'J'}, Arrays.splice(new char[] {'A', 'B', 'C', 'J'}, -3, -1));
		
		assertThrows(NullPointerException.class, () -> Arrays.splice((char[])(null), 0, 0));
	}
	
	@Test
	public void testSpliceCharArrayIntIntCharArray() {
		assertArrayEquals(new char[] {'A', 'B', 'E', 'F', 'G', 'H', 'I', 'J'}, Arrays.splice(new char[] {'A', 'B', 'C', 'D'}, +2, +2, new char[] {'E', 'F', 'G', 'H', 'I', 'J'}));
		assertArrayEquals(new char[] {'A', 'B', 'E', 'F', 'G', 'H', 'I', 'J'}, Arrays.splice(new char[] {'A', 'B', 'C', 'D'}, -2, +2, new char[] {'E', 'F', 'G', 'H', 'I', 'J'}));
		assertArrayEquals(new char[] {'A', 'D', 'E', 'F', 'G', 'H', 'I', 'J'}, Arrays.splice(new char[] {'A', 'B', 'C', 'J'}, -3, -1, new char[] {'D', 'E', 'F', 'G', 'H', 'I'}));
		
		assertThrows(NullPointerException.class, () -> Arrays.splice(new char[0], 0, 0, null));
		assertThrows(NullPointerException.class, () -> Arrays.splice(null, 0, 0, new char[0]));
	}
	
	@Test
	public void testSpliceDoubleArrayInt() {
		assertArrayEquals(new double[] {0.0D, 1.0D}, Arrays.splice(new double[] {0.0D, 1.0D, 2.0D, 3.0D}, +2));
		assertArrayEquals(new double[] {0.0D, 1.0D}, Arrays.splice(new double[] {0.0D, 1.0D, 2.0D, 3.0D}, -2));
		assertArrayEquals(new double[] {0.0D}, Arrays.splice(new double[] {0.0D, 1.0D, 2.0D, 9.0D}, -3));
		
		assertThrows(NullPointerException.class, () -> Arrays.splice((double[])(null), 0));
	}
	
	@Test
	public void testSpliceDoubleArrayIntInt() {
		assertArrayEquals(new double[] {0.0D, 1.0D}, Arrays.splice(new double[] {0.0D, 1.0D, 2.0D, 3.0D}, +2, +2));
		assertArrayEquals(new double[] {0.0D, 1.0D}, Arrays.splice(new double[] {0.0D, 1.0D, 2.0D, 3.0D}, -2, +2));
		assertArrayEquals(new double[] {0.0D, 9.0D}, Arrays.splice(new double[] {0.0D, 1.0D, 2.0D, 9.0D}, -3, -1));
		
		assertThrows(NullPointerException.class, () -> Arrays.splice((double[])(null), 0, 0));
	}
	
	@Test
	public void testSpliceDoubleArrayIntIntDoubleArray() {
		assertArrayEquals(new double[] {0.0D, 1.0D, 4.0D, 5.0D, 6.0D, 7.0D, 8.0D, 9.0D}, Arrays.splice(new double[] {0.0D, 1.0D, 2.0D, 3.0D}, +2, +2, new double[] {4.0D, 5.0D, 6.0D, 7.0D, 8.0D, 9.0D}));
		assertArrayEquals(new double[] {0.0D, 1.0D, 4.0D, 5.0D, 6.0D, 7.0D, 8.0D, 9.0D}, Arrays.splice(new double[] {0.0D, 1.0D, 2.0D, 3.0D}, -2, +2, new double[] {4.0D, 5.0D, 6.0D, 7.0D, 8.0D, 9.0D}));
		assertArrayEquals(new double[] {0.0D, 3.0D, 4.0D, 5.0D, 6.0D, 7.0D, 8.0D, 9.0D}, Arrays.splice(new double[] {0.0D, 1.0D, 2.0D, 9.0D}, -3, -1, new double[] {3.0D, 4.0D, 5.0D, 6.0D, 7.0D, 8.0D}));
		
		assertThrows(NullPointerException.class, () -> Arrays.splice(new double[0], 0, 0, null));
		assertThrows(NullPointerException.class, () -> Arrays.splice(null, 0, 0, new double[0]));
	}
	
	@Test
	public void testSpliceFloatArrayInt() {
		assertArrayEquals(new float[] {0.0F, 1.0F}, Arrays.splice(new float[] {0.0F, 1.0F, 2.0F, 3.0F}, +2));
		assertArrayEquals(new float[] {0.0F, 1.0F}, Arrays.splice(new float[] {0.0F, 1.0F, 2.0F, 3.0F}, -2));
		assertArrayEquals(new float[] {0.0F}, Arrays.splice(new float[] {0.0F, 1.0F, 2.0F, 9.0F}, -3));
		
		assertThrows(NullPointerException.class, () -> Arrays.splice((float[])(null), 0));
	}
	
	@Test
	public void testSpliceFloatArrayIntInt() {
		assertArrayEquals(new float[] {0.0F, 1.0F}, Arrays.splice(new float[] {0.0F, 1.0F, 2.0F, 3.0F}, +2, +2));
		assertArrayEquals(new float[] {0.0F, 1.0F}, Arrays.splice(new float[] {0.0F, 1.0F, 2.0F, 3.0F}, -2, +2));
		assertArrayEquals(new float[] {0.0F, 9.0F}, Arrays.splice(new float[] {0.0F, 1.0F, 2.0F, 9.0F}, -3, -1));
		
		assertThrows(NullPointerException.class, () -> Arrays.splice((float[])(null), 0, 0));
	}
	
	@Test
	public void testSpliceFloatArrayIntIntFloatArray() {
		assertArrayEquals(new float[] {0.0F, 1.0F, 4.0F, 5.0F, 6.0F, 7.0F, 8.0F, 9.0F}, Arrays.splice(new float[] {0.0F, 1.0F, 2.0F, 3.0F}, +2, +2, new float[] {4.0F, 5.0F, 6.0F, 7.0F, 8.0F, 9.0F}));
		assertArrayEquals(new float[] {0.0F, 1.0F, 4.0F, 5.0F, 6.0F, 7.0F, 8.0F, 9.0F}, Arrays.splice(new float[] {0.0F, 1.0F, 2.0F, 3.0F}, -2, +2, new float[] {4.0F, 5.0F, 6.0F, 7.0F, 8.0F, 9.0F}));
		assertArrayEquals(new float[] {0.0F, 3.0F, 4.0F, 5.0F, 6.0F, 7.0F, 8.0F, 9.0F}, Arrays.splice(new float[] {0.0F, 1.0F, 2.0F, 9.0F}, -3, -1, new float[] {3.0F, 4.0F, 5.0F, 6.0F, 7.0F, 8.0F}));
		
		assertThrows(NullPointerException.class, () -> Arrays.splice(new float[0], 0, 0, null));
		assertThrows(NullPointerException.class, () -> Arrays.splice(null, 0, 0, new float[0]));
	}
	
	@Test
	public void testSpliceIntArrayInt() {
		assertArrayEquals(new int[] {0, 1}, Arrays.splice(new int[] {0, 1, 2, 3}, +2));
		assertArrayEquals(new int[] {0, 1}, Arrays.splice(new int[] {0, 1, 2, 3}, -2));
		assertArrayEquals(new int[] {0}, Arrays.splice(new int[] {0, 1, 2, 9}, -3));
		
		assertThrows(NullPointerException.class, () -> Arrays.splice((int[])(null), 0));
	}
	
	@Test
	public void testSpliceIntArrayIntInt() {
		assertArrayEquals(new int[] {0, 1}, Arrays.splice(new int[] {0, 1, 2, 3}, +2, +2));
		assertArrayEquals(new int[] {0, 1}, Arrays.splice(new int[] {0, 1, 2, 3}, -2, +2));
		assertArrayEquals(new int[] {0, 9}, Arrays.splice(new int[] {0, 1, 2, 9}, -3, -1));
		
		assertThrows(NullPointerException.class, () -> Arrays.splice((int[])(null), 0, 0));
	}
	
	@Test
	public void testSpliceIntArrayIntIntIntArray() {
		assertArrayEquals(new int[] {0, 1, 4, 5, 6, 7, 8, 9}, Arrays.splice(new int[] {0, 1, 2, 3}, +2, +2, new int[] {4, 5, 6, 7, 8, 9}));
		assertArrayEquals(new int[] {0, 1, 4, 5, 6, 7, 8, 9}, Arrays.splice(new int[] {0, 1, 2, 3}, -2, +2, new int[] {4, 5, 6, 7, 8, 9}));
		assertArrayEquals(new int[] {0, 3, 4, 5, 6, 7, 8, 9}, Arrays.splice(new int[] {0, 1, 2, 9}, -3, -1, new int[] {3, 4, 5, 6, 7, 8}));
		
		assertThrows(NullPointerException.class, () -> Arrays.splice(new int[0], 0, 0, null));
		assertThrows(NullPointerException.class, () -> Arrays.splice(null, 0, 0, new int[0]));
	}
	
	@Test
	public void testSpliceLongArrayInt() {
		assertArrayEquals(new long[] {0L, 1L}, Arrays.splice(new long[] {0L, 1L, 2L, 3L}, +2));
		assertArrayEquals(new long[] {0L, 1L}, Arrays.splice(new long[] {0L, 1L, 2L, 3L}, -2));
		assertArrayEquals(new long[] {0L}, Arrays.splice(new long[] {0L, 1L, 2L, 9L}, -3));
		
		assertThrows(NullPointerException.class, () -> Arrays.splice((long[])(null), 0));
	}
	
	@Test
	public void testSpliceLongArrayIntInt() {
		assertArrayEquals(new long[] {0L, 1L}, Arrays.splice(new long[] {0L, 1L, 2L, 3L}, +2, +2));
		assertArrayEquals(new long[] {0L, 1L}, Arrays.splice(new long[] {0L, 1L, 2L, 3L}, -2, +2));
		assertArrayEquals(new long[] {0L, 9L}, Arrays.splice(new long[] {0L, 1L, 2L, 9L}, -3, -1));
		
		assertThrows(NullPointerException.class, () -> Arrays.splice((long[])(null), 0, 0));
	}
	
	@Test
	public void testSpliceLongArrayIntIntLongArray() {
		assertArrayEquals(new long[] {0L, 1L, 4L, 5L, 6L, 7L, 8L, 9L}, Arrays.splice(new long[] {0L, 1L, 2L, 3L}, +2, +2, new long[] {4L, 5L, 6L, 7L, 8L, 9L}));
		assertArrayEquals(new long[] {0L, 1L, 4L, 5L, 6L, 7L, 8L, 9L}, Arrays.splice(new long[] {0L, 1L, 2L, 3L}, -2, +2, new long[] {4L, 5L, 6L, 7L, 8L, 9L}));
		assertArrayEquals(new long[] {0L, 3L, 4L, 5L, 6L, 7L, 8L, 9L}, Arrays.splice(new long[] {0L, 1L, 2L, 9L}, -3, -1, new long[] {3L, 4L, 5L, 6L, 7L, 8L}));
		
		assertThrows(NullPointerException.class, () -> Arrays.splice(new long[0], 0, 0, null));
		assertThrows(NullPointerException.class, () -> Arrays.splice(null, 0, 0, new long[0]));
	}
	
	@Test
	public void testSpliceShortArrayInt() {
		assertArrayEquals(new short[] {0, 1}, Arrays.splice(new short[] {0, 1, 2, 3}, +2));
		assertArrayEquals(new short[] {0, 1}, Arrays.splice(new short[] {0, 1, 2, 3}, -2));
		assertArrayEquals(new short[] {0}, Arrays.splice(new short[] {0, 1, 2, 9}, -3));
		
		assertThrows(NullPointerException.class, () -> Arrays.splice((short[])(null), 0));
	}
	
	@Test
	public void testSpliceShortArrayIntInt() {
		assertArrayEquals(new short[] {0, 1}, Arrays.splice(new short[] {0, 1, 2, 3}, +2, +2));
		assertArrayEquals(new short[] {0, 1}, Arrays.splice(new short[] {0, 1, 2, 3}, -2, +2));
		assertArrayEquals(new short[] {0, 9}, Arrays.splice(new short[] {0, 1, 2, 9}, -3, -1));
		
		assertThrows(NullPointerException.class, () -> Arrays.splice((short[])(null), 0, 0));
	}
	
	@Test
	public void testSpliceShortArrayIntIntShortArray() {
		assertArrayEquals(new short[] {0, 1, 4, 5, 6, 7, 8, 9}, Arrays.splice(new short[] {0, 1, 2, 3}, +2, +2, new short[] {4, 5, 6, 7, 8, 9}));
		assertArrayEquals(new short[] {0, 1, 4, 5, 6, 7, 8, 9}, Arrays.splice(new short[] {0, 1, 2, 3}, -2, +2, new short[] {4, 5, 6, 7, 8, 9}));
		assertArrayEquals(new short[] {0, 3, 4, 5, 6, 7, 8, 9}, Arrays.splice(new short[] {0, 1, 2, 9}, -3, -1, new short[] {3, 4, 5, 6, 7, 8}));
		
		assertThrows(NullPointerException.class, () -> Arrays.splice(new short[0], 0, 0, null));
		assertThrows(NullPointerException.class, () -> Arrays.splice(null, 0, 0, new short[0]));
	}
	
	@Test
	public void testToBooleanArrayListFunction() {
		final List<String> stringsA = new ArrayList<>();
		final List<String> stringsB = new ArrayList<>();
		
		stringsA.add("A");
		stringsA.add("BB");
		stringsA.add("CCC");
		
		stringsB.add(null);
		
		assertArrayEquals(new boolean[] {}, Arrays.toBooleanArray(new ArrayList<String>(), string -> new boolean[0]));
		assertArrayEquals(new boolean[] {false, true, true, true, true, true}, Arrays.toBooleanArray(stringsA, string -> Arrays.repeat(new boolean[] {string.length() > 1}, string.length())));
		
		assertThrows(NullPointerException.class, () -> Arrays.toBooleanArray(null, string -> new boolean[0]));
		assertThrows(NullPointerException.class, () -> Arrays.toBooleanArray(stringsB, string -> new boolean[0]));
		assertThrows(NullPointerException.class, () -> Arrays.toBooleanArray(stringsA, null));
		assertThrows(NullPointerException.class, () -> Arrays.toBooleanArray(stringsA, string -> null));
	}
	
	@Test
	public void testToByteArrayIntArray() {
		assertArrayEquals(new byte[] {(byte)(0), (byte)(1), (byte)(2)}, Arrays.toByteArray(new int[] {0, 1, 2}));
		
		assertThrows(NullPointerException.class, () -> Arrays.toByteArray((int[])(null)));
	}
	
	@Test
	public void testToByteArrayListFunction() {
		final List<String> stringsA = new ArrayList<>();
		final List<String> stringsB = new ArrayList<>();
		
		stringsA.add("A");
		stringsA.add("BB");
		stringsA.add("CCC");
		
		stringsB.add(null);
		
		assertArrayEquals(new byte[] {}, Arrays.toByteArray(new ArrayList<String>(), string -> new byte[0]));
		assertArrayEquals(new byte[] {1, 2, 2, 3, 3, 3}, Arrays.toByteArray(stringsA, string -> Arrays.repeat(new byte[] {(byte)(string.length())}, string.length())));
		
		assertThrows(NullPointerException.class, () -> Arrays.toByteArray(null, string -> new byte[0]));
		assertThrows(NullPointerException.class, () -> Arrays.toByteArray(stringsB, string -> new byte[0]));
		assertThrows(NullPointerException.class, () -> Arrays.toByteArray(stringsA, null));
		assertThrows(NullPointerException.class, () -> Arrays.toByteArray(stringsA, string -> null));
	}
	
	@Test
	public void testToCharArrayListFunction() {
		final List<String> stringsA = new ArrayList<>();
		final List<String> stringsB = new ArrayList<>();
		
		stringsA.add("A");
		stringsA.add("BB");
		stringsA.add("CCC");
		
		stringsB.add(null);
		
		assertArrayEquals(new char[] {}, Arrays.toCharArray(new ArrayList<String>(), string -> new char[0]));
		assertArrayEquals(new char[] {'B', 'C', 'C', 'D', 'D', 'D'}, Arrays.toCharArray(stringsA, string -> Arrays.repeat(new char[] {(char)('A' + string.length())}, string.length())));
		
		assertThrows(NullPointerException.class, () -> Arrays.toCharArray(null, string -> new char[0]));
		assertThrows(NullPointerException.class, () -> Arrays.toCharArray(stringsB, string -> new char[0]));
		assertThrows(NullPointerException.class, () -> Arrays.toCharArray(stringsA, null));
		assertThrows(NullPointerException.class, () -> Arrays.toCharArray(stringsA, string -> null));
	}
	
	@Test
	public void testToDoubleArrayListFunction() {
		final List<String> stringsA = new ArrayList<>();
		final List<String> stringsB = new ArrayList<>();
		
		stringsA.add("A");
		stringsA.add("BB");
		stringsA.add("CCC");
		
		stringsB.add(null);
		
		assertArrayEquals(new double[] {}, Arrays.toDoubleArray(new ArrayList<String>(), string -> new double[0]));
		assertArrayEquals(new double[] {1.0D, 2.0D, 2.0D, 3.0D, 3.0D, 3.0D}, Arrays.toDoubleArray(stringsA, string -> Arrays.repeat(new double[] {string.length()}, string.length())));
		
		assertThrows(NullPointerException.class, () -> Arrays.toDoubleArray(null, string -> new double[0]));
		assertThrows(NullPointerException.class, () -> Arrays.toDoubleArray(stringsB, string -> new double[0]));
		assertThrows(NullPointerException.class, () -> Arrays.toDoubleArray(stringsA, null));
		assertThrows(NullPointerException.class, () -> Arrays.toDoubleArray(stringsA, string -> null));
	}
	
	@Test
	public void testToFloatArrayListFunction() {
		final List<String> stringsA = new ArrayList<>();
		final List<String> stringsB = new ArrayList<>();
		
		stringsA.add("A");
		stringsA.add("BB");
		stringsA.add("CCC");
		
		stringsB.add(null);
		
		assertArrayEquals(new float[] {}, Arrays.toFloatArray(new ArrayList<String>(), string -> new float[0]));
		assertArrayEquals(new float[] {1.0F, 2.0F, 2.0F, 3.0F, 3.0F, 3.0F}, Arrays.toFloatArray(stringsA, string -> Arrays.repeat(new float[] {string.length()}, string.length())));
		
		assertThrows(NullPointerException.class, () -> Arrays.toFloatArray(null, string -> new float[0]));
		assertThrows(NullPointerException.class, () -> Arrays.toFloatArray(stringsB, string -> new float[0]));
		assertThrows(NullPointerException.class, () -> Arrays.toFloatArray(stringsA, null));
		assertThrows(NullPointerException.class, () -> Arrays.toFloatArray(stringsA, string -> null));
	}
	
	@Test
	public void testToIntArrayListFunction() {
		final List<String> stringsA = new ArrayList<>();
		final List<String> stringsB = new ArrayList<>();
		
		stringsA.add("A");
		stringsA.add("BB");
		stringsA.add("CCC");
		
		stringsB.add(null);
		
		assertArrayEquals(new int[] {}, Arrays.toIntArray(new ArrayList<String>(), string -> new int[0]));
		assertArrayEquals(new int[] {1, 2, 2, 3, 3, 3}, Arrays.toIntArray(stringsA, string -> Arrays.repeat(new int[] {string.length()}, string.length())));
		
		assertThrows(NullPointerException.class, () -> Arrays.toIntArray(null, string -> new int[0]));
		assertThrows(NullPointerException.class, () -> Arrays.toIntArray(stringsB, string -> new int[0]));
		assertThrows(NullPointerException.class, () -> Arrays.toIntArray(stringsA, null));
		assertThrows(NullPointerException.class, () -> Arrays.toIntArray(stringsA, string -> null));
	}
	
	@Test
	public void testToLongArrayListFunction() {
		final List<String> stringsA = new ArrayList<>();
		final List<String> stringsB = new ArrayList<>();
		
		stringsA.add("A");
		stringsA.add("BB");
		stringsA.add("CCC");
		
		stringsB.add(null);
		
		assertArrayEquals(new long[] {}, Arrays.toLongArray(new ArrayList<String>(), string -> new long[0]));
		assertArrayEquals(new long[] {1L, 2L, 2L, 3L, 3L, 3L}, Arrays.toLongArray(stringsA, string -> Arrays.repeat(new long[] {string.length()}, string.length())));
		
		assertThrows(NullPointerException.class, () -> Arrays.toLongArray(null, string -> new long[0]));
		assertThrows(NullPointerException.class, () -> Arrays.toLongArray(stringsB, string -> new long[0]));
		assertThrows(NullPointerException.class, () -> Arrays.toLongArray(stringsA, null));
		assertThrows(NullPointerException.class, () -> Arrays.toLongArray(stringsA, string -> null));
	}
	
	@Test
	public void testToShortArrayListFunction() {
		final List<String> stringsA = new ArrayList<>();
		final List<String> stringsB = new ArrayList<>();
		
		stringsA.add("A");
		stringsA.add("BB");
		stringsA.add("CCC");
		
		stringsB.add(null);
		
		assertArrayEquals(new short[] {}, Arrays.toShortArray(new ArrayList<String>(), string -> new short[0]));
		assertArrayEquals(new short[] {1, 2, 2, 3, 3, 3}, Arrays.toShortArray(stringsA, string -> Arrays.repeat(new short[] {(short)(string.length())}, string.length())));
		
		assertThrows(NullPointerException.class, () -> Arrays.toShortArray(null, string -> new short[0]));
		assertThrows(NullPointerException.class, () -> Arrays.toShortArray(stringsB, string -> new short[0]));
		assertThrows(NullPointerException.class, () -> Arrays.toShortArray(stringsA, null));
		assertThrows(NullPointerException.class, () -> Arrays.toShortArray(stringsA, string -> null));
	}
}