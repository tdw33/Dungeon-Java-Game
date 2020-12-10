package dev.teamcyan.dungeoncrafter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dev.teamcyan.dungeoncrafter.DungeonCrafter;
import dev.teamcyan.dungeoncrafter.classes.GameModel;

/**
 * Displays the main menu.
 */
public class MainMenuScreen extends BaseScreen {

    // The size and position of the four buttons
    private static final int PLAY_BUTTON_WIDTH = DungeonCrafter.WIDTH/24*5;
    private static final int PLAY_BUTTON_HEIGHT = DungeonCrafter.HEIGHT/72*3;
    private static final int PLAY_BUTTON_X = DungeonCrafter.WIDTH/12;
    private static final int PLAY_BUTTON_Y = DungeonCrafter.HEIGHT/3;

    private static final int LOAD_BUTTON_WIDTH = DungeonCrafter.WIDTH/24*5;
    private static final int LOAD_BUTTON_HEIGHT = DungeonCrafter.HEIGHT/72*3;
    private static final int LOAD_BUTTON_X = DungeonCrafter.WIDTH/12*4;
    private static final int LOAD_BUTTON_Y = DungeonCrafter.HEIGHT/3;

    private static final int SETTINGS_BUTTON_WIDTH = DungeonCrafter.WIDTH/24*5;
    private static final int SETTINGS_BUTTON_HEIGHT = DungeonCrafter.HEIGHT/72*3;
    private static final int SETTINGS_BUTTON_X = DungeonCrafter.WIDTH/12*7;
    private static final int SETTINGS_BUTTON_Y = DungeonCrafter.HEIGHT/3;

    private static final int EXIT_BUTTON_WIDTH = DungeonCrafter.WIDTH/9;
    private static final int EXIT_BUTTON_HEIGHT = DungeonCrafter.HEIGHT/72*3;
    private static final int EXIT_BUTTON_X = DungeonCrafter.WIDTH/12*10;
    private static final int EXIT_BUTTON_Y = DungeonCrafter.HEIGHT/3;

    DungeonCrafter game;
    SpriteBatch batch = new SpriteBatch();


    Texture playButtonActive;
    Texture playButtonInactive;
    Texture loadButtonActive;
    Texture loadButtonInactive;
    Texture loadButtonUnable;
    Texture settingsButtonActive;
    Texture settingsButtonInactive;
    Texture exitButtonActive;
    Texture exitButtonInactive;
    Texture menuBackground;

    /**
     * Initializes the textures of the screen
     * @param parent instance of the DungeonCrafter class
     * @param model instance of the current GameModel class
     */
    public MainMenuScreen (DungeonCrafter parent, GameModel model) {
        super(parent, model);
        this.game = parent;
        playButtonActive = new Texture("menu_buttons/new_game_active.png");
        playButtonInactive = new Texture("menu_buttons/new_game_inactive.png");
        loadButtonActive = new Texture("menu_buttons/load_game_active.png");
        loadButtonInactive = new Texture("menu_buttons/load_game_inactive.png");
        loadButtonUnable = new Texture("menu_buttons/load_game_unable.png");
        settingsButtonActive = new Texture("menu_buttons/settings_active.png");
        settingsButtonInactive = new Texture("menu_buttons/settings_inactive.png");
        exitButtonActive = new Texture("menu_buttons/exit_active.png");
        exitButtonInactive = new Texture("menu_buttons/exit_inactive.png");
        menuBackground = new Texture("menu_buttons/menuBackground.png");

    }


    /**
     * Update background music
     */
    @Override
    public void init() {
        super.controller.audioManager.startMusic(super.controller.audioManager.menuSound, 40);
        super.controller.audioManager.stopMusic(super.controller.audioManager.ambients);
    }

    /**
     * Continuous screen setup
     * @param delta amount of time that passed since last call
     */
    @Override
    public void draw(float delta) {
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.3f, 1);
        //colour range from 0-1 using decimals (must add f after to convert to float)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        // menu background
        batch.draw(menuBackground, 0, 0, DungeonCrafter.WIDTH, DungeonCrafter.HEIGHT);

