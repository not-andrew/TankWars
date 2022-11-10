import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class redprojectile extends zz
{ boolean wasplaced=false;
    int speeddegradation=0;
    int direction;
    /**
     * Act - do whatever the projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int dm;
    public redprojectile(int rot,int d)
    {
        direction=rot;
        turn(direction);
        dm=d;
        GreenfootSound v=new GreenfootSound("sounds/tankshot.mp3");
                
            v.play();
    }
    public void act() 
    {
        gotowards();
        checkcolision();
        // Add your action code here.
    }   
    public void gotowards()
    {
     //if (!getWorld().getObjects().isEmpty()) // is a ball in world
       
    
    
    
    if (speeddegradation<24)speeddegradation++;
    
    move(38-speeddegradation);
    
    
    }
    public int edge()
    {int ret=0;
        movepoint mvp = (movepoint) getWorld().getObjects(movepoint.class).get(0);
     if (getX()>(mvp.getX()+520)) ret=1;
     if (getX()<(mvp.getX()-520)) ret=1;
     if (getY()>(mvp.getY()+320)) ret=1;
     if (getY()<(mvp.getY()-320)) ret=1;
     return ret;
    }
    public void checkcolision()
    {
      //Tank Tank =(Tank) getOneIntersectingObject(Tank.class);
      //Actor Tank = getOneIntersectingObject(Tank.class);
      //asta nu merge pt ca Tank in cazul asta e un obiect actor,
      //nu un obiect tank
      
      if(edge()==1) {getWorld().removeObject(this);}
      else{blueplayer blp =(blueplayer) getOneIntersectingObject(blueplayer.class);
    if (blp != null) {
        
         
        blp.hp-=dm;
        //getWorld().removeObject(Tank);
        getWorld().removeObject(this);
    }}
     
    }
}
