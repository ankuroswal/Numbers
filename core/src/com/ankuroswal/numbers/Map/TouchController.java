package com.ankuroswal.numbers.Map;

import com.ankuroswal.Utils.Move;
import com.ankuroswal.Utils.UI;
import com.ankuroswal.numbers.GameScreen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class TouchController implements GestureListener {
	private OrthographicCamera camera;
	private GameScreen gameScreen;

	public TouchController(OrthographicCamera camera, GameScreen gameScreen) {
		this.camera = camera;
		this.gameScreen = gameScreen;
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		Vector3 touchPos = new Vector3(x, y, 0);
		camera.unproject(touchPos);
		touchPos.x = (int) touchPos.x / UI.TILEWIDTH;
		touchPos.y = (int) touchPos.y / UI.TILEHEIGHT;

		int playerX = Map.getInstance().getPlayer().x;
		int playerY = Map.getInstance().getPlayer().y;

		Move direction = Move.STAY;

		if (playerX < touchPos.x && playerY == touchPos.y)
			direction = Move.RIGHT;
		else if (playerX > touchPos.x && playerY == touchPos.y)
			direction = Move.LEFT;
		else if (playerY < touchPos.y && playerX == touchPos.x)
			direction = Move.UP;
		else if (playerY > touchPos.y && playerX == touchPos.x)
			direction = Move.DOWN;

		gameScreen.move(direction);
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {

		Vector2 vector = new Vector2(-deltaX * .5f, deltaY * .5f);

		camera.translate(vector);

		// don't let camera get out of bounds
		camera.position.x = Math.min(Map.getInstance().getWidth()
				* UI.TILEWIDTH, camera.position.x);
		camera.position.y = Math.min(Map.getInstance().getHeight()
				* UI.TILEHEIGHT, camera.position.y);
		camera.position.x = Math.max(0, camera.position.x);
		camera.position.y = Math.max(0, camera.position.y);

		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		float zoomAmount = (initialDistance - distance) * .01f;
		if (zoomAmount < .5f)
			zoomAmount = .5f;
		else if (zoomAmount > 1.7)
			zoomAmount = 1.7f;
		camera.zoom = zoomAmount;
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		return false;
	}

}
