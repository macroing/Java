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
public final class IntArrayOutputStreamUnitTests {
	public IntArrayOutputStreamUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testAvailable() {
		try(final IntArrayOutputStream intArrayOutputStream = new IntArrayOutputStream(0)) {
			assertEquals(0, intArrayOutputStream.available());
			
			intArrayOutputStream.write(1);
			
			assertEquals(0, intArrayOutputStream.available());
			
			intArrayOutputStream.write(2);
			
			assertEquals(0, intArrayOutputStream.available());
			
			intArrayOutputStream.write(3);
			
			assertEquals(1, intArrayOutputStream.available());
		}
	}
	
	@Test
	public void testCapacity() {
		try(final IntArrayOutputStream intArrayOutputStream = new IntArrayOutputStream(0)) {
			assertEquals(0, intArrayOutputStream.capacity());
			
			intArrayOutputStream.write(1);
			
			assertEquals(1, intArrayOutputStream.capacity());
			
			intArrayOutputStream.write(2);
			
			assertEquals(2, intArrayOutputStream.capacity());
			
			intArrayOutputStream.write(3);
			
			assertEquals(4, intArrayOutputStream.capacity());
			
			intArrayOutputStream.write(4);
			
			assertEquals(4, intArrayOutputStream.capacity());
		}
	}
	
	@Test
	public void testConstructor() {
		try(final IntArrayOutputStream intArrayOutputStream = new IntArrayOutputStream()) {
			assertEquals(32, intArrayOutputStream.capacity());
		}
	}
	
	@Test
	public void testConstructorInt() {
		try(final IntArrayOutputStream intArrayOutputStream = new IntArrayOutputStream(10)) {
			assertEquals(10, intArrayOutputStream.capacity());
		}
		
		assertThrows(IllegalArgumentException.class, () -> new IntArrayOutputStream(-1));
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
		
//		try(final IntArrayOutputStream intArrayOutputStream = new IntArrayOutputStream(0)) {
//			intArrayOutputStream.write(new int[9]);
//			
//			assertThrows(OutOfMemoryError.class, () -> intArrayOutputStream.write(new int[(Integer.MAX_VALUE - 8) / 4]));
//		}
		
		/*
		 * The following try-block tests the following code in the doGrow(int) method:
		 * 
		 * if(newCapacity - MAX_ARRAY_SIZE > 0) {
		 *     newCapacity = minCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
		 * }
		 */
		
		try(final IntArrayOutputStream intArrayOutputStream = new IntArrayOutputStream(0)) {
			assertThrows(OutOfMemoryError.class, () -> {
				intArrayOutputStream.write(new int[1]);
				intArrayOutputStream.write(new int[2]);
				intArrayOutputStream.write(new int[4]);
				intArrayOutputStream.write(new int[8]);
				intArrayOutputStream.write(new int[16]);
				intArrayOutputStream.write(new int[32]);
				intArrayOutputStream.write(new int[64]);
				intArrayOutputStream.write(new int[128]);
				intArrayOutputStream.write(new int[256]);
				intArrayOutputStream.write(new int[512]);
				intArrayOutputStream.write(new int[1024]);
				intArrayOutputStream.write(new int[2048]);
				intArrayOutputStream.write(new int[4096]);
				intArrayOutputStream.write(new int[8192]);
				intArrayOutputStream.write(new int[16384]);
				intArrayOutputStream.write(new int[32768]);
				intArrayOutputStream.write(new int[65536]);
				intArrayOutputStream.write(new int[131072]);
				intArrayOutputStream.write(new int[262144]);
				intArrayOutputStream.write(new int[524288]);
				intArrayOutputStream.write(new int[1048576]);
				intArrayOutputStream.write(new int[2097152]);
				intArrayOutputStream.write(new int[4194304]);
				intArrayOutputStream.write(new int[8388608]);
				intArrayOutputStream.write(new int[16777216]);
				intArrayOutputStream.write(new int[33554432]);
				intArrayOutputStream.write(new int[67108864]);
				intArrayOutputStream.write(new int[134217728]);
				intArrayOutputStream.write(new int[268435456]);
				intArrayOutputStream.write(new int[536870912]);
			});
			
//			This used to work on another machine:
//			assertThrows(OutOfMemoryError.class, () -> intArrayOutputStream.write(new int[1]));
			
			intArrayOutputStream.write(new int[1]);
		}
	}
	
