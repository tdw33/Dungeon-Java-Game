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

  private boolean tileHasHealth(TilePos tPos, TiledMapTileLayer layer) {
    TiledMapTileLayer.Cell tileHere = layer.getCell(tPos.getX(), tPos.getY());
    if (tileHere.getTile().getProperties().get("block_health") != null) {
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


  private void tileAttack(TilePos tPos, TiledMapTileLayer layer) {
    int attack = 5;
    if (tileExists(tPos, layer)) {
      if (tileHasHealth(tPos, layer)){
        if(tileGetHealth(tPos, layer) > 0 ) {
          int tHealth = tileGetHealth(tPos, layer);
          tHealth -= attack;
          System.out.println(tHealth);
          tileSetHealth(tPos, layer, tHealth);
        } else {
          tileDestroy(tPos, layer);
        }
      }
    }

  }

  /**
   * Digs to the left 3 squares
   **/
  public void interactBlockRight(Pos pos){
    TilePos tPos1 = convertToTilePos(pos);
    tPos1.setX(tPos1.getX() + 1);
    tPos1.setY(tPos1.getY() - 1);
    tileAttack(tPos1, terrainLayer);

    TilePos tPos2 = convertToTilePos(pos);
    tPos2.setX(tPos2.getX() + 1 );
    tPos2.setY(tPos2.getY());
    tileAttack(tPos2, terrainLayer);

    TilePos tPos3 = convertToTilePos(pos);
    tPos3.setX(tPos3.getX() + 1);
    tPos3.setY(tPos3.getY() + 1);
    tileAttack(tPos3, terrainLayer);

    return;
  }

  /**
   * Digs to the left 3 squares
   **/
  public void interactBlockLeft(Pos pos){
    TilePos tPos1 = convertToTilePos(pos);
    tPos1.setX(tPos1.getX() - 1);
    tPos1.setY(tPos1.getY() - 1);
    tileAttack(tPos1, terrainLayer);

    TilePos tPos2 = convertToTilePos(pos);
    tPos2.setX(tPos2.getX() - 1);
    tPos2.setY(tPos2.getY());
    tileAttack(tPos2, terrainLayer);

    TilePos tPos3 = convertToTilePos(pos);
    tPos3.setX(tPos3.getX() - 1);
    tPos3.setY(tPos3.getY() + 1);
    tileAttack(tPos3, terrainLayer);
  }

  /**
   * Digs to the centre 3 squares
   **/
  public void interactBlockCentre(Pos pos){
    TilePos tPos1 = convertToTilePos(pos);
    tPos1.setX(tPos1.getX());
    tPos1.setY(tPos1.getY() - 1);
    tileAttack(tPos1, terrainLayer);

    TilePos tPos2 = convertToTilePos(pos);
    tPos2.setX(tPos2.getX());
    tPos2.setY(tPos2.getY());
    tileAttack(tPos2, terrainLayer);

    TilePos tPos3 = convertToTilePos(pos);
    tPos3.setX(tPos3.getX());
    tPos3.setY(tPos3.getY() + 1);
    tileAttack(tPos3, terrainLayer);
  }

  public void setBlockLeft(Pos pos){
    TilePos tPos = convertToTilePos(pos);
    TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
    cell.setTile(tileSet.getTile(1));
    terrainLayer.setCell(tPos.getX()-1, tPos.getY(), cell);
    return;
  }

  public void setBlockRight(Pos pos){
    TilePos tPos = convertToTilePos(pos);
    TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
    cell.setTile(tileSet.getTile(1));
    terrainLayer.setCell(tPos.getX()+1, tPos.getY(), cell);
    return;
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

  /**
   * Returns an int of the tileMap HP
   **/
  private int tileGetHealth(TilePos tPos, TiledMapTileLayer layer) {
    int health = (int)terrainLayer.getCell(tPos.getX(), tPos.getY()).getTile().getProperties().get("block_health");
    return health;
  }

  private void tileSetHealth(TilePos tPos, TiledMapTileLayer layer, int value) {
    terrainLayer.getCell(tPos.getX(), tPos.getY()).getTile().getProperties().put("block_health", value);
    return;
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

}
