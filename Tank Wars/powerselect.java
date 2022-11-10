import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class powerselect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class powerselect extends World
{

    /**
     * Constructor for objects of class powerselect.
     * 
     */
    public powerselect()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100, 750, 1); 
         
        GreenfootImage bg =new GreenfootImage("ui/BAckhround.png");
        bg.scale(1100,750);
        setBackground(bg);
        for (int i=1;i<=4;i++){addObject(new zzzbluemenu(i),600,300); 
            addObject(new zzzredmenu(i),0,0);}
            addObject(new zzz2pdone(),0,0);
    }
    
    
    
}
