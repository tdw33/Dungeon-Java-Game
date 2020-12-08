package dev.teamcyan.dungeoncrafter.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import dev.teamcyan.dungeoncrafter.DungeonCrafter;
import dev.teamcyan.dungeoncrafter.classes.GEPlayer;
import dev.teamcyan.dungeoncrafter.classes.GameModel;


/**
 * Screen that displays current state of the game inventory.
 */
public class InventoryScreen extends BaseScreen{

    public static final int IMAGE_DIM = 80;
    public static final int IMAGE_X = 130;
    private Label dirt;
    private Label iron;
    private Label gold;
    private Label stone;

    /**
     * Setup all the parts of the screen
     * @param parent instance of the DungeonCrafter class
     * @param model instance of the current GameModel class
     */
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
                    if (model.getPlayer().getIron() >= 30 && model.getPlayer().getHealth() < 300) {
                        ironArmourLabel.setFontScale(2.5f);
                    }
                } else if (event.toString() == "exit") {
                    ironArmourLabel.setFontScale(2f);
                } else if (event.toString() == "touchDown") {
                    if (model.getPlayer().getIron() >= 30 && model.getPlayer().getHealth() < 300) {
                        model.getPlayer().decrementIron(30);
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
                    if (model.getPlayer().getGold() >= 30 && model.getPlayer().getHealth() < 300) {
                        goldArmourLabel.setFontScale(2.5f);
                    }
                } else if (event.toString() == "exit") {
                    goldArmourLabel.setFontScale(2f);
                } else if (event.toString() == "touchDown") {
                    if (model.getPlayer().getGold() >= 30 && model.getPlayer().getHealth() < 300) {
                        model.getPlayer().decrementGold(30);
                        model.getPlayer().incrementHealth(200);
                    }

                }

                return true;
            }
        });

        final Label.LabelStyle style2 = new Label.LabelStyle();
        style2.fontColor = Color.WHITE;
        style2.font = new BitmapFont();
        style2.font.getData().setScale(2f);

        int number_x = 370;
        this.dirt = new Label("", style2);
        dirt.setBounds(number_x,DungeonCrafter.HEIGHT-250,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(dirt);

        this.iron = new Label("", style2);
        iron.setBounds(number_x,DungeonCrafter.HEIGHT-450,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(iron);

        this.stone = new Label("", style2);
        stone.setBounds(number_x,DungeonCrafter.HEIGHT-350,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(stone);

        this.gold = new Label("", style2);
        gold.setBounds(number_x,DungeonCrafter.HEIGHT-550,IMAGE_DIM,IMAGE_DIM);
        ui.addActor(gold);

    }

    /**
     * implement for initial setups.
     */
    @Override
    public void init() {
        leavingInv = true;
        //super.timer.stop();
    }

    /**
     * Implement for continuous updates of the screen.
     * Amount of material needs to be updated continuously, because it changes throughout the game.
     * @param delta amount of time that passed since last call
     */
    @Override
    public void draw(float delta) {

        this.dirt.setText(model.getPlayer().getDirt());
        this.stone.setText(model.getPlayer().getStone());
        this.iron.setText(model.getPlayer().getIron());
        this.gold.setText(model.getPlayer().getGold());


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
