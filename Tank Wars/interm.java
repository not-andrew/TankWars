import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class interm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class interm extends World
{

    /**
     * Constructor for objects of class interm.
     * 
     */
    public interm()
    {    
         
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
    public void act()
    {Greenfoot.setWorld(new ImageScrollWorld());
    }
}
