package dev.dungeon;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class MainGame extends ApplicationAdapter implements InputProcessor{ //implement gives the movement objects
	SpriteBatch batch;
	TextureAtlas atlas;
	Sprite sprite; // this can be the player etc
	boolean movingRight = false;
	boolean movingLeft = false;
	boolean movingUp = false;
	boolean movingDown = false;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		atlas = new TextureAtlas("textures.atlas");
		sprite = new Sprite(atlas.findRegion("Player/red_square1"));
		sprite.setPosition(Gdx.graphics.getWidth()/2 - sprite.getWidth()/2,
		          Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);
		
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render () {
		if(movingRight) {
			sprite.translateX(3f);
		}
		
		if(movingLeft) {
			sprite.translateX(-3f);
		}
		if(movingUp) {
			sprite.translateY(3f);
		}
		if(movingDown) {
			sprite.translateY(-3f);
		}
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.draw(sprite, sprite.getX(), sprite.getY()); // this will be diffrent when you have nummbers at end eg player_1, player_2
		batch.end();
	}
	

	
	@Override
	public void dispose () {
		batch.dispose();
		atlas.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Input.Keys.LEFT) {
		movingLeft = true;
		}
		if(keycode == Input.Keys.RIGHT) {
		movingRight = true; 
		}
		if(keycode == Input.Keys.UP) {
			movingUp = true; 
		}
		if(keycode == Input.Keys.DOWN) {
			movingDown = true; 
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if(keycode == Input.Keys.RIGHT)
			movingRight = false;
		
		if(keycode == Input.Keys.LEFT)
			movingLeft = false;
		
		if(keycode == Input.Keys.UP)
			movingUp = false;
		
		if(keycode == Input.Keys.DOWN)
			movingDown = false;
		
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
	
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
