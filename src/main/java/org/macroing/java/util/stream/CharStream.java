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
package org.macroing.java.util.stream;

import java.lang.reflect.Field;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.BaseStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.macroing.java.util.OptionalChar;
import org.macroing.java.util.PrimitiveIterator;
import org.macroing.java.util.Spliterator;
import org.macroing.java.util.function.CharBinaryOperator;
import org.macroing.java.util.function.CharConsumer;
import org.macroing.java.util.function.CharFunction;
import org.macroing.java.util.function.CharPredicate;
import org.macroing.java.util.function.CharToIntFunction;
import org.macroing.java.util.function.CharToLongFunction;
import org.macroing.java.util.function.CharUnaryOperator;
import org.macroing.java.util.function.ObjCharConsumer;

/**
 * A sequence of primitive {@code char}-valued elements supporting sequential and parallel aggregate operations.
 * <p>
 * This is the {@code char} primitive specialization of {@code Stream}.
 * 
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
public interface CharStream extends BaseStream<Character, CharStream> {
//	TODO: Add Javadocs!
	CharStream distinct();
	
//	TODO: Add Javadocs!
	CharStream filter(final CharPredicate predicate);
	
//	TODO: Add Javadocs!
	CharStream flatMap(final CharFunction<? extends CharStream> mapper);
	
//	TODO: Add Javadocs!
	CharStream limit(final long maxSize);
	
//	TODO: Add Javadocs!
	CharStream map(final CharUnaryOperator mapper);
	
//	TODO: Add Javadocs!
	@Override
	CharStream parallel();
	
//	TODO: Add Javadocs!
	CharStream peek(final CharConsumer action);
	
//	TODO: Add Javadocs!
	@Override
	CharStream sequential();
	
//	TODO: Add Javadocs!
	CharStream skip(final long n);
	
//	TODO: Add Javadocs!
	CharStream sorted();
	
//	TODO: Add Javadocs!
	IntStream mapToInt(final CharToIntFunction mapper);
	
//	TODO: Add Javadocs!
	LongStream mapToLong(final CharToLongFunction mapper);
	
//	TODO: Add Javadocs!
	OptionalChar findAny();
	
//	TODO: Add Javadocs!
	OptionalChar findFirst();
	
//	TODO: Add Javadocs!
	OptionalChar max();
	
//	TODO: Add Javadocs!
	OptionalChar min();
	
//	TODO: Add Javadocs!
	OptionalChar reduce(final CharBinaryOperator op);
	
//	TODO: Add Javadocs!
	@Override
	PrimitiveIterator.OfChar iterator();
	
//	TODO: Add Javadocs!
	<R> R collect(final Supplier<R> supplier, final ObjCharConsumer<R> accumulator, final BiConsumer<R, R> combiner);
	
//	TODO: Add Javadocs!
	@Override
	Spliterator.OfChar spliterator();
	
//	TODO: Add Javadocs!
	Stream<Character> boxed();
	
//	TODO: Add Javadocs!
	<U> Stream<U> mapToObj(final CharFunction<? extends U> mapper);
	
//	TODO: Add Javadocs!
	boolean allMatch(final CharPredicate predicate);
	
//	TODO: Add Javadocs!
	boolean anyMatch(final CharPredicate predicate);
	
//	TODO: Add Javadocs!
	boolean noneMatch(final CharPredicate predicate);
	
//	TODO: Add Javadocs!
	char reduce(final char identity, final CharBinaryOperator op);
	
//	TODO: Add Javadocs!
	char[] toArray();
	
//	TODO: Add Javadocs!
	long count();
	
//	TODO: Add Javadocs!
	void forEach(final CharConsumer action);
	
//	TODO: Add Javadocs!
	void forEachOrdered(final CharConsumer action);
}