package com.ankuroswal.numbers.Levels;

import com.ankuroswal.Utils.UI;
import com.ankuroswal.numbers.Node.Node;
import com.ankuroswal.numbers.Node.NodeFactory;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;

public class LevelConverter {
	public static Texture convertLeveltoTexture(Level level) {
		
		Pixmap map = new Pixmap(UI.LEVELTILESIZE, UI.LEVELTILESIZE,
				Format.RGBA8888);

		Integer[][] layout = level.getLayout();
		map.setColor(Color.DARK_GRAY);
		map.fill();
		int height = layout[0].length;
		int width = layout.length;

		int tileSize = UI.LEVELTILESIZE / Math.max(width, height);
		int differenceHeight = ((height - width) * tileSize) / 2;
		int differenceWidth = ((width - height) * tileSize) / 2;

		if (differenceHeight < 0)
			differenceHeight = 0;

		if (differenceWidth < 0)
			differenceWidth = 0;

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				Node n = NodeFactory.getNode(layout[x][y]);
				map.setColor(n.getColor());
				map.fillRectangle(y * tileSize + differenceWidth, x * tileSize
						+ differenceHeight, tileSize, tileSize);
			}
		}

		Texture texture = new Texture(map);
		map.dispose();
		return texture;
	}
}
