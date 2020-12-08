package dev.teamcyan.dungeoncrafter.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import dev.teamcyan.dungeoncrafter.DungeonCrafter;
import dev.teamcyan.dungeoncrafter.classes.GameModel;


/**
 * Screen is called upon a lost game.
 */
public class GameOverScreen extends BaseScreen {

    /**
     * Setup all the parts of the screen
     * @param controller instance of the DungeonCrafter class
     * @param model instance of the current GameModel class
     */
    public GameOverScreen(final DungeonCrafter controller, GameModel model) {
        super(controller, model);

        Texture backgroundTexture = new Texture("menu_buttons/GameOverBackground.png");
        Image background = new Image(backgroundTexture);
        background.setBounds(0,0,DungeonCrafter.WIDTH, DungeonCrafter.HEIGHT);
        ui.addActor(background);

        final Label.LabelStyle restartStyle = new Label.LabelStyle();
        restartStyle.fontColor = Color.WHITE;
        restartStyle.font = new BitmapFont();
        restartStyle.font.getData().setScale(2f);

        final Label restartLabel = new Label("Restart", restartStyle);
        final Button.ButtonStyle buttonStyle = new Button.ButtonStyle();
        final Button restartButton = new Button(restartLabel, buttonStyle);
        restartButton.setBounds(250,DungeonCrafter.HEIGHT-400,0,0);
        ui.addActor(restartButton);

        restartButton.addListener(new EventListener()
        {
            @Override
            public boolean handle(Event event)
            {
                if (event.toString() == "enter") {
                    restartLabel.setFontScale(3f);
                } else if (event.toString() == "exit") {
                    restartLabel.setFontScale(2f);
                } else if (event.toString() == "touchDown") {
                    controller.restartGame();
                }

                return true;
            }
        });

        final Label.LabelStyle exitStyle = new Label.LabelStyle();
        exitStyle.fontColor = Color.WHITE;
        exitStyle.font = new BitmapFont();
        exitStyle.font.getData().setScale(2f);

        final Label exitLabel = new Label("Menu", exitStyle);
        final Button exitButton = new Button(exitLabel, buttonStyle);
        exitButton.setBounds(DungeonCrafter.WIDTH/2 +100,DungeonCrafter.HEIGHT-400,0,0);
        ui.addActor(exitButton);

        exitButton.addListener(new EventListener()
        {
            @Override
            public boolean handle(Event event)
            {
                if (event.toString() == "enter") {
                    exitLabel.setFontScale(3f);
                } else if (event.toString() == "exit") {
                    exitLabel.setFontScale(2f);
                } else if (event.toString() == "touchDown") {
                    controller.changeScreen(MainMenuScreen.class);
                }

                return true;
            }
        });
    }

    /**
     * implement for initial setups.
     */
    @Override
    public void init() {

    }

    /**
     * Implement for continuous updates of the screen
     * @param delta amount of time that passed since last call
     */
    @Override
    public void draw(float delta) {

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
