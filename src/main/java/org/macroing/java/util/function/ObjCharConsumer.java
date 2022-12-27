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
 * Represents an operation that accepts an {@code Object}-valued and a {@code char}-valued argument, and returns no result.
 * <p>
 * This is the {@code (reference, char)} specialization of {@code BiConsumer}.
 * <p>
 * Unlike most other functional interfaces, {@code ObjCharConsumer} is expected to operate via side-effects.
 * <p>
 * This is a functional interface whose functional method is {@link #accept(Object, char)}.
 * 
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
@FunctionalInterface
public interface ObjCharConsumer<T> {
	/**
	 * Performs this operation on the given arguments.
	 * 
	 * @param t the first input argument
	 * @param value the second input argument
	 */
	void accept(final T t, final char value);
}