import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class spworld2 extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public static final int WIDE=1100;
    public static final int HIGH=750;
    Scroller scroller;
    Actor scrollActor;
    
    public spworld2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDE, HIGH, 1,false); 
        GreenfootImage bg=new GreenfootImage("textura.png");
        int bgHigh=bg.getHeight();
        int bgWide=bg.getWidth();
        scroller =new Scroller(this,bg);
        scrollActor=new player();
        addObject(scrollActor,(bgWide/2),bgHigh/2);
        
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
        //rest vertwalls
        addObject(new wallv(),1048,-141);
        addObject(new wallv(),1048,265);
        addObject(new wallv(),269,399);
        addObject(new wallv(),272,777);
        //res horwall
        addObject(new wallhor(),341,335);
        addObject(new wallhor(),499,335);
        addObject(new wallhor(),659,335);
        addObject(new wallhor(),817,335);
        addObject(new wallhor(),977,335);
        //house
        addObject(new house(),-451,22);
        addObject(new house(),-205,22);
        addObject(new house(),21,22);
        addObject(new house(),-329,705);
        addObject(new house(),-70,705);
        //addObject(new house(),1318,790);
        addObject(new house(),1067,471);
        //bigbildin
        addObject(new bigbuilding(),124,310);
        addObject(new bigbuilding(),550,-15);
        addObject(new bigbuilding(),355,-15);
        //bigrock
        addObject(new bigrock(),271,477);
        addObject(new bigrock(),271,695);
        addObject(new bigrock(),1045,-67);
        addObject(new bigrock(),1046,182);
        //tanks
        addObject(new Tank(),1347,92);
        addObject(new Tank(),1203,342);
        addObject(new Tank(),1348,490);

        //canon
        /*addObject(new fixedcanon(),944,-57);
        addObject(new fixedcanon(),1081,186);
        addObject(new fixedcanon(),134,766);
        addObject(new Tank(),255,342);
        addObject(new fixedcanon(),271,748);
        addObject(new fixedcanon(),9,605);
        addObject(new fixedcanon(),738,-136);
        addObject(new fixedcanon(),82,-137);
         */
        //addObject(new fixedcanon(),280,360);

        fixedcanon fixedcanon = new fixedcanon();
        addObject(fixedcanon,343,387);
        fixedcanon fixedcanon2 = new fixedcanon();
        addObject(fixedcanon2,170,19);
        fixedcanon fixedcanon3 = new fixedcanon();
        addObject(fixedcanon3,1039,22);
        fixedcanon fixedcanon4 = new fixedcanon();
        addObject(fixedcanon4,668,12);
        fixedcanon fixedcanon5 = new fixedcanon();
        addObject(fixedcanon5,1074,725);
        fixedcanon fixedcanon6 = new fixedcanon();
        addObject(fixedcanon6,320,747);
        fixedcanon fixedcanon7 = new fixedcanon();
        addObject(fixedcanon7,65,733);
        fixedcanon fixedcanon8 = new fixedcanon();
        addObject(fixedcanon8,240,345);
        removeObject(fixedcanon8);

        fixedcanon fixedcanon9 = new fixedcanon();
        addObject(fixedcanon9,1078,269);

        //generator
        addObject(new generator(2),1350,-75);

        Tank tank4 = new Tank();
        addObject(tank4,436,233);
        Tank tank5 = new Tank();
        addObject(tank5,770,227);
        //house6.setLocation(1053,597);
        Tank tank6 = new Tank();
        addObject(tank6,1053,597);
        Tank tank7 = new Tank();
        addObject(tank7,435,403);
        Tank tank8 = new Tank();
        addObject(tank8,265,575);
       // bigbuildingPart.setLocation(98,229);
        Tank tank9 = new Tank();
        addObject(tank9,98,229);
        Tank tank10 = new Tank();
        addObject(tank10,24,451);
        Tank tank11 = new Tank();
        addObject(tank11,711,645);
    }
}
