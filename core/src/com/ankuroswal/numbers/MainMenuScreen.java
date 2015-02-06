package com.ankuroswal.numbers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenuScreen implements Screen {

	private final Numbers game;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private BitmapFont font;
	
	public MainMenuScreen(final Numbers game) {
		this.game = game;
		this.batch = new SpriteBatch();
		this.font = new BitmapFont();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 400, 400);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		font.draw(batch, "Welcome to Numbers!!! ", 400/2, 400/2);
		font.draw(batch, "Tap anywhere to begin!", 400/2, 400/2- 50);
		batch.end();

		if (Gdx.input.isTouched()) {
			game.setScreen(new LevelScreen(game));
			dispose();
		}
	}

	@Override
	public void resize(int width, int height) {

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
}

