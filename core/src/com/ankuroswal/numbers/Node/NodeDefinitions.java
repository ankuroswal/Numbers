package com.ankuroswal.numbers.Node;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

public enum NodeDefinitions {
	
	EMPTY(0, 0, new Color(0, 0, 0, 0), null, "nothing.png"), 
	RED(-9, -1, new Color(1, 0, 0, 1), EMPTY, "redtile.png"), 
	GREEN(0, 9, new Color(0, 1, 0, 1), RED, "greentile.png"), 
	YELLOW(10, 20, new Color(1, 1, 0, 1), GREEN, "yellowtile.png");

	public int min, max;
	public NodeDefinitions transform;
	public Color color;
	public Texture texture;

	NodeDefinitions(int min, int max, Color color, NodeDefinitions transform, String picture) {
		this.transform = transform;
		this.color = color;
		this.min = min;
		this.max = max;
		this.texture = new Texture(Gdx.files.internal(picture));
	}

}