package com.ankuroswal.numbers.Operations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class OperationActor extends Actor {
	private final BitmapFont font;

	public OperationActor()
	{
		font = new BitmapFont(Gdx.files.internal("opensans.fnt"),
				Gdx.files.internal("opensans.png"), false);
		font.getRegion().getTexture()
				.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	}
	@Override
	public void draw(Batch batch, float parentAlpha) {
		
	
	}
	
}
