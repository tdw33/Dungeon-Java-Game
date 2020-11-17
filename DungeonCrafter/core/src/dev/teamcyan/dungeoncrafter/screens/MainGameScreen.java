package dev.teamcyan.dungeoncrafter.screens;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.utils.Array;
import dev.teamcyan.dungeoncrafter.DungeonCrafter;
import dev.teamcyan.dungeoncrafter.classes.GEPlayer;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.*;

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
    private TextureRegion[] charFrames;
    private static int CHAR_PIXEL_WIDTH = 64;
    private static int CHAR_PIXEL_HEIGHT = 64;
    private int index = 0;
    private Texture spriteSheet;
    private enum State {RUNNINGL, RUNNINGR, JUMPING, STANDING, FALLING };
    private State currentState;
    private State previousState;
    private Animation<TextureRegion> charRunL;
    private TextureRegion charFall;
    private Animation<TextureRegion> charRunR;
    private TextureRegion charStand;
    private TextureRegion charJump;
    private TextureRegion region;
    private float stateTimer = 0;
    private float deltaTime = Gdx.graphics.getDeltaTime();



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
                camera.translate((int)Math.ceil(newXVelocity),0,0);
            } else {
                model.getPlayer().getVelocity().setX(0.0);
            }

        } else if (newXVelocity < 0) {
            TiledMapTileLayer.Cell topLeft = layer.getCell((int) Math.floor(newXPosition / layer.getTileWidth()), (int) Math.floor((model.getPlayer().getPosition().getY() + sprite.getHeight()) / layer.getTileHeight()));
            TiledMapTileLayer.Cell bottomLeft = layer.getCell((int) Math.floor(newXPosition / layer.getTileWidth()), (int) Math.ceil(model.getPlayer().getPosition().getY() / layer.getTileHeight()));
            if (bottomLeft == null && topLeft == null) {
                model.getPlayer().getVelocity().setX(newXVelocity);
                model.getPlayer().getPosition().setX((int)Math.floor(newXPosition));
                camera.translate((int)Math.floor(newXVelocity),0,0);
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
            camera.translate(0,-(int)newYVelocity,0);

        } else {
            model.getPlayer().getVelocity().setY(0);
        }


        if(movingUp) {
            TiledMapTileLayer.Cell cellLeftCorner = layer.getCell((int) (sprite.getX() / layer.getTileWidth()), (int) ((sprite.getY()+sprite.getHeight()) / layer.getTileHeight()));
            TiledMapTileLayer.Cell cellRightCorner = layer.getCell((int) (((sprite.getX()-1)+sprite.getWidth()) / layer.getTileWidth()), (int) ((sprite.getY()+sprite.getHeight()) / layer.getTileHeight()));
            if (cellLeftCorner == null && cellRightCorner == null) {
                model.getPlayer().setY(model.getPlayer().getPosition().getY()+1);
                camera.translate(0, 1, 0);
            }
        }

    }

    @Override
    public void draw(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



        currentState = State.STANDING;
        previousState = State.STANDING;

        charFrames = new TextureRegion[274];
        Array<TextureRegion> frames = new Array<TextureRegion>();
        spriteSheet = new Texture("sprites/character/charactersheet.png");



        charStand = new TextureRegion(spriteSheet, 0, 640, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT);
        charJump = new TextureRegion(spriteSheet, 64, 1280, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT);
        charFall = new TextureRegion(spriteSheet, 128, 1280, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT);
        for (int i = 0; i < 9; i++) {
                frames.add(new TextureRegion(spriteSheet, i*64, 704, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT));
            }

        charRunR = new Animation(0.15f, frames);
        frames.clear();
        for (int i = 0; i < 9; i++) {
            frames.add(new TextureRegion(spriteSheet, i*64, 576, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT));
        }
        charRunL = new Animation(0.15f, frames);
        frames.clear();
        region = getFrame();





        if(zoomIn) {
            camera.zoom -= 0.1;
        }
        if(zoomOut) {
            camera.zoom += 0.1;
        }

        TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get("Tile Layer 1");
        setPosition(model.getPlayer(), layer);
        sprite.setPosition(model.getPlayer().getPosition().getX(), model.getPlayer().getPosition().getY());
        mapRenderer.setView(camera);
        mapRenderer.render();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        /*for (Sprite s : q) {
            batch.draw(s, s.getX(), s.getY(), s.getWidth(),s.getHeight()); // this will be diffrent when you have nummbers at end eg player_1, player_2
        }*/
        batch.draw(region, sprite.getX(), sprite.getY(), sprite.getWidth(),sprite.getHeight()); // this will be diffrent when you have nummbers at end eg player_1, player_2
        batch.draw(charFall, 1750, 700, 64, 64);
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

    public State getState(){
        if(movingLeft && !movingUp && !movingDown){
            return State.RUNNINGL;
        } else if (movingRight && !movingUp && !movingDown){
            return State.RUNNINGR;
        } else if(movingUp || movingDown && previousState == State.JUMPING){
            return State.JUMPING;
        } else if(movingDown) {
            return State.FALLING;
        } else return State.STANDING;
    }

    public TextureRegion getFrame(){
        currentState = getState();
        stateTimer += Gdx.graphics.getDeltaTime();

        TextureRegion region;
        if (currentState == State.RUNNINGL ){
            region = charRunL.getKeyFrame(stateTimer, true);;
        } else if (currentState == State.RUNNINGR){
            region = charRunR.getKeyFrame(stateTimer, true);
        } else if (currentState == State.JUMPING){
            region = charJump;
        } else if (currentState == State.FALLING) {
            region = charFall;
        } else {
            region = charStand;
        }



        previousState = currentState;
        return region;

    }



}
