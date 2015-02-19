package com.ankuroswal.numbers.Levels;

import com.ankuroswal.numbers.Operations.OpQueue;
import com.ankuroswal.numbers.Utils.UI;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class LevelUIRenderer {
	private Stage stage;
	private Label score;
	private Label operations;
	private Viewport viewport;
	private OpQueue queue;

	public LevelUIRenderer(OpQueue queue, BitmapFont font) {

		int width = 480/3;
		int height = 800/3;
		
		this.queue = queue;
		viewport = new ExtendViewport(width, height);
		Table table = new Table();

		stage = new Stage(viewport);

		font.setScale(1f);
		font.getRegion().getTexture()
				.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		LabelStyle style = new LabelStyle();
		style.fontColor = new Color(1, 1, 1, 1f);
		style.font = font;
		TextureRegionDrawable region = new TextureRegionDrawable();
		region.setRegion(new TextureRegion(new Texture("yellowtile.png"), UI.TILEWIDTH, UI.TILEHEIGHT));
		style.background = region;

		score = new Label(queue.getScore() + "", style);
		operations = new Label(queue.toString(), style);

		table.setFillParent(true);
		table.add(score).width(100).padBottom(height / 2 + 100)
				.padRight(width / 2);
		table.add(operations).width(100).padBottom(height / 2 + 100)
				.padLeft(width / 2 );
		stage.addActor(table);

	}

	public void render(float delta) {
		score.setText(queue.getScore() + "");
		operations.setText(queue.toString());
		stage.act(delta);
		stage.draw();
	}

	public void resize(int width, int height) {
		viewport.update(width, height, true);
	}

	public void dispose() {
		stage.dispose();
	}

}
