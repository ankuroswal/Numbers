package com.ankuroswal.numbers.Map;

import com.ankuroswal.Utils.UI;
import com.ankuroswal.numbers.Player;
import com.ankuroswal.numbers.Levels.Level;
import com.ankuroswal.numbers.Node.Node;
import com.ankuroswal.numbers.Node.NodeFactory;
import com.ankuroswal.numbers.Node.NodeLayer;

public class Map {

	private static Map instance = null;
	private Player p;
	private NodeLayer nodelayer;
	private int width = 0;
	private int height = 0;

	// only for initial instantiation
	private Map() {}

	// Singleton design pattern that is kind of thread safe
	public static Map getInstance() {
		if (instance == null) {
			synchronized (Map.class) {
				if (instance == null) {
					instance = new Map();
				}
			}
		}
		return instance;
	}
	
	public void setLevel(Level level) {
		Integer[][] layout = level.getLayout();
		height = layout[0].length;
		width = layout.length;
		p = new Player();

		p.x = (int) level.getPlayerPos().x;
		p.y = (int) level.getPlayerPos().y;

		nodelayer = new NodeLayer(width, height, UI.TILEWIDTH, UI.TILEHEIGHT);

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				placeNode(NodeFactory.getNode((int) layout[x][y]), x, y);
			}
		}
	}

	// place a node on the grid and add it's the node map tile to the layer
	public boolean placeNode(Node n, int x, int y) {
		if (!boundaryCheck(x, y))
			return false;

		nodelayer.setNode(x, y, n);
		return true;
	}

	public Node getNode(int x, int y) {
		return nodelayer.getNode(x, y);
	}

	public Integer playerMove(int deltaX, int deltaY) {
		return move(p.x + deltaX, p.y + deltaY);
	}

	private Integer move(int x, int y) {
		if (moveCheck(x, y)) {
			p.x = x;
			p.y = y;
			int value = nodelayer.getNode(x, y).getValue();
			nodelayer.getNode(x, y).runActions();
			return value;
		}
		return null;
	}

	public boolean isStuck() {
		int x = p.x, y = p.y;
		boolean result = false;
		result |= moveCheck(x + 1, y);
		result |= moveCheck(x - 1, y);
		result |= moveCheck(x, y - 1);
		result |= moveCheck(x, y + 1);
		return !result;
	}

	// check to see if player can move to a particular location
	public boolean moveCheck(int x, int y) {
		return (boundaryCheck(x, y) && !(getNode(x, y).getID() == 0));
	}

	// check to see if you are outside the map boundary
	public boolean boundaryCheck(int x, int y) {
		return (x >= 0 && x < nodelayer.getWidth())
				&& (y >= 0 && y < nodelayer.getHeight());
	}

	public Player getPlayer() {
		return this.p;
	}

	public NodeLayer getNodeLayer() {
		return nodelayer;
	}

	@SuppressWarnings("unused")
	private void debugGrid() {
		int width = nodelayer.getWidth();
		int height = nodelayer.getHeight();
		System.out.println("---------");
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (p.x == x && p.y == y) {
					System.out.print("p ");
				} else {
					System.out.print(nodelayer.getNode(x, y).getID() + " ");
				}
			}
			System.out.println();
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
