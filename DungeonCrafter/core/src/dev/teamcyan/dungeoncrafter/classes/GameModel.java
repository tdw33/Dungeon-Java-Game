package dev.teamcyan.dungeoncrafter.classes;

import dev.teamcyan.dungeoncrafter.DungeonCrafter;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameModel {
    private GMap map;
    private boolean active = false;
    private GEPlayer player;
    private GEPebble pebble;
    private GEEnemy enemy;
    private GESpeech speech;

    private final String MAPNAME = "tile/TestingMap.tmx";
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
        this.map = new GMap(controller.getModel(), MAPNAME);
        this.player = new GEPlayer(this);
        this.pebble = new GEPebble(this);
        this.enemy = new GEEnemy(this);
        this.speech = new GESpeech(this);
        this.active = true;
        camera = new OrthographicCamera();
        camera.zoom = 0.5f;

        int position_x = 150;
        int position_y = 1400;

        this.player.getPosition().setX(position_x);
        this.player.getPosition().setY(position_y);

        this.pebble.getPosition().setX(position_x+50);
        this.pebble.getPosition().setY(position_y+50);

        this.enemy.getPosition().setX(position_x+20);
        this.enemy.getPosition().setY(position_x+20);
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

    public GMap getMap() {
        return this.map;
    }
    public GEPebble getPebble() {
        return pebble;
    }

    public GEEnemy getEnemy() {
        return enemy;
    }
    public GESpeech getSpeech(){ return speech; }



    public boolean isActive() 
    {
        return this.active;
    }
}
