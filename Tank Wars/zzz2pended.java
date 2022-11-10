import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class zzz2pended here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class zzz2pended extends Actor
{
    /**
     * Act - do whatever the zzz2pended wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        GreenfootImage c=new GreenfootImage("ui/ReturnTomenu.png");
        c.scale(330,98);
        
        setImage (c);
        if (Greenfoot.mouseClicked(this)){Greenfoot.setWorld(new menuworld());}
        // Add your action code here.
    }    
}
