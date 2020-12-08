package dev.teamcyan.dungeoncrafter.classes;

/**
 * A helper class to send and receive positions across functions
 */
public class Pos {
    private float x;
    private float y;

    /**
     * Constructor receives x and y
     * @param x
     * @param y
     */
    public Pos (float x, float  y)
    {
        this.x=x;
        this.y=y;
    }
    /**
     * Setter for  X
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
     * getter for Y
     * @return float 
     */
    public float  getY()
    {
       return this.y; 
    }

    /**
     * Getter for X
     * @return x float 
     */
    public float getX()
    {
       return this.x; 
    }
}

