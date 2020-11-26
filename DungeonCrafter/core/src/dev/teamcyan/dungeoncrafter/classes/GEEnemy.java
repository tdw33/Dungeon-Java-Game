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

import java.util.ArrayList;
import java.util.List;

public class GEEnemy extends GameElement
{
    public static final float ACCELERATION = (float) 2.0;

    Velocity velocity;
    private TextureRegion region;
    private Animation<TextureRegion> enemyShoot;
    private Texture enemySpriteSheet;
    public float stateTimer = 0;
    public float projectileTimer = 0;
    public State currentState;
    public State previousState;
    public List<GEProjectile> projectiles;
    public GameModel model;

    public GEEnemy (GameModel model)
    {
        this.model = model;
        this.getype = GEType.PLAYER;
        this.velocity = new Velocity(0,0);
        this.position = new Pos(0,0);
        this.currentState = State.STANDING;
        this.previousState = State.STANDING;
        this.projectiles = new ArrayList<GEProjectile>();
        this.enemySpriteSheet = new Texture("sprites/enemy/enemyArcher.png");

        Array<TextureRegion> frames = new Array<TextureRegion>();
        for (int i = 0; i < 13; i++) {
            frames.add(new TextureRegion(enemySpriteSheet, i*64, 1088, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT));
        }
        this.enemyShoot = new Animation(0.5f, frames);
        this.region = enemyShoot.getKeyFrame(stateTimer, true);
        frames.clear();

    }

    public float setX(TiledMapTileLayer layer, Pos playerPosition) {
        // apply gravity, when no floor
        float delta = Gdx.graphics.getDeltaTime();
        float newXVelocity;

        double distance = Math.sqrt(Math.pow((playerPosition.getX() - this.position.getX()), 2) + Math.pow((playerPosition.getY() - this.position.getY()), 2));
        if (this.velocity.getY() > 1) {
            newXVelocity = this.velocity.getX();
        } else if (distance > 300) {
            if (playerPosition.getX() > this.position.getX()) {
                float newV = this.velocity.getX() + this.ACCELERATION * delta;
                newXVelocity = newV > layer.getTileWidth() ? this.velocity.getX() : newV;
            } else {
                float newV = this.velocity.getX() - this.ACCELERATION * delta;
                newXVelocity = newV < layer.getTileWidth() ? this.velocity.getX() : newV;
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
                this.velocity.setX(0);
            }
        }
        return this.position.getX();
    }

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

        float newYVelocity = this.velocity.getY() + delta * gravity;

        float newYPosition = this.position.getY() - newYVelocity;
        TiledMapTileLayer.Cell leftBottom = layer.getCell((int) Math.ceil(this.position.getX() / layer.getTileWidth()), (int) Math.floor(newYPosition / layer.getTileHeight()));
        TiledMapTileLayer.Cell rightBottom = layer.getCell((int) Math.floor((this.position.getX()+this.region.getRegionWidth()-10) / layer.getTileWidth()), (int) Math.floor(newYPosition / layer.getTileHeight()));
        TiledMapTileLayer.Cell leftTop = layer.getCell((int) Math.ceil(this.position.getX() / layer.getTileWidth()), (int) Math.floor((newYPosition+this.getRegion().getRegionHeight()) / layer.getTileHeight()));
        TiledMapTileLayer.Cell rightTop = layer.getCell((int) Math.floor((this.position.getX()+this.region.getRegionWidth()-10) / layer.getTileWidth()), (int) Math.floor((newYPosition+this.getRegion().getRegionHeight()) / layer.getTileHeight()));
        if ((newYVelocity <= 0 && leftBottom == null && rightBottom == null) || (newYVelocity > 0 && leftTop == null && rightTop == null)) {
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
        } else if(this.velocity.getY() < -1) {
            this.currentState = GameElement.State.FALLING;
        } else if (this.velocity.getX() < -1) {
            this.currentState = GameElement.State.RUNNINGL;
        } else if (this.velocity.getX() > 1) {
            this.currentState = GameElement.State.RUNNINGR;
        } else {
            this.currentState = GameElement.State.STANDING;
        }

        stateTimer += Gdx.graphics.getDeltaTime();

        /*if (this.currentState == State.RUNNINGL ){
            region = charRunL.getKeyFrame(stateTimer, true);;
        } else if (this.currentState == State.RUNNINGR){
            region = charRunR.getKeyFrame(stateTimer, true);
        } else if (this.currentState == State.JUMPING){
            region = charJump;
        } else if (this.currentState == State.FALLING) {
            region = charFall;
        } else {
            region = charStand;
        }*/

        previousState = currentState;

        region = enemyShoot.getKeyFrame(stateTimer, true);
    }

    public TextureRegion getRegion() {
        return region;
    }

    public List<GEProjectile> getProjectiles(TiledMapTileLayer layer, Pos playerPosition) {
        this.projectileTimer += Gdx.graphics.getDeltaTime();
        if (this.projectileTimer > 3) {
            projectiles.add(new GEProjectile(this.model, this.position, playerPosition));
            this.projectileTimer = 0;
        }

        List<GEProjectile> projectilesToRemove = new ArrayList<GEProjectile>();
        for (GEProjectile proj : this.projectiles) {

            if (!proj.setPosition(layer)) {
                projectilesToRemove.add(proj);
            }
        }
        this.projectiles.removeAll(projectilesToRemove);

        return this.projectiles;
    }
}