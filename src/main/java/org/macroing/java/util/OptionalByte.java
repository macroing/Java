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

import org.macroing.java.util.function.ByteConsumer;
import org.macroing.java.util.function.ByteSupplier;

/**
 * A container object which may or may not contain a {@code byte} value.
 * <p>
 * If a value is present, {@link #isPresent()} will return {@code true} and {@link #getAsByte()} will return the value.
 * <p>
 * Additional methods that depend on the presence or absence of a contained value are provided, such as {@link #orElse(byte)} (return a default value if value not present) and {@link #ifPresent(ByteConsumer)} (execute a block of code if the value
 * is present).
 * <p>
 * This is a value-based class; use of identity-sensitive operations (including reference equality ({@code ==}), identity hash code, or synchronization) on instances of {@code OptionalByte} may have unpredictable results and should be avoided.
 * 
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
public final class OptionalByte {
	private static final OptionalByte EMPTY = new OptionalByte();
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private final boolean isPresent;
	private final byte value;
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private OptionalByte() {
		this.isPresent = false;
		this.value = 0;
	}
	
	private OptionalByte(final byte value) {
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
		return this.isPresent ? String.format("OptionalByte[%s]", Byte.toString(this.value)) : "OptionalByte.empty";
	}
	
	/**
	 * Indicates whether some other {@code Object} is "equal to" this {@code OptionalByte}.
	 * <p>
	 * The other {@code Object} is considered equal if:
	 * <ul>
	 * <li>it is also an {@code OptionalByte} and;</li>
	 * <li>both instances have no value present or;</li>
	 * <li>the present values are "equal to" each other.</li>
	 * </ul>
	 * 
	 * @param object an {@code Object} to be tested for equality
	 * @return {@code true} if the other {@code Object} is "equal to" this {@code OptionalByte} otherwise {@code false}
	 */
	@Override
	public boolean equals(final Object object) {
		if(object == this) {
			return true;
		} else if(!(object instanceof OptionalByte)) {
			return false;
		} else {
			final OptionalByte optionalByte = (OptionalByte)(object);
			
			if(this.isPresent && optionalByte.isPresent) {
				return this.value == optionalByte.value;
			}
			
			/*
			 * The below code can only be true when comparing two empty OptionalByte instances.
			 * However, the empty() method returns a constant instance, so object == this above will handle that case.
			 */
			
//			return this.isPresent == optionalByte.isPresent;
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
	 * If a value is present in this {@code OptionalByte}, returns the value, otherwise throws {@code NoSuchElementException}.
	 * 
	 * @return the value held by this {@code OptionalByte}
	 * @throws NoSuchElementException if there is no value present
	 */
	public byte getAsByte() {
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
	public byte orElse(final byte other) {
		return this.isPresent ? this.value : other;
	}
	
	/**
	 * Returns the value if present, otherwise invokes {@code other} and returns the result of that invocation.
	 * 
	 * @param other a {@code ByteSupplier} whose result is returned if no value is present
	 * @return the value if present, otherwise invokes {@code other} and returns the result of that invocation
	 * @throws NullPointerException if value is not present and {@code other} is {@code null}
	 */
	public byte orElseGet(final ByteSupplier other) {
		return this.isPresent ? this.value : other.getAsByte();
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
	public <X extends Throwable> byte orElseThrow(final Supplier<X> exceptionSupplier) throws X {
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
		return this.isPresent ? Byte.hashCode(this.value) : 0;
	}
	
	/**
	 * Have the specified {@code consumer} accept the value if a value is present, otherwise do nothing.
	 * 
	 * @param consumer block to be executed if a value is present
	 * @throws NullPointerException if value is present and {@code consumer} is {@code null}
	 */
	public void ifPresent(final ByteConsumer consumer) {
		if(this.isPresent) {
			consumer.accept(this.value);
		}
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Returns an empty {@code OptionalByte} instance.
	 * <p>
	 * No value is present for this {@code OptionalByte}.
	 * <p>
	 * Though it may be tempting to do so, avoid testing if an object is empty by comparing with {@code ==} against instances returned by {@code OptionalByte.empty()}. There is no guarantee that it is a singleton. Instead, use {@link #isPresent()}.
	 * 
	 * @return an empty {@code OptionalByte} instance
	 */
	public static OptionalByte empty() {
		return EMPTY;
	}
	
	/**
	 * Returns an {@code OptionalByte} with the specified value present.
	 * 
	 * @param value the value to be present
	 * @return an {@code OptionalByte} with the specified value present
	 */
	public static OptionalByte of(final byte value) {
		return new OptionalByte(value);
	}
}