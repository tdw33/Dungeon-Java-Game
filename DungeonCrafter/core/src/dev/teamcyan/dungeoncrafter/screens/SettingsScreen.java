package dev.teamcyan.dungeoncrafter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dev.teamcyan.dungeoncrafter.DungeonCrafter;
import dev.teamcyan.dungeoncrafter.classes.GameModel;

public class SettingsScreen extends BaseScreen {

    public static final int SETTINGS_BUTTON_WIDTH = 150;
    public static final int SETTINGS_BUTTON_HEIGHT = 50;
    public static final int SETTINGS_BUTTON_Y = 600;
    public static final int BACK_BUTTON_WIDTH = 50;
    public static final int BACK_BUTTON_HEIGHT = 50;
    public static final int BACK_BUTTON_Y = 650;

    DungeonCrafter game;
    SpriteBatch batch = new SpriteBatch();

    Texture settingsButtonActive;
    Texture settingsButtonInactive;
    Texture backButtonActive;
    Texture backButtonInactive;

    public SettingsScreen (DungeonCrafter parent, GameModel model) {
        super(parent, model);
        this.game = parent;
        settingsButtonActive = new Texture("menu_buttons/settings_active.png");
        settingsButtonInactive = new Texture("menu_buttons/settings_inactive.png");
        backButtonActive = new Texture("menu_buttons/back_active.png");
        backButtonInactive = new Texture("menu_buttons/back_inactive.png");

    }

    @Override
    public void init() {

    }

    @Override
    public void draw(float delta) {
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        batch.begin();

        int settings_x = (DungeonCrafter.WIDTH/2)-(SETTINGS_BUTTON_WIDTH/2);
        int back_x = 50;

        if(Gdx.input.getX() < settings_x + SETTINGS_BUTTON_WIDTH && Gdx.input.getX() > settings_x && DungeonCrafter.HEIGHT - Gdx.input.getY()
                < SETTINGS_BUTTON_Y + SETTINGS_BUTTON_HEIGHT &&  DungeonCrafter.HEIGHT - Gdx.input.getY() > SETTINGS_BUTTON_Y) {
            batch.draw(settingsButtonActive,
                    settings_x,SETTINGS_BUTTON_Y, SETTINGS_BUTTON_WIDTH, SETTINGS_BUTTON_HEIGHT);

        } else {
            batch.draw(settingsButtonInactive,
                    settings_x,SETTINGS_BUTTON_Y, SETTINGS_BUTTON_WIDTH, SETTINGS_BUTTON_HEIGHT);}

        // back arrow
        if(Gdx.input.getX() < settings_x + BACK_BUTTON_WIDTH && Gdx.input.getX() > back_x && DungeonCrafter.HEIGHT - Gdx.input.getY()
                < BACK_BUTTON_Y + BACK_BUTTON_HEIGHT &&  DungeonCrafter.HEIGHT - Gdx.input.getY() > BACK_BUTTON_Y) {
            batch.draw(backButtonActive,
                    back_x,BACK_BUTTON_Y, BACK_BUTTON_WIDTH, BACK_BUTTON_HEIGHT);
            if(Gdx.input.isTouched()){
                this.dispose();
                controller.changeScreen(MainMenuScreen.class);}
        } else {
            batch.draw(backButtonInactive,
                    back_x,BACK_BUTTON_Y, BACK_BUTTON_WIDTH, BACK_BUTTON_HEIGHT);}

        batch.end();
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

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
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
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
