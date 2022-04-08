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

import java.util.NoSuchElementException;
import java.util.function.Supplier;

import org.macroing.java.util.function.CharConsumer;
import org.macroing.java.util.function.CharSupplier;

/**
 * A container object which may or may not contain a {@code char} value.
 * <p>
 * If a value is present, {@link #isPresent()} will return {@code true} and {@link #getAsChar()} will return the value.
 * <p>
 * Additional methods that depend on the presence or absence of a contained value are provided, such as {@link #orElse(char)} (return a default value if value not present) and {@link #ifPresent(CharConsumer)} (execute a block of code if the value
 * is present).
 * <p>
 * This is a value-based class; use of identity-sensitive operations (including reference equality ({@code ==}), identity hash code, or synchronization) on instances of {@code OptionalChar} may have unpredictable results and should be avoided.
 * 
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
public final class OptionalChar {
	private static final OptionalChar EMPTY = new OptionalChar();
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private final boolean isPresent;
	private final char value;
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private OptionalChar() {
		this.isPresent = false;
		this.value = 0;
	}
	
	private OptionalChar(final char value) {
		this.isPresent = true;
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
	@Override
	public String toString() {
		return this.isPresent ? String.format("OptionalChar[%s]", Character.toString(this.value)) : "OptionalChar.empty";
	}
	
	/**
	 * Indicates whether some other {@code Object} is "equal to" this {@code OptionalChar}.
	 * <p>
	 * The other {@code Object} is considered equal if:
	 * <ul>
	 * <li>it is also an {@code OptionalChar} and;</li>
	 * <li>both instances have no value present or;</li>
	 * <li>the present values are "equal to" each other.</li>
	 * </ul>
	 * 
	 * @param object an {@code Object} to be tested for equality
	 * @return {@code true} if the other {@code Object} is "equal to" this {@code OptionalChar} otherwise {@code false}
	 */
	@Override
	public boolean equals(final Object object) {
		if(object == this) {
			return true;
		} else if(!(object instanceof OptionalChar)) {
			return false;
		} else {
			final OptionalChar optionalChar = (OptionalChar)(object);
			
			if(this.isPresent && optionalChar.isPresent) {
				return this.value == optionalChar.value;
			}
			
			/*
			 * The below code can only be true when comparing two empty OptionalChar instances.
			 * However, the empty() method returns a constant instance, so object == this above will handle that case.
			 */
			
//			return this.isPresent == optionalChar.isPresent;
			return false;
		}
	}
	
	/**
	 * Returns {@code true} if there is a value present, otherwise {@code false}.
	 * 
	 * @return {@code true} if there is a value present, otherwise {@code false}
	 */
	public boolean isPresent() {
		return this.isPresent;
	}
	
	/**
	 * If a value is present in this {@code OptionalChar}, returns the value, otherwise throws {@code NoSuchElementException}.
	 * 
	 * @return the value held by this {@code OptionalChar}
	 * @throws NoSuchElementException if there is no value present
	 */
	public char getAsChar() {
		if(!this.isPresent) {
			throw new NoSuchElementException("No value present");
		}
		
		return this.value;
	}
	
	/**
	 * Returns the value if present, otherwise returns {@code other}.
	 * 
	 * @param other the value to be returned if there is no value present
	 * @return the value if present, otherwise returns {@code other}
	 */
	public char orElse(final char other) {
		return this.isPresent ? this.value : other;
	}
	
	/**
	 * Returns the value if present, otherwise invokes {@code other} and returns the result of that invocation.
	 * 
	 * @param other a {@code CharSupplier} whose result is returned if no value is present
	 * @return the value if present, otherwise invokes {@code other} and returns the result of that invocation
	 * @throws NullPointerException if value is not present and {@code other} is {@code null}
	 */
	public char orElseGet(final CharSupplier other) {
		return this.isPresent ? this.value : other.getAsChar();
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
	public <X extends Throwable> char orElseThrow(final Supplier<X> exceptionSupplier) throws X {
		if(this.isPresent) {
			return this.value;
		}
		
		throw exceptionSupplier.get();
	}
	
	/**
	 * Returns the hash code value of the present value, if any, or {@code 0} (zero) if no value is present.
	 * 
	 * @return the hash code value of the present value, if any, or {@code 0} (zero) if no value is present
	 */
	@Override
	public int hashCode() {
		return this.isPresent ? Character.hashCode(this.value) : 0;
	}
	
	/**
	 * Have the specified {@code consumer} accept the value if a value is present, otherwise do nothing.
	 * 
	 * @param consumer block to be executed if a value is present
	 * @throws NullPointerException if value is present and {@code consumer} is {@code null}
	 */
	public void ifPresent(final CharConsumer consumer) {
		if(this.isPresent) {
			consumer.accept(this.value);
		}
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Returns an empty {@code OptionalChar} instance.
	 * <p>
	 * No value is present for this {@code OptionalChar}.
	 * <p>
	 * Though it may be tempting to do so, avoid testing if an object is empty by comparing with {@code ==} against instances returned by {@code OptionalChar.empty()}. There is no guarantee that it is a singleton. Instead, use {@link #isPresent()}.
	 * 
	 * @return an empty {@code OptionalChar} instance
	 */
	public static OptionalChar empty() {
		return EMPTY;
	}
	
	/**
	 * Returns an {@code OptionalChar} with the specified value present.
	 * 
	 * @param value the value to be present
	 * @return an {@code OptionalChar} with the specified value present
	 */
	public static OptionalChar of(final char value) {
		return new OptionalChar(value);
	}
}