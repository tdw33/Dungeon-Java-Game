package com.teamcyan.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Input;              //for user input
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Dungeon extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
    ShapeRenderer shapeRenderer;

    float circleX = 200;
	float circleY = 100;

    float xSpeed = 120;
	float ySpeed = 60;
	
	@Override
	public void create () {
        //gets triggered when the application is opened
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
        shapeRenderer = new ShapeRenderer();
	}

	@Override
	public void render () {

        circleX += xSpeed *  Gdx.graphics.getDeltaTime();
        circleY += ySpeed *  Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			xSpeed *= -1;
		}

		if(circleY < 0 || circleY > Gdx.graphics.getHeight()){
			ySpeed *= -1;
		}

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(0, 1, 0, 1);
        shapeRenderer.circle(circleX, circleY, 75);
		shapeRenderer.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
