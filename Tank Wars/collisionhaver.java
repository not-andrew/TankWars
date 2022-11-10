import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class collisionhaver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class collisionhaver extends Actor
{
    /**
     * Act - do whatever the collisionhaver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        // Add your action code here.
    }  
    public void collision(int step)
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
        if(getOneObjectAtOffset(imagewidth/-2,imageheight/2,yzobstacles.class)!=null||
        getOneObjectAtOffset(imagewidth/2,imageheight/2,yzobstacles.class)!=null)isonground=true;
        
        
        return isonground;
    }
    public boolean didbumphead(int step)
    { boolean bumpedhead=false;
        int imagewidth=getImage().getWidth();
        int imageheight=getImage().getHeight();
        if(getOneObjectAtOffset(imagewidth/-2,imageheight/-2,yzobstacles.class)!=null||
         getOneObjectAtOffset(imagewidth/2,imageheight/-2,yzobstacles.class)!=null)bumpedhead=true;
        return bumpedhead;
    }
    public boolean canmoveleft(int step)
    {boolean canmoveleft=true;
        int imagewidth=getImage().getWidth();
        int imageheight=getImage().getHeight();
        //-step ca sa nu declanseze isonsolidground (buffer)
        if(getOneObjectAtOffset(imagewidth/-2-step,imageheight/-2,yzobstacles.class)!=null||
        getOneObjectAtOffset(imagewidth/-2-step,imageheight/2-1,yzobstacles.class)!=null)canmoveleft=false;
        return canmoveleft;
        
    }
    public boolean canmoveright(int step)
    {boolean canmoveright=true;
        int imagewidth=getImage().getWidth();
        int imageheight=getImage().getHeight();
        if(getOneObjectAtOffset(imagewidth/2+step,imageheight/-2,yzobstacles.class)!=null||
        getOneObjectAtOffset(imagewidth/2+step,imageheight/2-1,yzobstacles.class)!=null)canmoveright=false;
        return canmoveright;
        
    }
}
