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
 * The class {@code Floats} contains methods for performing operations on {@code float} values.
 * <p>
 * You can think of this class as an extension to both {@code Float} and {@code Math}. It does what {@code Math} does for the {@code double}, {@code float} and {@code int} types, but for the {@code float} type only. In addition to this it also adds new methods.
 * <p>
 * This class does not contain all methods from {@code Math}. The methods in {@code Math} that deals with the {@code double} type can be found in the class {@link Doubles}. The methods in {@code Math} that deals with the {@code int} type can be found in the class {@link Ints}.
 * <p>
 * The documentation in this class should be comprehensive. But some of the details covered in the documentation of the {@code Float} or {@code Math} classes may be missing. To get the full documentation for a particular method, you may want to look at the documentation of the corresponding method in the {@code Float} or {@code Math} class. This is, of course, only true if the method you're looking at exists in the {@code Float} or {@code Math} class.
 * <p>
 * Not all methods in the {@code Float} and {@code Math} classes that should be added to this class, may have been added yet.
 * 
 * @since 1.0.0
 * @author J&#246;rgen Lundgren
 */
public final class Floats {
	/**
	 * The {@code float} value that represents a machine epsilon.
	 */
	public static final float MACHINE_EPSILON = Math.ulp(1.0F) * 0.5F;
	
	/**
	 * The maximum {@code float} value that is equal to {@code +Float.MAX_VALUE}.
	 */
	public static final float MAX_VALUE = +Float.MAX_VALUE;
	
	/**
	 * The minimum {@code float} value that is equal to {@code -Float.MAX_VALUE}.
	 */
	public static final float MIN_VALUE = -Float.MAX_VALUE;
	
	/**
	 * The value of {@code Floats.nextDown(1.0F)}.
	 */
	public static final float NEXT_DOWN_1_1 = nextDown(1.0F);
	
	/**
	 * The value of {@code Floats.nextDown(Floats.NEXT_DOWN_1_1)}.
	 */
	public static final float NEXT_DOWN_1_2 = nextDown(NEXT_DOWN_1_1);
	
	/**
	 * The value of {@code Floats.nextDown(Floats.NEXT_DOWN_1_2)}.
	 */
	public static final float NEXT_DOWN_1_3 = nextDown(NEXT_DOWN_1_2);
	
	/**
	 * The value of {@code Floats.nextUp(1.0F)}.
	 */
	public static final float NEXT_UP_1_1 = nextUp(1.0F);
	
	/**
	 * The value of {@code Floats.nextUp(Floats.NEXT_UP_1_1)}.
	 */
	public static final float NEXT_UP_1_2 = nextUp(NEXT_UP_1_1);
	
	/**
	 * The value of {@code Floats.nextUp(Floats.NEXT_UP_1_2)}.
	 */
	public static final float NEXT_UP_1_3 = nextUp(NEXT_UP_1_2);
	
	/**
	 * The {@code float} value that represents Not-a-Number (NaN).
	 */
	public static final float NaN = Float.NaN;
	
	/**
	 * The {@code float} value that is closer than any other to pi, the ratio of the circumference of a circle to its diameter.
	 */
	public static final float PI = (float)(Math.PI);
	
	/**
	 * The {@code float} value that is closer than any other to pi, the ratio of the circumference of a circle to its diameter, divided by 180.0.
	 */
	public static final float PI_DIVIDED_BY_180 = PI / 180.0F;
	
	/**
	 * The {@code float} value that is closer than any other to pi, the ratio of the circumference of a circle to its diameter, divided by 2.0.
	 */
	public static final float PI_DIVIDED_BY_2 = PI / 2.0F;
	
	/**
	 * The {@code float} value that is closer than any other to pi, the ratio of the circumference of a circle to its diameter, divided by 4.0.
	 */
	public static final float PI_DIVIDED_BY_4 = PI / 4.0F;
	
	/**
	 * The {@code float} value that is closer than any other to pi, the ratio of the circumference of a circle to its diameter, multiplied by 2.0.
	 */
	public static final float PI_MULTIPLIED_BY_2 = PI * 2.0F;
	
