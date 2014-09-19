package com.ankuroswal.Node;

import com.badlogic.gdx.graphics.Color;

public enum NodeDefinitions {
	
	EMPTY(0, 0, new Color(0, 0, 0, 0), null), 
	RED(-9, -1, new Color(1, 0, 0, 1), EMPTY), 
	GREEN(0, 9, new Color(0, 1, 0, 1), RED), 
	YELLOW(10, 20, new Color(1, 1, 0, 1), GREEN);

	public int min, max;
	public NodeDefinitions transform;
	public Color color;

	NodeDefinitions(int min, int max, Color color, NodeDefinitions transform) {
		this.transform = transform;
		this.color = color;
		this.min = min;
		this.max = max;
	}

}