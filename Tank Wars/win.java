import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class menuworld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class win extends World
{

    /**
     * Constructor for objects of class menuworld.
     * 
     */
    GreenfootSound v=new GreenfootSound("sounds/menumusic.mp3"); 
    int delay=120;
    public win( )
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100, 750, 1); 
       //GreenfootImage bg =new GreenfootImage("win.png");
        //bg.scale(1100,750);
        //setBackground(bg);
        
         //addObject(new zzzmenu(1),550,340);
      //addObject(new zzzmenu(2),548, 460);
      
    }
     public void stopplaying()
    {
        v.stop();
    }
    private void prepare()
    {
    
    
    }
    public void act()
    {
        if (Greenfoot.getKey()!=null&&delay==0){v.stop();Greenfoot.setWorld(new menuworld());}
        if (delay>0) delay--;
        v.playLoop();
    }
}
