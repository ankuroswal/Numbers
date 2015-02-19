package com.ankuroswal.numbers.Levels;

import com.ankuroswal.numbers.External.LevelDirectory;
import com.ankuroswal.numbers.Map.Map;
import com.ankuroswal.numbers.Node.NodeLayer;
import com.ankuroswal.numbers.Node.NodeRender;
import com.ankuroswal.numbers.Utils.UI;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

public class LevelRenderer {
	private TiledMap tiledMap;
	private OrthographicCamera camera;
	private TiledMapRenderer tiledMapRenderer;
	private Batch batch;

	public LevelRenderer(Batch batch) {
		this.batch = batch;
		camera = new OrthographicCamera();
	}

	public void setLevel(int id) {
		// setup the map
		tiledMap = new TiledMap();
		Level level = LevelDirectory.getInstance().getLevel(id);
		Map.getInstance().setLevel(level);
		tiledMap.getLayers().add(Map.getInstance().getNodeLayer());
		tiledMapRenderer = new NodeRender(tiledMap, 1.0f, batch);
		camera.frustum.boundsInFrustum(createBoundingBox());

	}

	public void render(float delta) {
		camera.update();
		batch.setProjectionMatrix(camera.combined);

		tiledMapRenderer.setView(camera);
		tiledMapRenderer.render();
	}

	public void resize() {
		// set up camera
		int maxOrtho = Math.max(Map.getInstance().getWidth(), Map.getInstance()
				.getHeight());
		camera.setToOrtho(false, maxOrtho * UI.TILESIZE, maxOrtho * UI.TILESIZE);
		NodeLayer layer = Map.getInstance().getNodeLayer();

		// center camera
		Vector3 center = new Vector3(layer.getWidth() * layer.getTileWidth()
				/ 2, layer.getHeight() * layer.getTileHeight() / 2, 0);
		camera.position.set(center);
		camera.zoom = 1.1f;
	}

	public OrthographicCamera getCamera() {
		return camera;
	}

	private BoundingBox createBoundingBox() {
		Vector3 max = new Vector3(Map.getInstance().getWidth() * UI.TILEWIDTH,
				Map.getInstance().getHeight() * UI.TILEHEIGHT, 0);
		
		Vector3 min = new Vector3(0, 0 ,0);
		
		return new BoundingBox(min, max);
	}
}
