package dev.teamcyan.dungeoncrafter.classes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.utils.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The final boss class. Subclass of GEEnemy
 */
public class GEBoss extends GEEnemy{
    public static final float ACCELERATION = (float) 2.0;
    public Velocity velocity;
    private TextureRegion region;
    private Animation<TextureRegion> bossAttackR;
    private Animation<TextureRegion> bossAttackL;
    private Animation<TextureRegion> bossWalkL;
    private Animation<TextureRegion> bossWalkR;
    private Texture bossSpriteSheet;
    private TextureRegion bossStand;
    public float stateTimer = 0;
    public float projectileTimer = 0;
    public State currentState;
    public State previousState;
    public List<GEProjectile> projectiles;
    private int health = 100;
    private boolean isAlive = true;
    private float attackTimer = 0;

    /**
     * Constructor for Game Element Boss 
     * @param model
     * @param position
     */
    public GEBoss (GameModel model, Pos position){
        super(model, position);
        this.getype = GEType.PLAYER;
        this.velocity = new Velocity(0,0);
        this.position = position;
        this.currentState = State.STANDING;
        this.previousState = State.STANDING;
        this.projectiles = new ArrayList<GEProjectile>();
        this.bossSpriteSheet = new Texture("sprites/enemy/boss.png");

        Array<TextureRegion> frames = new Array<TextureRegion>();

        this.bossStand = new TextureRegion(bossSpriteSheet, 0, 649, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT-12);

        for (int i = 5; i > 0; i--) {
            frames.add(new TextureRegion(this.bossSpriteSheet, i*64, 969, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT-12));
        }
        this.bossAttackR = new Animation(0.25f, frames);
        frames.clear();

        for (int i = 5; i > 0; i--) {
            frames.add(new TextureRegion(this.bossSpriteSheet, i*64, 843, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT-12));
        }
        this.bossAttackL = new Animation(0.25f, frames);
        frames.clear();

        for (int i = 0; i < 9; i++) {
            frames.add(new TextureRegion(bossSpriteSheet, i*64, 587, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT-12));
        }
        this.bossWalkL = new Animation(0.15f, frames);
        frames.clear();

        for (int i = 0; i < 9; i++) {
            frames.add(new TextureRegion(bossSpriteSheet, i*64, 713, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT-12));
        }
        this.bossWalkR = new Animation(0.15f, frames);
        frames.clear();
    }

    /**
     * Setter for X
     * @param layer
     * @param playerPosition
     */
    public float setX(TiledMapTileLayer layer, Pos playerPosition) {
        // apply gravity, when no floor
        float delta = Gdx.graphics.getDeltaTime();
        float newXVelocity;

        double distance = Math.sqrt(Math.pow((playerPosition.getX() - this.position.getX()), 2) + Math.pow((playerPosition.getY() - this.position.getY()), 2));
        if (this.velocity.getY() > 1) {
            newXVelocity = this.velocity.getX();
        } else if (distance > 40) {
            if (playerPosition.getX() > this.position.getX()) {
                float newV = this.velocity.getX() + this.ACCELERATION * delta;
                newXVelocity = newV > layer.getTileWidth() ? this.velocity.getX() : newV;
            } else {
                float newV = this.velocity.getX() - this.ACCELERATION * delta;
                newXVelocity = newV < (-1)*layer.getTileWidth() ? this.velocity.getX() : newV;
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
                this.velocity.setY(4f);
                this.velocity.setX((float)0.0);
            }

        } else if (newXVelocity < 0) {
            TiledMapTileLayer.Cell topLeft = layer.getCell((int) Math.floor(newXPosition / layer.getTileWidth()), (int) Math.floor((this.position.getY() + this.region.getRegionHeight()) / layer.getTileHeight()));
            TiledMapTileLayer.Cell bottomLeft = layer.getCell((int) Math.floor(newXPosition / layer.getTileWidth()), (int) Math.ceil(this.position.getY() / layer.getTileHeight()));
            if (bottomLeft == null && topLeft == null) {
                this.velocity.setX(newXVelocity);
                this.position.setX((int)Math.floor(newXPosition));
            } else {
                this.velocity.setY(4f);
                this.velocity.setX(0);
            }
        }
        return this.position.getX();
    }

    /**
     * Setter for Y
     * @param layer
     */
    public float setY(TiledMapTileLayer layer) {
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

        float newYPosition = this.position.getY() + newYVelocity;
        TiledMapTileLayer.Cell leftBottom = layer.getCell((int) Math.ceil(this.position.getX() / layer.getTileWidth()), (int) Math.floor(newYPosition / layer.getTileHeight()));
        TiledMapTileLayer.Cell rightBottom = layer.getCell((int) Math.floor((this.position.getX()+this.region.getRegionWidth()-10) / layer.getTileWidth()), (int) Math.floor(newYPosition / layer.getTileHeight()));
        TiledMapTileLayer.Cell leftTop = layer.getCell((int) Math.ceil(this.position.getX() / layer.getTileWidth()), (int) Math.floor((newYPosition+this.region.getRegionHeight()) / layer.getTileHeight()));
        TiledMapTileLayer.Cell rightTop = layer.getCell((int) Math.floor((this.position.getX()+this.region.getRegionWidth()-10) / layer.getTileWidth()), (int) Math.floor((newYPosition+this.region.getRegionHeight()) / layer.getTileHeight()));
        if ((newYVelocity <= 0 && leftBottom == null && rightBottom == null) || (newYVelocity > 0 && leftTop == null && rightTop == null)) {
            this.velocity.setY(newYVelocity);
            this.position.setY((int)newYPosition);

        } else {
            this.velocity.setY(0);
        }
        return this.position.getY();
    }

    public TextureRegion getRegion() {
        return region;
    }

    /**
     * Setter for Region
     */
    public void setRegion() {
        if (this.velocity.getY() >1) {
            this.currentState = GameElement.State.JUMPING;
        } else if(this.velocity.getY() < -1) {
            this.currentState = GameElement.State.FALLING;
        } else if (this.velocity.getX() < -1) {
            this.currentState = GameElement.State.RUNNINGL;
        } else if (this.velocity.getX() > 1) {
            this.currentState = GameElement.State.RUNNINGR;
        } else if (this.previousState == State.RUNNINGL || this.currentState == State.ATTACKL){
            this.currentState = GameElement.State.ATTACKL;
        } else if (this.previousState == State.RUNNINGR || this.currentState == State.ATTACKR){
            this.currentState = GameElement.State.ATTACKR;
        } else{
            this.currentState = State.STANDING;
        }

        stateTimer += Gdx.graphics.getDeltaTime();

        if (this.currentState == State.RUNNINGL ){
            region =bossWalkL.getKeyFrame(stateTimer, true);;
        } else if (this.currentState == State.RUNNINGR){
            region = bossWalkR.getKeyFrame(stateTimer, true);
        } else if (this.currentState == State.ATTACKL){
            this.attackTimer += Gdx.graphics.getDeltaTime();
            if (this.attackTimer > 1.2) {
                if (super.getDistance(model.getPlayer().getPosition()) < 70 ){
                    model.getPlayer().decrementHealth(5);
                }
                this.attackTimer = 0;
            }
            region = bossAttackL.getKeyFrame(stateTimer, true);
        } else if (this.currentState == State.ATTACKR){
            region = bossAttackR.getKeyFrame(stateTimer, true);
        } else {
            region = bossStand;
        }

        previousState = currentState;
    }

    /**
     * Getter for isAlive Flag 
     */
    public boolean isAlive() {
        return this.isAlive;
    }
}
