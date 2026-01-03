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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

@SuppressWarnings("static-method")
public final class DoubleArrayOutputStreamUnitTests {
	public DoubleArrayOutputStreamUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testAvailable() {
		try(final DoubleArrayOutputStream doubleArrayOutputStream = new DoubleArrayOutputStream(0)) {
			assertEquals(0, doubleArrayOutputStream.available());
			
			doubleArrayOutputStream.write(1.0D);
			
			assertEquals(0, doubleArrayOutputStream.available());
			
			doubleArrayOutputStream.write(2.0D);
			
			assertEquals(0, doubleArrayOutputStream.available());
			
			doubleArrayOutputStream.write(3.0D);
			
			assertEquals(1, doubleArrayOutputStream.available());
		}
	}
	
	@Test
	public void testCapacity() {
		try(final DoubleArrayOutputStream doubleArrayOutputStream = new DoubleArrayOutputStream(0)) {
			assertEquals(0, doubleArrayOutputStream.capacity());
			
			doubleArrayOutputStream.write(1.0D);
			
			assertEquals(1, doubleArrayOutputStream.capacity());
			
			doubleArrayOutputStream.write(2.0D);
			
			assertEquals(2, doubleArrayOutputStream.capacity());
			
			doubleArrayOutputStream.write(3.0D);
			
			assertEquals(4, doubleArrayOutputStream.capacity());
			
			doubleArrayOutputStream.write(4.0D);
			
			assertEquals(4, doubleArrayOutputStream.capacity());
		}
	}
	
	@Test
	public void testConstructor() {
		try(final DoubleArrayOutputStream doubleArrayOutputStream = new DoubleArrayOutputStream()) {
			assertEquals(32, doubleArrayOutputStream.capacity());
		}
	}
	
	@Test
	public void testConstructorInt() {
		try(final DoubleArrayOutputStream doubleArrayOutputStream = new DoubleArrayOutputStream(10)) {
			assertEquals(10, doubleArrayOutputStream.capacity());
		}
		
		assertThrows(IllegalArgumentException.class, () -> new DoubleArrayOutputStream(-1));
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
		
//		try(final DoubleArrayOutputStream doubleArrayOutputStream = new DoubleArrayOutputStream(0)) {
//			doubleArrayOutputStream.write(new double[9]);
//			
//			assertThrows(OutOfMemoryError.class, () -> doubleArrayOutputStream.write(new double[(Integer.MAX_VALUE - 8) / 8]));
//		}
		
		/*
		 * The following try-block tests the following code in the doGrow(int) method:
		 * 
		 * if(newCapacity - MAX_ARRAY_SIZE > 0) {
		 *     newCapacity = minCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
		 * }
		 */
		
		try(final DoubleArrayOutputStream doubleArrayOutputStream = new DoubleArrayOutputStream(0)) {
			assertThrows(OutOfMemoryError.class, () -> {
				doubleArrayOutputStream.write(new double[1]);
				doubleArrayOutputStream.write(new double[2]);
				doubleArrayOutputStream.write(new double[4]);
				doubleArrayOutputStream.write(new double[8]);
				doubleArrayOutputStream.write(new double[16]);
				doubleArrayOutputStream.write(new double[32]);
				doubleArrayOutputStream.write(new double[64]);
				doubleArrayOutputStream.write(new double[128]);
				doubleArrayOutputStream.write(new double[256]);
				doubleArrayOutputStream.write(new double[512]);
				doubleArrayOutputStream.write(new double[1024]);
				doubleArrayOutputStream.write(new double[2048]);
				doubleArrayOutputStream.write(new double[4096]);
				doubleArrayOutputStream.write(new double[8192]);
				doubleArrayOutputStream.write(new double[16384]);
				doubleArrayOutputStream.write(new double[32768]);
				doubleArrayOutputStream.write(new double[65536]);
				doubleArrayOutputStream.write(new double[131072]);
				doubleArrayOutputStream.write(new double[262144]);
				doubleArrayOutputStream.write(new double[524288]);
				doubleArrayOutputStream.write(new double[1048576]);
				doubleArrayOutputStream.write(new double[2097152]);
				doubleArrayOutputStream.write(new double[4194304]);
				doubleArrayOutputStream.write(new double[8388608]);
				doubleArrayOutputStream.write(new double[16777216]);
				doubleArrayOutputStream.write(new double[33554432]);
				doubleArrayOutputStream.write(new double[67108864]);
				doubleArrayOutputStream.write(new double[134217728]);
			});
			
//			assertThrows(OutOfMemoryError.class, () -> doubleArrayOutputStream.write(new double[1]));
		}
	}
	
