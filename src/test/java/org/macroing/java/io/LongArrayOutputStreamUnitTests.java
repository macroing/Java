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
public final class LongArrayOutputStreamUnitTests {
	public LongArrayOutputStreamUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testAvailable() {
		try(final LongArrayOutputStream longArrayOutputStream = new LongArrayOutputStream(0)) {
			assertEquals(0, longArrayOutputStream.available());
			
			longArrayOutputStream.write(1L);
			
			assertEquals(0, longArrayOutputStream.available());
			
			longArrayOutputStream.write(2L);
			
			assertEquals(0, longArrayOutputStream.available());
			
			longArrayOutputStream.write(3L);
			
			assertEquals(1, longArrayOutputStream.available());
		}
	}
	
	@Test
	public void testCapacity() {
		try(final LongArrayOutputStream longArrayOutputStream = new LongArrayOutputStream(0)) {
			assertEquals(0, longArrayOutputStream.capacity());
			
			longArrayOutputStream.write(1L);
			
			assertEquals(1, longArrayOutputStream.capacity());
			
			longArrayOutputStream.write(2L);
			
			assertEquals(2, longArrayOutputStream.capacity());
			
			longArrayOutputStream.write(3L);
			
			assertEquals(4, longArrayOutputStream.capacity());
			
			longArrayOutputStream.write(4L);
			
			assertEquals(4, longArrayOutputStream.capacity());
		}
	}
	
	@Test
	public void testConstructor() {
		try(final LongArrayOutputStream longArrayOutputStream = new LongArrayOutputStream()) {
			assertEquals(32, longArrayOutputStream.capacity());
		}
	}
	
	@Test
	public void testConstructorInt() {
		try(final LongArrayOutputStream longArrayOutputStream = new LongArrayOutputStream(10)) {
			assertEquals(10, longArrayOutputStream.capacity());
		}
		
		assertThrows(IllegalArgumentException.class, () -> new LongArrayOutputStream(-1));
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
		
//		try(final LongArrayOutputStream longArrayOutputStream = new LongArrayOutputStream(0)) {
//			longArrayOutputStream.write(new long[9]);
//			
//			assertThrows(OutOfMemoryError.class, () -> longArrayOutputStream.write(new long[(Integer.MAX_VALUE - 8) / 8]));
//		}
		
		/*
		 * The following try-block tests the following code in the doGrow(int) method:
		 * 
		 * if(newCapacity - MAX_ARRAY_SIZE > 0) {
		 *     newCapacity = minCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
		 * }
		 */
		
		try(final LongArrayOutputStream longArrayOutputStream = new LongArrayOutputStream(0)) {
			assertThrows(OutOfMemoryError.class, () -> {
				longArrayOutputStream.write(new long[1]);
				longArrayOutputStream.write(new long[2]);
				longArrayOutputStream.write(new long[4]);
				longArrayOutputStream.write(new long[8]);
				longArrayOutputStream.write(new long[16]);
				longArrayOutputStream.write(new long[32]);
				longArrayOutputStream.write(new long[64]);
				longArrayOutputStream.write(new long[128]);
				longArrayOutputStream.write(new long[256]);
				longArrayOutputStream.write(new long[512]);
				longArrayOutputStream.write(new long[1024]);
				longArrayOutputStream.write(new long[2048]);
				longArrayOutputStream.write(new long[4096]);
				longArrayOutputStream.write(new long[8192]);
				longArrayOutputStream.write(new long[16384]);
				longArrayOutputStream.write(new long[32768]);
				longArrayOutputStream.write(new long[65536]);
				longArrayOutputStream.write(new long[131072]);
				longArrayOutputStream.write(new long[262144]);
				longArrayOutputStream.write(new long[524288]);
				longArrayOutputStream.write(new long[1048576]);
				longArrayOutputStream.write(new long[2097152]);
				longArrayOutputStream.write(new long[4194304]);
				longArrayOutputStream.write(new long[8388608]);
				longArrayOutputStream.write(new long[16777216]);
				longArrayOutputStream.write(new long[33554432]);
				longArrayOutputStream.write(new long[67108864]);
				longArrayOutputStream.write(new long[134217728]);
			});
			
//			assertThrows(OutOfMemoryError.class, () -> longArrayOutputStream.write(new long[1]));
		}
	}
	
