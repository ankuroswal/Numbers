package com.ankuroswal.numbers.Levels;

import com.ankuroswal.Utils.UI;
import com.ankuroswal.numbers.Node.Node;
import com.ankuroswal.numbers.Node.NodeFactory;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;

public class LevelConverter {
	public static Texture convertLeveltoTexture(Level level) {

		Pixmap map = new Pixmap(UI.LEVELTILESIZE, UI.LEVELTILESIZE,
				Format.RGBA8888);

		Integer[][] layout = level.getLayout();

		// rotate matrix
		int m = layout[0].length;
		int n = layout.length;

		Integer[][] tmp = new Integer[m][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				tmp[m - 1 - j][i] = layout[i][j];
		
		layout = tmp;
		
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
				Node node = NodeFactory.getNode(layout[x][y]);
				map.setColor(node.getColor());
				map.fillRectangle(y * tileSize + differenceWidth, x * tileSize
						+ differenceHeight, tileSize, tileSize);
			}
		}

		Texture texture = new Texture(map);
		map.dispose();
		return texture;
	}
}