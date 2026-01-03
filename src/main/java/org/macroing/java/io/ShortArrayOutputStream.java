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
package org.macroing.java.io;

import java.io.OutputStream;
import java.util.Arrays;

/**
 * A {@code ShortArrayOutputStream} is an {@code OutputStream} implementation that writes data to a {@code short} array.
 * 
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
public final class ShortArrayOutputStream extends OutputStream {
	private static final int MAX_ARRAY_SIZE = (Integer.MAX_VALUE - 8) / 2;
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private int size;
	private short[] buffer;
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Constructs a new {@code ShortArrayOutputStream} instance with an initial capacity of {@code 32}.
	 * <p>
	 * Calling this constructor is equivalent to the following:
	 * <pre>
	 * {@code
	 * new ShortArrayOutputStream(32);
	 * }
	 * </pre>
	 */
	public ShortArrayOutputStream() {
		this(32);
	}
	
	/**
	 * Constructs a new {@code ShortArrayOutputStream} instance with an initial capacity of {@code capacity}.
	 * <p>
	 * If {@code capacity} is less than {@code 0}, an {@code IllegalArgumentException} will be thrown.
	 * 
	 * @param capacity the initial capacity
	 * @throws IllegalArgumentException thrown if, and only if, {@code capacity} is less than {@code 0}
	 */
	public ShortArrayOutputStream(final int capacity) {
		this.size = 0;
		this.buffer = new short[doRequireMinimum(capacity, 0, "capacity")];
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Returns the number of {@code short} values that can be written without expanding the current {@code short} array.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * int available = shortArrayOutputStream.capacity() - shortArrayOutputStream.size();
	 * }
	 * </pre>
	 * 
	 * @return the number of {@code short} values that can be written without expanding the current {@code short} array
	 */
	public synchronized int available() {
		return capacity() - size();
	}
	
	/**
	 * Returns the capacity of this {@code ShortArrayOutputStream} instance.
	 * <p>
	 * The capacity represents the length of the current {@code short} array.
	 * 
	 * @return the capacity of this {@code ShortArrayOutputStream} instance
	 */
	public synchronized int capacity() {
		return this.buffer.length;
	}
	
	/**
	 * Returns the size of this {@code ShortArrayOutputStream} instance.
	 * <p>
	 * The size represents the number of {@code short} values that have been written so far.
	 * 
	 * @return the size of this {@code ShortArrayOutputStream} instance
	 */
	public synchronized int size() {
		return this.size;
	}
	
	/**
	 * Returns a {@code short} array that contains the {@code short} values that have been written so far.
	 * 
	 * @return a {@code short} array that contains the {@code short} values that have been written so far
	 */
	public synchronized short[] toShortArray() {
		return Arrays.copyOf(this.buffer, this.size);
	}
	
	/**
	 * Closing a {@code ShortArrayOutputStream} instance has no effect.
	 * <p>
	 * The methods in this class can be called after the stream has been closed without generating an {@code IOException}.
	 */
	@Override
	public void close() {
//		Do nothing.
	}
	
	/**
	 * Resets this {@code ShortArrayOutputStream} instance so that the size is {@code 0}.
	 */
	public synchronized void reset() {
		this.size = 0;
	}
	
	/**
	 * Writes the specified {@code byte} value to this {@code ShortArrayOutputStream} instance.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * shortArrayOutputStream.write((byte)(b));
	 * }
	 * </pre>
	 * 
	 * @param b the {@code byte} value to write
	 */
	@Override
	public synchronized void write(final int b) {
		write((byte)(b));
	}
	
	/**
	 * Writes the specified {@code short} value to this {@code ShortArrayOutputStream} instance.
	 * 
	 * @param s the {@code short} value to write
	 */
	public synchronized void write(final short s) {
		doEnsureCapacity(this.size + 1);
		
		this.buffer[this.size] = s;
		this.size += 1;
	}
	
	/**
	 * Writes {@code s.length} {@code short} values, starting at offset {@code 0}, from {@code s} to this {@code ShortArrayOutputStream} instance.
	 * <p>
	 * If {@code s} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * shortArrayOutputStream.write(s, 0, s.length);
	 * }
	 * </pre>
	 * 
	 * @param s the {@code short} array to write from
	 * @throws NullPointerException thrown if, and only if, {@code s} is {@code null}
	 */
	public synchronized void write(final short[] s) {
		write(s, 0, s.length);
	}
	
	/**
	 * Writes {@code len} {@code short} values, starting at offset {@code off}, from {@code s} to this {@code ShortArrayOutputStream} instance.
	 * <p>
	 * If {@code s} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If either {@code off < 0}, {@code off > s.length}, {@code len < 0} or {@code off + len - s.length > 0}, an {@code IndexOutOfBoundsException} will be thrown.
	 * 
	 * @param s the {@code short} array to write from
	 * @param off the offset to start at in {@code s}
	 * @param len the number of {@code short} values to write from {@code s}
	 * @throws IndexOutOfBoundsException thrown if, and only if, either {@code off < 0}, {@code off > s.length}, {@code len < 0} or {@code off + len - s.length > 0}
	 * @throws NullPointerException thrown if, and only if, {@code s} is {@code null}
	 */
	public synchronized void write(final short[] s, final int off, final int len) {
		if(off < 0 || off > s.length || len < 0 || off + len - s.length > 0) {
			throw new IndexOutOfBoundsException();
		}
		
		doEnsureCapacity(this.size + len);
		
		System.arraycopy(s, off, this.buffer, this.size, len);
		
		this.size += len;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private void doEnsureCapacity(final int minCapacity) {
		if(minCapacity - this.buffer.length > 0) {
			doGrow(minCapacity);
		}
	}
	
	private void doGrow(final int minCapacity) {
//		Unable to verify that this code will ever be executed:
//		if(minCapacity < 0) {
//			throw new OutOfMemoryError();
//		}
		
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
	
	private static int doRequireMinimum(final int value, final int minimum, final String name) {
		if(value < minimum) {
			throw new IllegalArgumentException(String.format("%s < %d: %s == %d", name, Integer.valueOf(minimum), name, Integer.valueOf(value)));
		}
		
		return value;
	}
}