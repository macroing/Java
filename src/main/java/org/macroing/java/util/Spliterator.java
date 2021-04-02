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

import org.macroing.java.util.function.BooleanConsumer;
import org.macroing.java.util.function.ByteConsumer;
import org.macroing.java.util.function.CharConsumer;
import org.macroing.java.util.function.FloatConsumer;
import org.macroing.java.util.function.ShortConsumer;

/**
 * An extended version of {@code java.util.Spliterator}.
 * <p>
 * Specialized subtypes are provided for {@link OfBoolean boolean}, {@link OfByte byte}, {@link OfChar char}, {@link OfFloat float} and {@link OfShort short}.
 * 
 * @param <T> the type of elements returned by this {@code Spliterator}
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
public interface Spliterator<T> extends java.util.Spliterator<T> {
	/**
	 * A {@code Spliterator} specialized for {@code boolean} values.
	 * 
	 * @since 1.0.0
	 * @author J&#246;rgen Lundgren
	 */
	public interface OfBoolean extends OfPrimitive<Boolean, BooleanConsumer, OfBoolean> {
		/**
		 * {@inheritDoc}
		 */
		@Override
		OfBoolean trySplit();
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		boolean tryAdvance(final BooleanConsumer action);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default boolean tryAdvance(final Consumer<? super Boolean> action) {
			return action instanceof BooleanConsumer ? tryAdvance((BooleanConsumer)(action)) : tryAdvance((BooleanConsumer)(action::accept));
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(final BooleanConsumer action) {
			do {
				
			} while(tryAdvance(action));
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(final Consumer<? super Boolean> action) {
			if(action instanceof BooleanConsumer) {
				forEachRemaining((BooleanConsumer)(action));
			} else {
				forEachRemaining((BooleanConsumer)(action::accept));
			}
		}
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * A {@code Spliterator} specialized for {@code byte} values.
	 * 
	 * @since 1.0.0
	 * @author J&#246;rgen Lundgren
	 */
	public interface OfByte extends OfPrimitive<Byte, ByteConsumer, OfByte> {
		/**
		 * {@inheritDoc}
		 */
		@Override
		OfByte trySplit();
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		boolean tryAdvance(final ByteConsumer action);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default boolean tryAdvance(final Consumer<? super Byte> action) {
			return action instanceof ByteConsumer ? tryAdvance((ByteConsumer)(action)) : tryAdvance((ByteConsumer)(action::accept));
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(final ByteConsumer action) {
			do {
				
			} while(tryAdvance(action));
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(final Consumer<? super Byte> action) {
			if(action instanceof ByteConsumer) {
				forEachRemaining((ByteConsumer)(action));
			} else {
				forEachRemaining((ByteConsumer)(action::accept));
			}
		}
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
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
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * A {@code Spliterator} specialized for {@code float} values.
	 * 
	 * @since 1.0.0
	 * @author J&#246;rgen Lundgren
	 */
	public interface OfFloat extends OfPrimitive<Float, FloatConsumer, OfFloat> {
		/**
		 * {@inheritDoc}
		 */
		@Override
		OfFloat trySplit();
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		boolean tryAdvance(final FloatConsumer action);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default boolean tryAdvance(final Consumer<? super Float> action) {
			return action instanceof FloatConsumer ? tryAdvance((FloatConsumer)(action)) : tryAdvance((FloatConsumer)(action::accept));
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(final FloatConsumer action) {
			do {
				
			} while(tryAdvance(action));
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(final Consumer<? super Float> action) {
			if(action instanceof FloatConsumer) {
				forEachRemaining((FloatConsumer)(action));
			} else {
				forEachRemaining((FloatConsumer)(action::accept));
			}
		}
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * A {@code Spliterator} specialized for {@code short} values.
	 * 
	 * @since 1.0.0
	 * @author J&#246;rgen Lundgren
	 */
	public interface OfShort extends OfPrimitive<Short, ShortConsumer, OfShort> {
		/**
		 * {@inheritDoc}
		 */
		@Override
		OfShort trySplit();
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		boolean tryAdvance(final ShortConsumer action);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default boolean tryAdvance(final Consumer<? super Short> action) {
			return action instanceof ShortConsumer ? tryAdvance((ShortConsumer)(action)) : tryAdvance((ShortConsumer)(action::accept));
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(final ShortConsumer action) {
			do {
				
			} while(tryAdvance(action));
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(final Consumer<? super Short> action) {
			if(action instanceof ShortConsumer) {
				forEachRemaining((ShortConsumer)(action));
			} else {
				forEachRemaining((ShortConsumer)(action::accept));
			}
		}
	}
}