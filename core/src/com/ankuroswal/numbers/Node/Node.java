package com.ankuroswal.numbers.Node;

import java.util.ArrayList;
import java.util.List;

import com.ankuroswal.numbers.Actions.Action;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.math.Vector2;

public abstract class Node {

	private int x, y;
	private int value = 0;
	private String valueString = "";
	private int id = 0;
	private Color color;
	private List<Action> actionList = new ArrayList<Action>();
	
	public Node(int min, int max, Color color) {
		this.color = color;
		calculateValue(min, max);
	}
	
	// returns texture region this must be a static reference in child classes
	public abstract TiledMapTile getTile();
	
	// ------------------------------- ACTION METHODS  -------------------------------
	
	public void runActions()
	{
		for (Action i : actionList)
		{
			i.activate(this);
		}
	}
	
	protected void addAction(Action a)
	{
		actionList.add(a);
	}
	
	// ------------------------------- GETTERS AND SETTERS -------------------------------
	
	// the current value of the node in terms of score
	public Integer getValue()
	{
		return value;
	}
	
	public int getID()
	{
		return id;
	}
	
	protected void setID(int id)
	{
		this.id = id;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public Vector2 getPosition()
	{
		return new Vector2(x, y);
	}
	
	public void setPosition(Vector2 pos)
	{
		x = (int) pos.x;
		y = (int) pos.y;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public String getValueString()
	{
		return valueString;
	}
	
	// ------------------------------- UTILS -------------------------------

	// gets a random value in between the min and max of this node
	private void calculateValue(int min, int max)
	{
		value = min+(int)(Math.random()*((max-min) + 1));		
		valueString = String.valueOf(value);
	}
}
