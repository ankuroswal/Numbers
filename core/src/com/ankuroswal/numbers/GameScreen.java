package com.ankuroswal.numbers;

import com.ankuroswal.Utils.UI;
import com.ankuroswal.numbers.Levels.Level1;
import com.ankuroswal.numbers.Levels.Level2;
import com.ankuroswal.numbers.Map.Map;
import com.ankuroswal.numbers.Node.NodeRender;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GameScreen implements Screen, InputProcessor {

	private SpriteBatch batch;
	private OpQueue queue;
	private PlayerRender player;
	private OrthographicCamera camera;
	private Rectangle viewport;
	private TiledMapRenderer tiledMapRenderer;
	private TiledMap tiledMap;
	private BitmapFont font;

	public GameScreen() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		queue = new OpQueue();
		Map.getInstance().setLevel(new Level2());
		player = new PlayerRender(Map.getInstance());
		tiledMap = new TiledMap();
		tiledMap.getLayers().add(Map.getInstance().getNodeLayer());
		tiledMapRenderer = new NodeRender(tiledMap, 1.0f, batch);
		int minOrtho = Math.max(Map.getInstance().getWidth(), Map.getInstance()
				.getHeight());
		camera.setToOrtho(false, minOrtho * UI.TILESIZE, minOrtho * UI.TILESIZE);
		font = new BitmapFont(Gdx.files.internal("opensans.fnt"),
				Gdx.files.internal("opensans.png"), false);
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		tiledMapRenderer.setView(camera);
		tiledMapRenderer.render();
		camera.update();
		tiledMapRenderer.setView(camera);
		tiledMapRenderer.render();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		player.render(batch, delta);
		font.setColor(1, 1, 1, 1.0f);
		font.draw(batch, queue.getScore() + "", 15, 200);
		for (int i = 0; i < queue.getQ().size(); i++) {
			if (i == 0) {
				font.setColor(1, 1, 1, 1.0f);
			} else {
				font.setColor(.5f, .5f, .5f, 1.0f);
			}
			font.draw(batch, queue.getQ().get(i).renderString + "",
					50 * i + 100, 200);
		}

		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// calculate new viewport
		float aspectRatio = (float) width / (float) height;
		float scale = 1f;
		Vector2 crop = new Vector2(0f, 0f);

		if (aspectRatio > UI.ASPECT_RATIO) {
			scale = (float) height / (float) UI.VIRTUAL_HEIGHT;
			crop.x = (width - UI.VIRTUAL_WIDTH * scale) / 2f;
		} else if (aspectRatio < UI.ASPECT_RATIO) {
			scale = (float) width / (float) UI.VIRTUAL_WIDTH;
			crop.y = (height - UI.VIRTUAL_HEIGHT * scale) / 2f;
		} else {
			scale = (float) width / (float) UI.VIRTUAL_WIDTH;
		}

		float w = (float) UI.VIRTUAL_WIDTH * scale;
		float h = (float) UI.VIRTUAL_HEIGHT * scale;
		viewport = new Rectangle(crop.x, crop.y, w, h);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
		case Keys.DPAD_LEFT:
			queue.useQ(Map.getInstance().playerMove(-1, 0));
			player.move(2);
			break;
		case Keys.DPAD_RIGHT:
			queue.useQ(Map.getInstance().playerMove(1, 0));
			player.move(3);
			break;
		case Keys.DPAD_UP:
			queue.useQ(Map.getInstance().playerMove(0, 1));
			player.move(1);
			break;
		case Keys.DPAD_DOWN:
			queue.useQ(Map.getInstance().playerMove(0, -1));
			player.move(0);
			break;
		case Keys.A:
			camera.zoom += 0.02;
			break;
		case Keys.Q:
			camera.zoom -= 0.02;
			break;
		}

		if (Map.getInstance().isStuck()) {
			queue.setScore(0);
			queue.startQ(4);
			tiledMap.getLayers().remove(0);
			Map.getInstance().setLevel(new Level1());
			tiledMap.getLayers().add(Map.getInstance().getNodeLayer());
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch (keycode) {
		case Keys.A:
			camera.zoom += 0.1;
			break;
		case Keys.Q:
			camera.zoom -= 0.02;
			break;
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
