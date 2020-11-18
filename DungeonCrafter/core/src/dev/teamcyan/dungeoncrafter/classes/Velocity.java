package dev.teamcyan.dungeoncrafter.classes;

public class Velocity {
    private float x;
    private float y;

    public Velocity (float x, float  y)
    {
        this.x=x;
        this.y=y;
    }

    public void setX(float x)
    {
        this.x=x;
    }

    public void setY(float  y)
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
