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
import com.badlogic.gdx.utils.Null;
import dev.teamcyan.dungeoncrafter.DungeonCrafter;
import dev.teamcyan.dungeoncrafter.classes.GEPlayer;
import dev.teamcyan.dungeoncrafter.classes.GMap;
import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.maps.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3 ;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import java.util.ArrayList;

import dev.teamcyan.dungeoncrafter.DungeonCrafter;
import dev.teamcyan.dungeoncrafter.classes.GameModel;
import dev.teamcyan.dungeoncrafter.classes.Pos;

public class MainGameScreen extends BaseScreen {

    private SpriteBatch batch = new SpriteBatch();
    private boolean movingRight = false;
    private boolean movingLeft = false;
    private boolean movingUp = false;
    private boolean movingDown = false;
    private boolean zoomIn = false;
    private boolean zoomOut = false;

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

        model.getPlayer().getSprite().setPosition(model.getMap().getMapPixelWidth()/2,model.getMap().getMapPixelHeight()/2);
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

        TiledMapTileLayer layer = (TiledMapTileLayer) model.getMap().getTiledMap().getLayers().get("Tile Layer 1");

        model.getCamera().translate(
                (model.getPlayer().getSprite().getX() - model.getPlayer().setX(
                        layer, movingLeft, movingRight)) * (-1),
                (model.getPlayer().getSprite().getY() - model.getPlayer().setY(
                        layer, movingUp, movingDown)) * (-1),
                0);

        model.getPebble().setX(layer, model.getPlayer().getPosition());
        model.getPebble().setY(layer);

        model.getMap().getMapRenderer().setView(model.getCamera());
        model.getMap().getMapRenderer().render();
        batch.setProjectionMatrix(model.getCamera().combined);


        batch.begin();
        /*for (Sprite s : q) {
            batch.draw(s, s.getX(), s.getY(), s.getWidth(),s.getHeight()); // this will be diffrent when you have nummbers at end eg player_1, player_2
        }*/

        Sprite player = model.getPlayer().getSprite();
        batch.draw(player, player.getX(), player.getY(), player.getWidth(), player.getHeight()); // this will be diffrent when you have nummbers at end eg player_1, player_2
        Sprite pebble = model.getPebble().getSprite();
        batch.draw(pebble, pebble.getX(), pebble.getY(), pebble.getWidth(),pebble.getHeight()); // this will be diffrent when you have nummbers at end eg player_1, player_2
        font.setColor(1,1,1,1);   //Brown is an underated Colour
        font.draw(batch, mouseInfo, player.getX(), player.getY()+150);
        font.draw(batch, "Mouse XY:", player.getX(), player.getY()+170);
        font.draw(batch, "Keys active:", player.getX(), player.getY()+200);
        for(int i = 0; i < keyInfo.size(); i++)
        {
            font.draw(batch, keyInfo.get(i), player.getX()+80+(i*10), player.getY()+200);
        }
        //font.draw(game.batch, keyInfo, 50, DungeonCrafter.HEIGHT-30);
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
        model.getMap().getTiledMap().dispose();
    }

    @Override
    public boolean keyDown(int keycode) {

        keyInfo.add(String.valueOf((char) (keycode + 68)));

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
        keyInfo.remove((keyInfo.indexOf(String.valueOf((char) (keycode + 68)))));
        //System.out.println((char) (keycode + 68));
        if(keycode == Input.Keys.RIGHT) {
            movingRight = false;
        }

        if(keycode == Input.Keys.LEFT)
            movingLeft = false;

        if(keycode == Input.Keys.UP)
            movingUp = false;

        if(keycode == Input.Keys.DOWN)
            movingDown = false;

        if(keycode == Input.Keys.I) {
            zoomIn = false;
        }
        if(keycode == Input.Keys.O) {
            zoomOut = false;
        }

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

        model.getPlayer().getSprite().setCenterX(screenX);
        model.getPlayer().getSprite().setCenterY(DungeonCrafter.HEIGHT - screenY);

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
        mouseInfo = "X = " + String.valueOf(screenX) + "\nY = " + String.valueOf(screenY);
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
