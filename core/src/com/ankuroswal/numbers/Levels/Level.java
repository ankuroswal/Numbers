package com.ankuroswal.numbers.Levels;

import java.util.ArrayList;
import java.util.Collections;

import com.ankuroswal.numbers.External.LevelDirectory;
import com.ankuroswal.numbers.Operations.Operations;
import com.badlogic.gdx.math.Vector2;

public class Level {

	private Integer[][] layout;
	private Vector2 playerPos = new Vector2(0, 0);
	private double winningScore;
	private int id;
	private ArrayList<Operations> operations;
	

	@SuppressWarnings("unused")
	private Level(){};
	
	// make a level
	public Level(int id)
	{
		copy(LevelDirectory.getInstance().getLevel(id));
	}
	
	// copy constructor
	public Level(Level level)
	{
		operations = new ArrayList<Operations>();
		copy(level);
	}
	
	// constructor used for saving
	public Level(Integer id, Integer[][] layout, double winningScore, ArrayList<Operations>  operations) {
		setLayout(layout);
		this.winningScore = winningScore;
		this.id = id;
		this.operations = operations;
	}

	private void setLayout(Integer[][] layout) {
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
	
	public ArrayList<Operations> getOperations() {
		return operations;
	}

	public int getID()
	{
		return id;
	}
	
	public void copy(Level level)
	{
		setLayout(level.getLayout());
		setPlayerPos(level.getPlayerPos());
		winningScore = level.getWinningScore();
		if (level.getOperations() != null)
			Collections.copy(operations, level.getOperations());
	}
}
