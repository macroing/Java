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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

@SuppressWarnings("static-method")
public final class ShortArrayOutputStreamUnitTests {
	public ShortArrayOutputStreamUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testAvailable() {
		try(final ShortArrayOutputStream shortArrayOutputStream = new ShortArrayOutputStream(0)) {
			assertEquals(0, shortArrayOutputStream.available());
			
			shortArrayOutputStream.write((short)(1));
			
			assertEquals(0, shortArrayOutputStream.available());
			
			shortArrayOutputStream.write((short)(2));
			
			assertEquals(0, shortArrayOutputStream.available());
			
			shortArrayOutputStream.write((short)(3));
			
			assertEquals(1, shortArrayOutputStream.available());
		}
	}
	
	@Test
	public void testCapacity() {
		try(final ShortArrayOutputStream shortArrayOutputStream = new ShortArrayOutputStream(0)) {
			assertEquals(0, shortArrayOutputStream.capacity());
			
			shortArrayOutputStream.write((short)(1));
			
			assertEquals(1, shortArrayOutputStream.capacity());
			
			shortArrayOutputStream.write((short)(2));
			
			assertEquals(2, shortArrayOutputStream.capacity());
			
			shortArrayOutputStream.write((short)(3));
			
			assertEquals(4, shortArrayOutputStream.capacity());
			
			shortArrayOutputStream.write((short)(4));
			
			assertEquals(4, shortArrayOutputStream.capacity());
		}
	}
	
	@Test
	public void testConstructor() {
		try(final ShortArrayOutputStream shortArrayOutputStream = new ShortArrayOutputStream()) {
			assertEquals(32, shortArrayOutputStream.capacity());
		}
	}
	
	@Test
	public void testConstructorInt() {
		try(final ShortArrayOutputStream shortArrayOutputStream = new ShortArrayOutputStream(10)) {
			assertEquals(10, shortArrayOutputStream.capacity());
		}
		
		assertThrows(IllegalArgumentException.class, () -> new ShortArrayOutputStream(-1));
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
		
//		try(final ShortArrayOutputStream shortArrayOutputStream = new ShortArrayOutputStream(0)) {
//			shortArrayOutputStream.write(new short[9]);
//			
//			assertThrows(OutOfMemoryError.class, () -> shortArrayOutputStream.write(new short[(Integer.MAX_VALUE - 8) / 2]));
//		}
		
		/*
		 * The following try-block tests the following code in the doGrow(int) method:
		 * 
		 * if(newCapacity - MAX_ARRAY_SIZE > 0) {
		 *     newCapacity = minCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
		 * }
		 */
		
		try(final ShortArrayOutputStream shortArrayOutputStream = new ShortArrayOutputStream(0)) {
			assertThrows(OutOfMemoryError.class, () -> {
				shortArrayOutputStream.write(new short[1]);
				shortArrayOutputStream.write(new short[2]);
				shortArrayOutputStream.write(new short[4]);
				shortArrayOutputStream.write(new short[8]);
				shortArrayOutputStream.write(new short[16]);
				shortArrayOutputStream.write(new short[32]);
				shortArrayOutputStream.write(new short[64]);
				shortArrayOutputStream.write(new short[128]);
				shortArrayOutputStream.write(new short[256]);
				shortArrayOutputStream.write(new short[512]);
				shortArrayOutputStream.write(new short[1024]);
				shortArrayOutputStream.write(new short[2048]);
				shortArrayOutputStream.write(new short[4096]);
				shortArrayOutputStream.write(new short[8192]);
				shortArrayOutputStream.write(new short[16384]);
				shortArrayOutputStream.write(new short[32768]);
				shortArrayOutputStream.write(new short[65536]);
				shortArrayOutputStream.write(new short[131072]);
				shortArrayOutputStream.write(new short[262144]);
				shortArrayOutputStream.write(new short[524288]);
				shortArrayOutputStream.write(new short[1048576]);
				shortArrayOutputStream.write(new short[2097152]);
				shortArrayOutputStream.write(new short[4194304]);
				shortArrayOutputStream.write(new short[8388608]);
				shortArrayOutputStream.write(new short[16777216]);
				shortArrayOutputStream.write(new short[33554432]);
				shortArrayOutputStream.write(new short[67108864]);
				shortArrayOutputStream.write(new short[134217728]);
				shortArrayOutputStream.write(new short[268435456]);
				shortArrayOutputStream.write(new short[536870912]);
			});
			
			assertThrows(OutOfMemoryError.class, () -> shortArrayOutputStream.write(new short[1]));
		}
	}
	
