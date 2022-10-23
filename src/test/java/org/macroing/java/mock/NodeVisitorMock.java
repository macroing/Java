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
package org.macroing.java.mock;

import org.macroing.java.util.visitor.Node;
import org.macroing.java.util.visitor.NodeVisitor;

public final class NodeVisitorMock implements NodeVisitor {
	private final boolean isThrowingRuntimeException;
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public NodeVisitorMock() {
		this(false);
	}
	
	public NodeVisitorMock(final boolean isThrowingRuntimeException) {
		this.isThrowingRuntimeException = isThrowingRuntimeException;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void visit(final Node node) {
		if(this.isThrowingRuntimeException) {
			throw new RuntimeException();
		}
	}
}