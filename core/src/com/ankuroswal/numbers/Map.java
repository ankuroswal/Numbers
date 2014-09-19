package com.ankuroswal.numbers;

import com.ankuroswal.Node.Node;
import com.ankuroswal.Node.Player;
import com.ankuroswal.Node.NodeDefinitions;

public class Map {

	private int size;
	private Node[][] grid;
	private Player p;

	public Map() {
		this.size = 5;
		this.p = new Player();
		this.grid = new Node[size][size];
		intialize();
	}

	public Integer playerMove(int deltaX, int deltaY) {
		return move(p.x + deltaX, p.y + deltaY);
	}

	private Integer move(int x, int y) {
		if (boundaryCheck(x, y)) {
			grid[p.x][p.y] = grid[p.x][p.y].transform();
			p.x = x;
			p.y = y;
			return grid[x][y].getValue();
		}
		return null;
	}

	public void intialize() {
		p.x = size / 2;
		p.y = size / 2;
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				grid[x][y] = new Node(NodeDefinitions.GREEN);
			}
		}
		grid[0][0] = new Node(NodeDefinitions.YELLOW);
		grid[size - 1][size - 1] = new Node(NodeDefinitions.YELLOW);
	}

	public boolean isStuck() {
		int x = p.x, y = p.y;
		boolean result = false;
		result |= boundaryCheck(x + 1, y);
		result |= boundaryCheck(x - 1, y);
		result |= boundaryCheck(x, y - 1);
		result |= boundaryCheck(x, y + 1);

		return !result;
	}

	private boolean boundaryCheck(int x, int y) {
		if ((x < 0 || x >= grid.length) || (y < 0 || y >= grid.length)
				|| grid[x][y].type == NodeDefinitions.EMPTY) {
			return false;
		}
		return true;
	}

	public int getSize() {
		return size;
	}

	public Node[][] getGrid() {
		return grid;
	}

	public Player getPlayer() {
		return this.p;
	}
}
