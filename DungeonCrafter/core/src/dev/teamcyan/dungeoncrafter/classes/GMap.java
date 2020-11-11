package dev.teamcyan.dungeoncrafter.classes;
import java.util.*;
import dev.teamcyan.dungeoncrafter.classes.GameElement;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;


public class GMap extends GameElement{
  private int sizeHorizontal;
  private int sizeVertical;
  private String seed;
  private GameElement[][] gMap = {};
  private String mapName;
  private GEPlayer player;

  public GMap (int x, int y)
  {
    //initialiser
    setMapSize(x,y);
    placePlayer();
  }

  public GMap()
  {
    //default initialiser
    setMapSize(100,100);
    placePlayer();
    mapName = "tile/TileMap.tmx";
  }

  private void blankMap()
  {
  //  TiledMapTileLayer layer = (TiledMapTileLayer)map.getLayers().get("some_layer_name");
  //  Cell cell = new Cell();
  //  TiledMapTileSet tileSet = map.getTileSets().getTileSet("tileset_name");
  //  cell.setTile(tileSet.getTile(42)); /* or some other id, identifying the tile */
  //  layer.setCell(32, 64, cell); // 32 and 64 being x and y coordinates
  //  for (int i=0;i<100;i++)
  //    for (int j=0;j<100;j++)
  //      Cell cell = new Cell();

  }

  private void placePlayer()
  {
    player = new GEPlayer();
    //player.setX(this.sizeVertical/2);
    //player.setY(this.sizeHorizontal/2);
  }

  public GameElement getGEAtPos(Pos position)
  {
    return this.gMap[position.getY()][position.getX()];
  }


  public void destroyGEAtPos(Pos position)
  {
  }

  public int getMapSizeVert()
  {
    return this.sizeVertical;
  }

  public int getMapSizeHoriz()
  {
    return this.sizeHorizontal;
  }

  private void setMapSize(int x, int y)
  {
    this.sizeVertical = y;
    this.sizeHorizontal = x;
  }

  public Pos getPlayer(){
    return player.getPosition();
  }

  public String getMapName(){
    return mapName;
  }

  /*
+ mapInit(Seed):Map
  public */
}
