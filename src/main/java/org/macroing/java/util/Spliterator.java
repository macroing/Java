/**
 * Copyright 2021 J&#246;rgen Lundgren
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

import java.util.function.Consumer;

import org.macroing.java.util.function.CharConsumer;

/**
 * An extended version of {@code java.util.Spliterator}.
 * <p>
 * Specialized subtypes are provided for {@link OfChar char}.
 * 
 * @param <T> the type of elements returned by this {@code Spliterator}
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
public interface Spliterator<T> extends java.util.Spliterator<T> {
	/**
	 * A {@code Spliterator} specialized for {@code char} values.
	 * 
	 * @since 1.0.0
	 * @author J&#246;rgen Lundgren
	 */
	public interface OfChar extends OfPrimitive<Character, CharConsumer, OfChar> {
		/**
		 * {@inheritDoc}
		 */
		@Override
		OfChar trySplit();
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		boolean tryAdvance(final CharConsumer action);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default boolean tryAdvance(final Consumer<? super Character> action) {
			return action instanceof CharConsumer ? tryAdvance((CharConsumer)(action)) : tryAdvance((CharConsumer)(action::accept));
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(final CharConsumer action) {
			do {
				
			} while(tryAdvance(action));
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(final Consumer<? super Character> action) {
			if(action instanceof CharConsumer) {
				forEachRemaining((CharConsumer)(action));
			} else {
				forEachRemaining((CharConsumer)(action::accept));
			}
		}
	}
}