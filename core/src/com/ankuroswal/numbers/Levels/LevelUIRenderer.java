package com.ankuroswal.numbers.Levels;

import com.ankuroswal.numbers.Operations.OpQueue;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class LevelUIRenderer {
	private Stage stage;
	private Label score;
	private Label operations;
	
	private OpQueue queue;

	public LevelUIRenderer(OpQueue queue, BitmapFont font) {
		int width = Gdx.graphics.getWidth();
		int height = Gdx.graphics.getHeight();
		this.queue = queue;

		stage = new Stage(new ScreenViewport());
		LabelStyle style = new LabelStyle();
		style.font = font;
		score = new Label(queue.getScore() + "", style);
		operations = new Label(queue.toString(), style);

		score.setCenterPosition(20, height - 20);
		operations.setCenterPosition(width/2, height - 20);
	
		stage.addActor(score);
		stage.addActor(operations);

	}

	public void render(float delta) {
		score.setText(queue.getScore() + "");
		operations.setText(queue.toString());
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
