package com.ankuroswal.numbers.Levels;

import com.badlogic.gdx.math.Vector2;

public abstract class Level {

	private Integer[][] layout;
	private Vector2 playerPos = new Vector2(0,0);
	private float winningScore;
	
	public Level(Integer[][] layout, float winningScore)
	{
		this.layout = layout;
		this.winningScore = winningScore;
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
	
	public float getWinningScore()
	{
		return winningScore;
	}
}
