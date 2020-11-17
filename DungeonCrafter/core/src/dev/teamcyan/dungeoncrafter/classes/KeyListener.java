package dev.teamcyan.dungeoncrafter.classes;

import java.util.ArrayList;

public class KeyListener {
    public ArrayList<Integer> activeKeys;
    public int mouseX;
    public int mouseY;
    public String mousePrint;

    public KeyListener(){
        activeKeys = new ArrayList<Integer>();
        mousePrint = "";
    }

    public boolean keyDownListener(int keycode) {
        activeKeys.add(keycode);
        return false;
    }

    public boolean keyUpListener(int keycode) {
        activeKeys.remove(activeKeys.indexOf(keycode));
        return false;
    }

    public boolean mouseMoved(int screenX, int screenY) {
        mouseX = screenX;
        mouseY = screenY;
        mousePrint = "X = " + String.valueOf(screenX) + "\nY = " + String.valueOf(screenY);
        return false;
    }

    }
