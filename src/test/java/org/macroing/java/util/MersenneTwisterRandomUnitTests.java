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
package org.macroing.java.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;

@SuppressWarnings("static-method")
public final class MersenneTwisterRandomUnitTests {
	public MersenneTwisterRandomUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testNextDouble() {
		final Random random = new MersenneTwisterRandom();
		
		for(int i = 0; i < 1000000; i++) {
			final double value = random.nextDouble();
			
			assertTrue(value >= 0.0D && value < 1.0D);
		}
	}
	
	@Test
	public void testNextFloat() {
		final Random random = new MersenneTwisterRandom();
		
		for(int i = 0; i < 1000000; i++) {
			final float value = random.nextFloat();
			
			assertTrue(value >= 0.0F && value < 1.0F);
		}
	}
}