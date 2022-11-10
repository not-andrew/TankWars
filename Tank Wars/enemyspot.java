import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemyspot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemyspot extends Actor
{
    /**
     * Act - do whatever the enemyspot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean w=false;
    
     int xx;
       int xy;
    public void act() 
    { 
         
        c();
        
        if (Greenfoot.isKeyDown("y")) move(5);
        if(w==false){int x=getX(); int y=getY();
        for (int i=0;i<=4;i++){enemy enemy=new enemy(i);  
            getWorld().addObject(enemy,x,y);  w=true; }
        
        
        }// Add your action code here.
    }   
    private void c ()
    {
        xx=getX();
        xy=getY();
    }
}
