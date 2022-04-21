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

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

/**
 * A {@code Timer} represents a timer that can measure how long an activity has taken.
 * <p>
 * When you create a new {@code Timer} instance, it starts immediately. If you want to restart it, consider calling {@link #restart()} or {@link #restart(long)}.
 * <p>
 * The default methods of this class uses {@code System.currentTimeMillis()} in the calculations. But all default methods have an overloaded method that requires a {@code long milliseconds} parameter. Prefer to use these overloaded methods whenever you need to call multiple methods at the same "time". Otherwise, the results you get may not end up as you would expect.
 * 
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
public final class Timer {
	private final AtomicLong millisecondsFrom;
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Constructs a new {@code Timer} instance and starts it.
	 * <p>
	 * Calling this constructor is equivalent to the following:
	 * <pre>
	 * {@code
	 * new Timer(System.currentTimeMillis());
	 * }
	 * </pre>
	 */
	public Timer() {
		this(System.currentTimeMillis());
	}
	
	/**
	 * Constructs a new {@code Timer} instance and starts it.
	 * 
	 * @param millisecondsFrom the milliseconds to measure from
	 */
	public Timer(final long millisecondsFrom) {
		this.millisecondsFrom = new AtomicLong(millisecondsFrom);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Returns a {@code String} with the hours, minutes and seconds that have passed between the time at which this {@code Timer} instance was started or restarted and now.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * getTime(System.currentTimeMillis());
	 * }
	 * </pre>
	 * 
	 * @return a {@code String} with the hours, minutes and seconds that have passed between the time at which this {@code Timer} instance was started or restarted and now
	 */
	public String getTime() {
		return getTime(System.currentTimeMillis());
	}
	
	/**
	 * Returns a {@code String} with the hours, minutes and seconds that have passed between the time at which this {@code Timer} instance was started or restarted and {@code millisecondsTo}.
	 * <p>
	 * This method uses {@code getHours(millisecondsTo)}, {@code getMinutesRemaining(millisecondsTo)} and {@code getSecondsRemaining(millisecondsTo)} to get the hours, minutes and seconds, respectively.
	 * 
	 * @param millisecondsTo the milliseconds to measure to
	 * @return a {@code String} with the hours, minutes and seconds that have passed between the time at which this {@code Timer} instance was started or restarted and {@code millisecondsTo}
	 */
	public String getTime(final long millisecondsTo) {
		return String.format("%02d:%02d:%02d", Long.valueOf(getHours(millisecondsTo)), Long.valueOf(getMinutesRemaining(millisecondsTo)), Long.valueOf(getSecondsRemaining(millisecondsTo)));
	}
	
	/**
	 * Returns a {@code String} representation of this {@code Timer} instance.
	 * 
	 * @return a {@code String} representation of this {@code Timer} instance
	 */
	@Override
	public String toString() {
		return String.format("new Timer(%sL)", Long.toString(getMillisecondsFrom()));
	}
	
	/**
	 * Compares {@code object} to this {@code Timer} instance for equality.
	 * <p>
	 * Returns {@code true} if, and only if, {@code object} is an instance of {@code Timer}, and their respective values are equal, {@code false} otherwise.
	 * 
	 * @param object the {@code Object} to compare to this {@code Timer} instance for equality
	 * @return {@code true} if, and only if, {@code object} is an instance of {@code Timer}, and their respective values are equal, {@code false} otherwise
	 */
	@Override
	public boolean equals(final Object object) {
		if(object == this) {
			return true;
		} else if(!(object instanceof Timer)) {
			return false;
		} else if(getMillisecondsFrom() != Timer.class.cast(object).getMillisecondsFrom()) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Returns a hash code for this {@code Timer} instance.
	 * 
	 * @return a hash code for this {@code Timer} instance
	 */
	@Override
	public int hashCode() {
		return Objects.hash(Long.valueOf(getMillisecondsFrom()));
	}
	
	/**
	 * Returns the hours that have passed between the time at which this {@code Timer} instance was started or restarted and now.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * getHours(System.currentTimeMillis());
	 * }
	 * </pre>
	 * 
	 * @return the hours that have passed between the time at which this {@code Timer} instance was started or restarted and now
	 */
	public long getHours() {
		return getHours(System.currentTimeMillis());
	}
	
	/**
	 * Returns the hours that have passed between the time at which this {@code Timer} instance was started or restarted and {@code millisecondsTo}.
	 * 
	 * @param millisecondsTo the milliseconds to measure to
	 * @return the hours that have passed between the time at which this {@code Timer} instance was started or restarted and {@code millisecondsTo}
	 */
	public long getHours(final long millisecondsTo) {
		return (millisecondsTo - getMillisecondsFrom()) / (60L * 60L * 1000L);
	}
	
	/**
	 * Returns the milliseconds that have passed between the time at which this {@code Timer} instance was started or restarted and now.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * getMilliseconds(System.currentTimeMillis());
	 * }
	 * </pre>
	 * 
	 * @return the milliseconds that have passed between the time at which this {@code Timer} instance was started or restarted and now
	 */
	public long getMilliseconds() {
		return getMilliseconds(System.currentTimeMillis());
	}
	
	/**
	 * Returns the milliseconds that have passed between the time at which this {@code Timer} instance was started or restarted and {@code millisecondsTo}.
	 * 
	 * @param millisecondsTo the milliseconds to measure to
	 * @return the milliseconds that have passed between the time at which this {@code Timer} instance was started or restarted and {@code millisecondsTo}
	 */
	public long getMilliseconds(final long millisecondsTo) {
		return millisecondsTo - getMillisecondsFrom();
	}
	
	/**
	 * Returns the milliseconds to measure from.
	 * 
	 * @return the milliseconds to measure from
	 */
	public long getMillisecondsFrom() {
		return this.millisecondsFrom.get();
	}
	
	/**
	 * Returns the milliseconds that have passed between the time at which this {@code Timer} instance was started or restarted and now, excluding the milliseconds that are represented by full hours, minutes and seconds.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * getMillisecondsRemaining(System.currentTimeMillis());
	 * }
	 * </pre>
	 * 
	 * @return the milliseconds that have passed between the time at which this {@code Timer} instance was started or restarted and now, excluding the milliseconds that are represented by full hours, minutes and seconds
	 */
	public long getMillisecondsRemaining() {
		return getMillisecondsRemaining(System.currentTimeMillis());
	}
	
	/**
	 * Returns the milliseconds that have passed between the time at which this {@code Timer} instance was started or restarted and {@code millisecondsTo}, excluding the milliseconds that are represented by full hours, minutes and seconds.
	 * 
	 * @param millisecondsTo the milliseconds to measure to
	 * @return the milliseconds that have passed between the time at which this {@code Timer} instance was started or restarted and {@code millisecondsTo}, excluding the milliseconds that are represented by full hours, minutes and seconds
	 */
	public long getMillisecondsRemaining(final long millisecondsTo) {
		return getMilliseconds(millisecondsTo) - getHours(millisecondsTo) * 60L * 60L * 1000L - getMinutesRemaining(millisecondsTo) * 60L * 1000L - getSecondsRemaining(millisecondsTo) * 1000L;
	}
	
	/**
	 * Returns the minutes that have passed between the time at which this {@code Timer} instance was started or restarted and now.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * getMinutes(System.currentTimeMillis());
	 * }
	 * </pre>
	 * 
	 * @return the minutes that have passed between the time at which this {@code Timer} instance was started or restarted and now
	 */
	public long getMinutes() {
		return getMinutes(System.currentTimeMillis());
	}
	
	/**
	 * Returns the minutes that have passed between the time at which this {@code Timer} instance was started or restarted and {@code millisecondsTo}.
	 * 
	 * @param millisecondsTo the milliseconds to measure to
	 * @return the minutes that have passed between the time at which this {@code Timer} instance was started or restarted and {@code millisecondsTo}
	 */
	public long getMinutes(final long millisecondsTo) {
		return (millisecondsTo - getMillisecondsFrom()) / (60L * 1000L);
	}
	
	/**
	 * Returns the minutes that have passed between the time at which this {@code Timer} instance was started or restarted and now, excluding the minutes that are represented by full hours.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * getMinutesRemaining(System.currentTimeMillis());
	 * }
	 * </pre>
	 * 
	 * @return the minutes that have passed between the time at which this {@code Timer} instance was started or restarted and now, excluding the minutes that are represented by full hours
	 */
	public long getMinutesRemaining() {
		return getMinutesRemaining(System.currentTimeMillis());
	}
	
	/**
	 * Returns the minutes that have passed between the time at which this {@code Timer} instance was started or restarted and {@code millisecondsTo}, excluding the minutes that are represented by full hours.
	 * 
	 * @param millisecondsTo the milliseconds to measure to
	 * @return the minutes that have passed between the time at which this {@code Timer} instance was started or restarted and {@code millisecondsTo}, excluding the minutes that are represented by full hours
	 */
	public long getMinutesRemaining(final long millisecondsTo) {
		return getMinutes(millisecondsTo) - getHours(millisecondsTo) * 60L;
	}
	
	/**
	 * Returns the seconds that have passed between the time at which this {@code Timer} instance was started or restarted and now.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * getSeconds(System.currentTimeMillis());
	 * }
	 * </pre>
	 * 
	 * @return the seconds that have passed between the time at which this {@code Timer} instance was started or restarted and now
	 */
	public long getSeconds() {
		return getSeconds(System.currentTimeMillis());
	}
	
	/**
	 * Returns the seconds that have passed between the time at which this {@code Timer} instance was started or restarted and {@code millisecondsTo}.
	 * 
	 * @param millisecondsTo the milliseconds to measure to
	 * @return the seconds that have passed between the time at which this {@code Timer} instance was started or restarted and {@code millisecondsTo}
	 */
	public long getSeconds(final long millisecondsTo) {
		return (millisecondsTo - getMillisecondsFrom()) / 1000L;
	}
	
	/**
	 * Returns the seconds that have passed between the time at which this {@code Timer} instance was started or restarted and now, excluding the seconds that are represented by full hours and minutes.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * getSecondsRemaining(System.currentTimeMillis());
	 * }
	 * </pre>
	 * 
	 * @return the seconds that have passed between the time at which this {@code Timer} instance was started or restarted and now, excluding the seconds that are represented by full hours and minutes
	 */
	public long getSecondsRemaining() {
		return getSecondsRemaining(System.currentTimeMillis());
	}
	
	/**
	 * Returns the seconds that have passed between the time at which this {@code Timer} instance was started or restarted and {@code millisecondsTo}, excluding the seconds that are represented by full hours and minutes.
	 * 
	 * @param millisecondsTo the milliseconds to measure to
	 * @return the seconds that have passed between the time at which this {@code Timer} instance was started or restarted and {@code millisecondsTo}, excluding the seconds that are represented by full hours and minutes
	 */
	public long getSecondsRemaining(final long millisecondsTo) {
		return getSeconds(millisecondsTo) - getHours(millisecondsTo) * 60L * 60L - getMinutesRemaining(millisecondsTo) * 60L;
	}
	
	/**
	 * Restarts this {@code Timer} instance.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * restart(System.currentTimeMillis());
	 * }
	 * </pre>
	 */
	public void restart() {
		restart(System.currentTimeMillis());
	}
	
	/**
	 * Restarts this {@code Timer} instance.
	 * 
	 * @param millisecondsFrom the milliseconds to measure from
	 */
	public void restart(final long millisecondsFrom) {
		this.millisecondsFrom.set(millisecondsFrom);
	}
}