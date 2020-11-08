package dev.teamcyan.dungeoncrafter;

import Screens.MainGameScreen;

import Screens.MainMenuScreen;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class DungeonCrafter extends Game {


	public static final int WIDTH = 720;
	public static final int HEIGHT = 720;

	public SpriteBatch batch;


	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}




}
