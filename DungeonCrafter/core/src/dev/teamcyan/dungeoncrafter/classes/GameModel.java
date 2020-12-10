package dev.teamcyan.dungeoncrafter.classes;

import dev.teamcyan.dungeoncrafter.DungeonCrafter;
import com.badlogic.gdx.graphics.OrthographicCamera;

import java.util.ArrayList;
import java.util.List;

/**
 * Model of the MVC-pattern. Holds all stateful information of the game.
 */
public class GameModel {
    private GMap map;
    private boolean active = false;
    private GEPlayer player;
    private GEPebble pebble;
    private List<GEEnemy> enemies;
    private GESpeech speech;
    private final String MAPNAME = "tile/GameMap.tmx";
    private OrthographicCamera camera;

    /**
     * Starts a new games and initialises all the needed classes
     * @param controller
     */
    public void startNewGame(DungeonCrafter controller) 
    {
        this.map = new GMap(controller.getModel(), MAPNAME);
        this.player = new GEPlayer(this, controller);
        this.pebble = new GEPebble(this);

        enemies = new ArrayList<GEEnemy>();
        this.enemies.add(new GEEnemy(this, new Pos(1600, 300*32-650)));
        this.enemies.add(new GEEnemy(this, new Pos(5*32+1200, 280*32-600)));
        this.enemies.add(new GEEnemy(this, new Pos(5*32+720, 280*32-1200)));
        this.enemies.add(new GEEnemy(this, new Pos(5*32+2540, 280*32-500)));
        this.enemies.add(new GEEnemy(this, new Pos(2700, 280*32+530)));
        this.enemies.add(new GEEnemy(this, new Pos(5*32+4540, 280*32+350)));
        this.enemies.add(new GEEnemy(this, new Pos(5*32+5640, 280*32+400)));
        this.enemies.add(new GEEnemy(this, new Pos(5*32+6540, 280*32-180)));
        this.enemies.add(new GEEnemy(this, new Pos(5*32+4640, 280*32-870)));
        this.enemies.add(new GEEnemy(this, new Pos(5*32+900, 280*32-2400)));
        this.enemies.add(new GEEnemy(this, new Pos(5*32+11040, 280*32+50)));
        this.enemies.add(new GEEnemy(this, new Pos(8140, 300*32-3800)));
        this.enemies.add(new GEEnemy(this, new Pos(5*32+6600, 280*32-1300)));
        this.enemies.add(new GEEnemy(this, new Pos(5*32+3440, 280*32-3600)));
        this.enemies.add(new GEEnemy(this, new Pos(5*32+2840, 280*32-2500)));
        this.enemies.add(new GEEnemy(this, new Pos(5*32+300, 280*32-3900)));
        this.enemies.add(new GEEnemy(this, new Pos(5*32-30, 280*32-4900)));
        this.enemies.add(new GEEnemy(this, new Pos(5*32+1700, 280*32-5200)));
        this.enemies.add(new GEEnemy(this, new Pos(5*32+2650, 280*32-6700)));
        this.enemies.add(new GEEnemy(this, new Pos(5*32+5800, 280*32-4950)));
        this.enemies.add(new GEEnemy(this, new Pos(8000, 280*32-6820)));
        this.enemies.add(new GEEnemy(this, new Pos(5*32+10340, 280*32-4700)));
        this.enemies.add(new GEEnemy(this, new Pos(11800, 280*32-5400)));
        this.enemies.add(new GEEnemy(this, new Pos(11000, 300*32-8700)));
        this.enemies.add(new GEEnemy(this, new Pos(5*32+12940, 280*32-8300)));

        this.enemies.add(new GEBoss(this, controller, new Pos(14500, 300*32-8800)));
        this.speech = new GESpeech(this);
        this.active = true;
        camera = new OrthographicCamera();
        camera.zoom = 0.5f;

        //Defines the position of player and pebble
        int position_x = 200;
        int position_y = 300*32-670;

        this.player.getPosition().setX(position_x);
        this.player.getPosition().setY(position_y);

        this.pebble.getPosition().setX(position_x-50);
        this.pebble.getPosition().setY(position_y+20);

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

    /**
     * TODO
     */
    public void dispose() 
    { 
      /*
        this.map.dispose();
        this.player.dispose();
        */
    }

    /**
     * Getter for Player character 
     * @return
     */
    public GEPlayer getPlayer() 
    {
        return this.player;
    }

    /**
     * Getter for map
     * @return
     */
    public GMap getMap() {
        return this.map;
    }

    /**
     * Getter for Pebble character
     * @return
     */
    public GEPebble getPebble() {
        return pebble;
    }

    /**
     * Getter for Enemeies
     * @return
     */
    public List<GEEnemy> getEnemies() {
        return this.enemies;
    }

    /**
     * Getter for speach
     * @return
     */
    public GESpeech getSpeech(){ return speech; }

    /**
     * Getter for active flag
     * @return
     */
    public boolean isActive(){
        return this.active;
    }

    /**
     * Setter for active flag
     */
    public void deactivate(){
         this.active = false;
    }

     /**
     * Getter for Camera
     * @return
     */
    public OrthographicCamera getCamera() {
        return this.camera;
      }
  
      /**
       * Setter for Camera Zoom
       * @param factor
       */
      public void setCameraZoom(float factor) {
        this.camera.zoom = factor;
      }
}
