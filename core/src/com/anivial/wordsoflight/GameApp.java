package com.anivial.wordsoflight;

import com.anivial.wordsoflight.utils.Assets;
import com.anivial.wordsoflight.utils.Dictionary;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameApp extends Game {
	public static final String TITLE = "Words of Light";

	public static final int WIDTH = 1080;
	public static final int HEIGHT = 1920;
	public static OrthographicCamera cam;
	public static OrthographicCamera camUI;
	public static Viewport viewport;
	public static Viewport viewportUI;
	public static SpriteBatch batch;
	public static Preferences save;

	@Override
	public void create () {
		Gdx.input.setCatchBackKey(true);

		Assets.getInstance().load();
		Assets.getInstance().finishLoading();

		save = Gdx.app.getPreferences("save");
		cam = new OrthographicCamera();
		cam.position.set(GameApp.WIDTH / 2f, GameApp.HEIGHT / 2f, 0);
		viewport = new FitViewport(GameApp.WIDTH, GameApp.HEIGHT, cam);

		camUI = new OrthographicCamera();
		camUI.position.set(GameApp.WIDTH / 2f, GameApp.HEIGHT / 2f, 0);
		viewportUI = new FitViewport(GameApp.WIDTH, GameApp.HEIGHT, camUI);

		batch = new SpriteBatch();
		Gdx.gl.glClearColor(0, 0, 0, 1);

		Dictionary.getInstance().test();

		//setScreen(new MenuScreen(this));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}

	@Override
	public void dispose () {
		batch.dispose();
		Assets.getInstance().dispose();
	}
}
