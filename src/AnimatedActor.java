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

    }
    
    public void setAnimation(Animation a)
    {
        animation = a;
        animationTimer = new Timer((int)(100000000/animation.getFrameRate()));
    }
    
    public void act()
    {
        if(animation != null)
        {
            if(animationTimer.isDone())
            {
                this.setImage(animation.getNextFrame());
                animationTimer.reset();
            }
        }
    }
}