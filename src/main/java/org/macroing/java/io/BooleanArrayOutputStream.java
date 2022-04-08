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
package org.macroing.java.io;

import java.io.OutputStream;
import java.lang.reflect.Field;//TODO: Add Unit Tests!
import java.util.Arrays;

/**
 * A {@code BooleanArrayOutputStream} is an {@code OutputStream} implementation that writes data to a {@code boolean} array.
 * 
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
public final class BooleanArrayOutputStream extends OutputStream {
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private boolean[] buffer;
	private int size;
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Constructs a new {@code BooleanArrayOutputStream} instance with an initial capacity of {@code 32}.
	 * <p>
	 * Calling this constructor is equivalent to the following:
	 * <pre>
	 * {@code
	 * new BooleanArrayOutputStream(32);
	 * }
	 * </pre>
	 */
//	TODO: Add Unit Tests!
	public BooleanArrayOutputStream() {
		this(32);
	}
	
	/**
	 * Constructs a new {@code BooleanArrayOutputStream} instance with an initial capacity of {@code capacity}.
	 * <p>
	 * If {@code capacity} is less than {@code 0}, an {@code IllegalArgumentException} will be thrown.
	 * 
	 * @param capacity the initial capacity
	 * @throws IllegalArgumentException thrown if, and only if, {@code capacity} is less than {@code 0}
	 */
//	TODO: Add Unit Tests!
	public BooleanArrayOutputStream(final int capacity) {
		this.buffer = new boolean[doRequireRange(capacity, 0, Integer.MAX_VALUE, "capacity")];
		this.size = 0;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Returns a {@code boolean} array that contains the {@code boolean} values that have been written so far.
	 * 
	 * @return a {@code boolean} array that contains the {@code boolean} values that have been written so far
	 */
//	TODO: Add Unit Tests!
	public synchronized boolean[] toBooleanArray() {
		return Arrays.copyOf(this.buffer, this.size);
	}
	
	/**
	 * Returns the number of {@code boolean} values that can be written without expanding the current {@code boolean} array.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * int available = booleanArrayOutputStream.capacity() - booleanArrayOutputStream.size();
	 * }
	 * </pre>
	 * 
	 * @return the number of {@code boolean} values that can be written without expanding the current {@code boolean} array
	 */
//	TODO: Add Unit Tests!
	public synchronized int available() {
		return capacity() - size();
	}
	
	/**
	 * Returns the capacity of this {@code BooleanArrayOutputStream} instance.
	 * <p>
	 * The capacity represents the length of the current {@code boolean} array.
	 * 
	 * @return the capacity of this {@code BooleanArrayOutputStream} instance
	 */
//	TODO: Add Unit Tests!
	public synchronized int capacity() {
		return this.buffer.length;
	}
	
	/**
	 * Returns the size of this {@code BooleanArrayOutputStream} instance.
	 * <p>
	 * The size represents the number of {@code boolean} values that have been written so far.
	 * 
	 * @return the size of this {@code BooleanArrayOutputStream} instance
	 */
//	TODO: Add Unit Tests!
	public synchronized int size() {
		return this.size;
	}
	
	/**
	 * Closing a {@code BooleanArrayOutputStream} instance has no effect.
	 * <p>
	 * The methods in this class can be called after the stream has been closed without generating an {@code IOException}.
	 */
//	TODO: Add Unit Tests!
	@Override
	public void close() {
		
	}
	
	/**
	 * Resets this {@code BooleanArrayOutputStream} instance so that the size is {@code 0}.
	 */
//	TODO: Add Unit Tests!
	public synchronized void reset() {
		this.size = 0;
	}
	
	/**
	 * Writes the specified {@code boolean} value to this {@code BooleanArrayOutputStream} instance.
	 * 
	 * @param b the {@code boolean} value to write
	 */
//	TODO: Add Unit Tests!
	public synchronized void write(final boolean b) {
		doEnsureCapacity(this.size + 1);
		
		this.buffer[this.size] = b;
		this.size += 1;
	}
	
	/**
	 * Writes {@code d.length} {@code boolean} values, starting at offset {@code 0}, from {@code b} to this {@code BooleanArrayOutputStream} instance.
	 * <p>
	 * If {@code b} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * booleanArrayOutputStream.write(b, 0, b.length);
	 * }
	 * </pre>
	 * 
	 * @param b the {@code boolean} array to write from
	 * @throws NullPointerException thrown if, and only if, {@code b} is {@code null}
	 */
//	TODO: Add Unit Tests!
	public synchronized void write(final boolean[] b) {
		write(b, 0, b.length);
	}
	
	/**
	 * Writes {@code len} {@code boolean} values, starting at offset {@code off}, from {@code b} to this {@code BooleanArrayOutputStream} instance.
	 * <p>
	 * If {@code b} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If either {@code off < 0}, {@code off > b.length}, {@code len < 0} or {@code off + len - b.length > 0}, an {@code IndexOutOfBoundsException} will be thrown.
	 * 
	 * @param b the {@code boolean} array to write from
	 * @param off the offset to start at in {@code b}
	 * @param len the number of {@code boolean} values to write from {@code b}
	 * @throws IndexOutOfBoundsException thrown if, and only if, either {@code off < 0}, {@code off > b.length}, {@code len < 0} or {@code off + len - b.length > 0}
	 * @throws NullPointerException thrown if, and only if, {@code b} is {@code null}
	 */
//	TODO: Add Unit Tests!
	public synchronized void write(final boolean[] b, final int off, final int len) {
//		Similar to ByteArrayOutputStream. It looks like 'off > b.length' is a bug. Should it not be 'off >= b.length'?
		if(off < 0 || off > b.length || len < 0 || off + len - b.length > 0) {
			throw new IndexOutOfBoundsException();
		}
		
		doEnsureCapacity(this.size + len);
		
		System.arraycopy(b, off, this.buffer, this.size, len);
		
		this.size += len;
	}
	
	/**
	 * Writes the specified {@code byte} value to this {@code BooleanArrayOutputStream} instance.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * booleanArrayOutputStream.write((byte)(b) != 0);
	 * }
	 * </pre>
	 * 
	 * @param b the {@code byte} value to write
	 */
//	TODO: Add Unit Tests!
	@Override
	public synchronized void write(final int b) {
		write((byte)(b) != 0);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private void doEnsureCapacity(final int minCapacity) {
		if(minCapacity - this.buffer.length > 0) {
			doGrow(minCapacity);
		}
	}
	
	private void doGrow(final int minCapacity) {
		if(minCapacity < 0) {
			throw new OutOfMemoryError();
		}
		
		int oldCapacity = this.buffer.length;
		int newCapacity = oldCapacity << 1;
		
		if(newCapacity - minCapacity < 0) {
			newCapacity = minCapacity;
		}
		
		if(newCapacity - MAX_ARRAY_SIZE > 0) {
			newCapacity = minCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
		}
		
		this.buffer = Arrays.copyOf(this.buffer, newCapacity);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private static int doRequireRange(final int value, final int minimum, final int maximum, final String name) {
		if(value < minimum) {
			throw new IllegalArgumentException(String.format("%s < %d: %s == %d", name, Integer.valueOf(minimum), name, Integer.valueOf(value)));
		} else if(value > maximum) {
			throw new IllegalArgumentException(String.format("%s > %d: %s == %d", name, Integer.valueOf(maximum), name, Integer.valueOf(value)));
		} else {
			return value;
		}
	}
}