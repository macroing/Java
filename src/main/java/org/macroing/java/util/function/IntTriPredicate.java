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
 * Represents a predicate ({@code boolean}-valued function) of three {@code int}-valued arguments.
 * <p>
 * This is a functional interface whose functional method is {@link #test(int, int, int)}.
 * 
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
@FunctionalInterface
public interface IntTriPredicate {
	/**
	 * Evaluates this predicate on the given arguments.
	 * <p>
	 * Returns {@code true} if, and only if, the input arguments matches the predicate, {@code false} otherwise.
	 * 
	 * @param a the first input argument
	 * @param b the second input argument
	 * @param c the third input argument
	 * @return {@code true} if, and only if, the input arguments matches the predicate, {@code false} otherwise
	 */
	boolean test(final int a, final int b, final int c);
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Returns a composed predicate that represents a short-circuiting logical AND of this predicate and another.
	 * <p>
	 * If {@code other} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * When evaluating the composed predicate, if this predicate is {@code false}, then the {@code other} predicate is not evaluated.
	 * <p>
	 * Any exceptions thrown during evaluation of either predicate are relayed to the caller; if evaluation of this predicate throws an exception, the {@code other} predicate will not be evaluated.
	 * 
	 * @param other the predicate on the right-hand side of the logical AND expression
	 * @return a composed predicate that represents a short-circuiting logical AND of this predicate and another
	 * @throws NullPointerException thrown if, and only if, {@code other} is {@code null}
	 */
	default IntTriPredicate and(final IntTriPredicate other) {
		Objects.requireNonNull(other, "other == null");
		
		return (a, b, c) -> test(a, b, c) && other.test(a, b, c);
	}
	
	/**
	 * Returns a predicate that represents the logical negation of this predicate.
	 * 
	 * @return a predicate that represents the logical negation of this predicate
	 */
	default IntTriPredicate negate() {
		return (a, b, c) -> !test(a, b, c);
	}
	
	/**
	 * Returns a composed predicate that represents a short-circuiting logical OR of this predicate and another.
	 * <p>
	 * If {@code other} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * When evaluating the composed predicate, if this predicate is {@code true}, then the {@code other} predicate is not evaluated.
	 * <p>
	 * Any exceptions thrown during evaluation of either predicate are relayed to the caller; if evaluation of this predicate throws an exception, the {@code other} predicate will not be evaluated.
	 * 
	 * @param other the predicate on the right-hand side of the logical OR expression
	 * @return a composed predicate that represents a short-circuiting logical OR of this predicate and another
	 * @throws NullPointerException thrown if, and only if, {@code other} is {@code null}
	 */
	default IntTriPredicate or(final IntTriPredicate other) {
		Objects.requireNonNull(other, "other == null");
		
		return (a, b, c) -> test(a, b, c) || other.test(a, b, c);
	}
}