package com.ankuroswal.numbers.Levels;

import com.ankuroswal.numbers.GameScreen;
import com.ankuroswal.numbers.Numbers;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class LevelTile extends Actor {

	private TextureRegion region;
	private BitmapFont font;
	private Level level;
	private int id;

	public LevelTile(final int id, final Numbers game) {
		this.id = id;
		level = LevelFactory.getLevel(id);
		region = new TextureRegion(LevelConverter.convertLeveltoTexture(level));
		font = new BitmapFont();
		font.getRegion().getTexture()
		.setFilter(TextureFilter.Linear, TextureFilter.Linear);

        setBounds(getX(),getY(), region.getRegionWidth(), region.getRegionHeight());
        
        this.addListener(new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int buttons){
            	game.setScreen(new GameScreen(game, id));
            	return true;
            }
        });
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		font.draw(batch, LevelSave.getLevel(id) + "", getX(), getY() + region.getRegionHeight() + 30);
		batch.draw(region, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(),
                getScaleX(), getScaleY(), getRotation());
	}
	
	public Level getLevel()
	{
		return level;
	}
	
	public int getID() {
		return id;
	}
}