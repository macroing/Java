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

import java.util.List;
import java.util.Objects;

/**
 * A class that consists exclusively of static methods that returns or performs various operations on {@code List} instances.
 * 
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
public final class Lists {
	private Lists() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Checks that {@code list} and all of its elements are not {@code null}.
	 * <p>
	 * Returns {@code list}.
	 * <p>
	 * If either {@code list}, an element in {@code list} or {@code name} are {@code null}, a {@code NullPointerException} will be thrown.
	 * 
	 * @param <T> the generic type of {@code list}
	 * @param list the {@code List} to check
	 * @param name the name of the parameter argument used for {@code list}, that will be part of the message for the {@code NullPointerException}
	 * @return {@code list}
	 * @throws NullPointerException thrown if, and only if, either {@code list}, an element in {@code list} or {@code name} are {@code null}
	 */
	public static <T> List<T> requireNonNull(final List<T> list, final String name) {
		Objects.requireNonNull(name, "name == null");
		
		if(list == null) {
			throw new NullPointerException(String.format("%s == null", name));
		}
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == null) {
				throw new NullPointerException(String.format("%s.get(%d) == null", name, Integer.valueOf(i)));
			}
		}
		
		return list;
	}
}