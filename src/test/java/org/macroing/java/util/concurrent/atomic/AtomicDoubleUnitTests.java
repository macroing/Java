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
package org.macroing.java.util.concurrent.atomic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.jupiter.api.Test;

@SuppressWarnings("static-method")
public final class AtomicDoubleUnitTests {
	public AtomicDoubleUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@SuppressWarnings("unused")
	@Test
	public void testAccumulateAndGet() {
		final AtomicDouble atomicDouble = new AtomicDouble(10.0D);
		
		assertEquals(10.0D, atomicDouble.get());
		assertEquals(20.0D, atomicDouble.accumulateAndGet(10.0D, (previous, x) -> previous + x));
		assertEquals(20.0D, atomicDouble.get());
		
		assertThrows(NullPointerException.class, () -> atomicDouble.accumulateAndGet(10.0D, null));
		
//		The following code simulates multiple compareAndSet(double, double) operations:
		
		final AtomicBoolean atomicBoolean = new AtomicBoolean();
		
		final double value = atomicDouble.accumulateAndGet(10.0D, (previous, x) -> {
			if(atomicBoolean.compareAndSet(false, true)) {
				final CountDownLatch countDownLatch = new CountDownLatch(1);
				
				final Runnable runnable = () -> {
					atomicDouble.set(10.0D);
					
					countDownLatch.countDown();
				};
				
				final
				Thread thread = new Thread(runnable);
				thread.start();
				
				try {
					countDownLatch.await();
				} catch(final InterruptedException e) {
//					Do nothing.
				}
			}
			
			return previous + x;
		});
		
		assertEquals(20.0D, value);
		assertEquals(20.0D, atomicDouble.get());
	}
	
	@Test
	public void testAddAndGet() {
		final AtomicDouble atomicDouble = new AtomicDouble(10.0D);
		
		assertEquals(10.0D, atomicDouble.get());
		assertEquals(12.0D, atomicDouble.addAndGet(2.0D));
		assertEquals(12.0D, atomicDouble.get());
	}
	
	@Test
	public void testCompareAndSet() {
		final AtomicDouble atomicDouble = new AtomicDouble(10.0D);
		
		assertEquals(10.0D, atomicDouble.get());
		assertFalse(atomicDouble.compareAndSet(20.0D, 30.0D));
		assertEquals(10.0D, atomicDouble.get());
		assertTrue(atomicDouble.compareAndSet(10.0D, 20.0D));
		assertEquals(20.0D, atomicDouble.get());
		assertTrue(atomicDouble.compareAndSet(20.0D, 30.0D));
		assertEquals(30.0D, atomicDouble.get());
		assertFalse(atomicDouble.compareAndSet(10.0D, 20.0D));
		assertEquals(30.0D, atomicDouble.get());
	}
	
	@Test
	public void testConstructor() {
		final AtomicDouble atomicDouble = new AtomicDouble();
		
		assertEquals(0.0D, atomicDouble.get());
	}
	
	@Test
	public void testConstructorDouble() {
		final AtomicDouble atomicDouble = new AtomicDouble(10.0D);
		
		assertEquals(10.0D, atomicDouble.get());
	}
	
	@Test
	public void testDecrementAndGet() {
		final AtomicDouble atomicDouble = new AtomicDouble(10.0D);
		
		assertEquals(10.0D, atomicDouble.get());
		assertEquals( 9.0D, atomicDouble.decrementAndGet());
		assertEquals( 9.0D, atomicDouble.get());
	}
	
	@Test
	public void testDoubleValue() {
		final AtomicDouble atomicDouble = new AtomicDouble(10.0D);
		
		assertEquals(10.0D, atomicDouble.doubleValue());
	}
	
	@Test
	public void testFloatValue() {
		final AtomicDouble atomicDouble = new AtomicDouble(10.0D);
		
		assertEquals(10.0F, atomicDouble.floatValue());
	}
	
