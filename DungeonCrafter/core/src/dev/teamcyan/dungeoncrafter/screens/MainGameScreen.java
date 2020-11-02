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
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import java.util.ArrayList;

public class MainGameScreen implements Screen, InputProcessor {

    TextureAtlas atlas;
    SpriteBatch batch;
    boolean movingRight = false;
    boolean movingLeft = false;
    boolean movingUp = false;
    boolean movingDown = false;
    Sprite sprite;
    BitmapFont font;
    ArrayList<String> keyInfo;
    String mouseInfo;


    DungeonCrafter game;

    public MainGameScreen(DungeonCrafter game) {
        this.game = game;
    }

    @Override
    public void show() {

        atlas = new TextureAtlas("textures.atlas");
        sprite = new Sprite(atlas.findRegion("tile/wall"));
        sprite.setPosition(0, 0);
        font = new BitmapFont(Gdx.files.internal("newFont.fnt"),Gdx.files.internal("newFont.png"), false);
        Gdx.input.setInputProcessor(this);
        keyInfo = new ArrayList<String>();
        mouseInfo = "";

    }

    @Override
    public void render(float delta) {
        if(movingRight) {
            sprite.translateX(3f);
        }
        if(movingLeft) {
            sprite.translateX(-3f);
        }
        if(movingUp) {
            sprite.translateY(3f);
        }
        if(movingDown) {
            sprite.translateY(-3f);
        }

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        game.batch.begin();
        game.batch.draw(sprite, sprite.getX(), sprite.getY(), 100,100); // this will be diffrent when you have nummbers at end eg player_1, player_2
        font.setColor(0.5f,0.4f,0,1);   //Brown is an underated Colour
        font.draw(game.batch, mouseInfo, 20, DungeonCrafter.HEIGHT-50);
        font.draw(game.batch, "Mouse XY:", 20, DungeonCrafter.HEIGHT-20);
        font.draw(game.batch, "Keys active:", 100, DungeonCrafter.HEIGHT-20);
        for(int i = 0; i < keyInfo.size(); i++)
        {
            font.draw(game.batch, keyInfo.get(i), 100+(15*i), DungeonCrafter.HEIGHT-50);
        }
        //font.draw(game.batch, keyInfo, 50, DungeonCrafter.HEIGHT-30);
        game.batch.end();
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

    @Override
    public boolean keyDown(int keycode) {
        keyInfo.add(String.valueOf((char) (keycode + 68)));
        if(keycode == Input.Keys.LEFT) {
            movingLeft = true;
        }
        if(keycode == Input.Keys.RIGHT) {
            movingRight = true;
        }
        if(keycode == Input.Keys.UP) {
            movingUp = true;
        }
        if(keycode == Input.Keys.DOWN) {
            movingDown = true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        keyInfo.remove((keyInfo.indexOf(String.valueOf((char) (keycode + 68)))));
        System.out.println((char) (keycode + 68));
        if(keycode == Input.Keys.RIGHT) {
            movingRight = false;
        }

        if(keycode == Input.Keys.LEFT)
            movingLeft = false;

        if(keycode == Input.Keys.UP)
            movingUp = false;

        if(keycode == Input.Keys.DOWN)
            movingDown = false;

        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println("x = " + screenX);
        System.out.println("y = " + screenY);
        sprite.setCenterX(screenX);
        sprite.setCenterY(DungeonCrafter.HEIGHT - screenY);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        mouseInfo = "X = " + String.valueOf(screenX) + "\nY = " + String.valueOf(screenY);
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
