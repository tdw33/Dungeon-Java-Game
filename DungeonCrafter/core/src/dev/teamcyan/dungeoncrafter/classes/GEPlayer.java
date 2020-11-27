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
import dev.teamcyan.dungeoncrafter.DungeonCrafter;
import dev.teamcyan.dungeoncrafter.screens.GameOverScreen;

public class GEPlayer extends GameElement
{
  GameModel model;
  DungeonCrafter controller;
  public enum BLOCK {DIRT, STONE, IRON};

  Velocity velocity;
  private TextureRegion region;
  private Texture basicSpriteSheet;
  private Animation<TextureRegion> charRunL;
  private TextureRegion charFall;
  private Animation<TextureRegion> charRunR;
  private Animation<TextureRegion> charMineL;
  private Animation<TextureRegion> charMineR;
  private Animation<TextureRegion> charMineD;
  private TextureRegion charStand;
  private TextureRegion charJump;
  private Texture ironSpriteSheet;
  private Animation<TextureRegion> ironCharRunL;
  private TextureRegion ironCharFall;
  private Animation<TextureRegion> ironCharRunR;
  private Animation<TextureRegion> ironCharMineL;
  private Animation<TextureRegion> ironCharMineR;
  private Animation<TextureRegion> ironCharMineD;
  private TextureRegion ironCharStand;
  private TextureRegion ironCharJump;
  private Texture goldSpriteSheet;
  private Animation<TextureRegion> goldCharRunL;
  private TextureRegion goldCharFall;
  private Animation<TextureRegion> goldCharRunR;
  private Animation<TextureRegion> goldCharMineL;
  private Animation<TextureRegion> goldCharMineR;
  private Animation<TextureRegion> goldCharMineD;
  private TextureRegion goldCharStand;
  private TextureRegion goldCharJump;
  public float stateTimer = 0;
  public State currentState;
  public State previousState;
  private int health = 100;
  private int stone = 0;
  private int iron = 0;
  private int dirt = 0;
  private BLOCK currentCraftingBlock = BLOCK.DIRT;

  public GEPlayer (GameModel model, DungeonCrafter controller) {
    this.controller = controller;
    this.model = model;
    this.getype = GEType.PLAYER;
    this.velocity = new Velocity(0, 0);
    this.position = new Pos(0,0);
    this.basicSpriteSheet = new Texture("sprites/mainCharacter/characterPickaxe.png");
    this.ironSpriteSheet = new Texture("sprites/mainCharacter/steelCharacterPickaxe.png");
    this.goldSpriteSheet = new Texture("sprites/mainCharacter/goldCharacterPickaxe.png");
    this.currentState = State.STANDING;
    this.previousState = State.STANDING;


    // basic character frames

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
      frames.add(new TextureRegion(this.basicSpriteSheet, i*64, 905, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT-12));
    }
    this.charMineD = new Animation(0.15f, frames);
    frames.clear();

    for (int i = 5; i > 0; i--) {
      frames.add(new TextureRegion(this.basicSpriteSheet, i*64, 969, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT-12));
    }
    this.charMineR = new Animation(0.15f, frames);
    frames.clear();



    //iron armour frames

    this.ironCharStand = new TextureRegion(ironSpriteSheet, 0, 649, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT-12);
    this.ironCharJump = new TextureRegion(ironSpriteSheet, 64, 1280, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT);
    this.ironCharFall = new TextureRegion(ironSpriteSheet, 128, 1280, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT);

    this.region = ironCharStand;

    for (int i = 0; i < 9; i++) {
      frames.add(new TextureRegion(this.ironSpriteSheet, i*64, 713, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT-12));
    }
    this.ironCharRunR = new Animation(0.15f, frames);
    frames.clear();

    for (int i = 0; i < 9; i++) {
      frames.add(new TextureRegion(this.ironSpriteSheet, i*64, 587, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT-12));
    }
    this.ironCharRunL = new Animation(0.15f, frames);
    frames.clear();

