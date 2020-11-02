package dev.teamcyan.dungeoncrafter.classes;
import java.util.*;
import dev.teamcyan.dungeoncrafter.classes.GameElement;

public class GMap{

  private int sizeHorizontal;
  private int sizeVertical;
  private String seed;
  private List<List<GameElement>> gMap = new ArrayList<List<GameElement>>();

  public GameElement getGEAtPos(Pos position){
    return this.gMap[position.getX()][position.getY()];
  }


  destroyGEAtPos(Pos):

+ getMapSize(): Integer

+ setMapSize(): Integer

+ getPlayer():Pos

+ mapInit(Seed):Map
  public 
}
