import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class house here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bigbuilding extends yzobstacles
{
    /**
     * Act - do whatever the house wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Actor layer[];
    
    
    public GreenfootImage[] img=new GreenfootImage[64];
    protected void addedToWorld(World world)
    {
        //getrealcoords();
        img[0]=new GreenfootImage("obstacles/BigBuildingBase.png");
        //img[0].scale(280,280);
        img[1]=new GreenfootImage("obstacles/BigBuildingFloor1.png");
        //img[1].scale(280,280);
        img[3]=new GreenfootImage("obstacles/BigBuildingFloor2.png");
        //img[2].scale(280,280);
        img[2]=new GreenfootImage("obstacles/BigBuildingMid.png");
        //img[3].scale(280,280);
        img[4]=new GreenfootImage("obstacles/BigBuildingRoof.png");
        //img[4].scale(280,280);
        img[5]=new GreenfootImage("obstacles/BigBuildingTransparent.png");
        setImage(img[0]);
        if (layer == null)
        {
            layer= new Actor[6];
            for (int i=1; i<=5; i++)
            {int k=i;
                //layer[i] = new Part(i);
                if(i<9&&i>3){if (i%2==1){k=2;} if (i%2==0) {k=1;} if (i%2==2) {k=3;}}
                if (i==5) k=4;
                getWorld().addObject(new Part(k), getX(), getY()-18*i);
            }
        }
    }
    
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    
    
    
    public class Part extends Actor
    {
        private int partnum;
        int t=1;
        public Part (int id)
        {
            partnum= id;
            setImage(img[partnum]);
            t=1;
        }
        public void act()
        {
            if (t==0){setImage(img[partnum]);t=1;}
            if (isTouching(player.class)){
                
                setImage(new GreenfootImage("invplayer.png"));
                   t=0;
            }
            
        }   
    }
}
