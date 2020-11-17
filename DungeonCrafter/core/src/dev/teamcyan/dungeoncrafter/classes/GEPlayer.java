package dev.teamcyan.dungeoncrafter.classes;

import com.badlogic.gdx.Gdx;
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

  public GEPlayer () {
    this.getype = GEType.PLAYER;
    this.velocity = new Velocity(0, 0);

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

  public Pos getPosition() {
      return new Pos(this.region.getRegionX(), this.region.getRegionY());
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

    float newXPosition = this.region.getRegionX() + newXVelocity;

    if(newXVelocity > 0) {
      TiledMapTileLayer.Cell topRight = layer.getCell((int) ((newXPosition + this.region.getRegionWidth()) / layer.getTileWidth()), (int) Math.floor((this.region.getRegionY() + this.region.getRegionHeight()) / layer.getTileHeight()));
      TiledMapTileLayer.Cell bottomRight = layer.getCell((int)((newXPosition + this.region.getRegionWidth()) / layer.getTileWidth()), (int) Math.ceil(this.region.getRegionY() / layer.getTileHeight()));
      if (bottomRight == null && topRight == null) {
        this.velocity.setX(newXVelocity);
        this.region.setRegionX((int)newXPosition);
      } else {
        this.velocity.setX((float)0.0);
      }

    } else if (newXVelocity < 0) {
      TiledMapTileLayer.Cell topLeft = layer.getCell((int) Math.floor(newXPosition / layer.getTileWidth()), (int) Math.floor((this.region.getRegionY() + this.region.getRegionHeight()) / layer.getTileHeight()));
      TiledMapTileLayer.Cell bottomLeft = layer.getCell((int) Math.floor(newXPosition / layer.getTileWidth()), (int) Math.ceil(this.region.getRegionY() / layer.getTileHeight()));
      if (bottomLeft == null && topLeft == null) {
        this.velocity.setX(newXVelocity);
        this.region.setRegionX((int)newXPosition);
      } else {
        this.velocity.setX((float)0.0);
      }
    }
    return this.region.getRegionX();

  }

  public float setY(TiledMapTileLayer layer, boolean movingUp, boolean movingDown) {

  // apply gravity, when no floor
    float delta = Gdx.graphics.getDeltaTime();

    float newYVelocity = this.velocity.getY() + delta * this.GRAVITY;

    float newYPosition = this.region.getRegionY() - newYVelocity;// - Math.floor(newYVelocity);
    TiledMapTileLayer.Cell leftBottom = layer.getCell((int) Math.floor(this.region.getRegionX() / layer.getTileWidth()), (int) Math.floor(newYPosition / layer.getTileHeight()));
    TiledMapTileLayer.Cell rightBottom = layer.getCell((int) Math.floor((this.region.getRegionX()+this.region.getRegionWidth()-1) / layer.getTileWidth()), (int) Math.floor(newYPosition / layer.getTileHeight()));
    if (leftBottom == null && rightBottom == null) {
      this.velocity.setY(newYVelocity);
      this.region.setRegionY((int)newYPosition);
    } else {
      this.velocity.setY(0);
    }


    if(movingUp) {
      TiledMapTileLayer.Cell cellLeftCorner = layer.getCell((int) (this.region.getRegionX() / layer.getTileWidth()), (int) ((this.region.getRegionY()+this.region.getRegionHeight()) / layer.getTileHeight()));
      TiledMapTileLayer.Cell cellRightCorner = layer.getCell((int) (((this.region.getRegionX()-1)+this.region.getRegionWidth()) / layer.getTileWidth()), (int) ((this.region.getRegionY()+this.region.getRegionHeight()) / layer.getTileHeight()));
      if (cellLeftCorner == null && cellRightCorner == null) {
        this.region.setRegionY(this.region.getRegionY()+1);
      }
    }

    return this.region.getRegionY();
  }

  public TextureRegion getRegion(){
    currentState = getState();
    stateTimer += Gdx.graphics.getDeltaTime();

    if (currentState == State.RUNNINGL ){
      region = charRunL.getKeyFrame(stateTimer, true);;
    } else if (currentState == State.RUNNINGR){
      region = charRunR.getKeyFrame(stateTimer, true);
    } else if (currentState == State.JUMPING){
      region = charJump;
    } else if (currentState == State.FALLING) {
      region = charFall;
    } else {
      region = charStand;
    }

    previousState = currentState;
    return region;

  }

}
