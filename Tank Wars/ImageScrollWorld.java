import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImageScrollWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public static final int WIDE=1100;
    public static final int HIGH=750;
    Scroller scroller;
    Actor scrollActor;
    
    public ImageScrollWorld()
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
        scrollActor.move(-600);
        prepare();
        setPaintOrder(powertimer.class,mouse.class,player.class,platform.class,enemy.class);
    }
    public void act()
    {
     if(scrollActor!=null)scroll();   
        
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
        int xm=-654;
        int ym=-161;
        int xs=1591;
        int ys=902;
        //left vrt wall
        addObject(new wallv(),xm,-97);
        addObject(new wallv(),xm,38);
        addObject(new wallv(),xm,171);
        addObject(new wallv(),xm,305);
        addObject(new wallv(),xm,438);
        addObject(new wallv(),xm,576);
        addObject(new wallv(),xm,708);
        addObject(new wallv(),xm,838);
        //right vert wall
        addObject(new wallv(),xs,-97);
        addObject(new wallv(),xs,38);
        addObject(new wallv(),xs,171);
        addObject(new wallv(),xs,305);
        addObject(new wallv(),xs,438);
        addObject(new wallv(),xs,576);
        addObject(new wallv(),xs,708);
        addObject(new wallv(),xs,838);
        //horiz wall up
        addObject(new wallhor(),-567,ym);
        addObject(new wallhor(),-407,ym);
        addObject(new wallhor(),-247,ym);
        addObject(new wallhor(),-88,ym);
        addObject(new wallhor(),72,ym);
        addObject(new wallhor(),228,ym);
        addObject(new wallhor(),388,ym);
        addObject(new wallhor(),548,ym);
        addObject(new wallhor(),707,ym);
        addObject(new wallhor(),867,ym);
        addObject(new wallhor(),1026,ym);
        addObject(new wallhor(),1186,ym);
        addObject(new wallhor(),1345,ym);
        addObject(new wallhor(),1504,ym);
        //horiz wall down
        addObject(new wallhor(),-567,ys);
        addObject(new wallhor(),-407,ys);
        addObject(new wallhor(),-247,ys);
        addObject(new wallhor(),-88,ys);
        addObject(new wallhor(),72,ys);
        addObject(new wallhor(),228,ys);
        addObject(new wallhor(),388,ys);
        addObject(new wallhor(),548,ys);
        addObject(new wallhor(),707,ys);
        addObject(new wallhor(),867,ys);
        addObject(new wallhor(),1026,ys);
        addObject(new wallhor(),1186,ys);
        addObject(new wallhor(),1345,ys);
        addObject(new wallhor(),1504,ys);
        //tanks
        addObject(new Tank(),222,94);
        addObject(new Tank(),458,692);
        addObject(new Tank(),678,635);
        addObject(new Tank(),1055,445);
        addObject(new Tank(),781,601);
        addObject(new Tank(),935,686);
        addObject(new Tank(),1121,669);
        addObject(new Tank(),958,311);
        addObject(new Tank(),447,193);
        addObject(new Tank(),471,351);
        //canons
        addObject(new fixedcanon(),384,-42);
        addObject(new fixedcanon(),513,474);
        addObject(new fixedcanon(),1208,383);
        
        
        //house
        addObject(new house(),-434,-64);
        addObject(new house(),-231,-64);
        addObject(new house(),88,-64);
        addObject(new house(),-267,712);
        addObject(new house(),45,712);
        addObject(new house(),234,465);
        //bigrock
        addObject(new bigrock(),31,438);
        addObject(new bigrock(),1,68);
        //bigbilding
        addObject(new bigbuilding(),817,73);
        addObject(new bigbuilding(),1063,73);
        addObject(new bigbuilding(),852,498);
        addObject(new bigbuilding(),1213,498);
        //generator
        addObject(new generator(1),1275,221);
        
        
        
    }
}
