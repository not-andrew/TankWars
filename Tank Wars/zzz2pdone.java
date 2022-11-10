import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class zzz2pdone here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class zzz2pdone extends Actor
{
    /**
     * Act - do whatever the zzz2pdone wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int red;
    public int blue;
    public zzz2pdone()
    {
    }
    public void act() 
    {
        if (red!=0&&blue!=0) Greenfoot.setWorld(new beforestart2(red,blue));
        // Add your action code here.
    }    
}
