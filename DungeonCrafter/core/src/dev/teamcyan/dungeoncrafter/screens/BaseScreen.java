package dev.teamcyan.dungeoncrafter.screens;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Timer;
import dev.teamcyan.dungeoncrafter.DungeonCrafter;
import dev.teamcyan.dungeoncrafter.classes.GameModel;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

/**
 * Screens act as views in the MVC-pattern. BaseScreen provides all screens with base functionalities
 * as an abstract class the other screens inherit from.
 */
public abstract class BaseScreen implements Screen, InputProcessor {
    protected DungeonCrafter controller;
    protected GameModel model;
    /**
     * Stage object is accessible by subclasses and holds screen information
     */
    protected Stage ui;
    public static Timer timer=new Timer();
    public static boolean leavingInv;

    /**
     * @param controller instance of the DungeonCrafter class
     * @param model instance of the current GameModel class
     */
    public BaseScreen(DungeonCrafter controller, GameModel model) {
        this.controller = controller;
        this.model = model;
        ui = new Stage(new ScreenViewport());
    }

    /**
     * Initial screen setup. Note call to init(), which is overridden by subclasses for their individual screen
     * setup.
     */
    @Override
    final public void show() {
        // Set Debug Mode
        ui.setDebugAll(controller.isDebugOn());

        // Map the controller
        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(ui);
        inputMultiplexer.addProcessor(this);
        Gdx.input.setInputProcessor(inputMultiplexer);

        // Screen-specific initialization
        init();
    }

    /**
     * Placeholder method designed for subclasses to be called from show().
     */
    public void init() {
    }

    /**
     * Lifecycle method from Screen.class is called repeatedly to update screen continuously.
     * Note call to ui.draw(), which is overridden by subclasses for their individual continuous drawing.
     * @param delta amount of time that passed since last call
     */
    @Override
    final public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        draw(delta);
        if(ui != null) {
            ui.act(delta);
            ui.draw();
        }
    }

    /**
     * Placeholder method designed for subclasses to be called from render()
     * @param delta amount of time that passed since last call
     */
    //Override this sucker to implement any custom drawing
    public void draw(float delta) {}

    /**
     * Update the viewport on window resizes
     * @param width width of newly resized window
     * @param height width of newly resized window
     */
    @Override public void resize(int width, int height) {
        ui.getViewport().update(DungeonCrafter.WIDTH, DungeonCrafter.HEIGHT);
    }

    /**
     * Safely dispose data when necessary
     */
    @Override public void dispose() {
        if(ui != null) ui.dispose();
        ui = null;
    }
}
