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
package org.macroing.java.util.function;

import java.util.Objects;

/**
 * Represents an operation that accepts a single {@code boolean}-valued argument and returns no result.
 * <p>
 * This is the primitive type specialization of {@code Consumer} for {@code boolean}.
 * <p>
 * Unlike most other functional interfaces, {@code BooleanConsumer} is expected to operate via side-effects.
 * <p>
 * This is a functional interface whose functional method is {@link #accept(boolean)}.
 * 
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
@FunctionalInterface
public interface BooleanConsumer {
	/**
	 * Performs this operation on the given argument.
	 * 
	 * @param value the input argument
	 */
	void accept(final boolean value);
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Returns a composed {@code BooleanConsumer} that performs, in sequence, this operation followed by the {@code after} operation.
	 * <p>
	 * If {@code after} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If performing either operation throws an exception, it is relayed to the caller of the composed operation.
	 * <p>
	 * If performing this operation throws an exception, the {@code after} operation will not be performed.
	 * 
	 * @param after the operation to perform after this operation
	 * @return a composed {@code BooleanConsumer} that performs, in sequence, this operation followed by the {@code after} operation
	 * @throws NullPointerException thrown if, and only if, {@code after} is {@code null}
	 */
	default BooleanConsumer andThen(final BooleanConsumer after) {
		Objects.requireNonNull(after, "after == null");
		
		return (boolean t) -> {
			accept(t);
			
			after.accept(t);
		};
	}
}