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
package org.macroing.java.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

@SuppressWarnings("static-method")
public final class RandomsUnitTests {
	private RandomsUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testNextBoolean() {
		final boolean value = Randoms.nextBoolean();
		
		assertTrue(value == false || value == true);
	}
	
	@Test
	public void testNextDouble() {
		for(int i = 0; i < 100000; i++) {
			final double value = Randoms.nextDouble();
			
			assertTrue(value >= 0.0D && value < 1.0D);
		}
	}
	
	@Test
	public void testNextDoubleDouble() {
		for(int i = 0; i < 100000; i++) {
			final double value = Randoms.nextDouble(100.0D);
			
			assertTrue(value >= 0.0D && value < 100.0D);
		}
		
		assertThrows(IllegalArgumentException.class, () -> Randoms.nextDouble(0.0D));
	}
	
	@Test
	public void testNextDoubleDoubleDouble() {
		for(int i = 0; i < 100000; i++) {
			final double value = Randoms.nextDouble(-100.0D, 100.0D);
			
			assertTrue(value >= -100.0D && value < 100.0D);
		}
		
		assertThrows(IllegalArgumentException.class, () -> Randoms.nextDouble(0.0D, 0.0D));
	}
	
	@Test
	public void testNextFloat() {
		for(int i = 0; i < 100000; i++) {
			final float value = Randoms.nextFloat();
			
			assertTrue(value >= 0.0F && value < 1.0F);
		}
	}
	
	@Test
	public void testNextFloatFloat() {
		for(int i = 0; i < 100000; i++) {
			final float value = Randoms.nextFloat(100.0F);
			
			assertTrue(value >= 0.0F && value < 100.0F);
		}
		
		assertThrows(IllegalArgumentException.class, () -> Randoms.nextFloat(0.0F));
	}
	
	@Test
	public void testNextFloatFloatFloat() {
		for(int i = 0; i < 100000; i++) {
			final float value = Randoms.nextFloat(-100.0F, 100.0F);
			
			assertTrue(value >= -100.0F && value < 100.0F);
		}
		
		assertThrows(IllegalArgumentException.class, () -> Randoms.nextFloat(0.0F, 0.0F));
	}
	
	@Test
	public void testNextFloatInternal() {
		assertEquals(1.0F, Randoms.nextFloatInternal(2.0F, 1.0F));
		assertEquals(Float.intBitsToFloat(Float.floatToIntBits(2.0F) - 1), Randoms.nextFloatInternal(2.0F, 2.0F));
	}
	
	@Test
	public void testNextInt() {
		for(int i = 0; i < 100000; i++) {
			final int value = Randoms.nextInt();
			
			assertTrue(value >= Integer.MIN_VALUE && value <= Integer.MAX_VALUE);
		}
	}
	
	@Test
	public void testNextIntInt() {
		for(int i = 0; i < 100000; i++) {
			final int value = Randoms.nextInt(100);
			
			assertTrue(value >= 0 && value < 100);
		}
		
		assertThrows(IllegalArgumentException.class, () -> Randoms.nextInt(0));
	}
	
	@Test
	public void testNextIntIntInt() {
		for(int i = 0; i < 100000; i++) {
			final int value = Randoms.nextInt(-100, 100);
			
			assertTrue(value >= -100 && value < 100);
		}
		
		assertThrows(IllegalArgumentException.class, () -> Randoms.nextInt(0, 0));
	}
}