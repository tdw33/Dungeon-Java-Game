package dev.teamcyan.dungeoncrafter.classes;

public class GEPlayer extends GameElement 
{
  String playerTextureName;
  double fallVelocity;

  public GEPlayer ()
  {
    this.getype = GEType.PLAYER;
    this.spriteName = "tile/wall";
    this.position = new Pos(0,0);
    this.fallVelocity = 0.0;

  }

  public void setX(int x)
  {
      this.position.setX(x);
  }

  public void setY(int y) 
  {
    this.position.setY(y);
  }

  public double getFallVelocity() {
    return this.fallVelocity;
  }

  public void setFallVelocity(double y) {
    this.fallVelocity = y;
  }
}
