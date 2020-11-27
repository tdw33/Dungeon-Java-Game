package dev.teamcyan.dungeoncrafter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.kotcrab.vis.ui.widget.*;
import dev.teamcyan.dungeoncrafter.DungeonCrafter;
import dev.teamcyan.dungeoncrafter.classes.GEPlayer;
import dev.teamcyan.dungeoncrafter.classes.GameModel;



public class InventoryScreen extends BaseScreen{

    public static final int IMAGE_DIM = 100;

    public InventoryScreen(DungeonCrafter parent, final GameModel model) {
        super(parent, model);

        Texture backgroundTexture = new Texture("menu_buttons/InventoryBackground.png");
        Image background = new Image(backgroundTexture);
        background.setBounds(0,0,DungeonCrafter.WIDTH, DungeonCrafter.HEIGHT);
        ui.addActor(background);

        Texture dirtTexture = new Texture("sprites/rocks/default_dirt.png");
        TextureRegion dirtTextureRegion = new TextureRegion(dirtTexture);
        TextureRegionDrawable dirtTexRegionDrawable = new TextureRegionDrawable(dirtTextureRegion);
        Image dirtImage = new Image(dirtTexRegionDrawable);
        dirtImage.setBounds(100,DungeonCrafter.HEIGHT-250,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(dirtImage);

        final Label.LabelStyle style = new Label.LabelStyle();
        style.fontColor = Color.WHITE;
        style.font = new BitmapFont();
        style.font.getData().setScale(2f);
        final Label dirtLabel = new Label("Dirt:", style);
        dirtLabel.setBounds(250,DungeonCrafter.HEIGHT-250,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(dirtLabel);

        Texture stoneTexture = new Texture("sprites/rocks/default_stone_brick.png");
        TextureRegion stoneTextureRegion = new TextureRegion(stoneTexture);
        TextureRegionDrawable stoneTexRegionDrawable = new TextureRegionDrawable(stoneTextureRegion);
        Image stoneImage = new Image(stoneTexRegionDrawable);
        stoneImage.setBounds(100,DungeonCrafter.HEIGHT-370,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(stoneImage);

        Label stoneLabel = new Label("Stone:", style);
        stoneLabel.setBounds(250,DungeonCrafter.HEIGHT-370,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(stoneLabel);

        Texture ironTexture = new Texture("sprites/otherPrecious/default_mineral_iron.png");
        TextureRegion ironTextureRegion = new TextureRegion(ironTexture);
        TextureRegionDrawable ironTexRegionDrawable = new TextureRegionDrawable(ironTextureRegion);
        Image ironImage = new Image(ironTexRegionDrawable);
        ironImage.setBounds(100,DungeonCrafter.HEIGHT-490,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(ironImage);

        Label ironLabel = new Label("Iron:", style);
        ironLabel.setBounds(250,DungeonCrafter.HEIGHT-490,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(ironLabel);

        Label chooseLabel = new Label("Choose a block to craft with:", style);
        chooseLabel.setBounds(150,DungeonCrafter.HEIGHT-550,0,0);
        ui.addActor(chooseLabel);

        Texture stoneBlockTexture = new Texture("sprites/rocks/default_stone_block.png");
        TextureRegion stoneBlockTextureRegion = new TextureRegion(stoneBlockTexture);
        TextureRegionDrawable stoneBlockTexRegionDrawable = new TextureRegionDrawable(stoneBlockTextureRegion);
        final ImageButton stoneButton = new ImageButton(stoneBlockTexRegionDrawable);
        stoneButton.setBounds(DungeonCrafter.WIDTH/2-220,DungeonCrafter.HEIGHT-690,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(stoneButton);

        stoneButton.addListener(new EventListener()
        {
            @Override
            public boolean handle(Event event)
            {
                if (event.toString() == "enter") {
                    stoneButton.setBounds(DungeonCrafter.WIDTH/2-230,DungeonCrafter.HEIGHT-700,IMAGE_DIM+20,IMAGE_DIM+20);
                } else if (event.toString() == "exit") {
                    stoneButton.setBounds(DungeonCrafter.WIDTH/2-220,DungeonCrafter.HEIGHT-690,IMAGE_DIM,IMAGE_DIM);
                } else if (event.toString() == "touchDown") {
                    model.getPlayer().setCurrentCraftingBlock(GEPlayer.BLOCK.STONE);
                    stoneButton.setBounds(DungeonCrafter.WIDTH/2-220,DungeonCrafter.HEIGHT-690,IMAGE_DIM,IMAGE_DIM);
                    controller.changeScreen(MainGameScreen.class);
                }

                return true;
            }
        });

        Texture dirtBlockTexture = new Texture("sprites/rocks/default_dirt.png");
        TextureRegion dirtBlockTextureRegion = new TextureRegion(dirtBlockTexture);
        TextureRegionDrawable dirtBlockTexRegionDrawable = new TextureRegionDrawable(dirtBlockTextureRegion);
        final ImageButton dirtButton = new ImageButton(dirtBlockTexRegionDrawable);
        dirtButton.setBounds(DungeonCrafter.WIDTH/2-50,DungeonCrafter.HEIGHT-690,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(dirtButton);

        dirtButton.addListener(new EventListener()
        {
            @Override
            public boolean handle(Event event)
            {
                if (event.toString() == "enter") {
                    dirtButton.setBounds(DungeonCrafter.WIDTH/2-60,DungeonCrafter.HEIGHT-700,IMAGE_DIM+20,IMAGE_DIM+20);
                } else if (event.toString() == "exit") {
                    dirtButton.setBounds(DungeonCrafter.WIDTH/2-50,DungeonCrafter.HEIGHT-690,IMAGE_DIM,IMAGE_DIM);
                } else if (event.toString() == "touchDown") {
                    model.getPlayer().setCurrentCraftingBlock(GEPlayer.BLOCK.DIRT);
                    dirtButton.setBounds(DungeonCrafter.WIDTH/2-50,DungeonCrafter.HEIGHT-690,IMAGE_DIM,IMAGE_DIM);
                    controller.changeScreen(MainGameScreen.class);
                }

                return true;
            }
        });

        Texture ironBlockTexture = new Texture("sprites/precious/default_steel_block.png");
        TextureRegion ironBlockTextureRegion = new TextureRegion(ironBlockTexture);
        TextureRegionDrawable ironBlockTexRegionDrawable = new TextureRegionDrawable(ironBlockTextureRegion);
        final ImageButton ironButton = new ImageButton(ironBlockTexRegionDrawable);
        ironButton.setBounds(DungeonCrafter.WIDTH/2+120,DungeonCrafter.HEIGHT-690,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(ironButton);

        ironButton.addListener(new EventListener()
        {
            @Override
            public boolean handle(Event event)
            {
                if (event.toString() == "enter") {
                    ironButton.setBounds(DungeonCrafter.WIDTH/2+110,DungeonCrafter.HEIGHT-700,IMAGE_DIM+20,IMAGE_DIM+20);
                } else if (event.toString() == "exit") {
                    ironButton.setBounds(DungeonCrafter.WIDTH/2+120,DungeonCrafter.HEIGHT-690,IMAGE_DIM,IMAGE_DIM);
                } else if (event.toString() == "touchDown") {
                    model.getPlayer().setCurrentCraftingBlock(GEPlayer.BLOCK.IRON);
                    ironButton.setBounds(DungeonCrafter.WIDTH/2+120,DungeonCrafter.HEIGHT-690,IMAGE_DIM,IMAGE_DIM);
                    controller.changeScreen(MainGameScreen.class);
                }

                return true;
            }
        });

        final Label exitLabel = new Label("Back", style);
        final Button.ButtonStyle buttonStyle = new Button.ButtonStyle();
        final Button exitButton = new Button(exitLabel, buttonStyle);
        exitButton.setBounds(DungeonCrafter.WIDTH-50,DungeonCrafter.HEIGHT-50,0,0);
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
                    controller.changeScreen(MainGameScreen.class);
                }

                return true;
            }
        });

    }

    @Override
    public void init() {

    }

    @Override
    public void draw(float delta) {

        final Label.LabelStyle style = new Label.LabelStyle();
        style.fontColor = Color.WHITE;
        style.font = new BitmapFont();
        style.font.getData().setScale(2f);

        final Label dirt = new Label(Integer.toString(model.getPlayer().getDirt()), style);
        dirt.setBounds(350,DungeonCrafter.HEIGHT-250,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(dirt);

        final Label iron = new Label(Integer.toString(model.getPlayer().getIron()), style);
        iron.setBounds(350,DungeonCrafter.HEIGHT-490,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(iron);

        final Label stone = new Label(Integer.toString(model.getPlayer().getStone()), style);
        stone.setBounds(350,DungeonCrafter.HEIGHT-370,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(stone);

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
