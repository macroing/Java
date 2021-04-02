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

import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.macroing.java.util.OptionalChar;
import org.macroing.java.util.PrimitiveIterator.OfChar;
import org.macroing.java.util.Spliterator;
import org.macroing.java.util.function.CharBinaryOperator;
import org.macroing.java.util.function.CharConsumer;
import org.macroing.java.util.function.CharFunction;
import org.macroing.java.util.function.CharPredicate;
import org.macroing.java.util.function.CharToIntFunction;
import org.macroing.java.util.function.CharToLongFunction;
import org.macroing.java.util.function.CharUnaryOperator;
import org.macroing.java.util.function.ObjCharConsumer;

final class CharStreamImpl implements CharStream {
	@Override
	public CharStream distinct() {
		return null;
	}
	
	@Override
	public CharStream filter(final CharPredicate predicate) {
		return null;
	}
	
	@Override
	public CharStream flatMap(final CharFunction<? extends CharStream> mapper) {
		return null;
	}
	
	@Override
	public CharStream limit(final long maxSize) {
		return null;
	}
	
	@Override
	public CharStream map(final CharUnaryOperator mapper) {
		return null;
	}
	
	@Override
	public CharStream onClose(final Runnable closeHandler) {
		return null;
	}
	
	@Override
	public CharStream parallel() {
		return null;
	}
	
	@Override
	public CharStream peek(final CharConsumer action) {
		return null;
	}
	
	@Override
	public CharStream sequential() {
		return null;
	}
	
	@Override
	public CharStream skip(final long n) {
		return null;
	}
	
	@Override
	public CharStream sorted() {
		return null;
	}
	
	@Override
	public CharStream unordered() {
		return null;
	}
	
	@Override
	public IntStream mapToInt(final CharToIntFunction mapper) {
		return null;
	}
	
	@Override
	public LongStream mapToLong(final CharToLongFunction mapper) {
		return null;
	}
	
	@Override
	public OptionalChar findAny() {
		return null;
	}
	
	@Override
	public OptionalChar findFirst() {
		return null;
	}
	
	@Override
	public OptionalChar max() {
		return null;
	}
	
	@Override
	public OptionalChar min() {
		return null;
	}
	
	@Override
	public OptionalChar reduce(final CharBinaryOperator op) {
		return null;
	}
	
	@Override
	public OfChar iterator() {
		return null;
	}
	
	@Override
	public <R> R collect(final Supplier<R> supplier, final ObjCharConsumer<R> accumulator, final BiConsumer<R, R> combiner) {
		return null;
	}
	
	@Override
	public Spliterator.OfChar spliterator() {
		return null;
	}
	
	@Override
	public Stream<Character> boxed() {
		return null;
	}
	
	@Override
	public <U> Stream<U> mapToObj(final CharFunction<? extends U> mapper) {
		return null;
	}
	
	@Override
	public boolean allMatch(final CharPredicate predicate) {
		return false;
	}
	
	@Override
	public boolean anyMatch(final CharPredicate predicate) {
		return false;
	}
	
	@Override
	public boolean isParallel() {
		return false;
	}
	
	@Override
	public boolean noneMatch(final CharPredicate predicate) {
		return false;
	}
	
	@Override
	public char reduce(final char identity, final CharBinaryOperator op) {
		return 0;
	}
	
	@Override
	public char[] toArray() {
		return null;
	}
	
	@Override
	public long count() {
		return 0;
	}
	
	@Override
	public void close() {
		
	}
	
	@Override
	public void forEach(final CharConsumer action) {
		
	}
	
	@Override
	public void forEachOrdered(final CharConsumer action) {
		
	}
}