	@Test
	public void testReset() {
		try(final LongArrayOutputStream longArrayOutputStream = new LongArrayOutputStream(0)) {
			assertEquals(0, longArrayOutputStream.size());
			
			longArrayOutputStream.write(1L);
			
			assertEquals(1, longArrayOutputStream.size());
			
			longArrayOutputStream.write(2L);
			
			assertEquals(2, longArrayOutputStream.size());
			
			longArrayOutputStream.reset();
			
			assertEquals(0, longArrayOutputStream.size());
		}
	}
	
	@Test
	public void testSize() {
		try(final LongArrayOutputStream longArrayOutputStream = new LongArrayOutputStream(0)) {
			assertEquals(0, longArrayOutputStream.size());
			
			longArrayOutputStream.write(1L);
			
			assertEquals(1, longArrayOutputStream.size());
			
			longArrayOutputStream.write(2L);
			
			assertEquals(2, longArrayOutputStream.size());
			
			longArrayOutputStream.write(3L);
			
			assertEquals(3, longArrayOutputStream.size());
		}
	}
	
	@Test
	public void testToLongArray() {
		try(final LongArrayOutputStream longArrayOutputStream = new LongArrayOutputStream(0)) {
			longArrayOutputStream.write(new long[] {1L, 2L, 3L});
			
			assertArrayEquals(new long[] {1L, 2L, 3L}, longArrayOutputStream.toLongArray());
		}
	}
	
	@Test
	public void testWriteLong() {
		try(final LongArrayOutputStream longArrayOutputStream = new LongArrayOutputStream(0)) {
			longArrayOutputStream.write(1L);
			longArrayOutputStream.write(2L);
			longArrayOutputStream.write(3L);
			
			assertArrayEquals(new long[] {1L, 2L, 3L}, longArrayOutputStream.toLongArray());
		}
	}
	
	@Test
	public void testWriteLongArray() {
		try(final LongArrayOutputStream longArrayOutputStream = new LongArrayOutputStream(0)) {
			longArrayOutputStream.write(new long[] {1L, 2L, 3L});
			
			assertArrayEquals(new long[] {1L, 2L, 3L}, longArrayOutputStream.toLongArray());
			
			assertThrows(NullPointerException.class, () -> longArrayOutputStream.write((long[])(null)));
		}
	}
	
	@Test
	public void testWriteLongArrayIntInt() {
		try(final LongArrayOutputStream longArrayOutputStream = new LongArrayOutputStream(0)) {
			longArrayOutputStream.write(new long[] {1L, 2L, 3L}, 0, 3);
			
			assertArrayEquals(new long[] {1L, 2L, 3L}, longArrayOutputStream.toLongArray());
			
			assertThrows(NullPointerException.class, () -> longArrayOutputStream.write((long[])(null), 0, 0));
			assertThrows(IndexOutOfBoundsException.class, () -> longArrayOutputStream.write(new long[] {}, -1, +0));
			assertThrows(IndexOutOfBoundsException.class, () -> longArrayOutputStream.write(new long[] {}, +1, +0));
			assertThrows(IndexOutOfBoundsException.class, () -> longArrayOutputStream.write(new long[] {}, +0, -1));
			assertThrows(IndexOutOfBoundsException.class, () -> longArrayOutputStream.write(new long[] {}, +0, +1));
		}
	}
	
	@Test
	public void testWriteInt() {
		try(final LongArrayOutputStream longArrayOutputStream = new LongArrayOutputStream(0)) {
			longArrayOutputStream.write(0);
			longArrayOutputStream.write(1);
			longArrayOutputStream.write(2);
			
			assertArrayEquals(new long[] {0, 1, 2}, longArrayOutputStream.toLongArray());
		}
	}
}