package dev.teamcyan.dungeoncrafter.classes;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * GameElement class is a parent class
 */
public class GameElement{
  public static final float GRAVITY = (float) 9.81;
  public static final float JUMPACCELERATION = (float) 230;
  public static final float RESISTANCE = (float) 0.2;
  public static final float ACCELERATION = (float) 5.0;
  public final static int CHAR_PIXEL_WIDTH = 64;
  public final static int CHAR_PIXEL_HEIGHT = 64;
  public enum State {RUNNINGL, RUNNINGR, JUMPING, STANDING, FALLING, MININGL, MININGR, MININGD, MININGU, ATTACKL, ATTACKR };

  protected String uid;
  protected Pos position;
  protected boolean visible;
  protected int health;
  protected String spriteName;
  protected boolean collision;
  protected GEType getype;

  public void init(){
    // method for initialising
  }

  public void render(){
    // method for rendering
  }

  public void create(){
    // method for creating the GE
  }

  public void destroy(){
  }

  public void interactA(){
  }

  public void interactB(){
  }

  public void die(){
  }

  public String getSpriteName(){
    return this.spriteName;
  }

  public Pos getPosition() {
    return this.position;
  }

}
