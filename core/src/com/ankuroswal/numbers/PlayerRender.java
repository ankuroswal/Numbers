package com.ankuroswal.numbers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;

public class PlayerRender {

	private Vector2 currentpos;
	private Map map;

	Animation walkAnimation; // #3
	Texture walkSheet; // #4
	
	Interpolation interpolate;
	
	TextureRegion[] Left = new TextureRegion[2];
	TextureRegion[] Right = new TextureRegion[2];
	TextureRegion[] Up = new TextureRegion[2];
	TextureRegion[] Down = new TextureRegion[2];
	TextureRegion[] Current = new TextureRegion[2];

	TextureRegion currentFrame; // #7
	float stateTime; // #8

	private Boolean play;

	PlayerRender(Map map) {
		currentpos = convertPosition(map.getPlayer().x, map.getPlayer().y);
		this.map = map;
		this.play = false;
		walkSheet = new Texture(Gdx.files.internal("alienSpriteSheet.png")); // #9
		TextureRegion[][] tmp = TextureRegion.split(walkSheet, 32, 32);

		int index = 0;
		for (int i = 0; i < 2; i++) {
			Down[index] = tmp[0][i];
			Right[index] = tmp[1][i];
			Left[index] = tmp[2][i];
			Up[index] = tmp[3][i];
			index++;
		}
		changeCurrent(Up);
		walkAnimation = new Animation(0.25f, Current); // #11
		stateTime = 0f;
	}

	private void changeCurrent(TextureRegion[] tmp) {
		for (int i = 0; i < tmp.length; i++) {
			Current[i] = tmp[i];
		}
	}

	public void render(SpriteBatch batch, float deltaTime) {
		stateTime += deltaTime;
		if(play){
			
		}
		currentFrame = walkAnimation.getKeyFrame(stateTime, true);
		Vector2 temp = convertPosition(map.getPlayer().x, map.getPlayer().y);
		batch.draw(currentFrame, temp.x, temp.y); // #17

	}

	public void move(int direction) {
		if (direction == 0) {
			changeCurrent(Down);
		} else if (direction == 1) {
			changeCurrent(Up);
		} else if (direction == 2) {
			changeCurrent(Left);
		} else if (direction == 3) {
			changeCurrent(Right);
		}
	}

	private Vector2 convertPosition(int x, int y) {
		return new Vector2(x * UIVars.TSize + UIVars.TdX, y * UIVars.TSize
				+ UIVars.TdY + 64);
	}

	public boolean isPlaying() {
		return play;
	}

}
