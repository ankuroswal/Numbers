package com.ankuroswal.numbers;

import com.ankuroswal.Utils.UI;
import com.ankuroswal.numbers.Levels.LevelFactory;
import com.ankuroswal.numbers.Levels.LevelTile;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class LevelScreen implements Screen, InputProcessor {
	private Stage stage;
	private Viewport viewport;
	public LevelScreen(final Numbers game) {
		game.getMyRequestHandler().showAds(true);
		int width = UI.VIRTUAL_HEIGHT/2;
		int height = UI.VIRTUAL_WIDTH/2;
		
		viewport = new ExtendViewport(width, height);
				
		Table container = new Table();
		Table table = new Table();
		table.setFillParent(true);
		container.setFillParent(true);
		ScrollPane pane = new ScrollPane(table);
	    stage = new Stage(viewport);
		container.add(pane).width(width).height(height);
	    container.row().fillX();
	    container.setBounds(0,0,width, height);
	    stage.addActor(container);
	    
		for (int i = 1; i <= LevelFactory.TOTALLEVELS; i++) {
			LevelTile tile = new LevelTile(i, game);
			table.add(tile).pad(10);
		}
		Gdx.input.setInputProcessor(stage);

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();

	}

	@Override
	public void resize(int width, int height) {
	    stage.getViewport().update(width, height, false);
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
		stage.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
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
