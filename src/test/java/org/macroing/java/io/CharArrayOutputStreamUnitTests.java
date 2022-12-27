/**
 * Copyright 2021 - 2023 J&#246;rgen Lundgren
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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

@SuppressWarnings("static-method")
public final class CharArrayOutputStreamUnitTests {
	public CharArrayOutputStreamUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testAvailable() {
		try(final CharArrayOutputStream charArrayOutputStream = new CharArrayOutputStream(0)) {
			assertEquals(0, charArrayOutputStream.available());
			
			charArrayOutputStream.write('A');
			
			assertEquals(0, charArrayOutputStream.available());
			
			charArrayOutputStream.write('B');
			
			assertEquals(0, charArrayOutputStream.available());
			
			charArrayOutputStream.write('C');
			
			assertEquals(1, charArrayOutputStream.available());
		}
	}
	
	@Test
	public void testCapacity() {
		try(final CharArrayOutputStream charArrayOutputStream = new CharArrayOutputStream(0)) {
			assertEquals(0, charArrayOutputStream.capacity());
			
			charArrayOutputStream.write('A');
			
			assertEquals(1, charArrayOutputStream.capacity());
			
			charArrayOutputStream.write('B');
			
			assertEquals(2, charArrayOutputStream.capacity());
			
			charArrayOutputStream.write('C');
			
			assertEquals(4, charArrayOutputStream.capacity());
			
			charArrayOutputStream.write('D');
			
			assertEquals(4, charArrayOutputStream.capacity());
		}
	}
	
	@Test
	public void testConstructor() {
		try(final CharArrayOutputStream charArrayOutputStream = new CharArrayOutputStream()) {
			assertEquals(32, charArrayOutputStream.capacity());
		}
	}
	
	@Test
	public void testConstructorInt() {
		try(final CharArrayOutputStream charArrayOutputStream = new CharArrayOutputStream(10)) {
			assertEquals(10, charArrayOutputStream.capacity());
		}
		
		assertThrows(IllegalArgumentException.class, () -> new CharArrayOutputStream(-1));
	}
	
	@Test
	public void testOutOfMemoryError() {
		/*
		 * The following try-block tests the following code in the doGrow(int) method:
		 * 
		 * if(minCapacity < 0) {
		 *     throw new OutOfMemoryError();
		 * }
		 */
		
