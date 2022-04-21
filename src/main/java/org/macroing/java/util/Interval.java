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
package org.macroing.java.util;

import java.util.Objects;

/**
 * This {@code Interval} class represents an interval and can be constructed for data types that implement the {@code Comparable} interface.
 * <p>
 * To demonstrate how to use this class, consider the following example:
 * <pre>
 * {@code
 * Interval<Integer> interval = new Interval<>(0, 10);
 * 
 * boolean contains = interval.contains(5);
 * }
 * </pre>
 * This class has potential to be thread-safe, in which case it's suitable for concurrent use without external synchronization. The {@code Interval} class is itself "immutable", but its endpoints may or may not be.
 * 
 * @param <T> the type of the interval
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
public final class Interval<T extends Comparable<T>> {
	private final T endpointA;
	private final T endpointB;
	private final boolean isIncludingEndpointA;
	private final boolean isIncludingEndpointB;
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Constructs a new {@code Interval} instance with {@code endpointA} and {@code endpointB} as endpoints.
	 * <p>
	 * If either {@code endpointA} or {@code endpointB} are {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * Calling this constructor is equivalent to the following:
	 * <pre>
	 * {@code
	 * new Interval(endpointA, endpointB, false);
	 * }
	 * </pre>
	 * 
	 * @param endpointA one of the endpoints
	 * @param endpointB one of the endpoints
	 * @throws NullPointerException thrown if, and only if, either {@code endpointA} or {@code endpointB} are {@code null}
	 */
	public Interval(final T endpointA, final T endpointB) {
		this(endpointA, endpointB, false);
	}
	
	/**
	 * Constructs a new {@code Interval} instance with {@code endpointA} and {@code endpointB} as endpoints.
	 * <p>
	 * If either {@code endpointA} or {@code endpointB} are {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * Calling this constructor is equivalent to the following:
	 * <pre>
	 * {@code
	 * new Interval(endpointA, endpointB, isIncludingEndpoints, isIncludingEndpoints);
	 * }
	 * </pre>
	 * 
	 * @param endpointA one of the endpoints
	 * @param endpointB one of the endpoints
	 * @param isIncludingEndpoints {@code true} if, and only if, {@code endpointA} and {@code endpointB} should be included, {@code false} otherwise
	 * @throws NullPointerException thrown if, and only if, either {@code endpointA} or {@code endpointB} are {@code null}
	 */
	public Interval(final T endpointA, final T endpointB, final boolean isIncludingEndpoints) {
		this(endpointA, endpointB, isIncludingEndpoints, isIncludingEndpoints);
	}
	
	/**
	 * Constructs a new {@code Interval} instance with {@code endpointA} and {@code endpointB} as endpoints.
	 * <p>
	 * If either {@code endpointA} or {@code endpointB} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param endpointA one of the endpoints
	 * @param endpointB one of the endpoints
	 * @param isIncludingEndpointA {@code true} if, and only if, {@code endpointA} should be included, {@code false} otherwise
	 * @param isIncludingEndpointB {@code true} if, and only if, {@code endpointB} should be included, {@code false} otherwise
	 * @throws NullPointerException thrown if, and only if, either {@code endpointA} or {@code endpointB} are {@code null}
	 */
	public Interval(final T endpointA, final T endpointB, final boolean isIncludingEndpointA, final boolean isIncludingEndpointB) {
		this.endpointA = Objects.requireNonNull(endpointA, "endpointA == null");
		this.endpointB = Objects.requireNonNull(endpointB, "endpointB == null");
		this.isIncludingEndpointA = isIncludingEndpointA;
		this.isIncludingEndpointB = isIncludingEndpointB;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Returns a {@code String} representation of this {@code Interval} instance.
	 * 
	 * @return a {@code String} representation of this {@code Interval} instance
	 */
	@Override
	public String toString() {
		final String endpointA = getEndpointA().toString();
		final String endpointASymbol = isIncludingEndpointA() ? "[" : "(";
		final String endpointB = getEndpointB().toString();
		final String endpointBSymbol = isIncludingEndpointB() ? "]" : ")";
		
		return String.format("%s%s,%s%s", endpointASymbol, endpointA, endpointB, endpointBSymbol);
	}
	
	/**
	 * Returns the endpoint denoted by {@code A}.
	 * 
	 * @return the endpoint denoted by {@code A}
	 */
	public T getEndpointA() {
		return this.endpointA;
	}
	
	/**
	 * Returns the endpoint denoted by {@code B}.
	 * 
	 * @return the endpoint denoted by {@code B}
	 */
	public T getEndpointB() {
		return this.endpointB;
	}
	
	/**
	 * Returns {@code true} if, and only if, {@code value} is contained in this {@code Interval} instance, {@code false} otherwise.
	 * <p>
	 * If {@code value} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param value the value to check for containment
	 * @return {@code true} if, and only if, {@code value} is contained in this {@code Interval} instance, {@code false} otherwise
	 * @throws NullPointerException thrown if, and only if, {@code value} is {@code null}
	 */
	public boolean contains(final T value) {
		final T a = doGetMinimumEndpoint();
		final T b = doGetMaximumEndpoint();
		final T c = Objects.requireNonNull(value, "value == null");
		
		final int compareToAC = a.compareTo(c);
		final int compareToCB = c.compareTo(b);
		
		final boolean isContainedAC = doIsIncludingMinimumEndpoint() ? compareToAC <= 0 : compareToAC < 0;
		final boolean isContainedCB = doIsIncludingMaximumEndpoint() ? compareToCB <= 0 : compareToCB < 0;
		
		return isContainedAC && isContainedCB;
	}
	
	/**
	 * Compares {@code object} to this {@code Interval} instance for equality.
	 * <p>
	 * Returns {@code true} if, and only if, {@code object} is an instance of {@code Interval}, and their respective values are equal, {@code false} otherwise.
	 * 
	 * @param object the {@code Object} to compare to this {@code Interval} instance for equality
	 * @return {@code true} if, and only if, {@code object} is an instance of {@code Interval}, and their respective values are equal, {@code false} otherwise
	 */
	@Override
	public boolean equals(final Object object) {
		if(object == this) {
			return true;
		} else if(!(object instanceof Interval)) {
			return false;
		} else if(!Objects.equals(this.endpointA, Interval.class.cast(object).endpointA)) {
			return false;
		} else if(!Objects.equals(this.endpointB, Interval.class.cast(object).endpointB)) {
			return false;
		} else if(this.isIncludingEndpointA != Interval.class.cast(object).isIncludingEndpointA) {
			return false;
		} else if(this.isIncludingEndpointB != Interval.class.cast(object).isIncludingEndpointB) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Returns {@code true} if, and only if, this {@code Interval} instance is closed, {@code false} otherwise.
	 * <p>
	 * An interval is said to be closed if both endpoints are included.
	 * 
	 * @return {@code true} if, and only if, this {@code Interval} instance is closed, {@code false} otherwise
	 */
	public boolean isClosed() {
		return isIncludingEndpointA() && isIncludingEndpointB();
	}
	
	/**
	 * Returns {@code true} if, and only if, this {@code Interval} instance excludes the endpoint denoted by {@code A}, {@code false} otherwise.
	 * 
	 * @return {@code true} if, and only if, this {@code Interval} instance excludes the endpoint denoted by {@code A}, {@code false} otherwise
	 */
	public boolean isExcludingEndpointA() {
		return !isIncludingEndpointA();
	}
	
	/**
	 * Returns {@code true} if, and only if, this {@code Interval} instance excludes the endpoint denoted by {@code B}, {@code false} otherwise.
	 * 
	 * @return {@code true} if, and only if, this {@code Interval} instance excludes the endpoint denoted by {@code B}, {@code false} otherwise
	 */
	public boolean isExcludingEndpointB() {
		return !isIncludingEndpointB();
	}
	
	/**
	 * Returns {@code true} if, and only if, {@code value} is greater than this {@code Interval} instance, {@code false} otherwise.
	 * <p>
	 * If {@code value} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param value the value to check
	 * @return {@code true} if, and only if, {@code value} is greater than this {@code Interval} instance, {@code false} otherwise
	 * @throws NullPointerException thrown if, and only if, {@code value} is {@code null}
	 */
	public boolean isGreaterThan(final T value) {
		return doIsIncludingMaximumEndpoint() ? value.compareTo(doGetMaximumEndpoint()) > 0 : value.compareTo(doGetMaximumEndpoint()) >= 0;
	}
	
	/**
	 * Returns {@code true} if, and only if, this {@code Interval} instance is half open, {@code false} otherwise.
	 * <p>
	 * An interval is said to be half open if one endpoint is included and the other is excluded.
	 * 
	 * @return {@code true} if, and only if, this {@code Interval} instance is half open, {@code false} otherwise
	 */
	public boolean isHalfOpen() {
		return isIncludingEndpointA() && isExcludingEndpointB() || isExcludingEndpointA() && isIncludingEndpointB();
	}
	
	/**
	 * Returns {@code true} if, and only if, this {@code Interval} instance includes the endpoint denoted by {@code A}, {@code false} otherwise.
	 * 
	 * @return {@code true} if, and only if, this {@code Interval} instance includes the endpoint denoted by {@code A}, {@code false} otherwise
	 */
	public boolean isIncludingEndpointA() {
		return this.isIncludingEndpointA;
	}
	
	/**
	 * Returns {@code true} if, and only if, this {@code Interval} instance includes the endpoint denoted by {@code B}, {@code false} otherwise.
	 * 
	 * @return {@code true} if, and only if, this {@code Interval} instance includes the endpoint denoted by {@code B}, {@code false} otherwise
	 */
	public boolean isIncludingEndpointB() {
		return this.isIncludingEndpointB;
	}
	
	/**
	 * Returns {@code true} if, and only if, {@code value} is less than this {@code Interval} instance, {@code false} otherwise.
	 * <p>
	 * If {@code value} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param value the value to check
	 * @return {@code true} if, and only if, {@code value} is less than this {@code Interval} instance, {@code false} otherwise
	 * @throws NullPointerException thrown if, and only if, {@code value} is {@code null}
	 */
	public boolean isLessThan(final T value) {
		return doIsIncludingMinimumEndpoint() ? value.compareTo(doGetMinimumEndpoint()) < 0 : value.compareTo(doGetMinimumEndpoint()) <= 0;
	}
	
	/**
	 * Returns {@code true} if, and only if, this {@code Interval} instance is open, {@code false} otherwise.
	 * <p>
	 * An interval is said to be open if both endpoints are excluded.
	 * 
	 * @return {@code true} if, and only if, this {@code Interval} instance is open, {@code false} otherwise
	 */
	public boolean isOpen() {
		return isExcludingEndpointA() && isExcludingEndpointB();
	}
	
	/**
	 * Returns a hash code for this {@code Interval} instance.
	 * 
	 * @return a hash code for this {@code Interval} instance
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.endpointA, this.endpointB, Boolean.valueOf(this.isIncludingEndpointA), Boolean.valueOf(this.isIncludingEndpointB));
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Returns a new {@code Interval} instance with {@code endpointA} and {@code endpointB} as endpoints.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * Interval.of(endpointA, endpointB, false);
	 * }
	 * </pre>
	 * 
	 * @param endpointA one of the endpoints
	 * @param endpointB one of the endpoints
	 * @return a new {@code Interval} instance with {@code endpointA} and {@code endpointB} as endpoints
	 */
	public static Interval<Integer> of(final int endpointA, final int endpointB) {
		return of(endpointA, endpointB, false);
	}
	
	/**
	 * Returns a new {@code Interval} instance with {@code endpointA} and {@code endpointB} as endpoints.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * Interval.of(endpointA, endpointB, isIncludingEndpoints, isIncludingEndpoints);
	 * }
	 * </pre>
	 * 
	 * @param endpointA one of the endpoints
	 * @param endpointB one of the endpoints
	 * @param isIncludingEndpoints {@code true} if, and only if, {@code endpointA} and {@code endpointB} should be included, {@code false} otherwise
	 * @return a new {@code Interval} instance with {@code endpointA} and {@code endpointB} as endpoints
	 */
	public static Interval<Integer> of(final int endpointA, final int endpointB, final boolean isIncludingEndpoints) {
		return of(endpointA, endpointB, isIncludingEndpoints, isIncludingEndpoints);
	}
	
	/**
	 * Returns a new {@code Interval} instance with {@code endpointA} and {@code endpointB} as endpoints.
	 * 
	 * @param endpointA one of the endpoints
	 * @param endpointB one of the endpoints
	 * @param isIncludingEndpointA {@code true} if, and only if, {@code endpointA} should be included, {@code false} otherwise
	 * @param isIncludingEndpointB {@code true} if, and only if, {@code endpointB} should be included, {@code false} otherwise
	 * @return a new {@code Interval} instance with {@code endpointA} and {@code endpointB} as endpoints
	 */
	public static Interval<Integer> of(final int endpointA, final int endpointB, final boolean isIncludingEndpointA, final boolean isIncludingEndpointB) {
		return new Interval<>(Integer.valueOf(endpointA), Integer.valueOf(endpointB), isIncludingEndpointA, isIncludingEndpointB);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private T doGetMaximumEndpoint() {
		return this.endpointA.compareTo(this.endpointB) <= 0 ? this.endpointB : this.endpointA;
	}
	
	private T doGetMinimumEndpoint() {
		return this.endpointA.compareTo(this.endpointB) <= 0 ? this.endpointA : this.endpointB;
	}
	
	private boolean doIsIncludingMaximumEndpoint() {
		return this.endpointA.compareTo(this.endpointB) <= 0 ? this.isIncludingEndpointB : this.isIncludingEndpointA;
	}
	
	private boolean doIsIncludingMinimumEndpoint() {
		return this.endpointA.compareTo(this.endpointB) <= 0 ? this.isIncludingEndpointA : this.isIncludingEndpointB;
	}
}