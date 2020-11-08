package dev.teamcyan.dungeoncrafter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dev.teamcyan.dungeoncrafter.DungeonCrafter;
import dev.teamcyan.dungeoncrafter.classes.GameModel;

public class MainMenuScreen extends BaseScreen {

    private static final int PLAY_BUTTON_WIDTH = 150;
    private static final int PLAY_BUTTON_HEIGHT = 50;
    private static final int PLAY_BUTTON_Y = 500;
    private static final int LOAD_BUTTON_WIDTH = 150;
    private static final int LOAD_BUTTON_HEIGHT = 50;
    private static final int LOAD_BUTTON_Y = 400;
    private static final int SETTINGS_BUTTON_WIDTH = 150;
    private static final int SETTINGS_BUTTON_HEIGHT = 50;
    private static final int SETTINGS_BUTTON_Y = 300;
    private static final int EXIT_BUTTON_WIDTH = 100;
    private static final int EXIT_BUTTON_HEIGHT = 50;
    private static final int EXIT_BUTTON_Y = 200;



    DungeonCrafter game;
    SpriteBatch batch = new SpriteBatch();


    Texture playButtonActive;
    Texture playButtonInactive;
    Texture loadButtonActive;
    Texture loadButtonInactive;
    Texture settingsButtonActive;
    Texture settingsButtonInactive;
    Texture exitButtonActive;
    Texture exitButtonInactive;

    public MainMenuScreen (DungeonCrafter parent, GameModel model) {
        super(parent, model);
        this.game = parent;
        playButtonActive = new Texture("menu_buttons/new_game_active.png");
        playButtonInactive = new Texture("menu_buttons/new_game_inactive.png");
        loadButtonActive = new Texture("menu_buttons/load_game_active.png");
        loadButtonInactive = new Texture("menu_buttons/load_game_inactive.png");
        settingsButtonActive = new Texture("menu_buttons/settings_active.png");
        settingsButtonInactive = new Texture("menu_buttons/settings_inactive.png");
        exitButtonActive = new Texture("menu_buttons/exit_active.png");
        exitButtonInactive = new Texture("menu_buttons/exit_inactive.png");

    }


    @Override
    public void init() {

    }

    @Override
    public void draw(float delta) {
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.3f, 1);
        //colour range from 0-1 using decimals (must add f after to convert to float)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();


        int play_x = (DungeonCrafter.WIDTH/2)-(PLAY_BUTTON_WIDTH/2);
        int exit_x = (DungeonCrafter.WIDTH/2)-(EXIT_BUTTON_WIDTH/2);

        // newgame
        if(Gdx.input.getX() < play_x + PLAY_BUTTON_WIDTH && Gdx.input.getX() > play_x && DungeonCrafter.HEIGHT - Gdx.input.getY()
                < PLAY_BUTTON_Y + PLAY_BUTTON_HEIGHT &&  DungeonCrafter.HEIGHT - Gdx.input.getY() > PLAY_BUTTON_Y ) {
            batch.draw(playButtonActive,
                    play_x,PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
                if(Gdx.input.isTouched()){
                    this.dispose();
                    controller.changeScreen(MainGameScreen.class);
                }

        } else {
            batch.draw(playButtonInactive,
                    play_x,PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);}


        // load game
        if(Gdx.input.getX() < play_x + LOAD_BUTTON_WIDTH && Gdx.input.getX() > play_x && DungeonCrafter.HEIGHT - Gdx.input.getY()
                < LOAD_BUTTON_Y + LOAD_BUTTON_HEIGHT &&  DungeonCrafter.HEIGHT - Gdx.input.getY() > LOAD_BUTTON_Y) {
            batch.draw(loadButtonActive,
                    play_x,LOAD_BUTTON_Y, LOAD_BUTTON_WIDTH, LOAD_BUTTON_HEIGHT);
            if(Gdx.input.isTouched()){
                this.dispose();
                controller.changeScreen(MainGameScreen.class);}

        } else {
            batch.draw(loadButtonInactive,
                    play_x,LOAD_BUTTON_Y, LOAD_BUTTON_WIDTH, LOAD_BUTTON_HEIGHT);}

        //settings
        if(Gdx.input.getX() < play_x + SETTINGS_BUTTON_WIDTH && Gdx.input.getX() > play_x && DungeonCrafter.HEIGHT - Gdx.input.getY()
                < SETTINGS_BUTTON_Y + SETTINGS_BUTTON_HEIGHT &&  DungeonCrafter.HEIGHT - Gdx.input.getY() > SETTINGS_BUTTON_Y) {
            batch.draw(settingsButtonActive,
                    play_x,SETTINGS_BUTTON_Y, SETTINGS_BUTTON_WIDTH, SETTINGS_BUTTON_HEIGHT);
                if(Gdx.input.isTouched()){
                    this.dispose();
                    controller.changeScreen(SettingsScreen.class);}

        } else {
            batch.draw(settingsButtonInactive,
                    play_x,SETTINGS_BUTTON_Y, SETTINGS_BUTTON_WIDTH, SETTINGS_BUTTON_HEIGHT);}

        // exit
        if(Gdx.input.getX() < exit_x + EXIT_BUTTON_WIDTH && Gdx.input.getX() > exit_x && DungeonCrafter.HEIGHT - Gdx.input.getY() //drawing active/inactive buttons depnding on where the mouse is
                < EXIT_BUTTON_Y + EXIT_BUTTON_HEIGHT &&  DungeonCrafter.HEIGHT - Gdx.input.getY() > EXIT_BUTTON_Y ){
            batch.draw(exitButtonActive,
                    exit_x,EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT );
            if (Gdx.input.isTouched()){  // is mouse is clicked
                Gdx.app.exit();
            }
        } else {
            batch.draw(exitButtonInactive,
                    exit_x,EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT );
        }

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
