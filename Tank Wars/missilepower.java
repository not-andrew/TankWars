import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class missilepower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class missilepower extends Actor
{
    /**
     * Act - do whatever the missilepower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int delay=20;
    boolean waspressed=false;
    GreenfootImage[] frame=new GreenfootImage[80];
    int frn=0; //framenumber
    public void addedToWorld(World World)
    {
        for (int i=1;i<=63;i++)
        {frame [i]=new GreenfootImage("explosion/frame00" + i + ".png");
            
            
            
        }
        
        
        
    }
    public void act() 
    {
        if (Greenfoot.getMouseInfo() != null&&!waspressed) staywithmouse();
        if (delay==0&&!waspressed)rocketbarrage();
        else delay--;
        if (waspressed){animate();}
        // Add your action code here.
    }    
    public void animate()
    {
        if (frn==63) getWorld().removeObject(this);        
        setImage(frame[frn]); frn++;
    }
    public void staywithmouse ()
    {
     int x=Greenfoot.getMouseInfo().getX();
        int y=Greenfoot.getMouseInfo().getY();   
        setLocation(x,y);
        
    }
    public void rocketbarrage()
    {
        
        if (Greenfoot.getMouseInfo()!=null){
            
        if (Greenfoot.getMouseInfo().getButton()==3) {
            GreenfootSound v=new GreenfootSound("sounds/missilepower.mp3");
            v.play();
            
         List <Tank> list_objects=getIntersectingObjects(Tank.class);
         for(Tank classObject : list_objects)
{
          classObject.remove();
}
         player pl = (player) getWorld().getObjects(player.class).get(0); 
       pl.isanother=false;
       //getWorld().removeObject(this);
         waspressed=true;
        }
        
        
    }}
    
    
    
}
