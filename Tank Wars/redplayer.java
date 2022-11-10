import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class redplayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class redplayer extends zz
{
    /**
     * Act - do whatever the redplayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Actor[] parts;
    int healdelay;
    boolean starthealing=false;
    int healam=15;
    int sx,sy;
    public boolean isplower;
    public int speed=6;
    public int shotdelay;
    public int hp=100;
    int sdelay=15;
    private int inputtype=10; //10=movement 1=shoot
    private int power;
    int damage=25;
    int powerdelay=200;
    GreenfootImage[] img=new GreenfootImage[6];
    protected void addedToWorld(World world)
    {
        //img[0]=new GreenfootImage("2pmode/Tracks.png");
        img[1]=new GreenfootImage("2pmode/RedWheels.png");
        img[2]=new GreenfootImage("2pmode/2playerRedHull.png");
        img[3]=new GreenfootImage("2pmode/2playerredHull_Hull_mid.png");
        
        
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
    
    public redplayer (int r)
    {
     //GreenfootImage n= new GreenfootImage("2pmode/redplayertemp.png");
     //n.scale(44,44);
     //setImage(n);
        power=r;
        if (power==4) {hp=70; damage=34;}
        if (power==1) {hp=115;}
    }
    public void act() 
    {
        if(inputtype==10) movement();
        stayonscreen();
        shootstuff();
        collision(speed);
        if (!isplower) collision2(speed);
        if (power==2&&powerdelay==0&&Greenfoot.isKeyDown("q")){sniper();
       powerdelay=300; }
       if (powerdelay>0){powerdelay--; 
        if (powerdelay==270) {
            int rott=getRotation();
            turnTowards(sx,sy);
        getWorld().addObject(new redprojectile(getRotation(),20),getX(),getY());
        setRotation(rott);    
    }
        }
        
        if (power==4)
        {
            if (healdelay==0&&hp<27){hp++;healdelay=120;}
            if (healdelay>0) healdelay--;
        }
        if (power==3)
        
        {
            if (hp>115) hp=115;
            if (Greenfoot.isKeyDown("q")&&powerdelay==0){starthealing=true;
            GreenfootSound s= new GreenfootSound("sounds/selfrepair.mp3");
               s.play();
                
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
        blueplayer rvp = (blueplayer) getWorld().getObjects(blueplayer.class).get(0);
        getWorld().addObject(new snipertarget2(),rvp.getX(),rvp.getY()); 
        sx=rvp.getX(); sy=rvp.getY();
    }
    public void shootstuff()
    {
       if (Greenfoot.isKeyDown("space")&&inputtype==10&&shotdelay==0){
        inputtype=1;
        getWorld().addObject(new redpointer(),getX(),getY());
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
        if (Greenfoot.isKeyDown("w")) move(speed);
        if (Greenfoot.isKeyDown("s")) move(-speed);
        if (Greenfoot.isKeyDown("d")) turn(speed-2);
        if (Greenfoot.isKeyDown("a")) turn(-speed+2);
        
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
     redpointer rlp = (redpointer) getWorld().getObjects(redpointer.class).get(0);
     turnTowards(rlp.getX(),rlp.getY());  
        if (Greenfoot.isKeyDown("space")&&sdelay==0){
            getWorld().addObject(new redprojectile(getRotation(),damage),getX(),getY());
        
    
             redpointer rdp = (redpointer) getWorld().getObjects(redpointer.class).get(0);
               getWorld().removeObject(rdp);
               inputtype=10;
               shotdelay=200;
            }
}
    




      public void collision2(int step)
    {
        while (isonsolidground(step)) setLocation(getX(),getY()-1);
        while (didbumphead(step)) setLocation(getX(),getY()+1);
        while (canmoveright(step)==false) setLocation(getX()-1,getY());
        while (canmoveleft(step)==false) setLocation(getX()+1,getY());
    }
            public boolean isonsolidground(int step)
    {
        boolean isonground=false;
        
        int imagewidth=getImage().getWidth();
        int imageheight=getImage().getHeight();
        if(getOneObjectAtOffset(imagewidth/-2,imageheight/2,blueplayer.class)!=null||
        getOneObjectAtOffset(imagewidth/2,imageheight/2,blueplayer.class)!=null)isonground=true;
        
        
        return isonground;
    }
    public boolean didbumphead(int step)
    { boolean bumpedhead=false;
        int imagewidth=getImage().getWidth();
        int imageheight=getImage().getHeight();
        if(getOneObjectAtOffset(imagewidth/-2,imageheight/-2,blueplayer.class)!=null||
         getOneObjectAtOffset(imagewidth/2,imageheight/-2,blueplayer.class)!=null)bumpedhead=true;
        return bumpedhead;
    }
    public boolean canmoveleft(int step)
    {boolean canmoveleft=true;
        int imagewidth=getImage().getWidth();
        int imageheight=getImage().getHeight();
        //-step ca sa nu declanseze isonsolidground (buffer)
        if(getOneObjectAtOffset(imagewidth/-2-step,imageheight/-2,blueplayer.class)!=null||
        getOneObjectAtOffset(imagewidth/-2-step,imageheight/2-1,blueplayer.class)!=null)canmoveleft=false;
        return canmoveleft;
        
    }
    public boolean canmoveright(int step)
    {boolean canmoveright=true;
        int imagewidth=getImage().getWidth();
        int imageheight=getImage().getHeight();
        if(getOneObjectAtOffset(imagewidth/2+step,imageheight/-2,blueplayer.class)!=null||
        getOneObjectAtOffset(imagewidth/2+step,imageheight/2-1,blueplayer.class)!=null)canmoveright=false;
        return canmoveright;
        
    }

    
    
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
