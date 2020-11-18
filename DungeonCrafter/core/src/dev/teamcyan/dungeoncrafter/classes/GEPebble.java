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

public class GEPebble extends GameElement
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

    public GEPebble ()
    {
        this.getype = GEType.PLAYER;
        this.velocity = new Velocity(0,0);
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

    public float setX(TiledMapTileLayer layer, Pos playerPosition) {
        // apply gravity, when no floor
        float delta = Gdx.graphics.getDeltaTime();
        float newXVelocity;

        double distance = Math.sqrt(Math.pow((playerPosition.getX() - this.position.getX()), 2) + Math.pow((playerPosition.getY() - this.position.getY()), 2));
        if (this.velocity.getY() > 1) {
            newXVelocity = this.velocity.getX();
        } else if (distance > 80) {
            if (playerPosition.getX() > this.position.getX()) {
                newXVelocity = this.velocity.getX() + this.ACCELERATION * delta;
            } else {
                newXVelocity = this.velocity.getX() - this.ACCELERATION * delta;
            }
        } else {
            newXVelocity = this.velocity.getX() * this.RESISTANCE;
            newXVelocity = newXVelocity > -0.000000001 && newXVelocity < 0.000000001 ? 0 : newXVelocity;
        }

        double newXPosition = this.position.getX() + newXVelocity;

        if(newXVelocity > 0) {
            TiledMapTileLayer.Cell topRight = layer.getCell((int) ((newXPosition + this.region.getRegionWidth()) / layer.getTileWidth()), (int) Math.floor((this.position.getY() + this.region.getRegionHeight()) / layer.getTileHeight()));
            TiledMapTileLayer.Cell bottomRight = layer.getCell((int)((newXPosition + this.region.getRegionWidth()) / layer.getTileWidth()), (int) Math.ceil(this.position.getY() / layer.getTileHeight()));
            if (bottomRight == null && topRight == null) {
                this.velocity.setX(newXVelocity);
                this.position.setX((int)Math.ceil(newXPosition));
            } else {
                this.velocity.setX((float)0.0);
            }

        } else if (newXVelocity < 0) {
            TiledMapTileLayer.Cell topLeft = layer.getCell((int) Math.floor(newXPosition / layer.getTileWidth()), (int) Math.floor((this.position.getY() + this.region.getRegionHeight()) / layer.getTileHeight()));
            TiledMapTileLayer.Cell bottomLeft = layer.getCell((int) Math.floor(newXPosition / layer.getTileWidth()), (int) Math.ceil(this.position.getY() / layer.getTileHeight()));
            if (bottomLeft == null && topLeft == null) {
                this.velocity.setX(newXVelocity);
                this.position.setX((int)Math.floor(newXPosition));
            } else {
                this.position.setX((float)0.0);
            }
        }
        return this.position.getX();
    }

    public float setY(TiledMapTileLayer layer) {

        // apply gravity, when no floor
        float delta = Gdx.graphics.getDeltaTime();

        float newYVelocity = this.velocity.getY() + delta * this.GRAVITY;

        double newYPosition = this.position.getY() - Math.floor(newYVelocity);
        TiledMapTileLayer.Cell leftBottom = layer.getCell((int) Math.floor(this.position.getX() / layer.getTileWidth()), (int) Math.floor(newYPosition / layer.getTileHeight()));
        TiledMapTileLayer.Cell rightBottom = layer.getCell((int) Math.floor((this.position.getX()+this.region.getRegionWidth()-1) / layer.getTileWidth()), (int) Math.floor(newYPosition / layer.getTileHeight()));
        if (leftBottom == null && rightBottom == null) {
            this.velocity.setY(newYVelocity);
            this.position.setY((int)newYPosition);

        } else {
            this.velocity.setY(0);
        }
        return this.position.getY();
    }

    public void setRegion() {
        if (this.velocity.getY() >1) {
            this.currentState = GameElement.State.JUMPING;
            System.out.println("JUmp");

        } else if(this.velocity.getY() < -1) {
            this.currentState = GameElement.State.FALLING;
            System.out.println("fall");

        } else if (this.velocity.getX() < -1) {
            this.currentState = GameElement.State.RUNNINGL;
        } else if (this.velocity.getX() > 1) {
            this.currentState = GameElement.State.RUNNINGR;
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
