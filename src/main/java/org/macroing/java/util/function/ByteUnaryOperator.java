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
 * Represents an operation on a single {@code byte}-valued operand that produces a {@code byte}-valued result.
 * <p>
 * This is the primitive type specialization of {@code UnaryOperator} for {@code byte}.
 * <p>
 * This is a functional interface whose functional method is {@link #applyAsByte(byte)}.
 * 
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
@FunctionalInterface
public interface ByteUnaryOperator {
	/**
	 * Applies this operator to the given operand.
	 * <p>
	 * Returns the operator result.
	 * 
	 * @param operand the operand
	 * @return the operator result
	 */
	byte applyAsByte(final byte operand);
	
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
	default ByteUnaryOperator andThen(final ByteUnaryOperator after) {
		Objects.requireNonNull(after, "after == null");
		
		return (byte v) -> after.applyAsByte(applyAsByte(v));
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
	default ByteUnaryOperator compose(final ByteUnaryOperator before) {
		Objects.requireNonNull(before, "before == null");
		
		return (byte v) -> applyAsByte(before.applyAsByte(v));
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Returns a unary operator that always returns its input argument.
	 * 
	 * @return a unary operator that always returns its input argument
	 */
	static ByteUnaryOperator identity() {
		return t -> t;
	}
}