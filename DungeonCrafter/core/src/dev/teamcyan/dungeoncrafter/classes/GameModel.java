package dev.teamcyan.dungeoncrafter.classes;

import dev.teamcyan.dungeoncrafter.DungeonCrafter;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameModel {
    private GMap map;
    private boolean active = false;
    private GEPlayer player;
    private final String MAPNAME = "tile/TileMap.tmx";
    private OrthographicCamera camera;

    public OrthographicCamera getCamera() {
      return this.camera;
    }

    public void setCameraZoom(float factor) {
      this.camera.zoom = factor;
    }

    //Start a new game.
    public void startNewGame(DungeonCrafter controller) 
    {
        this.map = new GMap(MAPNAME);
        this.player = new GEPlayer(controller.getAtlasRegion("tile/wall"));
        this.active = true;
        camera = new OrthographicCamera();
    }

    public void dispose() 
    { 
      /*
        this.map.dispose();
        this.player.dispose();
        */
    }

    public GEPlayer getPlayer() 
    {
        return this.player;
    }

    public GMap getMap() 
    {
        return this.map;
    }

    public boolean isActive() 
    {
        return this.active;
    }
}
