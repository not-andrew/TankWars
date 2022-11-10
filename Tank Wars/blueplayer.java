import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class redplayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class blueplayer extends zz
{
    /**
     * Act - do whatever the redplayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Actor[] parts;
    int healdelay;
    boolean starthealing=false;
    int healam=15;
    int sy, sx;
    public boolean isplower;
    public int speed=6;
    int step=6;
    public int shotdelay;
    public int hp=100;
    int sdelay=15;
    private int inputtype=10; //10=movement 1=shoot
    private int power;
    private int damage=25;
    int powerdelay=200;
    GreenfootImage[] img=new GreenfootImage[6];
    protected void addedToWorld(World world)
    {
        //img[0]=new GreenfootImage("2pmode/Tracks.png");
        img[1]=new GreenfootImage("2pmode/BlueWheels.png");
        img[2]=new GreenfootImage("2pmode/2playerBlueHull.png");
        img[3]=new GreenfootImage("2pmode/2playerblueHull_Hull_mid.png");
        
        
        if (parts == null)
        {
            parts = new Actor[5];
            for (int i=1; i<4; i++)
            {
                parts[i] = new Part(i);
                world.addObject(parts[i], getX(), getY());
            }
        }
    }
    public blueplayer (int b)
    {
     //GreenfootImage n= new GreenfootImage("2pmode/blueplayertemp.png");
     //n.scale(44,44);
     //setImage(n);
        power=b;
        if (power==4) {hp=70; damage=34;}
        if (power==1) {hp=125;}
    }
    public void act() 
    {
        step=speed;
        if(inputtype==10) movement();
        stayonscreen();
        if (!isplower) collision2();
        shootstuff();
        collision(speed);
        if (power==2){if (powerdelay==0&&Greenfoot.isKeyDown("u")){sniper();
       powerdelay=300; }
       if (powerdelay>0){powerdelay--; 
        if (powerdelay==270) {
            int rott=getRotation();
            turnTowards(sx,sy);
        getWorld().addObject(new blueprojectile(getRotation(),20),getX(),getY());
        setRotation(rott);    
    }
        }}
        
        if (power==4)
        {
            if (healdelay==0&&hp<27){hp++;healdelay=120;}
            if (healdelay>0) healdelay--;
        }
        if (power==3)
        
        {
            if (hp>115) hp=115;
            if (Greenfoot.isKeyDown("u")&&powerdelay==0){
                GreenfootSound s= new GreenfootSound("sounds/selfrepair.mp3");
               s.play();
                starthealing=true;
            healam=15;powerdelay=3000;}
            if (starthealing&&healam>0){if (healdelay==0){hp++; healam--;healdelay=100;}
         if (healdelay>0) healdelay--;
         if (healam==0) starthealing=false;
        }
         if (powerdelay>0) powerdelay--;
        }
        
        for (int i=1; i<4; i++){
            
            parts[i].setRotation(getRotation());
            parts[i].setLocation(getX(), getY()-4*i);
        }
        
        
        // Add your action code here.
    }  
    public void sniper()
    {
        redplayer rvp = (redplayer) getWorld().getObjects(redplayer.class).get(0);
        getWorld().addObject(new snipertarget2(),rvp.getX(),rvp.getY()); 
        sx=rvp.getX(); sy=rvp.getY();
    }
    public void shootstuff()
    {
       if (Greenfoot.isKeyDown("/")&&inputtype==10&&shotdelay==0){
        inputtype=1;
        getWorld().addObject(new bluepointer(),getX(),getY());
        sdelay=20;
        }
        if (inputtype==1){
        
         shoot();
        if(sdelay>0) sdelay--; 
        }
        if (shotdelay>0) shotdelay--; 
        
        
    }
    
    public void movement ()
    {
        if (Greenfoot.isKeyDown("i")) move(speed);
        if (Greenfoot.isKeyDown("k")) move(-speed);
        if (Greenfoot.isKeyDown("l")) turn(speed-2);
        if (Greenfoot.isKeyDown("j")) turn(-speed+2);
        
    }
    public void stayonscreen() //checks to stay within a distance from movepoint
    {movepoint mvp = (movepoint) getWorld().getObjects(movepoint.class).get(0);
     if (getX()>(mvp.getX()+520)) setLocation(mvp.getX()+520,getY());
     if (getX()<(mvp.getX()-520)) setLocation(mvp.getX()-520,getY());
     if (getY()>(mvp.getY()+320)) setLocation(getX(),mvp.getY()+320);
     if (getY()<(mvp.getY()-320)) setLocation(getX(),mvp.getY()-320);
        
    
    }
    public void shoot()
    {
     bluepointer blp = (bluepointer) getWorld().getObjects(bluepointer.class).get(0);
     turnTowards(blp.getX(),blp.getY());  
        if (Greenfoot.isKeyDown("/")&&sdelay==0){
            getWorld().addObject(new blueprojectile(getRotation(),damage),getX(),getY());
        
    
             bluepointer bdp = (bluepointer) getWorld().getObjects(bluepointer.class).get(0);
               getWorld().removeObject(bdp);
               inputtype=10;
               shotdelay=200;
            }
        }
      
     
      //////
      public void collision2()
            {
                while (isonsolidground()) setLocation(getX(),getY()-1);
        while (didbumphead()) setLocation(getX(),getY()+1);
        while (canmoveright()==false) setLocation(getX()-1,getY());
        while (canmoveleft()==false) setLocation(getX()+1,getY());
            }
            public boolean isonsolidground()
    {
        boolean isonground=false;
        
        int imagewidth=getImage().getWidth();
        int imageheight=getImage().getHeight();
        if(getOneObjectAtOffset(imagewidth/-2,imageheight/2,redplayer.class)!=null||
        getOneObjectAtOffset(imagewidth/2,imageheight/2,redplayer.class)!=null)isonground=true;
        
        
        return isonground;
    }
    public boolean didbumphead()
    { boolean bumpedhead=false;
        int imagewidth=getImage().getWidth();
        int imageheight=getImage().getHeight();
        if(getOneObjectAtOffset(imagewidth/-2,imageheight/-2,redplayer.class)!=null||
         getOneObjectAtOffset(imagewidth/2,imageheight/-2,redplayer.class)!=null)bumpedhead=true;
        return bumpedhead;
    }
    public boolean canmoveleft()
    {boolean canmoveleft=true;
        int imagewidth=getImage().getWidth();
        int imageheight=getImage().getHeight();
        //-step ca sa nu declanseze isonsolidground (buffer)
        if(getOneObjectAtOffset(imagewidth/-2-step,imageheight/-2,redplayer.class)!=null||
        getOneObjectAtOffset(imagewidth/-2-step,imageheight/2-1,redplayer.class)!=null)canmoveleft=false;
        return canmoveleft;
        
    }
    public boolean canmoveright()
    {boolean canmoveright=true;
        int imagewidth=getImage().getWidth();
        int imageheight=getImage().getHeight();
        if(getOneObjectAtOffset(imagewidth/2+step,imageheight/-2,redplayer.class)!=null||
        getOneObjectAtOffset(imagewidth/2+step,imageheight/2-1,redplayer.class)!=null)canmoveright=false;
        return canmoveright;
        
    }
    /////     
         
    
    
    
    
    
    public class Part extends Actor
    {
        private int partnum;
        
        public Part (int id)
        {
            partnum= id;
            
            setImage(img[partnum]);
            //setImage(((mouse)Tank.this.getWorld().getObjects(mouse.class).get(0)).images[partnum+7]);
        }
    }
}
