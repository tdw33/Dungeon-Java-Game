package dev.teamcyan.dungeoncrafter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import dev.teamcyan.dungeoncrafter.DungeonCrafter;


public class MapTestScreen implements Screen, InputProcessor {

    TextureAtlas atlas;
    SpriteBatch batch;
    boolean movingRight = false;
    boolean movingLeft = false;
    boolean movingUp = false;
    boolean movingDown = false;
    Sprite sprite;

    DungeonCrafter game;

    public MapTestScreen (DungeonCrafter game) {
        this.game = game;
    }

    @Override
    public void show() {

        atlas = new TextureAtlas("textures.atlas");

        sprite = new Sprite(atlas.findRegion("tile/wall"));
        sprite.setPosition(0,
                0);

        Gdx.input.setInputProcessor(this);

    }

    @Override
    public void render(float delta) {
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        atlas.dispose();
    }

}
