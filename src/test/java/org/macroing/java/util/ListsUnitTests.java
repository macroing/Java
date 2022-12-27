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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

@SuppressWarnings("static-method")
public final class ListsUnitTests {
	public ListsUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testRequireNonNull() {
		assertThrows(NullPointerException.class, () -> Lists.requireNonNull(null, "list"));
		assertThrows(NullPointerException.class, () -> Lists.requireNonNull(new ArrayList<>(), null));
		assertThrows(NullPointerException.class, () -> Lists.requireNonNull(Arrays.asList("A", null, "C"), "list"));
		
		assertEquals(Arrays.asList("A", "B", "C"), Lists.requireNonNull(Arrays.asList("A", "B", "C"), "list"));
	}
}