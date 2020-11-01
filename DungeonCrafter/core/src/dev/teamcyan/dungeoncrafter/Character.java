package dev.teamcyan.dungeoncrafter;

public abstract class Character{
    private String name = "Character Name";
    private int health = 100;
    private Pos position = new Pos(0,0);

    public abstract void create();
    //instantiate a new Character
    
    public abstract void render();
    //renders the Character

    public abstract void destroy();
    //destroys the character

    public int getHealth()
    {
    // returns the health of the character
        return this.health;
    }

    public void setHealth(int healthIn)
    {
    // sets the health of the character
        this.health=healthIn;
    }

    public void setPosition(Pos position)
    {
        this.position=position;
    }

    public Pos getPosition()
    {
        return position;
    }

    public void setX(float x)
    {
        this.position.setX(x);
    }

    public void setY(float y)
    {
        this.position.setY(y);
    }

}
