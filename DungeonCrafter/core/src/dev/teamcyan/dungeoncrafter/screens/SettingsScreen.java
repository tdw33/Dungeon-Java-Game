package dev.teamcyan.dungeoncrafter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import dev.teamcyan.dungeoncrafter.DungeonCrafter;
import dev.teamcyan.dungeoncrafter.classes.GameModel;

/**
 * Displays settings and controls.
 */
public class SettingsScreen extends BaseScreen {

    public static final int SETTINGS_BUTTON_WIDTH = 170;
    public static final int SETTINGS_BUTTON_HEIGHT = 50;
    public static final int SETTINGS_BUTTON_Y = 600;
    public static final int BACK_BUTTON_WIDTH = 70;
    public static final int BACK_BUTTON_HEIGHT = 40;
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

        int leftAlign = 80;
        int rightAlign = DungeonCrafter.WIDTH/2;

        final Label.LabelStyle style1 = new Label.LabelStyle();
        style1.fontColor = Color.WHITE;
        style1.font = new BitmapFont();
        style1.font.getData().setScale(3f);

        final Label gameOver = new Label("Controls:", style1);
        gameOver.setBounds(leftAlign,DungeonCrafter.HEIGHT-300,200,200);
        ui.addActor(gameOver);

        final Label.LabelStyle style = new Label.LabelStyle();
        style.fontColor = Color.WHITE;
        style.font = new BitmapFont();
        style.font.getData().setScale(2f);


        final Label digLeft = new Label("Dig left:   A", style);
        digLeft.setBounds(leftAlign,DungeonCrafter.HEIGHT-400,200,200);
        ui.addActor(digLeft);

        final Label digCenter = new Label("Dig center:   S", style);
        digCenter.setBounds(leftAlign,DungeonCrafter.HEIGHT-450,200,200);
        ui.addActor(digCenter);

        final Label digRight = new Label("Dig right:   D", style);
        digRight.setBounds(leftAlign,DungeonCrafter.HEIGHT-500,200,200);
        ui.addActor(digRight);

        final Label placeLeft = new Label("Place left:   Q", style);
        placeLeft.setBounds(leftAlign,DungeonCrafter.HEIGHT-550,200,200);
        ui.addActor(placeLeft);

        final Label placeRight = new Label("Place right:   E", style);
        placeRight.setBounds(leftAlign,DungeonCrafter.HEIGHT-600,200,200);
        ui.addActor(placeRight);

        final Label moveLeft = new Label("Move left:   left arrow", style);
        moveLeft.setBounds(rightAlign,DungeonCrafter.HEIGHT-400,200,200);
        ui.addActor(moveLeft);

        final Label moveRight = new Label("Move right:   right arrow", style);
        moveRight.setBounds(rightAlign,DungeonCrafter.HEIGHT-450,200,200);
        ui.addActor(moveRight);

        final Label jump = new Label("Jump:   up arrow", style);
        jump.setBounds(rightAlign,DungeonCrafter.HEIGHT-500,200,200);
        ui.addActor(jump);

        final Label duck = new Label("Duck:   down arrow", style);
        duck.setBounds(rightAlign,DungeonCrafter.HEIGHT-550,200,200);
        ui.addActor(duck);

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
