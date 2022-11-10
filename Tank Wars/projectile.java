import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class projectile extends Actor
{ boolean wasplaced=false;
    int speeddegradation=0;
    /**
     * Act - do whatever the projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        gotowards();
        checkcolision();
        // Add your action code here.
    }   
    public void gotowards()
    {
     //if (!getWorld().getObjects().isEmpty()) // is a ball in world
       
    mouse tkb = (mouse) getWorld().getObjects(mouse.class).get(0); // get reference to tankbottom
    int x=tkb.getX();
    int y=tkb.getY();
    
    if (wasplaced==false){
        int mx=Greenfoot.getMouseInfo().getX();
    int my=Greenfoot.getMouseInfo().getY();
        setLocation(x,y); wasplaced=true; turnTowards(mx,my);}
    if (speeddegradation<24)speeddegradation++;
    
    move(48-speeddegradation);
    
    
    }
    public void checkcolision()
    {
      //Tank Tank =(Tank) getOneIntersectingObject(Tank.class);
      //Actor Tank = getOneIntersectingObject(Tank.class);
      //asta nu merge pt ca Tank in cazul asta e un obiect actor,
      //nu un obiect tank
      
      if(isAtEdge()) {getWorld().removeObject(this);}
      else{Tank Tank =(Tank) getOneIntersectingObject(Tank.class);
    if (Tank != null) {
        
         
        Tank.remove();
        //getWorld().removeObject(Tank);
        getWorld().removeObject(this);
    }
     else{ generator g =(generator) getOneIntersectingObject(generator.class);
    if (g != null) {
        
         
        g.hp-=25;
        //getWorld().removeObject(Tank);
        getWorld().removeObject(this);
    }
    else
    {fixedcanon e =(fixedcanon) getOneIntersectingObject(fixedcanon.class);
    if (e != null) {
        
         
        e.hp-=25;
        //getWorld().removeObject(Tank);
        getWorld().removeObject(this);
    }
        
      else{if (isTouching(yzobstacles.class)){getWorld().removeObject(this);}}
    }
}
}
}
}
