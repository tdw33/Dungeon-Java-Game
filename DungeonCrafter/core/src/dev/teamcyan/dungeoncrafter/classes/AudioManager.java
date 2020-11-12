package dev.teamcyan.dungeoncrafter.classes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

import java.util.ArrayList;

public class AudioManager {
    public Music menuSound;
    long menuSoundID;
    ArrayList<Long> activeAudio;
    ArrayList<String> allAudio;

    public AudioManager (){
        this.menuSound = Gdx.audio.newMusic(Gdx.files.internal("sounds/sound1.mp3"));
    }


    public long startAudio(Sound toPlay){
        long soundID = toPlay.play();
        activeAudio.add(soundID);
        return soundID;
    }


    public void startMusic(Music toPlay){
        toPlay.play();
    }

    public void testPrint(){
        System.out.println("Testing function is running");
    }
    public void stopMusic(Music toStop){
        toStop.stop();
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
        //toFade.setVolume((float) 0.1);
        /*
        float newVolume;
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            toFade.setVolume((float)((100-i) / (float)100));
            newVolume = (100-i) / (float)100;
            System.out.println(newVolume);
        }
        */




    }
