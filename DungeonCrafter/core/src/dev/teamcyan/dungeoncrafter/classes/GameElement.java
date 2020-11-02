package dev.teamcyan.dungeoncrafter.classes;
import com.badlogic.gdx.graphics.g2d.Sprite;
import java.util.*;
import dev.teamcyan.dungeoncrafter.classes.*;

public class GameElement {

  private String uid;
  private Pos position;
  private boolean visible;
  private int health;
  private Sprite sprite;
  private boolean collision;
  private GEType getype;

  public void init(){
    // method for initialising
  }

  public void render(){
    // method for rendering
  }

  public void create()
  {
    // method for creating the GE
  }

  public void destroy()
  {
  }

  public void interactA()
  {
  }

  public void interactB()
  {
  }

  public void die()
  {
  }
}
