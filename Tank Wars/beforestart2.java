import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class powerselect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class beforestart2 extends World
{

    /**
     * Constructor for objects of class powerselect.
     * 
     */
    int plower;
    int timer=500;
    int redp, bluep;
    public beforestart2(int red, int blue)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100, 750, 1); 
        GreenfootImage bg =new GreenfootImage("ui/BAckhround.png");
        bg.scale(1100,750);
        setBackground(bg);
        plower=Greenfoot.getRandomNumber(2);
        redp=red; bluep=blue;    
    }
    public void act()
    {
        if (plower==1){
        GreenfootImage main = getBackground();
        
     GreenfootImage img = new GreenfootImage("red is the plower", 44, Color.RED,Color.WHITE);
       
     main.drawImage(img, 420, 370);
    }
    else{
         GreenfootImage main = getBackground();
        
     GreenfootImage img = new GreenfootImage("blue is the plower", 44, Color.BLUE,Color.WHITE);
       
     main.drawImage(img, 420, 370);
    }
     GreenfootImage main = getBackground();
        
     GreenfootImage img = new GreenfootImage("game will start in " +timer/60+" ", 44, Color.BLACK,Color.WHITE);
       
     main.drawImage(img, 410, 440);
     if (timer==0) Greenfoot.setWorld (new the2pworld(plower,redp,bluep));
     if (timer>0) timer--;
    }
}
