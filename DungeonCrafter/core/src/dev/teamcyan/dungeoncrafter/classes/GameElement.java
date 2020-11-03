package dev.teamcyan.dungeoncrafter.classes;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class GameElement {

  protected String uid;
  protected Pos position;
  protected boolean visible;
  protected int health;
  protected Sprite sprite;
  protected boolean collision;
  protected GEType getype;

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

  public Pos getPosition() {
    return this.position;
  }
}
