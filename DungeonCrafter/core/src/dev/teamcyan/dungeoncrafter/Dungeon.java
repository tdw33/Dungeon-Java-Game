package dev.teamcyan.dungeoncrafter;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Input;              //for user input
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Vector;

public class Dungeon extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
    ShapeRenderer shapeRenderer;
    Square me;
    Vector <Square> list = new Vector <Square>();

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
        for (int i = 0; i<10;i++)
        {
            me = new Square();
            me.create();
            list.add(me);
        }
	}

	@Override
	public void render () {

        circleX += xSpeed *  Gdx.graphics.getDeltaTime();
        circleY += ySpeed *  Gdx.graphics.getDeltaTime();

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        for (int i = 0; i<10;i++) {
            list.get(i).render();
        }

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
