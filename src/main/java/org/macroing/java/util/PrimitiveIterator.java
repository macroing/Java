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

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

import org.macroing.java.util.function.BooleanConsumer;
import org.macroing.java.util.function.ByteConsumer;
import org.macroing.java.util.function.CharConsumer;
import org.macroing.java.util.function.FloatConsumer;
import org.macroing.java.util.function.ShortConsumer;

/**
 * An extended version of {@code java.util.PrimitiveIterator}.
 * <p>
 * Specialized subtypes are provided for {@link OfBoolean boolean}, {@link OfByte byte}, {@link OfChar char}, {@link OfFloat float} and {@link OfShort short}.
 * 
 * @param <T> the type of elements returned by this {@code PrimitiveIterator}
 * @param <T_CONS> the type of primitive consumer
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
public interface PrimitiveIterator<T, T_CONS> extends java.util.PrimitiveIterator<T, T_CONS> {
	/**
	 * An {@code Iterator} specialized for {@code boolean} values.
	 * 
	 * @since 1.0.0
	 * @author J&#246;rgen Lundgren
	 */
	public static interface OfBoolean extends PrimitiveIterator<Boolean, BooleanConsumer> {
		/**
		 * Returns the next {@code boolean} element in the iteration.
		 * <p>
		 * If the iteration has no more elements, a {@code NoSuchElementException} will be thrown.
		 * 
		 * @return the next {@code boolean} element in the iteration
		 * @throws NoSuchElementException thrown if, and only if, the iteration has no more elements
		 */
		boolean nextBoolean();
		
		////////////////////////////////////////////////////////////////////////////////////////////////////
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default Boolean next() {
			return Boolean.valueOf(nextBoolean());
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(final Consumer<? super Boolean> action) {
			if(action instanceof BooleanConsumer) {
				forEachRemaining((BooleanConsumer)(action));
			} else {
				Objects.requireNonNull(action);
				
				forEachRemaining((BooleanConsumer)(action::accept));
			}
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(final BooleanConsumer action) {
			Objects.requireNonNull(action);
			
			while(hasNext()) {
				action.accept(nextBoolean());
			}
		}
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * An {@code Iterator} specialized for {@code byte} values.
	 * 
	 * @since 1.0.0
	 * @author J&#246;rgen Lundgren
	 */
	public static interface OfByte extends PrimitiveIterator<Byte, ByteConsumer> {
		/**
		 * Returns the next {@code byte} element in the iteration.
		 * <p>
		 * If the iteration has no more elements, a {@code NoSuchElementException} will be thrown.
		 * 
		 * @return the next {@code byte} element in the iteration
		 * @throws NoSuchElementException thrown if, and only if, the iteration has no more elements
		 */
		byte nextByte();
		
		////////////////////////////////////////////////////////////////////////////////////////////////////
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default Byte next() {
			return Byte.valueOf(nextByte());
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(final Consumer<? super Byte> action) {
			if(action instanceof ByteConsumer) {
				forEachRemaining((ByteConsumer)(action));
			} else {
				Objects.requireNonNull(action);
				
				forEachRemaining((ByteConsumer)(action::accept));
			}
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(final ByteConsumer action) {
			Objects.requireNonNull(action);
			
			while(hasNext()) {
				action.accept(nextByte());
			}
		}
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * An {@code Iterator} specialized for {@code char} values.
	 * 
	 * @since 1.0.0
	 * @author J&#246;rgen Lundgren
	 */
	public static interface OfChar extends PrimitiveIterator<Character, CharConsumer> {
		/**
		 * Returns the next {@code char} element in the iteration.
		 * <p>
		 * If the iteration has no more elements, a {@code NoSuchElementException} will be thrown.
		 * 
		 * @return the next {@code char} element in the iteration
		 * @throws NoSuchElementException thrown if, and only if, the iteration has no more elements
		 */
		char nextChar();
		
		////////////////////////////////////////////////////////////////////////////////////////////////////
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default Character next() {
			return Character.valueOf(nextChar());
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(final Consumer<? super Character> action) {
			if(action instanceof CharConsumer) {
				forEachRemaining((CharConsumer)(action));
			} else {
				Objects.requireNonNull(action);
				
				forEachRemaining((CharConsumer)(action::accept));
			}
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(final CharConsumer action) {
			Objects.requireNonNull(action);
			
			while(hasNext()) {
				action.accept(nextChar());
			}
		}
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * An {@code Iterator} specialized for {@code float} values.
	 * 
	 * @since 1.0.0
	 * @author J&#246;rgen Lundgren
	 */
	public static interface OfFloat extends PrimitiveIterator<Float, FloatConsumer> {
		/**
		 * Returns the next {@code float} element in the iteration.
		 * <p>
		 * If the iteration has no more elements, a {@code NoSuchElementException} will be thrown.
		 * 
		 * @return the next {@code float} element in the iteration
		 * @throws NoSuchElementException thrown if, and only if, the iteration has no more elements
		 */
		float nextFloat();
		
		////////////////////////////////////////////////////////////////////////////////////////////////////
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default Float next() {
			return Float.valueOf(nextFloat());
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(final Consumer<? super Float> action) {
			if(action instanceof FloatConsumer) {
				forEachRemaining((FloatConsumer)(action));
			} else {
				Objects.requireNonNull(action);
				
				forEachRemaining((FloatConsumer)(action::accept));
			}
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(final FloatConsumer action) {
			Objects.requireNonNull(action);
			
			while(hasNext()) {
				action.accept(nextFloat());
			}
		}
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * An {@code Iterator} specialized for {@code short} values.
	 * 
	 * @since 1.0.0
	 * @author J&#246;rgen Lundgren
	 */
	public static interface OfShort extends PrimitiveIterator<Short, ShortConsumer> {
		/**
		 * Returns the next {@code short} element in the iteration.
		 * <p>
		 * If the iteration has no more elements, a {@code NoSuchElementException} will be thrown.
		 * 
		 * @return the next {@code short} element in the iteration
		 * @throws NoSuchElementException thrown if, and only if, the iteration has no more elements
		 */
		short nextShort();
		
		////////////////////////////////////////////////////////////////////////////////////////////////////
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default Short next() {
			return Short.valueOf(nextShort());
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(final Consumer<? super Short> action) {
			if(action instanceof ShortConsumer) {
				forEachRemaining((ShortConsumer)(action));
			} else {
				Objects.requireNonNull(action);
				
				forEachRemaining((ShortConsumer)(action::accept));
			}
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(final ShortConsumer action) {
			Objects.requireNonNull(action);
			
			while(hasNext()) {
				action.accept(nextShort());
			}
		}
	}
}