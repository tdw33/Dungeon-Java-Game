package dev.teamcyan.dungeoncrafter.classes;

public class Velocity {
    private int x;
    private int y;

    public Velocity (int x, int  y)
    {
        this.x = x;
        this.y = y;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int  y)
    {
        this.y = y;
    }

    public int  getY()
    {
        return this.y;
    }

    public int getX()
    {
        return this.x;
    }
}
