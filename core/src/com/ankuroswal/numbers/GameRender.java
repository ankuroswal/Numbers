package com.ankuroswal.numbers;

import com.ankuroswal.numbers.Levels.Level;
import com.ankuroswal.numbers.Levels.Level1;
import com.ankuroswal.numbers.Map.Map;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class GameRender {

			
	private TiledMap map;
	private BitmapFont font;
	private OpQueue queue;
	
	private Level level;
	private MapRenderer render;
	private OrthographicCamera camera;

	public GameRender(OrthographicCamera camera, OpQueue queue) {
		
		this.queue = queue;
		this.camera = camera;
		
		level = new Level1();
		map = new TiledMap();
		map.getLayers().add(Map.getInstance().getNodeLayer());
		render = new OrthogonalTiledMapRenderer(map, 1f);
		
		font = new BitmapFont(Gdx.files.internal("opensans.fnt"),
				Gdx.files.internal("opensans.png"), false);

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
		 render.setView(camera);
	     render.render();	
	}
}
