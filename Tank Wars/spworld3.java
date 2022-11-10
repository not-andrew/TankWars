import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class spworld3 extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public static final int WIDE=1100;
    public static final int HIGH=750;
    Scroller scroller;
    Actor scrollActor;
    
    public spworld3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDE, HIGH, 1,false); 
        GreenfootImage bg=new GreenfootImage("textura.png");
        int bgHigh=bg.getHeight();
        int bgWide=bg.getWidth();
        scroller =new Scroller(this,bg);
        scrollActor=new player();
        addObject(scrollActor,bgWide/2,bgHigh/2);
        scroll();
        prepare();
        setPaintOrder(powertimer.class,mouse.class,player.class,platform.class,enemy.class);
    }
    public void act()
    {
     if(scrollActor!=null)scroll();   
     if (Greenfoot.getRandomNumber(150)==15){
         int k=Greenfoot.getRandomNumber(4);
         player pl = (player) getObjects(player.class).get(0);
         if (k==0) {
         addObject(new Tank(),pl.getX()-500, pl.getY()-Greenfoot.getRandomNumber(200));
        }
        if (k==1) {
         addObject(new Tank(),pl.getX()+500, pl.getY()+Greenfoot.getRandomNumber(200));
        }
        if (k==2) {
         addObject(new Tank(),pl.getX()-Greenfoot.getRandomNumber(200), pl.getY()-450);
        }
         if (k==2) {
         addObject(new Tank(),pl.getX()+Greenfoot.getRandomNumber(200), pl.getY()+450);
        } 
        
        }
        
    }
    private void scroll1()
    {
        int dsx=scrollActor.getX()-WIDE/2;
        int dsy=scrollActor.getY()-HIGH/2;
        scroller.scroll(dsx,dsy);
    }
    private void scroll()
    {
        int loX=190;//roaming limits
        int hiX=WIDE-190;
        int loY=160;
        int hiY=HIGH-160;
        int dsx=0, dsy=0;
        if (scrollActor.getX()<loX)dsx=scrollActor.getX()-loX;
        if (scrollActor.getX()>hiX)dsx=scrollActor.getX()-hiX;
        if (scrollActor.getY()<loY)dsy=scrollActor.getY()-loY;
        if (scrollActor.getY()>hiY)dsy=scrollActor.getY()-hiY;
        scroller.scroll(dsx,dsy);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        for (int i=0;i<=6;i++){mouse mouse=new mouse(i);addObject(mouse,0,0);}
        //for (int j=0;j<=2;j++){mouse mouse=new mouse(j);addObject(mouse,0,0);}

        powertimer powertimer = new powertimer();
        addObject(powertimer,894,691);
        
       
        
        
    }
    
}
