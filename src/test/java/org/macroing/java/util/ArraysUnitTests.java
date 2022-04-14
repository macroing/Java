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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

@SuppressWarnings("static-method")
public final class ArraysUnitTests {
	public ArraysUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
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
		assertArrayEquals(new boolean [] {false, true, false, true, false, true}, Arrays.repeat(new boolean[] {false,  true}, 3));
		
		assertThrows(NullPointerException.class, () -> Arrays.repeat((boolean[])(null), 1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new boolean[0], -1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new boolean[2], Integer.MAX_VALUE));
	}
	
	@Test
	public void testRepeatByteArrayInt() {
		assertArrayEquals(new byte [] {(byte)(1), (byte)(2), (byte)(1), (byte)(2), (byte)(1), (byte)(2)}, Arrays.repeat(new byte[] {(byte)(1), (byte)(2)}, 3));
		
		assertThrows(NullPointerException.class, () -> Arrays.repeat((byte[])(null), 1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new byte[0], -1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new byte[2], Integer.MAX_VALUE));
	}
	
	@Test
	public void testRepeatCharArrayInt() {
		assertArrayEquals(new char [] {'A', 'B', 'A', 'B', 'A', 'B'}, Arrays.repeat(new char[] {'A',  'B'}, 3));
		
		assertThrows(NullPointerException.class, () -> Arrays.repeat((char[])(null), 1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new char[0], -1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new char[2], Integer.MAX_VALUE));
	}
	
	@Test
	public void testRepeatDoubleArrayInt() {
		assertArrayEquals(new double [] {1.0D, 2.0D, 1.0D, 2.0D, 1.0D, 2.0D}, Arrays.repeat(new double[] {1.0D, 2.0D}, 3));
		
		assertThrows(NullPointerException.class, () -> Arrays.repeat((double[])(null), 1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new double[0], -1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new double[2], Integer.MAX_VALUE));
	}
	
	@Test
	public void testRepeatFloatArrayInt() {
		assertArrayEquals(new float [] {1.0F, 2.0F, 1.0F, 2.0F, 1.0F, 2.0F}, Arrays.repeat(new float[] {1.0F, 2.0F}, 3));
		
		assertThrows(NullPointerException.class, () -> Arrays.repeat((float[])(null), 1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new float[0], -1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new float[2], Integer.MAX_VALUE));
	}
	
	@Test
	public void testRepeatIntArrayInt() {
		assertArrayEquals(new int [] {1, 2, 1, 2, 1, 2}, Arrays.repeat(new int[] {1, 2}, 3));
		
		assertThrows(NullPointerException.class, () -> Arrays.repeat((int[])(null), 1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new int[0], -1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new int[2], Integer.MAX_VALUE));
	}
	
	@Test
	public void testRepeatLongArrayInt() {
		assertArrayEquals(new long [] {1L, 2L, 1L, 2L, 1L, 2L}, Arrays.repeat(new long[] {1L, 2L}, 3));
		
		assertThrows(NullPointerException.class, () -> Arrays.repeat((long[])(null), 1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new long[0], -1));
		assertThrows(IllegalArgumentException.class, () -> Arrays.repeat(new long[2], Integer.MAX_VALUE));
	}
	
	@Test
	public void testRepeatShortArrayInt() {
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
}