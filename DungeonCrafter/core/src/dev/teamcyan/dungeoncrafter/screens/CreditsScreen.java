package dev.teamcyan.dungeoncrafter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Timer;
import dev.teamcyan.dungeoncrafter.DungeonCrafter;
import dev.teamcyan.dungeoncrafter.classes.GameModel;

import java.util.ArrayList;

/**
 * Screen which is called when the game was successfully completed.
 */
public class CreditsScreen extends BaseScreen {

    /**
     * The amount of time the screen is active
     */
    double timeElapsed = 0;
    /**
     * The amount of time the credits are supposed to take to move through window
     */
    int creditLength = 50;
    Label intoTheDarkLabel;
    Label teamCyanLabel;
    Label teamMembersLabel;
    Label creatorsLabel;
    Label thanksForPlayingLabel;
    Button mainMenuButton, exitButton;

    Label exitLabel;

    /**
     * Setup initial credits screen. Initializes all labels.
     * @param controller instance of the DungeonCrafter class
     * @param model instance of the current GameModel class
     */
    public CreditsScreen(final DungeonCrafter controller, GameModel model) {
        super(controller, model);

        Texture backgroundTexture = new Texture("menu_buttons/background.png");
        Image background = new Image(backgroundTexture);
        background.setBounds(0,0,DungeonCrafter.WIDTH, DungeonCrafter.HEIGHT);
        ui.addActor(background);


        // Create font styles for different credit types
        final Label.LabelStyle creditStyle = new Label.LabelStyle();
        creditStyle.fontColor = Color.WHITE;
        creditStyle.font = new BitmapFont();
        creditStyle.font.getData().setScale(2f);

        final Label.LabelStyle teamCyanStyle = new Label.LabelStyle();
        teamCyanStyle.fontColor = Color.WHITE;
        teamCyanStyle.font = new BitmapFont();
        teamCyanStyle.font.getData().setScale(3f);

        final Label.LabelStyle titleStyle = new Label.LabelStyle();;
        titleStyle.fontColor = Color.WHITE;
        titleStyle.font = new BitmapFont();
        titleStyle.font.getData().setScale(4f);

        // Create return to menu and quit buttons
        final Button.ButtonStyle buttonStyle = new Button.ButtonStyle();
        final Label mainMenuLabel = new Label("Main Menu", teamCyanStyle);
        mainMenuButton = new Button(mainMenuLabel, buttonStyle);
        mainMenuButton.setBounds(250,DungeonCrafter.HEIGHT-400,0,0);

        mainMenuButton.addListener(new EventListener()
        {
            @Override
            public boolean handle(Event event)
            {
                if (event.toString() == "enter") {
                    mainMenuLabel.setFontScale(3f);
                } else if (event.toString() == "exit") {
                    mainMenuLabel.setFontScale(2f);
                } else if (event.toString() == "touchDown") {
                    controller.changeScreen(MainMenuScreen.class);
                }

                return true;
            }
        });


        exitLabel = new Label("Quit", teamCyanStyle);
        exitButton = new Button(exitLabel, buttonStyle);

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
                    Gdx.app.exit();
                }

                return true;
            }
        });


        thanksForPlayingLabel = new Label("Thanks For Playing!", teamCyanStyle);
        creatorsLabel = new Label("Creators", teamCyanStyle);
        intoTheDarkLabel = new Label("Into the Dark", titleStyle);
        teamCyanLabel = new Label("Developed by\n Team Cyan", teamCyanStyle);
        teamMembersLabel = new Label("Vlad Posmangiu Luchian \n Julius Martinetz \n He Jiang \n Tom Wells " +
                "\n Yandong Guo \n Lewis Williams \n Samuel Love \n Tianyu Ji", creditStyle);

        teamMembersLabel.setX((super.ui.getWidth() / 2) - (teamMembersLabel.getWidth() / 2));

        intoTheDarkLabel.setX((super.ui.getWidth() / 2) - (intoTheDarkLabel.getWidth() / 2));

        teamCyanLabel.setX((super.ui.getWidth() / 2) - (teamCyanLabel.getWidth() / 2));

        creatorsLabel.setX((super.ui.getWidth() / 2) - (creatorsLabel.getWidth() / 2));

        intoTheDarkLabel.setScale(5f);

        teamMembersLabel.setY(-super.ui.getHeight());
        creatorsLabel.setY(-super.ui.getHeight());
        teamCyanLabel.setY(-super.ui.getHeight());
        intoTheDarkLabel.setY(-super.ui.getHeight());

        thanksForPlayingLabel.setX((super.ui.getWidth() / 2) - (thanksForPlayingLabel.getWidth() / 2));
        thanksForPlayingLabel.setY((super.ui.getHeight() / 2) - (thanksForPlayingLabel.getHeight() / 2));
        thanksForPlayingLabel.setColor(1,1,1, (float) 0);
        mainMenuButton.setColor(1,1,1, (float) 0);
        exitButton.setColor(1,1,1, (float) 0);
        mainMenuButton.setX((super.ui.getWidth() / 4) - (mainMenuButton.getWidth() / 2));
        mainMenuButton.setY((super.ui.getWidth() / (float) 3) - (mainMenuButton.getHeight() / 2));
        exitButton.setX(((super.ui.getWidth() / 4) * 3) - (exitButton.getWidth() / 2));
        exitButton.setY((super.ui.getWidth() / (float) 3) - (exitButton.getHeight() / 2));



        ui.addActor(exitButton);
        ui.addActor(intoTheDarkLabel);
        ui.addActor(teamCyanLabel);
        ui.addActor(creatorsLabel);
        ui.addActor(teamMembersLabel);
        ui.addActor(thanksForPlayingLabel);
        ui.addActor(mainMenuButton);

    }

    /**
     * Create a scheduler which continuously updates a timer. Timer serves as reference for continuous screen
     * updates.
     */
    @Override
    public void init() {
        Timer creditsTimer = new Timer();
        creditsTimer.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                timeElapsed += 0.1;
            }
        }, 0, (float) 0.01, (int) creditLength*100);
    }

    /**
     * Continuously update label positions to create credit lieke moving visualization
     * @param delta amount of time that passed since last call
     */
    @Override
    public void draw(float delta) {

        if(timeElapsed > 10)
            intoTheDarkLabel.setY( (float) (10*(timeElapsed-20)));
        if(timeElapsed > 40)
            teamCyanLabel.setY((float) (10*(timeElapsed-50)));
        if(timeElapsed > 80)
            creatorsLabel.setY((float) (10*(timeElapsed-85)));
        if(timeElapsed > 85)
            teamMembersLabel.setY((float) (10*(timeElapsed-120)));

        // Fade in content at end of credits
        if(timeElapsed > 180)
            thanksForPlayingLabel.setColor(1,1,1, (float) ((timeElapsed-180) / 50));
        if(timeElapsed > 200) {
            mainMenuButton.setColor(1, 1, 1, (float) ((timeElapsed - 200) / 50));
            exitButton.setColor(1, 1, 1, (float) ((timeElapsed - 200) / 50));
        }
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
