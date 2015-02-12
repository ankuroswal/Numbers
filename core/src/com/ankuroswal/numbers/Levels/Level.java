package com.ankuroswal.numbers.Levels;

import java.util.ArrayList;

import com.ankuroswal.numbers.Operations.Operations;
import com.badlogic.gdx.math.Vector2;

public abstract class Level {

	private Integer[][] layout;
	private Vector2 playerPos = new Vector2(0, 0);
	private double winningScore;
	private double currentScore;
	private boolean open;
	private ArrayList<Operations> operations;
	
	public Level(int id)
	{
		
	}
	
	public Level(Integer[][] layout, float winningScore) {
		setLayout(layout);
		this.winningScore = winningScore;
	}

	public void setLayout(Integer[][] layout) {
		int m = layout[0].length;
		int n = layout.length;

		Integer[][] tmp = new Integer[m][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				tmp[j][n - 1 - i] = layout[i][j];

		this.layout = tmp;
	}

	public Integer[][] getLayout() {
		return this.layout;
	}

	public Vector2 getPlayerPos() {
		return playerPos;
	}

	public void setPlayerPos(Vector2 playerPos) {
		this.playerPos = playerPos;
	}

	public double getWinningScore() {
		return winningScore;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public ArrayList<Operations> getOperations() {
		return operations;
	}

	public void setOperations(ArrayList<Operations> operations) {
		this.operations = operations;
	}

	public double getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(double currentScore) {
		this.currentScore = currentScore;
	}
}
