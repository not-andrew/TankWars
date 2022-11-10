import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class generator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class generator extends yzobstacles
{
    int hp=75;
    int gennr;
    /**
     * Act - do whatever the generator wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public generator (int wrld)
    {
        gennr=wrld;
    }
    public void act() 
    {
        
        //getrealcoords();
        if (hp==0){
            //change world code
            if (gennr==1)Greenfoot.setWorld(new spworld2());
            if (gennr==2)Greenfoot.setWorld(new spworld3());
            getWorld().removeObject(this);
        }
        // Add your action code here.
    }    
}
