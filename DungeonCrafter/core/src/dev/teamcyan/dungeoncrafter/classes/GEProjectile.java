package dev.teamcyan.dungeoncrafter.classes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.utils.Array;

public class GEProjectile extends GameElement {
    Velocity velocity;
    private TextureRegion region;
    private TextureRegion charStand;
    private Texture enemySpriteSheet;

    public GEProjectile (Pos position, Pos destination)
    {
        this.getype = GEType.DEFAULT;
        this.position = new Pos(position.getX(), position.getY());
        this.velocity = new Velocity(destination.getX() > position.getX() ? 1 : -1, destination.getY() > position.getY() ? 1 : -1);

        this.enemySpriteSheet = new Texture("sprites/enemy/enemyArcher.png");
        this.charStand = new TextureRegion(enemySpriteSheet, 0, 640, CHAR_PIXEL_WIDTH, CHAR_PIXEL_HEIGHT);

        this.region = charStand;
    }

    public float setX(TiledMapTileLayer layer) {
        // apply gravity, when no floor
        float delta = Gdx.graphics.getDeltaTime();
        float newXVelocity = this.velocity.getX();

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

        float newYVelocity = this.velocity.getY();// + delta * this.GRAVITY;

        double newYPosition = this.position.getY() + newYVelocity;
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

    /*public void setRegion() {
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
    }*/

    public TextureRegion getRegion(){
        return this.region;
    }
}
