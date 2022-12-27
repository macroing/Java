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

/**
 * Represents a function that accepts a {@code long}-valued argument and produces a {@code boolean}-valued result.
 * <p>
 * This is the {@code long}-to-{@code boolean} primitive specialization for {@code Function}.
 * <p>
 * This is a functional interface whose functional method is {@link #applyAsBoolean(long)}.
 * 
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
@FunctionalInterface
public interface LongToBooleanFunction {
	/**
	 * Applies this function to the given argument.
	 * <p>
	 * Returns the function result.
	 * 
	 * @param value the function argument
	 * @return the function result
	 */
	boolean applyAsBoolean(final long value);
}