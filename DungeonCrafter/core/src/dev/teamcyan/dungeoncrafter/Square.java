package dev.teamcyan.dungeoncrafter;

import java.util.Random;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Input;              //for user input
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Square extends Character{
    ShapeRenderer square;

    public void create()
    {
        square = new ShapeRenderer();
    }

    public void render()
    {
        this.move();
        square.begin(ShapeRenderer.ShapeType.Filled);
        square.setColor(1,0,0,1);
        square.circle(this.getPosition().getX(),this.getPosition().getY(),75);
        square.end();
    }

    private void move()
    {

    }

    public void destroy()
    {
        this.square.dispose();
    }
}
