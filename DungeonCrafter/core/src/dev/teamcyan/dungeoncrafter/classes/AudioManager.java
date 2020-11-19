package dev.teamcyan.dungeoncrafter.classes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

import java.util.ArrayList;

public class AudioManager {
    public Music menuSound;
    public Music breakStone;
    public Music tick;
    long menuSoundID;
    ArrayList<Long> activeAudio = new ArrayList<>();
    ArrayList<String> playingAudio = new ArrayList<>();

    public AudioManager (){
        this.menuSound = Gdx.audio.newMusic(Gdx.files.internal("sounds/sound1.mp3"));
        this.breakStone = Gdx.audio.newMusic(Gdx.files.internal("sounds/harddig.ogg"));
        this.tick = Gdx.audio.newMusic(Gdx.files.internal("sounds/tick.wav"));
    }


    public long startAudio(Sound toPlay){
        if(playingAudio.contains(toPlay.toString())){
            return 0;
        }
        long soundID = toPlay.play();
        activeAudio.add(soundID);
        playingAudio.add(toPlay.toString());
        return soundID;
    }

    public void startMusicStr(String toPlay){
        if(toPlay == "tick")
            tick.play();
    }

    public void startMusic(Music toPlay){
        if(!toPlay.isPlaying())
            toPlay.play();
    }

    public void stopMusic(Music toStop){
        toStop.stop();
    }

    public void testPrint(){
        System.out.println("Testing function is running");
    }


    public void stopAudio(Sound toStop, long audioID){
        toStop.stop(audioID);
        activeAudio.remove(activeAudio.indexOf(audioID));
    }

    // Fade Music
    public void fadeMusic(final Music toFade) {
        Timer timer=new Timer();
        timer.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                float curVolume = toFade.getVolume();
                toFade.setVolume(curVolume - (float)0.01);
            }
        }, 0, (float)0.01, 100);
    }
    }
