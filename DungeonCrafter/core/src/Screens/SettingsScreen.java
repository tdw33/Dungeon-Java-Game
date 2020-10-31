package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import dev.desktop.dungeoncrafter.DungeonCrafter;

public class SettingsScreen implements Screen {

    public static final int SETTINGS_BUTTON_WIDTH = 150;
    public static final int SETTINGS_BUTTON_HEIGHT = 50;
    public static final int SETTINGS_BUTTON_Y = 600;
    public static final int BACK_BUTTON_WIDTH = 50;
    public static final int BACK_BUTTON_HEIGHT = 50;
    public static final int BACK_BUTTON_Y = 650;

    DungeonCrafter game;

    Texture settingsButtonActive;
    Texture settingsButtonInactive;
    Texture backButtonActive;
    Texture backButtonInactive;

    public SettingsScreen (DungeonCrafter game) {
        this.game = game;
        settingsButtonActive = new Texture("menu_buttons/settings_active.png");
        settingsButtonInactive = new Texture("menu_buttons/settings_inactive.png");
        backButtonActive = new Texture("menu_buttons/back_active.png");
        backButtonInactive = new Texture("menu_buttons/back_inactive.png");

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        game.batch.begin();

        int settings_x = (DungeonCrafter.WIDTH/2)-(SETTINGS_BUTTON_WIDTH/2);
        int back_x = 50;

        if(Gdx.input.getX() < settings_x + SETTINGS_BUTTON_WIDTH && Gdx.input.getX() > settings_x && DungeonCrafter.HEIGHT - Gdx.input.getY()
                < SETTINGS_BUTTON_Y + SETTINGS_BUTTON_HEIGHT &&  DungeonCrafter.HEIGHT - Gdx.input.getY() > SETTINGS_BUTTON_Y) {
            game.batch.draw(settingsButtonActive,
                    settings_x,SETTINGS_BUTTON_Y, SETTINGS_BUTTON_WIDTH, SETTINGS_BUTTON_HEIGHT);

        } else {
            game.batch.draw(settingsButtonInactive,
                    settings_x,SETTINGS_BUTTON_Y, SETTINGS_BUTTON_WIDTH, SETTINGS_BUTTON_HEIGHT);}

        // back arrow
        if(Gdx.input.getX() < settings_x + BACK_BUTTON_WIDTH && Gdx.input.getX() > back_x && DungeonCrafter.HEIGHT - Gdx.input.getY()
                < BACK_BUTTON_Y + BACK_BUTTON_HEIGHT &&  DungeonCrafter.HEIGHT - Gdx.input.getY() > BACK_BUTTON_Y) {
            game.batch.draw(backButtonActive,
                    back_x,BACK_BUTTON_Y, BACK_BUTTON_WIDTH, BACK_BUTTON_HEIGHT);
            if(Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new MainMenuScreen(game));}
        } else {
            game.batch.draw(backButtonInactive,
                    back_x,BACK_BUTTON_Y, BACK_BUTTON_WIDTH, BACK_BUTTON_HEIGHT);}

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

    }
}
