package dev.teamcyan.dungeoncrafter.classes;
import java.util.*;
import dev.teamcyan.dungeoncrafter.classes.GameElement;

public class GMap{

  private int sizeHorizontal;
  private int sizeVertical;
  private String seed;
  private List<List<GameElement>> gMap = new ArrayList<List<GameElement>>();
  private GEPlayer;

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
  }

  private placePlayer()
  {
    GEPlayer = new GEPlayer();
    GEPlayer.setX(this.sizeVertical/2);
    GEPlayer.setY(this.sizeHorizontal/2);
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

+ getPlayer():Pos

+ mapInit(Seed):Map
  public 
}
