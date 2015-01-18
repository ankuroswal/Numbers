package com.ankuroswal.numbers.Node;

import com.badlogic.gdx.graphics.Color;

public class RedNode extends Node{

	private static final int MIN = -1;
	private static final int MAX = -9;
	private static final String PATH = "redtile.png";
	private static final Color COLOR = new Color(1, 0, 0, 1);
	private static final NodeDefinitions TYPE = NodeDefinitions.RED;

	public RedNode() {
		super(MIN, MAX, PATH, COLOR, TYPE);
	}

	@Override
	public Node transform() {
		return new EmptyNode();
	}
}
