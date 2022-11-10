import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class house here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class house extends yzobstacles
{
    /**
     * Act - do whatever the house wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Actor layer[];
    
    public GreenfootImage[] img=new GreenfootImage[64];
    protected void addedToWorld(World world)
    {
        img[0]=new GreenfootImage("obstacles/HouseMid.png");
        img[0].scale(256,256);
        img[1]=new GreenfootImage("obstacles/HouseTop.png");
        img[1].scale(256,256);
        img[2]=new GreenfootImage("obstacles/HouseFloor.png");
        img[2].scale(256,256);
        setImage(img[2]);
        if (layer == null)
        {
            layer= new Actor[5];
            for (int i=0; i<2; i++)
            {
                layer[i] = new Part(i);
                world.addObject(layer[i], getX(), getY()-17*i);
            }
        }
    }
    
    
    public void act() 
    {
        //getrealcoords();
        // Add your action code here.
    }    
    
    
    
    
    public class Part extends Actor
    {
        private int partnum;
        
        public Part (int id)
        {
            partnum= id;
            setImage(img[partnum]);
        }
    }
}
