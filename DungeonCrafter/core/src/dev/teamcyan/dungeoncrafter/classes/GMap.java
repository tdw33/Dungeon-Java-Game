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


public class GMap extends GameElement{
  
  private TiledMap map;
  private int mapWidth;
  private int mapHeight;
  private int tilePixelWidth;
  private int tilePixelHeight;

  private int mapPixelWidth ;
  private int mapPixelHeight ;

  //private String seed;
  private String mapName;
  private OrthogonalTiledMapRenderer mapRenderer;

  public GMap(String mapName)
  {
    // load the map
    TmxMapLoader loader = new TmxMapLoader();
    map = loader.load(mapName);
    
    // surface the map properties
    MapProperties prop = map.getProperties();
    this.mapWidth = prop.get("width", Integer.class);
    this.mapHeight = prop.get("height", Integer.class);
    this.tilePixelWidth = prop.get("tilewidth", Integer.class);
    this.tilePixelHeight = prop.get("tileheight", Integer.class);
    this.mapPixelWidth = mapWidth * tilePixelWidth;
    this.mapPixelHeight = mapHeight * tilePixelHeight;
    this.mapRenderer = new OrthogonalTiledMapRenderer(map);
  }


  public void getGEAtPos(Pos position)
  {
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


  /*
+ mapInit(Seed):Map
  public */
}
