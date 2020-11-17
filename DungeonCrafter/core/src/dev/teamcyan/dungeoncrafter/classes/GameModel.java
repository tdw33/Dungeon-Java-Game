package dev.teamcyan.dungeoncrafter.classes;

import dev.teamcyan.dungeoncrafter.DungeonCrafter;

public class GameModel {
    private GMap map;
    private boolean active = false;
    private GEPlayer player;
    private GEPlayer pebble;

    //Start a new game.
    public void startNewGame(DungeonCrafter controller) {
        this.map = new GMap();//GalaxyFactory.get().make();
        this.player = new GEPlayer("tile/wall", new Pos(0, 0));// new Player(new ObjectIntMap<>(), galaxy.getStations().get("Homeworld"), galaxy.getStations().get("Homeworld"));
        this.pebble = new GEPlayer("player/standing", new Pos(0, 0));
        //this.player.getQuests().add(new QuestFactory().make("INTRO_QUEST", controller, this));
        this.active = true;
    }

    public void dispose() { }

    // === Getters / Setters === //
    public GEPlayer getPlayer() {
        return player;
    }

    public GEPlayer getPebble() {
        return pebble;
    }

    public GMap getMap() {
        return map;
    }

    public boolean isActive() {
        return active;
    }
}
