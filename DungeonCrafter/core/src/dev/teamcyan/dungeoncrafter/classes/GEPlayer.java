package dev.teamcyan.dungeoncrafter.classes;

public class GEPlayer extends GameElement {

  String playerTextureName;

  public GEPlayer (){

    this.getype = GEType.PLAYER;
    this.spriteName = "tile/wall";
    this.position = new Pos(0,0);
  }

  public void setX(int x){
      this.position.setX(x);
  }

  public void setY(int y) {
    this.position.setY(y);
  }
}
