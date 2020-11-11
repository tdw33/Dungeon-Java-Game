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
    SpriteBatch batch = new SpriteBatch();
    boolean movingRight = false;
    boolean movingLeft = false;
    boolean movingUp = false;
    boolean movingDown = false;
    boolean zoomIn = false;
    boolean zoomOut = false;
    Sprite sprite;
    List <Sprite> q = new ArrayList<>();
    private OrthogonalTiledMapRenderer mapRenderer;
    private TiledMap map;
    private int mapPixelWidth;
    private int mapPixelHeight;
    private OrthographicCamera camera;

    BitmapFont font;
    ArrayList<String> keyInfo;
    String mouseInfo;


    DungeonCrafter game;
    GameModel model;

    public MainGameScreen(DungeonCrafter parent, GameModel model) {
        super(parent, model);

        this.game = parent;
        this.model = model;
    }

    @Override
    public void init() {

        // load the map
        TmxMapLoader loader = new TmxMapLoader();
        map = loader.load(model.getMap().getMapName());
        // load map properties to store map dimensions
        MapProperties prop = map.getProperties();
        int mapWidth = prop.get("width", Integer.class);
        int mapHeight = prop.get("height", Integer.class);
        int tilePixelWidth = prop.get("tilewidth", Integer.class);
        int tilePixelHeight = prop.get("tileheight", Integer.class);
        mapPixelWidth = mapWidth * tilePixelWidth;
        mapPixelHeight = mapHeight * tilePixelHeight;

        /*
        //map = new TiledMap();
        TiledMapTileLayer.Cell cell;
        MapLayers layers = map.getLayers();


        TiledMapTileLayer layer = new TiledMapTileLayer(100, 100, 64, 64);
        //for (int x = 0; x < 15; x++) {
        //  for (int y = 0; y < 10; y++) {
          cell = layer.getCell(0, 0);
          //cell.setTile(new StaticTiledMapTile(atlas.findRegion("tile/wall")));
        // }
        //}
        layers.add(layer);
        /*for (int i = 0 ; i<5;i++)
        {
          sprite = new Sprite(atlas.findRegion("tile/wall"));
          sprite.setScale(5000.9f);
          sprite.setPosition(i*100,0);
          q.add(sprite);
        }
        //Vector3 vector = new Vector3(1,1,1);
        //camera.position(vector);
        */

        mapRenderer = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();
        camera.zoom = (float) 1.0;

        sprite = new Sprite(controller.getAtlasRegion(model.getPlayer().getSpriteName()));
        model.getPlayer().setX(mapPixelWidth/2);
        model.getPlayer().setY(mapPixelHeight/2);
        sprite.setPosition(model.getPlayer().getPosition().getX(),model.getPlayer().getPosition().getY());

        font = new BitmapFont();//Gdx.files.internal("data/digib.fnt"),Gdx.files.internal("data/digib.png"), false);;
        keyInfo = new ArrayList<String>();
        mouseInfo = "";

    }

    @Override
    public void draw(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get("Tile Layer 1");

        // apply gravity, when no floor
        double newPredictedYPosition = model.getPlayer().getFallVelocity()+Gdx.graphics.getDeltaTime()*controller.GRAVITY;

        TiledMapTileLayer.Cell gcellLeftCorner = layer.getCell((int) (sprite.getX() / layer.getTileWidth()), (int) ((sprite.getY()-newPredictedYPosition) / layer.getTileHeight()));
        TiledMapTileLayer.Cell gcellRightCorner = layer.getCell((int) (((sprite.getX()-1)+sprite.getWidth()) / layer.getTileWidth()), (int) ((sprite.getY()-newPredictedYPosition) / layer.getTileHeight()));
        TiledMapTileLayer.Cell gcellCenter = layer.getCell((int) ((sprite.getX()+(sprite.getWidth()/2)) / layer.getTileWidth()), (int) ((sprite.getY()-newPredictedYPosition) / layer.getTileHeight()));
        if (gcellLeftCorner == null && gcellRightCorner == null && gcellCenter == null) {
            model.getPlayer().setFallVelocity(newPredictedYPosition);
            double displacement = model.getPlayer().getFallVelocity();
            model.getPlayer().setY(model.getPlayer().getPosition().getY()-(int)displacement);
            camera.translate(0,-(int)displacement,0);

        } else {
            model.getPlayer().setFallVelocity(0);
        }

        if(movingRight) {
            TiledMapTileLayer.Cell cellBottomCorner = layer.getCell((int) ((sprite.getX()+sprite.getWidth()) / layer.getTileWidth()), (int) ((sprite.getY()) / layer.getTileHeight()));
            TiledMapTileLayer.Cell cellTopCorner = layer.getCell((int) ((sprite.getX()+sprite.getWidth()) / layer.getTileWidth()), (int) (((sprite.getY()-1)+sprite.getHeight()) / layer.getTileHeight()));
            TiledMapTileLayer.Cell cellCenter = layer.getCell((int) ((sprite.getX()+sprite.getWidth()) / layer.getTileWidth()), (int) ((sprite.getY()+(sprite.getHeight()/2)) / layer.getTileHeight()));
            if (cellBottomCorner == null && cellTopCorner == null && cellCenter == null) {
                model.getPlayer().setX(model.getPlayer().getPosition().getX()+1);
                camera.translate(1,0,0);
            }

        }
        if(movingLeft) {
            TiledMapTileLayer.Cell cellBottomCorner = layer.getCell((int) ((sprite.getX()-1) / layer.getTileWidth()), (int) (sprite.getY() / layer.getTileHeight()));
            TiledMapTileLayer.Cell cellTopCorner = layer.getCell((int) ((sprite.getX()-1) / layer.getTileWidth()), (int) (((sprite.getY()-1)+sprite.getHeight()) / layer.getTileHeight()));
            TiledMapTileLayer.Cell cellCenter = layer.getCell((int) ((sprite.getX()-1) / layer.getTileWidth()), (int) ((sprite.getY()+(sprite.getHeight()/2)) / layer.getTileHeight()));
            if (cellBottomCorner == null && cellTopCorner == null && cellCenter == null) {
                model.getPlayer().setX(model.getPlayer().getPosition().getX()-1);
                camera.translate(-1, 0, 0);
            }
        }
        if(movingUp) {
            TiledMapTileLayer.Cell cellLeftCorner = layer.getCell((int) (sprite.getX() / layer.getTileWidth()), (int) ((sprite.getY()+sprite.getHeight()) / layer.getTileHeight()));
            TiledMapTileLayer.Cell cellRightCorner = layer.getCell((int) (((sprite.getX()-1)+sprite.getWidth()) / layer.getTileWidth()), (int) ((sprite.getY()+sprite.getHeight()) / layer.getTileHeight()));
            TiledMapTileLayer.Cell cellCenter = layer.getCell((int) ((sprite.getX()+(sprite.getWidth()/2)) / layer.getTileWidth()), (int) ((sprite.getY()+sprite.getHeight()) / layer.getTileHeight()));
            if (cellLeftCorner == null && cellRightCorner == null && cellCenter == null) {
                model.getPlayer().setY(model.getPlayer().getPosition().getY()+1);
                camera.translate(0, 1, 0);
            }
        }
        if(movingDown) {
            TiledMapTileLayer.Cell cellLeftCorner = layer.getCell((int) (sprite.getX() / layer.getTileWidth()), (int) ((sprite.getY()-1) / layer.getTileHeight()));
            TiledMapTileLayer.Cell cellRightCorner = layer.getCell((int) (((sprite.getX()-1)+sprite.getWidth()) / layer.getTileWidth()), (int) ((sprite.getY()-1) / layer.getTileHeight()));
            TiledMapTileLayer.Cell cellCenter = layer.getCell((int) ((sprite.getX()+(sprite.getWidth()/2)) / layer.getTileWidth()), (int) ((sprite.getY()-1) / layer.getTileHeight()));
            if (cellLeftCorner == null && cellRightCorner == null && cellCenter == null) {
                model.getPlayer().setY(model.getPlayer().getPosition().getY()-1);
                camera.translate(0, -1, 0);
            }
        }
        if(zoomIn) {
            camera.zoom -= 0.1;
        }
        if(zoomOut) {
            camera.zoom += 0.1;
        }

        sprite.setPosition(model.getPlayer().getPosition().getX(), model.getPlayer().getPosition().getY());

        mapRenderer.setView(camera);
        mapRenderer.render();
        batch.setProjectionMatrix(camera.combined);

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
        camera.update();

    }

    @Override
    public void resize(int width, int height) {
      camera.viewportWidth = width;
      camera.viewportHeight = height;
      camera.position.set(mapPixelWidth/2f, mapPixelHeight/2f, 0); //by default camera position on (0,0,0)
      camera.update();
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
        System.out.println((char) (keycode + 68));
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
