package com.anivial.wordsoflight.utils;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class Assets {
    private AssetManager manager = new AssetManager();

    private static Assets instance = null;

    protected Assets(){
    }

    public static Assets getInstance() {
        if(instance == null) {
            instance = new Assets();
        }
        return instance;
    }

    public void load() {
        /*
        manager.load("sounds/deathsound.ogg", Sound.class);
        manager.load("menu.png", Texture.class);
        manager.load("musics/level4.ogg", Music.class);
        */
    }

    public Texture getTexture(String fileName){
        return manager.get(fileName, Texture.class);
    }

    public Music getMusic(String fileName){
        return manager.get(fileName, Music.class);
    }

    public Sound getSound(String fileName){
        return manager.get(fileName, Sound.class);
    }

    public void finishLoading(){
        manager.finishLoading();
    }

    public void dispose(){
        manager.dispose();
    }
}