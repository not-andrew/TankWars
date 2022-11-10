import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class entankprojectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class entankprojectile extends enemyspot
{
    /**
     * Act - do whatever the entankprojectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int speeddegradation=0;
    public boolean wasplaced=false;
    public int projectilerot=0;
    public int dmg=25;
    public void act() 
    {
        
        
        
        gotowards();
        checkcolision();
        // Add your action code here.
    }  
    public entankprojectile()
    {
    }
    
    public entankprojectile(int rot)
    {
        projectilerot=rot;
    }
    public void gotowards()
    {
        //enemyspot tkb = (enemyspot) getWorld().getObjects(enemyspot.class).get(0); // get reference to tankbottom
    //int x=tkb.getX();
    //int y=tkb.getY();
    
    if (wasplaced==false){
        //int rotation=tkb.projectilerot;
    
        //setLocation(x,y);
        wasplaced=true; setRotation(projectilerot);}
    if (speeddegradation<11)speeddegradation++;
    
    move(24-speeddegradation);
        
    }
    public void checkcolision()
    {
      Actor pl = getOneIntersectingObject(player.class);
      if(isAtEdge()) {getWorld().removeObject(this);}
      else{
    if (pl != null) {
        //getWorld().removeObject(beejump);
        player pl2 = (player) getWorld().getObjects(player.class).get(0);
        pl2.hp-=dmg;
        getWorld().removeObject(this);
    }
     else{if (isTouching(yzobstacles.class)){getWorld().removeObject(this);}}
}}
}
