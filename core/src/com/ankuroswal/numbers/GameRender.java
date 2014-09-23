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
			font.setColor(1, 1, 1, 1.0f);
			font.draw(batch, queue.getQ().get(i).renderString + "",
					50 * i + 100, 400);
		}

		for (int x = 0; x < map.getSize(); x++) {
			for (int y = 0; y < map.getSize(); y++) {
				if (map.getPlayer().x != x || map.getPlayer().y != y) {
					Node n = map.getGrid()[x][y];
					batch.draw(n.texture, x * 64 + 100 - 64, y * 64 + 100 - 64);
					font.setColor(Color.BLACK);
					font.draw(batch, n.getValue() + "", x * 64 + 100 - 45,
							y * 64 + 100 - 32);
				}
			}
		}
		for (int x = 0; x < map.getSize(); x++) {
			for (int y = 0; y < map.getSize(); y++) {
				Node n = map.getGrid()[x][y];
				drawShadow(n, map.getGrid(), x - 1, y, 2, batch);
				drawShadow(n, map.getGrid(), x + 1, y, 3, batch);
				drawShadow(n, map.getGrid(), x, y - 1, 1, batch);
				drawShadow(n, map.getGrid(), x, y + 1, 0, batch);
			}
		}
	}

	private void drawShadow(Node current, Node[][] grid, int x, int y, int pos,
			SpriteBatch b) {
		if (!map.boundaryCheck(x, y)) {
			return;
		}
		if (current.type != NodeDefinitions.EMPTY
				&& current.transform().type == grid[x][y].type) {
			b.draw(shadow[pos], x * 64 + 100 - 64, y * 64 + 100 - 64);
		}

	}
}
