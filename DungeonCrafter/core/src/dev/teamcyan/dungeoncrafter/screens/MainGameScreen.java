package dev.teamcyan.dungeoncrafter.screens;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.utils.Array;
import dev.teamcyan.dungeoncrafter.DungeonCrafter;
import dev.teamcyan.dungeoncrafter.classes.*;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.*;

public class MainGameScreen extends BaseScreen {

    SpriteBatch batch = new SpriteBatch();
    SpriteBatch hud = new SpriteBatch();
    boolean movingRight = false;
    boolean movingLeft = false;
    boolean movingUp = false;
    boolean movingDown = false;
    boolean zoomIn = false;
    boolean zoomOut = false;



    private BitmapFont font;
    private ArrayList<String> keyInfo;
    private String mouseInfo;

    private DungeonCrafter game;
    private GameModel model;

    public MainGameScreen(DungeonCrafter parent, GameModel model) 
    {
        /**
         * Constructor - 
         * Inherit the game and the model fron the parent class
         */

        super(parent, model);
        this.game = parent;
        this.model = model;

    }



    @Override
    public void init() {

        // load the map
        this.model.setCameraZoom(1f);
        System.out.println(model.getPlayer().getPosition().getX());
        System.out.println(model.getMap().getMapPixelWidth());
        model.getPlayer().getPosition().setX(model.getMap().getMapPixelWidth()/2);
        model.getPlayer().getPosition().setY(model.getMap().getMapPixelHeight()/2);
        model.getPebble().getSprite().setPosition(model.getMap().getMapPixelWidth()/2+10,model.getMap().getMapPixelHeight()/2+10);

        font = new BitmapFont();
        keyInfo = new ArrayList<String>();
        mouseInfo = "";

    }


    @Override
    public void draw(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(zoomIn) {
            model.getCamera().zoom -= 0.1;
        }
        if(zoomOut) {
            model.getCamera().zoom += 0.1;
        }

        TiledMapTileLayer layer = (TiledMapTileLayer)model
                                    .getMap()
                                    .getTiledMap()
                                    .getLayers()
                                    .get("Tile Layer 1");

        model.getCamera().translate(
                (model.getPlayer().getPosition().getX() - model.getPlayer().setX(
                        layer, movingLeft, movingRight)) * (-1),
                (model.getPlayer().getPosition().getY() - model.getPlayer().setY(
                        layer, movingUp, movingDown)) * (-1), 0);

        model.getPebble().setX(layer, model.getPlayer().getPosition());
        model.getPebble().setY(layer);

        model.getMap().getMapRenderer().setView(model.getCamera());
        model.getMap().getMapRenderer().render();
        batch.setProjectionMatrix(model.getCamera().combined);


        batch.begin();

        /*
        if(uiMatrix == null){
            uiMatrix = model.getCamera().combined.cpy();
        }
        */


        float existingZoom = model.getCamera().zoom;
        //hud.setProjectionMatrix(camera.combined);
        model.getCamera().zoom = 1f;
        model.getCamera().update();

        //batch.setProjectionMatrix(uiMatrix);
        font.setColor(1,1,1,1);

        GEPlayer player = model.getPlayer();
        batch.draw(
            player.getRegion(), 
            player.getPosition().getX(), 
            player.getPosition().getY(), 
            player.getRegion().getRegionWidth(), 
            player.getRegion().getRegionHeight()); 

        Sprite pebble = model.getPebble().getSprite();
        batch.draw(pebble, pebble.getX(), pebble.getY(), pebble.getWidth(),pebble.getHeight()); // this will be diffrent when you have nummbers at end eg player_1, player_2

        GEEnemy enemy = model.getEnemy();
        batch.draw(enemy.getRegion(), 1750, 700, 64, 64);

        font.setColor(1,1,1,1);   //Brown is an underated Colour
        font.draw(batch, mouseInfo, player.getPosition().getX(), player.getPosition().getY()+150);
        font.draw(batch, "Mouse XY:", player.getPosition().getX(), player.getPosition().getY()+170);
        font.draw(batch, "Keys active:", player.getPosition().getX(), player.getPosition().getY()+200);
        for(int i = 0; i < keyInfo.size(); i++)
        {
            font.draw(batch, super.controller.keyListener.activeKeys.get(i), player.getPosition().getX()+80+(i*10), player.getPosition().getY()+200);
        }
        batch.end();
        model.getCamera().update();

    }

    @Override
    public void resize(int width, int height) {
      model.getCamera().viewportWidth = width;
      model.getCamera().viewportHeight = height;
      model.getCamera().position.set(model.getMap().getMapPixelWidth()/2f, model.getMap().getMapPixelHeight()/2f, 0); //by default model.getCamera() position on (0,0,0)
      model.getCamera().update();
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
        batch.dispose();
        hud.dispose();
        model.getMap().getTiledMap().dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        super.controller.keyListener.keyDownListener(keycode);

        if(keycode == Input.Keys.LEFT) {
            movingLeft = true;
        }
        if(keycode == Input.Keys.RIGHT) {
            movingRight = true;
        }
        if(keycode == Input.Keys.UP) {
            movingUp = true;
        }
        if(keycode == Input.Keys.DOWN) {
            movingDown = true;
        }
        if(keycode == Input.Keys.I) {
            zoomIn = true;
        }
        if(keycode == Input.Keys.O) {
            zoomOut = true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        super.controller.keyListener.keyUpListener(keycode);

        if(keycode == Input.Keys.RIGHT)
            movingRight = false;

        if(keycode == Input.Keys.LEFT)
            movingLeft = false;

        if(keycode == Input.Keys.UP)
            movingUp = false;

        if(keycode == Input.Keys.DOWN)
            movingDown = false;

        if(keycode == Input.Keys.I)
            zoomIn = false;

        if(keycode == Input.Keys.O)
            zoomOut = false;

        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println("x = " + screenX);
        System.out.println("y = " + screenY);

        model.getPlayer().getRegion().setRegionX(screenX);
        model.getPlayer().getRegion().setRegionY(DungeonCrafter.HEIGHT - screenY);

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
        super.controller.keyListener.mouseMoved(screenX, screenY);
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
    public GameElement.State getState(){
        if(movingLeft && !movingUp && !movingDown){
            return GameElement.State.RUNNINGL;
        } else if (movingRight && !movingUp && !movingDown){
            return GameElement.State.RUNNINGR;
        //} else if(movingUp || movingDown && previousState == GameElement.State.JUMPING){
        //    return GameElement.State.JUMPING;
        } else if(movingDown) {
            return GameElement.State.FALLING;
        } else return GameElement.State.STANDING;
    }

}
