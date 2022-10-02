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
public final class BooleanArrayOutputStreamUnitTests {
	public BooleanArrayOutputStreamUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testAvailable() {
		try(final BooleanArrayOutputStream booleanArrayOutputStream = new BooleanArrayOutputStream(0)) {
			assertEquals(0, booleanArrayOutputStream.available());
			
			booleanArrayOutputStream.write(false);
			
			assertEquals(0, booleanArrayOutputStream.available());
			
			booleanArrayOutputStream.write(false);
			
			assertEquals(0, booleanArrayOutputStream.available());
			
			booleanArrayOutputStream.write(false);
			
			assertEquals(1, booleanArrayOutputStream.available());
		}
	}
	
	@Test
	public void testCapacity() {
		try(final BooleanArrayOutputStream booleanArrayOutputStream = new BooleanArrayOutputStream(0)) {
			assertEquals(0, booleanArrayOutputStream.capacity());
			
			booleanArrayOutputStream.write(false);
			
			assertEquals(1, booleanArrayOutputStream.capacity());
			
			booleanArrayOutputStream.write(false);
			
			assertEquals(2, booleanArrayOutputStream.capacity());
			
			booleanArrayOutputStream.write(false);
			
			assertEquals(4, booleanArrayOutputStream.capacity());
			
			booleanArrayOutputStream.write(false);
			
			assertEquals(4, booleanArrayOutputStream.capacity());
		}
	}
	
	@Test
	public void testConstructor() {
		try(final BooleanArrayOutputStream booleanArrayOutputStream = new BooleanArrayOutputStream()) {
			assertEquals(32, booleanArrayOutputStream.capacity());
		}
	}
	
	@Test
	public void testConstructorInt() {
		try(final BooleanArrayOutputStream booleanArrayOutputStream = new BooleanArrayOutputStream(10)) {
			assertEquals(10, booleanArrayOutputStream.capacity());
		}
		
		assertThrows(IllegalArgumentException.class, () -> new BooleanArrayOutputStream(-1));
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
		
		try(final BooleanArrayOutputStream booleanArrayOutputStream = new BooleanArrayOutputStream(0)) {
			booleanArrayOutputStream.write(new boolean[9]);
			
			assertThrows(OutOfMemoryError.class, () -> booleanArrayOutputStream.write(new boolean[Integer.MAX_VALUE - 8]));
		}
		
		/*
		 * The following try-block tests the following code in the doGrow(int) method:
		 * 
		 * if(newCapacity - MAX_ARRAY_SIZE > 0) {
		 *     newCapacity = minCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
		 * }
		 */
		
		try(final BooleanArrayOutputStream booleanArrayOutputStream = new BooleanArrayOutputStream(0)) {
			assertThrows(OutOfMemoryError.class, () -> {
				booleanArrayOutputStream.write(new boolean[1]);
				booleanArrayOutputStream.write(new boolean[2]);
				booleanArrayOutputStream.write(new boolean[4]);
				booleanArrayOutputStream.write(new boolean[8]);
				booleanArrayOutputStream.write(new boolean[16]);
				booleanArrayOutputStream.write(new boolean[32]);
				booleanArrayOutputStream.write(new boolean[64]);
				booleanArrayOutputStream.write(new boolean[128]);
				booleanArrayOutputStream.write(new boolean[256]);
				booleanArrayOutputStream.write(new boolean[512]);
				booleanArrayOutputStream.write(new boolean[1024]);
				booleanArrayOutputStream.write(new boolean[2048]);
				booleanArrayOutputStream.write(new boolean[4096]);
				booleanArrayOutputStream.write(new boolean[8192]);
				booleanArrayOutputStream.write(new boolean[16384]);
				booleanArrayOutputStream.write(new boolean[32768]);
				booleanArrayOutputStream.write(new boolean[65536]);
				booleanArrayOutputStream.write(new boolean[131072]);
				booleanArrayOutputStream.write(new boolean[262144]);
				booleanArrayOutputStream.write(new boolean[524288]);
				booleanArrayOutputStream.write(new boolean[1048576]);
				booleanArrayOutputStream.write(new boolean[2097152]);
				booleanArrayOutputStream.write(new boolean[4194304]);
				booleanArrayOutputStream.write(new boolean[8388608]);
				booleanArrayOutputStream.write(new boolean[16777216]);
				booleanArrayOutputStream.write(new boolean[33554432]);
				booleanArrayOutputStream.write(new boolean[67108864]);
				booleanArrayOutputStream.write(new boolean[134217728]);
				booleanArrayOutputStream.write(new boolean[268435456]);
				booleanArrayOutputStream.write(new boolean[536870912]);
				booleanArrayOutputStream.write(new boolean[1073741824]);
			});
			
//			This used to work on another machine:
//			assertThrows(OutOfMemoryError.class, () -> booleanArrayOutputStream.write(new boolean[1]));
			
			booleanArrayOutputStream.write(new boolean[1]);
		}
	}
	
