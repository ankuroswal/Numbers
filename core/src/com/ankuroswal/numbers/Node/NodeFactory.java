package com.ankuroswal.numbers.Node;

public class NodeFactory {

	public static Node getNode(int id)
	{
		switch(id)
		{
		case 0:
			return new EmptyNode();
		case 1:
			return new RedNode();
		case 2:
			return new GreenNode();
		case 3: 
			return new YellowNode();
		}
		return null;	
	}
}
