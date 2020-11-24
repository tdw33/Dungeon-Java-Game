package dev.teamcyan.dungeoncrafter.classes;

import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;


public class GMap extends GameElement {
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
  //private TiledMapTileLayer boostLayer;
  private TiledMapTileSet tileSet;


///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
// Constructor 
//
///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////

  public GMap(String mapName) {
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

    this.terrainLayer = (TiledMapTileLayer) mapLayers.get("environment_layer");
    this.backgroundLayer = (TiledMapTileLayer) mapLayers.get("background_layer");
    //this.boostLayer = (TiledMapTileLayer) mapLayers.get("boost_layer");

    this.tileSet = map.getTileSets().getTileSet("default_dirt");
  }


///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
// Internal methods
//
///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////

  /**
   * Returns true if tile exists on layer and false if it does not 
   **/
  private boolean tileExists(TilePos tPos, TiledMapTileLayer layer) {
    TiledMapTileLayer.Cell tileHere = layer.getCell(tPos.getX(), tPos.getY());
    if(tileHere != null){
      return true;
    }
    return false;
  }

  /**
   * Convert the Pos to a TilePos
   * Returns a TilePos
   **/
  private TilePos convertToTilePos(Pos pos) {
    int x = (int)(pos.getX() / tileWidth); 
    int y = (int)(pos.getY() / tileHeight);
    return new TilePos(x,y); 
  }

  /**
   * Returns the y of  position of a tile  
   * */
  private void tileDestroy(TilePos tPos, TiledMapTileLayer layer) {
    if (tileExists(tPos, layer)) {
      layer.getCell(tPos.getX(), tPos.getY()).setTile(null);
      layer.setCell(tPos.getX(), tPos.getY(), null);
    }
  }

  /**
   * Digs to the left 3 squares
   **/
  public void interactBlock(Pos pos){
    TilePos tPos1 = convertToTilePos(pos);
    TilePos tPos2 = convertToTilePos(pos);
    TilePos tPos3 = convertToTilePos(pos);

    System.out.println(tPos1);

    tPos1.setX(tPos1.getX() - 1);
    tPos1.setY(tPos1.getY() - 1);

    tPos2.setX(tPos2.getX() - 1);
    tPos2.setY(tPos2.getY());

    tPos3.setX(tPos3.getX() - 1);
    tPos3.setY(tPos3.getY() + 1);

    tileDestroy(tPos1, terrainLayer);
    tileDestroy(tPos2, terrainLayer);
    tileDestroy(tPos3, terrainLayer);

    return;
  }

  public void setBlock(Pos pos){
    TilePos tPos = convertToTilePos(pos);
    TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
    cell.setTile(tileSet.getTile(1));
    terrainLayer.setCell(tPos.getX(), tPos.getY(), cell);
  }


///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
// Get and Set methods
//
///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////

  public TiledMapTileLayer.Cell getBlock(Pos pos) {
    TilePos tPos = convertToTilePos(pos);
    return terrainLayer.getCell(tPos.getX(), tPos.getY());
  }

  public TiledMapTile getBackgroundTile(Pos pos){
    TilePos tPos = convertToTilePos(pos);
    return backgroundLayer.getCell(tPos.getX(), tPos.getY()).getTile();
  }

  public TiledMapTileLayer getTerainLayer(){
    return this.terrainLayer;
  }

  public TiledMap getTiledMap() {
    return this.map;
  }


  public OrthogonalTiledMapRenderer getMapRenderer() {
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
