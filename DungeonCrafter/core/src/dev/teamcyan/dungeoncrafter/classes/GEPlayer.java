package dev.teamcyan.dungeoncrafter.classes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.utils.Array;

public class GEPlayer extends GameElement
{

  Velocity velocity;
  private TextureRegion region;
  private Texture basicSpriteSheet;
  private Animation<TextureRegion> charRunL;
  private TextureRegion charFall;
  private Animation<TextureRegion> charRunR;
  private TextureRegion charStand;
  private TextureRegion charJump;
  public float stateTimer = 0;
  public State currentState;
  public State previousState;

  public GEPlayer () {
    this.getype = GEType.PLAYER;
    this.velocity = new Velocity(0, 0);
    this.position = new Pos(0,0);
    this.basicSpriteSheet = new Texture("sprites/mainCharacter/characterPickaxe.png");
    this.currentState = State.STANDING;
    this.previousState = State.STANDING;

    this.charStand = new TextureRegion(basicSpriteSheet, 0, 640, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT);
    this.charJump = new TextureRegion(basicSpriteSheet, 64, 1280, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT);
    this.charFall = new TextureRegion(basicSpriteSheet, 128, 1280, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT);

    this.region = charStand;

    Array<TextureRegion> frames = new Array<TextureRegion>();
    for (int i = 0; i < 9; i++) {
      frames.add(new TextureRegion(this.basicSpriteSheet, i*64, 704, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT));
    }
    this.charRunR = new Animation(0.15f, frames);
    frames.clear();

    for (int i = 0; i < 9; i++) {
      frames.add(new TextureRegion(this.basicSpriteSheet, i*64, 576, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT));
    }
    this.charRunL = new Animation(0.15f, frames);
    frames.clear();
  }

  public void setName(String spriteName) {
      this.spriteName = spriteName;
  }


  public float setX(TiledMapTileLayer layer, boolean movingLeft, boolean movingRight) {
    float delta = Gdx.graphics.getDeltaTime();
    float newXVelocity;
    if (this.velocity.getY() > 1) {
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

  public float setY(TiledMapTileLayer layer, boolean movingUp, boolean movingDown) {

  // apply gravity, when no floor
    float delta = Gdx.graphics.getDeltaTime();

    float newYVelocity = this.velocity.getY() + delta * this.GRAVITY;

    float newYPosition = this.position.getY() - newYVelocity;// - Math.floor(newYVelocity);
    TiledMapTileLayer.Cell leftBottom = layer.getCell((int) Math.floor(this.position.getX() / layer.getTileWidth()), (int) Math.floor(newYPosition / layer.getTileHeight()));
    TiledMapTileLayer.Cell rightBottom = layer.getCell((int) Math.floor((this.position.getX()+this.region.getRegionWidth()-1) / layer.getTileWidth()), (int) Math.floor(newYPosition / layer.getTileHeight()));
    if (leftBottom == null && rightBottom == null) {
      this.velocity.setY(newYVelocity);
      this.position.setY((int)newYPosition);

    } else {
      this.velocity.setY(0);
    }


    if(movingUp) {
      TiledMapTileLayer.Cell cellLeftCorner = layer.getCell((int) (this.position.getX() / layer.getTileWidth()), (int) ((this.position.getY()+this.region.getRegionHeight()) / layer.getTileHeight()));
      TiledMapTileLayer.Cell cellRightCorner = layer.getCell((int) (((this.position.getX()-1)+this.region.getRegionWidth()) / layer.getTileWidth()), (int) ((this.position.getY()+this.region.getRegionHeight()) / layer.getTileHeight()));
      if (cellLeftCorner == null && cellRightCorner == null) {
        this.position.setY(this.position.getY()+1);
      }
    }

    return this.position.getY();
  }

  public void setRegion(KeyListener keyListener) {

    if(keyListener.activeKeys.contains(Input.Keys.LEFT) &&
       !keyListener.activeKeys.contains(Input.Keys.UP) &&
       !keyListener.activeKeys.contains(Input.Keys.DOWN)){

      this.currentState = GameElement.State.RUNNINGL;
    } else if (keyListener.activeKeys.contains(Input.Keys.RIGHT) &&
            !keyListener.activeKeys.contains(Input.Keys.UP) &&
            !keyListener.activeKeys.contains(Input.Keys.DOWN)){

      this.currentState = GameElement.State.RUNNINGR;
    } else if(keyListener.activeKeys.contains(Input.Keys.UP) ||
            keyListener.activeKeys.contains(Input.Keys.DOWN) &&
            this.previousState == GameElement.State.JUMPING){

      this.currentState = GameElement.State.JUMPING;
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
    } else if (this.currentState == State.FALLING) {
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
