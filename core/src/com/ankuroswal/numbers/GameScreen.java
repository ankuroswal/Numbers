package com.ankuroswal.numbers;

import com.ankuroswal.numbers.Levels.LevelRenderer;
import com.ankuroswal.numbers.Levels.LevelSave;
import com.ankuroswal.numbers.Levels.LevelUIRenderer;
import com.ankuroswal.numbers.Map.Map;
import com.ankuroswal.numbers.Operations.OpQueue;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

public class GameScreen implements Screen, InputProcessor, GestureListener  {
	private final Numbers game;
	private OpQueue queue;
	private PlayerRender player;
	private BitmapFont font;
	private LevelRenderer levelrender;
	private SpriteBatch batch;
	private LevelUIRenderer levelUI;
	private Integer level;
	public GameScreen(final Numbers game, Integer level) {
		this.game = game;
		this.level = level;
		batch = new SpriteBatch();
		font = new BitmapFont();
		queue = new OpQueue();
		levelUI = new LevelUIRenderer(queue, font);
		levelrender = new LevelRenderer(batch);
		levelrender.setLevel(level);
		player = new PlayerRender(Map.getInstance());
		font = new BitmapFont(Gdx.files.internal("opensans.fnt"),
				Gdx.files.internal("opensans.png"), false);
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		levelrender.render(delta);
		levelUI.render(delta);
		batch.begin();
		player.render(batch, delta);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		levelrender.resize();
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
		font.dispose();
		batch.dispose();
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
			levelrender.getCamera().zoom += 0.02;
			break;
		case Keys.Q:
			levelrender.getCamera().zoom -= 0.02;
			break;
		}

		if (Map.getInstance().isStuck()) {
			LevelSave.setLevel(level, queue.getScore());
			LevelSave.save();
			queue.setScore(0);
			queue.startQ(4);
			game.setScreen(new LevelScreen(game));
			dispose();
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