	@Test
	public void testReset() {
		try(final DoubleArrayOutputStream doubleArrayOutputStream = new DoubleArrayOutputStream(0)) {
			assertEquals(0, doubleArrayOutputStream.size());
			
			doubleArrayOutputStream.write(1.0D);
			
			assertEquals(1, doubleArrayOutputStream.size());
			
			doubleArrayOutputStream.write(2.0D);
			
			assertEquals(2, doubleArrayOutputStream.size());
			
			doubleArrayOutputStream.reset();
			
			assertEquals(0, doubleArrayOutputStream.size());
		}
	}
	
	@Test
	public void testSize() {
		try(final DoubleArrayOutputStream doubleArrayOutputStream = new DoubleArrayOutputStream(0)) {
			assertEquals(0, doubleArrayOutputStream.size());
			
			doubleArrayOutputStream.write(1.0D);
			
			assertEquals(1, doubleArrayOutputStream.size());
			
			doubleArrayOutputStream.write(2.0D);
			
			assertEquals(2, doubleArrayOutputStream.size());
			
			doubleArrayOutputStream.write(3.0D);
			
			assertEquals(3, doubleArrayOutputStream.size());
		}
	}
	
	@Test
	public void testToDoubleArray() {
		try(final DoubleArrayOutputStream doubleArrayOutputStream = new DoubleArrayOutputStream(0)) {
			doubleArrayOutputStream.write(new double[] {1.0D, 2.0D, 3.0D});
			
			assertArrayEquals(new double[] {1.0D, 2.0D, 3.0D}, doubleArrayOutputStream.toDoubleArray());
		}
	}
	
	@Test
	public void testWriteDouble() {
		try(final DoubleArrayOutputStream doubleArrayOutputStream = new DoubleArrayOutputStream(0)) {
			doubleArrayOutputStream.write(1.0D);
			doubleArrayOutputStream.write(2.0D);
			doubleArrayOutputStream.write(3.0D);
			
			assertArrayEquals(new double[] {1.0D, 2.0D, 3.0D}, doubleArrayOutputStream.toDoubleArray());
		}
	}
	
	@Test
	public void testWriteDoubleArray() {
		try(final DoubleArrayOutputStream doubleArrayOutputStream = new DoubleArrayOutputStream(0)) {
			doubleArrayOutputStream.write(new double[] {1.0D, 2.0D, 3.0D});
			
			assertArrayEquals(new double[] {1.0D, 2.0D, 3.0D}, doubleArrayOutputStream.toDoubleArray());
			
			assertThrows(NullPointerException.class, () -> doubleArrayOutputStream.write((double[])(null)));
		}
	}
	
	@Test
	public void testWriteDoubleArrayIntInt() {
		try(final DoubleArrayOutputStream doubleArrayOutputStream = new DoubleArrayOutputStream(0)) {
			doubleArrayOutputStream.write(new double[] {1.0D, 2.0D, 3.0D}, 0, 3);
			
			assertArrayEquals(new double[] {1.0D, 2.0D, 3.0D}, doubleArrayOutputStream.toDoubleArray());
			
			assertThrows(NullPointerException.class, () -> doubleArrayOutputStream.write((double[])(null), 0, 0));
			assertThrows(IndexOutOfBoundsException.class, () -> doubleArrayOutputStream.write(new double[] {}, -1, +0));
			assertThrows(IndexOutOfBoundsException.class, () -> doubleArrayOutputStream.write(new double[] {}, +1, +0));
			assertThrows(IndexOutOfBoundsException.class, () -> doubleArrayOutputStream.write(new double[] {}, +0, -1));
			assertThrows(IndexOutOfBoundsException.class, () -> doubleArrayOutputStream.write(new double[] {}, +0, +1));
		}
	}
	
	@Test
	public void testWriteInt() {
		try(final DoubleArrayOutputStream doubleArrayOutputStream = new DoubleArrayOutputStream(0)) {
			doubleArrayOutputStream.write(0);
			doubleArrayOutputStream.write(1);
			doubleArrayOutputStream.write(2);
			
			assertArrayEquals(new double[] {0, 1, 2}, doubleArrayOutputStream.toDoubleArray());
		}
	}
}