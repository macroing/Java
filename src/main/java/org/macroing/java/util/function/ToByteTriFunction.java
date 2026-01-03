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
package org.macroing.java.util.function;

/**
 * Represents a function that accepts three arguments and produces a {@code byte}-valued result.
 * <p>
 * This is the {@code byte}-producing primitive specialization for {@link TriFunction}.
 * <p>
 * This is a functional interface whose functional method is {@link #applyAsByte(Object, Object, Object)}.
 * 
 * @param <T> the type of the first argument to the function
 * @param <U> the type of the second argument to the function
 * @param <V> the type of the third argument to the function
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
@FunctionalInterface
public interface ToByteTriFunction<T, U, V> {
	/**
	 * Applies this function to the given arguments.
	 * <p>
	 * Returns the function result.
	 * 
	 * @param t the first function argument
	 * @param u the second function argument
	 * @param v the third function argument
	 * @return the function result
	 */
	byte applyAsByte(final T t, final U u, final V v);
}