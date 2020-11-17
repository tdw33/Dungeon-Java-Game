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

public class MainGameScreen extends BaseScreen {
    private SpriteBatch batch = new SpriteBatch();
    private boolean movingRight = false;
    private boolean movingLeft = false;
    private boolean movingUp = false;
    private boolean movingDown = false;
    private boolean zoomIn = false;
    private boolean zoomOut = false;
    private Sprite sprite;
    private List <Sprite> q = new ArrayList<>();
    private TiledMap map;
    private int mapPixelWidth;
    private int mapPixelHeight;

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

        sprite = new Sprite(controller.getAtlasRegion(model.getPlayer().getSpriteName()));

        model.getPlayer().setX(mapPixelWidth/2);
        model.getPlayer().setY(mapPixelHeight/2);
        sprite.setPosition(model.getPlayer().getPosition().getX(),model.getPlayer().getPosition().getY());

        font = new BitmapFont();
        keyInfo = new ArrayList<String>();
        mouseInfo = "";

    }

    public void setPosition(GEPlayer player, TiledMapTileLayer layer) {
        // apply gravity, when no floor
        float delta = Gdx.graphics.getDeltaTime();
        double newXVelocity;

        if (movingLeft == movingRight) {
            newXVelocity = model.getPlayer().getVelocity().getX() * controller.RESISTANCE;
            newXVelocity = newXVelocity > -0.000000001 && newXVelocity < 0.000000001 ? 0 : newXVelocity;
        } else if (movingRight) {
            newXVelocity = model.getPlayer().getVelocity().getX() + controller.ACCELERATION * delta;// delta * controller.RESISTANCE * -1 + ;
        } else {
            newXVelocity = model.getPlayer().getVelocity().getX() - controller.ACCELERATION * delta;// delta * controller.RESISTANCE * -1 + ;
        }

        double newXPosition = model.getPlayer().getPosition().getX() + newXVelocity;

        if(newXVelocity > 0) {
            TiledMapTileLayer.Cell topRight = layer.getCell((int) ((newXPosition + sprite.getWidth()) / layer.getTileWidth()), (int) Math.floor((model.getPlayer().getPosition().getY() + sprite.getHeight()) / layer.getTileHeight()));
            TiledMapTileLayer.Cell bottomRight = layer.getCell((int)((newXPosition + sprite.getWidth()) / layer.getTileWidth()), (int) Math.ceil(model.getPlayer().getPosition().getY() / layer.getTileHeight()));
            if (bottomRight == null && topRight == null) {
                model.getPlayer().getVelocity().setX(newXVelocity);
                model.getPlayer().getPosition().setX((int)Math.ceil(newXPosition));
                model.getCamera().translate((int)Math.ceil(newXVelocity),0,0);
            } else {
                model.getPlayer().getVelocity().setX(0.0);
            }

        } else if (newXVelocity < 0) {
            TiledMapTileLayer.Cell topLeft = layer.getCell((int) Math.floor(newXPosition / layer.getTileWidth()), (int) Math.floor((model.getPlayer().getPosition().getY() + sprite.getHeight()) / layer.getTileHeight()));
            TiledMapTileLayer.Cell bottomLeft = layer.getCell((int) Math.floor(newXPosition / layer.getTileWidth()), (int) Math.ceil(model.getPlayer().getPosition().getY() / layer.getTileHeight()));
            if (bottomLeft == null && topLeft == null) {
                model.getPlayer().getVelocity().setX(newXVelocity);
                model.getPlayer().getPosition().setX((int)Math.floor(newXPosition));
                model.getCamera().translate((int)Math.floor(newXVelocity),0,0);
            } else {
                model.getPlayer().getVelocity().setX(0.0);
            }
        }

        double newYVelocity = model.getPlayer().getVelocity().getY() + delta * controller.GRAVITY;

        double newYPosition = model.getPlayer().getPosition().getY() - Math.floor(newYVelocity);
        TiledMapTileLayer.Cell leftBottom = layer.getCell((int) Math.floor(model.getPlayer().getPosition().getX() / layer.getTileWidth()), (int) Math.floor(newYPosition / layer.getTileHeight()));
        TiledMapTileLayer.Cell rightBottom = layer.getCell((int) Math.floor((model.getPlayer().getPosition().getX()+sprite.getWidth()-1) / layer.getTileWidth()), (int) Math.floor(newYPosition / layer.getTileHeight()));
        if (leftBottom == null && rightBottom == null) {
            model.getPlayer().getVelocity().setY(newYVelocity);
            model.getPlayer().setY((int)newYPosition);
            model.getCamera().translate(0,-(int)newYVelocity,0);

        } else {
            model.getPlayer().getVelocity().setY(0);
        }


        if(movingUp) {
            TiledMapTileLayer.Cell cellLeftCorner = layer.getCell((int) (sprite.getX() / layer.getTileWidth()), (int) ((sprite.getY()+sprite.getHeight()) / layer.getTileHeight()));
            TiledMapTileLayer.Cell cellRightCorner = layer.getCell((int) (((sprite.getX()-1)+sprite.getWidth()) / layer.getTileWidth()), (int) ((sprite.getY()+sprite.getHeight()) / layer.getTileHeight()));
            if (cellLeftCorner == null && cellRightCorner == null) {
                model.getPlayer().setY(model.getPlayer().getPosition().getY()+1);
                model.getCamera().translate(0, 1, 0);
            }
        }

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

        TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get("Tile Layer 1");
        setPosition(model.getPlayer(), layer);
        sprite.setPosition(model.getPlayer().getPosition().getX(), model.getPlayer().getPosition().getY());
        model.getMap().getMapRenderer().setView(model.getCamera());
        model.getMap().getMapRenderer().render();
        batch.setProjectionMatrix(model.getCamera().combined);

        batch.begin();
        /*for (Sprite s : q) {
            batch.draw(s, s.getX(), s.getY(), s.getWidth(),s.getHeight()); // this will be diffrent when you have nummbers at end eg player_1, player_2
        }*/
        batch.draw(sprite, sprite.getX(), sprite.getY(), sprite.getWidth(),sprite.getHeight()); // this will be diffrent when you have nummbers at end eg player_1, player_2
        font.setColor(1,1,1,1);   //Brown is an underated Colour
        font.draw(batch, mouseInfo, sprite.getX(), sprite.getY()+150);
        font.draw(batch, "Mouse XY:", sprite.getX(), sprite.getY()+170);
        font.draw(batch, "Keys active:", sprite.getX(), sprite.getY()+200);
        for(int i = 0; i < keyInfo.size(); i++)
        {
            font.draw(batch, keyInfo.get(i), sprite.getX()+80+(i*10), sprite.getY()+200);
        }
        //font.draw(game.batch, keyInfo, 50, DungeonCrafter.HEIGHT-30);
        batch.end();
        model.getCamera().update();

    }

    @Override
    public void resize(int width, int height) {
      model.getCamera().viewportWidth = width;
      model.getCamera().viewportHeight = height;
      model.getCamera().position.set(mapPixelWidth/2f, mapPixelHeight/2f, 0); //by default model.getCamera() position on (0,0,0)
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
        map.dispose();
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
        sprite.setCenterX(screenX);
        sprite.setCenterY(DungeonCrafter.HEIGHT - screenY);
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
