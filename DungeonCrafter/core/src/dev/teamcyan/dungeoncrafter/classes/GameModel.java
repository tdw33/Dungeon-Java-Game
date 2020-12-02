package dev.teamcyan.dungeoncrafter.classes;

import dev.teamcyan.dungeoncrafter.DungeonCrafter;
import com.badlogic.gdx.graphics.OrthographicCamera;

import java.util.ArrayList;
import java.util.List;

public class GameModel {
    private GMap map;
    private boolean active = false;
    private GEPlayer player;
    private GEPebble pebble;
    private List<GEEnemy> enemies = new ArrayList<GEEnemy>();
    private GESpeech speech;

    private final String MAPNAME = "tile/GameMap.tmx";
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
        this.player = new GEPlayer(this, controller);
        this.pebble = new GEPebble(this);
        this.enemies.add(new GEEnemy(this));
        this.enemies.add(new GEBoss(this));
        this.speech = new GESpeech(this);
        this.active = true;
        camera = new OrthographicCamera();
        camera.zoom = 0.5f;

        int position_x = 5*32;
        int position_y = 280*32;

        this.player.getPosition().setX(position_x);
        this.player.getPosition().setY(position_y);

        this.pebble.getPosition().setX(position_x+50);
        this.pebble.getPosition().setY(position_y+50);

        this.enemies.get(0).getPosition().setX(position_x+20);
        this.enemies.get(0).getPosition().setY(position_y+20);
        this.enemies.get(1).getPosition().setX(position_x+1750);
        this.enemies.get(1).getPosition().setY(position_y+30);

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

    public List<GEEnemy> getEnemies() {
        return this.enemies;
    }
    public GESpeech getSpeech(){ return speech; }


    public boolean isActive()
    {
        return this.active;
    }
    public void deactivate()
    {
         this.active = false;
    }
}
