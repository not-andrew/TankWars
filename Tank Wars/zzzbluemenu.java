import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class zzzbluemenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class zzzbluemenu extends Actor
{
    /**
     * Act - do whatever the zzzbluemenu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int option;
    GreenfootImage[] img=new GreenfootImage[5];
    public zzzbluemenu(int opt)
    {
        option=opt;
        img[1]=new GreenfootImage("2pmenu/advarmor.png");
        img[1].scale(330,89);
        img[2]=new GreenfootImage("2pmenu/SNIPER.png");
        img[2].scale(330,89);
        img[3]=new GreenfootImage("2pmenu/selfrepair.png");
        img[3].scale(330,89);
        img[4]=new GreenfootImage("2pmenu/Dealwiththedevil.png");
        img[4].scale(330,89);
        setImage(img[option]);
        
        
    }
    public void act() 
    {
         MouseInfo mouse = Greenfoot.getMouseInfo();
        //Change Button.class to the name of your button class.
        if (mouse != null) {
            //change the file to what you want for when the mouse is not over the button.
            img[option].scale(330,89);
            List objects = getWorld().getObjectsAt(mouse.getX(), mouse.getY(), zzzbluemenu.class);
            for (Object object : objects)
            {
                if (object == this)
                {
                    //change the file to what you want for when the mouse is over the button.
                    img[option].scale(360,99);
                }
            }
        }
        setLocation(800,200+option*120);
        if (Greenfoot.mouseClicked(this))
        {zzz2pdone pl = (zzz2pdone) getWorld().getObjects(zzz2pdone.class).get(0);
            pl.blue=option;
        }
        // Add your action code here.
    }    
}
