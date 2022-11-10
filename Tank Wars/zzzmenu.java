import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class zzzmenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class zzzmenu extends Actor
{
    /**
     * Act - do whatever the zzzmenu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int option;
    GreenfootImage[] img=new GreenfootImage[6];
    int sndelay;
   
    public zzzmenu(int opt)
    {
        option=opt;
        img[1]=new GreenfootImage("ui/Singleplayer.png");
        img[1].scale(335,98);
        img[2]=new GreenfootImage("ui/2player.png");
        img[2].scale(335,98);
        setImage(img[opt]);
        
    }
    public void act() 
    {MouseInfo mouse = Greenfoot.getMouseInfo();
         if (mouse != null) {
            //change the file to what you want for when the mouse is not over the button.
            img[option].scale(335,98);
            List objects = getWorld().getObjectsAt(mouse.getX(), mouse.getY(), zzzmenu.class);
            for (Object object : objects)
            {
                if (object == this)
                {
                    //change the file to what you want for when the mouse is over the button.
                    img[option].scale(360,99);
                }
            }
        }
        
         
        if (Greenfoot.mouseClicked(this)){
            GreenfootSound v1 = ((menuworld) getWorld()).v;
            v1.stop();
        if (option==1) Greenfoot.setWorld(new interm());
        if (option==2) Greenfoot.setWorld(new powerselect());
        }
        
            // Add your action code here.
    }    
}
