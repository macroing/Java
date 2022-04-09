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
package org.macroing.java.awt.image;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import org.junit.jupiter.api.Test;

@SuppressWarnings("static-method")
public final class BufferedImagesUnitTests {
	public BufferedImagesUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testCreateScreenCaptureIntIntIntInt() {
		final BufferedImage bufferedImageA = BufferedImages.createScreenCapture(0, 0, 1, 1);
		
		assertNotNull(bufferedImageA);
		
		assertEquals(1, bufferedImageA.getWidth());
		assertEquals(1, bufferedImageA.getHeight());
		
		assertThrows(IllegalArgumentException.class, () -> BufferedImages.createScreenCapture(0, 0, 0, 1));
		assertThrows(IllegalArgumentException.class, () -> BufferedImages.createScreenCapture(0, 0, 1, 0));
	}
	
	@Test
	public void testCreateScreenCaptureRectangle() {
		final BufferedImage bufferedImageA = BufferedImages.createScreenCapture(new Rectangle(0, 0, 1, 1));
		
		assertNotNull(bufferedImageA);
		
		assertEquals(1, bufferedImageA.getWidth());
		assertEquals(1, bufferedImageA.getHeight());
		
		assertThrows(NullPointerException.class, () -> BufferedImages.createScreenCapture(null));
		assertThrows(IllegalArgumentException.class, () -> BufferedImages.createScreenCapture(new Rectangle(0, 0, 0, 1)));
		assertThrows(IllegalArgumentException.class, () -> BufferedImages.createScreenCapture(new Rectangle(0, 0, 1, 0)));
		
		BufferedImages.setRobot(null);
		
		final BufferedImage bufferedImageB = BufferedImages.createScreenCapture(new Rectangle(0, 0, 1, 1));
		
		assertNotNull(bufferedImageB);
		
		assertEquals(1, bufferedImageB.getWidth());
		assertEquals(1, bufferedImageB.getHeight());
		
		BufferedImages.setRobot(true);
		BufferedImages.setRobot();
	}
	
	@Test
	public void testGetCompatibleBufferedImageBufferedImage() {
		final BufferedImage bufferedImageA = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
		final BufferedImage bufferedImageB = BufferedImages.getCompatibleBufferedImage(bufferedImageA);
		
		assertNotNull(bufferedImageB);
		
		assertSame(bufferedImageA, bufferedImageB);
	}
	
	@Test
	public void testGetCompatibleBufferedImageBufferedImageInt() {
		final BufferedImage bufferedImageA = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		final BufferedImage bufferedImageB = BufferedImages.getCompatibleBufferedImage(bufferedImageA, BufferedImage.TYPE_INT_RGB);
		final BufferedImage bufferedImageC = BufferedImages.getCompatibleBufferedImage(bufferedImageA, BufferedImage.TYPE_INT_BGR);
		
		assertNotNull(bufferedImageB);
		assertNotNull(bufferedImageC);
		
		assertSame(bufferedImageA, bufferedImageB);
		
		assertEquals(100, bufferedImageC.getWidth());
		assertEquals(100, bufferedImageC.getHeight());
		assertEquals(BufferedImage.TYPE_INT_BGR, bufferedImageC.getType());
		
		assertThrows(NullPointerException.class, () -> BufferedImages.getCompatibleBufferedImage(null, BufferedImage.TYPE_INT_RGB));
		assertThrows(IllegalArgumentException.class, () -> BufferedImages.getCompatibleBufferedImage(bufferedImageA, -1));
	}
}