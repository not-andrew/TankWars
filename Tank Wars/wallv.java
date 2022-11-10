import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class wallv here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class wallv extends yzobstacles
{
    /**
     * Act - do whatever the wallv wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public wallv()
    {
        GreenfootImage img=new GreenfootImage("obstacles/vertwall.png");
        img.scale(16,160);
        setImage(img);
    }
    public void act() 
    {
        
        
         //getrealcoords();
        // Add your action code here.
    }    
}
