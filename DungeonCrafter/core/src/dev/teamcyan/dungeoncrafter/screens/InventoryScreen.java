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
import com.badlogic.gdx.utils.TimeUtils;
import com.kotcrab.vis.ui.widget.*;
import dev.teamcyan.dungeoncrafter.DungeonCrafter;
import dev.teamcyan.dungeoncrafter.classes.GEPlayer;
import dev.teamcyan.dungeoncrafter.classes.GameModel;



public class InventoryScreen extends BaseScreen{

    public static final int IMAGE_DIM = 80;
    public static final int IMAGE_X = 130;
    long timerDelay;

    public InventoryScreen(DungeonCrafter parent, final GameModel model) {
        super(parent, model);
        //background
        Texture backgroundTexture = new Texture("menu_buttons/InventoryBackground.png");
        Image background = new Image(backgroundTexture);
        background.setBounds(0,0,DungeonCrafter.WIDTH, DungeonCrafter.HEIGHT);
        ui.addActor(background);

        //Dirt
        Texture dirtTexture = new Texture("sprites/rocks/default_dirt.png");
        TextureRegion dirtTextureRegion = new TextureRegion(dirtTexture);
        TextureRegionDrawable dirtTexRegionDrawable = new TextureRegionDrawable(dirtTextureRegion);
        Image dirtImage = new Image(dirtTexRegionDrawable);
        int dirt_y = DungeonCrafter.HEIGHT-250;
        dirtImage.setBounds(IMAGE_X,dirt_y,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(dirtImage);

        final Label.LabelStyle style = new Label.LabelStyle();
        style.fontColor = Color.WHITE;
        style.font = new BitmapFont();
        style.font.getData().setScale(2f);
        final Label dirtLabel = new Label("Dirt:", style);
        dirtLabel.setBounds(250,dirt_y,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(dirtLabel);

        //Stone
        Texture stoneTexture = new Texture("sprites/rocks/default_stone.png");
        TextureRegion stoneTextureRegion = new TextureRegion(stoneTexture);
        TextureRegionDrawable stoneTexRegionDrawable = new TextureRegionDrawable(stoneTextureRegion);
        Image stoneImage = new Image(stoneTexRegionDrawable);
        int stone_y = DungeonCrafter.HEIGHT-350;
        stoneImage.setBounds(IMAGE_X,stone_y,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(stoneImage);

        Label stoneLabel = new Label("Stone:", style);
        stoneLabel.setBounds(250,stone_y,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(stoneLabel);

        //Iron
        Texture ironTexture = new Texture("sprites/otherPrecious/default_mineral_iron.png");
        TextureRegion ironTextureRegion = new TextureRegion(ironTexture);
        TextureRegionDrawable ironTexRegionDrawable = new TextureRegionDrawable(ironTextureRegion);
        Image ironImage = new Image(ironTexRegionDrawable);
        int iron_y = DungeonCrafter.HEIGHT-450;
        ironImage.setBounds(IMAGE_X,iron_y,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(ironImage);

        Label ironLabel = new Label("Iron:", style);
        ironLabel.setBounds(250,iron_y,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(ironLabel);

        //Gold
        Texture goldTexture = new Texture("sprites/otherPrecious/default_mineral_gold.png");
        TextureRegion goldTextureRegion = new TextureRegion(goldTexture);
        TextureRegionDrawable goldTexRegionDrawable = new TextureRegionDrawable(goldTextureRegion);
        Image goldImage = new Image(goldTexRegionDrawable);
        int gold_y = DungeonCrafter.HEIGHT-550;
        goldImage.setBounds(IMAGE_X,gold_y,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(goldImage);

        Label goldLabel = new Label("Gold:", style);
        goldLabel.setBounds(250,gold_y,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(goldLabel);

        //Choose text
        Label chooseLabel = new Label("Choose a block to craft with:", style);
        chooseLabel.setBounds(150,DungeonCrafter.HEIGHT-570,0,0);
        ui.addActor(chooseLabel);

        //Choose stone
        Texture stoneBlockTexture = new Texture("sprites/rocks/default_stone.png");
        TextureRegion stoneBlockTextureRegion = new TextureRegion(stoneBlockTexture);
        TextureRegionDrawable stoneBlockTexRegionDrawable = new TextureRegionDrawable(stoneBlockTextureRegion);
        final ImageButton stoneButton = new ImageButton(stoneBlockTexRegionDrawable);
        stoneButton.setBounds(DungeonCrafter.WIDTH/2+80,DungeonCrafter.HEIGHT-690,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(stoneButton);

        stoneButton.addListener(new EventListener()
        {
            @Override
            public boolean handle(Event event)
            {
                if (event.toString() == "enter") {
                    stoneButton.setBounds(DungeonCrafter.WIDTH/2+70,DungeonCrafter.HEIGHT-700,IMAGE_DIM+20,IMAGE_DIM+20);
                } else if (event.toString() == "exit") {
                    stoneButton.setBounds(DungeonCrafter.WIDTH/2+80,DungeonCrafter.HEIGHT-690,IMAGE_DIM,IMAGE_DIM);
                } else if (event.toString() == "touchDown") {
                    model.getPlayer().setCurrentCraftingBlock(GEPlayer.BLOCK.STONE);
                    stoneButton.setBounds(DungeonCrafter.WIDTH/2+80,DungeonCrafter.HEIGHT-690,IMAGE_DIM,IMAGE_DIM);
                    controller.changeScreen(MainGameScreen.class);
                }

                return true;
            }
        });

        //Choose dirt
        Texture dirtBlockTexture = new Texture("sprites/rocks/default_dirt.png");
        TextureRegion dirtBlockTextureRegion = new TextureRegion(dirtBlockTexture);
        TextureRegionDrawable dirtBlockTexRegionDrawable = new TextureRegionDrawable(dirtBlockTextureRegion);
        final ImageButton dirtButton = new ImageButton(dirtBlockTexRegionDrawable);
        dirtButton.setBounds(DungeonCrafter.WIDTH/2-130,DungeonCrafter.HEIGHT-690,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(dirtButton);

        dirtButton.addListener(new EventListener()
        {
            @Override
            public boolean handle(Event event)
            {
                if (event.toString() == "enter") {
                    dirtButton.setBounds(DungeonCrafter.WIDTH/2-140,DungeonCrafter.HEIGHT-700,IMAGE_DIM+20,IMAGE_DIM+20);
                } else if (event.toString() == "exit") {
                    dirtButton.setBounds(DungeonCrafter.WIDTH/2-130,DungeonCrafter.HEIGHT-690,IMAGE_DIM,IMAGE_DIM);
                } else if (event.toString() == "touchDown") {
                    model.getPlayer().setCurrentCraftingBlock(GEPlayer.BLOCK.DIRT);
                    dirtButton.setBounds(DungeonCrafter.WIDTH/2-130,DungeonCrafter.HEIGHT-690,IMAGE_DIM,IMAGE_DIM);
                    controller.changeScreen(MainGameScreen.class);
                }

                return true;
            }
        });

        /*
        //Choose steel
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
        */

        //Back button
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
                    leavingInv = true;
                    controller.changeScreen(MainGameScreen.class);
                }

                return true;
            }
        });

        //Craft armour
        final Label ironArmourLabel = new Label("Craft iron armour", style);
        final Button.ButtonStyle ironArmourButtonStyle = new Button.ButtonStyle();
        final Button ironArmourButton = new Button(ironArmourLabel, ironArmourButtonStyle);
        ironArmourButton.setBounds(550,DungeonCrafter.HEIGHT-410,0,0);
        ui.addActor(ironArmourButton);

        ironArmourButton.addListener(new EventListener()
        {
            @Override
            public boolean handle(Event event)
            {
                if (event.toString() == "enter") {
                    if (model.getPlayer().getIron() >= 50 && model.getPlayer().getHealth() < 300) {
                        ironArmourLabel.setFontScale(2.5f);
                    }
                } else if (event.toString() == "exit") {
                    ironArmourLabel.setFontScale(2f);
                } else if (event.toString() == "touchDown") {
                    if (model.getPlayer().getIron() >= 50 && model.getPlayer().getHealth() < 300) {
                        model.getPlayer().decrementIron(10);
                        model.getPlayer().incrementHealth(100);
                    }

                }

                return true;
            }
        });

        //Craft gold armour
        final Label goldArmourLabel = new Label("Craft gold armour", style);
        final Button.ButtonStyle goldArmourButtonStyle = new Button.ButtonStyle();
        final Button goldArmourButton = new Button(goldArmourLabel, goldArmourButtonStyle);
        goldArmourButton.setBounds(550,DungeonCrafter.HEIGHT-510,0,0);
        ui.addActor(goldArmourButton);

        goldArmourButton.addListener(new EventListener()
        {
            @Override
            public boolean handle(Event event)
            {
                if (event.toString() == "enter") {
                    if (model.getPlayer().getGold() >= 50 && model.getPlayer().getHealth() < 300) {
                        goldArmourLabel.setFontScale(2.5f);
                    }
                } else if (event.toString() == "exit") {
                    goldArmourLabel.setFontScale(2f);
                } else if (event.toString() == "touchDown") {
                    if (model.getPlayer().getGold() >= 50 && model.getPlayer().getHealth() < 300) {
                        model.getPlayer().decrementGold(10);
                        model.getPlayer().incrementHealth(200);
                    }

                }

                return true;
            }
        });

    }

    @Override
    public void init() {
        leavingInv = true;
        //super.timer.stop();
    }

    //Number of blocks
    @Override
    public void draw(float delta) {

        final Label.LabelStyle style = new Label.LabelStyle();
        style.fontColor = Color.WHITE;
        style.font = new BitmapFont();
        style.font.getData().setScale(2f);

        int number_x = 370;
        final Label dirt = new Label(Integer.toString(model.getPlayer().getDirt()), style);
        dirt.setBounds(number_x,DungeonCrafter.HEIGHT-250,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(dirt);

        final Label iron = new Label(Integer.toString(model.getPlayer().getIron()), style);
        iron.setBounds(number_x,DungeonCrafter.HEIGHT-450,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(iron);

        final Label stone = new Label(Integer.toString(model.getPlayer().getStone()), style);
        stone.setBounds(number_x,DungeonCrafter.HEIGHT-350,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(stone);

        final Label gold = new Label(Integer.toString(model.getPlayer().getGold()), style);
        gold.setBounds(number_x,DungeonCrafter.HEIGHT-550,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(gold);

    }

    public void pause() {

    }
    public void resume() {

    }

    @Override
    public void dispose() {
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
