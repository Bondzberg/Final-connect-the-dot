/**
 * @(#)AnimatedActor.java
 *
 *  Lab 5 Starter Code
 *
 *
 * @author Mr May
 * @version 1.00 2016/7/21
 */
import mayflower.*;

public class AnimatedActor extends Actor
{
    private Animation animation;
    private Timer animationTimer;

    public AnimatedActor() 
    {
        animation = null;
        animationTimer = new Timer((int)animation.getFrameRate());
    }
    
    public void setAnimation(Animation a)
    {
        animation = a;
        animationTimer.reset();
    }
    
    public void act()
    {
        if(animation != null)
        {
            if(animationTimer.isDone())
            {   
                animationTimer.reset();         
                this.setImage(animation.getNextFrame());
            }
        }
    }
}