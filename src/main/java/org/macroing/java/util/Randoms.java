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

import java.util.concurrent.ThreadLocalRandom;

/**
 * A class that consists exclusively of static methods that returns pseudorandom {@code boolean}, {@code double}, {@code float} and {@code int} values.
 * 
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
public final class Randoms {
	private Randoms() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Returns a pseudorandom {@code boolean} value.
	 * 
	 * @return a pseudorandom {@code boolean} value
	 */
	public static boolean nextBoolean() {
		return ThreadLocalRandom.current().nextBoolean();
	}
	
	/**
	 * Returns a pseudorandom {@code double} value between {@code 0.0D} (inclusive) and {@code 1.0D} (exclusive).
	 * 
	 * @return a pseudorandom {@code double} value between {@code 0.0D} (inclusive) and {@code 1.0D} (exclusive)
	 */
	public static double nextDouble() {
		return ThreadLocalRandom.current().nextDouble();
	}
	
	/**
	 * Returns a pseudorandom {@code double} value between {@code 0.0D} (inclusive) and {@code bound} (exclusive).
	 * <p>
	 * If {@code bound} is less than or equal to {@code 0.0D}, an {@code IllegalArgumentException} will be thrown.
	 * 
	 * @param bound the upper bound (exclusive) that must be positive
	 * @return a pseudorandom {@code double} value between {@code 0.0D} (inclusive) and {@code bound} (exclusive)
	 * @throws IllegalArgumentException thrown if, and only if, {@code bound} is less than or equal to {@code 0.0D}
	 */
	public static double nextDouble(final double bound) {
		return ThreadLocalRandom.current().nextDouble(bound);
	}
	
	/**
	 * Returns a pseudorandom {@code double} value between {@code origin} (inclusive) and {@code bound} (exclusive).
	 * <p>
	 * If {@code origin} is greater than or equal to {@code bound}, an {@code IllegalArgumentException} will be thrown.
	 * 
	 * @param origin the least value returned
	 * @param bound the upper bound (exclusive)
	 * @return a pseudorandom {@code double} value between {@code origin} (inclusive) and {@code bound} (exclusive)
	 * @throws IllegalArgumentException thrown if, and only if, {@code origin} is greater than or equal to {@code bound}
	 */
	public static double nextDouble(final double origin, final double bound) {
		return ThreadLocalRandom.current().nextDouble(origin, bound);
	}
	
	/**
	 * Returns a pseudorandom {@code float} value between {@code 0.0F} (inclusive) and {@code 1.0F} (exclusive).
	 * 
	 * @return a pseudorandom {@code float} value between {@code 0.0F} (inclusive) and {@code 1.0F} (exclusive)
	 */
	public static float nextFloat() {
		return ThreadLocalRandom.current().nextFloat();
	}
	
	/**
	 * Returns a pseudorandom {@code float} value between {@code 0.0F} (inclusive) and {@code bound} (exclusive).
	 * <p>
	 * If {@code bound} is less than or equal to {@code 0.0F}, an {@code IllegalArgumentException} will be thrown.
	 * 
	 * @param bound the upper bound (exclusive) that must be positive
	 * @return a pseudorandom {@code float} value between {@code 0.0F} (inclusive) and {@code bound} (exclusive)
	 * @throws IllegalArgumentException thrown if, and only if, {@code bound} is less than or equal to {@code 0.0F}
	 */
	public static float nextFloat(final float bound) {
		if(bound <= 0.0F) {
			throw new IllegalArgumentException("bound must be positive");
		}
		
		final float result = ThreadLocalRandom.current().nextFloat() * bound;
		
		return nextFloatInternal(bound, result);
	}
	
	/**
	 * Returns a pseudorandom {@code float} value between {@code origin} (inclusive) and {@code bound} (exclusive).
	 * <p>
	 * If {@code origin} is greater than or equal to {@code bound}, an {@code IllegalArgumentException} will be thrown.
	 * 
	 * @param origin the least value returned
	 * @param bound the upper bound (exclusive)
	 * @return a pseudorandom {@code float} value between {@code origin} (inclusive) and {@code bound} (exclusive)
	 * @throws IllegalArgumentException thrown if, and only if, {@code origin} is greater than or equal to {@code bound}
	 */
	public static float nextFloat(final float origin, final float bound) {
		if(origin >= bound) {
			throw new IllegalArgumentException("bound must be greater than origin");
		}
		
		final float result = (ThreadLocalRandom.current().nextInt() >>> 8) * 0x1.0p-24F * (bound - origin) + origin;
		
		return nextFloatInternal(bound, result);
	}
	
	/**
	 * Returns a pseudorandom {@code int} value.
	 * 
	 * @return a pseudorandom {@code int} value
	 */
	public static int nextInt() {
		return ThreadLocalRandom.current().nextInt();
	}
	
	/**
	 * Returns a pseudorandom {@code int} value between {@code 0} (inclusive) and {@code bound} (exclusive).
	 * <p>
	 * If {@code bound} is less than or equal to {@code 0}, an {@code IllegalArgumentException} will be thrown.
	 * 
	 * @param bound the upper bound (exclusive) that must be positive
	 * @return a pseudorandom {@code int} value between {@code 0} (inclusive) and {@code bound} (exclusive)
	 * @throws IllegalArgumentException thrown if, and only if, {@code bound} is less than or equal to {@code 0}
	 */
	public static int nextInt(final int bound) {
		return ThreadLocalRandom.current().nextInt(bound);
	}
	
	/**
	 * Returns a pseudorandom {@code int} value between {@code origin} (inclusive) and {@code bound} (exclusive).
	 * <p>
	 * If {@code origin} is greater than or equal to {@code bound}, an {@code IllegalArgumentException} will be thrown.
	 * 
	 * @param origin the least value returned
	 * @param bound the upper bound (exclusive)
	 * @return a pseudorandom {@code int} value between {@code origin} (inclusive) and {@code bound} (exclusive)
	 * @throws IllegalArgumentException thrown if, and only if, {@code origin} is greater than or equal to {@code bound}
	 */
	public static int nextInt(final int origin, final int bound) {
		return ThreadLocalRandom.current().nextInt(origin, bound);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	static float nextFloatInternal(final float bound, final float result) {
		return result < bound ? result : Float.intBitsToFloat(Float.floatToIntBits(bound) - 1);
	}
}