    for (int i = 5; i > 0; i--) {
      frames.add(new TextureRegion(this.ironSpriteSheet, i*64, 843, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT-12));
    }
    this.ironCharMineL = new Animation(0.15f, frames);
    frames.clear();

    for (int i = 5; i > 0; i--) {
      frames.add(new TextureRegion(this.ironSpriteSheet, i*64, 905, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT-12));
    }
    this.ironCharMineD = new Animation(0.15f, frames);
    frames.clear();

    for (int i = 5; i > 0; i--) {
      frames.add(new TextureRegion(this.ironSpriteSheet, i*64, 969, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT-12));
    }
    this.ironCharMineR = new Animation(0.15f, frames);
    frames.clear();



    // gold armour

    this.goldCharStand = new TextureRegion(goldSpriteSheet, 0, 649, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT-12);
    this.goldCharJump = new TextureRegion(goldSpriteSheet, 64, 1280, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT);
    this.goldCharFall = new TextureRegion(goldSpriteSheet, 128, 1280, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT);

    this.region = goldCharStand;

    for (int i = 0; i < 9; i++) {
      frames.add(new TextureRegion(this.goldSpriteSheet, i*64, 713, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT-12));
    }
    this.goldCharRunR = new Animation(0.15f, frames);
    frames.clear();

    for (int i = 0; i < 9; i++) {
      frames.add(new TextureRegion(this.goldSpriteSheet, i*64, 587, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT-12));
    }
    this.goldCharRunL = new Animation(0.15f, frames);
    frames.clear();

    for (int i = 5; i > 0; i--) {
      frames.add(new TextureRegion(this.goldSpriteSheet, i*64, 843, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT-12));
    }
    this.goldCharMineL = new Animation(0.15f, frames);
    frames.clear();

    for (int i = 5; i > 0; i--) {
      frames.add(new TextureRegion(this.goldSpriteSheet, i*64, 905, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT-12));
    }
    this.goldCharMineD = new Animation(0.15f, frames);
    frames.clear();

