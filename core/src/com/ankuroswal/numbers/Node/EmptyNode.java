package com.ankuroswal.numbers.Node;

import com.badlogic.gdx.graphics.Color;

public class EmptyNode extends Node{

    private static final int MIN = 0;
    private static final int MAX = 0;
    private static final String PATH = "nothing.png";
    private static final Color COLOR = new Color(0, 0, 0, 1);
    private static final NodeDefinitions TYPE = NodeDefinitions.EMPTY;
    
	public EmptyNode() {
		super(MIN, MAX, PATH, COLOR, TYPE);
	}

	@Override
	public Node transform() {
		return null;
	}
	
}
