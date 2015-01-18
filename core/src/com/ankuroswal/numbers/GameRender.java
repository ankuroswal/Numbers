package com.ankuroswal.numbers;

import com.ankuroswal.numbers.Node.Node;
import com.ankuroswal.numbers.Node.NodeDefinitions;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameRender {

	private Map map;
	private BitmapFont font;
	private Texture shadow[] = new Texture[4];
	private OpQueue queue;

	public GameRender(Map map, OpQueue queue) {
		this.map = map;
		this.queue = queue;
		font = new BitmapFont(Gdx.files.internal("opensans.fnt"),
				Gdx.files.internal("opensans.png"), false);

		shadow[0] = new Texture(Gdx.files.internal("bottomshadow.png"));
		shadow[1] = new Texture(Gdx.files.internal("topshadow.png"));
		shadow[2] = new Texture(Gdx.files.internal("rightshadow.png"));
		shadow[3] = new Texture(Gdx.files.internal("leftshadow.png"));
	}

	public void render(SpriteBatch batch) {

		font.setColor(1, 1, 1, 1.0f);
		font.draw(batch, queue.getScore() + "", 400, 400);

		for (int i = 0; i < queue.getQ().size(); i++) {
			if (i == 0) {
				font.setColor(1, 1, 1, 1.0f);
			} else {
				font.setColor(.5f, .5f, .5f, 1.0f);
			}
			font.draw(batch, queue.getQ().get(i).renderString + "",
					50 * i + 100, 40);

		}

		for (int x = 0; x < map.getSize(); x++) {
			for (int y = 0; y < map.getSize(); y++) {

				Node n = map.getGrid()[x][y];
				batch.draw(n.getTexture(), x * UIVars.TSize + UIVars.TdX, y * 64
						+ UIVars.TSize + UIVars.TdX);
				if (map.getPlayer().x != x || map.getPlayer().y != y) {
					font.setColor(Color.BLACK);
					font.draw(batch, n.getValue() + "", x * UIVars.TSize
							+ UIVars.FdX, y * UIVars.TSize + UIVars.FdY);
				} else {

				}
			}
		}

		for (int x = 0; x < map.getSize(); x++) {
			for (int y = 0; y < map.getSize(); y++) {
				Node n = map.getGrid()[x][y];
				drawShadow(n, map.getGrid(), x, y - 1, 1, batch);
				drawShadow(n, map.getGrid(), x, y + 1, 0, batch);
				drawShadow(n, map.getGrid(), x - 1, y, 2, batch);
				drawShadow(n, map.getGrid(), x + 1, y, 3, batch);
			}
		}
	}

	private void drawShadow(Node current, Node[][] grid, int x, int y, int pos,
			SpriteBatch b) {
		if (map.boundaryCheck(x, y)) {
			if (current.getType() != NodeDefinitions.EMPTY
					&& current.transform().getType() == grid[x][y].getType()) {
				b.draw(shadow[pos], x * UIVars.TSize + UIVars.TdX, y
						* UIVars.TSize + UIVars.TdY + UIVars.TSize);
			}
		}
	}
}
