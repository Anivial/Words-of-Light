package com.anivial.wordsoflight.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.anivial.wordsoflight.GameApp;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = GameApp.TITLE;
		config.width = GameApp.WIDTH;
		config.height = GameApp.HEIGHT;
		new LwjglApplication(new GameApp(), config);
	}
}
