package com.ankuroswal.numbers.Node;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Vector2;

public class NodeLayer extends MapLayer {

	private int width;
	private int height;

	private float tileWidth;
	private float tileHeight;

	private Node[][] grid;
	private Cell[][] cells;

	public NodeLayer(int width, int height, int tileWidth, int tileHeight) {
		super();
		this.width = width;
		this.height = height;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		this.cells = new Cell[width][height];
		this.grid = new Node[width][height];
	}

	/** @return layer's width in tiles */
	public int getWidth() {
		return width;
	}

	/** @return layer's height in tiles */
	public int getHeight() {
		return height;
	}

	/** @return tiles' width in pixels */
	public float getTileWidth() {
		return tileWidth;
	}

	/** @return tiles' height in pixels */
	public float getTileHeight() {
		return tileHeight;
	}

	/**
	 * @param x
	 *            X coordinate
	 * @param y
	 *            Y coordinate
	 * @return {@link Node} at (x, y)
	 */
	public Node getNode(int x, int y) {
		if (x < 0 || x >= width)
			return null;
		if (y < 0 || y >= height)
			return null;
		return grid[x][y];
	}

	/**
	 * Sets the {@link Node} at the given coordinates.
	 * 
	 * @param x
	 *            X coordinate
	 * @param y
	 *            Y coordinate
	 * @param cell
	 *            the {@link Cell} to set at the given coordinates.
	 */
	public void setNode(int x, int y, Node node) {
		if (x < 0 || x >= width)
			return;
		if (y < 0 || y >= height)
			return;
		grid[x][y] = node;
		grid[x][y].setPosition(new Vector2(x, y));
		Cell c = new Cell();
		c.setTile(node.getTile());
		cells[x][y] = c;
	}

	/**
	 * @param x
	 *            X coordinate
	 * @param y
	 *            Y coordinate
	 * @return {@link Cell} at (x, y)
	 */
	public Cell getCell(int x, int y) {
		if (x < 0 || x >= width)
			return null;
		if (y < 0 || y >= height)
			return null;
		return cells[x][y];
	}
}