	@Test
	public void testGet() {
		final AtomicDouble atomicDouble = new AtomicDouble(10.0D);
		
		assertEquals(10.0D, atomicDouble.get());
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testGetAndAccumulate() {
		final AtomicDouble atomicDouble = new AtomicDouble(10.0D);
		
		assertEquals(10.0D, atomicDouble.get());
		assertEquals(10.0D, atomicDouble.getAndAccumulate(10.0D, (previous, x) -> previous + x));
		assertEquals(20.0D, atomicDouble.get());
		
		assertThrows(NullPointerException.class, () -> atomicDouble.getAndAccumulate(10.0D, null));
		
//		The following code simulates multiple compareAndSet(double, double) operations:
		
		final AtomicBoolean atomicBoolean = new AtomicBoolean();
		
		final double value = atomicDouble.getAndAccumulate(10.0D, (previous, x) -> {
			if(atomicBoolean.compareAndSet(false, true)) {
				final CountDownLatch countDownLatch = new CountDownLatch(1);
				
				final Runnable runnable = () -> {
					atomicDouble.set(10.0D);
					
					countDownLatch.countDown();
				};
				
				final
				Thread thread = new Thread(runnable);
				thread.start();
				
				try {
					countDownLatch.await();
				} catch(final InterruptedException e) {
//					Do nothing.
				}
			}
			
			return previous + x;
		});
		
		assertEquals(10.0D, value);
		assertEquals(20.0D, atomicDouble.get());
	}
	
	@Test
	public void testGetAndAdd() {
		final AtomicDouble atomicDouble = new AtomicDouble(10.0D);
		
		assertEquals(10.0D, atomicDouble.get());
		assertEquals(10.0D, atomicDouble.getAndAdd(2.0D));
		assertEquals(12.0D, atomicDouble.get());
	}
	
	@Test
	public void testGetAndDecrement() {
		final AtomicDouble atomicDouble = new AtomicDouble(10.0D);
		
		assertEquals(10.0D, atomicDouble.get());
		assertEquals(10.0D, atomicDouble.getAndDecrement());
		assertEquals( 9.0D, atomicDouble.get());
	}
	
	@Test
	public void testGetAndIncrement() {
		final AtomicDouble atomicDouble = new AtomicDouble(10.0D);
		
		assertEquals(10.0D, atomicDouble.get());
		assertEquals(10.0D, atomicDouble.getAndIncrement());
		assertEquals(11.0D, atomicDouble.get());
	}
	
	@Test
	public void testGetAndSet() {
		final AtomicDouble atomicDouble = new AtomicDouble(10.0D);
		
		assertEquals(10.0D, atomicDouble.get());
		assertEquals(10.0D, atomicDouble.getAndSet(20.0D));
		assertEquals(20.0D, atomicDouble.get());
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testGetAndUpdate() {
		final AtomicDouble atomicDouble = new AtomicDouble(10.0D);
		
		assertEquals(10.0D, atomicDouble.get());
		assertEquals(10.0D, atomicDouble.getAndUpdate(previous -> 20.0D));
		assertEquals(20.0D, atomicDouble.get());
		
		assertThrows(NullPointerException.class, () -> atomicDouble.getAndUpdate(null));
		
//		The following code simulates multiple compareAndSet(double, double) operations:
		
		final AtomicBoolean atomicBoolean = new AtomicBoolean();
		
		final double value = atomicDouble.getAndUpdate(previous -> {
			if(atomicBoolean.compareAndSet(false, true)) {
				final CountDownLatch countDownLatch = new CountDownLatch(1);
				
				final Runnable runnable = () -> {
					atomicDouble.set(10.0D);
					
					countDownLatch.countDown();
				};
				
				final
				Thread thread = new Thread(runnable);
				thread.start();
				
				try {
					countDownLatch.await();
				} catch(final InterruptedException e) {
//					Do nothing.
				}
			}
			
			return 30.0D;
		});
		
		assertEquals(10.0D, value);
		assertEquals(30.0D, atomicDouble.get());
	}
	
	@Test
	public void testIncrementAndGet() {
		final AtomicDouble atomicDouble = new AtomicDouble(10.0D);
		
		assertEquals(10.0D, atomicDouble.get());
		assertEquals(11.0D, atomicDouble.incrementAndGet());
		assertEquals(11.0D, atomicDouble.get());
	}
	
	@Test
	public void testIntValue() {
		final AtomicDouble atomicDouble = new AtomicDouble(10.0D);
		
		assertEquals(10, atomicDouble.intValue());
	}
	
	@Test
	public void testLazySet() {
		final AtomicDouble atomicDouble = new AtomicDouble(10.0D);
		
		assertEquals(10.0D, atomicDouble.get());
		
		atomicDouble.lazySet(20.0D);
		
		assertEquals(20.0D, atomicDouble.get());
	}
	
	@Test
	public void testLongValue() {
		final AtomicDouble atomicDouble = new AtomicDouble(10.0D);
		
		assertEquals(10L, atomicDouble.longValue());
	}
	
	@Test
	public void testSet() {
		final AtomicDouble atomicDouble = new AtomicDouble(10.0D);
		
		assertEquals(10.0D, atomicDouble.get());
		
		atomicDouble.set(20.0D);
		
		assertEquals(20.0D, atomicDouble.get());
	}
	
	@Test
	public void testToString() {
		final AtomicDouble atomicDouble = new AtomicDouble(10.0D);
		
		assertEquals(Double.toString(10.0D), atomicDouble.toString());
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testUpdateAndGet() {
		final AtomicDouble atomicDouble = new AtomicDouble(10.0D);
		
		assertEquals(10.0D, atomicDouble.get());
		assertEquals(20.0D, atomicDouble.updateAndGet(previous -> 20.0D));
		assertEquals(20.0D, atomicDouble.get());
		
		assertThrows(NullPointerException.class, () -> atomicDouble.updateAndGet(null));
		
//		The following code simulates multiple compareAndSet(double, double) operations:
		
		final AtomicBoolean atomicBoolean = new AtomicBoolean();
		
		final double value = atomicDouble.updateAndGet(previous -> {
			if(atomicBoolean.compareAndSet(false, true)) {
				final CountDownLatch countDownLatch = new CountDownLatch(1);
				
				final Runnable runnable = () -> {
					atomicDouble.set(10.0D);
					
					countDownLatch.countDown();
				};
				
				final
				Thread thread = new Thread(runnable);
				thread.start();
				
				try {
					countDownLatch.await();
				} catch(final InterruptedException e) {
//					Do nothing.
				}
			}
			
			return 30.0D;
		});
		
		assertEquals(30.0D, value);
		assertEquals(30.0D, atomicDouble.get());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testWeakCompareAndSet() {
		final AtomicDouble atomicDouble = new AtomicDouble(10.0D);
		
		assertEquals(10.0D, atomicDouble.get());
		assertFalse(atomicDouble.weakCompareAndSet(20.0D, 30.0D));
		assertEquals(10.0D, atomicDouble.get());
		assertTrue(atomicDouble.weakCompareAndSet(10.0D, 20.0D));
		assertEquals(20.0D, atomicDouble.get());
		assertTrue(atomicDouble.weakCompareAndSet(20.0D, 30.0D));
		assertEquals(30.0D, atomicDouble.get());
		assertFalse(atomicDouble.weakCompareAndSet(10.0D, 20.0D));
		assertEquals(30.0D, atomicDouble.get());
	}
}