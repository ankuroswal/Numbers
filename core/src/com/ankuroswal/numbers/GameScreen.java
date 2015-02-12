package com.ankuroswal.numbers;

import com.ankuroswal.Utils.Move;
import com.ankuroswal.numbers.Levels.LevelRenderer;
import com.ankuroswal.numbers.Levels.LevelSave;
import com.ankuroswal.numbers.Levels.LevelUIRenderer;
import com.ankuroswal.numbers.Map.Map;
import com.ankuroswal.numbers.Map.TouchController;
import com.ankuroswal.numbers.Operations.OpQueue;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;

public class GameScreen implements Screen {
	private final Numbers game;
	private OpQueue queue;
	private PlayerRender player;
	private BitmapFont font;
	private LevelRenderer levelrender;
	private SpriteBatch batch;
	private LevelUIRenderer levelUI;
	private Integer level;
	private TouchController touch;

	public GameScreen(final Numbers game, Integer level) {
		this.game = game;
		this.level = level;
		batch = new SpriteBatch();
		font = new BitmapFont();
		queue = new OpQueue();
		levelUI = new LevelUIRenderer(queue, font);
		levelrender = new LevelRenderer(batch);
		levelrender.setLevel(level);
		player = new PlayerRender(Map.getInstance());
		font = new BitmapFont(Gdx.files.internal("opensans.fnt"),
				Gdx.files.internal("opensans.png"), false);
		touch = new TouchController(levelrender.getCamera(), this);
		Gdx.input.setInputProcessor(new GestureDetector(touch));
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		levelrender.render(delta);
		batch.begin();
		player.render(batch, delta);
		batch.end();
		levelUI.render(delta);

	}

	@Override
	public void resize(int width, int height) {
		levelrender.resize();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		levelUI.dispose();
		player.dispose();
		font.dispose();
		batch.dispose();
	}

	public void move(Move move) {
		if (!player.isPlaying()) {
			switch (move) {
			case LEFT:
				queue.useQ(Map.getInstance().playerMove(-1, 0));
				player.move(2);
				break;
			case RIGHT:
				queue.useQ(Map.getInstance().playerMove(1, 0));
				player.move(3);
				break;
			case UP:
				queue.useQ(Map.getInstance().playerMove(0, 1));
				player.move(1);
				break;
			case DOWN:
				queue.useQ(Map.getInstance().playerMove(0, -1));
				player.move(0);
				break;
			case STAY:
				break;
			default:
				break;
			}
		}
		if (Map.getInstance().isStuck()) {
			LevelSave.setLevel(level, queue.getScore());
			LevelSave.save();
			queue.setScore(0);
			queue.startQ(4);
			game.setScreen(new LevelScreen(game));
			dispose();
		}
	}

}
