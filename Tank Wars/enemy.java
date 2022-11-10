import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


 

public class enemy extends Actor
{
    int projectilerot;
    int shotdelay=0;
    int partcopy;
    int yoffset;
    int doturn=0;
    //int ex=xx;
    //int ey=xy;
    //public GreenfootImage[] images=new GreenfootImage[8];
    
    /*public void addtoworld (World MyWorld)
    {images[0]= new GreenfootImage("EnemyHull_lower.png");
        images[1]= new GreenfootImage("Enemy_Hull_Mid.png");
        images[2]= new GreenfootImage("EnemyHull_top.png");
        images[3]= new GreenfootImage("EnemyTurret_lower.png");
        images[4]= new GreenfootImage("EnemyTurret_top.png");
     
        
        
    }*/
    public enemy()
    {
    }
    public enemy (int part)
    {
        partcopy=part;
        
        //Actor mydot = getOneIntersectingObject(enemyspot.class);
        
    }
    
    
    
    public void act() 
    {
        
        mouse pl = (mouse) getWorld().getObjects(mouse.class).get(0);
        setImage(pl.images[partcopy+7]);
        yoffset=partcopy*3;
        stayonpoint();
        trackplayer();
        //setLocation(ex,ey);
        //setLocation(getX(), getY()-5);
        
    }    
    public void stayonpoint()
    {
        //enemyspot mydot = (enemyspot) getWorld().getObjects(enemyspot.class).get(0);
        //if (mydot!=null){
        
       // int x=xx;//getx();
        //int y=xy;//gety();
        setLocation(getX(),getY());
    //}
    }
    public void trackplayer()
    {int turnvalue=0;
     if (partcopy>2)
     { player playerspot = (player) getWorld().getObjects(player.class).get(0);
        
         int x=playerspot.getX();
         int y=playerspot.getY();
         int rot=getRotation();
         turnTowards(x,y); int nrot=getRotation();
         
         if (((nrot-rot)>2||(nrot-rot)<2)&&doturn==0){
            if (nrot>rot){if (nrot-rot<180){turnvalue=1;} else turnvalue=-1;}
            if (nrot<rot){if (rot-nrot>180){turnvalue=1; }else turnvalue=-1;  }
            setRotation(rot);
            turn(turnvalue);
            doturn=2;
            }
         else { doturn=0; setRotation(rot);}
             
             
             //if (shotdelay==0) shotdelay=900000;
             //if (shotdelay>250000) projectilerot=getRotation();
             //shotdelay--;
             if (Greenfoot.getRandomNumber(900)==3){
                 entankprojectile spawn=new entankprojectile(rot); 
                 getWorld().addObject(spawn,getX(),getY());
                }
             
            
          
         
        }
        
        
    }
    
    
    
}
