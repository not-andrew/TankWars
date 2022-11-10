import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class snipertarget2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class snipertarget2 extends zz
{
    /**
     * Act - do whatever the snipertarget2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int timer=30;
    public snipertarget2()
    {
        GreenfootImage c=new GreenfootImage("powercircle2.png");
        c.scale(50,50);
        setImage(c);
    }
    public void act() 
    {
        if (timer>0) timer--;
        if (timer==0)getWorld().removeObject(this);
        // Add your action code here.
    }    
}
