package com.ankuroswal.numbers.Node;

public class NodeFactory {

	public static Node create(NodeDefinitions type) {

		switch (type) {
		case EMPTY:
			return new EmptyNode();
		case GREEN:
			return new GreenNode();
		case RED:
			return new RedNode();
		case YELLOW:
			return new YellowNode();
		default:
			return null;		
		}
	}
}
