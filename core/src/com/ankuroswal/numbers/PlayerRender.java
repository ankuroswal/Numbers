package com.ankuroswal.numbers;

import com.ankuroswal.Utils.UI;
import com.ankuroswal.numbers.Map.Map;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;

public class PlayerRender {

	private Vector2 currentPos;
	private Vector2 target;
	
	private Map map;
	private float rotate;
	private Animation walkAnimation;
	private Texture walkSheet;

	private TextureRegion[] Left = new TextureRegion[2];
	private TextureRegion[] Right = new TextureRegion[2];
	private TextureRegion[] Up = new TextureRegion[2];
	private TextureRegion[] Down = new TextureRegion[2];
	private TextureRegion[] Current = new TextureRegion[2];

	TextureRegion currentFrame;
	float stateTime;

	private Boolean play;

	public PlayerRender(Map map) {
		currentPos = convertPosition(map.getPlayer().x, map.getPlayer().y);
		rotate = 0;
	
		this.map = map;
		this.play = false;
		walkSheet = new Texture(Gdx.files.internal("alienSpriteSheet.png"));
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
		walkAnimation = new Animation(0.1f, Current);
		stateTime = 0f;
	}

	private void changeCurrent(TextureRegion[] tmp) {

		for (int i = 0; i < tmp.length; i++) {
			Current[i] = tmp[i];
		}
	}

	public void render(SpriteBatch batch, float deltaTime) {
		if (play) {
			stateTime += deltaTime;
			currentPos.interpolate(target, .28f, Interpolation.fade);

			if (currentPos.epsilonEquals(target, 1))
			{
				play = false;
			}
		}		
		currentFrame = walkAnimation.getKeyFrame(stateTime, true);
		batch.draw(currentFrame, currentPos.x, currentPos.y, currentPos.x, currentPos.y,
				currentFrame.getRegionWidth(), currentFrame.getRegionHeight(),
				1, 1, rotate);

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
		target = convertPosition(map.getPlayer().x, map.getPlayer().y);
		play = true;
	}

	private Vector2 convertPosition(int x, int y) {
		return new Vector2(x * UI.TILEWIDTH, y * UI.TILEHEIGHT);
	}

	public boolean isPlaying() {
		return play;
	}
	
	public void dispose()
	{
		walkSheet.dispose();
	}

}
