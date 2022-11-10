import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class yzobstacles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class yzobstacles extends Actor
{
    /**
     * Act - do whatever the yzobstacles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        // Add your action code here.
    }    
    public void getrealcoords()
    {
     Scroller s = ((spworld2) getWorld()).scroller;
        GreenfootImage main = getWorld().getBackground();
       int x=getX()+s.getScrolledX();
       int y=getY()+s.getScrolledY();
     GreenfootImage img = new GreenfootImage(" "+x+","+y+" ", 44, Color.BLACK,Color.WHITE);
        
     main.drawImage(img, getX(), getY());
        
        
        
    }
}
