package com.ankuroswal.numbers.Levels;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class LevelUIRenderer {
	private Stage stage;

	public LevelUIRenderer()
	{
	    stage = new Stage(new ScreenViewport());
	    Actor actor = new Actor();		
	    stage.addActor(actor);
	}
	public void render(float delta) {
		stage.act(delta);
		stage.draw();
	}

	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);

	}

	public void dispose() {
		stage.dispose();
	}
}
