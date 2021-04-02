/**
 * Copyright 2021 J&#246;rgen Lundgren
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
 * Represents a function that accepts two arguments and produces a {@code float}-valued result.
 * <p>
 * This is the {@code float}-producing primitive specialization for {@code BiFunction}.
 * <p>
 * This is a functional interface whose functional method is {@link #applyAsFloat(Object, Object)}.
 * 
 * @param <T> the type of the first argument to the function
 * @param <U> the type of the second argument to the function
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
@FunctionalInterface
public interface ToFloatBiFunction<T, U> {
	/**
	 * Applies this function to the given arguments.
	 * <p>
	 * Returns the function result.
	 * 
	 * @param t the first function argument
	 * @param u the second function argument
	 * @return the function result
	 */
	float applyAsFloat(final T t, final U u);
}