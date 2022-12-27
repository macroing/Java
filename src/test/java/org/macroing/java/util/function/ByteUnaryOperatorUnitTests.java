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
package org.macroing.java.util.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

@SuppressWarnings("static-method")
public final class ByteUnaryOperatorUnitTests {
	public ByteUnaryOperatorUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testAndThen() {
		final ByteUnaryOperator a = value -> (byte)(value * 2);
		final ByteUnaryOperator b = value -> (byte)(value / 2);
		final ByteUnaryOperator c = a.andThen(b);
		
		final byte value = c.applyAsByte((byte)(10));
		
		assertEquals((byte)(10), value);
		
		assertThrows(NullPointerException.class, () -> a.andThen(null));
	}
	
	@Test
	public void testCompose() {
		final ByteUnaryOperator a = value -> (byte)(value * 2);
		final ByteUnaryOperator b = value -> (byte)(value / 2);
		final ByteUnaryOperator c = a.compose(b);
		
		final byte value = c.applyAsByte((byte)(10));
		
		assertEquals((byte)(10), value);
		
		assertThrows(NullPointerException.class, () -> a.compose(null));
	}
	
	@Test
	public void testIdentity() {
		final ByteUnaryOperator byteUnaryOperator = ByteUnaryOperator.identity();
		
		final byte value = byteUnaryOperator.applyAsByte((byte)(10));
		
		assertEquals((byte)(10), value);
	}
}