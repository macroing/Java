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

import java.lang.reflect.Field;//TODO: Add Unit Tests!
import java.util.Objects;

/**
 * Represents a predicate ({@code boolean}-valued function) of one {@code float}-valued argument.
 * <p>
 * This is the {@code float}-consuming primitive type specialization of {@code Predicate}.
 * <p>
 * This is a functional interface whose functional method is {@link #test(float)}.
 * 
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
@FunctionalInterface
public interface FloatPredicate {
	/**
	 * Evaluates this predicate on the given argument.
	 * <p>
	 * Returns {@code true} if, and only if, the input argument matches the predicate, {@code false} otherwise.
	 * 
	 * @param value the input argument
	 * @return {@code true} if, and only if, the input argument matches the predicate, {@code false} otherwise
	 */
	boolean test(final float value);
	
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
//	TODO: Add Unit Tests!
	default FloatPredicate and(final FloatPredicate other) {
		Objects.requireNonNull(other, "other == null");
		
		return value -> test(value) && other.test(value);
	}
	
	/**
	 * Returns a predicate that represents the logical negation of this predicate.
	 * 
	 * @return a predicate that represents the logical negation of this predicate
	 */
//	TODO: Add Unit Tests!
	default FloatPredicate negate() {
		return value -> !test(value);
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
//	TODO: Add Unit Tests!
	default FloatPredicate or(final FloatPredicate other) {
		Objects.requireNonNull(other, "other == null");
		
		return value -> test(value) || other.test(value);
	}
}