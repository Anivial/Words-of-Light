package com.anivial.wordsoflight.screens;

import com.anivial.wordsoflight.GameApp;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.math.Vector3;

public class MenuScreen extends ScreenAdapter{
    private GameApp game;

    private Vector3 mouse;

    public MenuScreen(final GameApp game){
        this.game = game;
        mouse = new Vector3();
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown (int x, int y, int pointer, int button) {
                Gdx.input.setInputProcessor(null);
                GameApp.cam.unproject(mouse.set(x, y, 0), GameApp.viewport.getScreenX(), GameApp.viewport.getScreenY(), GameApp.viewport.getScreenWidth(), GameApp.viewport.getScreenHeight());
                return true;
            }
        });
    }

    public void render(float dt){
        GameApp.batch.setProjectionMatrix(GameApp.camUI.combined);
        GameApp.batch.begin();
        GameApp.batch.end();
    }

    public void hide(){
    }

    public void resize(int width, int height) {
        GameApp.viewport.update(width, height);
        GameApp.viewportUI.update(width, height);
    }

}