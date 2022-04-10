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
public final class FloatArrayOutputStreamUnitTests {
	public FloatArrayOutputStreamUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testAvailable() {
		try(final FloatArrayOutputStream floatArrayOutputStream = new FloatArrayOutputStream(0)) {
			assertEquals(0, floatArrayOutputStream.available());
			
			floatArrayOutputStream.write(1.0F);
			
			assertEquals(0, floatArrayOutputStream.available());
			
			floatArrayOutputStream.write(2.0F);
			
			assertEquals(0, floatArrayOutputStream.available());
			
			floatArrayOutputStream.write(3.0F);
			
			assertEquals(1, floatArrayOutputStream.available());
		}
	}
	
	@Test
	public void testCapacity() {
		try(final FloatArrayOutputStream floatArrayOutputStream = new FloatArrayOutputStream(0)) {
			assertEquals(0, floatArrayOutputStream.capacity());
			
			floatArrayOutputStream.write(1.0F);
			
			assertEquals(1, floatArrayOutputStream.capacity());
			
			floatArrayOutputStream.write(2.0F);
			
			assertEquals(2, floatArrayOutputStream.capacity());
			
			floatArrayOutputStream.write(3.0F);
			
			assertEquals(4, floatArrayOutputStream.capacity());
			
			floatArrayOutputStream.write(4.0F);
			
			assertEquals(4, floatArrayOutputStream.capacity());
		}
	}
	
	@Test
	public void testConstructor() {
		try(final FloatArrayOutputStream floatArrayOutputStream = new FloatArrayOutputStream()) {
			assertEquals(32, floatArrayOutputStream.capacity());
		}
	}
	
	@Test
	public void testConstructorInt() {
		try(final FloatArrayOutputStream floatArrayOutputStream = new FloatArrayOutputStream(10)) {
			assertEquals(10, floatArrayOutputStream.capacity());
		}
		
		assertThrows(IllegalArgumentException.class, () -> new FloatArrayOutputStream(-1));
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
		
//		try(final FloatArrayOutputStream floatArrayOutputStream = new FloatArrayOutputStream(0)) {
//			floatArrayOutputStream.write(new float[9]);
//			
//			assertThrows(OutOfMemoryError.class, () -> floatArrayOutputStream.write(new float[(Integer.MAX_VALUE - 8) / 4]));
//		}
		
		/*
		 * The following try-block tests the following code in the doGrow(int) method:
		 * 
		 * if(newCapacity - MAX_ARRAY_SIZE > 0) {
		 *     newCapacity = minCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
		 * }
		 */
		
		try(final FloatArrayOutputStream floatArrayOutputStream = new FloatArrayOutputStream(0)) {
			assertThrows(OutOfMemoryError.class, () -> {
				floatArrayOutputStream.write(new float[1]);
				floatArrayOutputStream.write(new float[2]);
				floatArrayOutputStream.write(new float[4]);
				floatArrayOutputStream.write(new float[8]);
				floatArrayOutputStream.write(new float[16]);
				floatArrayOutputStream.write(new float[32]);
				floatArrayOutputStream.write(new float[64]);
				floatArrayOutputStream.write(new float[128]);
				floatArrayOutputStream.write(new float[256]);
				floatArrayOutputStream.write(new float[512]);
				floatArrayOutputStream.write(new float[1024]);
				floatArrayOutputStream.write(new float[2048]);
				floatArrayOutputStream.write(new float[4096]);
				floatArrayOutputStream.write(new float[8192]);
				floatArrayOutputStream.write(new float[16384]);
				floatArrayOutputStream.write(new float[32768]);
				floatArrayOutputStream.write(new float[65536]);
				floatArrayOutputStream.write(new float[131072]);
				floatArrayOutputStream.write(new float[262144]);
				floatArrayOutputStream.write(new float[524288]);
				floatArrayOutputStream.write(new float[1048576]);
				floatArrayOutputStream.write(new float[2097152]);
				floatArrayOutputStream.write(new float[4194304]);
				floatArrayOutputStream.write(new float[8388608]);
				floatArrayOutputStream.write(new float[16777216]);
				floatArrayOutputStream.write(new float[33554432]);
				floatArrayOutputStream.write(new float[67108864]);
				floatArrayOutputStream.write(new float[134217728]);
				floatArrayOutputStream.write(new float[268435456]);
				floatArrayOutputStream.write(new float[536870912]);
			});
			
			assertThrows(OutOfMemoryError.class, () -> floatArrayOutputStream.write(new float[1]));
		}
	}
	
