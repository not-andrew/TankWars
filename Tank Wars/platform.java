import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class platform extends yzobstacles
{
    /**
     * Act - do whatever the platform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int w,h;
    public  platform()
    {
        this(100,25);
    }
    
    
    public   platform( int width, int height)
    {
        GreenfootImage image=getImage();
        image.scale(width,height);
        setImage(image);
        w=width;
        h=height;
        
    }
    
    public void act() 
    {
        //collision();
        // Add your action code here.
    }   
    public void collision()
    {player pl = (player) getWorld().getObjects(player.class).get(0);
    int px=pl.getX(), py=pl.getY(), x=getX(), y=getY();
        if (isTouching(mouse.class))
    {// pl.setLocation(pl.ax,pl.ay);
        //if (px<()
        
        
    }
    
    
    }
    
    
    
}
