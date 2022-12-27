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
public final class AtomicFloatUnitTests {
	public AtomicFloatUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@SuppressWarnings("unused")
	@Test
	public void testAccumulateAndGet() {
		final AtomicFloat atomicFloat = new AtomicFloat(10.0F);
		
		assertEquals(10.0F, atomicFloat.get());
		assertEquals(20.0F, atomicFloat.accumulateAndGet(10.0F, (previous, x) -> previous + x));
		assertEquals(20.0F, atomicFloat.get());
		
		assertThrows(NullPointerException.class, () -> atomicFloat.accumulateAndGet(10.0F, null));
		
//		The following code simulates multiple compareAndSet(float, float) operations:
		
		final AtomicBoolean atomicBoolean = new AtomicBoolean();
		
		final float value = atomicFloat.accumulateAndGet(10.0F, (previous, x) -> {
			if(atomicBoolean.compareAndSet(false, true)) {
				final CountDownLatch countDownLatch = new CountDownLatch(1);
				
				final Runnable runnable = () -> {
					atomicFloat.set(10.0F);
					
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
		
		assertEquals(20.0F, value);
		assertEquals(20.0F, atomicFloat.get());
	}
	
	@Test
	public void testAddAndGet() {
		final AtomicFloat atomicFloat = new AtomicFloat(10.0F);
		
		assertEquals(10.0F, atomicFloat.get());
		assertEquals(12.0F, atomicFloat.addAndGet(2.0F));
		assertEquals(12.0F, atomicFloat.get());
	}
	
	@Test
	public void testCompareAndSet() {
		final AtomicFloat atomicFloat = new AtomicFloat(10.0F);
		
		assertEquals(10.0F, atomicFloat.get());
		assertFalse(atomicFloat.compareAndSet(20.0F, 30.0F));
		assertEquals(10.0F, atomicFloat.get());
		assertTrue(atomicFloat.compareAndSet(10.0F, 20.0F));
		assertEquals(20.0F, atomicFloat.get());
		assertTrue(atomicFloat.compareAndSet(20.0F, 30.0F));
		assertEquals(30.0F, atomicFloat.get());
		assertFalse(atomicFloat.compareAndSet(10.0F, 20.0F));
		assertEquals(30.0F, atomicFloat.get());
	}
	
	@Test
	public void testConstructor() {
		final AtomicFloat atomicFloat = new AtomicFloat();
		
		assertEquals(0.0F, atomicFloat.get());
	}
	
	@Test
	public void testConstructorFloat() {
		final AtomicFloat atomicFloat = new AtomicFloat(10.0F);
		
		assertEquals(10.0F, atomicFloat.get());
	}
	
	@Test
	public void testDecrementAndGet() {
		final AtomicFloat atomicFloat = new AtomicFloat(10.0F);
		
		assertEquals(10.0F, atomicFloat.get());
		assertEquals( 9.0F, atomicFloat.decrementAndGet());
		assertEquals( 9.0F, atomicFloat.get());
	}
	
	@Test
	public void testDoubleValue() {
		final AtomicFloat atomicFloat = new AtomicFloat(10.0F);
		
		assertEquals(10.0D, atomicFloat.doubleValue());
	}
	
	@Test
	public void testFloatValue() {
		final AtomicFloat atomicFloat = new AtomicFloat(10.0F);
		
		assertEquals(10.0F, atomicFloat.floatValue());
	}
	
	@Test
	public void testGet() {
		final AtomicFloat atomicFloat = new AtomicFloat(10.0F);
		
		assertEquals(10.0F, atomicFloat.get());
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testGetAndAccumulate() {
		final AtomicFloat atomicFloat = new AtomicFloat(10.0F);
		
		assertEquals(10.0F, atomicFloat.get());
		assertEquals(10.0F, atomicFloat.getAndAccumulate(10.0F, (previous, x) -> previous + x));
		assertEquals(20.0F, atomicFloat.get());
		
		assertThrows(NullPointerException.class, () -> atomicFloat.getAndAccumulate(10.0F, null));
		
//		The following code simulates multiple compareAndSet(float, float) operations:
		
		final AtomicBoolean atomicBoolean = new AtomicBoolean();
		
		final float value = atomicFloat.getAndAccumulate(10.0F, (previous, x) -> {
			if(atomicBoolean.compareAndSet(false, true)) {
				final CountDownLatch countDownLatch = new CountDownLatch(1);
				
				final Runnable runnable = () -> {
					atomicFloat.set(10.0F);
					
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
		
		assertEquals(10.0F, value);
		assertEquals(20.0F, atomicFloat.get());
	}
	
	@Test
	public void testGetAndAdd() {
		final AtomicFloat atomicFloat = new AtomicFloat(10.0F);
		
		assertEquals(10.0F, atomicFloat.get());
		assertEquals(10.0F, atomicFloat.getAndAdd(2.0F));
		assertEquals(12.0F, atomicFloat.get());
	}
	
	@Test
	public void testGetAndDecrement() {
		final AtomicFloat atomicFloat = new AtomicFloat(10.0F);
		
		assertEquals(10.0F, atomicFloat.get());
		assertEquals(10.0F, atomicFloat.getAndDecrement());
		assertEquals( 9.0F, atomicFloat.get());
	}
	
	@Test
	public void testGetAndIncrement() {
		final AtomicFloat atomicFloat = new AtomicFloat(10.0F);
		
		assertEquals(10.0F, atomicFloat.get());
		assertEquals(10.0F, atomicFloat.getAndIncrement());
		assertEquals(11.0F, atomicFloat.get());
	}
	
	@Test
	public void testGetAndSet() {
		final AtomicFloat atomicFloat = new AtomicFloat(10.0F);
		
		assertEquals(10.0F, atomicFloat.get());
		assertEquals(10.0F, atomicFloat.getAndSet(20.0F));
		assertEquals(20.0F, atomicFloat.get());
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testGetAndUpdate() {
		final AtomicFloat atomicFloat = new AtomicFloat(10.0F);
		
		assertEquals(10.0F, atomicFloat.get());
		assertEquals(10.0F, atomicFloat.getAndUpdate(previous -> 20.0F));
		assertEquals(20.0F, atomicFloat.get());
		
		assertThrows(NullPointerException.class, () -> atomicFloat.getAndUpdate(null));
		
//		The following code simulates multiple compareAndSet(float, float) operations:
		
		final AtomicBoolean atomicBoolean = new AtomicBoolean();
		
		final float value = atomicFloat.getAndUpdate(previous -> {
			if(atomicBoolean.compareAndSet(false, true)) {
				final CountDownLatch countDownLatch = new CountDownLatch(1);
				
				final Runnable runnable = () -> {
					atomicFloat.set(10.0F);
					
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
			
			return 30.0F;
		});
		
		assertEquals(10.0F, value);
		assertEquals(30.0F, atomicFloat.get());
	}
	
	@Test
	public void testIncrementAndGet() {
		final AtomicFloat atomicFloat = new AtomicFloat(10.0F);
		
		assertEquals(10.0F, atomicFloat.get());
		assertEquals(11.0F, atomicFloat.incrementAndGet());
		assertEquals(11.0F, atomicFloat.get());
	}
	
	@Test
	public void testIntValue() {
		final AtomicFloat atomicFloat = new AtomicFloat(10.0F);
		
		assertEquals(10, atomicFloat.intValue());
	}
	
	@Test
	public void testLazySet() {
		final AtomicFloat atomicFloat = new AtomicFloat(10.0F);
		
		assertEquals(10.0F, atomicFloat.get());
		
		atomicFloat.lazySet(20.0F);
		
		assertEquals(20.0F, atomicFloat.get());
	}
	
	@Test
	public void testLongValue() {
		final AtomicFloat atomicFloat = new AtomicFloat(10.0F);
		
		assertEquals(10L, atomicFloat.longValue());
	}
	
	@Test
	public void testSet() {
		final AtomicFloat atomicFloat = new AtomicFloat(10.0F);
		
		assertEquals(10.0F, atomicFloat.get());
		
		atomicFloat.set(20.0F);
		
		assertEquals(20.0F, atomicFloat.get());
	}
	
	@Test
	public void testToString() {
		final AtomicFloat atomicFloat = new AtomicFloat(10.0F);
		
		assertEquals(Float.toString(10.0F), atomicFloat.toString());
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testUpdateAndGet() {
		final AtomicFloat atomicFloat = new AtomicFloat(10.0F);
		
		assertEquals(10.0F, atomicFloat.get());
		assertEquals(20.0F, atomicFloat.updateAndGet(previous -> 20.0F));
		assertEquals(20.0F, atomicFloat.get());
		
		assertThrows(NullPointerException.class, () -> atomicFloat.updateAndGet(null));
		
//		The following code simulates multiple compareAndSet(float, float) operations:
		
		final AtomicBoolean atomicBoolean = new AtomicBoolean();
		
		final float value = atomicFloat.updateAndGet(previous -> {
			if(atomicBoolean.compareAndSet(false, true)) {
				final CountDownLatch countDownLatch = new CountDownLatch(1);
				
				final Runnable runnable = () -> {
					atomicFloat.set(10.0F);
					
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
			
			return 30.0F;
		});
		
		assertEquals(30.0F, value);
		assertEquals(30.0F, atomicFloat.get());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testWeakCompareAndSet() {
		final AtomicFloat atomicFloat = new AtomicFloat(10.0F);
		
		assertEquals(10.0F, atomicFloat.get());
		assertFalse(atomicFloat.weakCompareAndSet(20.0F, 30.0F));
		assertEquals(10.0F, atomicFloat.get());
		assertTrue(atomicFloat.weakCompareAndSet(10.0F, 20.0F));
		assertEquals(20.0F, atomicFloat.get());
		assertTrue(atomicFloat.weakCompareAndSet(20.0F, 30.0F));
		assertEquals(30.0F, atomicFloat.get());
		assertFalse(atomicFloat.weakCompareAndSet(10.0F, 20.0F));
		assertEquals(30.0F, atomicFloat.get());
	}
}