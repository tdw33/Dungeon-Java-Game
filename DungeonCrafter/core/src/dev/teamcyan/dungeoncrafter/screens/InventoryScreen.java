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

import javax.xml.soap.Text;

public class InventoryScreen extends BaseScreen{

    public static final int IMAGE_DIM = 100;

    public InventoryScreen(DungeonCrafter parent, final GameModel model) {
        super(parent, model);

        Texture goldTexture = new Texture("sprites/precious/default_gold_ingot.png");
        TextureRegion goldTextureRegion = new TextureRegion(goldTexture);
        TextureRegionDrawable goldTexRegionDrawable = new TextureRegionDrawable(goldTextureRegion);
        Image goldImage = new Image(goldTexRegionDrawable);
        goldImage.setBounds(100,DungeonCrafter.HEIGHT-200,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(goldImage);

        final Label.LabelStyle style = new Label.LabelStyle();
        style.fontColor = Color.WHITE;
        style.font = new BitmapFont();
        style.font.getData().setScale(2f);
        final Label goldLabel = new Label("Gold:", style);
        goldLabel.setBounds(250,DungeonCrafter.HEIGHT-200,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(goldLabel);

        Texture steelTexture = new Texture("sprites/precious/default_steel_ingot.png");
        TextureRegion steelTextureRegion = new TextureRegion(steelTexture);
        TextureRegionDrawable steelTexRegionDrawable = new TextureRegionDrawable(steelTextureRegion);
        Image steelImage = new Image(steelTexRegionDrawable);
        steelImage.setBounds(100,DungeonCrafter.HEIGHT-350,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(steelImage);

        Label steelLabel = new Label("Steel:", style);
        steelLabel.setBounds(250,DungeonCrafter.HEIGHT-350,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(steelLabel);

        Label chooseLabel = new Label("Choose a block to craft with:", style);
        chooseLabel.setBounds(150,DungeonCrafter.HEIGHT-400,0,0);
        ui.addActor(chooseLabel);

        Texture steelBlockTexture = new Texture("sprites/precious/default_steel_block.png");
        TextureRegion steelBlockTextureRegion = new TextureRegion(steelBlockTexture);
        TextureRegionDrawable steelBlockTexRegionDrawable = new TextureRegionDrawable(steelBlockTextureRegion);
        final ImageButton steelButton = new ImageButton(steelBlockTexRegionDrawable);
        steelButton.setBounds(DungeonCrafter.WIDTH/2-120,DungeonCrafter.HEIGHT-550,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(steelButton);

        steelButton.addListener(new EventListener()
        {
            @Override
            public boolean handle(Event event)
            {
                if (event.toString() == "enter") {
                    steelButton.setBounds(DungeonCrafter.WIDTH/2-130,DungeonCrafter.HEIGHT-560,IMAGE_DIM+20,IMAGE_DIM+20);
                } else if (event.toString() == "exit") {
                    steelButton.setBounds(DungeonCrafter.WIDTH/2-120,DungeonCrafter.HEIGHT-550,IMAGE_DIM,IMAGE_DIM);
                } else if (event.toString() == "touchDown") {
                    model.getPlayer().setCurrentCraftingBlock(GEPlayer.BLOCK.STEEL);
                    steelButton.setBounds(DungeonCrafter.WIDTH/2-120,DungeonCrafter.HEIGHT-550,IMAGE_DIM,IMAGE_DIM);
                    controller.changeScreen(MainGameScreen.class);
                }

                return true;
            }
        });

        Texture goldBlockTexture = new Texture("sprites/precious/default_gold_block.png");
        TextureRegion goldBlockTextureRegion = new TextureRegion(goldBlockTexture);
        TextureRegionDrawable goldBlockTexRegionDrawable = new TextureRegionDrawable(goldBlockTextureRegion);
        final ImageButton goldButton = new ImageButton(goldBlockTexRegionDrawable);
        goldButton.setBounds(DungeonCrafter.WIDTH/2+20,DungeonCrafter.HEIGHT-550,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(goldButton);

        goldButton.addListener(new EventListener()
        {
            @Override
            public boolean handle(Event event)
            {
                if (event.toString() == "enter") {
                    goldButton.setBounds(DungeonCrafter.WIDTH/2+10,DungeonCrafter.HEIGHT-560,IMAGE_DIM+20,IMAGE_DIM+20);
                } else if (event.toString() == "exit") {
                    goldButton.setBounds(DungeonCrafter.WIDTH/2+20,DungeonCrafter.HEIGHT-550,IMAGE_DIM,IMAGE_DIM);
                } else if (event.toString() == "touchDown") {
                    model.getPlayer().setCurrentCraftingBlock(GEPlayer.BLOCK.GOLD);
                    goldButton.setBounds(DungeonCrafter.WIDTH/2+20,DungeonCrafter.HEIGHT-550,IMAGE_DIM,IMAGE_DIM);
                    controller.changeScreen(MainGameScreen.class);
                }

                return true;
            }
        });

        final Label exitLabel = new Label("Exit", style);
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

        final Label gold = new Label(Integer.toString(model.getPlayer().getGold()), style);
        gold.setBounds(350,DungeonCrafter.HEIGHT-200,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(gold);

        final Label steel = new Label(Integer.toString(model.getPlayer().getSteel()), style);
        steel.setBounds(350,DungeonCrafter.HEIGHT-350,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(steel);

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