	/**
	 * The reciprocal (or inverse) of {@link #PI_MULTIPLIED_BY_2}.
	 */
	public static final float PI_MULTIPLIED_BY_2_RECIPROCAL = 1.0F / PI_MULTIPLIED_BY_2;
	
	/**
	 * The {@code float} value that is closer than any other to pi, the ratio of the circumference of a circle to its diameter, multiplied by 4.0.
	 */
	public static final float PI_MULTIPLIED_BY_4 = PI * 4.0F;
	
	/**
	 * The reciprocal (or inverse) of {@link #PI_MULTIPLIED_BY_4}.
	 */
	public static final float PI_MULTIPLIED_BY_4_RECIPROCAL = 1.0F / PI_MULTIPLIED_BY_4;
	
	/**
	 * The reciprocal (or inverse) of {@link #PI}.
	 */
	public static final float PI_RECIPROCAL = 1.0F / PI;
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private Floats() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Returns {@code true} if, and only if, {@code a} is equal to {@code b}, {@code false} otherwise.
	 * 
	 * @param a a {@code float} value
	 * @param b a {@code float} value
	 * @return {@code true} if, and only if, {@code a} is equal to {@code b}, {@code false} otherwise
	 */
	public static boolean equals(final float a, final float b) {
		return Float.compare(a, b) == 0;
	}
	
	/**
	 * Returns {@code true} if, and only if, {@code a} is equal to {@code b} and {@code b} is equal to {@code c}, {@code false} otherwise.
	 * 
	 * @param a a {@code float} value
	 * @param b a {@code float} value
	 * @param c a {@code float} value
	 * @return {@code true} if, and only if, {@code a} is equal to {@code b} and {@code b} is equal to {@code c}, {@code false} otherwise
	 */
	public static boolean equals(final float a, final float b, final float c) {
		return equals(a, b) && equals(b, c);
	}
	
	/**
	 * Returns {@code true} if, and only if, {@code value} is finite, {@code false} otherwise.
	 * 
	 * @param value a {@code float} value
	 * @return {@code true} if, and only if, {@code value} is finite, {@code false} otherwise
	 */
	public static boolean isFinite(final float value) {
		return !isInfinite(value) && !isNaN(value);
	}
	
	/**
	 * Returns {@code true} if, and only if, {@code value} is infinitely large in magnitude, {@code false} otherwise.
	 * 
	 * @param value a {@code float} value
	 * @return {@code true} if, and only if, {@code value} is infinitely large in magnitude, {@code false} otherwise
	 */
	public static boolean isInfinite(final float value) {
		return Float.isInfinite(value);
	}
	
	/**
	 * Returns {@code true} if, and only if, {@code value} is {@code Float.NaN}, {@code false} otherwise.
	 * 
	 * @param value a {@code float} value
	 * @return {@code true} if, and only if, {@code value} is {@code Float.NaN}, {@code false} otherwise
	 */
	public static boolean isNaN(final float value) {
		return Float.isNaN(value);
	}
	
