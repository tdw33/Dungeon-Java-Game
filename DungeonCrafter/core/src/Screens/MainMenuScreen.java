package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import dev.desktop.dungeoncrafter.DungeonCrafter;

public class MainMenuScreen implements Screen {

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


    Texture playButtonActive;
    Texture playButtonInactive;
    Texture loadButtonActive;
    Texture loadButtonInactive;
    Texture settingsButtonActive;
    Texture settingsButtonInactive;
    Texture exitButtonActive;
    Texture exitButtonInactive;

    public MainMenuScreen (DungeonCrafter game) {
        this.game = game;
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
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.3f, 1);
        //colour range from 0-1 using decimals (must add f after to convert to float)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();


        int play_x = (DungeonCrafter.WIDTH/2)-(PLAY_BUTTON_WIDTH/2);
        int exit_x = (DungeonCrafter.WIDTH/2)-(EXIT_BUTTON_WIDTH/2);

        // newgame
        if(Gdx.input.getX() < play_x + PLAY_BUTTON_WIDTH && Gdx.input.getX() > play_x && DungeonCrafter.HEIGHT - Gdx.input.getY()
                < PLAY_BUTTON_Y + PLAY_BUTTON_HEIGHT &&  DungeonCrafter.HEIGHT - Gdx.input.getY() > PLAY_BUTTON_Y ) {
            game.batch.draw(playButtonActive,
                    play_x,PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
                if(Gdx.input.isTouched()){
                    this.dispose();
                    game.setScreen(new MainGameScreen(game));}

        } else {
            game.batch.draw(playButtonInactive,
                    play_x,PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);}


        // load game
        if(Gdx.input.getX() < play_x + LOAD_BUTTON_WIDTH && Gdx.input.getX() > play_x && DungeonCrafter.HEIGHT - Gdx.input.getY()
                < LOAD_BUTTON_Y + LOAD_BUTTON_HEIGHT &&  DungeonCrafter.HEIGHT - Gdx.input.getY() > LOAD_BUTTON_Y) {
            game.batch.draw(loadButtonActive,
                    play_x,LOAD_BUTTON_Y, LOAD_BUTTON_WIDTH, LOAD_BUTTON_HEIGHT);


        } else {
            game.batch.draw(loadButtonInactive,
                    play_x,LOAD_BUTTON_Y, LOAD_BUTTON_WIDTH, LOAD_BUTTON_HEIGHT);}

        //settings
        if(Gdx.input.getX() < play_x + SETTINGS_BUTTON_WIDTH && Gdx.input.getX() > play_x && DungeonCrafter.HEIGHT - Gdx.input.getY()
                < SETTINGS_BUTTON_Y + SETTINGS_BUTTON_HEIGHT &&  DungeonCrafter.HEIGHT - Gdx.input.getY() > SETTINGS_BUTTON_Y) {
            game.batch.draw(settingsButtonActive,
                    play_x,SETTINGS_BUTTON_Y, SETTINGS_BUTTON_WIDTH, SETTINGS_BUTTON_HEIGHT);

        } else {
            game.batch.draw(settingsButtonInactive,
                    play_x,SETTINGS_BUTTON_Y, SETTINGS_BUTTON_WIDTH, SETTINGS_BUTTON_HEIGHT);}

        // exit
        if(Gdx.input.getX() < exit_x + EXIT_BUTTON_WIDTH && Gdx.input.getX() > exit_x && DungeonCrafter.HEIGHT - Gdx.input.getY() //drawing active/inactive buttons depnding on where the mouse is
                < EXIT_BUTTON_Y + EXIT_BUTTON_HEIGHT &&  DungeonCrafter.HEIGHT - Gdx.input.getY() > EXIT_BUTTON_Y ){
            game.batch.draw(exitButtonActive,
                    exit_x,EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT );
            if (Gdx.input.isTouched()){  // is mouse is clicked
                Gdx.app.exit();
            }
        } else {
            game.batch.draw(exitButtonInactive,
                    exit_x,EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT );
        }

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
