package dev.teamcyan.dungeoncrafter.classes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.utils.Array;

public class GEPlayer extends GameElement
{
  GameModel model;
  public enum BLOCK {GOLD, STEEL};

  Velocity velocity;
  private TextureRegion region;
  private Texture basicSpriteSheet;
  private Animation<TextureRegion> charRunL;
  private TextureRegion charFall;
  private Animation<TextureRegion> charRunR;
  private Animation<TextureRegion> charMineL;
  private Animation<TextureRegion> charMineR;
  private TextureRegion charStand;
  private TextureRegion charJump;
  public float stateTimer = 0;
  public State currentState;
  public State previousState;
  private int health = 100;
  private int gold = 0;
  private int steel = 0;
  private BLOCK currentCraftingBlock = BLOCK.STEEL;

  public GEPlayer (GameModel model) {
    this.model = model;
    this.getype = GEType.PLAYER;
    this.velocity = new Velocity(0, 0);
    this.position = new Pos(0,0);
    this.basicSpriteSheet = new Texture("sprites/mainCharacter/characterPickaxe.png");
    this.currentState = State.STANDING;
    this.previousState = State.STANDING;

    this.charStand = new TextureRegion(basicSpriteSheet, 0, 649, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT-12);
    this.charJump = new TextureRegion(basicSpriteSheet, 64, 1280, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT);
    this.charFall = new TextureRegion(basicSpriteSheet, 128, 1280, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT);

    this.region = charStand;

    Array<TextureRegion> frames = new Array<TextureRegion>();
    for (int i = 0; i < 9; i++) {
      frames.add(new TextureRegion(this.basicSpriteSheet, i*64, 713, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT-12));
    }
    this.charRunR = new Animation(0.15f, frames);
    frames.clear();

    for (int i = 0; i < 9; i++) {
      frames.add(new TextureRegion(this.basicSpriteSheet, i*64, 587, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT-12));
    }
    this.charRunL = new Animation(0.15f, frames);
    frames.clear();

    for (int i = 5; i > 0; i--) {
      frames.add(new TextureRegion(this.basicSpriteSheet, i*64, 843, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT-12));
    }
    this.charMineL = new Animation(0.15f, frames);
    frames.clear();

    for (int i = 5; i > 0; i--) {
      frames.add(new TextureRegion(this.basicSpriteSheet, i*64, 969, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT-12));
    }
    this.charMineR = new Animation(0.15f, frames);
    frames.clear();
  }

  public int getHealth() {
    return this.health;
  }

  public void incrementGold() {
    this.gold += 1;
  }
  public boolean decrementGold() {
    if (this.gold > 0) {
      this.gold -= 1;
      return true;
    }
    return false;
  }
  public void incrementSteel() {
    this.steel += 1;
  }
  public boolean decrementSteel() {
    if (this.steel > 0) {
      this.steel -= 1;
      return true;
    }
    return false;
  }

  public int getGold() {
    return this.gold;
  }

  public int getSteel() {
    return this.steel;
  }

  public void setCurrentCraftingBlock(BLOCK block) {
    this.currentCraftingBlock = block;
  }
  public void decrementHealth(int damage) {
    this.health -= damage;
  }
  public void setName(String spriteName) {
      this.spriteName = spriteName;
  }


  public float setX(TiledMapTileLayer layer, boolean movingLeft, boolean movingRight) {
    float delta = Gdx.graphics.getDeltaTime();
    float newXVelocity;
    if (this.velocity.getY() < -1) {
      newXVelocity = this.velocity.getX();
    } else if (movingLeft == movingRight) {
      newXVelocity = this.velocity.getX() * this.RESISTANCE;
      newXVelocity = newXVelocity > -0.000000001 && newXVelocity < 0.000000001 ? 0 : newXVelocity;
    } else if (movingRight) {
      newXVelocity = this.velocity.getX() + this.ACCELERATION * delta;
    } else {
      newXVelocity = this.velocity.getX() - this.ACCELERATION * delta;
    }

    float newXPosition = this.position.getX() + newXVelocity;

    if(newXVelocity > 0) {
      TiledMapTileLayer.Cell topRight = layer.getCell((int) ((newXPosition + this.region.getRegionWidth()) / layer.getTileWidth()), (int) Math.floor((this.position.getY() + this.region.getRegionHeight()) / layer.getTileHeight()));
      TiledMapTileLayer.Cell bottomRight = layer.getCell((int)((newXPosition + this.region.getRegionWidth()) / layer.getTileWidth()), (int) Math.ceil(this.position.getY() / layer.getTileHeight()));
      if (bottomRight == null && topRight == null) {
        this.velocity.setX(newXVelocity);
        this.position.setX((int)newXPosition);
      } else {
        this.velocity.setX((float)0.0);
      }

    } else if (newXVelocity < 0) {
      TiledMapTileLayer.Cell topLeft = layer.getCell((int) Math.floor(newXPosition / layer.getTileWidth()), (int) Math.floor((this.position.getY() + this.region.getRegionHeight()) / layer.getTileHeight()));
      TiledMapTileLayer.Cell bottomLeft = layer.getCell((int) Math.floor(newXPosition / layer.getTileWidth()), (int) Math.ceil(this.position.getY() / layer.getTileHeight()));
      if (bottomLeft == null && topLeft == null) {
        this.velocity.setX(newXVelocity);
        this.position.setX((int)newXPosition);
      } else {
        this.velocity.setX((float)0.0);
      }
    }
    return this.position.getX();

  }

