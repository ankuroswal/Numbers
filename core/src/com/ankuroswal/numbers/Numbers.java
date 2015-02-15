package com.ankuroswal.numbers;

import com.ankuroswal.numbers.Google.IActivityRequestHandler;
import com.ankuroswal.numbers.Levels.LevelSave;
import com.badlogic.gdx.Game;

public class Numbers extends Game {

	private IActivityRequestHandler myRequestHandler;

	public Numbers(IActivityRequestHandler handler) {
		handler.showAds(false);
		myRequestHandler = handler;
	}

	public void create() {
		LevelSave.load();
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	public IActivityRequestHandler getMyRequestHandler() {
		return myRequestHandler;
	}
}
