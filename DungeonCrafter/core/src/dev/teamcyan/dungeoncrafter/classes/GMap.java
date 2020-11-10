package dev.teamcyan.dungeoncrafter.classes;
import java.util.*;
import dev.teamcyan.dungeoncrafter.classes.GameElement;

public class GMap{

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
