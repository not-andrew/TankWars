import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class player extends collisionhaver

{   boolean ws=false;
    int plam=0;
    private final int speed=4;
    public int degrees;
    public int change;
    public int ax,ay;
    int powerdelay=0;
    int step=5;
     int timeout=0;
    boolean isanother=false;
    public int hp=100;
    public int healdelay=1000;
    GreenfootSound selfrepair= new GreenfootSound("sounds/selfrepair.mp3");
    /**
     * Act - do whatever the player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] imgs= new GreenfootImage[5];
    public void addedToWorld (World World)
    {
        imgs[1]=new GreenfootImage("Hp/h1.png");
        imgs[2]=new GreenfootImage("Hp/h2.png");
        imgs[3]=new GreenfootImage("Hp/h3.png");
        imgs[4]=new GreenfootImage("Hp/h4.png");
        
    }
  
    
    
    public void act() 
    {
        
        movem(); rotate();
        power();
        collision(step);
        hpring();
        if (hp<1) {if (getWorld().getClass().getName()=="spworld3"){ Greenfoot.setWorld(new win());}
    else {Greenfoot.setWorld(new failed());}
    }
      
    } 
    public void hpring()
    {
        if (hp>76) {setImage(imgs[4]);}
        if (hp<76){setImage(imgs[3]);}
        if (hp<51){setImage(imgs[2]);}
        if (hp<26){setImage(imgs[1]);}
        if (hp>125) hp=125;
        if (Greenfoot.isKeyDown("e")&&healdelay==0){hp+=20;healdelay=1560;
        
        selfrepair.play();
        }
        if (healdelay>0)healdelay--;
        
        
    }
    public void power()
    {
     if (Greenfoot.getMouseInfo()!=null){
        if (Greenfoot.getMouseInfo().getButton()==3&&powerdelay==0&&isanother==false){
        missilepower n = new missilepower();
        getWorld().addObject(n,Greenfoot.getMouseInfo().getX(),Greenfoot.getMouseInfo().getY());
        powerdelay=900;
        isanother=true;
    }
     else { if (isanother==false&&powerdelay>0) powerdelay--;}

}
    
    
    
    }
    public void movem()
    {//sprite pus invers asa ca mergi invers
      ax=getX();
          ay=getY();
         
        if (Greenfoot.isKeyDown("s")) {move (speed);
          
        }
     if (Greenfoot.isKeyDown("w")) {move (-speed); 
       
        }
        
          
    
    }
    public void rotate()
    {
        degrees=getRotation();
        change=0;
     if (Greenfoot.isKeyDown("a")){degrees-=5; change +=5;}
     if (Greenfoot.isKeyDown("d")){degrees+=5; change-=5;}
        setRotation(degrees);
        
    }
    
    
    
}
