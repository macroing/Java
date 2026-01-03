/**
 * Copyright 2021 - 2026 J&#246;rgen Lundgren
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

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;

import org.macroing.java.io.BooleanArrayOutputStream;
import org.macroing.java.io.CharArrayOutputStream;
import org.macroing.java.io.DoubleArrayOutputStream;
import org.macroing.java.io.FloatArrayOutputStream;
import org.macroing.java.io.IntArrayOutputStream;
import org.macroing.java.io.LongArrayOutputStream;
import org.macroing.java.io.ShortArrayOutputStream;
import org.macroing.java.util.function.IntToBooleanFunction;
import org.macroing.java.util.function.IntToByteFunction;
import org.macroing.java.util.function.IntToCharFunction;
import org.macroing.java.util.function.IntToFloatFunction;
import org.macroing.java.util.function.IntToShortFunction;

/**
 * A class that consists exclusively of static methods that returns or performs various operations on arrays.
 * 
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
public final class Arrays {
	private Arrays() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Checks that {@code array} and all of its elements are not {@code null}.
	 * <p>
	 * Returns {@code array}.
	 * <p>
	 * If either {@code array}, an element in {@code array} or {@code name} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param <T> the generic type of {@code array}
	 * @param array the array to check
	 * @param name the name of the parameter argument used for {@code array}, that will be part of the message for the {@code NullPointerException}
	 * @return {@code array}
	 * @throws NullPointerException thrown if, and only if, either {@code array}, an element in {@code array} or {@code name} are {@code null}
	 */
	public static <T> T[] requireNonNull(final T[] array, final String name) {
		Objects.requireNonNull(name, "name == null");
		
		if(array == null) {
			throw new NullPointerException(String.format("%s == null", name));
		}
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == null) {
				throw new NullPointerException(String.format("%s[%d] == null", name, Integer.valueOf(i)));
			}
		}
		
		return array;
	}
	
	/**
	 * Returns {@code true} if, and only if, the elements of {@code arrayA} are equal to the elements of {@code arrayB}, {@code false} otherwise.
	 * <p>
	 * If either {@code arrayA} or {@code arrayB} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param arrayA a {@code boolean[]}
	 * @param arrayB a {@code boolean[]}
	 * @return {@code true} if, and only if, the elements of {@code arrayA} are equal to the elements of {@code arrayB}, {@code false} otherwise
	 * @throws NullPointerException thrown if, and only if, either {@code arrayA} or {@code arrayB} are {@code null}
	 */
	public static boolean equals(final boolean[] arrayA, final boolean[] arrayB) {
		Objects.requireNonNull(arrayA, "arrayA == null");
		Objects.requireNonNull(arrayB, "arrayB == null");
		
		if(arrayA == arrayB) {
			return true;
		} else if(arrayA.length != arrayB.length) {
			return false;
		} else {
			for(int i = 0; i < arrayA.length; i++) {
				if(arrayA[i] != arrayB[i]) {
					return false;
				}
			}
			
			return true;
		}
	}
	
	/**
	 * Returns {@code true} if, and only if, the elements of {@code arrayA} starting at {@code offsetArrayA} are equal to the elements of {@code arrayB} starting at {@code offsetArrayB}, {@code false} otherwise.
	 * <p>
	 * If either {@code arrayA} or {@code arrayB} are {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If {@code offsetArrayA} is less than {@code 0} or greater than or equal to {@code arrayA.length}, {@code offsetArrayB} is less than {@code 0} or greater than or equal to {@code arrayB.length}, {@code length} is less than {@code 0}, {@code offsetArrayA + length} is less than {@code 0} or greater than {@code arrayA.length} or {@code offsetArrayB + length} is less than {@code 0} or greater than {@code arrayB.length}, an {@code IllegalArgumentException} will be thrown.
	 * 
	 * @param arrayA a {@code boolean[]}
	 * @param arrayB a {@code boolean[]}
	 * @param offsetArrayA the offset to start at in {@code arrayA}
	 * @param offsetArrayB the offset to start at in {@code arrayB}
	 * @param length the length of the sub-arrays to test for equality
	 * @return {@code true} if, and only if, the elements of {@code arrayA} starting at {@code offsetArrayA} are equal to the elements of {@code arrayB} starting at {@code offsetArrayB}, {@code false} otherwise
	 * @throws IllegalArgumentException thrown if, and only if, {@code offsetArrayA} is less than {@code 0} or greater than or equal to {@code arrayA.length}, {@code offsetArrayB} is less than {@code 0} or greater than or equal to {@code arrayB.length}, {@code length} is less than {@code 0}, {@code offsetArrayA + length} is less than {@code 0} or greater than {@code arrayA.length} or {@code offsetArrayB + length} is less than {@code 0} or greater than {@code arrayB.length}
	 * @throws NullPointerException thrown if, and only if, either {@code arrayA} or {@code arrayB} are {@code null}
	 */
	public static boolean equals(final boolean[] arrayA, final boolean[] arrayB, final int offsetArrayA, final int offsetArrayB, final int length) {
		Objects.requireNonNull(arrayA, "arrayA == null");
		Objects.requireNonNull(arrayB, "arrayB == null");
		
		doRequireRange(offsetArrayA, 0, arrayA.length - 1, "offsetArrayA");
		doRequireRange(offsetArrayB, 0, arrayB.length - 1, "offsetArrayB");
		doRequireRange(length, 0, Integer.MAX_VALUE, "length");
		doRequireRange(offsetArrayA + length, 0, arrayA.length, "offsetArrayA + length");
		doRequireRange(offsetArrayB + length, 0, arrayB.length, "offsetArrayB + length");
		
		for(int i = 0; i < length; i++) {
			if(arrayA[offsetArrayA + i] != arrayB[offsetArrayB + i]) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Returns {@code true} if, and only if, the elements of {@code arrayA} are equal to the elements of {@code arrayB}, {@code false} otherwise.
	 * <p>
	 * If either {@code arrayA} or {@code arrayB} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param arrayA a {@code byte[]}
	 * @param arrayB a {@code byte[]}
	 * @return {@code true} if, and only if, the elements of {@code arrayA} are equal to the elements of {@code arrayB}, {@code false} otherwise
	 * @throws NullPointerException thrown if, and only if, either {@code arrayA} or {@code arrayB} are {@code null}
	 */
	public static boolean equals(final byte[] arrayA, final byte[] arrayB) {
		Objects.requireNonNull(arrayA, "arrayA == null");
		Objects.requireNonNull(arrayB, "arrayB == null");
		
		if(arrayA == arrayB) {
			return true;
		} else if(arrayA.length != arrayB.length) {
			return false;
		} else {
			for(int i = 0; i < arrayA.length; i++) {
				if(arrayA[i] != arrayB[i]) {
					return false;
				}
			}
			
			return true;
		}
	}
	
	/**
	 * Returns {@code true} if, and only if, the elements of {@code arrayA} starting at {@code offsetArrayA} are equal to the elements of {@code arrayB} starting at {@code offsetArrayB}, {@code false} otherwise.
	 * <p>
	 * If either {@code arrayA} or {@code arrayB} are {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If {@code offsetArrayA} is less than {@code 0} or greater than or equal to {@code arrayA.length}, {@code offsetArrayB} is less than {@code 0} or greater than or equal to {@code arrayB.length}, {@code length} is less than {@code 0}, {@code offsetArrayA + length} is less than {@code 0} or greater than {@code arrayA.length} or {@code offsetArrayB + length} is less than {@code 0} or greater than {@code arrayB.length}, an {@code IllegalArgumentException} will be thrown.
	 * 
	 * @param arrayA a {@code byte[]}
	 * @param arrayB a {@code byte[]}
	 * @param offsetArrayA the offset to start at in {@code arrayA}
	 * @param offsetArrayB the offset to start at in {@code arrayB}
	 * @param length the length of the sub-arrays to test for equality
	 * @return {@code true} if, and only if, the elements of {@code arrayA} starting at {@code offsetArrayA} are equal to the elements of {@code arrayB} starting at {@code offsetArrayB}, {@code false} otherwise
	 * @throws IllegalArgumentException thrown if, and only if, {@code offsetArrayA} is less than {@code 0} or greater than or equal to {@code arrayA.length}, {@code offsetArrayB} is less than {@code 0} or greater than or equal to {@code arrayB.length}, {@code length} is less than {@code 0}, {@code offsetArrayA + length} is less than {@code 0} or greater than {@code arrayA.length} or {@code offsetArrayB + length} is less than {@code 0} or greater than {@code arrayB.length}
	 * @throws NullPointerException thrown if, and only if, either {@code arrayA} or {@code arrayB} are {@code null}
	 */
	public static boolean equals(final byte[] arrayA, final byte[] arrayB, final int offsetArrayA, final int offsetArrayB, final int length) {
		Objects.requireNonNull(arrayA, "arrayA == null");
		Objects.requireNonNull(arrayB, "arrayB == null");
		
		doRequireRange(offsetArrayA, 0, arrayA.length - 1, "offsetArrayA");
		doRequireRange(offsetArrayB, 0, arrayB.length - 1, "offsetArrayB");
		doRequireRange(length, 0, Integer.MAX_VALUE, "length");
		doRequireRange(offsetArrayA + length, 0, arrayA.length, "offsetArrayA + length");
		doRequireRange(offsetArrayB + length, 0, arrayB.length, "offsetArrayB + length");
		
		for(int i = 0; i < length; i++) {
			if(arrayA[offsetArrayA + i] != arrayB[offsetArrayB + i]) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Returns {@code true} if, and only if, the elements of {@code arrayA} are equal to the elements of {@code arrayB}, {@code false} otherwise.
	 * <p>
	 * If either {@code arrayA} or {@code arrayB} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param arrayA a {@code char[]}
	 * @param arrayB a {@code char[]}
	 * @return {@code true} if, and only if, the elements of {@code arrayA} are equal to the elements of {@code arrayB}, {@code false} otherwise
	 * @throws NullPointerException thrown if, and only if, either {@code arrayA} or {@code arrayB} are {@code null}
	 */
	public static boolean equals(final char[] arrayA, final char[] arrayB) {
		Objects.requireNonNull(arrayA, "arrayA == null");
		Objects.requireNonNull(arrayB, "arrayB == null");
		
		if(arrayA == arrayB) {
			return true;
		} else if(arrayA.length != arrayB.length) {
			return false;
		} else {
			for(int i = 0; i < arrayA.length; i++) {
				if(arrayA[i] != arrayB[i]) {
					return false;
				}
			}
			
			return true;
		}
	}
	
	/**
	 * Returns {@code true} if, and only if, the elements of {@code arrayA} starting at {@code offsetArrayA} are equal to the elements of {@code arrayB} starting at {@code offsetArrayB}, {@code false} otherwise.
	 * <p>
	 * If either {@code arrayA} or {@code arrayB} are {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If {@code offsetArrayA} is less than {@code 0} or greater than or equal to {@code arrayA.length}, {@code offsetArrayB} is less than {@code 0} or greater than or equal to {@code arrayB.length}, {@code length} is less than {@code 0}, {@code offsetArrayA + length} is less than {@code 0} or greater than {@code arrayA.length} or {@code offsetArrayB + length} is less than {@code 0} or greater than {@code arrayB.length}, an {@code IllegalArgumentException} will be thrown.
	 * 
	 * @param arrayA a {@code char[]}
	 * @param arrayB a {@code char[]}
	 * @param offsetArrayA the offset to start at in {@code arrayA}
	 * @param offsetArrayB the offset to start at in {@code arrayB}
	 * @param length the length of the sub-arrays to test for equality
	 * @return {@code true} if, and only if, the elements of {@code arrayA} starting at {@code offsetArrayA} are equal to the elements of {@code arrayB} starting at {@code offsetArrayB}, {@code false} otherwise
	 * @throws IllegalArgumentException thrown if, and only if, {@code offsetArrayA} is less than {@code 0} or greater than or equal to {@code arrayA.length}, {@code offsetArrayB} is less than {@code 0} or greater than or equal to {@code arrayB.length}, {@code length} is less than {@code 0}, {@code offsetArrayA + length} is less than {@code 0} or greater than {@code arrayA.length} or {@code offsetArrayB + length} is less than {@code 0} or greater than {@code arrayB.length}
	 * @throws NullPointerException thrown if, and only if, either {@code arrayA} or {@code arrayB} are {@code null}
	 */
	public static boolean equals(final char[] arrayA, final char[] arrayB, final int offsetArrayA, final int offsetArrayB, final int length) {
		Objects.requireNonNull(arrayA, "arrayA == null");
		Objects.requireNonNull(arrayB, "arrayB == null");
		
		doRequireRange(offsetArrayA, 0, arrayA.length - 1, "offsetArrayA");
		doRequireRange(offsetArrayB, 0, arrayB.length - 1, "offsetArrayB");
		doRequireRange(length, 0, Integer.MAX_VALUE, "length");
		doRequireRange(offsetArrayA + length, 0, arrayA.length, "offsetArrayA + length");
		doRequireRange(offsetArrayB + length, 0, arrayB.length, "offsetArrayB + length");
		
		for(int i = 0; i < length; i++) {
			if(arrayA[offsetArrayA + i] != arrayB[offsetArrayB + i]) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Returns {@code true} if, and only if, the elements of {@code arrayA} are equal to the elements of {@code arrayB}, {@code false} otherwise.
	 * <p>
	 * If either {@code arrayA} or {@code arrayB} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param arrayA a {@code double[]}
	 * @param arrayB a {@code double[]}
	 * @return {@code true} if, and only if, the elements of {@code arrayA} are equal to the elements of {@code arrayB}, {@code false} otherwise
	 * @throws NullPointerException thrown if, and only if, either {@code arrayA} or {@code arrayB} are {@code null}
	 */
	public static boolean equals(final double[] arrayA, final double[] arrayB) {
		Objects.requireNonNull(arrayA, "arrayA == null");
		Objects.requireNonNull(arrayB, "arrayB == null");
		
		if(arrayA == arrayB) {
			return true;
		} else if(arrayA.length != arrayB.length) {
			return false;
		} else {
			for(int i = 0; i < arrayA.length; i++) {
				if(Double.compare(arrayA[i], arrayB[i]) != 0) {
					return false;
				}
			}
			
			return true;
		}
	}
	
	/**
	 * Returns {@code true} if, and only if, the elements of {@code arrayA} starting at {@code offsetArrayA} are equal to the elements of {@code arrayB} starting at {@code offsetArrayB}, {@code false} otherwise.
	 * <p>
	 * If either {@code arrayA} or {@code arrayB} are {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If {@code offsetArrayA} is less than {@code 0} or greater than or equal to {@code arrayA.length}, {@code offsetArrayB} is less than {@code 0} or greater than or equal to {@code arrayB.length}, {@code length} is less than {@code 0}, {@code offsetArrayA + length} is less than {@code 0} or greater than {@code arrayA.length} or {@code offsetArrayB + length} is less than {@code 0} or greater than {@code arrayB.length}, an {@code IllegalArgumentException} will be thrown.
	 * 
	 * @param arrayA a {@code double[]}
	 * @param arrayB a {@code double[]}
	 * @param offsetArrayA the offset to start at in {@code arrayA}
	 * @param offsetArrayB the offset to start at in {@code arrayB}
	 * @param length the length of the sub-arrays to test for equality
	 * @return {@code true} if, and only if, the elements of {@code arrayA} starting at {@code offsetArrayA} are equal to the elements of {@code arrayB} starting at {@code offsetArrayB}, {@code false} otherwise
	 * @throws IllegalArgumentException thrown if, and only if, {@code offsetArrayA} is less than {@code 0} or greater than or equal to {@code arrayA.length}, {@code offsetArrayB} is less than {@code 0} or greater than or equal to {@code arrayB.length}, {@code length} is less than {@code 0}, {@code offsetArrayA + length} is less than {@code 0} or greater than {@code arrayA.length} or {@code offsetArrayB + length} is less than {@code 0} or greater than {@code arrayB.length}
	 * @throws NullPointerException thrown if, and only if, either {@code arrayA} or {@code arrayB} are {@code null}
	 */
	public static boolean equals(final double[] arrayA, final double[] arrayB, final int offsetArrayA, final int offsetArrayB, final int length) {
		Objects.requireNonNull(arrayA, "arrayA == null");
		Objects.requireNonNull(arrayB, "arrayB == null");
		
		doRequireRange(offsetArrayA, 0, arrayA.length - 1, "offsetArrayA");
		doRequireRange(offsetArrayB, 0, arrayB.length - 1, "offsetArrayB");
		doRequireRange(length, 0, Integer.MAX_VALUE, "length");
		doRequireRange(offsetArrayA + length, 0, arrayA.length, "offsetArrayA + length");
		doRequireRange(offsetArrayB + length, 0, arrayB.length, "offsetArrayB + length");
		
		for(int i = 0; i < length; i++) {
			if(Double.compare(arrayA[offsetArrayA + i], arrayB[offsetArrayB + i]) != 0) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Returns {@code true} if, and only if, the elements of {@code arrayA} are equal to the elements of {@code arrayB}, {@code false} otherwise.
	 * <p>
	 * If either {@code arrayA} or {@code arrayB} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param arrayA a {@code float[]}
	 * @param arrayB a {@code float[]}
	 * @return {@code true} if, and only if, the elements of {@code arrayA} are equal to the elements of {@code arrayB}, {@code false} otherwise
	 * @throws NullPointerException thrown if, and only if, either {@code arrayA} or {@code arrayB} are {@code null}
	 */
	public static boolean equals(final float[] arrayA, final float[] arrayB) {
		Objects.requireNonNull(arrayA, "arrayA == null");
		Objects.requireNonNull(arrayB, "arrayB == null");
		
		if(arrayA == arrayB) {
			return true;
		} else if(arrayA.length != arrayB.length) {
			return false;
		} else {
			for(int i = 0; i < arrayA.length; i++) {
				if(Float.compare(arrayA[i], arrayB[i]) != 0) {
					return false;
				}
			}
			
			return true;
		}
	}
	
	/**
	 * Returns {@code true} if, and only if, the elements of {@code arrayA} starting at {@code offsetArrayA} are equal to the elements of {@code arrayB} starting at {@code offsetArrayB}, {@code false} otherwise.
	 * <p>
	 * If either {@code arrayA} or {@code arrayB} are {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If {@code offsetArrayA} is less than {@code 0} or greater than or equal to {@code arrayA.length}, {@code offsetArrayB} is less than {@code 0} or greater than or equal to {@code arrayB.length}, {@code length} is less than {@code 0}, {@code offsetArrayA + length} is less than {@code 0} or greater than {@code arrayA.length} or {@code offsetArrayB + length} is less than {@code 0} or greater than {@code arrayB.length}, an {@code IllegalArgumentException} will be thrown.
	 * 
	 * @param arrayA a {@code float[]}
	 * @param arrayB a {@code float[]}
	 * @param offsetArrayA the offset to start at in {@code arrayA}
	 * @param offsetArrayB the offset to start at in {@code arrayB}
	 * @param length the length of the sub-arrays to test for equality
	 * @return {@code true} if, and only if, the elements of {@code arrayA} starting at {@code offsetArrayA} are equal to the elements of {@code arrayB} starting at {@code offsetArrayB}, {@code false} otherwise
	 * @throws IllegalArgumentException thrown if, and only if, {@code offsetArrayA} is less than {@code 0} or greater than or equal to {@code arrayA.length}, {@code offsetArrayB} is less than {@code 0} or greater than or equal to {@code arrayB.length}, {@code length} is less than {@code 0}, {@code offsetArrayA + length} is less than {@code 0} or greater than {@code arrayA.length} or {@code offsetArrayB + length} is less than {@code 0} or greater than {@code arrayB.length}
	 * @throws NullPointerException thrown if, and only if, either {@code arrayA} or {@code arrayB} are {@code null}
	 */
	public static boolean equals(final float[] arrayA, final float[] arrayB, final int offsetArrayA, final int offsetArrayB, final int length) {
		Objects.requireNonNull(arrayA, "arrayA == null");
		Objects.requireNonNull(arrayB, "arrayB == null");
		
		doRequireRange(offsetArrayA, 0, arrayA.length - 1, "offsetArrayA");
		doRequireRange(offsetArrayB, 0, arrayB.length - 1, "offsetArrayB");
		doRequireRange(length, 0, Integer.MAX_VALUE, "length");
		doRequireRange(offsetArrayA + length, 0, arrayA.length, "offsetArrayA + length");
		doRequireRange(offsetArrayB + length, 0, arrayB.length, "offsetArrayB + length");
		
		for(int i = 0; i < length; i++) {
			if(Float.compare(arrayA[offsetArrayA + i], arrayB[offsetArrayB + i]) != 0) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Returns {@code true} if, and only if, the elements of {@code arrayA} are equal to the elements of {@code arrayB}, {@code false} otherwise.
	 * <p>
	 * If either {@code arrayA} or {@code arrayB} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param arrayA a {@code int[]}
	 * @param arrayB a {@code int[]}
	 * @return {@code true} if, and only if, the elements of {@code arrayA} are equal to the elements of {@code arrayB}, {@code false} otherwise
	 * @throws NullPointerException thrown if, and only if, either {@code arrayA} or {@code arrayB} are {@code null}
	 */
	public static boolean equals(final int[] arrayA, final int[] arrayB) {
		Objects.requireNonNull(arrayA, "arrayA == null");
		Objects.requireNonNull(arrayB, "arrayB == null");
		
		if(arrayA == arrayB) {
			return true;
		} else if(arrayA.length != arrayB.length) {
			return false;
		} else {
			for(int i = 0; i < arrayA.length; i++) {
				if(arrayA[i] != arrayB[i]) {
					return false;
				}
			}
			
			return true;
		}
	}
	
	/**
	 * Returns {@code true} if, and only if, the elements of {@code arrayA} starting at {@code offsetArrayA} are equal to the elements of {@code arrayB} starting at {@code offsetArrayB}, {@code false} otherwise.
	 * <p>
	 * If either {@code arrayA} or {@code arrayB} are {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If {@code offsetArrayA} is less than {@code 0} or greater than or equal to {@code arrayA.length}, {@code offsetArrayB} is less than {@code 0} or greater than or equal to {@code arrayB.length}, {@code length} is less than {@code 0}, {@code offsetArrayA + length} is less than {@code 0} or greater than {@code arrayA.length} or {@code offsetArrayB + length} is less than {@code 0} or greater than {@code arrayB.length}, an {@code IllegalArgumentException} will be thrown.
	 * 
	 * @param arrayA an {@code int[]}
	 * @param arrayB an {@code int[]}
	 * @param offsetArrayA the offset to start at in {@code arrayA}
	 * @param offsetArrayB the offset to start at in {@code arrayB}
	 * @param length the length of the sub-arrays to test for equality
	 * @return {@code true} if, and only if, the elements of {@code arrayA} starting at {@code offsetArrayA} are equal to the elements of {@code arrayB} starting at {@code offsetArrayB}, {@code false} otherwise
	 * @throws IllegalArgumentException thrown if, and only if, {@code offsetArrayA} is less than {@code 0} or greater than or equal to {@code arrayA.length}, {@code offsetArrayB} is less than {@code 0} or greater than or equal to {@code arrayB.length}, {@code length} is less than {@code 0}, {@code offsetArrayA + length} is less than {@code 0} or greater than {@code arrayA.length} or {@code offsetArrayB + length} is less than {@code 0} or greater than {@code arrayB.length}
	 * @throws NullPointerException thrown if, and only if, either {@code arrayA} or {@code arrayB} are {@code null}
	 */
	public static boolean equals(final int[] arrayA, final int[] arrayB, final int offsetArrayA, final int offsetArrayB, final int length) {
		Objects.requireNonNull(arrayA, "arrayA == null");
		Objects.requireNonNull(arrayB, "arrayB == null");
		
		doRequireRange(offsetArrayA, 0, arrayA.length - 1, "offsetArrayA");
		doRequireRange(offsetArrayB, 0, arrayB.length - 1, "offsetArrayB");
		doRequireRange(length, 0, Integer.MAX_VALUE, "length");
		doRequireRange(offsetArrayA + length, 0, arrayA.length, "offsetArrayA + length");
		doRequireRange(offsetArrayB + length, 0, arrayB.length, "offsetArrayB + length");
		
		for(int i = 0; i < length; i++) {
			if(arrayA[offsetArrayA + i] != arrayB[offsetArrayB + i]) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Returns {@code true} if, and only if, the elements of {@code arrayA} are equal to the elements of {@code arrayB}, {@code false} otherwise.
	 * <p>
	 * If either {@code arrayA} or {@code arrayB} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param arrayA a {@code long[]}
	 * @param arrayB a {@code long[]}
	 * @return {@code true} if, and only if, the elements of {@code arrayA} are equal to the elements of {@code arrayB}, {@code false} otherwise
	 * @throws NullPointerException thrown if, and only if, either {@code arrayA} or {@code arrayB} are {@code null}
	 */
	public static boolean equals(final long[] arrayA, final long[] arrayB) {
		Objects.requireNonNull(arrayA, "arrayA == null");
		Objects.requireNonNull(arrayB, "arrayB == null");
		
		if(arrayA == arrayB) {
			return true;
		} else if(arrayA.length != arrayB.length) {
			return false;
		} else {
			for(int i = 0; i < arrayA.length; i++) {
				if(arrayA[i] != arrayB[i]) {
					return false;
				}
			}
			
			return true;
		}
	}
	
	/**
	 * Returns {@code true} if, and only if, the elements of {@code arrayA} starting at {@code offsetArrayA} are equal to the elements of {@code arrayB} starting at {@code offsetArrayB}, {@code false} otherwise.
	 * <p>
	 * If either {@code arrayA} or {@code arrayB} are {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If {@code offsetArrayA} is less than {@code 0} or greater than or equal to {@code arrayA.length}, {@code offsetArrayB} is less than {@code 0} or greater than or equal to {@code arrayB.length}, {@code length} is less than {@code 0}, {@code offsetArrayA + length} is less than {@code 0} or greater than {@code arrayA.length} or {@code offsetArrayB + length} is less than {@code 0} or greater than {@code arrayB.length}, an {@code IllegalArgumentException} will be thrown.
	 * 
	 * @param arrayA a {@code long[]}
	 * @param arrayB a {@code long[]}
	 * @param offsetArrayA the offset to start at in {@code arrayA}
	 * @param offsetArrayB the offset to start at in {@code arrayB}
	 * @param length the length of the sub-arrays to test for equality
	 * @return {@code true} if, and only if, the elements of {@code arrayA} starting at {@code offsetArrayA} are equal to the elements of {@code arrayB} starting at {@code offsetArrayB}, {@code false} otherwise
	 * @throws IllegalArgumentException thrown if, and only if, {@code offsetArrayA} is less than {@code 0} or greater than or equal to {@code arrayA.length}, {@code offsetArrayB} is less than {@code 0} or greater than or equal to {@code arrayB.length}, {@code length} is less than {@code 0}, {@code offsetArrayA + length} is less than {@code 0} or greater than {@code arrayA.length} or {@code offsetArrayB + length} is less than {@code 0} or greater than {@code arrayB.length}
	 * @throws NullPointerException thrown if, and only if, either {@code arrayA} or {@code arrayB} are {@code null}
	 */
	public static boolean equals(final long[] arrayA, final long[] arrayB, final int offsetArrayA, final int offsetArrayB, final int length) {
		Objects.requireNonNull(arrayA, "arrayA == null");
		Objects.requireNonNull(arrayB, "arrayB == null");
		
		doRequireRange(offsetArrayA, 0, arrayA.length - 1, "offsetArrayA");
		doRequireRange(offsetArrayB, 0, arrayB.length - 1, "offsetArrayB");
		doRequireRange(length, 0, Integer.MAX_VALUE, "length");
		doRequireRange(offsetArrayA + length, 0, arrayA.length, "offsetArrayA + length");
		doRequireRange(offsetArrayB + length, 0, arrayB.length, "offsetArrayB + length");
		
		for(int i = 0; i < length; i++) {
			if(arrayA[offsetArrayA + i] != arrayB[offsetArrayB + i]) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Returns {@code true} if, and only if, the elements of {@code arrayA} are equal to the elements of {@code arrayB}, {@code false} otherwise.
	 * <p>
	 * If either {@code arrayA} or {@code arrayB} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param arrayA a {@code short[]}
	 * @param arrayB a {@code short[]}
	 * @return {@code true} if, and only if, the elements of {@code arrayA} are equal to the elements of {@code arrayB}, {@code false} otherwise
	 * @throws NullPointerException thrown if, and only if, either {@code arrayA} or {@code arrayB} are {@code null}
	 */
	public static boolean equals(final short[] arrayA, final short[] arrayB) {
		Objects.requireNonNull(arrayA, "arrayA == null");
		Objects.requireNonNull(arrayB, "arrayB == null");
		
		if(arrayA == arrayB) {
			return true;
		} else if(arrayA.length != arrayB.length) {
			return false;
		} else {
			for(int i = 0; i < arrayA.length; i++) {
				if(arrayA[i] != arrayB[i]) {
					return false;
				}
			}
			
			return true;
		}
	}
	
	/**
	 * Returns {@code true} if, and only if, the elements of {@code arrayA} starting at {@code offsetArrayA} are equal to the elements of {@code arrayB} starting at {@code offsetArrayB}, {@code false} otherwise.
	 * <p>
	 * If either {@code arrayA} or {@code arrayB} are {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If {@code offsetArrayA} is less than {@code 0} or greater than or equal to {@code arrayA.length}, {@code offsetArrayB} is less than {@code 0} or greater than or equal to {@code arrayB.length}, {@code length} is less than {@code 0}, {@code offsetArrayA + length} is less than {@code 0} or greater than {@code arrayA.length} or {@code offsetArrayB + length} is less than {@code 0} or greater than {@code arrayB.length}, an {@code IllegalArgumentException} will be thrown.
	 * 
	 * @param arrayA a {@code short[]}
	 * @param arrayB a {@code short[]}
	 * @param offsetArrayA the offset to start at in {@code arrayA}
	 * @param offsetArrayB the offset to start at in {@code arrayB}
	 * @param length the length of the sub-arrays to test for equality
	 * @return {@code true} if, and only if, the elements of {@code arrayA} starting at {@code offsetArrayA} are equal to the elements of {@code arrayB} starting at {@code offsetArrayB}, {@code false} otherwise
	 * @throws IllegalArgumentException thrown if, and only if, {@code offsetArrayA} is less than {@code 0} or greater than or equal to {@code arrayA.length}, {@code offsetArrayB} is less than {@code 0} or greater than or equal to {@code arrayB.length}, {@code length} is less than {@code 0}, {@code offsetArrayA + length} is less than {@code 0} or greater than {@code arrayA.length} or {@code offsetArrayB + length} is less than {@code 0} or greater than {@code arrayB.length}
	 * @throws NullPointerException thrown if, and only if, either {@code arrayA} or {@code arrayB} are {@code null}
	 */
	public static boolean equals(final short[] arrayA, final short[] arrayB, final int offsetArrayA, final int offsetArrayB, final int length) {
		Objects.requireNonNull(arrayA, "arrayA == null");
		Objects.requireNonNull(arrayB, "arrayB == null");
		
		doRequireRange(offsetArrayA, 0, arrayA.length - 1, "offsetArrayA");
		doRequireRange(offsetArrayB, 0, arrayB.length - 1, "offsetArrayB");
		doRequireRange(length, 0, Integer.MAX_VALUE, "length");
		doRequireRange(offsetArrayA + length, 0, arrayA.length, "offsetArrayA + length");
		doRequireRange(offsetArrayB + length, 0, arrayB.length, "offsetArrayB + length");
		
		for(int i = 0; i < length; i++) {
			if(arrayA[offsetArrayA + i] != arrayB[offsetArrayB + i]) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Returns a {@code boolean[]} with a length of {@code length} and elements generated by {@code function}.
	 * <p>
	 * If {@code length} is less than {@code 0}, an {@code IllegalArgumentException} will be thrown.
	 * <p>
	 * If {@code function} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param length the length of the {@code boolean[]}
	 * @param function an {@link IntToBooleanFunction} that generates the elements and takes the current index as parameter
	 * @return a {@code boolean[]} with a length of {@code length} and elements generated by {@code function}
	 * @throws IllegalArgumentException thrown if, and only if, {@code length} is less than {@code 0}
	 * @throws NullPointerException thrown if, and only if, {@code function} is {@code null}
	 */
	public static boolean[] generateBooleanArray(final int length, final IntToBooleanFunction function) {
		doRequireRange(length, 0, Integer.MAX_VALUE, "length");
		
		Objects.requireNonNull(function, "function == null");
		
		final boolean[] array = new boolean[length];
		
		for(int i = 0; i < length; i++) {
			array[i] = function.applyAsBoolean(i);
		}
		
		return array;
	}
	
	/**
	 * Performs a merge operation on the {@code boolean[]} instances in {@code arrays}.
	 * <p>
	 * Returns a new {@code boolean[]} with {@code arrays} merged.
	 * <p>
	 * If either {@code arrays} or at least one of its elements are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param arrays the {@code boolean[][]} instance to combine into one {@code boolean[]}
	 * @return a new {@code boolean[]} with {@code arrays} merged
	 * @throws NullPointerException thrown if, and only if, either {@code arrays} or at least one of its elements are {@code null}
	 */
	public static boolean[] merge(final boolean[]... arrays) {
		requireNonNull(arrays, "arrays");
		
		try(final BooleanArrayOutputStream booleanArrayOutputStream = new BooleanArrayOutputStream()) {
			for(final boolean[] array : arrays) {
				booleanArrayOutputStream.write(array);
			}
			
			return booleanArrayOutputStream.toBooleanArray();
		}
	}
	
	/**
	 * Returns a {@code boolean[]} with {@code array} repeated {@code repetition} times.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If {@code repetition} is less than {@code 0} or {@code array.length * repetition} overflows, an {@code IllegalArgumentException} will be thrown.
	 * 
	 * @param array the {@code boolean[]} to repeat {@code repetition} times
	 * @param repetition the number of times to repeat {@code array}
	 * @return a {@code boolean[]} with {@code array} repeated {@code repetition} times
	 * @throws IllegalArgumentException thrown if, and only if, {@code repetition} is less than {@code 0} or {@code array.length * repetition} overflows
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static boolean[] repeat(final boolean[] array, final int repetition) {
		Objects.requireNonNull(array, "array == null");
		
		doRequireRange(repetition, 0, Integer.MAX_VALUE, "repetition");
		
		if(array.length == 0 || repetition == 0) {
			return new boolean[0];
		} else if(array.length == 1) {
			final boolean[] repeatedArray = new boolean[repetition];
			
			final boolean element = array[0];
			
			for(int i = 0; i < repetition; i++) {
				repeatedArray[i] = element;
			}
			
			return repeatedArray;
		} else {
			try {
				final boolean[] repeatedArray = new boolean[Math.multiplyExact(repetition, array.length)];
				
				for(int i = 0; i < repetition; i++) {
					System.arraycopy(array, 0, repeatedArray, i * array.length, array.length);
				}
				
				return repeatedArray;
			} catch(final ArithmeticException e) {
				throw new IllegalArgumentException(e);
			}
		}
	}
	
	/**
	 * Performs a splice operation on the {@code boolean[]} instance {@code array}.
	 * <p>
	 * Returns a new {@code boolean[]} with the result of the operation.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * Arrays.splice(array, offset, array.length);
	 * }
	 * </pre>
	 * 
	 * @param array the input {@code boolean[]}
	 * @param offset the offset for the removal, which may be negative
	 * @return a new {@code boolean[]} with the result of the operation
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static boolean[] splice(final boolean[] array, final int offset) {
		return splice(array, offset, array.length);
	}
	
	/**
	 * Performs a splice operation on the {@code boolean[]} instance {@code array}.
	 * <p>
	 * Returns a new {@code boolean[]} with the result of the operation.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * Arrays.splice(array, offset, length, new boolean[0]);
	 * }
	 * </pre>
	 * 
	 * @param array the input {@code boolean[]}
	 * @param offset the offset for the removal, which may be negative
	 * @param length the length of the removal, which may be negative
	 * @return a new {@code boolean[]} with the result of the operation
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static boolean[] splice(final boolean[] array, final int offset, final int length) {
		return splice(array, offset, length, new boolean[0]);
	}
	
	/**
	 * Performs a splice operation on the {@code boolean[]} instance {@code array}.
	 * <p>
	 * Returns a new {@code boolean[]} with the result of the operation.
	 * <p>
	 * If either {@code array} or {@code arrayReplacement} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param array the input {@code boolean[]}
	 * @param offset the offset for the removal, which may be negative
	 * @param length the length of the removal, which may be negative
	 * @param arrayReplacement a {@code boolean[]} that acts as replacement
	 * @return a new {@code boolean[]} with the result of the operation
	 * @throws NullPointerException thrown if, and only if, either {@code array} or {@code arrayReplacement} are {@code null}
	 */
	public static boolean[] splice(final boolean[] array, final int offset, final int length, final boolean[] arrayReplacement) {
		Objects.requireNonNull(array, "array == null");
		Objects.requireNonNull(arrayReplacement, "arrayReplacement == null");
		
		final boolean[] arrayA = array;
		final boolean[] arrayB = arrayReplacement;
		final boolean[] arrayC = array;
		
		final int arrayASrcPos = 0;
		final int arrayALength = doSaturate(offset >= 0 ? offset : arrayA.length + offset, 0, arrayA.length);
		
		final int arrayBSrcPos = 0;
		final int arrayBLength = arrayB.length;
		
		final int arrayCSrcPos = doSaturate(length >= 0 ? length + arrayALength : arrayC.length + length, arrayALength, arrayC.length);
		final int arrayCLength = arrayC.length - arrayCSrcPos;
		
		final int arrayDSrcPos0 = 0;
		final int arrayDSrcPos1 = arrayALength;
		final int arrayDSrcPos2 = arrayALength + arrayBLength;
		final int arrayDLength  = arrayA.length - (arrayCSrcPos - arrayALength) + arrayBLength;
		
		final boolean[] arrayD = new boolean[arrayDLength];
		
		System.arraycopy(arrayA, arrayASrcPos, arrayD, arrayDSrcPos0, arrayALength);
		System.arraycopy(arrayB, arrayBSrcPos, arrayD, arrayDSrcPos1, arrayBLength);
		System.arraycopy(arrayC, arrayCSrcPos, arrayD, arrayDSrcPos2, arrayCLength);
		
		return arrayD;
	}
	
	/**
	 * Returns a {@code boolean[]} representation of {@code objects} using {@code arrayFunction} as a converter.
	 * <p>
	 * If either {@code objects}, at least one of its elements, {@code arrayFunction} or at least one of its results are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param <T> the generic type
	 * @param objects a {@code List} of type {@code T} with {@code Object} instances to convert into {@code boolean[]} instances
	 * @param arrayFunction a {@code Function} that maps {@code Object} instances of type {@code T} into {@code boolean[]} instances
	 * @return a {@code boolean[]} representation of {@code objects} using {@code arrayFunction} as a converter
	 * @throws NullPointerException thrown if, and only if, either {@code objects}, at least one of its elements, {@code arrayFunction} or at least one of its results are {@code null}
	 */
	public static <T> boolean[] toBooleanArray(final List<T> objects, final Function<T, boolean[]> arrayFunction) {
		doRequireNonNullList(objects, "objects");
		
		Objects.requireNonNull(arrayFunction, "arrayFunction == null");
		
		if(objects.isEmpty()) {
			return new boolean[0];
		}
		
		try(final BooleanArrayOutputStream booleanArrayOutputStream = new BooleanArrayOutputStream()) {
			for(final T object : objects) {
				booleanArrayOutputStream.write(arrayFunction.apply(object));
			}
			
			return booleanArrayOutputStream.toBooleanArray();
		}
	}
	
	/**
	 * Checks that {@code arrays} and all of its elements are not {@code null}.
	 * <p>
	 * Returns {@code arrays}.
	 * <p>
	 * If either {@code arrays}, an element in {@code arrays} or {@code name} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param arrays the {@code boolean[][]} to check
	 * @param name the name of the parameter used for {@code arrays}, that will be part of the message to the {@code NullPointerException}
	 * @return {@code arrays}
	 * @throws NullPointerException thrown if, and only if, either {@code arrays}, an element in {@code arrays} or {@code name} are {@code null}
	 */
	public static boolean[][] requireNonNull(final boolean[][] arrays, final String name) {
		Objects.requireNonNull(name, "name == null");
		
		if(arrays == null) {
			throw new NullPointerException(String.format("%s == null", name));
		}
		
		for(int i = 0; i < arrays.length; i++) {
			if(arrays[i] == null) {
				throw new NullPointerException(String.format("%s[%d] == null", name, Integer.valueOf(i)));
			}
		}
		
		return arrays;
	}
	
	/**
	 * Returns a {@code byte[]} with a length of {@code length} and elements generated by {@code function}.
	 * <p>
	 * If {@code length} is less than {@code 0}, an {@code IllegalArgumentException} will be thrown.
	 * <p>
	 * If {@code function} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param length the length of the {@code byte[]}
	 * @param function an {@link IntToByteFunction} that generates the elements and takes the current index as parameter
	 * @return a {@code byte[]} with a length of {@code length} and elements generated by {@code function}
	 * @throws IllegalArgumentException thrown if, and only if, {@code length} is less than {@code 0}
	 * @throws NullPointerException thrown if, and only if, {@code function} is {@code null}
	 */
	public static byte[] generateByteArray(final int length, final IntToByteFunction function) {
		doRequireRange(length, 0, Integer.MAX_VALUE, "length");
		
		Objects.requireNonNull(function, "function == null");
		
		final byte[] array = new byte[length];
		
		for(int i = 0; i < length; i++) {
			array[i] = function.applyAsByte(i);
		}
		
		return array;
	}
	
	/**
	 * Performs a merge operation on the {@code byte[]} instances in {@code arrays}.
	 * <p>
	 * Returns a new {@code byte[]} with {@code arrays} merged.
	 * <p>
	 * If either {@code arrays} or at least one of its elements are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param arrays the {@code byte[][]} instance to combine into one {@code byte[]}
	 * @return a new {@code byte[]} with {@code arrays} merged
	 * @throws NullPointerException thrown if, and only if, either {@code arrays} or at least one of its elements are {@code null}
	 */
	public static byte[] merge(final byte[]... arrays) {
		/*
		 * Use of try-with-resources would require a catch-clause for IOException that will never be called.
		 * This would result in less than 100% code coverage for the unit tests.
		 * Eclipse has a whitelist for classes that does not have a resource leak. This list includes ByteArrayOutputStream.
		 * Without this whitelist entry, a resource leak warning would have been shown for the code below.
		 */
		
		requireNonNull(arrays, "arrays");
		
		final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
		for(final byte[] array : arrays) {
			byteArrayOutputStream.write(array, 0, array.length);
		}
		
		return byteArrayOutputStream.toByteArray();
	}
	
	/**
	 * Returns a {@code byte[]} with {@code array} repeated {@code repetition} times.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If {@code repetition} is less than {@code 0} or {@code array.length * repetition} overflows, an {@code IllegalArgumentException} will be thrown.
	 * 
	 * @param array the {@code byte[]} to repeat {@code repetition} times
	 * @param repetition the number of times to repeat {@code array}
	 * @return a {@code byte[]} with {@code array} repeated {@code repetition} times
	 * @throws IllegalArgumentException thrown if, and only if, {@code repetition} is less than {@code 0} or {@code array.length * repetition} overflows
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static byte[] repeat(final byte[] array, final int repetition) {
		Objects.requireNonNull(array, "array == null");
		
		doRequireRange(repetition, 0, Integer.MAX_VALUE, "repetition");
		
		if(array.length == 0 || repetition == 0) {
			return new byte[0];
		} else if(array.length == 1) {
			final byte[] repeatedArray = new byte[repetition];
			
			final byte element = array[0];
			
			for(int i = 0; i < repetition; i++) {
				repeatedArray[i] = element;
			}
			
			return repeatedArray;
		} else {
			try {
				final byte[] repeatedArray = new byte[Math.multiplyExact(repetition, array.length)];
				
				for(int i = 0; i < repetition; i++) {
					System.arraycopy(array, 0, repeatedArray, i * array.length, array.length);
				}
				
				return repeatedArray;
			} catch(final ArithmeticException e) {
				throw new IllegalArgumentException(e);
			}
		}
	}
	
	/**
	 * Performs a splice operation on the {@code byte[]} instance {@code array}.
	 * <p>
	 * Returns a new {@code byte[]} with the result of the operation.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * Arrays.splice(array, offset, array.length);
	 * }
	 * </pre>
	 * 
	 * @param array the input {@code byte[]}
	 * @param offset the offset for the removal, which may be negative
	 * @return a new {@code byte[]} with the result of the operation
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static byte[] splice(final byte[] array, final int offset) {
		return splice(array, offset, array.length);
	}
	
	/**
	 * Performs a splice operation on the {@code byte[]} instance {@code array}.
	 * <p>
	 * Returns a new {@code byte[]} with the result of the operation.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * Arrays.splice(array, offset, length, new byte[0]);
	 * }
	 * </pre>
	 * 
	 * @param array the input {@code byte[]}
	 * @param offset the offset for the removal, which may be negative
	 * @param length the length of the removal, which may be negative
	 * @return a new {@code byte[]} with the result of the operation
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static byte[] splice(final byte[] array, final int offset, final int length) {
		return splice(array, offset, length, new byte[0]);
	}
	
	/**
	 * Performs a splice operation on the {@code byte[]} instance {@code array}.
	 * <p>
	 * Returns a new {@code byte[]} with the result of the operation.
	 * <p>
	 * If either {@code array} or {@code arrayReplacement} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param array the input {@code byte[]}
	 * @param offset the offset for the removal, which may be negative
	 * @param length the length of the removal, which may be negative
	 * @param arrayReplacement a {@code byte[]} that acts as replacement
	 * @return a new {@code byte[]} with the result of the operation
	 * @throws NullPointerException thrown if, and only if, either {@code array} or {@code arrayReplacement} are {@code null}
	 */
	public static byte[] splice(final byte[] array, final int offset, final int length, final byte[] arrayReplacement) {
		Objects.requireNonNull(array, "array == null");
		Objects.requireNonNull(arrayReplacement, "arrayReplacement == null");
		
		final byte[] arrayA = array;
		final byte[] arrayB = arrayReplacement;
		final byte[] arrayC = array;
		
		final int arrayASrcPos = 0;
		final int arrayALength = doSaturate(offset >= 0 ? offset : arrayA.length + offset, 0, arrayA.length);
		
		final int arrayBSrcPos = 0;
		final int arrayBLength = arrayB.length;
		
		final int arrayCSrcPos = doSaturate(length >= 0 ? length + arrayALength : arrayC.length + length, arrayALength, arrayC.length);
		final int arrayCLength = arrayC.length - arrayCSrcPos;
		
		final int arrayDSrcPos0 = 0;
		final int arrayDSrcPos1 = arrayALength;
		final int arrayDSrcPos2 = arrayALength + arrayBLength;
		final int arrayDLength  = arrayA.length - (arrayCSrcPos - arrayALength) + arrayBLength;
		
		final byte[] arrayD = new byte[arrayDLength];
		
		System.arraycopy(arrayA, arrayASrcPos, arrayD, arrayDSrcPos0, arrayALength);
		System.arraycopy(arrayB, arrayBSrcPos, arrayD, arrayDSrcPos1, arrayBLength);
		System.arraycopy(arrayC, arrayCSrcPos, arrayD, arrayDSrcPos2, arrayCLength);
		
		return arrayD;
	}
	
	/**
	 * Returns a {@code byte[]} representation of {@code objects} using {@code arrayFunction} as a converter.
	 * <p>
	 * If either {@code objects}, at least one of its elements, {@code arrayFunction} or at least one of its results are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param <T> the generic type
	 * @param objects a {@code List} of type {@code T} with {@code Object} instances to convert into {@code byte[]} instances
	 * @param arrayFunction a {@code Function} that maps {@code Object} instances of type {@code T} into {@code byte[]} instances
	 * @return a {@code boolean[]} representation of {@code objects} using {@code arrayFunction} as a converter
	 * @throws NullPointerException thrown if, and only if, either {@code objects}, at least one of its elements, {@code arrayFunction} or at least one of its results are {@code null}
	 */
	public static <T> byte[] toByteArray(final List<T> objects, final Function<T, byte[]> arrayFunction) {
		doRequireNonNullList(objects, "objects");
		
		Objects.requireNonNull(arrayFunction, "arrayFunction == null");
		
		if(objects.isEmpty()) {
			return new byte[0];
		}
		
		final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
		for(final T object : objects) {
			final byte[] array = arrayFunction.apply(object);
			
			byteArrayOutputStream.write(array, 0, array.length);
		}
		
		return byteArrayOutputStream.toByteArray();
	}
	
	/**
	 * Returns a {@code byte[]} representation of {@code booleanArray}.
	 * <p>
	 * If {@code booleanArray} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param booleanArray a {@code boolean[]}
	 * @return a {@code byte[]} representation of {@code booleanArray}
	 * @throws NullPointerException thrown if, and only if, {@code booleanArray} is {@code null}
	 */
	public static byte[] toByteArray(final boolean[] booleanArray) {
		Objects.requireNonNull(booleanArray, "booleanArray == null");
		
		final byte[] byteArray = new byte[booleanArray.length];
		
		for(int i = 0; i < byteArray.length; i++) {
			byteArray[i] = (byte)(booleanArray[i] ? 1 : 0);
		}
		
		return byteArray;
	}
	
	/**
	 * Returns a {@code byte[]} representation of {@code charArray}.
	 * <p>
	 * If {@code charArray} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param charArray a {@code char[]}
	 * @return a {@code byte[]} representation of {@code charArray}
	 * @throws NullPointerException thrown if, and only if, {@code charArray} is {@code null}
	 */
	public static byte[] toByteArray(final char[] charArray) {
		Objects.requireNonNull(charArray, "charArray == null");
		
		final byte[] byteArray = new byte[charArray.length];
		
		for(int i = 0; i < byteArray.length; i++) {
			byteArray[i] = (byte)(charArray[i]);
		}
		
		return byteArray;
	}
	
	/**
	 * Returns a {@code byte[]} representation of {@code doubleArray}.
	 * <p>
	 * If {@code doubleArray} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param doubleArray a {@code double[]}
	 * @return a {@code byte[]} representation of {@code doubleArray}
	 * @throws NullPointerException thrown if, and only if, {@code doubleArray} is {@code null}
	 */
	public static byte[] toByteArray(final double[] doubleArray) {
		Objects.requireNonNull(doubleArray, "doubleArray == null");
		
		final byte[] byteArray = new byte[doubleArray.length];
		
		for(int i = 0; i < byteArray.length; i++) {
			byteArray[i] = (byte)(doubleArray[i]);
		}
		
		return byteArray;
	}
	
	/**
	 * Returns a {@code byte[]} representation of {@code floatArray}.
	 * <p>
	 * If {@code floatArray} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param floatArray a {@code float[]}
	 * @return a {@code byte[]} representation of {@code floatArray}
	 * @throws NullPointerException thrown if, and only if, {@code floatArray} is {@code null}
	 */
	public static byte[] toByteArray(final float[] floatArray) {
		Objects.requireNonNull(floatArray, "floatArray == null");
		
		final byte[] byteArray = new byte[floatArray.length];
		
		for(int i = 0; i < byteArray.length; i++) {
			byteArray[i] = (byte)(floatArray[i]);
		}
		
		return byteArray;
	}
	
	/**
	 * Returns a {@code byte[]} representation of {@code intArray}.
	 * <p>
	 * If {@code intArray} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param intArray an {@code int[]}
	 * @return a {@code byte[]} representation of {@code intArray}
	 * @throws NullPointerException thrown if, and only if, {@code intArray} is {@code null}
	 */
	public static byte[] toByteArray(final int[] intArray) {
		Objects.requireNonNull(intArray, "intArray == null");
		
		final byte[] byteArray = new byte[intArray.length];
		
		for(int i = 0; i < byteArray.length; i++) {
			byteArray[i] = (byte)(intArray[i]);
		}
		
		return byteArray;
	}
	
	/**
	 * Returns a {@code byte[]} representation of {@code longArray}.
	 * <p>
	 * If {@code longArray} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param longArray a {@code long[]}
	 * @return a {@code byte[]} representation of {@code longArray}
	 * @throws NullPointerException thrown if, and only if, {@code longArray} is {@code null}
	 */
	public static byte[] toByteArray(final long[] longArray) {
		Objects.requireNonNull(longArray, "longArray == null");
		
		final byte[] byteArray = new byte[longArray.length];
		
		for(int i = 0; i < byteArray.length; i++) {
			byteArray[i] = (byte)(longArray[i]);
		}
		
		return byteArray;
	}
	
	/**
	 * Returns a {@code byte[]} representation of {@code shortArray}.
	 * <p>
	 * If {@code shortArray} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param shortArray a {@code short[]}
	 * @return a {@code byte[]} representation of {@code shortArray}
	 * @throws NullPointerException thrown if, and only if, {@code shortArray} is {@code null}
	 */
	public static byte[] toByteArray(final short[] shortArray) {
		Objects.requireNonNull(shortArray, "shortArray == null");
		
		final byte[] byteArray = new byte[shortArray.length];
		
		for(int i = 0; i < byteArray.length; i++) {
			byteArray[i] = (byte)(shortArray[i]);
		}
		
		return byteArray;
	}
	
	/**
	 * Checks that {@code arrays} and all of its elements are not {@code null}.
	 * <p>
	 * Returns {@code arrays}.
	 * <p>
	 * If either {@code arrays}, an element in {@code arrays} or {@code name} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param arrays the {@code byte[][]} to check
	 * @param name the name of the parameter used for {@code arrays}, that will be part of the message to the {@code NullPointerException}
	 * @return {@code arrays}
	 * @throws NullPointerException thrown if, and only if, either {@code arrays}, an element in {@code arrays} or {@code name} are {@code null}
	 */
	public static byte[][] requireNonNull(final byte[][] arrays, final String name) {
		Objects.requireNonNull(name, "name == null");
		
		if(arrays == null) {
			throw new NullPointerException(String.format("%s == null", name));
		}
		
		for(int i = 0; i < arrays.length; i++) {
			if(arrays[i] == null) {
				throw new NullPointerException(String.format("%s[%d] == null", name, Integer.valueOf(i)));
			}
		}
		
		return arrays;
	}
	
	/**
	 * Returns a {@code char[]} with a length of {@code length} and elements generated by {@code function}.
	 * <p>
	 * If {@code length} is less than {@code 0}, an {@code IllegalArgumentException} will be thrown.
	 * <p>
	 * If {@code function} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param length the length of the {@code char[]}
	 * @param function an {@link IntToCharFunction} that generates the elements and takes the current index as parameter
	 * @return a {@code char[]} with a length of {@code length} and elements generated by {@code function}
	 * @throws IllegalArgumentException thrown if, and only if, {@code length} is less than {@code 0}
	 * @throws NullPointerException thrown if, and only if, {@code function} is {@code null}
	 */
	public static char[] generateCharArray(final int length, final IntToCharFunction function) {
		doRequireRange(length, 0, Integer.MAX_VALUE, "length");
		
		Objects.requireNonNull(function, "function == null");
		
		final char[] array = new char[length];
		
		for(int i = 0; i < length; i++) {
			array[i] = function.applyAsChar(i);
		}
		
		return array;
	}
	
	/**
	 * Performs a merge operation on the {@code char[]} instances in {@code arrays}.
	 * <p>
	 * Returns a new {@code char[]} with {@code arrays} merged.
	 * <p>
	 * If either {@code arrays} or at least one of its elements are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param arrays the {@code char[][]} instance to combine into one {@code char[]}
	 * @return a new {@code char[]} with {@code arrays} merged
	 * @throws NullPointerException thrown if, and only if, either {@code arrays} or at least one of its elements are {@code null}
	 */
	public static char[] merge(final char[]... arrays) {
		requireNonNull(arrays, "arrays");
		
		try(final CharArrayOutputStream charArrayOutputStream = new CharArrayOutputStream()) {
			for(final char[] array : arrays) {
				charArrayOutputStream.write(array);
			}
			
			return charArrayOutputStream.toCharArray();
		}
	}
	
	/**
	 * Returns a {@code char[]} with {@code array} repeated {@code repetition} times.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If {@code repetition} is less than {@code 0} or {@code array.length * repetition} overflows, an {@code IllegalArgumentException} will be thrown.
	 * 
	 * @param array the {@code char[]} to repeat {@code repetition} times
	 * @param repetition the number of times to repeat {@code array}
	 * @return a {@code char[]} with {@code array} repeated {@code repetition} times
	 * @throws IllegalArgumentException thrown if, and only if, {@code repetition} is less than {@code 0} or {@code array.length * repetition} overflows
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static char[] repeat(final char[] array, final int repetition) {
		Objects.requireNonNull(array, "array == null");
		
		doRequireRange(repetition, 0, Integer.MAX_VALUE, "repetition");
		
		if(array.length == 0 || repetition == 0) {
			return new char[0];
		} else if(array.length == 1) {
			final char[] repeatedArray = new char[repetition];
			
			final char element = array[0];
			
			for(int i = 0; i < repetition; i++) {
				repeatedArray[i] = element;
			}
			
			return repeatedArray;
		} else {
			try {
				final char[] repeatedArray = new char[Math.multiplyExact(repetition, array.length)];
				
				for(int i = 0; i < repetition; i++) {
					System.arraycopy(array, 0, repeatedArray, i * array.length, array.length);
				}
				
				return repeatedArray;
			} catch(final ArithmeticException e) {
				throw new IllegalArgumentException(e);
			}
		}
	}
	
	/**
	 * Performs a splice operation on the {@code char[]} instance {@code array}.
	 * <p>
	 * Returns a new {@code char[]} with the result of the operation.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * Arrays.splice(array, offset, array.length);
	 * }
	 * </pre>
	 * 
	 * @param array the input {@code char[]}
	 * @param offset the offset for the removal, which may be negative
	 * @return a new {@code char[]} with the result of the operation
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static char[] splice(final char[] array, final int offset) {
		return splice(array, offset, array.length);
	}
	
	/**
	 * Performs a splice operation on the {@code char[]} instance {@code array}.
	 * <p>
	 * Returns a new {@code char[]} with the result of the operation.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * Arrays.splice(array, offset, length, new char[0]);
	 * }
	 * </pre>
	 * 
	 * @param array the input {@code char[]}
	 * @param offset the offset for the removal, which may be negative
	 * @param length the length of the removal, which may be negative
	 * @return a new {@code char[]} with the result of the operation
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static char[] splice(final char[] array, final int offset, final int length) {
		return splice(array, offset, length, new char[0]);
	}
	
	/**
	 * Performs a splice operation on the {@code char[]} instance {@code array}.
	 * <p>
	 * Returns a new {@code char[]} with the result of the operation.
	 * <p>
	 * If either {@code array} or {@code arrayReplacement} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param array the input {@code char[]}
	 * @param offset the offset for the removal, which may be negative
	 * @param length the length of the removal, which may be negative
	 * @param arrayReplacement a {@code char[]} that acts as replacement
	 * @return a new {@code char[]} with the result of the operation
	 * @throws NullPointerException thrown if, and only if, either {@code array} or {@code arrayReplacement} are {@code null}
	 */
	public static char[] splice(final char[] array, final int offset, final int length, final char[] arrayReplacement) {
		Objects.requireNonNull(array, "array == null");
		Objects.requireNonNull(arrayReplacement, "arrayReplacement == null");
		
		final char[] arrayA = array;
		final char[] arrayB = arrayReplacement;
		final char[] arrayC = array;
		
		final int arrayASrcPos = 0;
		final int arrayALength = doSaturate(offset >= 0 ? offset : arrayA.length + offset, 0, arrayA.length);
		
		final int arrayBSrcPos = 0;
		final int arrayBLength = arrayB.length;
		
		final int arrayCSrcPos = doSaturate(length >= 0 ? length + arrayALength : arrayC.length + length, arrayALength, arrayC.length);
		final int arrayCLength = arrayC.length - arrayCSrcPos;
		
		final int arrayDSrcPos0 = 0;
		final int arrayDSrcPos1 = arrayALength;
		final int arrayDSrcPos2 = arrayALength + arrayBLength;
		final int arrayDLength  = arrayA.length - (arrayCSrcPos - arrayALength) + arrayBLength;
		
		final char[] arrayD = new char[arrayDLength];
		
		System.arraycopy(arrayA, arrayASrcPos, arrayD, arrayDSrcPos0, arrayALength);
		System.arraycopy(arrayB, arrayBSrcPos, arrayD, arrayDSrcPos1, arrayBLength);
		System.arraycopy(arrayC, arrayCSrcPos, arrayD, arrayDSrcPos2, arrayCLength);
		
		return arrayD;
	}
	
	/**
	 * Returns a {@code char[]} representation of {@code objects} using {@code arrayFunction} as a converter.
	 * <p>
	 * If either {@code objects}, at least one of its elements, {@code arrayFunction} or at least one of its results are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param <T> the generic type
	 * @param objects a {@code List} of type {@code T} with {@code Object} instances to convert into {@code char[]} instances
	 * @param arrayFunction a {@code Function} that maps {@code Object} instances of type {@code T} into {@code char[]} instances
	 * @return a {@code char[]} representation of {@code objects} using {@code arrayFunction} as a converter
	 * @throws NullPointerException thrown if, and only if, either {@code objects}, at least one of its elements, {@code arrayFunction} or at least one of its results are {@code null}
	 */
	public static <T> char[] toCharArray(final List<T> objects, final Function<T, char[]> arrayFunction) {
		doRequireNonNullList(objects, "objects");
		
		Objects.requireNonNull(arrayFunction, "arrayFunction == null");
		
		if(objects.isEmpty()) {
			return new char[0];
		}
		
		try(final CharArrayOutputStream charArrayOutputStream = new CharArrayOutputStream()) {
			for(final T object : objects) {
				charArrayOutputStream.write(arrayFunction.apply(object));
			}
			
			return charArrayOutputStream.toCharArray();
		}
	}
	
	/**
	 * Checks that {@code arrays} and all of its elements are not {@code null}.
	 * <p>
	 * Returns {@code arrays}.
	 * <p>
	 * If either {@code arrays}, an element in {@code arrays} or {@code name} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param arrays the {@code char[][]} to check
	 * @param name the name of the parameter used for {@code arrays}, that will be part of the message to the {@code NullPointerException}
	 * @return {@code arrays}
	 * @throws NullPointerException thrown if, and only if, either {@code arrays}, an element in {@code arrays} or {@code name} are {@code null}
	 */
	public static char[][] requireNonNull(final char[][] arrays, final String name) {
		Objects.requireNonNull(name, "name == null");
		
		if(arrays == null) {
			throw new NullPointerException(String.format("%s == null", name));
		}
		
		for(int i = 0; i < arrays.length; i++) {
			if(arrays[i] == null) {
				throw new NullPointerException(String.format("%s[%d] == null", name, Integer.valueOf(i)));
			}
		}
		
		return arrays;
	}
	
	/**
	 * Returns a {@code double[]} with a length of {@code length} and elements generated by {@code function}.
	 * <p>
	 * If {@code length} is less than {@code 0}, an {@code IllegalArgumentException} will be thrown.
	 * <p>
	 * If {@code function} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param length the length of the {@code double[]}
	 * @param function an {@code IntToDoubleFunction} that generates the elements and takes the current index as parameter
	 * @return a {@code double[]} with a length of {@code length} and elements generated by {@code function}
	 * @throws IllegalArgumentException thrown if, and only if, {@code length} is less than {@code 0}
	 * @throws NullPointerException thrown if, and only if, {@code function} is {@code null}
	 */
	public static double[] generateDoubleArray(final int length, final IntToDoubleFunction function) {
		doRequireRange(length, 0, Integer.MAX_VALUE, "length");
		
		Objects.requireNonNull(function, "function == null");
		
		final double[] array = new double[length];
		
		for(int i = 0; i < length; i++) {
			array[i] = function.applyAsDouble(i);
		}
		
		return array;
	}
	
	/**
	 * Performs a merge operation on the {@code double[]} instances in {@code arrays}.
	 * <p>
	 * Returns a new {@code double[]} with {@code arrays} merged.
	 * <p>
	 * If either {@code arrays} or at least one of its elements are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param arrays the {@code double[][]} instance to combine into one {@code double[]}
	 * @return a new {@code double[]} with {@code arrays} merged
	 * @throws NullPointerException thrown if, and only if, either {@code arrays} or at least one of its elements are {@code null}
	 */
	public static double[] merge(final double[]... arrays) {
		requireNonNull(arrays, "arrays");
		
		try(final DoubleArrayOutputStream doubleArrayOutputStream = new DoubleArrayOutputStream()) {
			for(final double[] array : arrays) {
				doubleArrayOutputStream.write(array);
			}
			
			return doubleArrayOutputStream.toDoubleArray();
		}
	}
	
	/**
	 * Returns a {@code double[]} with {@code array} repeated {@code repetition} times.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If {@code repetition} is less than {@code 0} or {@code array.length * repetition} overflows, an {@code IllegalArgumentException} will be thrown.
	 * 
	 * @param array the {@code double[]} to repeat {@code repetition} times
	 * @param repetition the number of times to repeat {@code array}
	 * @return a {@code double[]} with {@code array} repeated {@code repetition} times
	 * @throws IllegalArgumentException thrown if, and only if, {@code repetition} is less than {@code 0} or {@code array.length * repetition} overflows
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static double[] repeat(final double[] array, final int repetition) {
		Objects.requireNonNull(array, "array == null");
		
		doRequireRange(repetition, 0, Integer.MAX_VALUE, "repetition");
		
		if(array.length == 0 || repetition == 0) {
			return new double[0];
		} else if(array.length == 1) {
			final double[] repeatedArray = new double[repetition];
			
			final double element = array[0];
			
			for(int i = 0; i < repetition; i++) {
				repeatedArray[i] = element;
			}
			
			return repeatedArray;
		} else {
			try {
				final double[] repeatedArray = new double[Math.multiplyExact(repetition, array.length)];
				
				for(int i = 0; i < repetition; i++) {
					System.arraycopy(array, 0, repeatedArray, i * array.length, array.length);
				}
				
				return repeatedArray;
			} catch(final ArithmeticException e) {
				throw new IllegalArgumentException(e);
			}
		}
	}
	
	/**
	 * Performs a splice operation on the {@code double[]} instance {@code array}.
	 * <p>
	 * Returns a new {@code double[]} with the result of the operation.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * Arrays.splice(array, offset, array.length);
	 * }
	 * </pre>
	 * 
	 * @param array the input {@code double[]}
	 * @param offset the offset for the removal, which may be negative
	 * @return a new {@code double[]} with the result of the operation
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static double[] splice(final double[] array, final int offset) {
		return splice(array, offset, array.length);
	}
	
	/**
	 * Performs a splice operation on the {@code double[]} instance {@code array}.
	 * <p>
	 * Returns a new {@code double[]} with the result of the operation.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * Arrays.splice(array, offset, length, new double[0]);
	 * }
	 * </pre>
	 * 
	 * @param array the input {@code double[]}
	 * @param offset the offset for the removal, which may be negative
	 * @param length the length of the removal, which may be negative
	 * @return a new {@code double[]} with the result of the operation
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static double[] splice(final double[] array, final int offset, final int length) {
		return splice(array, offset, length, new double[0]);
	}
	
	/**
	 * Performs a splice operation on the {@code double[]} instance {@code array}.
	 * <p>
	 * Returns a new {@code double[]} with the result of the operation.
	 * <p>
	 * If either {@code array} or {@code arrayReplacement} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param array the input {@code double[]}
	 * @param offset the offset for the removal, which may be negative
	 * @param length the length of the removal, which may be negative
	 * @param arrayReplacement a {@code double[]} that acts as replacement
	 * @return a new {@code double[]} with the result of the operation
	 * @throws NullPointerException thrown if, and only if, either {@code array} or {@code arrayReplacement} are {@code null}
	 */
	public static double[] splice(final double[] array, final int offset, final int length, final double[] arrayReplacement) {
		Objects.requireNonNull(array, "array == null");
		Objects.requireNonNull(arrayReplacement, "arrayReplacement == null");
		
		final double[] arrayA = array;
		final double[] arrayB = arrayReplacement;
		final double[] arrayC = array;
		
		final int arrayASrcPos = 0;
		final int arrayALength = doSaturate(offset >= 0 ? offset : arrayA.length + offset, 0, arrayA.length);
		
		final int arrayBSrcPos = 0;
		final int arrayBLength = arrayB.length;
		
		final int arrayCSrcPos = doSaturate(length >= 0 ? length + arrayALength : arrayC.length + length, arrayALength, arrayC.length);
		final int arrayCLength = arrayC.length - arrayCSrcPos;
		
		final int arrayDSrcPos0 = 0;
		final int arrayDSrcPos1 = arrayALength;
		final int arrayDSrcPos2 = arrayALength + arrayBLength;
		final int arrayDLength  = arrayA.length - (arrayCSrcPos - arrayALength) + arrayBLength;
		
		final double[] arrayD = new double[arrayDLength];
		
		System.arraycopy(arrayA, arrayASrcPos, arrayD, arrayDSrcPos0, arrayALength);
		System.arraycopy(arrayB, arrayBSrcPos, arrayD, arrayDSrcPos1, arrayBLength);
		System.arraycopy(arrayC, arrayCSrcPos, arrayD, arrayDSrcPos2, arrayCLength);
		
		return arrayD;
	}
	
	/**
	 * Returns a {@code double[]} representation of {@code objects} using {@code arrayFunction} as a converter.
	 * <p>
	 * If either {@code objects}, at least one of its elements, {@code arrayFunction} or at least one of its results are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param <T> the generic type
	 * @param objects a {@code List} of type {@code T} with {@code Object} instances to convert into {@code double[]} instances
	 * @param arrayFunction a {@code Function} that maps {@code Object} instances of type {@code T} into {@code double[]} instances
	 * @return a {@code double[]} representation of {@code objects} using {@code arrayFunction} as a converter
	 * @throws NullPointerException thrown if, and only if, either {@code objects}, at least one of its elements, {@code arrayFunction} or at least one of its results are {@code null}
	 */
	public static <T> double[] toDoubleArray(final List<T> objects, final Function<T, double[]> arrayFunction) {
		doRequireNonNullList(objects, "objects");
		
		Objects.requireNonNull(arrayFunction, "arrayFunction == null");
		
		if(objects.isEmpty()) {
			return new double[0];
		}
		
		try(final DoubleArrayOutputStream doubleArrayOutputStream = new DoubleArrayOutputStream()) {
			for(final T object : objects) {
				doubleArrayOutputStream.write(arrayFunction.apply(object));
			}
			
			return doubleArrayOutputStream.toDoubleArray();
		}
	}
	
	/**
	 * Checks that {@code arrays} and all of its elements are not {@code null}.
	 * <p>
	 * Returns {@code arrays}.
	 * <p>
	 * If either {@code arrays}, an element in {@code arrays} or {@code name} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param arrays the {@code double[][]} to check
	 * @param name the name of the parameter used for {@code arrays}, that will be part of the message to the {@code NullPointerException}
	 * @return {@code arrays}
	 * @throws NullPointerException thrown if, and only if, either {@code arrays}, an element in {@code arrays} or {@code name} are {@code null}
	 */
	public static double[][] requireNonNull(final double[][] arrays, final String name) {
		Objects.requireNonNull(name, "name == null");
		
		if(arrays == null) {
			throw new NullPointerException(String.format("%s == null", name));
		}
		
		for(int i = 0; i < arrays.length; i++) {
			if(arrays[i] == null) {
				throw new NullPointerException(String.format("%s[%d] == null", name, Integer.valueOf(i)));
			}
		}
		
		return arrays;
	}
	
	/**
	 * Returns a {@code float[]} with a length of {@code length} and elements generated by {@code function}.
	 * <p>
	 * If {@code length} is less than {@code 0}, an {@code IllegalArgumentException} will be thrown.
	 * <p>
	 * If {@code function} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param length the length of the {@code float[]}
	 * @param function an {@link IntToFloatFunction} that generates the elements and takes the current index as parameter
	 * @return a {@code float[]} with a length of {@code length} and elements generated by {@code function}
	 * @throws IllegalArgumentException thrown if, and only if, {@code length} is less than {@code 0}
	 * @throws NullPointerException thrown if, and only if, {@code function} is {@code null}
	 */
	public static float[] generateFloatArray(final int length, final IntToFloatFunction function) {
		doRequireRange(length, 0, Integer.MAX_VALUE, "length");
		
		Objects.requireNonNull(function, "function == null");
		
		final float[] array = new float[length];
		
		for(int i = 0; i < length; i++) {
			array[i] = function.applyAsFloat(i);
		}
		
		return array;
	}
	
	/**
	 * Performs a merge operation on the {@code float[]} instances in {@code arrays}.
	 * <p>
	 * Returns a new {@code float[]} with {@code arrays} merged.
	 * <p>
	 * If either {@code arrays} or at least one of its elements are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param arrays the {@code float[][]} instance to combine into one {@code float[]}
	 * @return a new {@code float[]} with {@code arrays} merged
	 * @throws NullPointerException thrown if, and only if, either {@code arrays} or at least one of its elements are {@code null}
	 */
	public static float[] merge(final float[]... arrays) {
		requireNonNull(arrays, "arrays");
		
		try(final FloatArrayOutputStream floatArrayOutputStream = new FloatArrayOutputStream()) {
			for(final float[] array : arrays) {
				floatArrayOutputStream.write(array);
			}
			
			return floatArrayOutputStream.toFloatArray();
		}
	}
	
	/**
	 * Returns a {@code float[]} with {@code array} repeated {@code repetition} times.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If {@code repetition} is less than {@code 0} or {@code array.length * repetition} overflows, an {@code IllegalArgumentException} will be thrown.
	 * 
	 * @param array the {@code float[]} to repeat {@code repetition} times
	 * @param repetition the number of times to repeat {@code array}
	 * @return a {@code float[]} with {@code array} repeated {@code repetition} times
	 * @throws IllegalArgumentException thrown if, and only if, {@code repetition} is less than {@code 0} or {@code array.length * repetition} overflows
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static float[] repeat(final float[] array, final int repetition) {
		Objects.requireNonNull(array, "array == null");
		
		doRequireRange(repetition, 0, Integer.MAX_VALUE, "repetition");
		
		if(array.length == 0 || repetition == 0) {
			return new float[0];
		} else if(array.length == 1) {
			final float[] repeatedArray = new float[repetition];
			
			final float element = array[0];
			
			for(int i = 0; i < repetition; i++) {
				repeatedArray[i] = element;
			}
			
			return repeatedArray;
		} else {
			try {
				final float[] repeatedArray = new float[Math.multiplyExact(repetition, array.length)];
				
				for(int i = 0; i < repetition; i++) {
					System.arraycopy(array, 0, repeatedArray, i * array.length, array.length);
				}
				
				return repeatedArray;
			} catch(final ArithmeticException e) {
				throw new IllegalArgumentException(e);
			}
		}
	}
	
	/**
	 * Performs a splice operation on the {@code float[]} instance {@code array}.
	 * <p>
	 * Returns a new {@code float[]} with the result of the operation.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * Arrays.splice(array, offset, array.length);
	 * }
	 * </pre>
	 * 
	 * @param array the input {@code float[]}
	 * @param offset the offset for the removal, which may be negative
	 * @return a new {@code float[]} with the result of the operation
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static float[] splice(final float[] array, final int offset) {
		return splice(array, offset, array.length);
	}
	
	/**
	 * Performs a splice operation on the {@code float[]} instance {@code array}.
	 * <p>
	 * Returns a new {@code float[]} with the result of the operation.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * Arrays.splice(array, offset, length, new float[0]);
	 * }
	 * </pre>
	 * 
	 * @param array the input {@code float[]}
	 * @param offset the offset for the removal, which may be negative
	 * @param length the length of the removal, which may be negative
	 * @return a new {@code float[]} with the result of the operation
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static float[] splice(final float[] array, final int offset, final int length) {
		return splice(array, offset, length, new float[0]);
	}
	
	/**
	 * Performs a splice operation on the {@code float[]} instance {@code array}.
	 * <p>
	 * Returns a new {@code float[]} with the result of the operation.
	 * <p>
	 * If either {@code array} or {@code arrayReplacement} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param array the input {@code float[]}
	 * @param offset the offset for the removal, which may be negative
	 * @param length the length of the removal, which may be negative
	 * @param arrayReplacement a {@code float[]} that acts as replacement
	 * @return a new {@code float[]} with the result of the operation
	 * @throws NullPointerException thrown if, and only if, either {@code array} or {@code arrayReplacement} are {@code null}
	 */
	public static float[] splice(final float[] array, final int offset, final int length, final float[] arrayReplacement) {
		Objects.requireNonNull(array, "array == null");
		Objects.requireNonNull(arrayReplacement, "arrayReplacement == null");
		
		final float[] arrayA = array;
		final float[] arrayB = arrayReplacement;
		final float[] arrayC = array;
		
		final int arrayASrcPos = 0;
		final int arrayALength = doSaturate(offset >= 0 ? offset : arrayA.length + offset, 0, arrayA.length);
		
		final int arrayBSrcPos = 0;
		final int arrayBLength = arrayB.length;
		
		final int arrayCSrcPos = doSaturate(length >= 0 ? length + arrayALength : arrayC.length + length, arrayALength, arrayC.length);
		final int arrayCLength = arrayC.length - arrayCSrcPos;
		
		final int arrayDSrcPos0 = 0;
		final int arrayDSrcPos1 = arrayALength;
		final int arrayDSrcPos2 = arrayALength + arrayBLength;
		final int arrayDLength  = arrayA.length - (arrayCSrcPos - arrayALength) + arrayBLength;
		
		final float[] arrayD = new float[arrayDLength];
		
		System.arraycopy(arrayA, arrayASrcPos, arrayD, arrayDSrcPos0, arrayALength);
		System.arraycopy(arrayB, arrayBSrcPos, arrayD, arrayDSrcPos1, arrayBLength);
		System.arraycopy(arrayC, arrayCSrcPos, arrayD, arrayDSrcPos2, arrayCLength);
		
		return arrayD;
	}
	
	/**
	 * Returns a {@code float[]} representation of {@code objects} using {@code arrayFunction} as a converter.
	 * <p>
	 * If either {@code objects}, at least one of its elements, {@code arrayFunction} or at least one of its results are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param <T> the generic type
	 * @param objects a {@code List} of type {@code T} with {@code Object} instances to convert into {@code float[]} instances
	 * @param arrayFunction a {@code Function} that maps {@code Object} instances of type {@code T} into {@code float[]} instances
	 * @return a {@code float[]} representation of {@code objects} using {@code arrayFunction} as a converter
	 * @throws NullPointerException thrown if, and only if, either {@code objects}, at least one of its elements, {@code arrayFunction} or at least one of its results are {@code null}
	 */
	public static <T> float[] toFloatArray(final List<T> objects, final Function<T, float[]> arrayFunction) {
		doRequireNonNullList(objects, "objects");
		
		Objects.requireNonNull(arrayFunction, "arrayFunction == null");
		
		if(objects.isEmpty()) {
			return new float[0];
		}
		
		try(final FloatArrayOutputStream floatArrayOutputStream = new FloatArrayOutputStream()) {
			for(final T object : objects) {
				floatArrayOutputStream.write(arrayFunction.apply(object));
			}
			
			return floatArrayOutputStream.toFloatArray();
		}
	}
	
	/**
	 * Checks that {@code arrays} and all of its elements are not {@code null}.
	 * <p>
	 * Returns {@code arrays}.
	 * <p>
	 * If either {@code arrays}, an element in {@code arrays} or {@code name} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param arrays the {@code float[][]} to check
	 * @param name the name of the parameter used for {@code arrays}, that will be part of the message to the {@code NullPointerException}
	 * @return {@code arrays}
	 * @throws NullPointerException thrown if, and only if, either {@code arrays}, an element in {@code arrays} or {@code name} are {@code null}
	 */
	public static float[][] requireNonNull(final float[][] arrays, final String name) {
		Objects.requireNonNull(name, "name == null");
		
		if(arrays == null) {
			throw new NullPointerException(String.format("%s == null", name));
		}
		
		for(int i = 0; i < arrays.length; i++) {
			if(arrays[i] == null) {
				throw new NullPointerException(String.format("%s[%d] == null", name, Integer.valueOf(i)));
			}
		}
		
		return arrays;
	}
	
	/**
	 * Returns a hash code based on the contents of {@code array}.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param array the {@code boolean[]} to compute a hash code for
	 * @return a hash code based on the contents of {@code array}
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static int hashCode(final boolean[] array) {
		Objects.requireNonNull(array, "array == null");
		
		int result = 1;
		
		for(final boolean element : array) {
			result = 31 * result + (element ? 1231 : 1237);
		}
		
		return result;
	}
	
	/**
	 * Returns a hash code based on the contents of {@code array}.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param array the {@code byte[]} to compute a hash code for
	 * @return a hash code based on the contents of {@code array}
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static int hashCode(final byte[] array) {
		Objects.requireNonNull(array, "array == null");
		
		int result = 1;
		
		for(final byte element : array) {
			result = 31 * result + element;
		}
		
		return result;
	}
	
	/**
	 * Returns a hash code based on the contents of {@code array}.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param array the {@code char[]} to compute a hash code for
	 * @return a hash code based on the contents of {@code array}
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static int hashCode(final char[] array) {
		Objects.requireNonNull(array, "array == null");
		
		int result = 1;
		
		for(final char element : array) {
			result = 31 * result + element;
		}
		
		return result;
	}
	
	/**
	 * Returns a hash code based on the contents of {@code array}.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param array the {@code double[]} to compute a hash code for
	 * @return a hash code based on the contents of {@code array}
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static int hashCode(final double[] array) {
		Objects.requireNonNull(array, "array == null");
		
		int result = 1;
		
		for(final double element : array) {
			final long bits = Double.doubleToLongBits(element);
			
			result = 31 * result + (int)(bits ^ (bits >>> 32L));
		}
		
		return result;
	}
	
	/**
	 * Returns a hash code based on the contents of {@code array}.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param array the {@code float[]} to compute a hash code for
	 * @return a hash code based on the contents of {@code array}
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static int hashCode(final float[] array) {
		Objects.requireNonNull(array, "array == null");
		
		int result = 1;
		
		for(final float element : array) {
			result = 31 * result + Float.floatToIntBits(element);
		}
		
		return result;
	}
	
	/**
	 * Returns a hash code based on the contents of {@code array}.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param array the {@code int[]} to compute a hash code for
	 * @return a hash code based on the contents of {@code array}
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static int hashCode(final int[] array) {
		Objects.requireNonNull(array, "array == null");
		
		int result = 1;
		
		for(final int element : array) {
			result = 31 * result + element;
		}
		
		return result;
	}
	
	/**
	 * Returns a hash code based on the contents of {@code array}.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param array the {@code long[]} to compute a hash code for
	 * @return a hash code based on the contents of {@code array}
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static int hashCode(final long[] array) {
		Objects.requireNonNull(array, "array == null");
		
		int result = 1;
		
		for(final long element : array) {
			result = 31 * result + (int)(element ^ (element >>> 32L));
		}
		
		return result;
	}
	
	/**
	 * Returns a hash code based on the contents of {@code array}.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param array the {@code short[]} to compute a hash code for
	 * @return a hash code based on the contents of {@code array}
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static int hashCode(final short[] array) {
		Objects.requireNonNull(array, "array == null");
		
		int result = 1;
		
		for(final short element : array) {
			result = 31 * result + element;
		}
		
		return result;
	}
	
	/**
	 * Returns the index of {@code value} in {@code array}, or {@code -1} if it cannot be found.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param value the {@code boolean} value to find the index for
	 * @param array the {@code boolean[]} to search for {@code value} in
	 * @return the index of {@code value} in {@code array}, or {@code -1} if it cannot be found
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static int indexOf(final boolean value, final boolean[] array) {
		Objects.requireNonNull(array, "array == null");
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == value) {
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Returns the index of {@code value} in {@code array}, or {@code -1} if it cannot be found.
	 * <p>
	 * If either {@code value} or {@code array} are {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If {@code isIncrementingByValueLength} is {@code true} and {@code array.length % value.length} is not equal to {@code 0}, an {@code IllegalArgumentException} will be thrown.
	 * <p>
	 * If {@code isIncrementingByValueLength} is {@code true}, this method assumes {@code array} contains sub-structures with equal lengths, namely {@code value.length}. This will yield a faster search, but also restrictions on {@code array}. It requires a length that is a multiple of {@code value.length}. If {@code array} does not contain sub-structures with equal lengths, {@code isIncrementingByValueLength} should be {@code false}.
	 * <p>
	 * If {@code isReturningRelativeIndex} is {@code true}, the relative index of {@code value} in {@code array} will be returned. The relative index represents the index of the sub-structure in {@code array}. It works best if {@code isIncrementingByValueLength} is {@code true} and its restrictions are met.
	 * <p>
	 * If {@code isReturningRelativeIndex} is {@code false}, the absolute index of {@code value} in {@code array} will be returned. The absolute index represents the index in {@code array}.
	 * 
	 * @param value the {@code boolean[]} value to find the index for
	 * @param array the {@code boolean[]} to search for {@code value} in
	 * @param isIncrementingByValueLength {@code true} if, and only if, {@code array} consists of sub-structures with a length of {@code value.length}, {@code false} otherwise
	 * @param isReturningRelativeIndex {@code true} if, and only if, the relative index should be returned, {@code false} otherwise
	 * @return the index of {@code value} in {@code array}, or {@code -1} if it cannot be found
	 * @throws IllegalArgumentException thrown if, and only if, {@code isIncrementingByValueLength} is {@code true} and {@code array.length % value.length} is not equal to {@code 0}
	 * @throws NullPointerException thrown if, and only if, either {@code value} or {@code array} are {@code null}
	 */
	public static int indexOf(final boolean[] value, final boolean[] array, final boolean isIncrementingByValueLength, final boolean isReturningRelativeIndex) {
		Objects.requireNonNull(value, "value == null");
		Objects.requireNonNull(array, "array == null");
		
		if(value.length == 0 || array.length == 0) {
			return -1;
		}
		
		if(isIncrementingByValueLength) {
			doRequireExact(array.length % value.length, 0, "array.length % value.length");
		}
		
		final int count = isIncrementingByValueLength ? array.length / value.length : array.length;
		final int length = isIncrementingByValueLength ? value.length : 1;
		
		for(int indexAbsolute = 0, indexRelative = 0; indexRelative < count; indexAbsolute += length, indexRelative++) {
			if(array.length < indexAbsolute + value.length) {
				return -1;
			}
			
			if(equals(array, value, indexAbsolute, 0, value.length)) {
				return isReturningRelativeIndex ? indexRelative : indexAbsolute;
			}
		}
		
		return -1;
	}
	
	/**
	 * Returns the index of {@code value} in {@code array}, or {@code -1} if it cannot be found.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param value the {@code byte} value to find the index for
	 * @param array the {@code byte[]} to search for {@code value} in
	 * @return the index of {@code value} in {@code array}, or {@code -1} if it cannot be found
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static int indexOf(final byte value, final byte[] array) {
		Objects.requireNonNull(array, "array == null");
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == value) {
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Returns the index of {@code value} in {@code array}, or {@code -1} if it cannot be found.
	 * <p>
	 * If either {@code value} or {@code array} are {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If {@code isIncrementingByValueLength} is {@code true} and {@code array.length % value.length} is not equal to {@code 0}, an {@code IllegalArgumentException} will be thrown.
	 * <p>
	 * If {@code isIncrementingByValueLength} is {@code true}, this method assumes {@code array} contains sub-structures with equal lengths, namely {@code value.length}. This will yield a faster search, but also restrictions on {@code array}. It requires a length that is a multiple of {@code value.length}. If {@code array} does not contain sub-structures with equal lengths, {@code isIncrementingByValueLength} should be {@code false}.
	 * <p>
	 * If {@code isReturningRelativeIndex} is {@code true}, the relative index of {@code value} in {@code array} will be returned. The relative index represents the index of the sub-structure in {@code array}. It works best if {@code isIncrementingByValueLength} is {@code true} and its restrictions are met.
	 * <p>
	 * If {@code isReturningRelativeIndex} is {@code false}, the absolute index of {@code value} in {@code array} will be returned. The absolute index represents the index in {@code array}.
	 * 
	 * @param value the {@code byte[]} value to find the index for
	 * @param array the {@code byte[]} to search for {@code value} in
	 * @param isIncrementingByValueLength {@code true} if, and only if, {@code array} consists of sub-structures with a length of {@code value.length}, {@code false} otherwise
	 * @param isReturningRelativeIndex {@code true} if, and only if, the relative index should be returned, {@code false} otherwise
	 * @return the index of {@code value} in {@code array}, or {@code -1} if it cannot be found
	 * @throws IllegalArgumentException thrown if, and only if, {@code isIncrementingByValueLength} is {@code true} and {@code array.length % value.length} is not equal to {@code 0}
	 * @throws NullPointerException thrown if, and only if, either {@code value} or {@code array} are {@code null}
	 */
	public static int indexOf(final byte[] value, final byte[] array, final boolean isIncrementingByValueLength, final boolean isReturningRelativeIndex) {
		Objects.requireNonNull(value, "value == null");
		Objects.requireNonNull(array, "array == null");
		
		if(value.length == 0 || array.length == 0) {
			return -1;
		}
		
		if(isIncrementingByValueLength) {
			doRequireExact(array.length % value.length, 0, "array.length % value.length");
		}
		
		final int count = isIncrementingByValueLength ? array.length / value.length : array.length;
		final int length = isIncrementingByValueLength ? value.length : 1;
		
		for(int indexAbsolute = 0, indexRelative = 0; indexRelative < count; indexAbsolute += length, indexRelative++) {
			if(array.length < indexAbsolute + value.length) {
				return -1;
			}
			
			if(equals(array, value, indexAbsolute, 0, value.length)) {
				return isReturningRelativeIndex ? indexRelative : indexAbsolute;
			}
		}
		
		return -1;
	}
	
	/**
	 * Returns the index of {@code value} in {@code array}, or {@code -1} if it cannot be found.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param value the {@code char} value to find the index for
	 * @param array the {@code char[]} to search for {@code value} in
	 * @return the index of {@code value} in {@code array}, or {@code -1} if it cannot be found
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static int indexOf(final char value, final char[] array) {
		Objects.requireNonNull(array, "array == null");
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == value) {
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Returns the index of {@code value} in {@code array}, or {@code -1} if it cannot be found.
	 * <p>
	 * If either {@code value} or {@code array} are {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If {@code isIncrementingByValueLength} is {@code true} and {@code array.length % value.length} is not equal to {@code 0}, an {@code IllegalArgumentException} will be thrown.
	 * <p>
	 * If {@code isIncrementingByValueLength} is {@code true}, this method assumes {@code array} contains sub-structures with equal lengths, namely {@code value.length}. This will yield a faster search, but also restrictions on {@code array}. It requires a length that is a multiple of {@code value.length}. If {@code array} does not contain sub-structures with equal lengths, {@code isIncrementingByValueLength} should be {@code false}.
	 * <p>
	 * If {@code isReturningRelativeIndex} is {@code true}, the relative index of {@code value} in {@code array} will be returned. The relative index represents the index of the sub-structure in {@code array}. It works best if {@code isIncrementingByValueLength} is {@code true} and its restrictions are met.
	 * <p>
	 * If {@code isReturningRelativeIndex} is {@code false}, the absolute index of {@code value} in {@code array} will be returned. The absolute index represents the index in {@code array}.
	 * 
	 * @param value the {@code char[]} value to find the index for
	 * @param array the {@code char[]} to search for {@code value} in
	 * @param isIncrementingByValueLength {@code true} if, and only if, {@code array} consists of sub-structures with a length of {@code value.length}, {@code false} otherwise
	 * @param isReturningRelativeIndex {@code true} if, and only if, the relative index should be returned, {@code false} otherwise
	 * @return the index of {@code value} in {@code array}, or {@code -1} if it cannot be found
	 * @throws IllegalArgumentException thrown if, and only if, {@code isIncrementingByValueLength} is {@code true} and {@code array.length % value.length} is not equal to {@code 0}
	 * @throws NullPointerException thrown if, and only if, either {@code value} or {@code array} are {@code null}
	 */
	public static int indexOf(final char[] value, final char[] array, final boolean isIncrementingByValueLength, final boolean isReturningRelativeIndex) {
		Objects.requireNonNull(value, "value == null");
		Objects.requireNonNull(array, "array == null");
		
		if(value.length == 0 || array.length == 0) {
			return -1;
		}
		
		if(isIncrementingByValueLength) {
			doRequireExact(array.length % value.length, 0, "array.length % value.length");
		}
		
		final int count = isIncrementingByValueLength ? array.length / value.length : array.length;
		final int length = isIncrementingByValueLength ? value.length : 1;
		
		for(int indexAbsolute = 0, indexRelative = 0; indexRelative < count; indexAbsolute += length, indexRelative++) {
			if(array.length < indexAbsolute + value.length) {
				return -1;
			}
			
			if(equals(array, value, indexAbsolute, 0, value.length)) {
				return isReturningRelativeIndex ? indexRelative : indexAbsolute;
			}
		}
		
		return -1;
	}
	
	/**
	 * Returns the index of {@code value} in {@code array}, or {@code -1} if it cannot be found.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param value the {@code double} value to find the index for
	 * @param array the {@code double[]} to search for {@code value} in
	 * @return the index of {@code value} in {@code array}, or {@code -1} if it cannot be found
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static int indexOf(final double value, final double[] array) {
		Objects.requireNonNull(array, "array == null");
		
		for(int i = 0; i < array.length; i++) {
			if(Double.compare(array[i], value) == 0) {
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Returns the index of {@code value} in {@code array}, or {@code -1} if it cannot be found.
	 * <p>
	 * If either {@code value} or {@code array} are {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If {@code isIncrementingByValueLength} is {@code true} and {@code array.length % value.length} is not equal to {@code 0}, an {@code IllegalArgumentException} will be thrown.
	 * <p>
	 * If {@code isIncrementingByValueLength} is {@code true}, this method assumes {@code array} contains sub-structures with equal lengths, namely {@code value.length}. This will yield a faster search, but also restrictions on {@code array}. It requires a length that is a multiple of {@code value.length}. If {@code array} does not contain sub-structures with equal lengths, {@code isIncrementingByValueLength} should be {@code false}.
	 * <p>
	 * If {@code isReturningRelativeIndex} is {@code true}, the relative index of {@code value} in {@code array} will be returned. The relative index represents the index of the sub-structure in {@code array}. It works best if {@code isIncrementingByValueLength} is {@code true} and its restrictions are met.
	 * <p>
	 * If {@code isReturningRelativeIndex} is {@code false}, the absolute index of {@code value} in {@code array} will be returned. The absolute index represents the index in {@code array}.
	 * 
	 * @param value the {@code double[]} value to find the index for
	 * @param array the {@code double[]} to search for {@code value} in
	 * @param isIncrementingByValueLength {@code true} if, and only if, {@code array} consists of sub-structures with a length of {@code value.length}, {@code false} otherwise
	 * @param isReturningRelativeIndex {@code true} if, and only if, the relative index should be returned, {@code false} otherwise
	 * @return the index of {@code value} in {@code array}, or {@code -1} if it cannot be found
	 * @throws IllegalArgumentException thrown if, and only if, {@code isIncrementingByValueLength} is {@code true} and {@code array.length % value.length} is not equal to {@code 0}
	 * @throws NullPointerException thrown if, and only if, either {@code value} or {@code array} are {@code null}
	 */
	public static int indexOf(final double[] value, final double[] array, final boolean isIncrementingByValueLength, final boolean isReturningRelativeIndex) {
		Objects.requireNonNull(value, "value == null");
		Objects.requireNonNull(array, "array == null");
		
		if(value.length == 0 || array.length == 0) {
			return -1;
		}
		
		if(isIncrementingByValueLength) {
			doRequireExact(array.length % value.length, 0, "array.length % value.length");
		}
		
		final int count = isIncrementingByValueLength ? array.length / value.length : array.length;
		final int length = isIncrementingByValueLength ? value.length : 1;
		
		for(int indexAbsolute = 0, indexRelative = 0; indexRelative < count; indexAbsolute += length, indexRelative++) {
			if(array.length < indexAbsolute + value.length) {
				return -1;
			}
			
			if(equals(array, value, indexAbsolute, 0, value.length)) {
				return isReturningRelativeIndex ? indexRelative : indexAbsolute;
			}
		}
		
		return -1;
	}
	
	/**
	 * Returns the index of {@code value} in {@code array}, or {@code -1} if it cannot be found.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param value the {@code float} value to find the index for
	 * @param array the {@code float[]} to search for {@code value} in
	 * @return the index of {@code value} in {@code array}, or {@code -1} if it cannot be found
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static int indexOf(final float value, final float[] array) {
		Objects.requireNonNull(array, "array == null");
		
		for(int i = 0; i < array.length; i++) {
			if(Float.compare(array[i], value) == 0) {
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Returns the index of {@code value} in {@code array}, or {@code -1} if it cannot be found.
	 * <p>
	 * If either {@code value} or {@code array} are {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If {@code isIncrementingByValueLength} is {@code true} and {@code array.length % value.length} is not equal to {@code 0}, an {@code IllegalArgumentException} will be thrown.
	 * <p>
	 * If {@code isIncrementingByValueLength} is {@code true}, this method assumes {@code array} contains sub-structures with equal lengths, namely {@code value.length}. This will yield a faster search, but also restrictions on {@code array}. It requires a length that is a multiple of {@code value.length}. If {@code array} does not contain sub-structures with equal lengths, {@code isIncrementingByValueLength} should be {@code false}.
	 * <p>
	 * If {@code isReturningRelativeIndex} is {@code true}, the relative index of {@code value} in {@code array} will be returned. The relative index represents the index of the sub-structure in {@code array}. It works best if {@code isIncrementingByValueLength} is {@code true} and its restrictions are met.
	 * <p>
	 * If {@code isReturningRelativeIndex} is {@code false}, the absolute index of {@code value} in {@code array} will be returned. The absolute index represents the index in {@code array}.
	 * 
	 * @param value the {@code float[]} value to find the index for
	 * @param array the {@code float[]} to search for {@code value} in
	 * @param isIncrementingByValueLength {@code true} if, and only if, {@code array} consists of sub-structures with a length of {@code value.length}, {@code false} otherwise
	 * @param isReturningRelativeIndex {@code true} if, and only if, the relative index should be returned, {@code false} otherwise
	 * @return the index of {@code value} in {@code array}, or {@code -1} if it cannot be found
	 * @throws IllegalArgumentException thrown if, and only if, {@code isIncrementingByValueLength} is {@code true} and {@code array.length % value.length} is not equal to {@code 0}
	 * @throws NullPointerException thrown if, and only if, either {@code value} or {@code array} are {@code null}
	 */
	public static int indexOf(final float[] value, final float[] array, final boolean isIncrementingByValueLength, final boolean isReturningRelativeIndex) {
		Objects.requireNonNull(value, "value == null");
		Objects.requireNonNull(array, "array == null");
		
		if(value.length == 0 || array.length == 0) {
			return -1;
		}
		
		if(isIncrementingByValueLength) {
			doRequireExact(array.length % value.length, 0, "array.length % value.length");
		}
		
		final int count = isIncrementingByValueLength ? array.length / value.length : array.length;
		final int length = isIncrementingByValueLength ? value.length : 1;
		
		for(int indexAbsolute = 0, indexRelative = 0; indexRelative < count; indexAbsolute += length, indexRelative++) {
			if(array.length < indexAbsolute + value.length) {
				return -1;
			}
			
			if(equals(array, value, indexAbsolute, 0, value.length)) {
				return isReturningRelativeIndex ? indexRelative : indexAbsolute;
			}
		}
		
		return -1;
	}
	
	/**
	 * Returns the index of {@code value} in {@code array}, or {@code -1} if it cannot be found.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param value the {@code int} value to find the index for
	 * @param array the {@code int[]} to search for {@code value} in
	 * @return the index of {@code value} in {@code array}, or {@code -1} if it cannot be found
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static int indexOf(final int value, final int[] array) {
		Objects.requireNonNull(array, "array == null");
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == value) {
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Returns the index of {@code value} in {@code array}, or {@code -1} if it cannot be found.
	 * <p>
	 * If either {@code value} or {@code array} are {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If {@code isIncrementingByValueLength} is {@code true} and {@code array.length % value.length} is not equal to {@code 0}, an {@code IllegalArgumentException} will be thrown.
	 * <p>
	 * If {@code isIncrementingByValueLength} is {@code true}, this method assumes {@code array} contains sub-structures with equal lengths, namely {@code value.length}. This will yield a faster search, but also restrictions on {@code array}. It requires a length that is a multiple of {@code value.length}. If {@code array} does not contain sub-structures with equal lengths, {@code isIncrementingByValueLength} should be {@code false}.
	 * <p>
	 * If {@code isReturningRelativeIndex} is {@code true}, the relative index of {@code value} in {@code array} will be returned. The relative index represents the index of the sub-structure in {@code array}. It works best if {@code isIncrementingByValueLength} is {@code true} and its restrictions are met.
	 * <p>
	 * If {@code isReturningRelativeIndex} is {@code false}, the absolute index of {@code value} in {@code array} will be returned. The absolute index represents the index in {@code array}.
	 * 
	 * @param value the {@code int[]} value to find the index for
	 * @param array the {@code int[]} to search for {@code value} in
	 * @param isIncrementingByValueLength {@code true} if, and only if, {@code array} consists of sub-structures with a length of {@code value.length}, {@code false} otherwise
	 * @param isReturningRelativeIndex {@code true} if, and only if, the relative index should be returned, {@code false} otherwise
	 * @return the index of {@code value} in {@code array}, or {@code -1} if it cannot be found
	 * @throws IllegalArgumentException thrown if, and only if, {@code isIncrementingByValueLength} is {@code true} and {@code array.length % value.length} is not equal to {@code 0}
	 * @throws NullPointerException thrown if, and only if, either {@code value} or {@code array} are {@code null}
	 */
	public static int indexOf(final int[] value, final int[] array, final boolean isIncrementingByValueLength, final boolean isReturningRelativeIndex) {
		Objects.requireNonNull(value, "value == null");
		Objects.requireNonNull(array, "array == null");
		
		if(value.length == 0 || array.length == 0) {
			return -1;
		}
		
		if(isIncrementingByValueLength) {
			doRequireExact(array.length % value.length, 0, "array.length % value.length");
		}
		
		final int count = isIncrementingByValueLength ? array.length / value.length : array.length;
		final int length = isIncrementingByValueLength ? value.length : 1;
		
		for(int indexAbsolute = 0, indexRelative = 0; indexRelative < count; indexAbsolute += length, indexRelative++) {
			if(array.length < indexAbsolute + value.length) {
				return -1;
			}
			
			if(equals(array, value, indexAbsolute, 0, value.length)) {
				return isReturningRelativeIndex ? indexRelative : indexAbsolute;
			}
		}
		
		return -1;
	}
	
	/**
	 * Returns the index of {@code value} in {@code array}, or {@code -1} if it cannot be found.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param value the {@code long} value to find the index for
	 * @param array the {@code long[]} to search for {@code value} in
	 * @return the index of {@code value} in {@code array}, or {@code -1} if it cannot be found
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static int indexOf(final long value, final long[] array) {
		Objects.requireNonNull(array, "array == null");
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == value) {
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Returns the index of {@code value} in {@code array}, or {@code -1} if it cannot be found.
	 * <p>
	 * If either {@code value} or {@code array} are {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If {@code isIncrementingByValueLength} is {@code true} and {@code array.length % value.length} is not equal to {@code 0}, an {@code IllegalArgumentException} will be thrown.
	 * <p>
	 * If {@code isIncrementingByValueLength} is {@code true}, this method assumes {@code array} contains sub-structures with equal lengths, namely {@code value.length}. This will yield a faster search, but also restrictions on {@code array}. It requires a length that is a multiple of {@code value.length}. If {@code array} does not contain sub-structures with equal lengths, {@code isIncrementingByValueLength} should be {@code false}.
	 * <p>
	 * If {@code isReturningRelativeIndex} is {@code true}, the relative index of {@code value} in {@code array} will be returned. The relative index represents the index of the sub-structure in {@code array}. It works best if {@code isIncrementingByValueLength} is {@code true} and its restrictions are met.
	 * <p>
	 * If {@code isReturningRelativeIndex} is {@code false}, the absolute index of {@code value} in {@code array} will be returned. The absolute index represents the index in {@code array}.
	 * 
	 * @param value the {@code long[]} value to find the index for
	 * @param array the {@code long[]} to search for {@code value} in
	 * @param isIncrementingByValueLength {@code true} if, and only if, {@code array} consists of sub-structures with a length of {@code value.length}, {@code false} otherwise
	 * @param isReturningRelativeIndex {@code true} if, and only if, the relative index should be returned, {@code false} otherwise
	 * @return the index of {@code value} in {@code array}, or {@code -1} if it cannot be found
	 * @throws IllegalArgumentException thrown if, and only if, {@code isIncrementingByValueLength} is {@code true} and {@code array.length % value.length} is not equal to {@code 0}
	 * @throws NullPointerException thrown if, and only if, either {@code value} or {@code array} are {@code null}
	 */
	public static int indexOf(final long[] value, final long[] array, final boolean isIncrementingByValueLength, final boolean isReturningRelativeIndex) {
		Objects.requireNonNull(value, "value == null");
		Objects.requireNonNull(array, "array == null");
		
		if(value.length == 0 || array.length == 0) {
			return -1;
		}
		
		if(isIncrementingByValueLength) {
			doRequireExact(array.length % value.length, 0, "array.length % value.length");
		}
		
		final int count = isIncrementingByValueLength ? array.length / value.length : array.length;
		final int length = isIncrementingByValueLength ? value.length : 1;
		
		for(int indexAbsolute = 0, indexRelative = 0; indexRelative < count; indexAbsolute += length, indexRelative++) {
			if(array.length < indexAbsolute + value.length) {
				return -1;
			}
			
			if(equals(array, value, indexAbsolute, 0, value.length)) {
				return isReturningRelativeIndex ? indexRelative : indexAbsolute;
			}
		}
		
		return -1;
	}
	
	/**
	 * Returns the index of {@code value} in {@code array}, or {@code -1} if it cannot be found.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param value the {@code short} value to find the index for
	 * @param array the {@code short[]} to search for {@code value} in
	 * @return the index of {@code value} in {@code array}, or {@code -1} if it cannot be found
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static int indexOf(final short value, final short[] array) {
		Objects.requireNonNull(array, "array == null");
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == value) {
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Returns the index of {@code value} in {@code array}, or {@code -1} if it cannot be found.
	 * <p>
	 * If either {@code value} or {@code array} are {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If {@code isIncrementingByValueLength} is {@code true} and {@code array.length % value.length} is not equal to {@code 0}, an {@code IllegalArgumentException} will be thrown.
	 * <p>
	 * If {@code isIncrementingByValueLength} is {@code true}, this method assumes {@code array} contains sub-structures with equal lengths, namely {@code value.length}. This will yield a faster search, but also restrictions on {@code array}. It requires a length that is a multiple of {@code value.length}. If {@code array} does not contain sub-structures with equal lengths, {@code isIncrementingByValueLength} should be {@code false}.
	 * <p>
	 * If {@code isReturningRelativeIndex} is {@code true}, the relative index of {@code value} in {@code array} will be returned. The relative index represents the index of the sub-structure in {@code array}. It works best if {@code isIncrementingByValueLength} is {@code true} and its restrictions are met.
	 * <p>
	 * If {@code isReturningRelativeIndex} is {@code false}, the absolute index of {@code value} in {@code array} will be returned. The absolute index represents the index in {@code array}.
	 * 
	 * @param value the {@code short[]} value to find the index for
	 * @param array the {@code short[]} to search for {@code value} in
	 * @param isIncrementingByValueLength {@code true} if, and only if, {@code array} consists of sub-structures with a length of {@code value.length}, {@code false} otherwise
	 * @param isReturningRelativeIndex {@code true} if, and only if, the relative index should be returned, {@code false} otherwise
	 * @return the index of {@code value} in {@code array}, or {@code -1} if it cannot be found
	 * @throws IllegalArgumentException thrown if, and only if, {@code isIncrementingByValueLength} is {@code true} and {@code array.length % value.length} is not equal to {@code 0}
	 * @throws NullPointerException thrown if, and only if, either {@code value} or {@code array} are {@code null}
	 */
	public static int indexOf(final short[] value, final short[] array, final boolean isIncrementingByValueLength, final boolean isReturningRelativeIndex) {
		Objects.requireNonNull(value, "value == null");
		Objects.requireNonNull(array, "array == null");
		
		if(value.length == 0 || array.length == 0) {
			return -1;
		}
		
		if(isIncrementingByValueLength) {
			doRequireExact(array.length % value.length, 0, "array.length % value.length");
		}
		
		final int count = isIncrementingByValueLength ? array.length / value.length : array.length;
		final int length = isIncrementingByValueLength ? value.length : 1;
		
		for(int indexAbsolute = 0, indexRelative = 0; indexRelative < count; indexAbsolute += length, indexRelative++) {
			if(array.length < indexAbsolute + value.length) {
				return -1;
			}
			
			if(equals(array, value, indexAbsolute, 0, value.length)) {
				return isReturningRelativeIndex ? indexRelative : indexAbsolute;
			}
		}
		
		return -1;
	}
	
	/**
	 * Returns an {@code int[]} with a length of {@code length} and elements generated by {@code function}.
	 * <p>
	 * If {@code length} is less than {@code 0}, an {@code IllegalArgumentException} will be thrown.
	 * <p>
	 * If {@code function} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param length the length of the {@code int[]}
	 * @param function an {@code IntUnaryOperator} that generates the elements and takes the current index as parameter
	 * @return an {@code int[]} with a length of {@code length} and elements generated by {@code function}
	 * @throws IllegalArgumentException thrown if, and only if, {@code length} is less than {@code 0}
	 * @throws NullPointerException thrown if, and only if, {@code function} is {@code null}
	 */
	public static int[] generateIntArray(final int length, final IntUnaryOperator function) {
		doRequireRange(length, 0, Integer.MAX_VALUE, "length");
		
		Objects.requireNonNull(function, "function == null");
		
		final int[] array = new int[length];
		
		for(int i = 0; i < length; i++) {
			array[i] = function.applyAsInt(i);
		}
		
		return array;
	}
	
	/**
	 * Performs a merge operation on the {@code int[]} instances in {@code arrays}.
	 * <p>
	 * Returns a new {@code int[]} with {@code arrays} merged.
	 * <p>
	 * If either {@code arrays} or at least one of its elements are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param arrays the {@code int[][]} instance to combine into one {@code int[]}
	 * @return a new {@code int[]} with {@code arrays} merged
	 * @throws NullPointerException thrown if, and only if, either {@code arrays} or at least one of its elements are {@code null}
	 */
	public static int[] merge(final int[]... arrays) {
		requireNonNull(arrays, "arrays");
		
		try(final IntArrayOutputStream intArrayOutputStream = new IntArrayOutputStream()) {
			for(final int[] array : arrays) {
				intArrayOutputStream.write(array);
			}
			
			return intArrayOutputStream.toIntArray();
		}
	}
	
	/**
	 * Returns an {@code int[]} with {@code array} repeated {@code repetition} times.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If {@code repetition} is less than {@code 0} or {@code array.length * repetition} overflows, an {@code IllegalArgumentException} will be thrown.
	 * 
	 * @param array the {@code int[]} to repeat {@code repetition} times
	 * @param repetition the number of times to repeat {@code array}
	 * @return an {@code int[]} with {@code array} repeated {@code repetition} times
	 * @throws IllegalArgumentException thrown if, and only if, {@code repetition} is less than {@code 0} or {@code array.length * repetition} overflows
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static int[] repeat(final int[] array, final int repetition) {
		Objects.requireNonNull(array, "array == null");
		
		doRequireRange(repetition, 0, Integer.MAX_VALUE, "repetition");
		
		if(array.length == 0 || repetition == 0) {
			return new int[0];
		} else if(array.length == 1) {
			final int[] repeatedArray = new int[repetition];
			
			final int element = array[0];
			
			for(int i = 0; i < repetition; i++) {
				repeatedArray[i] = element;
			}
			
			return repeatedArray;
		} else {
			try {
				final int[] repeatedArray = new int[Math.multiplyExact(repetition, array.length)];
				
				for(int i = 0; i < repetition; i++) {
					System.arraycopy(array, 0, repeatedArray, i * array.length, array.length);
				}
				
				return repeatedArray;
			} catch(final ArithmeticException e) {
				throw new IllegalArgumentException(e);
			}
		}
	}
	
	/**
	 * Performs a splice operation on the {@code int[]} instance {@code array}.
	 * <p>
	 * Returns a new {@code int[]} with the result of the operation.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * Arrays.splice(array, offset, array.length);
	 * }
	 * </pre>
	 * 
	 * @param array the input {@code int[]}
	 * @param offset the offset for the removal, which may be negative
	 * @return a new {@code int[]} with the result of the operation
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static int[] splice(final int[] array, final int offset) {
		return splice(array, offset, array.length);
	}
	
	/**
	 * Performs a splice operation on the {@code int[]} instance {@code array}.
	 * <p>
	 * Returns a new {@code int[]} with the result of the operation.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * Arrays.splice(array, offset, length, new int[0]);
	 * }
	 * </pre>
	 * 
	 * @param array the input {@code int[]}
	 * @param offset the offset for the removal, which may be negative
	 * @param length the length of the removal, which may be negative
	 * @return a new {@code int[]} with the result of the operation
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static int[] splice(final int[] array, final int offset, final int length) {
		return splice(array, offset, length, new int[0]);
	}
	
	/**
	 * Performs a splice operation on the {@code int[]} instance {@code array}.
	 * <p>
	 * Returns a new {@code int[]} with the result of the operation.
	 * <p>
	 * If either {@code array} or {@code arrayReplacement} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param array the input {@code int[]}
	 * @param offset the offset for the removal, which may be negative
	 * @param length the length of the removal, which may be negative
	 * @param arrayReplacement an {@code int[]} that acts as replacement
	 * @return a new {@code int[]} with the result of the operation
	 * @throws NullPointerException thrown if, and only if, either {@code array} or {@code arrayReplacement} are {@code null}
	 */
	public static int[] splice(final int[] array, final int offset, final int length, final int[] arrayReplacement) {
		Objects.requireNonNull(array, "array == null");
		Objects.requireNonNull(arrayReplacement, "arrayReplacement == null");
		
		final int[] arrayA = array;
		final int[] arrayB = arrayReplacement;
		final int[] arrayC = array;
		
		final int arrayASrcPos = 0;
		final int arrayALength = doSaturate(offset >= 0 ? offset : arrayA.length + offset, 0, arrayA.length);
		
		final int arrayBSrcPos = 0;
		final int arrayBLength = arrayB.length;
		
		final int arrayCSrcPos = doSaturate(length >= 0 ? length + arrayALength : arrayC.length + length, arrayALength, arrayC.length);
		final int arrayCLength = arrayC.length - arrayCSrcPos;
		
		final int arrayDSrcPos0 = 0;
		final int arrayDSrcPos1 = arrayALength;
		final int arrayDSrcPos2 = arrayALength + arrayBLength;
		final int arrayDLength  = arrayA.length - (arrayCSrcPos - arrayALength) + arrayBLength;
		
		final int[] arrayD = new int[arrayDLength];
		
		System.arraycopy(arrayA, arrayASrcPos, arrayD, arrayDSrcPos0, arrayALength);
		System.arraycopy(arrayB, arrayBSrcPos, arrayD, arrayDSrcPos1, arrayBLength);
		System.arraycopy(arrayC, arrayCSrcPos, arrayD, arrayDSrcPos2, arrayCLength);
		
		return arrayD;
	}
	
	/**
	 * Returns an {@code int[]} representation of {@code objects} using {@code arrayFunction} as a converter.
	 * <p>
	 * If either {@code objects}, at least one of its elements, {@code arrayFunction} or at least one of its results are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param <T> the generic type
	 * @param objects a {@code List} of type {@code T} with {@code Object} instances to convert into {@code int[]} instances
	 * @param arrayFunction a {@code Function} that maps {@code Object} instances of type {@code T} into {@code int[]} instances
	 * @return an {@code int[]} representation of {@code objects} using {@code arrayFunction} as a converter
	 * @throws NullPointerException thrown if, and only if, either {@code objects}, at least one of its elements, {@code arrayFunction} or at least one of its results are {@code null}
	 */
	public static <T> int[] toIntArray(final List<T> objects, final Function<T, int[]> arrayFunction) {
		doRequireNonNullList(objects, "objects");
		
		Objects.requireNonNull(arrayFunction, "arrayFunction == null");
		
		if(objects.isEmpty()) {
			return new int[0];
		}
		
		try(final IntArrayOutputStream intArrayOutputStream = new IntArrayOutputStream()) {
			for(final T object : objects) {
				intArrayOutputStream.write(arrayFunction.apply(object));
			}
			
			return intArrayOutputStream.toIntArray();
		}
	}
	
	/**
	 * Checks that {@code arrays} and all of its elements are not {@code null}.
	 * <p>
	 * Returns {@code arrays}.
	 * <p>
	 * If either {@code arrays}, an element in {@code arrays} or {@code name} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param arrays the {@code int[][]} to check
	 * @param name the name of the parameter used for {@code arrays}, that will be part of the message to the {@code NullPointerException}
	 * @return {@code arrays}
	 * @throws NullPointerException thrown if, and only if, either {@code arrays}, an element in {@code arrays} or {@code name} are {@code null}
	 */
	public static int[][] requireNonNull(final int[][] arrays, final String name) {
		Objects.requireNonNull(name, "name == null");
		
		if(arrays == null) {
			throw new NullPointerException(String.format("%s == null", name));
		}
		
		for(int i = 0; i < arrays.length; i++) {
			if(arrays[i] == null) {
				throw new NullPointerException(String.format("%s[%d] == null", name, Integer.valueOf(i)));
			}
		}
		
		return arrays;
	}
	
	/**
	 * Returns a {@code long[]} with a length of {@code length} and elements generated by {@code function}.
	 * <p>
	 * If {@code length} is less than {@code 0}, an {@code IllegalArgumentException} will be thrown.
	 * <p>
	 * If {@code function} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param length the length of the {@code long[]}
	 * @param function an {@code IntToLongFunction} that generates the elements and takes the current index as parameter
	 * @return a {@code long[]} with a length of {@code length} and elements generated by {@code function}
	 * @throws IllegalArgumentException thrown if, and only if, {@code length} is less than {@code 0}
	 * @throws NullPointerException thrown if, and only if, {@code function} is {@code null}
	 */
	public static long[] generateLongArray(final int length, final IntToLongFunction function) {
		doRequireRange(length, 0, Integer.MAX_VALUE, "length");
		
		Objects.requireNonNull(function, "function == null");
		
		final long[] array = new long[length];
		
		for(int i = 0; i < length; i++) {
			array[i] = function.applyAsLong(i);
		}
		
		return array;
	}
	
	/**
	 * Performs a merge operation on the {@code long[]} instances in {@code arrays}.
	 * <p>
	 * Returns a new {@code long[]} with {@code arrays} merged.
	 * <p>
	 * If either {@code arrays} or at least one of its elements are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param arrays the {@code long[][]} instance to combine into one {@code long[]}
	 * @return a new {@code long[]} with {@code arrays} merged
	 * @throws NullPointerException thrown if, and only if, either {@code arrays} or at least one of its elements are {@code null}
	 */
	public static long[] merge(final long[]... arrays) {
		requireNonNull(arrays, "arrays");
		
		try(final LongArrayOutputStream longArrayOutputStream = new LongArrayOutputStream()) {
			for(final long[] array : arrays) {
				longArrayOutputStream.write(array);
			}
			
			return longArrayOutputStream.toLongArray();
		}
	}
	
	/**
	 * Returns a {@code long[]} with {@code array} repeated {@code repetition} times.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If {@code repetition} is less than {@code 0} or {@code array.length * repetition} overflows, an {@code IllegalArgumentException} will be thrown.
	 * 
	 * @param array the {@code long[]} to repeat {@code repetition} times
	 * @param repetition the number of times to repeat {@code array}
	 * @return a {@code long[]} with {@code array} repeated {@code repetition} times
	 * @throws IllegalArgumentException thrown if, and only if, {@code repetition} is less than {@code 0} or {@code array.length * repetition} overflows
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static long[] repeat(final long[] array, final int repetition) {
		Objects.requireNonNull(array, "array == null");
		
		doRequireRange(repetition, 0, Integer.MAX_VALUE, "repetition");
		
		if(array.length == 0 || repetition == 0) {
			return new long[0];
		} else if(array.length == 1) {
			final long[] repeatedArray = new long[repetition];
			
			final long element = array[0];
			
			for(int i = 0; i < repetition; i++) {
				repeatedArray[i] = element;
			}
			
			return repeatedArray;
		} else {
			try {
				final long[] repeatedArray = new long[Math.multiplyExact(repetition, array.length)];
				
				for(int i = 0; i < repetition; i++) {
					System.arraycopy(array, 0, repeatedArray, i * array.length, array.length);
				}
				
				return repeatedArray;
			} catch(final ArithmeticException e) {
				throw new IllegalArgumentException(e);
			}
		}
	}
	
	/**
	 * Performs a splice operation on the {@code long[]} instance {@code array}.
	 * <p>
	 * Returns a new {@code long[]} with the result of the operation.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * Arrays.splice(array, offset, array.length);
	 * }
	 * </pre>
	 * 
	 * @param array the input {@code long[]}
	 * @param offset the offset for the removal, which may be negative
	 * @return a new {@code long[]} with the result of the operation
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static long[] splice(final long[] array, final int offset) {
		return splice(array, offset, array.length);
	}
	
	/**
	 * Performs a splice operation on the {@code long[]} instance {@code array}.
	 * <p>
	 * Returns a new {@code long[]} with the result of the operation.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * Arrays.splice(array, offset, length, new long[0]);
	 * }
	 * </pre>
	 * 
	 * @param array the input {@code long[]}
	 * @param offset the offset for the removal, which may be negative
	 * @param length the length of the removal, which may be negative
	 * @return a new {@code long[]} with the result of the operation
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static long[] splice(final long[] array, final int offset, final int length) {
		return splice(array, offset, length, new long[0]);
	}
	
	/**
	 * Performs a splice operation on the {@code long[]} instance {@code array}.
	 * <p>
	 * Returns a new {@code long[]} with the result of the operation.
	 * <p>
	 * If either {@code array} or {@code arrayReplacement} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param array the input {@code long[]}
	 * @param offset the offset for the removal, which may be negative
	 * @param length the length of the removal, which may be negative
	 * @param arrayReplacement a {@code long[]} that acts as replacement
	 * @return a new {@code long[]} with the result of the operation
	 * @throws NullPointerException thrown if, and only if, either {@code array} or {@code arrayReplacement} are {@code null}
	 */
	public static long[] splice(final long[] array, final int offset, final int length, final long[] arrayReplacement) {
		Objects.requireNonNull(array, "array == null");
		Objects.requireNonNull(arrayReplacement, "arrayReplacement == null");
		
		final long[] arrayA = array;
		final long[] arrayB = arrayReplacement;
		final long[] arrayC = array;
		
		final int arrayASrcPos = 0;
		final int arrayALength = doSaturate(offset >= 0 ? offset : arrayA.length + offset, 0, arrayA.length);
		
		final int arrayBSrcPos = 0;
		final int arrayBLength = arrayB.length;
		
		final int arrayCSrcPos = doSaturate(length >= 0 ? length + arrayALength : arrayC.length + length, arrayALength, arrayC.length);
		final int arrayCLength = arrayC.length - arrayCSrcPos;
		
		final int arrayDSrcPos0 = 0;
		final int arrayDSrcPos1 = arrayALength;
		final int arrayDSrcPos2 = arrayALength + arrayBLength;
		final int arrayDLength  = arrayA.length - (arrayCSrcPos - arrayALength) + arrayBLength;
		
		final long[] arrayD = new long[arrayDLength];
		
		System.arraycopy(arrayA, arrayASrcPos, arrayD, arrayDSrcPos0, arrayALength);
		System.arraycopy(arrayB, arrayBSrcPos, arrayD, arrayDSrcPos1, arrayBLength);
		System.arraycopy(arrayC, arrayCSrcPos, arrayD, arrayDSrcPos2, arrayCLength);
		
		return arrayD;
	}
	
	/**
	 * Returns a {@code long[]} representation of {@code objects} using {@code arrayFunction} as a converter.
	 * <p>
	 * If either {@code objects}, at least one of its elements, {@code arrayFunction} or at least one of its results are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param <T> the generic type
	 * @param objects a {@code List} of type {@code T} with {@code Object} instances to convert into {@code long[]} instances
	 * @param arrayFunction a {@code Function} that maps {@code Object} instances of type {@code T} into {@code long[]} instances
	 * @return a {@code long[]} representation of {@code objects} using {@code arrayFunction} as a converter
	 * @throws NullPointerException thrown if, and only if, either {@code objects}, at least one of its elements, {@code arrayFunction} or at least one of its results are {@code null}
	 */
	public static <T> long[] toLongArray(final List<T> objects, final Function<T, long[]> arrayFunction) {
		doRequireNonNullList(objects, "objects");
		
		Objects.requireNonNull(arrayFunction, "arrayFunction == null");
		
		if(objects.isEmpty()) {
			return new long[0];
		}
		
		try(final LongArrayOutputStream longArrayOutputStream = new LongArrayOutputStream()) {
			for(final T object : objects) {
				longArrayOutputStream.write(arrayFunction.apply(object));
			}
			
			return longArrayOutputStream.toLongArray();
		}
	}
	
	/**
	 * Checks that {@code arrays} and all of its elements are not {@code null}.
	 * <p>
	 * Returns {@code arrays}.
	 * <p>
	 * If either {@code arrays}, an element in {@code arrays} or {@code name} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param arrays the {@code long[][]} to check
	 * @param name the name of the parameter used for {@code arrays}, that will be part of the message to the {@code NullPointerException}
	 * @return {@code arrays}
	 * @throws NullPointerException thrown if, and only if, either {@code arrays}, an element in {@code arrays} or {@code name} are {@code null}
	 */
	public static long[][] requireNonNull(final long[][] arrays, final String name) {
		Objects.requireNonNull(name, "name == null");
		
		if(arrays == null) {
			throw new NullPointerException(String.format("%s == null", name));
		}
		
		for(int i = 0; i < arrays.length; i++) {
			if(arrays[i] == null) {
				throw new NullPointerException(String.format("%s[%d] == null", name, Integer.valueOf(i)));
			}
		}
		
		return arrays;
	}
	
	/**
	 * Returns a {@code short[]} with a length of {@code length} and elements generated by {@code function}.
	 * <p>
	 * If {@code length} is less than {@code 0}, an {@code IllegalArgumentException} will be thrown.
	 * <p>
	 * If {@code function} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param length the length of the {@code short[]}
	 * @param function an {@link IntToShortFunction} that generates the elements and takes the current index as parameter
	 * @return a {@code short[]} with a length of {@code length} and elements generated by {@code function}
	 * @throws IllegalArgumentException thrown if, and only if, {@code length} is less than {@code 0}
	 * @throws NullPointerException thrown if, and only if, {@code function} is {@code null}
	 */
	public static short[] generateShortArray(final int length, final IntToShortFunction function) {
		doRequireRange(length, 0, Integer.MAX_VALUE, "length");
		
		Objects.requireNonNull(function, "function == null");
		
		final short[] array = new short[length];
		
		for(int i = 0; i < length; i++) {
			array[i] = function.applyAsShort(i);
		}
		
		return array;
	}
	
	/**
	 * Performs a merge operation on the {@code short[]} instances in {@code arrays}.
	 * <p>
	 * Returns a new {@code short[]} with {@code arrays} merged.
	 * <p>
	 * If either {@code arrays} or at least one of its elements are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param arrays the {@code short[][]} instance to combine into one {@code short[]}
	 * @return a new {@code short[]} with {@code arrays} merged
	 * @throws NullPointerException thrown if, and only if, either {@code arrays} or at least one of its elements are {@code null}
	 */
	public static short[] merge(final short[]... arrays) {
		requireNonNull(arrays, "arrays");
		
		try(final ShortArrayOutputStream shortArrayOutputStream = new ShortArrayOutputStream()) {
			for(final short[] array : arrays) {
				shortArrayOutputStream.write(array);
			}
			
			return shortArrayOutputStream.toShortArray();
		}
	}
	
	/**
	 * Returns a {@code short[]} with {@code array} repeated {@code repetition} times.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If {@code repetition} is less than {@code 0} or {@code array.length * repetition} overflows, an {@code IllegalArgumentException} will be thrown.
	 * 
	 * @param array the {@code short[]} to repeat {@code repetition} times
	 * @param repetition the number of times to repeat {@code array}
	 * @return a {@code short[]} with {@code array} repeated {@code repetition} times
	 * @throws IllegalArgumentException thrown if, and only if, {@code repetition} is less than {@code 0} or {@code array.length * repetition} overflows
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static short[] repeat(final short[] array, final int repetition) {
		Objects.requireNonNull(array, "array == null");
		
		doRequireRange(repetition, 0, Integer.MAX_VALUE, "repetition");
		
		if(array.length == 0 || repetition == 0) {
			return new short[0];
		} else if(array.length == 1) {
			final short[] repeatedArray = new short[repetition];
			
			final short element = array[0];
			
			for(int i = 0; i < repetition; i++) {
				repeatedArray[i] = element;
			}
			
			return repeatedArray;
		} else {
			try {
				final short[] repeatedArray = new short[Math.multiplyExact(repetition, array.length)];
				
				for(int i = 0; i < repetition; i++) {
					System.arraycopy(array, 0, repeatedArray, i * array.length, array.length);
				}
				
				return repeatedArray;
			} catch(final ArithmeticException e) {
				throw new IllegalArgumentException(e);
			}
		}
	}
	
	/**
	 * Performs a splice operation on the {@code short[]} instance {@code array}.
	 * <p>
	 * Returns a new {@code short[]} with the result of the operation.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * Arrays.splice(array, offset, array.length);
	 * }
	 * </pre>
	 * 
	 * @param array the input {@code short[]}
	 * @param offset the offset for the removal, which may be negative
	 * @return a new {@code short[]} with the result of the operation
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static short[] splice(final short[] array, final int offset) {
		return splice(array, offset, array.length);
	}
	
	/**
	 * Performs a splice operation on the {@code short[]} instance {@code array}.
	 * <p>
	 * Returns a new {@code short[]} with the result of the operation.
	 * <p>
	 * If {@code array} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * Arrays.splice(array, offset, length, new short[0]);
	 * }
	 * </pre>
	 * 
	 * @param array the input {@code short[]}
	 * @param offset the offset for the removal, which may be negative
	 * @param length the length of the removal, which may be negative
	 * @return a new {@code short[]} with the result of the operation
	 * @throws NullPointerException thrown if, and only if, {@code array} is {@code null}
	 */
	public static short[] splice(final short[] array, final int offset, final int length) {
		return splice(array, offset, length, new short[0]);
	}
	
	/**
	 * Performs a splice operation on the {@code short[]} instance {@code array}.
	 * <p>
	 * Returns a new {@code short[]} with the result of the operation.
	 * <p>
	 * If either {@code array} or {@code arrayReplacement} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param array the input {@code short[]}
	 * @param offset the offset for the removal, which may be negative
	 * @param length the length of the removal, which may be negative
	 * @param arrayReplacement a {@code short[]} that acts as replacement
	 * @return a new {@code short[]} with the result of the operation
	 * @throws NullPointerException thrown if, and only if, either {@code array} or {@code arrayReplacement} are {@code null}
	 */
	public static short[] splice(final short[] array, final int offset, final int length, final short[] arrayReplacement) {
		Objects.requireNonNull(array, "array == null");
		Objects.requireNonNull(arrayReplacement, "arrayReplacement == null");
		
		final short[] arrayA = array;
		final short[] arrayB = arrayReplacement;
		final short[] arrayC = array;
		
		final int arrayASrcPos = 0;
		final int arrayALength = doSaturate(offset >= 0 ? offset : arrayA.length + offset, 0, arrayA.length);
		
		final int arrayBSrcPos = 0;
		final int arrayBLength = arrayB.length;
		
		final int arrayCSrcPos = doSaturate(length >= 0 ? length + arrayALength : arrayC.length + length, arrayALength, arrayC.length);
		final int arrayCLength = arrayC.length - arrayCSrcPos;
		
		final int arrayDSrcPos0 = 0;
		final int arrayDSrcPos1 = arrayALength;
		final int arrayDSrcPos2 = arrayALength + arrayBLength;
		final int arrayDLength  = arrayA.length - (arrayCSrcPos - arrayALength) + arrayBLength;
		
		final short[] arrayD = new short[arrayDLength];
		
		System.arraycopy(arrayA, arrayASrcPos, arrayD, arrayDSrcPos0, arrayALength);
		System.arraycopy(arrayB, arrayBSrcPos, arrayD, arrayDSrcPos1, arrayBLength);
		System.arraycopy(arrayC, arrayCSrcPos, arrayD, arrayDSrcPos2, arrayCLength);
		
		return arrayD;
	}
	
	/**
	 * Returns a {@code short[]} representation of {@code objects} using {@code arrayFunction} as a converter.
	 * <p>
	 * If either {@code objects}, at least one of its elements, {@code arrayFunction} or at least one of its results are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param <T> the generic type
	 * @param objects a {@code List} of type {@code T} with {@code Object} instances to convert into {@code short[]} instances
	 * @param arrayFunction a {@code Function} that maps {@code Object} instances of type {@code T} into {@code short[]} instances
	 * @return a {@code short[]} representation of {@code objects} using {@code arrayFunction} as a converter
	 * @throws NullPointerException thrown if, and only if, either {@code objects}, at least one of its elements, {@code arrayFunction} or at least one of its results are {@code null}
	 */
	public static <T> short[] toShortArray(final List<T> objects, final Function<T, short[]> arrayFunction) {
		doRequireNonNullList(objects, "objects");
		
		Objects.requireNonNull(arrayFunction, "arrayFunction == null");
		
		if(objects.isEmpty()) {
			return new short[0];
		}
		
		try(final ShortArrayOutputStream shortArrayOutputStream = new ShortArrayOutputStream()) {
			for(final T object : objects) {
				shortArrayOutputStream.write(arrayFunction.apply(object));
			}
			
			return shortArrayOutputStream.toShortArray();
		}
	}
	
	/**
	 * Checks that {@code arrays} and all of its elements are not {@code null}.
	 * <p>
	 * Returns {@code arrays}.
	 * <p>
	 * If either {@code arrays}, an element in {@code arrays} or {@code name} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param arrays the {@code short[][]} to check
	 * @param name the name of the parameter used for {@code arrays}, that will be part of the message to the {@code NullPointerException}
	 * @return {@code arrays}
	 * @throws NullPointerException thrown if, and only if, either {@code arrays}, an element in {@code arrays} or {@code name} are {@code null}
	 */
	public static short[][] requireNonNull(final short[][] arrays, final String name) {
		Objects.requireNonNull(name, "name == null");
		
		if(arrays == null) {
			throw new NullPointerException(String.format("%s == null", name));
		}
		
		for(int i = 0; i < arrays.length; i++) {
			if(arrays[i] == null) {
				throw new NullPointerException(String.format("%s[%d] == null", name, Integer.valueOf(i)));
			}
		}
		
		return arrays;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private static <T> List<T> doRequireNonNullList(final List<T> list, final String name) {
		Objects.requireNonNull(name, "name == null");
		
		if(list == null) {
			throw new NullPointerException(String.format("%s == null", name));
		}
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == null) {
				throw new NullPointerException(String.format("%s.get(%d) == null", name, Integer.valueOf(i)));
			}
		}
		
		return list;
	}
	
	private static int doRequireExact(final int value, final int valueExpected, final String name) {
		Objects.requireNonNull(name, "name == null");
		
		if(value != valueExpected) {
			throw new IllegalArgumentException(String.format("%s != %d: %s == %d", name, Integer.valueOf(valueExpected), name, Integer.valueOf(value)));
		}
		
		return value;
	}
	
	private static int doRequireRange(final int value, final int edgeA, final int edgeB, final String name) {
		Objects.requireNonNull(name, "name == null");
		
		final int minimum = Math.min(edgeA, edgeB);
		final int maximum = Math.max(edgeA, edgeB);
		
		if(value < minimum) {
			throw new IllegalArgumentException(String.format("%s < %d: %s == %d", name, Integer.valueOf(minimum), name, Integer.valueOf(value)));
		} else if(value > maximum) {
			throw new IllegalArgumentException(String.format("%s > %d: %s == %d", name, Integer.valueOf(maximum), name, Integer.valueOf(value)));
		} else {
			return value;
		}
	}
	
	private static int doSaturate(final int value, final int edgeA, final int edgeB) {
		return Math.max(Math.min(value, Math.max(edgeA, edgeB)), Math.min(edgeA, edgeB));
	}
}