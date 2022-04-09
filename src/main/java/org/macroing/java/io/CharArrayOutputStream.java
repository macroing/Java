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
import java.util.Arrays;

/**
 * A {@code CharArrayOutputStream} is an {@code OutputStream} implementation that writes data to a {@code char} array.
 * 
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
public final class CharArrayOutputStream extends OutputStream {
	private static final int MAX_ARRAY_SIZE = (Integer.MAX_VALUE - 8) / 2;
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private char[] buffer;
	private int size;
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Constructs a new {@code CharArrayOutputStream} instance with an initial capacity of {@code 32}.
	 * <p>
	 * Calling this constructor is equivalent to the following:
	 * <pre>
	 * {@code
	 * new CharArrayOutputStream(32);
	 * }
	 * </pre>
	 */
	public CharArrayOutputStream() {
		this(32);
	}
	
	/**
	 * Constructs a new {@code CharArrayOutputStream} instance with an initial capacity of {@code capacity}.
	 * <p>
	 * If {@code capacity} is less than {@code 0}, an {@code IllegalArgumentException} will be thrown.
	 * 
	 * @param capacity the initial capacity
	 * @throws IllegalArgumentException thrown if, and only if, {@code capacity} is less than {@code 0}
	 */
	public CharArrayOutputStream(final int capacity) {
		this.buffer = new char[doRequireMinimum(capacity, 0, "capacity")];
		this.size = 0;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Returns a {@code char} array that contains the {@code char} values that have been written so far.
	 * 
	 * @return a {@code char} array that contains the {@code char} values that have been written so far
	 */
	public synchronized char[] toCharArray() {
		return Arrays.copyOf(this.buffer, this.size);
	}
	
	/**
	 * Returns the number of {@code char} values that can be written without expanding the current {@code char} array.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * int available = charArrayOutputStream.capacity() - charArrayOutputStream.size();
	 * }
	 * </pre>
	 * 
	 * @return the number of {@code char} values that can be written without expanding the current {@code char} array
	 */
	public synchronized int available() {
		return capacity() - size();
	}
	
	/**
	 * Returns the capacity of this {@code CharArrayOutputStream} instance.
	 * <p>
	 * The capacity represents the length of the current {@code char} array.
	 * 
	 * @return the capacity of this {@code CharArrayOutputStream} instance
	 */
	public synchronized int capacity() {
		return this.buffer.length;
	}
	
	/**
	 * Returns the size of this {@code CharArrayOutputStream} instance.
	 * <p>
	 * The size represents the number of {@code char} values that have been written so far.
	 * 
	 * @return the size of this {@code CharArrayOutputStream} instance
	 */
	public synchronized int size() {
		return this.size;
	}
	
	/**
	 * Closing a {@code CharArrayOutputStream} instance has no effect.
	 * <p>
	 * The methods in this class can be called after the stream has been closed without generating an {@code IOException}.
	 */
	@Override
	public void close() {
		
	}
	
	/**
	 * Resets this {@code CharArrayOutputStream} instance so that the size is {@code 0}.
	 */
	public synchronized void reset() {
		this.size = 0;
	}
	
	/**
	 * Writes the specified {@code char} value to this {@code CharArrayOutputStream} instance.
	 * 
	 * @param c the {@code char} value to write
	 */
	public synchronized void write(final char c) {
		doEnsureCapacity(this.size + 1);
		
		this.buffer[this.size] = c;
		this.size += 1;
	}
	
	/**
	 * Writes {@code c.length} {@code char} values, starting at offset {@code 0}, from {@code c} to this {@code CharArrayOutputStream} instance.
	 * <p>
	 * If {@code c} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * charArrayOutputStream.write(c, 0, c.length);
	 * }
	 * </pre>
	 * 
	 * @param c the {@code char} array to write from
	 * @throws NullPointerException thrown if, and only if, {@code c} is {@code null}
	 */
	public synchronized void write(final char[] c) {
		write(c, 0, c.length);
	}
	
	/**
	 * Writes {@code len} {@code char} values, starting at offset {@code off}, from {@code c} to this {@code CharArrayOutputStream} instance.
	 * <p>
	 * If {@code c} is {@code null}, a {@code NullPointerException} will be thrown.
	 * <p>
	 * If either {@code off < 0}, {@code off > c.length}, {@code len < 0} or {@code off + len - c.length > 0}, an {@code IndexOutOfBoundsException} will be thrown.
	 * 
	 * @param c the {@code char} array to write from
	 * @param off the offset to start at in {@code c}
	 * @param len the number of {@code char} values to write from {@code c}
	 * @throws IndexOutOfBoundsException thrown if, and only if, either {@code off < 0}, {@code off > c.length}, {@code len < 0} or {@code off + len - c.length > 0}
	 * @throws NullPointerException thrown if, and only if, {@code c} is {@code null}
	 */
	public synchronized void write(final char[] c, final int off, final int len) {
		if(off < 0 || off > c.length || len < 0 || off + len - c.length > 0) {
			throw new IndexOutOfBoundsException();
		}
		
		doEnsureCapacity(this.size + len);
		
		System.arraycopy(c, off, this.buffer, this.size, len);
		
		this.size += len;
	}
	
	/**
	 * Writes the specified {@code byte} value to this {@code CharArrayOutputStream} instance.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * charArrayOutputStream.write((char)((byte)(b)));
	 * }
	 * </pre>
	 * 
	 * @param b the {@code byte} value to write
	 */
	@Override
	public synchronized void write(final int b) {
		write((char)((byte)(b)));
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