        // new game
        if(Gdx.input.getX() < PLAY_BUTTON_X + PLAY_BUTTON_WIDTH && Gdx.input.getX() > PLAY_BUTTON_X && DungeonCrafter.HEIGHT - Gdx.input.getY()
                < PLAY_BUTTON_Y + PLAY_BUTTON_HEIGHT &&  DungeonCrafter.HEIGHT - Gdx.input.getY() > PLAY_BUTTON_Y ) {
            batch.draw(playButtonActive,
                    PLAY_BUTTON_X,PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
                if(Gdx.input.isTouched()){
                    this.dispose();
                    controller.restartGame();
                }

        } else {
            batch.draw(playButtonInactive,
                    PLAY_BUTTON_X,PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);}


        // load game
        batch.draw(loadButtonUnable, LOAD_BUTTON_X,LOAD_BUTTON_Y, LOAD_BUTTON_WIDTH, LOAD_BUTTON_HEIGHT);
        if (model.isActive()) {
            if(Gdx.input.getX() < LOAD_BUTTON_X + LOAD_BUTTON_WIDTH && Gdx.input.getX() > LOAD_BUTTON_X && DungeonCrafter.HEIGHT - Gdx.input.getY()
                    < LOAD_BUTTON_Y + LOAD_BUTTON_HEIGHT &&  DungeonCrafter.HEIGHT - Gdx.input.getY() > LOAD_BUTTON_Y) {
                batch.draw(loadButtonActive,
                        LOAD_BUTTON_X,LOAD_BUTTON_Y, LOAD_BUTTON_WIDTH, LOAD_BUTTON_HEIGHT);
                if(Gdx.input.isTouched()){
                    this.dispose();
                    controller.audioManager.startMusic(controller.audioManager.ambients, 20);
                    controller.changeScreen(MainGameScreen.class);}

            } else {
                batch.draw(loadButtonInactive,
                        LOAD_BUTTON_X,LOAD_BUTTON_Y, LOAD_BUTTON_WIDTH, LOAD_BUTTON_HEIGHT);}
        }


        //settings
        if(Gdx.input.getX() < SETTINGS_BUTTON_X + SETTINGS_BUTTON_WIDTH && Gdx.input.getX() > SETTINGS_BUTTON_X && DungeonCrafter.HEIGHT - Gdx.input.getY()
                < SETTINGS_BUTTON_Y + SETTINGS_BUTTON_HEIGHT &&  DungeonCrafter.HEIGHT - Gdx.input.getY() > SETTINGS_BUTTON_Y) {
            batch.draw(settingsButtonActive,
                    SETTINGS_BUTTON_X,SETTINGS_BUTTON_Y, SETTINGS_BUTTON_WIDTH, SETTINGS_BUTTON_HEIGHT);
                if(Gdx.input.isTouched()){
                    //this.dispose();
                    controller.changeScreen(SettingsScreen.class);}

        } else {
            batch.draw(settingsButtonInactive,
                    SETTINGS_BUTTON_X,SETTINGS_BUTTON_Y, SETTINGS_BUTTON_WIDTH, SETTINGS_BUTTON_HEIGHT);}

        // exit
        if(Gdx.input.getX() < EXIT_BUTTON_X + EXIT_BUTTON_WIDTH && Gdx.input.getX() > EXIT_BUTTON_X && DungeonCrafter.HEIGHT - Gdx.input.getY() //drawing active/inactive buttons depnding on where the mouse is
                < EXIT_BUTTON_Y + EXIT_BUTTON_HEIGHT &&  DungeonCrafter.HEIGHT - Gdx.input.getY() > EXIT_BUTTON_Y ){
            batch.draw(exitButtonActive,
                    EXIT_BUTTON_X,EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT );
            if (Gdx.input.isTouched()){  // is mouse is clicked
                Gdx.app.exit();
            }
        } else {
            batch.draw(exitButtonInactive,
                    EXIT_BUTTON_X,EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT );
        }

            batch.end();
    }

    /**
     * Implement for keyboard inputs. Called immediately on key presses.
     * @param keycode the code of the key that was clicked. One of Input.Keys.
     * @return boolean whether the input was processed
     */
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    /**
     * Implement for keyboard inputs. Called immediately on key releases.
     * @param keycode the code of the key that was clicked. One of Input.Keys.
     * @return boolean whether the input was processed
     */
    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    /**
     * Implement for keyboard inputs. Called when a key was typed.
     * @param character the character that was typed
     * @return boolean whether the input was processed
     */
    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    /**
     * Implement for screen clicks or touches. Called immediately on screen press.
     * @param screenX x-coordinate of the click. Origin is in the upper left corner.
     * @param screenY y-coordinate of the click. Origin is in the upper left corner.
     * @param pointer the pointer for the event.
     * @param button the button for the event.
     * @return boolean whether the input was processed
     */
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    /**
     * Implement for screen clicks or touches. Called immediately on screen release.
     * @param screenX x-coordinate of the click. Origin is in the upper left corner.
     * @param screenY y-coordinate of the click. Origin is in the upper left corner.
     * @param pointer the pointer for the event.
     * @param button the button for the event.
     * @return boolean whether the input was processed
     */
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    /**
     * Implement for screen clicks or touches. Called when mouse or finger was dragged.
     * @param screenX x-coordinate of the event. Origin is in the upper left corner.
     * @param screenY y-coordinate of the event. Origin is in the upper left corner.
     * @param pointer the pointer for the event.
     * @return boolean whether the input was processed
     */
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    /**
     * Called when the mouse was moved without any buttons being pressed. Will not be called on iOS.
     * @param screenX x-coordinate of the event. Origin is in the upper left corner.
     * @param screenY y-coordinate of the event. Origin is in the upper left corner.
     * @return boolean whether the input was processed
     */
    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    /**
     * Called when the mouse wheel was scrolled.
     * @param amount the amount the wheel was scrolled
     * @return boolean whether the input was processed
     */
    @Override
    public boolean scrolled(int amount) {
        return false;
    }


    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    /**
     * Flush all stateful data.
     */
    @Override
    public void hide() {

    }
}
