package dev.teamcyan.dungeoncrafter.classes;

public class Pos {
    private int x;
    private int y;

    public Pos (int x, int  y)
    {
        this.x=x;
        this.y=y;
    }

    public void setX(int x)
    {
        this.x=x;
    }

    public void setY(int  y)
    {
        this.y=y;
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

