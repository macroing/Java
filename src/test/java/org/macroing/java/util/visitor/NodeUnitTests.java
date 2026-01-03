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
package org.macroing.java.util.visitor;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.macroing.java.mock.NodeHierarchicalVisitorMock;
import org.macroing.java.mock.NodeMockC;
import org.macroing.java.mock.NodeVisitorMock;

@SuppressWarnings("static-method")
public final class NodeUnitTests {
	public NodeUnitTests() {
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testAcceptNodeHierarchicalVisitor() {
		final
		Node node = new NodeMockC();
		node.accept(new NodeHierarchicalVisitorMock(nodeEnter -> true, nodeLeave -> true));
		
		assertThrows(NodeTraversalException.class, () -> node.accept(new NodeHierarchicalVisitorMock(null, null)));
		assertThrows(NullPointerException.class, () -> node.accept((NodeHierarchicalVisitor)(null)));
	}
	
	@Test
	public void testAcceptNodeVisitor() {
		final
		Node node = new NodeMockC();
		node.accept(new NodeVisitorMock());
		
		assertThrows(NodeTraversalException.class, () -> node.accept(new NodeVisitorMock(true)));
		assertThrows(NullPointerException.class, () -> node.accept((NodeVisitor)(null)));
	}
}