import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class wallhor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class wallhor extends yzobstacles
{
    /**
     * Act - do whatever the wallhor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public wallhor()
    {
        GreenfootImage img=new GreenfootImage("obstacles/horizontalwall.png");
        img.scale(160,32);
        setImage(img);
    }
    public void act() 
    {
        
        //getrealcoords();
        // Add your action code here.
    }    
}
