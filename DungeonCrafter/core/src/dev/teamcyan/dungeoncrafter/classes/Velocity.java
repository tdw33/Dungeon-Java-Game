package dev.teamcyan.dungeoncrafter.classes;

/**
 * A helper class to send and recieve velocities across functions
 */
public class Velocity {
    private float x;
    private float y;

    /**
     * Constructor for Velocity
     * @param x
     * @param y
     */
    public Velocity (float x, float  y)
    {
        this.x=x;
        this.y=y;
    }

    /**
     * Setter for X
     * @param x
     */
    public void setX(float x)
    {
        this.x=x;
    }

    /**
     * Setter for Y
     * @param y
     */
    public void setY(float  y)
    {
        this.y=y;
    }

    /**
     * Getter for Y
     * @return
     */
    public float getY()
    {
        return this.y;
    }

    /**
     * Getter for X
     * @return
     */
    public float getX()
    {
        return this.x;
    }
}
