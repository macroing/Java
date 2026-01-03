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
package org.macroing.java.util;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

/**
 * A {@code LazyReference} evaluates and stores a reference value lazily.
 * 
 * @param <T> the type of the value
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
public final class LazyReference<T> {
	private final AtomicReference<T> value;
	private final Supplier<T> valueSupplier;
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Constructs a new {@code LazyReference} instance.
	 * <p>
	 * If {@code valueSupplier} is {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param valueSupplier a {@code Supplier} instance
	 * @throws NullPointerException thrown if, and only if, {@code valueSupplier} is {@code null}
	 */
	public LazyReference(final Supplier<T> valueSupplier) {
		this.value = new AtomicReference<>();
		this.valueSupplier = Objects.requireNonNull(valueSupplier, "valueSupplier == null");
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Returns the value from this {@code LazyReference} instance.
	 * <p>
	 * If {@code valueSupplier.get()} returns {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * This method will set the value to {@code valueSupplier.get()} when the value has not been set.
	 * 
	 * @return the value from this {@code LazyReference} instance
	 * @throws NullPointerException thrown if, and only if, {@code valueSupplier.get()} returns {@code null}
	 */
	public T getValue() {
		return this.value.updateAndGet(currentValue -> currentValue == null ? Objects.requireNonNull(this.valueSupplier.get(), "valueSupplier.get() == null") : currentValue);
	}
}