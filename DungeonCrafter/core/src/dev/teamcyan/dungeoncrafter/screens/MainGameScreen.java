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

import dev.teamcyan.dungeoncrafter.DungeonCrafter;

public class MainGameScreen implements Screen {
    SpriteBatch batch = new SpriteBatch();
    TextureAtlas atlas;
    boolean movingRight = false;
    boolean movingLeft = false;
    boolean movingUp = false;
    boolean movingDown = false;
    Sprite sprite;
    List <Sprite> q = new ArrayList<>();
    private OrthogonalTiledMapRenderer mapRenderer;
    private TiledMap map;
    private OrthographicCamera camera;


    DungeonCrafter game;

    public MainGameScreen(DungeonCrafter game) {
        this.game = game;
    }

    @Override
    public void show() {
      atlas = new TextureAtlas("textures.atlas");

      sprite = new Sprite(atlas.findRegion("tile/wall"));
      sprite.setScale(50.9f);
      sprite.setPosition(100,0);

      TmxMapLoader loader = new TmxMapLoader();
      map = loader.load("tile/TileMap.tmx");

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
     

        mapRenderer = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();

        for (int i = 0 ; i<5;i++)
        {
          sprite = new Sprite(atlas.findRegion("tile/wall"));
          sprite.setScale(50.9f);
          sprite.setPosition(i*100,0);
          q.add(sprite);
        }
        //Vector3 vector = new Vector3(1,1,1);
        //camera.position(vector);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.translate(5,5,0);
        camera.update();

        mapRenderer.setView(camera);
        mapRenderer.render();
    }

    @Override
    public void resize(int width, int height) {
      camera.viewportWidth = width;
      camera.viewportHeight = height;
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
        atlas.dispose();
        map.dispose();
    }

}