	/**
	 * Returns {@code true} if, and only if, either {@code Floats.equals(value, +0.0F)} or {@code Floats.equals(value, -0.0F)} are {@code true}, {@code false} otherwise.
	 * 
	 * @param value a {@code float} value
	 * @return {@code true} if, and only if, either {@code Floats.equals(value, +0.0F)} or {@code Floats.equals(value, -0.0F)} are {@code true}, {@code false} otherwise
	 */
	public static boolean isZero(final float value) {
		return equals(value, +0.0F) || equals(value, -0.0F);
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
	 * Float.intBitsToFloat(0x7fffffff & Float.floatToIntBits(value))
	 * }
	 * </pre>
	 * 
	 * @param value a {@code float} value
	 * @return the absolute version of {@code value}
	 * @see Math#abs(float)
	 */
	public static float abs(final float value) {
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
	public static float acos(final float value) {
		return (float)(Math.acos(value));
	}
	
	/**
	 * Returns {@code value} if, and only if, {@code value >= valueMin}, {@code value + valueAdd} otherwise.
	 * 
	 * @param value the value to check
	 * @param valueMin the minimum value to use
	 * @param valueAdd the value that might be added to {@code value}
	 * @return {@code value} if, and only if, {@code value >= valueMin}, {@code value + valueAdd} otherwise
	 */
	public static float addLessThan(final float value, final float valueMin, final float valueAdd) {
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
	public static float asin(final float value) {
		return (float)(Math.asin(value));
	}
	
	/**
	 * Returns the result of {@code asin(value)} divided by pi.
	 * 
	 * @param value the value whose arc sine divided by pi is to be returned
	 * @return the result of {@code asin(value)} divided by pi
	 * @see #asin(float)
	 */
	public static float asinpi(final float value) {
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
	public static float atan(final float value) {
		return (float)(Math.atan(value));
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
	public static float atan2(final float y, final float x) {
		return (float)(Math.atan2(y, x));
	}
	
	/**
	 * Returns the result of {@code atan2(y, x)} divided by (pi * 2).
	 * 
	 * @param y the ordinate coordinate
	 * @param x the abscissa coordinate
	 * @return the result of {@code atan2(y, x)} divided by (pi * 2)
	 * @see #atan2(float, float)
	 */
	public static float atan2pi2(final float y, final float x) {
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
	 * Floats.lerp(Floats.lerp(a, b, tX), Floats.lerp(c, d, tX), tY);
	 * }
	 * </pre>
	 * 
	 * @param a a {@code float} value
	 * @param b a {@code float} value
	 * @param c a {@code float} value
	 * @param d a {@code float} value
	 * @param tX the X-axis factor
	 * @param tY the Y-axis factor
	 * @return the result of the bilinear interpolation operation
	 * @see #lerp(float, float, float)
	 */
	public static float blerp(final float a, final float b, final float c, final float d, final float tX, final float tY) {
		return lerp(lerp(a, b, tX), lerp(c, d, tX), tY);
	}
	
	/**
	 * Returns the smallest (closest to negative infinity) {@code float} value that is greater than or equal to {@code value} and is equal to a mathematical integer.
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
	 * @return the smallest (closest to negative infinity) {@code float} value that is greater than or equal to {@code value} and is equal to a mathematical integer
	 * @see Math#ceil(double)
	 */
	public static float ceil(final float value) {
		return (float)(Math.ceil(value));
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
	public static float cos(final float angleRadians) {
		return (float)(Math.cos(angleRadians));
	}
	
	/**
	 * Returns the value of the error function for {@code value}.
	 * 
	 * @param value a {@code float} value
	 * @return the value of the error function for {@code value}
	 */
	public static float erf(final float value) {
		final int sign = value < 0.0F ? -1 : +1;
		
		final float a1 = +0.254829592F;
		final float a2 = -0.284496736F;
		final float a3 = +1.421413741F;
		final float a4 = -1.453152027F;
		final float a5 = +1.061405429F;
		
		final float p = 0.3275911F;
		
		final float x = abs(value);
		final float y = 1.0F / (1.0F + p * x);
		final float z = 1.0F - (((((a5 * y + a4) * y) + a3) * y + a2) * y + a1) * y * exp(-x * x);
		
		return sign * z;
	}
	
	/**
	 * Returns the value of the inverse error function for {@code value}.
	 * 
	 * @param value a {@code float} value
	 * @return the value of the inverse error function for {@code value}
	 */
	public static float erfInv(final float value) {
		float p = 0.0F;
		float x = saturate(value, -0.99999F, +0.99999F);
		float y = -log((1.0F - x) * (1.0F + x));
		
		if(y < 5.0F) {
			y = y - 2.5F;
			
			p = +2.81022636E-08F;
			p = +3.43273939E-07F + p * y;
			p = -3.52338770E-06F + p * y;
			p = -4.39150654E-06F + p * y;
			p = +0.000218580870F + p * y;
			p = -0.001253725030F + p * y;
			p = -0.004177681640F + p * y;
			p = +0.246640727000F + p * y;
			p = +1.501409410000F + p * y;
		} else {
			y = sqrt(y) - 3.0F;
			
			p = -0.000200214257F;
			p = +0.000100950558F + p * y;
			p = +0.001349343220F + p * y;
			p = -0.003673428440F + p * y;
			p = +0.005739507730F + p * y;
			p = -0.007622461300F + p * y;
			p = +0.009438870470F + p * y;
			p = +1.001674060000F + p * y;
			p = +2.832976820000F + p * y;
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
	public static float exp(final float exponent) {
		return (float)(Math.exp(exponent));
	}
	
	/**
	 * Returns {@code value} if it is finite and {@code defaultValue} otherwise.
	 * 
	 * @param value a {@code float} value
	 * @param defaultValue a {@code float} value
	 * @return {@code value} if it is finite and {@code defaultValue} otherwise
	 */
	public static float finiteOrDefault(final float value, final float defaultValue) {
		if(isInfinite(value)) {
			return defaultValue;
		} else if(isNaN(value)) {
			return defaultValue;
		} else {
			return value;
		}
	}
	
	/**
	 * Returns the largest (closest to positive infinity) {@code float} value that is less than or equal to {@code value} and is equal to a mathematical integer.
	 * <p>
	 * Special cases:
	 * <ul>
	 * <li>If the argument value is already equal to a mathematical integer, then the result is the same as the argument.</li>
	 * <li>If the argument is NaN or an infinity or positive zero or negative zero, then the result is the same as the argument.</li>
	 * </ul>
	 * 
	 * @param value a value
	 * @return the largest (closest to positive infinity) {@code float} value that is less than or equal to {@code value} and is equal to a mathematical integer
	 * @see Math#floor(double)
	 */
	public static float floor(final float value) {
		return (float)(Math.floor(value));
	}
	
	/**
	 * Returns the fractional part of {@code value}.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * Floats.fractionalPart(value, false);
	 * }
	 * </pre>
	 * 
	 * @param value a value
	 * @return the fractional part of {@code value}
	 */
	public static float fractionalPart(final float value) {
		return fractionalPart(value, false);
	}
	
	/**
	 * Returns the fractional part of {@code value}.
	 * <p>
	 * The fractional part of {@code value} is calculated in the following way:
	 * <pre>
	 * {@code
	 * float fractionalPart = value < 0.0F && isUsingCeilOnNegativeValue ? ceil(value) - value : value - floor(value);
	 * }
	 * </pre>
	 * 
	 * @param value a value
	 * @param isUsingCeilOnNegativeValue {@code true} if, and only if, {@code Floats.ceil(float)} should be used if {@code value} is negative, {@code false} otherwise
	 * @return the fractional part of {@code value}
	 */
	public static float fractionalPart(final float value, final boolean isUsingCeilOnNegativeValue) {
		return value < 0.0F && isUsingCeilOnNegativeValue ? ceil(value) - value : value - floor(value);
	}
	
	/**
	 * Returns the gamma of {@code value}.
	 * 
	 * @param value an {@code int} value
	 * @return the gamma of {@code value}
	 */
	public static float gamma(final int value) {
		return (value * MACHINE_EPSILON) / (1.0F - value * MACHINE_EPSILON);
	}
	
	/**
	 * Performs a linear interpolation operation on the supplied values.
	 * <p>
	 * Returns the result of the linear interpolation operation.
	 * 
	 * @param a a {@code float} value
	 * @param b a {@code float} value
	 * @param t the factor
	 * @return the result of the linear interpolation operation
	 */
	public static float lerp(final float a, final float b, final float t) {
		return (1.0F - t) * a + t * b;
	}
	
	/**
	 * Returns the natural logarithm (base {@code e}) of the {@code float} value {@code value}.
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
	 * @return the natural logarithm (base {@code e}) of the {@code float} value {@code value}
	 * @see Math#log(double)
	 */
	public static float log(final float value) {
		return (float)(Math.log(value));
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
	 * @see Math#max(float, float)
	 */
	public static float max(final float a, final float b) {
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
	public static float max(final float a, final float b, final float c) {
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
	public static float max(final float a, final float b, final float c, final float d) {
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
	public static float maxOrDefault(final float a, final float b, final float defaultValue) {
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
	 * @see Math#min(float, float)
	 */
	public static float min(final float a, final float b) {
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
	public static float min(final float a, final float b, final float c) {
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
	public static float min(final float a, final float b, final float c, final float d) {
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
	public static float minOrDefault(final float a, final float b, final float defaultValue) {
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
	public static float nextDown(final float value) {
		return Math.nextDown(value);
	}
	
	/**
	 * Returns the floating-point value adjacent to {@code value} in the direction of positive infinity.
	 * 
	 * @param value starting floating-point value
	 * @return the floating-point value adjacent to {@code value} in the direction of positive infinity
	 */
	public static float nextUp(final float value) {
		return Math.nextUp(value);
	}
	
	/**
	 * Returns the normalized representation of {@code value}.
	 * <p>
	 * If {@code value} is greater than or equal to {@code min(a, b)} and less than or equal to {@code max(a, b)}, the normalized representation of {@code value} will be between {@code 0.0F} (inclusive) and {@code 1.0F} (inclusive).
	 * 
	 * @param value the {@code float} value to normalize
	 * @param a the {@code float} value that represents the minimum or maximum boundary
	 * @param b the {@code float} value that represents the maximum or minimum boundary
	 * @return the normalized representation of {@code value}
	 */
	public static float normalize(final float value, final float a, final float b) {
		final float maximum = max(a, b);
		final float minimum = min(a, b);
		final float valueNormalized = (value - minimum) / (maximum - minimum);
		
		return valueNormalized;
	}
	
	/**
	 * Performs a modulo operation on {@code x} and {@code y}.
	 * <p>
	 * Returns a {@code float} value.
	 * <p>
	 * The modulo operation performed by this method differs slightly from the modulo operator in Java.
	 * <p>
	 * If {@code x} is positive, the following occurs:
	 * <pre>
	 * {@code
	 * float z = x % y;
	 * }
	 * </pre>
	 * If {@code x} is negative, the following occurs:
	 * <pre>
	 * {@code
	 * float z = (x % y + y) % y;
	 * }
	 * </pre>
	 * 
	 * @param x a {@code float} value
	 * @param y a {@code float} value
	 * @return a {@code float} value
	 */
	public static float positiveModulo(final float x, final float y) {
		return x < 0.0F ? (x % y + y) % y : x % y;
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
	public static float pow(final float base, final float exponent) {
		return (float)(Math.pow(base, exponent));
	}
	
	/**
	 * Returns {@code base} raised to the power of {@code 2.0F}.
	 * <p>
	 * This method should be faster than {@link #pow(float, float)}.
	 * 
	 * @param base the base
	 * @return {@code base} raised to the power of {@code 2.0F}
	 */
	public static float pow2(final float base) {
		return base * base;
	}
	
	/**
	 * Returns {@code base} raised to the power of {@code 5.0F}.
	 * <p>
	 * This method should be faster than {@link #pow(float, float)}.
	 * 
	 * @param base the base
	 * @return {@code base} raised to the power of {@code 5.0F}
	 */
	public static float pow5(final float base) {
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
	public static float powR(final float base, final int exponent) {
		switch(exponent) {
			case 0:
				return 1.0F;
			case 1:
				return base;
			default:
				final float a = powR(base, exponent / 2);
				final float b = powR(base, exponent & 1);
				
				return a * a * b;
		}
	}
	
	/**
	 * Returns the {@code float} value that is closest in value to the argument and is equal to a mathematical integer.
	 * <p>
	 * If two {@code float} values that are mathematical integers are equally close, the result is the integer value that is even.
	 * 
	 * @param value a {@code float} value
	 * @return the {@code float} value that is closest in value to the argument and is equal to a mathematical integer
	 */
	public static float rint(final float value) {
		return (float)(Math.rint(value));
	}
	
	/**
	 * Returns {@code value} or a saturated (or clamped) representation of it.
	 * <p>
	 * Calling this method is equivalent to the following:
	 * <pre>
	 * {@code
	 * Floats.saturate(value, 0.0F, 1.0F);
	 * }
	 * </pre>
	 * 
	 * @param value the value to saturate (or clamp)
	 * @return {@code value} or a saturated (or clamped) representation of it
	 */
	public static float saturate(final float value) {
		return saturate(value, 0.0F, 1.0F);
	}
	
	/**
	 * Returns {@code value} or a saturated (or clamped) representation of it.
	 * <p>
	 * If {@code value} is less than {@code Floats.min(valueMinMax, valueMaxMin)}, {@code Floats.min(valueMinMax, valueMaxMin)} will be returned. If {@code value} is greater than {@code Floats.max(valueMinMax, valueMaxMin)}, {@code Floats.max(valueMinMax, valueMaxMin)} will be returned. Otherwise {@code value} will be returned.
	 * 
	 * @param value the value to saturate (or clamp)
	 * @param valueMinMax the minimum or maximum value
	 * @param valueMaxMin the maximum or minimum value
	 * @return {@code value} or a saturated (or clamped) representation of it
	 */
	public static float saturate(final float value, final float valueMinMax, final float valueMaxMin) {
		final float valueMin = min(valueMinMax, valueMaxMin);
		final float valueMax = max(valueMinMax, valueMaxMin);
		
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
	public static float sin(final float angleRadians) {
		return (float)(Math.sin(angleRadians));
	}
	
	/**
	 * Returns the hyperbolic sine of a {@code value}.
	 * 
	 * @param value a {@code float} value
	 * @return the hyperbolic sine of a {@code value}
	 */
	public static float sinh(final float value) {
		return (float)(Math.sinh(value));
	}
	
	/**
	 * Performs a smoothstep operation on {@code value} and the edges {@code edgeA} and {@code edgeB}.
	 * <p>
	 * Returns a {@code float} value.
	 * 
	 * @param value a {@code float} value
	 * @param edgeA one of the edges
	 * @param edgeB one of the edges
	 * @return a {@code float} value
	 */
	public static float smoothstep(final float value, final float edgeA, final float edgeB) {
		final float x = saturate(normalize(value, edgeA, edgeB));
		final float y = x * x * (3.0F - 2.0F * x);
		
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
	 * Otherwise, the result is the {@code float} value closest to the true mathematical square root of the argument value.
	 * 
	 * @param value a value
	 * @return the correctly rounded positive square root of {@code value}
	 * @see Math#sqrt(double)
	 */
	public static float sqrt(final float value) {
		return (float)(Math.sqrt(value));
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
	public static float tan(final float angleRadians) {
		return (float)(Math.tan(angleRadians));
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
	public static float toDegrees(final float angleRadians) {
		return (float)(Math.toDegrees(angleRadians));
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
	public static float toRadians(final float angleDegrees) {
		return (float)(Math.toRadians(angleDegrees));
	}
	
	/**
	 * Attempts to solve the quadratic system based on the values {@code a}, {@code b} and {@code c}.
	 * <p>
	 * Returns a {@code float[]}, with a length of {@code 2}, that contains the result.
	 * <p>
	 * If the quadratic system could not be solved, the result will contain the values {@code Float.NaN}.
	 * 
	 * @param a a value
	 * @param b a value
	 * @param c a value
	 * @return a {@code float[]}, with a length of {@code 2}, that contains the result
	 */
	public static float[] solveQuadraticSystem(final float a, final float b, final float c) {
		final float[] result = new float[] {NaN, NaN};
		
		final float discriminantSquared = b * b - 4.0F * a * c;
		
		if(isZero(discriminantSquared)) {
			final float q = -0.5F * b / a;
			
			final float result0 = q;
			final float result1 = q;
			
			result[0] = result0;
			result[1] = result1;
		} else if(discriminantSquared > 0.0F) {
			final float discriminant = sqrt(discriminantSquared);
			
			final float q = -0.5F * (b > 0.0F ? b + discriminant : b - discriminant);
			
			final float result0 = q / a;
			final float result1 = c / q;
			
			result[0] = min(result0, result1);
			result[1] = max(result0, result1);
		}
		
		return result;
	}
}