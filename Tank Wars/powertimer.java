import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class powertimer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class powertimer extends Actor
{
    /**
     * Act - do whatever the powertimer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        player pl = (player) getWorld().getObjects(player.class).get(0);
        int text=pl.powerdelay/56;
        
        GreenfootImage main = getWorld().getBackground();
        GreenfootImage missilepowerbg=new GreenfootImage("ui/missiletimertemp.png");
     GreenfootImage img = new GreenfootImage(" "+text+" ", 44, Color.BLACK,null);
     main.drawImage(missilepowerbg,930,674);   
     if (text>9)main.drawImage(img, 930, 680);
     if (text>0&&text<10)main.drawImage(img, 938, 680);
     //add turret shot timeout
     
     int text2=pl.timeout/76;
     //GreenfootImage main2 = getWorld().getBackground();
        GreenfootImage turretshotbg=new GreenfootImage("ui/turrettimer.png");
     GreenfootImage img2 = new GreenfootImage(" "+text2+" ", 44, Color.BLACK,null);
     main.drawImage(turretshotbg,860,674);
     
     if (text2>0&&text2<10)main.drawImage(img2, 870, 680);
     
     
     //add heal timer
     int text3=pl.healdelay/60;
     //GreenfootImage main3 = getWorld().getBackground();
        GreenfootImage healframe=new GreenfootImage("ui/selfrepairframe.png");
     GreenfootImage img3 = new GreenfootImage(" "+text3+" ", 44, Color.BLACK,null);
     main.drawImage(healframe,1000,674);
     if (text3>9)main.drawImage(img3, 1000, 680);
     if (text3>0&&text3<10)main.drawImage(img3, 1010, 680);
        // Add your action code here.
    }  
  /*  public powertimer(int type)
    {
        player pl = (player) getWorld().getObjects(player.class).get(0);
        int text=pl.powerdelay/60;
        
        GreenfootImage main = getWorld().getBackground();
     GreenfootImage img = new GreenfootImage(" "+text+" ", 18, Color.YELLOW, Color.BLACK);
        main.drawImage(img, (main.getWidth() - img.getWidth()) / 2, 150);   
        
        
    }*/
    
    
    
    
}
