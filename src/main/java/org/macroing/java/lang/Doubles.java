/**
 * Copyright 2021 - 2026 J&#246;rgen Lundgren
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
package org.macroing.java.lang;

/**
 * The class {@code Doubles} contains methods for performing on {@code double} values.
 * <p>
 * You can think of this class as an extension to both {@code Double} and {@code Math}. It does what {@code Math} does for the {@code double}, {@code float} and {@code int} types, but for the {@code double} type only. In addition to this it also adds new methods.
 * <p>
 * This class does not contain all methods from {@code Math}. The methods in {@code Math} that deals with the {@code float} type can be found in the class {@link Floats}. The methods in {@code Math} that deals with the {@code int} type can be found in the class {@link Ints}.
 * <p>
 * The documentation in this class should be comprehensive. But some of the details covered in the documentation of the {@code Double} or {@code Math} classes may be missing. To get the full documentation for a particular method, you may want to look at the documentation of the corresponding method in the {@code Double} or {@code Math} class. This is, of course, only true if the method you're looking at exists in the {@code Double} or {@code Math} class.
 * <p>
 * Not all methods in the {@code Double} and {@code Math} classes that should be added to this class, may have been added yet.
 * 
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
public final class Doubles {
	/**
	 * The {@code double} value that represents a machine epsilon.
	 */
	public static final double MACHINE_EPSILON = Math.ulp(1.0D) * 0.5D;
	
	/**
	 * The maximum {@code double} value that is equal to {@code +Double.MAX_VALUE}.
	 */
	public static final double MAX_VALUE = +Double.MAX_VALUE;
	
	/**
	 * The minimum {@code double} value that is equal to {@code -Double.MAX_VALUE}.
	 */
	public static final double MIN_VALUE = -Double.MAX_VALUE;
	
	/**
	 * The value of {@code Doubles.nextDown(1.0D)}.
	 */
	public static final double NEXT_DOWN_1_1 = nextDown(1.0D);
	
	/**
	 * The value of {@code Doubles.nextDown(Doubles.NEXT_DOWN_1_1)}.
	 */
	public static final double NEXT_DOWN_1_2 = nextDown(NEXT_DOWN_1_1);
	
	/**
	 * The value of {@code Doubles.nextDown(Doubles.NEXT_DOWN_1_2)}.
	 */
	public static final double NEXT_DOWN_1_3 = nextDown(NEXT_DOWN_1_2);
	
	/**
	 * The value of {@code Doubles.nextUp(1.0D)}.
	 */
	public static final double NEXT_UP_1_1 = nextUp(1.0D);
	
	/**
	 * The value of {@code Doubles.nextUp(Doubles.NEXT_UP_1_1)}.
	 */
	public static final double NEXT_UP_1_2 = nextUp(NEXT_UP_1_1);
	
	/**
	 * The value of {@code Doubles.nextUp(Doubles.NEXT_UP_1_2)}.
	 */
	public static final double NEXT_UP_1_3 = nextUp(NEXT_UP_1_2);
	
	/**
	 * The {@code double} value that represents Not-a-Number (NaN).
	 */
	public static final double NaN = Double.NaN;
	
	/**
	 * The {@code double} value that is closer than any other to pi, the ratio of the circumference of a circle to its diameter.
	 */
	public static final double PI = Math.PI;
	
	/**
	 * The {@code double} value that is closer than any other to pi, the ratio of the circumference of a circle to its diameter, divided by 180.0.
	 */
	public static final double PI_DIVIDED_BY_180 = PI / 180.0D;
	
	/**
	 * The {@code double} value that is closer than any other to pi, the ratio of the circumference of a circle to its diameter, divided by 2.0.
	 */
	public static final double PI_DIVIDED_BY_2 = PI / 2.0D;
	
	/**
	 * The {@code double} value that is closer than any other to pi, the ratio of the circumference of a circle to its diameter, divided by 4.0.
	 */
	public static final double PI_DIVIDED_BY_4 = PI / 4.0D;
	
	/**
	 * The {@code double} value that is closer than any other to pi, the ratio of the circumference of a circle to its diameter, multiplied by 2.0.
	 */
	public static final double PI_MULTIPLIED_BY_2 = PI * 2.0D;
	
	/**
	 * The reciprocal (or inverse) of {@link #PI_MULTIPLIED_BY_2}.
	 */
	public static final double PI_MULTIPLIED_BY_2_RECIPROCAL = 1.0D / PI_MULTIPLIED_BY_2;
	
	/**
	 * The {@code double} value that is closer than any other to pi, the ratio of the circumference of a circle to its diameter, multiplied by 4.0.
	 */
	public static final double PI_MULTIPLIED_BY_4 = PI * 4.0D;
	
	/**
	 * The reciprocal (or inverse) of {@link #PI_MULTIPLIED_BY_4}.
	 */
	public static final double PI_MULTIPLIED_BY_4_RECIPROCAL = 1.0D / PI_MULTIPLIED_BY_4;
	
	/**
	 * The reciprocal (or inverse) of {@link #PI}.
	 */
	public static final double PI_RECIPROCAL = 1.0D / PI;
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private Doubles() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Returns {@code true} if, and only if, {@code a} is equal to {@code b}, {@code false} otherwise.
	 * 
	 * @param a a {@code double} value
	 * @param b a {@code double} value
	 * @return {@code true} if, and only if, {@code a} is equal to {@code b}, {@code false} otherwise
	 */
	public static boolean equals(final double a, final double b) {
		return Double.compare(a, b) == 0;
	}
	
	/**
	 * Returns {@code true} if, and only if, {@code a} is equal to {@code b} and {@code b} is equal to {@code c}, {@code false} otherwise.
	 * 
	 * @param a a {@code double} value
	 * @param b a {@code double} value
	 * @param c a {@code double} value
	 * @return {@code true} if, and only if, {@code a} is equal to {@code b} and {@code b} is equal to {@code c}, {@code false} otherwise
	 */
	public static boolean equals(final double a, final double b, final double c) {
		return equals(a, b) && equals(b, c);
	}
	
	/**
	 * Returns {@code true} if, and only if, {@code value} is finite, {@code false} otherwise.
	 * 
	 * @param value a {@code double} value
	 * @return {@code true} if, and only if, {@code value} is finite, {@code false} otherwise
	 */
	public static boolean isFinite(final double value) {
		return !isInfinite(value) && !isNaN(value);
	}
	
	/**
	 * Returns {@code true} if, and only if, {@code value} is infinitely large in magnitude, {@code false} otherwise.
	 * 
	 * @param value a {@code double} value
	 * @return {@code true} if, and only if, {@code value} is infinitely large in magnitude, {@code false} otherwise
	 */
	public static boolean isInfinite(final double value) {
		return Double.isInfinite(value);
	}
	
	/**
	 * Returns {@code true} if, and only if, {@code value} is {@code Double.NaN}, {@code false} otherwise.
	 * 
	 * @param value a {@code double} value
	 * @return {@code true} if, and only if, {@code value} is {@code Double.NaN}, {@code false} otherwise
	 */
	public static boolean isNaN(final double value) {
		return Double.isNaN(value);
	}
	
	/**
	 * Returns {@code true} if, and only if, either {@code Doubles.equals(value, +0.0D)} or {@code Doubles.equals(value, -0.0D)} are {@code true}, {@code false} otherwise.
	 * 
	 * @param value a {@code double} value
	 * @return {@code true} if, and only if, either {@code Doubles.equals(value, +0.0D)} or {@code Doubles.equals(value, -0.0D)} are {@code true}, {@code false} otherwise
	 */
	public static boolean isZero(final double value) {
		return equals(value, +0.0D) || equals(value, -0.0D);
	}
	
	/**
	 * Returns the absolute version of {@code value}.
	 * <p>
	 * If the argument is not negative, the argument is returned. If the argument is negative, the negation of the argument is returned.
	 * <p>
	 * Special cases:
	 * <ul>
	 * <li>If the argument is positive zero or negative zero, the result is positive zero.</li>
	 * <li>If the argument is infinite, the result is positive infinity.</li>
	 * <li>If the argument is NaN, the result is NaN.</li>
	 * </ul>
	 * <p>
	 * In other words, the result is the same as the value of the expression:
	 * <pre>
	 * {@code
	 * Double.longBitsToDouble((Double.doubleToLongBits(value) << 1) >>> 1)
	 * }
	 * </pre>
	 * 
	 * @param value a {@code double} value
	 * @return the absolute version of {@code value}
	 * @see Math#abs(double)
	 */
	public static double abs(final double value) {
		return Math.abs(value);
	}
	
	/**
	 * Returns the arc cosine of {@code value}.
	 * <p>
	 * The returned angle is in the range 0.0 through pi.
	 * <p>
	 * Special case:
	 * <ul>
	 * <li>If the argument is NaN or its absolute value is greater than 1, then the result is NaN.</li>
	 * </ul>
	 * <p>
	 * The computed result must be within 1 ulp of the exact result. Results must be semi-monotonic.
	 * 
	 * @param value the value whose arc cosine is to be returned
	 * @return the arc cosine of {@code value}
	 * @see Math#acos(double)
	 */
	public static double acos(final double value) {
		return Math.acos(value);
	}
	
	/**
	 * Returns {@code value} if, and only if, {@code value >= valueMin}, {@code value + valueAdd} otherwise.
	 * 
	 * @param value the value to check
	 * @param valueMin the minimum value to use
	 * @param valueAdd the value that might be added to {@code value}
	 * @return {@code value} if, and only if, {@code value >= valueMin}, {@code value + valueAdd} otherwise
	 */
	public static double addLessThan(final double value, final double valueMin, final double valueAdd) {
		return value < valueMin ? value + valueAdd : value;
	}
	
	/**
	 * Returns the arc sine of {@code value}.
	 * <p>
	 * The returned angle is in the range -pi / 2 through pi / 2.
	 * <p>
	 * Special cases:
	 * <ul>
	 * <li>If the argument is NaN or its absolute value is greater than 1, then the result is NaN.</li>
	 * <li>If the argument is zero, then the result is a zero with the same sign as the argument.</li>
	 * </ul>
	 * <p>
	 * The computed result must be within 1 ulp of the exact result. Results must be semi-monotonic.
	 * 
	 * @param value the value whose arc sine is to be returned
	 * @return the arc sine of {@code value}
	 * @see Math#asin(double)
	 */
	public static double asin(final double value) {
		return Math.asin(value);
	}
	
	/**
	 * Returns the result of {@code asin(value)} divided by pi.
	 * 
	 * @param value the value whose arc sine divided by pi is to be returned
	 * @return the result of {@code asin(value)} divided by pi
	 * @see #asin(double)
	 */
	public static double asinpi(final double value) {
		return asin(value) / PI;
	}
	
	/**
	 * Returns the arc tangent of {@code value}.
	 * <p>
	 * The returned angle is in the range -pi / 2 through pi / 2.
	 * <p>
	 * Special cases:
	 * <ul>
	 * <li>If the argument is NaN, then the result is NaN.</li>
	 * <li>If the argument is zero, then the result is a zero with the same sign as the argument.</li>
	 * </ul>
	 * <p>
	 * The computed result must be within 1 ulp of the exact result. Results must be semi-monotonic.
	 * 
	 * @param value the value whose arc tangent is to be returned
	 * @return the arc tangent of {@code value}
	 * @see Math#atan(double)
	 */
	public static double atan(final double value) {
		return Math.atan(value);
	}
	
	/**
	 * Returns the angle <i>theta</i> from the conversion of rectangular coordinates (x, y) to polar coordinates (r, <i>theta</i>).
	 * <p>
	 * This method computes the phase <i>theta</i> by computing an arc tangent of y / x in the range of <i>-pi</i> to <i>pi</i>.
	 * <p>
	 * Special cases:
	 * <ul>
	 * <li>If either argument is NaN, then the result is NaN.</li>
	 * <li>If the first argument is positive zero and the second argument is positive, or the first argument is positive and finite and the second argument is positive infinity, then the result is positive zero.</li>
	 * <li>If the first argument is negative zero and the second argument is positive, or the first argument is negative and finite and the second argument is positive infinity, then the result is negative zero.</li>
	 * <li>If the first argument is positive zero and the second argument is negative, or the first argument is positive and finite and the second argument is negative infinity, then the result is the {@code float} value closest to pi.</li>
	 * <li>If the first argument is negative zero and the second argument is negative, or the first argument is negative and finite and the second argument is negative infinity, then the result is the {@code float} value closest to -pi.</li>
	 * <li>If the first argument is positive and the second argument is positive zero or negative zero, or the first argument is positive infinity and the second argument is finite, then the result is the {@code float} value closest to pi / 2.</li>
	 * <li>If the first argument is negative and the second argument is positive zero or negative zero, or the first argument is negative infinity and the second argument is finite, then the result is the {@code float} value closest to -pi / 2.</li>
	 * <li>If both arguments are positive infinity, then the result is the {@code float} value closest to pi / 4.</li>
	 * <li>If the first argument is positive infinity and the second argument is negative infinity, then the result is the {@code float} value closest to 3 * pi / 4.</li>
	 * <li>If the first argument is negative infinity and the second argument is positive infinity, then the result is the {@code float} value closest to -pi / 4.</li>
	 * <li>If both arguments are negative infinity, then the result is the {@code float} value closest to -3 * pi / 4.</li>
	 * </ul>
	 * <p>
	 * The computed result must be within 2 ulps of the exact result. Results must be semi-monotonic.
	 * 
	 * @param y the ordinate coordinate
	 * @param x the abscissa coordinate
	 * @return the angle <i>theta</i> from the conversion of rectangular coordinates (x, y) to polar coordinates (r, <i>theta</i>)
	 * @see Math#atan2(double, double)
	 */
	public static double atan2(final double y, final double x) {
		return Math.atan2(y, x);
	}
	
	/**
	 * Returns the result of {@code atan2(y, x)} divided by (pi * 2).
	 * 
	 * @param y the ordinate coordinate
	 * @param x the abscissa coordinate
	 * @return the result of {@code atan2(y, x)} divided by (pi * 2)
	 * @see #atan2(double, double)
	 */
	public static double atan2pi2(final double y, final double x) {
		return atan2(y, x) / PI_MULTIPLIED_BY_2;
	}
	
	/**
	 * Performs a bilinear interpolation operation on the supplied values.
	 * <p>
	 * Returns the result of the bilinear interpolation operation.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * Doubles.lerp(Doubles.lerp(a, b, tX), Doubles.lerp(c, d, tX), tY);
	 * }
	 * </pre>
	 * 
	 * @param a a {@code double} value
	 * @param b a {@code double} value
	 * @param c a {@code double} value
	 * @param d a {@code double} value
	 * @param tX the X-axis factor
	 * @param tY the Y-axis factor
	 * @return the result of the bilinear interpolation operation
	 * @see #lerp(double, double, double)
	 */
	public static double blerp(final double a, final double b, final double c, final double d, final double tX, final double tY) {
		return lerp(lerp(a, b, tX), lerp(c, d, tX), tY);
	}
	
	/**
	 * Returns the smallest (closest to negative infinity) {@code double} value that is greater than or equal to {@code value} and is equal to a mathematical integer.
	 * <p>
	 * Special cases:
	 * <ul>
	 * <li>If the argument value is already equal to a mathematical integer, then the result is the same as the argument.</li>
	 * <li>If the argument is NaN or an infinity or positive zero or negative zero, then the result is the same as the argument.</li>
	 * <li>If the argument value is less than zero but greater than -1.0, then the result is negative zero.</li>
	 * </ul>
	 * <p>
	 * The computed result must be within 1 ulp of the exact result. Results must be semi-monotonic.
	 * 
	 * @param value a value
	 * @return the smallest (closest to negative infinity) {@code double} value that is greater than or equal to {@code value} and is equal to a mathematical integer
	 * @see Math#ceil(double)
	 */
	public static double ceil(final double value) {
		return Math.ceil(value);
	}
	
	/**
	 * Returns the trigonometric cosine of {@code angleRadians}.
	 * <p>
	 * Special case:
	 * <ul>
	 * <li>If the argument is NaN or an infinity, then the result is NaN.</li>
	 * </ul>
	 * <p>
	 * The computed result must be within 1 ulp of the exact result. Results must be semi-monotonic.
	 * 
	 * @param angleRadians an angle, in radians
	 * @return the trigonometric cosine of {@code angleRadians}
	 * @see Math#cos(double)
	 */
	public static double cos(final double angleRadians) {
		return Math.cos(angleRadians);
	}
	
	/**
	 * Returns the value of the error function for {@code value}.
	 * 
	 * @param value a {@code double} value
	 * @return the value of the error function for {@code value}
	 */
	public static double erf(final double value) {
		final int sign = value < 0.0D ? -1 : +1;
		
		final double a1 = +0.254829592D;
		final double a2 = -0.284496736D;
		final double a3 = +1.421413741D;
		final double a4 = -1.453152027D;
		final double a5 = +1.061405429D;
		
		final double p = 0.3275911D;
		
		final double x = abs(value);
		final double y = 1.0D / (1.0D + p * x);
		final double z = 1.0D - (((((a5 * y + a4) * y) + a3) * y + a2) * y + a1) * y * exp(-x * x);
		
		return sign * z;
	}
	
	/**
	 * Returns the value of the inverse error function for {@code value}.
	 * 
	 * @param value a {@code double} value
	 * @return the value of the inverse error function for {@code value}
	 */
	public static double erfInv(final double value) {
		double p = 0.0D;
		double x = saturate(value, -0.99999D, +0.99999D);
		double y = -log((1.0D - x) * (1.0D + x));
		
		if(y < 5.0D) {
			y = y - 2.5D;
			
			p = +2.81022636e-08D;
			p = +3.43273939e-07D + p * y;
			p = -3.52338770e-06D + p * y;
			p = -4.39150654e-06D + p * y;
			p = +0.000218580870D + p * y;
			p = -0.001253725030D + p * y;
			p = -0.004177681640D + p * y;
			p = +0.246640727000D + p * y;
			p = +1.501409410000D + p * y;
		} else {
			y = sqrt(y) - 3.0D;
			
			p = -0.000200214257D;
			p = +0.000100950558D + p * y;
			p = +0.001349343220D + p * y;
			p = -0.003673428440D + p * y;
			p = +0.005739507730D + p * y;
			p = -0.007622461300D + p * y;
			p = +0.009438870470D + p * y;
			p = +1.001674060000D + p * y;
			p = +2.832976820000D + p * y;
		}
		
		return p * x;
	}
	
	/**
	 * Returns Euler's number {@code e} raised to the power of {@code exponent}.
	 * <p>
	 * Special cases:
	 * <ul>
	 * <li>If the argument is NaN, the result is NaN.</li>
	 * <li>If the argument is positive infinity, then the result is positive infinity.</li>
	 * <li>If the argument is negative infinity, then the result is positive zero.</li>
	 * </ul>
	 * <p>
	 * The computed result must be within 1 ulp of the exact result. Results must be semi-monotonic.
	 * 
	 * @param exponent the exponent to raise {@code e} to
	 * @return Euler's number {@code e} raised to the power of {@code exponent}
	 * @see Math#exp(double)
	 */
	public static double exp(final double exponent) {
		return Math.exp(exponent);
	}
	
	/**
	 * Returns {@code value} if it is finite and {@code defaultValue} otherwise.
	 * 
	 * @param value a {@code double} value
	 * @param defaultValue a {@code double} value
	 * @return {@code value} if it is finite and {@code defaultValue} otherwise
	 */
	public static double finiteOrDefault(final double value, final double defaultValue) {
		if(isInfinite(value)) {
			return defaultValue;
		} else if(isNaN(value)) {
			return defaultValue;
		} else {
			return value;
		}
	}
	
	/**
	 * Returns the largest (closest to positive infinity) {@code double} value that is less than or equal to {@code value} and is equal to a mathematical integer.
	 * <p>
	 * Special cases:
	 * <ul>
	 * <li>If the argument value is already equal to a mathematical integer, then the result is the same as the argument.</li>
	 * <li>If the argument is NaN or an infinity or positive zero or negative zero, then the result is the same as the argument.</li>
	 * </ul>
	 * 
	 * @param value a value
	 * @return the largest (closest to positive infinity) {@code double} value that is less than or equal to {@code value} and is equal to a mathematical integer
	 * @see Math#floor(double)
	 */
	public static double floor(final double value) {
		return Math.floor(value);
	}
	
	/**
	 * Returns the fractional part of {@code value}.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * Doubles.fractionalPart(value, false);
	 * }
	 * </pre>
	 * 
	 * @param value a value
	 * @return the fractional part of {@code value}
	 */
	public static double fractionalPart(final double value) {
		return fractionalPart(value, false);
	}
	
	/**
	 * Returns the fractional part of {@code value}.
	 * <p>
	 * The fractional part of {@code value} is calculated in the following way:
	 * <pre>
	 * {@code
	 * double fractionalPart = value < 0.0D && isUsingCeilOnNegativeValue ? ceil(value) - value : value - floor(value);
	 * }
	 * </pre>
	 * 
	 * @param value a value
	 * @param isUsingCeilOnNegativeValue {@code true} if, and only if, {@code Doubles.ceil(double)} should be used if {@code value} is negative, {@code false} otherwise
	 * @return the fractional part of {@code value}
	 */
	public static double fractionalPart(final double value, final boolean isUsingCeilOnNegativeValue) {
		return value < 0.0D && isUsingCeilOnNegativeValue ? ceil(value) - value : value - floor(value);
	}
	
	/**
	 * Returns the gamma of {@code value}.
	 * 
	 * @param value an {@code int} value
	 * @return the gamma of {@code value}
	 */
	public static double gamma(final int value) {
		return (value * MACHINE_EPSILON) / (1.0D - value * MACHINE_EPSILON);
	}
	
	/**
	 * Performs a linear interpolation operation on the supplied values.
	 * <p>
	 * Returns the result of the linear interpolation operation.
	 * 
	 * @param a a {@code double} value
	 * @param b a {@code double} value
	 * @param t the factor
	 * @return the result of the linear interpolation operation
	 */
	public static double lerp(final double a, final double b, final double t) {
		return (1.0D - t) * a + t * b;
	}
	
	/**
	 * Returns the natural logarithm (base {@code e}) of the {@code double} value {@code value}.
	 * <p>
	 * Special cases:
	 * <ul>
	 * <li>If the argument is NaN or less than zero, then the result is NaN.</li>
	 * <li>If the argument is positive infinity, then the result is positive infinity.</li>
	 * <li>If the argument is positive zero or negative zero, then the result is negative infinity.</li>
	 * </ul>
	 * <p>
	 * The computed result must be within 1 ulp of the exact result. Results must be semi-monotonic.
	 * 
	 * @param value a value
	 * @return the natural logarithm (base {@code e}) of the {@code double} value {@code value}
	 * @see Math#log(double)
	 */
	public static double log(final double value) {
		return Math.log(value);
	}
	
	/**
	 * Returns the greater value of {@code a} and {@code b}.
	 * <p>
	 * The result is the argument closer to positive infinity.
	 * <p>
	 * If the arguments have the same value, the result is that same value. If either value is NaN, then the result is NaN. Unlike the numerical comparison operators, this method considers negative zero to be strictly smaller than positive zero. If one argument is positive zero and the other negative zero, the result is positive zero.
	 * 
	 * @param a a value
	 * @param b a value
	 * @return the greater value of {@code a} and {@code b}
	 * @see Math#max(double, double)
	 */
	public static double max(final double a, final double b) {
		return Math.max(a, b);
	}
	
	/**
	 * Returns the greater value of {@code a}, {@code b} and {@code c}.
	 * <p>
	 * The result is the argument closer to positive infinity.
	 * <p>
	 * If the arguments have the same value, the result is that same value. If either value is NaN, then the result is NaN. Unlike the numerical comparison operators, this method considers negative zero to be strictly smaller than positive zero. If one argument is positive zero and the two others negative zero, the result is positive zero.
	 * 
	 * @param a a value
	 * @param b a value
	 * @param c a value
	 * @return the greater value of {@code a}, {@code b} and {@code c}
	 */
	public static double max(final double a, final double b, final double c) {
		return Math.max(Math.max(a, b), c);
	}
	
	/**
	 * Returns the greater value of {@code a}, {@code b}, {@code c} and {@code d}.
	 * <p>
	 * The result is the argument closer to positive infinity.
	 * <p>
	 * If the arguments have the same value, the result is that same value. If either value is NaN, then the result is NaN. Unlike the numerical comparison operators, this method considers negative zero to be strictly smaller than positive zero. If one argument is positive zero and the two others negative zero, the result is positive zero.
	 * 
	 * @param a a value
	 * @param b a value
	 * @param c a value
	 * @param d a value
	 * @return the greater value of {@code a}, {@code b}, {@code c} and {@code d}
	 */
	public static double max(final double a, final double b, final double c, final double d) {
		return Math.max(Math.max(a, b), Math.max(c, d));
	}
	
	/**
	 * Returns the greater value of {@code a} and {@code b} or {@code defaultValue} if both are NaN.
	 * 
	 * @param a a value
	 * @param b a value
	 * @param defaultValue the default value
	 * @return the greater value of {@code a} and {@code b} or {@code defaultValue} if both are NaN
	 */
	public static double maxOrDefault(final double a, final double b, final double defaultValue) {
		final boolean isNaNA = isNaN(a);
		final boolean isNaNB = isNaN(b);
		
		if(!isNaNA && !isNaNB) {
			return max(a, b);
		} else if(!isNaNA) {
			return a;
		} else if(!isNaNB) {
			return b;
		} else {
			return defaultValue;
		}
	}
	
	/**
	 * Returns the smaller value of {@code a} and {@code b}.
	 * <p>
	 * The result is the value closer to negative infinity.
	 * <p>
	 * If the arguments have the same value, the result is that same value. If either value is NaN, then the result is NaN. Unlike the numerical comparison operators, this method considers negative zero to be strictly smaller than positive zero. If one argument is positive zero and the other is negative zero, the result is negative zero.
	 * 
	 * @param a a value
	 * @param b a value
	 * @return the smaller value of {@code a} and {@code b}
	 * @see Math#min(double, double)
	 */
	public static double min(final double a, final double b) {
		return Math.min(a, b);
	}
	
	/**
	 * Returns the smaller value of {@code a}, {@code b} and {@code c}.
	 * <p>
	 * The result is the value closer to negative infinity.
	 * <p>
	 * If the arguments have the same value, the result is that same value. If either value is NaN, then the result is NaN. Unlike the numerical comparison operators, this method considers negative zero to be strictly smaller than positive zero. If one argument is positive zero and the others negative zero, the result is negative zero.
	 * 
	 * @param a a value
	 * @param b a value
	 * @param c a value
	 * @return the smaller value of {@code a}, {@code b} and {@code c}
	 */
	public static double min(final double a, final double b, final double c) {
		return Math.min(Math.min(a, b), c);
	}
	
	/**
	 * Returns the smaller value of {@code a}, {@code b}, {@code c} and {@code d}.
	 * <p>
	 * The result is the value closer to negative infinity.
	 * <p>
	 * If the arguments have the same value, the result is that same value. If either value is NaN, then the result is NaN. Unlike the numerical comparison operators, this method considers negative zero to be strictly smaller than positive zero. If one argument is positive zero and the others negative zero, the result is negative zero.
	 * 
	 * @param a a value
	 * @param b a value
	 * @param c a value
	 * @param d a value
	 * @return the smaller value of {@code a}, {@code b}, {@code c} and {@code d}
	 */
	public static double min(final double a, final double b, final double c, final double d) {
		return Math.min(Math.min(a, b), Math.min(c, d));
	}
	
	/**
	 * Returns the smaller value of {@code a} and {@code b} or {@code defaultValue} if both are NaN.
	 * 
	 * @param a a value
	 * @param b a value
	 * @param defaultValue the default value
	 * @return the smaller value of {@code a} and {@code b} or {@code defaultValue} if both are NaN
	 */
	public static double minOrDefault(final double a, final double b, final double defaultValue) {
		final boolean isNaNA = isNaN(a);
		final boolean isNaNB = isNaN(b);
		
		if(!isNaNA && !isNaNB) {
			return min(a, b);
		} else if(!isNaNA) {
			return a;
		} else if(!isNaNB) {
			return b;
		} else {
			return defaultValue;
		}
	}
	
	/**
	 * Returns the floating-point value adjacent to {@code value} in the direction of negative infinity.
	 * 
	 * @param value starting floating-point value
	 * @return the floating-point value adjacent to {@code value} in the direction of negative infinity
	 */
	public static double nextDown(final double value) {
		return Math.nextDown(value);
	}
	
	/**
	 * Returns the floating-point value adjacent to {@code value} in the direction of positive infinity.
	 * 
	 * @param value starting floating-point value
	 * @return the floating-point value adjacent to {@code value} in the direction of positive infinity
	 */
	public static double nextUp(final double value) {
		return Math.nextUp(value);
	}
	
	/**
	 * Returns the normalized representation of {@code value}.
	 * <p>
	 * If {@code value} is greater than or equal to {@code min(a, b)} and less than or equal to {@code max(a, b)}, the normalized representation of {@code value} will be between {@code 0.0D} (inclusive) and {@code 1.0D} (inclusive).
	 * 
	 * @param value the {@code double} value to normalize
	 * @param a the {@code double} value that represents the minimum or maximum boundary
	 * @param b the {@code double} value that represents the maximum or minimum boundary
	 * @return the normalized representation of {@code value}
	 */
	public static double normalize(final double value, final double a, final double b) {
		final double maximum = max(a, b);
		final double minimum = min(a, b);
		final double valueNormalized = (value - minimum) / (maximum - minimum);
		
		return valueNormalized;
	}
	
	/**
	 * Performs a modulo operation on {@code x} and {@code y}.
	 * <p>
	 * Returns a {@code double} value.
	 * <p>
	 * The modulo operation performed by this method differs slightly from the modulo operator in Java.
	 * <p>
	 * If {@code x} is positive, the following occurs:
	 * <pre>
	 * {@code
	 * double z = x % y;
	 * }
	 * </pre>
	 * If {@code x} is negative, the following occurs:
	 * <pre>
	 * {@code
	 * double z = (x % y + y) % y;
	 * }
	 * </pre>
	 * 
	 * @param x a {@code double} value
	 * @param y a {@code double} value
	 * @return a {@code double} value
	 */
	public static double positiveModulo(final double x, final double y) {
		return x < 0.0D ? (x % y + y) % y : x % y;
	}
	
	/**
	 * Returns {@code base} raised to the power of {@code exponent}.
	 * <p>
	 * For the full documentation of this method, see {@link Math#pow(double, double)}.
	 * 
	 * @param base the base
	 * @param exponent the exponent
	 * @return {@code base} raised to the power of {@code exponent}
	 * @see Math#pow(double, double)
	 */
	public static double pow(final double base, final double exponent) {
		return Math.pow(base, exponent);
	}
	
	/**
	 * Returns {@code base} raised to the power of {@code 2.0D}.
	 * <p>
	 * This method should be faster than {@link #pow(double, double)}.
	 * 
	 * @param base the base
	 * @return {@code base} raised to the power of {@code 2.0D}
	 */
	public static double pow2(final double base) {
		return base * base;
	}
	
	/**
	 * Returns {@code base} raised to the power of {@code 5.0D}.
	 * <p>
	 * This method should be faster than {@link #pow(double, double)}.
	 * 
	 * @param base the base
	 * @return {@code base} raised to the power of {@code 5.0D}
	 */
	public static double pow5(final double base) {
		return base * base * base * base * base;
	}
	
	/**
	 * Returns {@code base} raised to the power of {@code exponent}.
	 * <p>
	 * This method is recursive and uses a divide and conquer approach.
	 * 
	 * @param base the base
	 * @param exponent the exponent
	 * @return {@code base} raised to the power of {@code exponent}
	 */
	public static double powR(final double base, final int exponent) {
		switch(exponent) {
			case 0:
				return 1.0D;
			case 1:
				return base;
			default:
				final double a = powR(base, exponent / 2);
				final double b = powR(base, exponent & 1);
				
				return a * a * b;
		}
	}
	
	/**
	 * Returns the {@code double} value that is closest in value to the argument and is equal to a mathematical integer.
	 * <p>
	 * If two {@code double} values that are mathematical integers are equally close, the result is the integer value that is even.
	 * 
	 * @param value a {@code double} value
	 * @return the {@code double} value that is closest in value to the argument and is equal to a mathematical integer
	 */
	public static double rint(final double value) {
		return Math.rint(value);
	}
	
	/**
	 * Returns {@code value} or a saturated (or clamped) representation of it.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * Doubles.saturate(value, 0.0D, 1.0D);
	 * }
	 * </pre>
	 * 
	 * @param value the value to saturate (or clamp)
	 * @return {@code value} or a saturated (or clamped) representation of it
	 */
	public static double saturate(final double value) {
		return saturate(value, 0.0D, 1.0D);
	}
	
	/**
	 * Returns {@code value} or a saturated (or clamped) representation of it.
	 * <p>
	 * If {@code value} is less than {@code Doubles.min(valueMinMax, valueMaxMin)}, {@code Doubles.min(valueMinMax, valueMaxMin)} will be returned. If {@code value} is greater than {@code Doubles.max(valueMinMax, valueMaxMin)}, {@code Doubles.max(valueMinMax, valueMaxMin)} will be returned. Otherwise {@code value} will be returned.
	 * 
	 * @param value the value to saturate (or clamp)
	 * @param valueMinMax the minimum or maximum value
	 * @param valueMaxMin the maximum or minimum value
	 * @return {@code value} or a saturated (or clamped) representation of it
	 */
	public static double saturate(final double value, final double valueMinMax, final double valueMaxMin) {
		final double valueMin = min(valueMinMax, valueMaxMin);
		final double valueMax = max(valueMinMax, valueMaxMin);
		
		return max(min(value, valueMax), valueMin);
	}
	
	/**
	 * Returns the trigonometric sine of {@code angleRadians}.
	 * <p>
	 * Special cases:
	 * <ul>
	 * <li>If the argument is NaN or an infinity, then the result is NaN.</li>
	 * <li>If the argument is zero, then the result is a zero with the same sign as the argument.</li>
	 * </ul>
	 * <p>
	 * The computed result must be within 1 ulp of the exact result. Results must be semi-monotonic.
	 * 
	 * @param angleRadians an angle, in radians
	 * @return the trigonometric sine of {@code angleRadians}
	 * @see Math#sin(double)
	 */
	public static double sin(final double angleRadians) {
		return Math.sin(angleRadians);
	}
	
	/**
	 * Returns the hyperbolic sine of a {@code value}.
	 * 
	 * @param value a {@code double} value
	 * @return the hyperbolic sine of a {@code value}
	 */
	public static double sinh(final double value) {
		return Math.sinh(value);
	}
	
	/**
	 * Performs a smoothstep operation on {@code value} and the edges {@code edgeA} and {@code edgeB}.
	 * <p>
	 * Returns a {@code double} value.
	 * 
	 * @param value a {@code double} value
	 * @param edgeA one of the edges
	 * @param edgeB one of the edges
	 * @return a {@code double} value
	 */
	public static double smoothstep(final double value, final double edgeA, final double edgeB) {
		final double x = saturate(normalize(value, edgeA, edgeB));
		final double y = x * x * (3.0D - 2.0D * x);
		
		return y;
	}
	
	/**
	 * Returns the correctly rounded positive square root of {@code value}.
	 * <p>
	 * Special cases:
	 * <ul>
	 * <li>If the argument is NaN or less than zero, then the result is NaN.</li>
	 * <li>If the argument is positive infinity, then the result is positive infinity.</li>
	 * <li>If the argument is positive zero or negative zero, then the result is the same as the argument.</li>
	 * </ul>
	 * <p>
	 * Otherwise, the result is the {@code double} value closest to the true mathematical square root of the argument value.
	 * 
	 * @param value a value
	 * @return the correctly rounded positive square root of {@code value}
	 * @see Math#sqrt(double)
	 */
	public static double sqrt(final double value) {
		return Math.sqrt(value);
	}
	
	/**
	 * Returns the trigonometric tangent of {@code angleRadians}.
	 * <p>
	 * Special cases:
	 * <ul>
	 * <li>If the argument is NaN or an infinity, then the result is NaN.</li>
	 * <li>If the argument is zero, then the result is a zero with the same sign as the argument.</li>
	 * </ul>
	 * <p>
	 * The computed result must be within 1 ulp of the exact result. Results must be semi-monotonic.
	 * 
	 * @param angleRadians an angle, in radians
	 * @return the trigonometric tangent of {@code angleRadians}
	 * @see Math#tan(double)
	 */
	public static double tan(final double angleRadians) {
		return Math.tan(angleRadians);
	}
	
	/**
	 * Returns an approximately equivalent angle measured in degrees from an angle measured in radians.
	 * <p>
	 * The conversion from radians to degrees is generally inexact.
	 * 
	 * @param angleRadians an angle, in radians
	 * @return an approximately equivalent angle measured in degrees from an angle measured in radians
	 * @see Math#toDegrees(double)
	 */
	public static double toDegrees(final double angleRadians) {
		return Math.toDegrees(angleRadians);
	}
	
	/**
	 * Returns an approximately equivalent angle measured in radians from an angle measured in degrees.
	 * <p>
	 * The conversion from degrees to radians is generally inexact.
	 * 
	 * @param angleDegrees an angle, in degrees
	 * @return an approximately equivalent angle measured in radians from an angle measured in degrees
	 * @see Math#toRadians(double)
	 */
	public static double toRadians(final double angleDegrees) {
		return Math.toRadians(angleDegrees);
	}
	
	/**
	 * Attempts to solve the quadratic system based on the values {@code a}, {@code b} and {@code c}.
	 * <p>
	 * Returns a {@code double[]}, with a length of {@code 2}, that contains the result.
	 * <p>
	 * If the quadratic system could not be solved, the result will contain the values {@code Double.NaN}.
	 * 
	 * @param a a value
	 * @param b a value
	 * @param c a value
	 * @return a {@code double[]}, with a length of {@code 2}, that contains the result
	 */
	public static double[] solveQuadraticSystem(final double a, final double b, final double c) {
		final double[] result = new double[] {NaN, NaN};
		
		final double discriminantSquared = b * b - 4.0D * a * c;
		
		if(isZero(discriminantSquared)) {
			final double q = -0.5D * b / a;
			
			final double result0 = q;
			final double result1 = q;
			
			result[0] = result0;
			result[1] = result1;
		} else if(discriminantSquared > 0.0D) {
			final double discriminant = sqrt(discriminantSquared);
			
			final double q = -0.5D * (b > 0.0D ? b + discriminant : b - discriminant);
			
			final double result0 = q / a;
			final double result1 = c / q;
			
			result[0] = min(result0, result1);
			result[1] = max(result0, result1);
		}
		
		return result;
	}
}