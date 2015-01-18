package com.ankuroswal.numbers;

import com.ankuroswal.numbers.Node.GreenNode;
import com.ankuroswal.numbers.Node.Node;
import com.ankuroswal.numbers.Node.NodeDefinitions;
import com.ankuroswal.numbers.Node.NodeFactory;
import com.ankuroswal.numbers.Node.YellowNode;

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
				grid[x][y] = new GreenNode();
			}
		}
		grid[0][0] = new YellowNode();
		grid[size - 1][size - 1] = new YellowNode();
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

	public boolean boundaryCheck(int x, int y) {
		return !((x < 0 || x >= grid.length) || 
				 (y < 0 || y >= grid.length) || 
				 grid[x][y].getType() == NodeDefinitions.EMPTY);
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
