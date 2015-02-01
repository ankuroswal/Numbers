package com.ankuroswal.numbers.Levels;

import com.badlogic.gdx.math.Vector2;

public class Level {

	private Integer[][] layout;
	private Vector2 playerPos = new Vector2(0,0);
	
	public Level(Integer[][] layout)
	{
		this.layout = layout;
	}
	
	public void setLayout(Integer[][] layout)
	{
		this.layout = layout;
	}
	
	public Integer[][] getLayout()
	{
		return this.layout;
	}

	public Vector2 getPlayerPos() {
		return playerPos;
	}

	public void setPlayerPos(Vector2 playerPos) {
		this.playerPos = playerPos;
	}
	
}
