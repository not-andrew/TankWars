import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class the2pworld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public static final int WIDE=1100;
    public static final int HIGH=750;
    Scroller scroller;
    Actor scrollActor;
    public int plower;
    
    public the2pworld(int plowe,int red,int blue)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDE, HIGH, 1,false); 
        GreenfootImage bg=new GreenfootImage("textura.png");
        int bgHigh=bg.getHeight();
        int bgWide=bg.getWidth();
        scroller =new Scroller(this,bg);
        scrollActor=new movepoint();
        addObject(scrollActor,WIDE/2,HIGH/2);
        scroll1();
        prepare();
        blueplayer blueplayer = new blueplayer(blue);
        addObject(blueplayer,279,380);
        redplayer redplayer = new redplayer(red);
        addObject(redplayer,841,374);
        blueplayer.turn(180);
        redplayer.setLocation(225,369);
        blueplayer.setLocation(862,378);
        if (plowe==1) {
        redplayer rvp = (redplayer) getObjects(redplayer.class).get(0);
        rvp.isplower=true;
        }
        if (plowe==0) {
        blueplayer bvp = (blueplayer) getObjects(blueplayer.class).get(0);
        bvp.isplower=true;    
    }
        plower=plowe;
        //setPaintOrder(powertimer.class,player.class,mouse.class,platform.class,enemy.class);
    }
    public void act()
    {
     if(scrollActor!=null)scroll1();   
        
    }
    private void scroll1()
    {
        int dsx=scrollActor.getX()-WIDE/2;
        int dsy=scrollActor.getY()-HIGH/2;
        scroller.scroll(dsx,dsy);
    }
    private void scroll()
    {
        int loX=100;//roaming limits
        int hiX=WIDE-100;
        int loY=70;
        int hiY=HIGH-70;
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

        firewall firewall = new firewall();
        addObject(firewall,506,374);
        
        tracker tracker = new tracker();
        addObject(tracker,550,375);
    }
}