	@Test
	public void testReset() {
		try(final FloatArrayOutputStream floatArrayOutputStream = new FloatArrayOutputStream(0)) {
			assertEquals(0, floatArrayOutputStream.size());
			
			floatArrayOutputStream.write(1.0F);
			
			assertEquals(1, floatArrayOutputStream.size());
			
			floatArrayOutputStream.write(2.0F);
			
			assertEquals(2, floatArrayOutputStream.size());
			
			floatArrayOutputStream.reset();
			
			assertEquals(0, floatArrayOutputStream.size());
		}
	}
	
	@Test
	public void testSize() {
		try(final FloatArrayOutputStream floatArrayOutputStream = new FloatArrayOutputStream(0)) {
			assertEquals(0, floatArrayOutputStream.size());
			
			floatArrayOutputStream.write(1.0F);
			
			assertEquals(1, floatArrayOutputStream.size());
			
			floatArrayOutputStream.write(2.0F);
			
			assertEquals(2, floatArrayOutputStream.size());
			
			floatArrayOutputStream.write(3.0F);
			
			assertEquals(3, floatArrayOutputStream.size());
		}
	}
	
	@Test
	public void testToFloatArray() {
		try(final FloatArrayOutputStream floatArrayOutputStream = new FloatArrayOutputStream(0)) {
			floatArrayOutputStream.write(new float[] {1.0F, 2.0F, 3.0F});
			
			assertArrayEquals(new float[] {1.0F, 2.0F, 3.0F}, floatArrayOutputStream.toFloatArray());
		}
	}
	
	@Test
	public void testWriteFloat() {
		try(final FloatArrayOutputStream floatArrayOutputStream = new FloatArrayOutputStream(0)) {
			floatArrayOutputStream.write(1.0F);
			floatArrayOutputStream.write(2.0F);
			floatArrayOutputStream.write(3.0F);
			
			assertArrayEquals(new float[] {1.0F, 2.0F, 3.0F}, floatArrayOutputStream.toFloatArray());
		}
	}
	
	@Test
	public void testWriteFloatArray() {
		try(final FloatArrayOutputStream floatArrayOutputStream = new FloatArrayOutputStream(0)) {
			floatArrayOutputStream.write(new float[] {1.0F, 2.0F, 3.0F});
			
			assertArrayEquals(new float[] {1.0F, 2.0F, 3.0F}, floatArrayOutputStream.toFloatArray());
			
			assertThrows(NullPointerException.class, () -> floatArrayOutputStream.write((float[])(null)));
		}
	}
	
	@Test
	public void testWriteFloatArrayIntInt() {
		try(final FloatArrayOutputStream floatArrayOutputStream = new FloatArrayOutputStream(0)) {
			floatArrayOutputStream.write(new float[] {1.0F, 2.0F, 3.0F}, 0, 3);
			
			assertArrayEquals(new float[] {1.0F, 2.0F, 3.0F}, floatArrayOutputStream.toFloatArray());
			
			assertThrows(NullPointerException.class, () -> floatArrayOutputStream.write((float[])(null), 0, 0));
			assertThrows(IndexOutOfBoundsException.class, () -> floatArrayOutputStream.write(new float[] {}, -1, +0));
			assertThrows(IndexOutOfBoundsException.class, () -> floatArrayOutputStream.write(new float[] {}, +1, +0));
			assertThrows(IndexOutOfBoundsException.class, () -> floatArrayOutputStream.write(new float[] {}, +0, -1));
			assertThrows(IndexOutOfBoundsException.class, () -> floatArrayOutputStream.write(new float[] {}, +0, +1));
		}
	}
	
	@Test
	public void testWriteInt() {
		try(final FloatArrayOutputStream floatArrayOutputStream = new FloatArrayOutputStream(0)) {
			floatArrayOutputStream.write(0);
			floatArrayOutputStream.write(1);
			floatArrayOutputStream.write(2);
			
			assertArrayEquals(new float[] {0, 1, 2}, floatArrayOutputStream.toFloatArray());
		}
	}
}