  public float setY(TiledMapTileLayer layer, KeyListener keyListener) {
    TiledMapTile currentBackgroundTile = model.getMap().getBackgroundTile(new Pos(this.position.getX()+this.region.getRegionWidth()/2, this.position.getY()+this.region.getRegionHeight()/2));
    float gravity;
    if (currentBackgroundTile.getProperties().get("inverseGravity") != null) {
      gravity = this.GRAVITY * (-1);
    } else {
      gravity = this.GRAVITY;
    }
    // apply gravity, when no floor
    float delta = Gdx.graphics.getDeltaTime();

    float newYVelocity = this.velocity.getY() - delta * gravity;

    float newYPosition = this.position.getY() + newYVelocity;// - Math.floor(newYVelocity);
    TiledMapTileLayer.Cell leftBottom = layer.getCell((int) Math.floor(this.position.getX() / layer.getTileWidth()), (int) Math.floor(newYPosition / layer.getTileHeight()));
    TiledMapTileLayer.Cell rightBottom = layer.getCell((int) Math.floor((this.position.getX()+this.region.getRegionWidth()-1) / layer.getTileWidth()), (int) Math.floor(newYPosition / layer.getTileHeight()));
    if (leftBottom == null && rightBottom == null) {
      this.velocity.setY(newYVelocity);
      this.position.setY((int)newYPosition);
    } else {
      if(keyListener.activeKeys.contains(Input.Keys.UP)) {
        keyListener.activeKeys.remove(keyListener.activeKeys.indexOf(Input.Keys.UP));
        TiledMapTileLayer.Cell cellLeftCorner = layer.getCell((int) (this.position.getX() / layer.getTileWidth()), (int) ((this.position.getY()+this.region.getRegionHeight()) / layer.getTileHeight()));
        TiledMapTileLayer.Cell cellRightCorner = layer.getCell((int) (((this.position.getX()-1)+this.region.getRegionWidth()) / layer.getTileWidth()), (int) ((this.position.getY()+this.region.getRegionHeight()) / layer.getTileHeight()));
        if (cellLeftCorner == null && cellRightCorner == null) {
          newYVelocity = this.velocity.getY() + delta * this.JUMPACCELERATION;
          this.velocity.setY(newYVelocity);
          newYPosition = this.position.getY() + newYVelocity;// - Math.floor(newYVelocity);
          this.position.setY(newYPosition);
        }
      } else {
        if (this.velocity.getY() > 0) {
          this.velocity.setY(newYVelocity);
          this.position.setY(newYPosition);

        } else {
          this.velocity.setY(0);
        }

      }
    }




    return this.position.getY();
  }

  public void setRegion(KeyListener keyListener) {

    if(keyListener.activeKeys.contains(Input.Keys.UP) ||
            keyListener.activeKeys.contains(Input.Keys.DOWN) &&
                    this.previousState == GameElement.State.JUMPING){

      this.currentState = GameElement.State.JUMPING;
    }  else if(keyListener.activeKeys.contains(Input.Keys.D) &&
            !keyListener.activeKeys.contains(Input.Keys.UP) &&
            !keyListener.activeKeys.contains(Input.Keys.DOWN)) {

      this.currentState = GameElement.State.MININGL;
    }else if(keyListener.activeKeys.contains(Input.Keys.G) &&
            !keyListener.activeKeys.contains(Input.Keys.UP) &&
            !keyListener.activeKeys.contains(Input.Keys.DOWN)) {

      this.currentState = GameElement.State.MININGR;
    }else if(keyListener.activeKeys.contains(Input.Keys.LEFT) &&
       !keyListener.activeKeys.contains(Input.Keys.UP) &&
       !keyListener.activeKeys.contains(Input.Keys.DOWN)){

      this.currentState = GameElement.State.RUNNINGL;
    } else if (keyListener.activeKeys.contains(Input.Keys.RIGHT) &&
            !keyListener.activeKeys.contains(Input.Keys.UP) &&
            !keyListener.activeKeys.contains(Input.Keys.DOWN)){

      this.currentState = GameElement.State.RUNNINGR;
    } else if(keyListener.activeKeys.contains(Input.Keys.DOWN)) {

      this.currentState = GameElement.State.FALLING;
    } else {

      this.currentState = GameElement.State.STANDING;
    }

    stateTimer += Gdx.graphics.getDeltaTime();

    if (this.currentState == State.RUNNINGL ){
      region = charRunL.getKeyFrame(stateTimer, true);;
    } else if (this.currentState == State.RUNNINGR){
      region = charRunR.getKeyFrame(stateTimer, true);
    } else if (this.currentState == State.JUMPING){
      region = charJump;
    } else if (this.currentState == State.MININGL){
      region = charMineL.getKeyFrame(stateTimer, true);
    } else if (this.currentState == State.MININGR){
      region = charMineR.getKeyFrame(stateTimer, true);
    }else if (this.currentState == State.FALLING) {
      region = charFall;
    } else {
      region = charStand;
    }

    previousState = currentState;
  }

  public TextureRegion getRegion(){
    return this.region;
  }

}
