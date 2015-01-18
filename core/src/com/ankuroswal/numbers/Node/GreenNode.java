package com.ankuroswal.numbers.Node;

import com.badlogic.gdx.graphics.Color;

public class GreenNode extends Node {
	
	private static final int MIN = 0;
	private static final int MAX = 9;
	private static final String PATH = "greentile.png";
	private static final Color COLOR = new Color(0, 1, 0, 1);
	private static final NodeDefinitions TYPE = NodeDefinitions.GREEN;

	public GreenNode() {
		super(MIN, MAX, PATH, COLOR, TYPE);
	}

	@Override
	public Node transform() {
		return new RedNode();
	}

}
