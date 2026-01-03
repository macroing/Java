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

import java.util.Objects;

/**
 * Represents an operation on a single {@code char}-valued operand that produces a {@code char}-valued result.
 * <p>
 * This is the primitive type specialization of {@code UnaryOperator} for {@code char}.
 * <p>
 * This is a functional interface whose functional method is {@link #applyAsChar(char)}.
 * 
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
@FunctionalInterface
public interface CharUnaryOperator {
	/**
	 * Applies this operator to the given operand.
	 * <p>
	 * Returns the operator result.
	 * 
	 * @param operand the operand
	 * @return the operator result
	 */
	char applyAsChar(final char operand);
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Returns a composed operator that first applies this operator to its input, and then applies the {@code after} operator to the result.
	 * <p>
	 * If {@code after} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If evaluation of either operator throws an exception, it is relayed to the caller of the composed operator.
	 * 
	 * @param after the operator to apply after this operator is applied
	 * @return a composed operator that first applies this operator to its input, and then applies the {@code after} operator to the result
	 * @throws NullPointerException thrown if, and only if, {@code after} is {@code null}
	 */
	default CharUnaryOperator andThen(final CharUnaryOperator after) {
		Objects.requireNonNull(after, "after == null");
		
		return (char v) -> after.applyAsChar(applyAsChar(v));
	}
	
	/**
	 * Returns a composed operator that first applies the {@code before} operator to its input, and then applies this operator to the result.
	 * <p>
	 * If {@code before} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If evaluation of either operator throws an exception, it is relayed to the caller of the composed operator.
	 * 
	 * @param before the operator to apply before this operator is applied
	 * @return a composed operator that first applies the {@code before} operator to its input, and then applies this operator to the result
	 * @throws NullPointerException thrown if, and only if, {@code before} is {@code null}
	 */
	default CharUnaryOperator compose(final CharUnaryOperator before) {
		Objects.requireNonNull(before, "before == null");
		
		return (char v) -> applyAsChar(before.applyAsChar(v));
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Returns a unary operator that always returns its input argument.
	 * 
	 * @return a unary operator that always returns its input argument
	 */
	static CharUnaryOperator identity() {
		return t -> t;
	}
}