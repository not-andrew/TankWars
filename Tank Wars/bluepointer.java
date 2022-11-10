import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class redpointer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class  bluepointer extends zz
{
    /**
     * Act - do whatever the redpointer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int framenumber=0;
    int delay=1;
    int dir=1;
    GreenfootImage[] frame=new GreenfootImage[4];
    public bluepointer()
    {
        GreenfootImage c=new GreenfootImage("2pmode/pointers/bluepointer1.png");
        c.scale(45,45);
        frame[1]=c;
        GreenfootImage c2=new GreenfootImage("2pmode/pointers/bluepointer2.png");
        c2.scale(45,45);
        frame[2]=c2;
        GreenfootImage c3=new GreenfootImage("2pmode/pointers/bluepointer3.png");
        c3.scale(45,45);
        frame[3]=c3;
        
    }
    
    public void act() 
    {
        if (delay==1){animate(); delay=4;framenumber+=dir;}
        else delay--;
        if (framenumber==4||framenumber==0) {dir=dir*-1; framenumber+=dir;}
        move();
        // Add your action code here.
    }    
    public void animate ()
    {
        setImage(frame[framenumber]);
        
    }
    public void move()
    {
        if (Greenfoot.isKeyDown("k")) setLocation(getX(),getY()+5);
        if (Greenfoot.isKeyDown("i")) setLocation(getX(),getY()-5);
        if (Greenfoot.isKeyDown("l")) setLocation(getX()+5,getY());
        if (Greenfoot.isKeyDown("j")) setLocation(getX()-5,getY());
        
    }
    
    
    
}
