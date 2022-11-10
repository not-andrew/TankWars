import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class the2pended here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class the2pended extends World
{

    /**
     * Constructor for objects of class the2pended.
     * 
     */
    int won=0;
    public the2pended(int whowon)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100, 750, 1); 
        addObject(new zzz2pended(),550,565);
        won=whowon; //1=blue won
    }
    public void act()
    {
        /*GreenfootImage main = getBackground();
        if (won==1){
     GreenfootImage img = new GreenfootImage("Blue Tank Won! ", 70, Color.BLACK,null);
    
    
     main.drawImage(img,350 , 275);
    }
    if (won==2){
     GreenfootImage img = new GreenfootImage("Red Tank Won! ", 70, Color.BLACK,null);
    
    
     main.drawImage(img,350 , 275);
    }*/
    GreenfootImage red=new GreenfootImage("2pmode/RedTOnk.png");
    red.scale(1100,750);
    GreenfootImage blu=new GreenfootImage("2pmode/BluTOnk.png");
    blu.scale(1100,750);
    if (won==2){
    setBackground(red);
    
    }
    if (won==1) { setBackground(blu);}
    }


}
