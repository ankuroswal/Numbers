package com.ankuroswal.numbers.Levels;

import com.badlogic.gdx.math.Vector2;

public abstract class Level {

	private Integer[][] layout;
	private Vector2 playerPos = new Vector2(0, 0);
	private float winningScore;

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

	public float getWinningScore() {
		return winningScore;
	}
}
