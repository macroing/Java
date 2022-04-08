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

import java.lang.reflect.Field;//TODO: Add Unit Tests!
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Supplier;

import org.macroing.java.util.function.ShortConsumer;
import org.macroing.java.util.function.ShortSupplier;

/**
 * A container object which may or may not contain a {@code short} value.
 * <p>
 * If a value is present, {@link #isPresent()} will return {@code true} and {@link #getAsShort()} will return the value.
 * <p>
 * Additional methods that depend on the presence or absence of a contained value are provided, such as {@link #orElse(short)} (return a default value if value not present) and {@link #ifPresent(ShortConsumer)} (execute a block of code if the value
 * is present).
 * <p>
 * This is a value-based class; use of identity-sensitive operations (including reference equality ({@code ==}), identity hash code, or synchronization) on instances of {@code OptionalShort} may have unpredictable results and should be avoided.
 * 
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
public final class OptionalShort {
	private static final OptionalShort EMPTY = new OptionalShort(null);
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Short value;
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private OptionalShort(final Short value) {
		this.value = value;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Returns a non-empty string representation of this object suitable for debugging.
	 * <p>
	 * The exact presentation format is unspecified and may vary between implementations and versions.
	 * <p>
	 * If a value is present the result must include its string representation in the result.
	 * <p>
	 * Empty and present instances must be unambiguously differentiable.
	 * 
	 * @return a non-empty string representation of this object suitable for debugging
	 */
//	TODO: Add Unit Tests!
	@Override
	public String toString() {
		return this.value != null ? String.format("OptionalShort[%s]", this.value) : "OptionalShort.empty";
	}
	
	/**
	 * Indicates whether some other {@code Object} is "equal to" this {@code OptionalShort}.
	 * <p>
	 * The other {@code Object} is considered equal if:
	 * <ul>
	 * <li>it is also an {@code OptionalShort} and;</li>
	 * <li>both instances have no value present or;</li>
	 * <li>the present values are "equal to" each other.</li>
	 * </ul>
	 * 
	 * @param object an {@code Object} to be tested for equality
	 * @return {@code true} if the other {@code Object} is "equal to" this {@code OptionalShort} otherwise {@code false}
	 */
//	TODO: Add Unit Tests!
	@Override
	public boolean equals(final Object object) {
		if(object == this) {
			return true;
		} else if(!(object instanceof OptionalShort)) {
			return false;
		} else if(!Objects.equals(OptionalShort.class.cast(object).value, this.value)) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Returns {@code true} if there is a value present, otherwise {@code false}.
	 * 
	 * @return {@code true} if there is a value present, otherwise {@code false}
	 */
//	TODO: Add Unit Tests!
	public boolean isPresent() {
		return this.value != null;
	}
	
	/**
	 * Returns the hash code value of the present value, if any, or {@code 0} (zero) if no value is present.
	 * 
	 * @return the hash code value of the present value, if any, or {@code 0} (zero) if no value is present
	 */
//	TODO: Add Unit Tests!
	@Override
	public int hashCode() {
		return isPresent() ? this.value.hashCode() : 0;
	}
	
	/**
	 * If a value is present in this {@code OptionalShort}, returns the value, otherwise throws {@code NoSuchElementException}.
	 * 
	 * @return the value held by this {@code OptionalShort}
	 * @throws NoSuchElementException if there is no value present
	 */
//	TODO: Add Unit Tests!
	public short getAsShort() {
		return orElseThrow(NoSuchElementException::new);
	}
	
	/**
	 * Returns the value if present, otherwise returns {@code other}.
	 * 
	 * @param other the value to be returned if there is no value present
	 * @return the value if present, otherwise returns {@code other}
	 */
//	TODO: Add Unit Tests!
	public short orElse(final short other) {
		return isPresent() ? this.value.shortValue() : other;
	}
	
	/**
	 * Returns the value if present, otherwise invokes {@code other} and returns the result of that invocation.
	 * 
	 * @param other a {@code ShortSupplier} whose result is returned if no value is present
	 * @return the value if present, otherwise invokes {@code other} and returns the result of that invocation
	 * @throws NullPointerException if value is not present and {@code other} is {@code null}
	 */
//	TODO: Add Unit Tests!
	public short orElseGet(final ShortSupplier other) {
		return isPresent() ? this.value.shortValue() : other.getAsShort();
	}
	
	/**
	 * Returns the contained value, if present, otherwise throws a {@code Throwable} to be created by the provided {@code Supplier}.
	 * 
	 * @param <X> the type of the {@code Throwable} to be thrown
	 * @param exceptionSupplier the {@code Supplier} which will return the {@code Throwable} to be thrown
	 * @return the contained value, if present
	 * @throws NullPointerException if no value is present and {@code exceptionSupplier} is {@code null}
	 * @throws X if there is no value present
	 */
//	TODO: Add Unit Tests!
	public <X extends Throwable> short orElseThrow(final Supplier<X> exceptionSupplier) throws X {
		if(isPresent()) {
			return this.value.shortValue();
		}
		
		throw exceptionSupplier.get();
	}
	
	/**
	 * Have the specified {@code consumer} accept the value if a value is present, otherwise do nothing.
	 * 
	 * @param consumer block to be executed if a value is present
	 * @throws NullPointerException if value is present and {@code consumer} is {@code null}
	 */
//	TODO: Add Unit Tests!
	public void ifPresent(final ShortConsumer consumer) {
		if(isPresent()) {
			consumer.accept(this.value.shortValue());
		}
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Returns an empty {@code OptionalShort} instance.
	 * <p>
	 * No value is present for this {@code OptionalShort}.
	 * <p>
	 * Though it may be tempting to do so, avoid testing if an object is empty by comparing with {@code ==} against instances returned by {@code OptionalShort.empty()}. There is no guarantee that it is a singleton. Instead, use {@link #isPresent()}.
	 * 
	 * @return an empty {@code OptionalShort} instance
	 */
//	TODO: Add Unit Tests!
	public static OptionalShort empty() {
		return EMPTY;
	}
	
	/**
	 * Returns an {@code OptionalShort} with the specified value present.
	 * 
	 * @param value the value to be present
	 * @return an {@code OptionalShort} with the specified value present
	 */
//	TODO: Add Unit Tests!
	public static OptionalShort of(final short value) {
		return new OptionalShort(Short.valueOf(value));
	}
}