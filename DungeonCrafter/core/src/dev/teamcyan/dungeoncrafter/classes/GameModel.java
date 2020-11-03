package dev.teamcyan.dungeoncrafter.classes;

import dev.teamcyan.dungeoncrafter.DungeonCrafter;

public class GameModel {
    private GMap map;
    private Square player;
    private boolean active = false;

    //Start a new game.
    public void startNewGame(DungeonCrafter controller) {
        this.map = new GMap();//GalaxyFactory.get().make();
        this.player = new Square();// new Player(new ObjectIntMap<>(), galaxy.getStations().get("Homeworld"), galaxy.getStations().get("Homeworld"));
        //this.player.getQuests().add(new QuestFactory().make("INTRO_QUEST", controller, this));
        this.active = true;
    }

    public void dispose() { }

    // === Getters / Setters === //
    public Square getPlayer() {
        return player;
    }

    public GMap getMap() {
        return map;
    }

    public boolean isActive() {
        return active;
    }
}
