package dev.teamcyan.dungeoncrafter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dev.teamcyan.dungeoncrafter.DungeonCrafter;
import dev.teamcyan.dungeoncrafter.classes.GameModel;

public class DifficultyScreen extends BaseScreen {

    boolean mouseDown = true;
    private static final float EASY_TIME = 600;
    private static final float MED_TIME = 300;
    private static final float HARD_TIME = 150;

    // The size and position of the four buttons
    private static final int EASY_BUTTON_WIDTH = DungeonCrafter.WIDTH / 6;
    private static final int EASY_BUTTON_HEIGHT = DungeonCrafter.HEIGHT / 18;
    private static final int EASY_BUTTON_X = DungeonCrafter.WIDTH / 9;
    private static final int EASY_BUTTON_Y = DungeonCrafter.HEIGHT / 3;

    private static final int MEDIUM_BUTTON_WIDTH = DungeonCrafter.WIDTH / 4;
    private static final int MEDIUM_BUTTON_HEIGHT = DungeonCrafter.HEIGHT / 18;
    private static final int MEDIUM_BUTTON_X = DungeonCrafter.WIDTH / 8 * 3;
    private static final int MEDIUM_BUTTON_Y = DungeonCrafter.HEIGHT / 3;

    private static final int HARD_BUTTON_WIDTH = DungeonCrafter.WIDTH / 6;
    private static final int HARD_BUTTON_HEIGHT = DungeonCrafter.HEIGHT / 18;
    private static final int HARD_BUTTON_X = DungeonCrafter.WIDTH / 24 * 17;
    private static final int HARD_BUTTON_Y = DungeonCrafter.HEIGHT / 3;

    private static final int BACK_BUTTON_WIDTH = DungeonCrafter.WIDTH / 6;
    private static final int BACK_BUTTON_HEIGHT = DungeonCrafter.HEIGHT / 18;
    private static final int BACK_BUTTON_X = DungeonCrafter.WIDTH / 72*55;
    private static final int BACK_BUTTON_Y = DungeonCrafter.HEIGHT / 18 * 2;


    DungeonCrafter game;
    SpriteBatch batch = new SpriteBatch();

    Texture easyButtonActive;
    Texture easyButtonInactive;
    Texture mediumButtonActive;
    Texture mediumButtonInactive;
    Texture hardButtonActive;
    Texture hardButtonInactive;
    Texture backButtonActive;
    Texture backButtonInactive;
    Texture menuBackground;

    public DifficultyScreen(DungeonCrafter parent, GameModel model) {
        super(parent, model);
        this.game = parent;
        easyButtonActive = new Texture("menu_buttons/easy_active.png");
        easyButtonInactive = new Texture("menu_buttons/easy_inactive.png");
        mediumButtonActive = new Texture("menu_buttons/medium_active.png");
        mediumButtonInactive = new Texture("menu_buttons/medium_inactive.png");
        hardButtonActive = new Texture("menu_buttons/hard_active.png");
        hardButtonInactive = new Texture("menu_buttons/hard_inactive.png");
        backButtonActive = new Texture("menu_buttons/back_active.png");
        backButtonInactive = new Texture("menu_buttons/back_inactive.png");
        menuBackground = new Texture("menu_buttons/menuBackground.png");

    }

    public void draw(float delta) {
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.3f, 1);
        //colour range from 0-1 using decimals (must add f after to convert to float)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        // menu background
        batch.draw(menuBackground, 0, 0, DungeonCrafter.WIDTH, DungeonCrafter.HEIGHT);

