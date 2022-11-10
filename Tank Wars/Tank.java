import greenfoot.*;
 
public class Tank extends collisionhaver
{
    private Actor[] parts;
     int doturn=0;
    public int shouldremove=0;
    int rottimeout=0;
    int rott=0;
    int step=2;
    int movedelay=25;
    protected void addedToWorld(World world)
    {
        if (parts == null)
        {
            parts = new Actor[5];
            for (int i=0; i<5; i++)
            {
                parts[i] = new Part(i);
                world.addObject(parts[i], getX(), getY());
            }
        }
    }
     
    public void act()
    {
         if (movedelay<70&&Greenfoot.getRandomNumber(24)>5){randommove(); }
        if (movedelay <100){movedelay+=1+Greenfoot.getRandomNumber(4);}
             if (movedelay>99) movedelay=0;
             collision(step);
        collision2();
        for (int i=0; i<5; i++){
            
            
            parts[i].setLocation(getX(), getY()-3*i);
             if(i>2&&doturn==0) {trackplayer(i); doturn=2;} 
             else doturn=0;  
        }
        
        
        
        
        
    }
    public void remove()
    {
        
        
        for (int i=0;i<5;i++)  getWorld().removeObject(parts[i]);
        
        getWorld().removeObject(this);
    
        
        
    }
    public void randommove()
    {if (rottimeout==0) {rott=Greenfoot.getRandomNumber(45) ;
        if (Greenfoot.getRandomNumber(3)==0) rott*=-1; rottimeout=11;
        turn (rott);
        for (int i=0;i<3;i++)  {parts[i].turn(rott);}
    }
        else{rottimeout--;}
     
     
     move (1+Greenfoot.getRandomNumber(2));
        
        
    }
     public void trackplayer(int i)
    {int turnvalue=0;
     
      player playerspot = (player) getWorld().getObjects(player.class).get(0);
         int x=playerspot.getX();
         int y=playerspot.getY();
         int rot=parts[i].getRotation();
         parts[i].turnTowards(x,y); int nrot=parts[i].getRotation();
         
         if (((nrot-rot)>2||(nrot-rot)<2)){
            if (nrot>rot){if (nrot-rot<180){turnvalue=1;} else turnvalue=-1;}
            if (nrot<rot){if (rot-nrot>180){turnvalue=1; }else turnvalue=-1;  }
            parts[i].setRotation(rot);
            parts[i].turn(turnvalue);
            
            }
         else { parts[i].setRotation(rot);}
             
             
             //if (shotdelay==0) shotdelay=900000;
             //if (shotdelay>250000) projectilerot=getRotation();
             //shotdelay--;
             if (Greenfoot.getRandomNumber(800)==3){
                 GreenfootSound v=new GreenfootSound("sounds/enemyshot.mp3");
                 v.setVolume(44);
            v.play();
                 entankprojectile spawn=new entankprojectile(rot); 
                 getWorld().addObject(spawn,getX(),getY());
                }
            }
            ////////////////
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
        if(getOneObjectAtOffset(imagewidth/-2,imageheight/2,player.class)!=null||
        getOneObjectAtOffset(imagewidth/2,imageheight/2,player.class)!=null)isonground=true;
        
        
        return isonground;
    }
    public boolean didbumphead()
    { boolean bumpedhead=false;
        int imagewidth=getImage().getWidth();
        int imageheight=getImage().getHeight();
        if(getOneObjectAtOffset(imagewidth/-2,imageheight/-2,player.class)!=null||
         getOneObjectAtOffset(imagewidth/2,imageheight/-2,player.class)!=null)bumpedhead=true;
        return bumpedhead;
    }
    public boolean canmoveleft()
    {boolean canmoveleft=true;
        int imagewidth=getImage().getWidth();
        int imageheight=getImage().getHeight();
        //-step ca sa nu declanseze isonsolidground (buffer)
        if(getOneObjectAtOffset(imagewidth/-2-step,imageheight/-2,player.class)!=null||
        getOneObjectAtOffset(imagewidth/-2-step,imageheight/2-1,player.class)!=null)canmoveleft=false;
        return canmoveleft;
        
    }
    public boolean canmoveright()
    {boolean canmoveright=true;
        int imagewidth=getImage().getWidth();
        int imageheight=getImage().getHeight();
        if(getOneObjectAtOffset(imagewidth/2+step,imageheight/-2,player.class)!=null||
        getOneObjectAtOffset(imagewidth/2+step,imageheight/2-1,player.class)!=null)canmoveright=false;
        return canmoveright;
        
    }
    
    //////////
            
            
          
         
        
        
    public class Part extends Actor
    {
        private int partnum;
        
        public Part (int id)
        {
            partnum= id;
            setImage(((mouse)Tank.this.getWorld().getObjects(mouse.class).get(0)).images[partnum+7]);
        }
    }
}
