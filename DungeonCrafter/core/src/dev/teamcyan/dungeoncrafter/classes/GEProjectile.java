package dev.teamcyan.dungeoncrafter.classes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.utils.Array;

public class GEProjectile extends GameElement {
    Velocity velocity;
    private Texture texture;
    private double angle;

    public GEProjectile (Pos position, Pos destination)
    {
        this.getype = GEType.DEFAULT;
        this.position = new Pos(position.getX(), position.getY()+30);

        this.velocity = new Velocity(destination.getX() - position.getX(), destination.getY() - position.getY());
        //this.velocity = new Velocity(0, 10);
        double magnitude = Math.sqrt(Math.pow(velocity.getX(),2) + Math.pow(velocity.getY(), 2));
        this.velocity = new Velocity((float)(velocity.getX()/magnitude), (float)(velocity.getY()/magnitude));
        Velocity spriteDirection = new Velocity(-1.0f,0.0f);
        this.angle = Math.atan2(spriteDirection.getX()* velocity.getY()-spriteDirection.getY()* velocity.getX(),spriteDirection.getX()* velocity.getX()+ spriteDirection.getY()* velocity.getY());
        this.velocity = new Velocity(this.velocity.getX()*4, this.velocity.getY()*4);
        this.texture = new Texture("sprites/enemy/arrow.png");

    }

    public boolean setPosition(TiledMapTileLayer layer) {
        // apply gravity, when no floor
        float delta = Gdx.graphics.getDeltaTime();

        double newXPosition = this.position.getX() + this.velocity.getX();
        double newYPosition = this.position.getY() + this.velocity.getY();

        TiledMapTileLayer.Cell tipCell = null;
        tipCell = layer.getCell((int) ((this.position.getX()) / layer.getTileWidth()), (int) ((this.position.getY()) / layer.getTileHeight()));

        if (tipCell == null) {
            this.position.setX((float)newXPosition);
            this.position.setY((float)newYPosition);
            return true;
        } else {
            return false;
        }
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

    public Texture getTexture(){
        return this.texture;
    }

    public double getAngle() {
        return this.angle * 180/3.1415;
    }
}
