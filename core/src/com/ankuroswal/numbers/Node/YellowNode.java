package com.ankuroswal.numbers.Node;

import com.badlogic.gdx.graphics.Color;

public class YellowNode extends Node{
	private static final int MIN = 10;
	private static final int MAX = 20;
	private static final String PATH = "yellowtile.png";
	private static final Color COLOR = new Color(1, 1, 0, 1);
	private static final NodeDefinitions TYPE = NodeDefinitions.YELLOW;

	public YellowNode() {
		super(MIN, MAX, PATH, COLOR, TYPE);
	}

	@Override
	public Node transform() {
		return new GreenNode();
	}
}
