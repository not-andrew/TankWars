import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class firewall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class firewall extends zz
{
    /**
     * Act - do whatever the firewall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int imnr=0;
    public int delay;
    GreenfootImage[] img=new GreenfootImage[5];
    public firewall()
    {
        img[0]=new GreenfootImage("invplayer.png");
        img[1]=new GreenfootImage("2pmode/flametempup.png");
        img[2]=new GreenfootImage("2pmode/flametempdown.png");
        img[3]=new GreenfootImage("2pmode/flametempleft.png");
        img[4]=new GreenfootImage("2pmode/flametempright.png");
        
    }
    public void act()
    {
        changeimage();
        //if (delay>0){if (imnr>0){collision();} delay=5;}
        //else delay--;
        
    }
    public void changeimage() 
    {
        setImage(img[imnr]);
        
        // Add your action code here.
    }
    public void collision()
   {
       redplayer r = (redplayer) getWorld().getObjects(redplayer.class).get(0);
     blueplayer b = (blueplayer) getWorld().getObjects(blueplayer.class).get(0);
       //redplayer rlp =(redplayer) getOneIntersectingObject(redplayer.class);
    if (isTouching(redplayer.class)) {
        
         
        r.hp-=5;
        //getWorld().removeObject(Tank);
        //getWorld().removeObject(this);
    }
       blueplayer blp =(blueplayer) getOneIntersectingObject(blueplayer.class);
    if (blp != null) {
        
         
        blp.hp-=5;
        //getWorld().removeObject(Tank);
        //getWorld().removeObject(this);
    }
    }
    
}
