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
package org.macroing.java.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

@SuppressWarnings("static-method")
public final class FilesUnitTests {
	public FilesUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testFindClosestExistingDirectoryTo() {
		final File fileA = Files.findClosestExistingDirectoryTo(new File("./src/main/java/directory/that/does/not/exist"));
		final File fileB = Files.findClosestExistingDirectoryTo(new File("directory/that/does/not/exist"));
		
		assertNotNull(fileA);
		assertNotNull(fileB);
		
		assertEquals("java", fileA.getName());
		assertEquals(".", fileB.getName());
		
		assertThrows(NullPointerException.class, () -> Files.findClosestExistingDirectoryTo(null));
	}
	
	@Test
	public void testFindFilesFromDirectory() {
		final List<File> files = Files.findFilesFromDirectory();
		
		assertTrue(files.size() > 0);
	}
	
	@Test
	public void testFindFilesFromDirectoryFile() {
		assertThrows(NullPointerException.class, () -> Files.findFilesFromDirectory(null));
	}
	
	@Test
	public void testFindFilesFromDirectoryFilePredicate() {
		assertThrows(NullPointerException.class, () -> Files.findFilesFromDirectory(new File("."), null));
		assertThrows(NullPointerException.class, () -> Files.findFilesFromDirectory(null, currentFile -> true));
	}
	
	@Test
	public void testFindFilesFromDirectoryFilePredicatePredicate() {
		final File directoryA = new File("./src/test/java");
		final File directoryB = new File("directory/that/does/not/exist");
		
		final Predicate<File> filePredicate = currentFile -> currentFile.getName().equals("FilesUnitTests.java");
		final Predicate<File> directoryPredicate = currentDirectory -> currentDirectory.getName().matches("org|macroing|java|io");
		
		final List<File> filesA = Files.findFilesFromDirectory(directoryA, filePredicate, directoryPredicate);
		final List<File> filesB = Files.findFilesFromDirectory(directoryB, filePredicate, directoryPredicate);
		
		assertEquals(1, filesA.size());
		assertEquals(0, filesB.size());
		
		assertThrows(NullPointerException.class, () -> Files.findFilesFromDirectory(new File("."), currentFile -> true, null));
		assertThrows(NullPointerException.class, () -> Files.findFilesFromDirectory(new File("."), null, currentDirectory -> true));
		assertThrows(NullPointerException.class, () -> Files.findFilesFromDirectory(null, currentFile -> true, currentDirectory -> true));
	}
	
	@Test
	public void testReadAllBytesToString() {
		final String string = Files.readAllBytesToString(new File("./src/test/java/org/macroing/java/io/FilesUnitTests.java"));
		
		assertNotNull(string);
		
		assertTrue(string.length() > 0);
		
		assertThrows(UncheckedIOException.class, () -> Files.readAllBytesToString(new File("directory/that/does/not/exist/File.txt")));
	}
}