package dev.teamcyan.dungeoncrafter.screens;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import dev.teamcyan.dungeoncrafter.DungeonCrafter;
import dev.teamcyan.dungeoncrafter.classes.GameModel;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public abstract class BaseScreen implements Screen, InputProcessor {
    protected DungeonCrafter controller;
    protected GameModel model;
    protected Stage ui;

    public BaseScreen(DungeonCrafter controller, GameModel model) {
        this.controller = controller;
        this.model = model;
        ui = new Stage(new ScreenViewport());
    }

    // === Lifecycle Methods === //
    @Override
    final public void show() {
        // Set Debug Mode
        ui.setDebugAll(controller.isDebugOn());

        // Map the controller
        InputMultiplexer input = new InputMultiplexer();
        input.addProcessor(ui);
        Gdx.input.setInputProcessor(this);

        // Screen-specific initialization
        init();
    }

    public void init() { }

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

    //Override this sucker to implement any custom drawing
    public void draw(float delta) {}

    @Override public void resize(int width, int height) {
        ui.getViewport().update(width, height);
    }

    @Override public void dispose() {
        if(ui != null) ui.dispose();
        ui = null;
    }
}
