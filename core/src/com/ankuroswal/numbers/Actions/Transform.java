package com.ankuroswal.numbers.Actions;

import com.ankuroswal.numbers.Map.Map;
import com.ankuroswal.numbers.Node.Node;
import com.ankuroswal.numbers.Node.NodeFactory;

public class Transform implements Action {
	
	private Node transformNode;
	
	public Transform(int transformID)
	{
		transformNode = NodeFactory.getNode(transformID);
	}
	
	@Override
	public void activate(Node n) {
		int x = n.getX();
		int y = n.getY();
		Map.getInstance().placeNode(transformNode, x, y);
	}

	@Override
	public int getPriority() {
		return 100;
	}
}
