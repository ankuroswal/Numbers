package com.ankuroswal.numbers;

import com.ankuroswal.numbers.Node.Node;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen, InputProcessor {

	private SpriteBatch batch;
	private BitmapFont font;
	private Map map;
	private OpQueue queue;
	
	public GameScreen() {
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("opensans.fnt"),
				Gdx.files.internal("opensans.png"), false);
		map = new Map();
		Gdx.input.setInputProcessor(this);
		queue = new OpQueue();
		
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0.21f, 0.0f, 0.01f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		

		font.setColor(1, 1, 1, 1.0f);
		font.draw(batch, queue.getScore() + "", 400, 400) ;
		
		for (int i = 0; i < queue.getQ().size(); i++) {
			font.setColor(1, 1, 1, 1.0f);
			font.draw(batch, queue.getQ().get(i).renderString + "",
					50 * i + 100, 400);
		}
		
		for (int x = 0; x < map.getSize(); x++) {
			for (int y = 0; y < map.getSize(); y++) {
				if (map.getPlayer().x != x || map.getPlayer().y != y) {
					Node n = map.getGrid()[x][y];
					font.setColor(n.color);
					font.draw(batch, n.getValue() + "", x * 50 + 100,
							y * 50 + 100);
				}
			}
		}
		batch.end();
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

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch (keycode) {
		case Keys.DPAD_LEFT:
			queue.useQ(map.playerMove(-1, 0));
			break;
		case Keys.DPAD_RIGHT:
			queue.useQ(map.playerMove(1, 0));
			break;
		case Keys.DPAD_UP:
			queue.useQ(map.playerMove(0, 1));
			break;
		case Keys.DPAD_DOWN:
			queue.useQ(map.playerMove(0, -1));
			break;
		}
		if(map.isStuck()){
			map.intialize();
			queue.setScore(0);
			queue.startQ(4);
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
