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
    private List<GEEnemy> enemies;
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

        int position_x = 5*32;
        int position_y = 280*32;

        enemies = new ArrayList<GEEnemy>();
        this.enemies.add(new GEEnemy(this, new Pos(position_x-50, position_y-600)));
        this.enemies.add(new GEEnemy(this, new Pos(position_x+500, position_y-600)));
        this.enemies.add(new GEEnemy(this, new Pos(position_x+720, position_y-1200)));
        this.enemies.add(new GEEnemy(this, new Pos(position_x+2540, position_y-500)));
        this.enemies.add(new GEEnemy(this, new Pos(position_x+2640, position_y+500)));
        this.enemies.add(new GEEnemy(this, new Pos(position_x+4540, position_y+450)));
        this.enemies.add(new GEEnemy(this, new Pos(position_x+5640, position_y+400)));
        this.enemies.add(new GEEnemy(this, new Pos(position_x+6540, position_y-180)));
        this.enemies.add(new GEEnemy(this, new Pos(position_x+4640, position_y-870)));
        this.enemies.add(new GEEnemy(this, new Pos(position_x+900, position_y-2400)));
        this.enemies.add(new GEEnemy(this, new Pos(position_x+11040, position_y+50)));
        this.enemies.add(new GEEnemy(this, new Pos(position_x+8140, position_y-3700)));
        this.enemies.add(new GEEnemy(this, new Pos(position_x+6600, position_y-1300)));
        this.enemies.add(new GEEnemy(this, new Pos(position_x+3440, position_y-3600)));
        this.enemies.add(new GEEnemy(this, new Pos(position_x+2840, position_y-2500)));
        this.enemies.add(new GEEnemy(this, new Pos(position_x+300, position_y-3900)));
        this.enemies.add(new GEEnemy(this, new Pos(position_x+20, position_y+20)));


        this.enemies.add(new GEBoss(this, new Pos(13000, 2000)));
        this.speech = new GESpeech(this);
        this.active = true;
        camera = new OrthographicCamera();
        camera.zoom = 0.5f;

        this.player.getPosition().setX(position_x);
        this.player.getPosition().setY(position_y);

        this.pebble.getPosition().setX(position_x+50);
        this.pebble.getPosition().setY(position_y+50);



        /*this.enemies.get(17).getPosition().setX(position_x+20);
        this.enemies.get(17).getPosition().setY(position_y+20);
        this.enemies.get(18).getPosition().setX(position_x-50);
        this.enemies.get(18).getPosition().setY(position_y-600);
        this.enemies.get(19).getPosition().setX(position_x+20);
        this.enemies.get(19).getPosition().setY(position_y+20);
        this.enemies.get(20).getPosition().setX(position_x-50);
        this.enemies.get(20).getPosition().setY(position_y-600);
        this.enemies.get(21).getPosition().setX(position_x+20);
        this.enemies.get(21).getPosition().setY(position_y+20);
        this.enemies.get(22).getPosition().setX(position_x-50);
        this.enemies.get(22).getPosition().setY(position_y-600);
        this.enemies.get(23).getPosition().setX(position_x+20);
        this.enemies.get(23).getPosition().setY(position_y+20);
        this.enemies.get(24).getPosition().setX(position_x-50);
        this.enemies.get(24).getPosition().setY(position_y-600);
        this.enemies.get(25).getPosition().setX(position_x+20);
        this.enemies.get(25).getPosition().setY(position_y+20);*/


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