	@Test
	public void testReset() {
		try(final BooleanArrayOutputStream booleanArrayOutputStream = new BooleanArrayOutputStream(0)) {
			assertEquals(0, booleanArrayOutputStream.size());
			
			booleanArrayOutputStream.write(false);
			
			assertEquals(1, booleanArrayOutputStream.size());
			
			booleanArrayOutputStream.write(false);
			
			assertEquals(2, booleanArrayOutputStream.size());
			
			booleanArrayOutputStream.reset();
			
			assertEquals(0, booleanArrayOutputStream.size());
		}
	}
	
	@Test
	public void testSize() {
		try(final BooleanArrayOutputStream booleanArrayOutputStream = new BooleanArrayOutputStream(0)) {
			assertEquals(0, booleanArrayOutputStream.size());
			
			booleanArrayOutputStream.write(false);
			
			assertEquals(1, booleanArrayOutputStream.size());
			
			booleanArrayOutputStream.write(false);
			
			assertEquals(2, booleanArrayOutputStream.size());
			
			booleanArrayOutputStream.write(false);
			
			assertEquals(3, booleanArrayOutputStream.size());
		}
	}
	
	@Test
	public void testToBooleanArray() {
		try(final BooleanArrayOutputStream booleanArrayOutputStream = new BooleanArrayOutputStream(0)) {
			booleanArrayOutputStream.write(new boolean[] {false, true, false});
			
			assertArrayEquals(new boolean[] {false, true, false}, booleanArrayOutputStream.toBooleanArray());
		}
	}
	
	@Test
	public void testWriteBoolean() {
		try(final BooleanArrayOutputStream booleanArrayOutputStream = new BooleanArrayOutputStream(0)) {
			booleanArrayOutputStream.write(false);
			booleanArrayOutputStream.write(true);
			booleanArrayOutputStream.write(false);
			
			assertArrayEquals(new boolean[] {false, true, false}, booleanArrayOutputStream.toBooleanArray());
		}
	}
	
	@Test
	public void testWriteBooleanArray() {
		try(final BooleanArrayOutputStream booleanArrayOutputStream = new BooleanArrayOutputStream(0)) {
			booleanArrayOutputStream.write(new boolean[] {false, true, false});
			
			assertArrayEquals(new boolean[] {false, true, false}, booleanArrayOutputStream.toBooleanArray());
			
			assertThrows(NullPointerException.class, () -> booleanArrayOutputStream.write((boolean[])(null)));
		}
	}
	
	@Test
	public void testWriteBooleanArrayIntInt() {
		try(final BooleanArrayOutputStream booleanArrayOutputStream = new BooleanArrayOutputStream(0)) {
			booleanArrayOutputStream.write(new boolean[] {false, true, false}, 0, 3);
			
			assertArrayEquals(new boolean[] {false, true, false}, booleanArrayOutputStream.toBooleanArray());
			
			assertThrows(NullPointerException.class, () -> booleanArrayOutputStream.write((boolean[])(null), 0, 0));
			assertThrows(IndexOutOfBoundsException.class, () -> booleanArrayOutputStream.write(new boolean[] {}, -1, +0));
			assertThrows(IndexOutOfBoundsException.class, () -> booleanArrayOutputStream.write(new boolean[] {}, +1, +0));
			assertThrows(IndexOutOfBoundsException.class, () -> booleanArrayOutputStream.write(new boolean[] {}, +0, -1));
			assertThrows(IndexOutOfBoundsException.class, () -> booleanArrayOutputStream.write(new boolean[] {}, +0, +1));
		}
	}
	
	@Test
	public void testWriteInt() {
		try(final BooleanArrayOutputStream booleanArrayOutputStream = new BooleanArrayOutputStream(0)) {
			booleanArrayOutputStream.write(0);
			booleanArrayOutputStream.write(1);
			booleanArrayOutputStream.write(0);
			
			assertArrayEquals(new boolean[] {false, true, false}, booleanArrayOutputStream.toBooleanArray());
		}
	}
}