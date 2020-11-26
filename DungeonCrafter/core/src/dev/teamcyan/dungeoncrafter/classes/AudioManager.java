package dev.teamcyan.dungeoncrafter.classes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

import java.util.ArrayList;

public class AudioManager {
    public Music menuSound;


    public Sound breakStone;
    public Music tick;
    public ArrayList<Music> ambientMusic = new ArrayList<>();

    long menuSoundID;
    public int curSong;

    ArrayList<Long> activeAudio = new ArrayList<>();
    ArrayList<String> playingAudio = new ArrayList<>();

    public AudioManager (){
        this.menuSound = Gdx.audio.newMusic(Gdx.files.internal("sounds/sound1.mp3"));
        this.breakStone = Gdx.audio.newSound(Gdx.files.internal("sounds/harddig.ogg"));
        this.tick = Gdx.audio.newMusic(Gdx.files.internal("sounds/tick.wav"));
        ambientMusic.add(Gdx.audio.newMusic(Gdx.files.internal("sounds/tick.wav")));
        ambientMusic.add(Gdx.audio.newMusic(Gdx.files.internal("sounds/ambient2.ogg")));
        ambientMusic.add(Gdx.audio.newMusic(Gdx.files.internal("sounds/ambient3.ogg")));

        curSong = 0;

        // Fix volume levels
        this.menuSound.setVolume((float)0.6);
        ambientMusic.get(0).setVolume((float)0.6);
        ambientMusic.get(1).setVolume((float)0.4);
        ambientMusic.get(2).setVolume((float)0.4);
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

    public void startMusic(Music toPlay, int maxVol){
        if(!toPlay.isPlaying()) {
            toPlay.setVolume(0);
            fadeMusicIn(toPlay, maxVol);
        }
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

    // Fade out music
    public void fadeMusicOut(final Music toFade) {
        Timer timer=new Timer();
        timer.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                float curVolume = toFade.getVolume();
                toFade.setVolume(curVolume - (float)0.01);
            }
        }, 0, (float)0.01, 100);
    }

    // Fade in music
    public void fadeMusicIn(final Music toFade, int maxVol) {
        Timer timer=new Timer();
        timer.scheduleTask(new Timer.Task() {
            public void run() {
                float curVolume = toFade.getVolume();
                toFade.setVolume(curVolume + (float)0.01);
            }
        }, 0, (float)0.01, maxVol);
    }


    public void breakBlock(String blockString){
        this.breakStone.stop();

        if(blockString.contains("brick")) {
            //this.breakStone.play();
            System.out.println("brick broken");
        }
        if(blockString.contains("clay")){
            //this.breakStone.play();
            System.out.println("clay broken");
        }

        if(blockString.contains("dirt")){
            breakStone.play();
            System.out.println("dirt broken");

        }
        if(blockString.contains("gravel")) {
            this.breakStone.play();
            System.out.println("gravel broken");
        }

        if(blockString.contains("stone")) {
            //this.breakStone.play();
            System.out.println("stone broken");
        }
    }


    }
