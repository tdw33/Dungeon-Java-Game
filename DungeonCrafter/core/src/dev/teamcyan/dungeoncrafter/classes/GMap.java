package dev.teamcyan.dungeoncrafter.classes;
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
import dev.teamcyan.dungeoncrafter.classes.Pos;
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
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3 ;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import java.util.ArrayList;


public class GMap extends GameElement{
  
  private TiledMap map;
  private int mapWidth;
  private int mapHeight;
  private int tileWidth;
  private int tileHeight;

  private int mapPixelWidth ;
  private int mapPixelHeight ;

  private OrthogonalTiledMapRenderer mapRenderer;
  private TiledMapTileLayer terrainLayer;
  private TiledMapTileLayer backgroundLayer;
  private TiledMapTileLayer lavaLayer;
  private TiledMapTileSet tileSet;

  public GMap(String mapName)
  {
    // load the map
    TmxMapLoader loader = new TmxMapLoader();
    map = loader.load(mapName);
    // surface the map properties
    MapProperties prop = map.getProperties();
    this.mapWidth = prop.get("width", Integer.class);
    this.mapHeight = prop.get("height", Integer.class);
    this.tileWidth = prop.get("tilewidth", Integer.class);
    this.tileHeight = prop.get("tileheight", Integer.class);
    this.mapPixelWidth = mapWidth * tileWidth;
    this.mapPixelHeight = mapHeight * tileHeight;
    this.mapRenderer = new OrthogonalTiledMapRenderer(map);
    MapLayers mapLayers = this.map.getLayers();
    this.terrainLayer = (TiledMapTileLayer) mapLayers.get(2);
    this.backgroundLayer = (TiledMapTileLayer) mapLayers.get(1);
    this.lavaLayer = (TiledMapTileLayer) mapLayers.get(0);
    this.tileSet = map.getTileSets().getTileSet("default_dirt");
  }

  public void interactBlock(Pos pos){
    
    // dig to the left
    int x = (int)(pos.getX() / tileWidth)-1; 
    int y =  (int)(pos.getY() / tileHeight);
    TiledMapTileLayer.Cell here = terrainLayer.getCell(x,y);
    if(here != null){
      here.setTile(null);
      terrainLayer.setCell(x,y,null);
    }
    
    // dig to the left above
    x = (int)(pos.getX() / tileWidth)-1; 
    y =  (int)(pos.getY() / tileHeight)+1;
    here = terrainLayer.getCell(x,y);
    if(here != null){
      here.setTile(null);
      terrainLayer.setCell(x,y,null);
    }
    
    // dig to the left below
    x = (int)(pos.getX() / tileWidth)-1; 
    y =  (int)(pos.getY() / tileHeight)-1;
    here = terrainLayer.getCell(x,y);
    if(here != null){
      here.setTile(null);
      terrainLayer.setCell(x,y,null);
    }
    return;
  }

  public void digBlock(Pos pos){
    int x = (int)(pos.getX() / tileHeight)-1; 
    int y =  (int)(pos.getY() / tileWidth)-1;
    TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
    cell.setTile(tileSet.getTile(1));
    terrainLayer.setCell(x,y,cell);
    return;
  }


  public void destroyGEAtPos(Pos position)
  {
  }

  public TiledMap getTiledMap()
  {
    return this.map;
  }


  public OrthogonalTiledMapRenderer getMapRenderer()
  {
    return this.mapRenderer;
  }

  public int getMapPixelWidth() {
    return mapPixelWidth;
  }

  public int getMapPixelHeight() {
    return mapPixelHeight;
  }

  /*
+ mapInit(Seed):Map
  public */
}
