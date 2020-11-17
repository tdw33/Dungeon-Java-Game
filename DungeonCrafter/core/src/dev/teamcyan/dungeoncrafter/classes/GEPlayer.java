package dev.teamcyan.dungeoncrafter.classes;

public class GEPlayer extends GameElement 
{
  String playerTextureName;
  Velocity velocity;

  public GEPlayer (String spriteName, Pos position)
  {
    this.getype = GEType.PLAYER;
    this.spriteName = spriteName;
    this.position = position;
    this.velocity = new Velocity(0,0);

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