	@Test
	public void testReset() {
		try(final ShortArrayOutputStream shortArrayOutputStream = new ShortArrayOutputStream(0)) {
			assertEquals(0, shortArrayOutputStream.size());
			
			shortArrayOutputStream.write((short)(1));
			
			assertEquals(1, shortArrayOutputStream.size());
			
			shortArrayOutputStream.write((short)(2));
			
			assertEquals(2, shortArrayOutputStream.size());
			
			shortArrayOutputStream.reset();
			
			assertEquals(0, shortArrayOutputStream.size());
		}
	}
	
	@Test
	public void testSize() {
		try(final ShortArrayOutputStream shortArrayOutputStream = new ShortArrayOutputStream(0)) {
			assertEquals(0, shortArrayOutputStream.size());
			
			shortArrayOutputStream.write((short)(1));
			
			assertEquals(1, shortArrayOutputStream.size());
			
			shortArrayOutputStream.write((short)(2));
			
			assertEquals(2, shortArrayOutputStream.size());
			
			shortArrayOutputStream.write((short)(3));
			
			assertEquals(3, shortArrayOutputStream.size());
		}
	}
	
	@Test
	public void testToShortArray() {
		try(final ShortArrayOutputStream shortArrayOutputStream = new ShortArrayOutputStream(0)) {
			shortArrayOutputStream.write(new short[] {(short)(1), (short)(2), (short)(3)});
			
			assertArrayEquals(new short[] {(short)(1), (short)(2), (short)(3)}, shortArrayOutputStream.toShortArray());
		}
	}
	
	@Test
	public void testWriteShort() {
		try(final ShortArrayOutputStream shortArrayOutputStream = new ShortArrayOutputStream(0)) {
			shortArrayOutputStream.write((short)(1));
			shortArrayOutputStream.write((short)(2));
			shortArrayOutputStream.write((short)(3));
			
			assertArrayEquals(new short[] {(short)(1), (short)(2), (short)(3)}, shortArrayOutputStream.toShortArray());
		}
	}
	
	@Test
	public void testWriteShortArray() {
		try(final ShortArrayOutputStream shortArrayOutputStream = new ShortArrayOutputStream(0)) {
			shortArrayOutputStream.write(new short[] {(short)(1), (short)(2), (short)(3)});
			
			assertArrayEquals(new short[] {(short)(1), (short)(2), (short)(3)}, shortArrayOutputStream.toShortArray());
			
			assertThrows(NullPointerException.class, () -> shortArrayOutputStream.write((short[])(null)));
		}
	}
	
	@Test
	public void testWriteShortArrayIntInt() {
		try(final ShortArrayOutputStream shortArrayOutputStream = new ShortArrayOutputStream(0)) {
			shortArrayOutputStream.write(new short[] {(short)(1), (short)(2), (short)(3)}, 0, 3);
			
			assertArrayEquals(new short[] {(short)(1), (short)(2), (short)(3)}, shortArrayOutputStream.toShortArray());
			
			assertThrows(NullPointerException.class, () -> shortArrayOutputStream.write((short[])(null), 0, 0));
			assertThrows(IndexOutOfBoundsException.class, () -> shortArrayOutputStream.write(new short[] {}, -1, +0));
			assertThrows(IndexOutOfBoundsException.class, () -> shortArrayOutputStream.write(new short[] {}, +1, +0));
			assertThrows(IndexOutOfBoundsException.class, () -> shortArrayOutputStream.write(new short[] {}, +0, -1));
			assertThrows(IndexOutOfBoundsException.class, () -> shortArrayOutputStream.write(new short[] {}, +0, +1));
		}
	}
	
	@Test
	public void testWriteInt() {
		try(final ShortArrayOutputStream shortArrayOutputStream = new ShortArrayOutputStream(0)) {
			shortArrayOutputStream.write(0);
			shortArrayOutputStream.write(1);
			shortArrayOutputStream.write(2);
			
			assertArrayEquals(new short[] {0, 1, 2}, shortArrayOutputStream.toShortArray());
		}
	}
}