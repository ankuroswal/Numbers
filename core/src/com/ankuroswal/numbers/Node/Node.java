package com.ankuroswal.numbers.Node;

import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

public abstract class Node {
	
	protected int value = 0;
	protected Color color;
	protected NodeDefinitions type;
	private Texture texture;
	
	public Node(int min, int max, String path, Color color, NodeDefinitions type)
	{
		// make sure everything is initialized from child classes
	    if (path == null) throw new NullPointerException("path may not be null");
	    if (color == null) throw new NullPointerException("color may not be null");
	    if (type == null) throw new NullPointerException("type may not be null");
	    
		this.color = color;
		this.type = type;
		this.value = 0;
		calculateValue(min, max);
		setTexture(path);
	}
	
	// what type of node is this
	public  NodeDefinitions getType()
	{
		 return type;
	}
	
	// returns the transformation node
	public abstract Node transform();
	
	// returns texture to render node
	public Texture getTexture()
	{
		return texture;
	}
	
	// returns the base color for the node
	public Color getColor()
	{
		return color;
	}

	// the current value of the node in terms of score
	public Integer getValue()
	{
		return value;
	}
	
	// Initializes texture
	private void setTexture(String path)
	{
		texture = new Texture(path);
	}
	
	// gets a random value in between the min and max of this node
	private void calculateValue(int min, int max)
	{
		Random random = new Random();
		int range = ((max - min) + 1) + min;
		if (range < 0)
			value = random.nextInt(range*-1)*-1;		
		else
			value = random.nextInt(range);
	}
}
