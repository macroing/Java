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

/**
 * The class {@code Longs} contains methods for performing operations on {@code long} values.
 * 
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
public final class Longs {
	private Longs() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Returns a {@code long} with the bits of {@code value} reversed.
	 * 
	 * @param value a {@code long} value
	 * @return a {@code long} with the bits of {@code value} reversed
	 */
	public static long reverseBits(final long value) {
		final long value0 = Ints.reverseBits((int)(value >>>  0));
		final long value1 = Ints.reverseBits((int)(value >>> 32));
		
		return (value0 << 32) | value1;
	}
}