package dev.teamcyan.dungeoncrafter.classes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import dev.teamcyan.dungeoncrafter.DungeonCrafter;

/**
 * Helper class for handling animations
 */
public class Animations {
    private TextureRegion standing;
    protected DungeonCrafter controller;
    protected GameModel model;
    protected GEPlayer player;
    Texture charactersheet;
    TextureRegion[] animationFrames;
    int index = 0;
    private static final int CHAR_PIXEL_HEIGHT = 64;
    private static final int CHAR_PIXEL_WIDTH = 64;
    private float stateTime = 0;
    public enum State {RUNNING, STANDING, JUMPING, FALLING};
    public State currentState;
    public State previousState;
    private Animation charRun;
    private Animation charJump;
    private Animation charStand;
    private float stateTimer;
    private boolean runningRight;
    TextureRegion[] charFrames;


    /**
     * Constructor of Animations Class
     * @param controller
     * @param model
     * @param player
     */
    public Animations(DungeonCrafter controller, GameModel model, GEPlayer player) {
        this.controller = controller;
        this.model = model;
        this.player = player;
        controller.getAtlasRegion("sprites/character/charactersheets");
        // convert the sprite sheet into a 1d array of all the images

        charFrames = new TextureRegion[273];
        TextureRegion[][] charSpriteSheet = TextureRegion.split(new Texture("sprites/character/charactersheets"),
                CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT);

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 21; j++) {
                charFrames[index++] = charSpriteSheet[j][i];
            }
        }

    }
}