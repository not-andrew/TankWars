import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        prepare();
       
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        player player = new player();
        addObject(player,439,282);

        for (int i=0;i<=6;i++){mouse mouse=new mouse(i);addObject(mouse,0,0);}
        //for (int j=0;j<=2;j++){mouse mouse=new mouse(j);addObject(mouse,0,0);}

        Tank tank = new Tank();
        addObject(tank,433,136);
        Tank tank2 = new Tank();
        addObject(tank2,145,247);
        Tank tank3 = new Tank();
        addObject(tank3,178,465);
        Tank tank4 = new Tank();
        addObject(tank4,344,512);
        Tank tank5 = new Tank();
        addObject(tank5,606,439);
        Tank tank6 = new Tank();
        addObject(tank6,733,273);
        Tank tank7 = new Tank();
        addObject(tank7,743,44);
        Tank tank8 = new Tank();
        addObject(tank8,113,90);
        Tank tank9 = new Tank();
        addObject(tank9,98,88);
        tank8.setLocation(113,96);
        Tank tank10 = new Tank();
        addObject(tank10,113,96);
        Tank tank11 = new Tank();
        addObject(tank11,285,174);
        Tank tank12 = new Tank();
        addObject(tank12,321,284);
        Tank tank13 = new Tank();
        addObject(tank13,440,390);
        Tank tank14 = new Tank();
        addObject(tank14,546,416);
        Tank tank15 = new Tank();
        addObject(tank15,682,145);
        Tank tank16 = new Tank();
        addObject(tank16,601,81);
        Tank tank17 = new Tank();
        addObject(tank17,504,173);
        Tank tank18 = new Tank();
        addObject(tank18,522,291);
        Tank tank19 = new Tank();
        addObject(tank19,488,335);
        Tank tank20 = new Tank();
        addObject(tank20,286,420);
        Tank tank21 = new Tank();
        addObject(tank21,98,539);
        Tank tank22 = new Tank();
        addObject(tank22,13,532);
        Tank tank23 = new Tank();
        addObject(tank23,87,327);
        Tank tank24 = new Tank();
        addObject(tank24,122,332);
        Tank tank25 = new Tank();
        addObject(tank25,205,428);
        Tank tank26 = new Tank();
        addObject(tank26,267,480);
        Tank tank27 = new Tank();
        addObject(tank27,459,539);
        Tank tank28 = new Tank();
        addObject(tank28,575,535);
        Tank tank29 = new Tank();
        addObject(tank29,686,487);
        Tank tank30 = new Tank();
        addObject(tank30,732,391);
        Tank tank31 = new Tank();
        addObject(tank31,708,316);
        Tank tank32 = new Tank();
        addObject(tank32,619,232);
        Tank tank33 = new Tank();
        addObject(tank33,544,125);
        Tank tank34 = new Tank();
        addObject(tank34,405,71);
        Tank tank35 = new Tank();
        addObject(tank35,275,79);
        Tank tank36 = new Tank();
        addObject(tank36,223,101);
        Tank tank37 = new Tank();
        addObject(tank37,181,213);
        Tank tank38 = new Tank();
        addObject(tank38,117,221);
        Tank tank39 = new Tank();
        addObject(tank39,84,186);
    }
}
