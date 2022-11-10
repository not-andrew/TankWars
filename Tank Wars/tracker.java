import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class tracker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tracker extends zz
{
    /**
     * Act - do whatever the tracker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        hptrack();
        showhp();
        // Add your action code here.
    }    
    public void hptrack()
    {
    redplayer r = (redplayer) getWorld().getObjects(redplayer.class).get(0);
        if (r.hp<1) Greenfoot.setWorld(new the2pended(1));
        
    blueplayer b = (blueplayer) getWorld().getObjects(blueplayer.class).get(0);
        if (b.hp<1) Greenfoot.setWorld(new the2pended(2));
    }
    public void showhp()
    {
        redplayer r = (redplayer) getWorld().getObjects(redplayer.class).get(0);
     blueplayer b = (blueplayer) getWorld().getObjects(blueplayer.class).get(0);
     movepoint mvp = (movepoint) getWorld().getObjects(movepoint.class).get(0);   
     
     GreenfootImage main = getWorld().getBackground();
       //red
     GreenfootImage img = new GreenfootImage(" "+r.hp+" ", 44, Color.RED,null);
     
     main.drawImage(img, mvp.getX()-250, mvp.getY()+220);
     
     
     //blue
     
     GreenfootImage img2 = new GreenfootImage(" "+b.hp+" ", 44, Color.BLUE,null);
     main.drawImage(img2, mvp.getX()+200,mvp.getY()+220);
       
    }
}
