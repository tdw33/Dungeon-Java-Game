package dev.teamcyan.dungeoncrafter.screens;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.kotcrab.vis.ui.widget.*;
import dev.teamcyan.dungeoncrafter.DungeonCrafter;
import dev.teamcyan.dungeoncrafter.classes.GameModel;

public class InventoryScreen extends BaseScreen{

    public InventoryScreen(DungeonCrafter parent, GameModel model) {
        super(parent, model);

    }

    @Override
    public void init() {

    }

    @Override
    public void draw(float delta) {

    }

    public void pause() {

    }
    public void resume() {

    }

    /**
     * Flush all stateful data.
     */
    @Override
    public void hide() {
        //super.hide();
    }

    private void updateSelection(String selected) {
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
