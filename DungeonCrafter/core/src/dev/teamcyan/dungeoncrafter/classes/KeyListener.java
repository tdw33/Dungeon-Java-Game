package dev.teamcyan.dungeoncrafter.classes;

import java.util.ArrayList;

public class KeyListener {
    public ArrayList<String> activeKeys;
    public int mouseX;
    public int mouseY;
    public String mousePrint;

    public KeyListener(){
        activeKeys = new ArrayList<String>();
        mousePrint = "";
    }

    public boolean keyDownListener(int keycode) {
        activeKeys.add(String.valueOf((char) (keycode + 68)));
        return false;
    }

    public boolean keyUpListener(int keycode) {
        activeKeys.remove((activeKeys.indexOf(String.valueOf((char) (keycode + 68)))));
        return false;
    }

    public boolean mouseMoved(int screenX, int screenY) {
        mouseX = screenX;
        mouseY = screenY;
        mousePrint = "X = " + String.valueOf(screenX) + "\nY = " + String.valueOf(screenY);
        return false;
    }

    }
