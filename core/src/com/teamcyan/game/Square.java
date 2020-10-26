package com.teamcyan.game;

import java.util.Random;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Input;              //for user input
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Square {
    ShapeRenderer square;

    Random rand = new Random(2);
    float xPos = 200;
	float yPos = 100;

    float xSpeed = rand.nextInt() % 120;
	float ySpeed = 60;

    public void create(){
        square = new ShapeRenderer();
    }

    public void render(){
        square.begin(ShapeRenderer.ShapeType.Filled);
        square.setColor(1,0,0,1);
        this.move();
        square.circle(xPos,yPos,75);
        square.end();
    }

    private void move(){
        xPos += xSpeed *  Gdx.graphics.getDeltaTime();
        yPos += ySpeed *  Gdx.graphics.getDeltaTime();

		if(yPos < 0 || yPos > Gdx.graphics.getHeight()){
			ySpeed *= -1;
        }

		if(xPos < 0 || xPos > Gdx.graphics.getWidth()){
			xSpeed *= -1;
        }
    }
}