//		try(final CharArrayOutputStream charArrayOutputStream = new CharArrayOutputStream(0)) {
//			charArrayOutputStream.write(new char[9]);
//			
//			assertThrows(OutOfMemoryError.class, () -> charArrayOutputStream.write(new char[(Integer.MAX_VALUE - 8) / 2]));
//		}
		
		/*
		 * The following try-block tests the following code in the doGrow(int) method:
		 * 
		 * if(newCapacity - MAX_ARRAY_SIZE > 0) {
		 *     newCapacity = minCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
		 * }
		 */
		
		try(final CharArrayOutputStream charArrayOutputStream = new CharArrayOutputStream(0)) {
			assertThrows(OutOfMemoryError.class, () -> {
				charArrayOutputStream.write(new char[1]);
				charArrayOutputStream.write(new char[2]);
				charArrayOutputStream.write(new char[4]);
				charArrayOutputStream.write(new char[8]);
				charArrayOutputStream.write(new char[16]);
				charArrayOutputStream.write(new char[32]);
				charArrayOutputStream.write(new char[64]);
				charArrayOutputStream.write(new char[128]);
				charArrayOutputStream.write(new char[256]);
				charArrayOutputStream.write(new char[512]);
				charArrayOutputStream.write(new char[1024]);
				charArrayOutputStream.write(new char[2048]);
				charArrayOutputStream.write(new char[4096]);
				charArrayOutputStream.write(new char[8192]);
				charArrayOutputStream.write(new char[16384]);
				charArrayOutputStream.write(new char[32768]);
				charArrayOutputStream.write(new char[65536]);
				charArrayOutputStream.write(new char[131072]);
				charArrayOutputStream.write(new char[262144]);
				charArrayOutputStream.write(new char[524288]);
				charArrayOutputStream.write(new char[1048576]);
				charArrayOutputStream.write(new char[2097152]);
				charArrayOutputStream.write(new char[4194304]);
				charArrayOutputStream.write(new char[8388608]);
				charArrayOutputStream.write(new char[16777216]);
				charArrayOutputStream.write(new char[33554432]);
				charArrayOutputStream.write(new char[67108864]);
				charArrayOutputStream.write(new char[134217728]);
				charArrayOutputStream.write(new char[268435456]);
				charArrayOutputStream.write(new char[536870912]);
			});
			
//			This used to work on another machine:
//			assertThrows(OutOfMemoryError.class, () -> charArrayOutputStream.write(new char[1]));
			
			charArrayOutputStream.write(new char[1]);
		}
	}
	
	@Test
	public void testReset() {
		try(final CharArrayOutputStream charArrayOutputStream = new CharArrayOutputStream(0)) {
			assertEquals(0, charArrayOutputStream.size());
			
			charArrayOutputStream.write('A');
			
			assertEquals(1, charArrayOutputStream.size());
			
			charArrayOutputStream.write('B');
			
			assertEquals(2, charArrayOutputStream.size());
			
			charArrayOutputStream.reset();
			
			assertEquals(0, charArrayOutputStream.size());
		}
	}
	
	@Test
	public void testSize() {
		try(final CharArrayOutputStream charArrayOutputStream = new CharArrayOutputStream(0)) {
			assertEquals(0, charArrayOutputStream.size());
			
			charArrayOutputStream.write('A');
			
			assertEquals(1, charArrayOutputStream.size());
			
			charArrayOutputStream.write('B');
			
			assertEquals(2, charArrayOutputStream.size());
			
			charArrayOutputStream.write('C');
			
			assertEquals(3, charArrayOutputStream.size());
		}
	}
	
	@Test
	public void testToCharArray() {
		try(final CharArrayOutputStream charArrayOutputStream = new CharArrayOutputStream(0)) {
			charArrayOutputStream.write(new char[] {'A', 'B', 'C'});
			
			assertArrayEquals(new char[] {'A', 'B', 'C'}, charArrayOutputStream.toCharArray());
		}
	}
	
	@Test
	public void testWriteChar() {
		try(final CharArrayOutputStream charArrayOutputStream = new CharArrayOutputStream(0)) {
			charArrayOutputStream.write('A');
			charArrayOutputStream.write('B');
			charArrayOutputStream.write('C');
			
			assertArrayEquals(new char[] {'A', 'B', 'C'}, charArrayOutputStream.toCharArray());
		}
	}
	
	@Test
	public void testWriteCharArray() {
		try(final CharArrayOutputStream charArrayOutputStream = new CharArrayOutputStream(0)) {
			charArrayOutputStream.write(new char[] {'A', 'B', 'C'});
			
			assertArrayEquals(new char[] {'A', 'B', 'C'}, charArrayOutputStream.toCharArray());
			
			assertThrows(NullPointerException.class, () -> charArrayOutputStream.write((char[])(null)));
		}
	}
	
	@Test
	public void testWriteCharArrayIntInt() {
		try(final CharArrayOutputStream charArrayOutputStream = new CharArrayOutputStream(0)) {
			charArrayOutputStream.write(new char[] {'A', 'B', 'C'}, 0, 3);
			
			assertArrayEquals(new char[] {'A', 'B', 'C'}, charArrayOutputStream.toCharArray());
			
			assertThrows(NullPointerException.class, () -> charArrayOutputStream.write((char[])(null), 0, 0));
			assertThrows(IndexOutOfBoundsException.class, () -> charArrayOutputStream.write(new char[] {}, -1, +0));
			assertThrows(IndexOutOfBoundsException.class, () -> charArrayOutputStream.write(new char[] {}, +1, +0));
			assertThrows(IndexOutOfBoundsException.class, () -> charArrayOutputStream.write(new char[] {}, +0, -1));
			assertThrows(IndexOutOfBoundsException.class, () -> charArrayOutputStream.write(new char[] {}, +0, +1));
		}
	}
	
	@Test
	public void testWriteInt() {
		try(final CharArrayOutputStream charArrayOutputStream = new CharArrayOutputStream(0)) {
			charArrayOutputStream.write(0);
			charArrayOutputStream.write(1);
			charArrayOutputStream.write(2);
			
			assertArrayEquals(new char[] {0, 1, 2}, charArrayOutputStream.toCharArray());
		}
	}
}