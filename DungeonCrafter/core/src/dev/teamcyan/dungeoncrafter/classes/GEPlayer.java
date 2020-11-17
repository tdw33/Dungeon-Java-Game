package dev.teamcyan.dungeoncrafter.classes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import dev.teamcyan.dungeoncrafter.screens.MainGameScreen;



public class GEPlayer extends GameElement
{

  int num = 0;
  String playerTextureName;
  Velocity velocity;

  public GEPlayer ()
  {
    this.getype = GEType.PLAYER;
    this.position = new Pos(0,0);
    this.velocity = new Velocity(0,0);
    this.spriteName = "animationFrames/tile003";
    }




  public void setName(String spriteName){
    this.spriteName = spriteName;
  }

  public void setX(int x)
  {
      this.position.setX(x);
  }

  public void setY(int y) 
  {
    this.position.setY(y);
  }

  public Velocity getVelocity() {
    return this.velocity;
  }


}
