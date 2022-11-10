import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class fixedcanon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class fixedcanon extends yzobstacles
{
    /**
     * Act - do whatever the fixedcanon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int hp=50;
    public void act() 
    {
        //getrealcoords();
        trackplayer();
        if( hp<1) getWorld().removeObject(this);
        // Add your action code here.
    }    
    public void trackplayer()
    {int turnvalue=0;
     
      player playerspot = (player) getWorld().getObjects(player.class).get(0);
         int x=playerspot.getX();
         int y=playerspot.getY();
         int rot=getRotation();
         turnTowards(x,y); int nrot=getRotation();
         
         if (((nrot-rot)>2||(nrot-rot)<2)){
            if (nrot>rot){if (nrot-rot<180){turnvalue=1;} else turnvalue=-1;}
            if (nrot<rot){if (rot-nrot>180){turnvalue=1; }else turnvalue=-1;  }
            setRotation(rot);
            turn(turnvalue);
            
            }
         else { setRotation(rot);}
             
             
             //if (shotdelay==0) shotdelay=900000;
             //if (shotdelay>250000) projectilerot=getRotation();
             //shotdelay--;
             if (Greenfoot.getRandomNumber(550)==3){
                 GreenfootSound v=new GreenfootSound("sounds/enemyshot.mp3");
            v.play();
                 entankprojectile spawn=new entankprojectile(rot); 
                 getWorld().addObject(spawn,getX(),getY());
                }
            }
}
