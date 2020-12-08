package dev.teamcyan.dungeoncrafter.classes;

import com.badlogic.gdx.Input;

import java.util.ArrayList;

/**
 * Handles key inputs.
 */
public class KeyListener {
    public ArrayList<Integer> activeKeys;
    public int mouseX;
    public int mouseY;
    public String mousePrint;

    /**
     * Constructor
     */
    public KeyListener(){
        activeKeys = new ArrayList<Integer>();
        mousePrint = "";
    }

    /**
     * Implement for keyboard inputs. Called immediately on key presses.
     * @param keycode the code of the key that was clicked. One of Input.Keys.
     * @return boolean whether the input was processed
     */
    public boolean keyDownListener(int keycode) {
        if (keycode != Input.Keys.UP) {
            activeKeys.add(keycode);
        }
        return false;
    }

    /**
     * Implement for keyboard inputs. Called immediately on key releases.
     * @param keycode the code of the key that was clicked. One of Input.Keys.
     * @return boolean whether the input was processed
     */
    public boolean keyUpListener(int keycode) {
        if (keycode == Input.Keys.UP) {
            activeKeys.add(keycode);
        } else {
            activeKeys.remove(activeKeys.indexOf(keycode));
        }
        return false;
    }

    /**
     * Called when the mouse was moved without any buttons being pressed. Will not be called on iOS.
     * @param screenX x-coordinate of the event. Origin is in the upper left corner.
     * @param screenY y-coordinate of the event. Origin is in the upper left corner.
     * @return boolean whether the input was processed
     */
    public boolean mouseMoved(int screenX, int screenY) {
        mouseX = screenX;
        mouseY = screenY;
        mousePrint = "X = " + String.valueOf(screenX) + "\nY = " + String.valueOf(screenY);
        return false;
    }

    }
