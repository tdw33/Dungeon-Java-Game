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
        this.enemies.add(new GEEnemy(this));
        this.enemies.add(new GEEnemy(this));
        this.enemies.add(new GEEnemy(this));
        this.enemies.add(new GEEnemy(this));
        this.enemies.add(new GEEnemy(this));
        this.enemies.add(new GEEnemy(this));
        this.enemies.add(new GEEnemy(this));
        this.enemies.add(new GEEnemy(this));
        this.enemies.add(new GEEnemy(this));
        this.enemies.add(new GEEnemy(this));
        this.enemies.add(new GEEnemy(this));
        this.enemies.add(new GEEnemy(this));
        this.enemies.add(new GEEnemy(this));
        this.enemies.add(new GEEnemy(this));
        this.enemies.add(new GEEnemy(this));
        this.enemies.add(new GEEnemy(this));
        this.enemies.add(new GEEnemy(this));
        this.enemies.add(new GEEnemy(this));
        this.enemies.add(new GEEnemy(this));
        this.enemies.add(new GEEnemy(this));
        this.enemies.add(new GEEnemy(this));
        this.enemies.add(new GEEnemy(this));
        this.enemies.add(new GEEnemy(this));
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


        this.enemies.get(0).getPosition().setX(position_x-50);
        this.enemies.get(0).getPosition().setY(position_y-600);
        this.enemies.get(1).getPosition().setX(position_x+500);
        this.enemies.get(1).getPosition().setY(position_y-600);
        this.enemies.get(2).getPosition().setX(position_x+720);
        this.enemies.get(2).getPosition().setY(position_y-1200);
        this.enemies.get(3).getPosition().setX(position_x+2540);
        this.enemies.get(3).getPosition().setY(position_y-500);
        this.enemies.get(4).getPosition().setX(position_x+2640);
        this.enemies.get(4).getPosition().setY(position_y+500);
        this.enemies.get(5).getPosition().setX(position_x+4540);
        this.enemies.get(5).getPosition().setY(position_y+450);
        this.enemies.get(6).getPosition().setX(position_x+5640);
        this.enemies.get(6).getPosition().setY(position_y+400);
        this.enemies.get(7).getPosition().setX(position_x+6540);
        this.enemies.get(7).getPosition().setY(position_y-180);
        this.enemies.get(8).getPosition().setX(position_x+4640);
        this.enemies.get(8).getPosition().setY(position_y-870);
        this.enemies.get(9).getPosition().setX(position_x+9000);
        this.enemies.get(9).getPosition().setY(position_y-2400);
        this.enemies.get(10).getPosition().setX(position_x+11040);
        this.enemies.get(10).getPosition().setY(position_y+50);
        this.enemies.get(11).getPosition().setX(position_x+8140);
        this.enemies.get(11).getPosition().setY(position_y-3700);
        this.enemies.get(12).getPosition().setX(position_x+6600);
        this.enemies.get(12).getPosition().setY(position_y-1300);
        this.enemies.get(13).getPosition().setX(position_x+3440);
        this.enemies.get(13).getPosition().setY(position_y-3600);
        this.enemies.get(14).getPosition().setX(position_x+2840);
        this.enemies.get(14).getPosition().setY(position_y-2500);
        this.enemies.get(15).getPosition().setX(position_x+300);
        this.enemies.get(15).getPosition().setY(position_y-3900);

        this.enemies.get(16).getPosition().setX(position_x+20);
        this.enemies.get(16).getPosition().setY(position_y+20);
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
