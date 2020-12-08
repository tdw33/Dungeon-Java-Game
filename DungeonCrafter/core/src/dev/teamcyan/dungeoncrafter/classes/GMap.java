package dev.teamcyan.dungeoncrafter.classes;

import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import java.util.Objects;

/**
 * Gmap is the map class of the game
 */
public class GMap extends GameElement {
  private GameModel model;
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


/**
 * GMap Constructor
 * 
 * @param model the GameModel which it is part of 
 * 
 * @param mapName the .txf file which it uses as a starting map
 */
  public GMap(GameModel model, String mapName) {
    // load the map
    this.model = model;
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

  /**
   * A method of interogating if a tile exists at a specific tPos on a named layer
   * 
   * @param tPos receives the position of the tile as a TilePos already converted
   * @param layer receives the TiledMapLyayer of the layer to search for
   * @return Returns true if tile exists on layer and false if it does not 
   */
  private boolean tileExists(TilePos tPos, TiledMapTileLayer layer) {
    TiledMapTileLayer.Cell tileHere = layer.getCell(tPos.getX(), tPos.getY());
    if(tileHere != null){
      return true;
    }
    return false;
  }
/**
 * 
 * @param tPos
 * @param layer
 * @return
 */
  private boolean tileHasHealth(TilePos tPos, TiledMapTileLayer layer) {
    TiledMapTileLayer.Cell tileHere = layer.getCell(tPos.getX(), tPos.getY());
    if (tileHere.getTile().getProperties().get("block_health") != null) {
      return true;
    }
    return false;
  }

 
  /**
   * Method to easily convert from Pos to a TilePos
   * @param pos global position
   * @return Returns the equivalent TilePos coordinate of the Pos
   */
  private TilePos convertToTilePos(Pos pos) {
    int x = (int)(pos.getX() / tileWidth); 
    int y = (int)(pos.getY() / tileHeight);
    return new TilePos(x,y); 
  }

  /**
   * Destroys (empties) the tile at the specifice position 
   * @param tPos TilePos of the tile to be destroyed
   * @param layer Layer where the Tile can be found
   */
  private void tileDestroy(TilePos tPos, TiledMapTileLayer layer) {
    if (tileExists(tPos, layer)) {
      String cellType = layer.getCell(tPos.getX(), tPos.getY()).getTile().getTextureRegion().getTexture().toString();
      if (Objects.equals(cellType,"sprites/rocks/default_stone.png")) {
        this.model.getPlayer().incrementStone();
      } else if (Objects.equals(cellType,"sprites/precious/default_steel_block.png")) {
        this.model.getPlayer().incrementIron();
      } else if (Objects.equals(cellType,"sprites/precious/default_gold_block.png")) {
        this.model.getPlayer().incrementGold();
      } else {
        this.model.getPlayer().incrementDirt();
      }

      layer.getCell(tPos.getX(), tPos.getY()).setTile(null);
      layer.setCell(tPos.getX(), tPos.getY(), null);
    }
  }

  /**
   * Method to attack a tile and reduce its health. When the health falls under 0 the tile is destroyed
   * @param tPos
   * @param layer
   * @return boolean
   */
  private boolean tileAttack(TilePos tPos, TiledMapTileLayer layer) {
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
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Interact with blocks to the right
   * @param pos
   * @return
   */
  public boolean interactBlockRight(Pos pos){
    boolean broken = false;

    TilePos tPos1 = convertToTilePos(pos);
    tPos1.setX(tPos1.getX() + 1);
    tPos1.setY(tPos1.getY());
    broken = broken | tileAttack(tPos1, terrainLayer);

    TilePos tPos2 = convertToTilePos(pos);
    tPos2.setX(tPos2.getX() + 1);
    tPos2.setY(tPos2.getY() + 1);
    broken = broken | tileAttack(tPos2, terrainLayer);

    TilePos tPos3 = convertToTilePos(pos);
    tPos3.setX(tPos3.getX() + 2);
    tPos3.setY(tPos3.getY());
    broken = broken | tileAttack(tPos3, terrainLayer);

    TilePos tPos4 = convertToTilePos(pos);
    tPos4.setX(tPos4.getX() + 2);
    tPos4.setY(tPos4.getY() + 1);
    broken = broken | tileAttack(tPos4, terrainLayer);

    return broken;
  }

   /**
   * Interact with blocks to the left
   * @param pos
   * @return
   */
  public boolean interactBlockLeft(Pos pos){
    boolean broken = false;

    TilePos tPos1 = convertToTilePos(pos);
    tPos1.setX(tPos1.getX() - 1);
    tPos1.setY(tPos1.getY());
    broken = broken | tileAttack(tPos1, terrainLayer);

    TilePos tPos2 = convertToTilePos(pos);
    tPos2.setX(tPos2.getX() - 1);
    tPos2.setY(tPos2.getY() + 1);
    broken = broken | tileAttack(tPos2, terrainLayer);

    TilePos tPos3 = convertToTilePos(pos);
    tPos3.setX(tPos3.getX() - 2);
    tPos3.setY(tPos3.getY());
    broken = broken | tileAttack(tPos3, terrainLayer);

    TilePos tPos4 = convertToTilePos(pos);
    tPos4.setX(tPos4.getX() - 2);
    tPos4.setY(tPos4.getY() + 1);
    broken = broken | tileAttack(tPos4, terrainLayer);

    return broken;
  }

   /**
   * Interact with blocks above
   * @param pos
   * @return
   */
  public boolean interactBlockUp(Pos pos){
    boolean broken = false;

    TilePos tPos1 = convertToTilePos(pos);
    tPos1.setX(tPos1.getX() + 1);
    tPos1.setY(tPos1.getY() + 1);
    broken = broken | tileAttack(tPos1, terrainLayer);

    TilePos tPos2 = convertToTilePos(pos);
    tPos2.setX(tPos2.getX() );
    tPos2.setY(tPos2.getY() + 1);
    broken = broken |tileAttack(tPos2, terrainLayer);

    TilePos tPos3 = convertToTilePos(pos);
    tPos3.setX(tPos3.getX() - 1);
    tPos3.setY(tPos3.getY() + 1);
    broken = broken |tileAttack(tPos3, terrainLayer);

    TilePos tPos4 = convertToTilePos(pos);
    tPos4.setX(tPos4.getX() + 1);
    tPos4.setY(tPos4.getY() + 2);
    broken = broken | tileAttack(tPos4, terrainLayer);

    TilePos tPos5 = convertToTilePos(pos);
    tPos5.setX(tPos5.getX());
    tPos5.setY(tPos5.getY() + 2);
    broken = broken | tileAttack(tPos5, terrainLayer);

    TilePos tPos6 = convertToTilePos(pos);
    tPos6.setX(tPos6.getX() - 1);
    tPos6.setY(tPos6.getY() + 2);
    broken = broken | tileAttack(tPos6, terrainLayer);

    return broken;
  }

    /**
   * Interact with blocks under
   * @param pos
   * @return
   */
  public boolean interactBlockCentre(Pos pos){
    boolean broken = false;

    TilePos tPos1 = convertToTilePos(pos);
    tPos1.setX(tPos1.getX());
    tPos1.setY(tPos1.getY() - 1);
    broken = broken | tileAttack(tPos1, terrainLayer);

    TilePos tPos2 = convertToTilePos(pos);
    tPos2.setX(tPos2.getX());
    tPos2.setY(tPos2.getY());
    broken = broken |tileAttack(tPos2, terrainLayer);

    TilePos tPos3 = convertToTilePos(pos);
    tPos3.setX(tPos3.getX());
    tPos3.setY(tPos3.getY() + 1);
    broken = broken |tileAttack(tPos3, terrainLayer);

    TilePos tPos4 = convertToTilePos(pos);
    tPos4.setX(tPos4.getX() - 1);
    tPos4.setY(tPos4.getY() - 1);
    broken = broken | tileAttack(tPos4, terrainLayer);

    TilePos tPos5 = convertToTilePos(pos);
    tPos5.setX(tPos5.getX() + 1);
    tPos5.setY(tPos5.getY() - 1);
    broken = broken | tileAttack(tPos5, terrainLayer);

    return broken;
  }

  /**
   * Place block to the left
   * @param pos
   */
  public void setBlockLeft(Pos pos){
    TilePos tPos = convertToTilePos(pos);
    TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
    if (model.getPlayer().getCurrentCraftingBlock() == GEPlayer.BLOCK.STONE) {
      cell.setTile(map.getTileSets().getTileSet("default_stone").getTile(113));
    } else {
      cell.setTile(tileSet.getTile(81));
    }
    terrainLayer.setCell(tPos.getX()-1, tPos.getY(), cell);
  }

  /**
   * Place block to the right
   * @param pos
   */
  public void setBlockRight(Pos pos){
    TilePos tPos = convertToTilePos(pos);
    TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
    if (model.getPlayer().getCurrentCraftingBlock() == GEPlayer.BLOCK.STONE) {
      cell.setTile(map.getTileSets().getTileSet("default_stone").getTile(113));
    } else {
      cell.setTile(map.getTileSets().getTileSet("default_dirt").getTile(81));
    }
    terrainLayer.setCell(tPos.getX()+1, tPos.getY(), cell);
  }

///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
// Get and Set methods
//
///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////

/**
 * Returns the cell block from the foreground layer
 * @param pos
 * @return
 */
  public TiledMapTileLayer.Cell getBlock(Pos pos) {
    TilePos tPos = convertToTilePos(pos);
    return terrainLayer.getCell(tPos.getX(), tPos.getY());
  }
/**
 * 
 * @param pos
 * @return
 */
  public TiledMapTile getBackgroundTile(Pos pos){
    TilePos tPos = convertToTilePos(pos);
    return backgroundLayer.getCell(tPos.getX(), tPos.getY()).getTile();
  }

  /**
   * Returns the Terrain layer
   * @return
   */
  public TiledMapTileLayer getTerainLayer(){
    return this.terrainLayer;
  }

  /**
   * Returns the Map Object
   * @return
   */
  public TiledMap getTiledMap() {
    return this.map;
  }

  /**
   * Returns the health of a tile as an int
   * @param tPos
   * @param layer
   * @return int
   */
  private int tileGetHealth(TilePos tPos, TiledMapTileLayer layer) {
    int health = (int)terrainLayer.getCell(tPos.getX(), tPos.getY()).getTile().getProperties().get("block_health");
    return health;
  }

  /**
   * Sets the health of a tile as an int
   * @param tPos
   * @param layer
   * @param value
   */
  private void tileSetHealth(TilePos tPos, TiledMapTileLayer layer, int value) {
    terrainLayer.getCell(tPos.getX(), tPos.getY()).getTile().getProperties().put("block_health", value);
    return;
  }

  /**
   * Returns the map Renderer for the GMap Element
   * @return
   */
  public OrthogonalTiledMapRenderer getMapRenderer() {
    return this.mapRenderer;
  }

  /**
   * Returns the width of a cell
   * @return
   */
  public int getMapPixelWidth() {
    return mapPixelWidth;
  }

  /**
   * Returns the Height of a cell
   * @return
   */
  public int getMapPixelHeight() {
    return mapPixelHeight;
  }
}
