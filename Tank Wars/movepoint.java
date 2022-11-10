import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class movepoint here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class movepoint extends zz
{
    /**
     * Act - do whatever the movepoint wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int delay=0;
    int delay2=0;
    int movetype=17;
    public void act() 
    {  firewall f = (firewall) getWorld().getObjects(firewall.class).get(0);
        if (delay==0){f.imnr=0;
         if (delay2==0){movetype=Greenfoot.getRandomNumber(4);delay=460;} 
         else {if (delay2>0)delay2--;
            }  
         
        }
        redplayer r = (redplayer) getWorld().getObjects(redplayer.class).get(0);
     blueplayer b = (blueplayer) getWorld().getObjects(blueplayer.class).get(0);
        if (delay>0){delay2=100; int x=getX(),y=getY();
         //firewall f =(firewall) getOneIntersectingObject(firewall.class);
         if (movetype==1){setLocation(getX()+1,getY()); delay--;
            f.imnr=3; f.setLocation(x-10,y);
        
        if (r.getX()<getX()-510) r.hp-=1;
        if (b.getX()<getX()-510) b.hp-=1;
        }
         if (movetype==3){setLocation(getX()-1,getY()); delay--;
            f.imnr=4; f.setLocation(x+10,y);
            if (r.getX()>getX()+510) r.hp-=1;
            if (b.getX()>getX()+510) b.hp-=1;
        }   
         if (movetype==2){setLocation(getX(),getY()-1); delay--;
            f.imnr=2; f.setLocation(x,y+10);
            if (r.getY()>getY()+305) r.hp-=1;
            if (b.getY()>getY()+305) b.hp-=1;
        }
         if (movetype==0){setLocation(getX(),getY()+1); delay--;
            f.imnr=1; f.setLocation(x,y-10);
            if (r.getY()<getY()-305) r.hp-=1;
            if (b.getY()<getY()-305) b.hp-=1;
        }
         
        }
        
        
        
        // Add your action code here.
    }    
}