        if (!mouseDown) {
            // easy
            if (Gdx.input.getX() < EASY_BUTTON_X + EASY_BUTTON_WIDTH && Gdx.input.getX() > EASY_BUTTON_X && DungeonCrafter.HEIGHT - Gdx.input.getY()
                    < EASY_BUTTON_Y + EASY_BUTTON_HEIGHT && DungeonCrafter.HEIGHT - Gdx.input.getY() > EASY_BUTTON_Y) {
                batch.draw(easyButtonActive,
                        EASY_BUTTON_X, EASY_BUTTON_Y, EASY_BUTTON_WIDTH, EASY_BUTTON_HEIGHT);
                if (Gdx.input.isTouched()) {
                    this.dispose();
                    model.startNewGame(game);

                    super.controller.totTime = EASY_TIME;
                    controller.changeScreen(MainGameScreen.class);
                }

            } else {
                batch.draw(easyButtonInactive,
                        EASY_BUTTON_X, EASY_BUTTON_Y, EASY_BUTTON_WIDTH, EASY_BUTTON_HEIGHT);
            }
            // MEDIUM
            if (Gdx.input.getX() < MEDIUM_BUTTON_X + MEDIUM_BUTTON_WIDTH && Gdx.input.getX() > MEDIUM_BUTTON_X && DungeonCrafter.HEIGHT - Gdx.input.getY()
                    < MEDIUM_BUTTON_Y + MEDIUM_BUTTON_HEIGHT && DungeonCrafter.HEIGHT - Gdx.input.getY() > MEDIUM_BUTTON_Y) {
                batch.draw(mediumButtonActive,
                        MEDIUM_BUTTON_X, MEDIUM_BUTTON_Y, MEDIUM_BUTTON_WIDTH, MEDIUM_BUTTON_HEIGHT);
                if (Gdx.input.isTouched()) {
                    this.dispose();
                    super.controller.totTime = MED_TIME;
                    controller.changeScreen(MainGameScreen.class);
                }

            } else {
                batch.draw(mediumButtonInactive,
                        MEDIUM_BUTTON_X, MEDIUM_BUTTON_Y, MEDIUM_BUTTON_WIDTH, MEDIUM_BUTTON_HEIGHT);
            }
            // Hard
            if (Gdx.input.getX() < HARD_BUTTON_X + HARD_BUTTON_WIDTH && Gdx.input.getX() > HARD_BUTTON_X && DungeonCrafter.HEIGHT - Gdx.input.getY()
                    < HARD_BUTTON_Y + HARD_BUTTON_HEIGHT && DungeonCrafter.HEIGHT - Gdx.input.getY() > HARD_BUTTON_Y) {
                batch.draw(hardButtonActive,
                        HARD_BUTTON_X, HARD_BUTTON_Y, HARD_BUTTON_WIDTH, HARD_BUTTON_HEIGHT);
                if (Gdx.input.isTouched()) {
                    this.dispose();
                    super.controller.totTime = HARD_TIME;
                    controller.changeScreen(MainGameScreen.class);
                }

            } else {
                batch.draw(hardButtonInactive,
                        HARD_BUTTON_X, HARD_BUTTON_Y, HARD_BUTTON_WIDTH, HARD_BUTTON_HEIGHT);
            }
            // back arrow
            if(Gdx.input.getX() < BACK_BUTTON_X + BACK_BUTTON_WIDTH && Gdx.input.getX() > BACK_BUTTON_X && DungeonCrafter.HEIGHT - Gdx.input.getY()
                    < BACK_BUTTON_Y + BACK_BUTTON_HEIGHT &&  DungeonCrafter.HEIGHT - Gdx.input.getY() > BACK_BUTTON_Y) {
                batch.draw(backButtonActive,
                        BACK_BUTTON_X,BACK_BUTTON_Y, BACK_BUTTON_WIDTH, BACK_BUTTON_HEIGHT);
                if(Gdx.input.isTouched()){
                    this.dispose();
                    controller.changeScreen(MainMenuScreen.class);}
            } else {
                batch.draw(backButtonInactive,
                        BACK_BUTTON_X,BACK_BUTTON_Y, BACK_BUTTON_WIDTH, BACK_BUTTON_HEIGHT);}

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
        //mouseDown = true;
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        mouseDown = false;
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
