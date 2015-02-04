package com.ankuroswal.numbers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MainMenuScreen implements Screen {

	private final Numbers game;
	private OrthographicCamera camera;
	private int width;
	private int height;

	public MainMenuScreen(final Numbers game) {
		this.game = game;
		width = Gdx.graphics.getHeight();
		height = Gdx.graphics.getWidth();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 400, 400);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		game.batch.setProjectionMatrix(camera.combined);

		game.batch.begin();
		game.font.draw(game.batch, "Welcome to Numbers!!! ", 400/2, 400/2);
		game.font.draw(game.batch, "Tap anywhere to begin!", 400/2, 400/2- 50);
		game.batch.end();

		if (Gdx.input.isTouched()) {
			game.setScreen(new GameScreen());
			dispose();
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

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
}