    for (int i = 5; i > 0; i--) {
      frames.add(new TextureRegion(this.goldSpriteSheet, i*64, 969, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT-12));
    }
    this.goldCharMineR = new Animation(0.15f, frames);
    frames.clear();


  }

  public BLOCK getCurrentCraftingBlock() {
    return this.currentCraftingBlock;
  }

  public int getHealth() {
    return this.health;
  }

  public void incrementDirt() {
    this.dirt += 1;
  }
  public boolean decrementDirt() {
    if (this.dirt > 0) {
      this.dirt -= 1;
      return true;
    }
    return false;
  }
  public void incrementIron() {
    this.iron += 1;
  }
  public boolean decrementIron() {
    if (this.iron > 0) {
      this.iron -= 1;
      return true;
    }
    return false;
  }
  public void incrementStone() {
    this.stone += 1;
  }
  public boolean decrementStone() {
    if (this.stone > 0) {
      this.stone -= 1;
      return true;
    }
    return false;
  }

  public int getIron() {
    return this.iron;
  }

  public int getStone() {
    return this.stone;
  }

  public int getDirt() {
    return this.dirt;
  }

  public void setCurrentCraftingBlock(BLOCK block) {
    this.currentCraftingBlock = block;
  }
  public void decrementHealth(int damage) {
    this.health -= damage;
    if (this.health <= 0) {
      this.controller.changeScreen(GameOverScreen.class);
      model.deactivate();
    }
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
      float newV = this.velocity.getX() + this.ACCELERATION * delta;
      newXVelocity = newV > layer.getTileWidth() ? this.velocity.getX() : newV;
    } else {
      float newV = this.velocity.getX() - this.ACCELERATION * delta;
      newXVelocity = newV < (-1)*layer.getTileWidth() ? this.velocity.getX() : newV;
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
    TiledMapTileLayer.Cell leftBottom = layer.getCell((int) Math.ceil(this.position.getX() / layer.getTileWidth()), (int) Math.floor(newYPosition / layer.getTileHeight()));
    TiledMapTileLayer.Cell rightBottom = layer.getCell((int) Math.floor((this.position.getX()+this.region.getRegionWidth()-10) / layer.getTileWidth()), (int) Math.floor(newYPosition / layer.getTileHeight()));
    TiledMapTileLayer.Cell leftTop = layer.getCell((int) Math.ceil(this.position.getX() / layer.getTileWidth()), (int) Math.floor((newYPosition+this.getRegion().getRegionHeight()) / layer.getTileHeight()));
    TiledMapTileLayer.Cell rightTop = layer.getCell((int) Math.floor((this.position.getX()+this.region.getRegionWidth()-10) / layer.getTileWidth()), (int) Math.floor((newYPosition+this.getRegion().getRegionHeight()) / layer.getTileHeight()));
    if ((newYVelocity <= 0 && leftBottom == null && rightBottom == null) || (newYVelocity > 0 && leftTop == null && rightTop == null)) {
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
    }  else if(keyListener.activeKeys.contains(Input.Keys.A)) {

      this.currentState = GameElement.State.MININGL;
    }else if(keyListener.activeKeys.contains(Input.Keys.D)) {

      this.currentState = GameElement.State.MININGR;
    }else if(keyListener.activeKeys.contains(Input.Keys.S)) {

      this.currentState = GameElement.State.MININGD;
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

    if (this.currentState == State.RUNNINGL){
      if(this.health <= 100){
        region = charRunL.getKeyFrame(stateTimer, true);
      } else if (this.health <= 200) {
        region = ironCharRunL.getKeyFrame(stateTimer, true);
      } else{
        region = goldCharRunL.getKeyFrame(stateTimer, true);
      }
    } else if (this.currentState == State.RUNNINGR){
      if(this.health <= 100){
        region = charRunR.getKeyFrame(stateTimer, true);
      } else if (this.health <= 200) {
        region = ironCharRunR.getKeyFrame(stateTimer, true);
      } else{
        region = goldCharRunR.getKeyFrame(stateTimer, true);
      }
    } else if (this.currentState == State.JUMPING){
      if(this.health <= 100){
        region = charJump;
      } else if (this.health <= 200) {
        region = ironCharJump;
      } else{
        region = goldCharJump;
      }
    } else if (this.currentState == State.MININGL){
        if(this.health <= 100){
          region = charMineL.getKeyFrame(stateTimer, true);
        } else if (this.health <= 200) {
          region = ironCharMineL.getKeyFrame(stateTimer, true);
        } else{
          region = goldCharMineL.getKeyFrame(stateTimer, true);
        }
    } else if (this.currentState == State.MININGR){
        if(this.health <= 100){
          region = charMineR.getKeyFrame(stateTimer, true);
        }  else if (this.health <= 200) {
          region = ironCharMineR.getKeyFrame(stateTimer, true);
        } else{
          region = goldCharMineR.getKeyFrame(stateTimer, true);
        }
    } else if (this.currentState == State.MININGD){
      if(this.health <= 100){
        region = charMineD.getKeyFrame(stateTimer, true);
      } else if (this.health <= 200) {
        region = ironCharMineD.getKeyFrame(stateTimer, true);
      } else{
        region = goldCharMineD.getKeyFrame(stateTimer, true);
      }
    }else if (this.currentState == State.FALLING) {
      if(this.health <= 100){
        region = charFall;
      } else if (this.health <= 200) {
        region = ironCharFall;
      } else{
        region = goldCharFall;
      }
    } else {
      if(this.health <= 100){
        region = charStand;
      }  else if (this.health <= 200) {
        region = ironCharStand;
      } else{
        region = goldCharStand;
      }
    }

    previousState = currentState;
  }

  public TextureRegion getRegion(){
    return this.region;
  }

}
