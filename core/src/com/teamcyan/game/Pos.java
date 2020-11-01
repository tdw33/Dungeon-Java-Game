package com.teamcyan.game;

public class Pos {
    private float x;
    private float y;

    public Pos (float x, float y)
    {
        this.x=x;
        this.y=y;
    }

    public void setX(float x)
    {
        this.x=x;
    }

    public void setY(float y)
    {
        this.y=y;
    }

    public float getY()
    {
       return this.y; 
    }

    public float getX()
    {
       return this.x; 
    }
}

