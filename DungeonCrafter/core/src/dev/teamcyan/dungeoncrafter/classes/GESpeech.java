package dev.teamcyan.dungeoncrafter.classes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import dev.teamcyan.dungeoncrafter.DungeonCrafter;
import javax.swing.plaf.TextUI;

/**
 * Speech handler class
 */
public class GESpeech extends GameElement {
    // TODO
    private float pebbleX;
    private float pebbleY;
    private Texture pebbleIntro;
    private Texture pebbleMove;
    private Texture pebbleDestroy;
    private Texture pebbleIntro2;
    private Texture pebblePlace;
    private Texture pebbleAttack;
    private Texture pebbleGather;
    private Texture speech;
    private float X;
    private float Y;
    private float width;
    private float height;
    private boolean speaking;
    private GameModel model;
    private DungeonCrafter game;
    public float stateTimer = 0;

    /**
     * Constructor 
     * @param model
     */
    public GESpeech(GameModel model){
        this.model = model;
        this.game = game;
        this.pebbleIntro = new Texture("speech/pebble_intro.png");
        this.pebbleMove = new Texture("speech/movement_speech.png");
        this.pebbleIntro2 = new Texture("speech/pebble_notime.png");
        this.pebbleDestroy = new Texture("speech/pebble_destroy.png");
        this.pebblePlace = new Texture("speech/pebble_place.png");
        this.pebbleGather = new Texture("speech/pebble_gather.png");
        this.speech = pebbleIntro;
        this.X = 40;
        this.Y = 40;
        this.width = 40;
        this.height = 30;
        this.speaking = true;
    }

    /**
     * Setter for Position
     */
    public void setPosition(){
        if(this.speech == pebbleIntro || this.speech == pebbleMove || this.speech == pebbleIntro2){
            this.X = -70;
            this.Y = 30;
            this.width = 340;
            this.height = 70;
        } else if(this.speech == pebbleDestroy || this.speech == pebblePlace ){
            this.X = -70;
            this.Y = 30;
            this.width = 340;
            this.height = 70;
        } else if(this.speech == pebbleGather){
            this.X = -90;
            this.Y = 30;
            this.width = 400;
            this.height = 100;
        }else {
            this.X = -70;
            this.Y = 30;
            this.width = 80;
            this.height = 60;
        }
    }

    /**
     * Setter for Speech
     */
    public void setSpeech() {
        stateTimer += Gdx.graphics.getDeltaTime();
        if(stateTimer > 4 &&  stateTimer < 12 ){
            this.speaking = true;
            this.speech = pebbleIntro;
        } else if(stateTimer > 12 && stateTimer < 17){
            this.speaking = true;
            this.speech = pebbleIntro2;
        } else if( stateTimer > 17 && stateTimer < 23){
            this.speaking = true;
            this.speech = pebbleMove;
        } else if(stateTimer > 23 && stateTimer < 28){
            this.speaking = true;
            this.speech = pebbleDestroy;
        } else if(stateTimer > 28 && stateTimer < 34){
            this.speaking = true;
            this.speech = pebblePlace;
        }else if(stateTimer > 34 && stateTimer < 43){
            this.speaking = true;
            this.speech = pebbleGather;
        }else{this.speaking = false;}
    }

    /**
     * Getter for speech
     * @return
     */
    public Texture getSpeech(){
        return this.speech;
    }

    /**
     * Getter for speech X
     * @return
     */
    public float getSpeechX(){
        return this.X;
    }

    /**
     * Getter for speech Y
     * @return
     */
    public float getSpeechY(){
        return this.Y;
    }

    /**
     * Getter for speech widht
     * @return
     */
    public float getSpeechWidth(){
        return this.width;
    }

    /**
     * Getter for speech Height
     * @return
     */
    public float getSpeechHeight(){
        return this.height;
    }

    /**
     * Flag Checker for speaking flag
     * @return
     */
    public boolean isSpeaking(){
        return this.speaking;
    }
    
}
