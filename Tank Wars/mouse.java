import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class tankbottom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mouse extends Actor
{
    
    
    int timeout=0;
    private final int speed=4;
    int yoffset;
    int partcopy;
    int ax,ay;
    public GreenfootImage[] images=new GreenfootImage[14];
    public void addedToWorld (World MyWorld)
    {
        images[0]= new GreenfootImage("Hull_lower.png");
        images[1]= new GreenfootImage("Hull_Wheels_Mid.png");
        images[2]= new GreenfootImage("Hull_Hull_mid.png");
        images[3]= new GreenfootImage("Hull_Top.png");
        images[4]= new GreenfootImage("Turret_lower.png");
        images[5]= new GreenfootImage("Turret_Upper.png");
        images[6]= new GreenfootImage("Turret_MG.png");
        images[7]= new GreenfootImage("EnemyHull_lower.png");
        images[8]= new GreenfootImage("EnemyHull_mid.png");
        images[9]= new GreenfootImage("EnemyHull_top.png");
        images[10]= new GreenfootImage("EnemyTurret_lower.png");
        images[11]= new GreenfootImage("EnemyTurret_top.png");
    }
    public void act() 
    {
        
        setImage(images[partcopy]);
        yoffset=partcopy*4;
        if (partcopy>3){if (Greenfoot.getMouseInfo() != null){rotateturret();} 
        keepturretinplace();}
        else {rotate();
       
    }
    
    }    
    public mouse()
    {
    }
    
    public mouse(int part)
    {
     setImage(images[part]);
     
        partcopy=part;
    }
    public void checkcollision()
    {player pl = (player) getWorld().getObjects(player.class).get(0);
        
        if (isTouching(platform.class)==false){ 
             ax=pl.getX();
         ay=pl.getY();
        }
        else {
            pl.setLocation(ax,ay);
        }
    }
    
    
    
    public void rotate()
    {
        
        player pl = (player) getWorld().getObjects(player.class).get(0); // get reference to tankbottom
    int x=pl.getX();
    int y=pl.getY();
    setLocation(x,y-yoffset);
    int degrees=pl.degrees;
     
        setRotation(degrees);
        
    }
    public void rotateturret()
    {
         player pl = (player) getWorld().getObjects(player.class).get(0);
        int x=Greenfoot.getMouseInfo().getX();
        int y=Greenfoot.getMouseInfo().getY();
        turnTowards(x,y);
        
        if ((Greenfoot.getMouseInfo().getButton()==1&&pl.timeout==0)&&partcopy==4){
            GreenfootSound v=new GreenfootSound("sounds/tankshot.mp3");
            v.play();
            projectile projectile=new projectile();
            getWorld().addObject(projectile, getX(),getY()); pl.timeout=370;}
        else if (pl.timeout>0) pl.timeout--;
        
        
    }
    public void keepturretinplace()
    {
         player pl = (player) getWorld().getObjects(player.class).get(0); // get reference to tankbottom
    int x1=pl.getX();
    int y1=pl.getY();
    setLocation(x1,y1-yoffset);
    int degrees=getRotation();
    int change=pl.change;
        setRotation(degrees-change);
    }
}