	@Test
	public void testReset() {
		try(final IntArrayOutputStream intArrayOutputStream = new IntArrayOutputStream(0)) {
			assertEquals(0, intArrayOutputStream.size());
			
			intArrayOutputStream.write(1);
			
			assertEquals(1, intArrayOutputStream.size());
			
			intArrayOutputStream.write(2);
			
			assertEquals(2, intArrayOutputStream.size());
			
			intArrayOutputStream.reset();
			
			assertEquals(0, intArrayOutputStream.size());
		}
	}
	
	@Test
	public void testSize() {
		try(final IntArrayOutputStream intArrayOutputStream = new IntArrayOutputStream(0)) {
			assertEquals(0, intArrayOutputStream.size());
			
			intArrayOutputStream.write(1);
			
			assertEquals(1, intArrayOutputStream.size());
			
			intArrayOutputStream.write(2);
			
			assertEquals(2, intArrayOutputStream.size());
			
			intArrayOutputStream.write(3);
			
			assertEquals(3, intArrayOutputStream.size());
		}
	}
	
	@Test
	public void testToIntArray() {
		try(final IntArrayOutputStream intArrayOutputStream = new IntArrayOutputStream(0)) {
			intArrayOutputStream.write(new int[] {1, 2, 3});
			
			assertArrayEquals(new int[] {1, 2, 3}, intArrayOutputStream.toIntArray());
		}
	}
	
	@Test
	public void testWriteIntArray() {
		try(final IntArrayOutputStream intArrayOutputStream = new IntArrayOutputStream(0)) {
			intArrayOutputStream.write(new int[] {1, 2, 3});
			
			assertArrayEquals(new int[] {1, 2, 3}, intArrayOutputStream.toIntArray());
			
			assertThrows(NullPointerException.class, () -> intArrayOutputStream.write((int[])(null)));
		}
	}
	
	@Test
	public void testWriteIntArrayIntInt() {
		try(final IntArrayOutputStream intArrayOutputStream = new IntArrayOutputStream(0)) {
			intArrayOutputStream.write(new int[] {1, 2, 3}, 0, 3);
			
			assertArrayEquals(new int[] {1, 2, 3}, intArrayOutputStream.toIntArray());
			
			assertThrows(NullPointerException.class, () -> intArrayOutputStream.write((int[])(null), 0, 0));
			assertThrows(IndexOutOfBoundsException.class, () -> intArrayOutputStream.write(new int[] {}, -1, +0));
			assertThrows(IndexOutOfBoundsException.class, () -> intArrayOutputStream.write(new int[] {}, +1, +0));
			assertThrows(IndexOutOfBoundsException.class, () -> intArrayOutputStream.write(new int[] {}, +0, -1));
			assertThrows(IndexOutOfBoundsException.class, () -> intArrayOutputStream.write(new int[] {}, +0, +1));
		}
	}
	
	@Test
	public void testWriteInt() {
		try(final IntArrayOutputStream intArrayOutputStream = new IntArrayOutputStream(0)) {
			intArrayOutputStream.write(0);
			intArrayOutputStream.write(1);
			intArrayOutputStream.write(2);
			
			assertArrayEquals(new int[] {0, 1, 2}, intArrayOutputStream.toIntArray());
		}
	}
	
	@Test
	public void testWriteIntInt() {
		try(final IntArrayOutputStream intArrayOutputStream = new IntArrayOutputStream(0)) {
			intArrayOutputStream.writeInt(1);
			intArrayOutputStream.writeInt(2);
			intArrayOutputStream.writeInt(3);
			
			assertArrayEquals(new int[] {1, 2, 3}, intArrayOutputStream.toIntArray());
		}
	}
}