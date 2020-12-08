package dev.teamcyan.dungeoncrafter.classes;

/**
 * Class that helps handling tile positions easier
 */
public class TilePos {
    private int x;
    private int y;

    /**
     * Constructor for Tile Pos
     * @param x
     * @param y
     */
    public TilePos (int x, int  y)
    {
        this.x=x;
        this.y=y;
    }

    /**
     * Setter for X
     * @param x
     */
    public void setX(int x)
    {
        this.x=x;
    }

    /**
     * Setter for Y
     * @param y
     */
    public void setY(int  y)
    {
        this.y=y;
    }

    /**
     * Getter for Y
     * @return
     */
    public int  getY()
    {
       return this.y; 
    }

    /**
     * Getter for X
     * @return
     */
    public int getX()
    {
       return this.x; 
    }
}

