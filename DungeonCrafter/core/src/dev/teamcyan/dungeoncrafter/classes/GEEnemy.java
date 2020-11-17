package dev.teamcyan.dungeoncrafter.classes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.utils.Array;

public class GEEnemy extends GameElement
{

    Velocity velocity;
    private TextureRegion region;
    private Animation<TextureRegion> enemyShoot;
    private Texture enemySpriteSheet;

    public GEEnemy ()
    {
        this.getype = GEType.PLAYER;
        this.velocity = new Velocity(0,0);
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

        double distance = Math.sqrt(Math.pow((playerPosition.getX() - this.region.getRegionX()), 2) + Math.pow((playerPosition.getY() - this.region.getRegionY()), 2));
        if (this.velocity.getY() > 1) {
            newXVelocity = this.velocity.getX();
        } else if (distance > 80) {
            if (playerPosition.getX() > this.region.getRegionX()) {
                newXVelocity = this.velocity.getX() + this.ACCELERATION * delta;
            } else {
                newXVelocity = this.velocity.getX() - this.ACCELERATION * delta;
            }
        } else {
            newXVelocity = this.velocity.getX() * this.RESISTANCE;
            newXVelocity = newXVelocity > -0.000000001 && newXVelocity < 0.000000001 ? 0 : newXVelocity;
        }

        double newXPosition = this.region.getRegionX() + newXVelocity;

        if(newXVelocity > 0) {
            TiledMapTileLayer.Cell topRight = layer.getCell((int) ((newXPosition + this.region.getRegionWidth()) / layer.getTileWidth()), (int) Math.floor((this.region.getRegionY() + this.region.getRegionHeight()) / layer.getTileHeight()));
            TiledMapTileLayer.Cell bottomRight = layer.getCell((int)((newXPosition + this.region.getRegionWidth()) / layer.getTileWidth()), (int) Math.ceil(this.region.getRegionY() / layer.getTileHeight()));
            if (bottomRight == null && topRight == null) {
                this.velocity.setX(newXVelocity);
                this.region.setRegionX((int)Math.ceil(newXPosition));
            } else {
                this.velocity.setX((float)0.0);
            }

        } else if (newXVelocity < 0) {
            TiledMapTileLayer.Cell topLeft = layer.getCell((int) Math.floor(newXPosition / layer.getTileWidth()), (int) Math.floor((this.region.getRegionY() + this.region.getRegionHeight()) / layer.getTileHeight()));
            TiledMapTileLayer.Cell bottomLeft = layer.getCell((int) Math.floor(newXPosition / layer.getTileWidth()), (int) Math.ceil(this.region.getRegionY() / layer.getTileHeight()));
            if (bottomLeft == null && topLeft == null) {
                this.velocity.setX(newXVelocity);
                this.region.setRegionX((int)Math.floor(newXPosition));
            } else {
                this.region.setRegionX(0);
            }
        }
        return this.region.getRegionX();
    }

    public float setY(TiledMapTileLayer layer) {

        // apply gravity, when no floor
        float delta = Gdx.graphics.getDeltaTime();

        float newYVelocity = this.velocity.getY() + delta * this.GRAVITY;

        double newYPosition = this.region.getRegionY() - Math.floor(newYVelocity);
        TiledMapTileLayer.Cell leftBottom = layer.getCell((int) Math.floor(this.region.getRegionX() / layer.getTileWidth()), (int) Math.floor(newYPosition / layer.getTileHeight()));
        TiledMapTileLayer.Cell rightBottom = layer.getCell((int) Math.floor((this.region.getRegionX()+this.region.getRegionWidth()-1) / layer.getTileWidth()), (int) Math.floor(newYPosition / layer.getTileHeight()));
        if (leftBottom == null && rightBottom == null) {
            this.velocity.setY(newYVelocity);
            this.region.setRegionY((int)newYPosition);

        } else {
            this.velocity.setY(0);
        }
        return this.region.getRegionY();
    }

    public TextureRegion getRegion() {
        stateTimer += Gdx.graphics.getDeltaTime();
        region = enemyShoot.getKeyFrame(stateTimer, true);

        return region;
    }

}