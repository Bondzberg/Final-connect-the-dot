/**
 * @(#)Animation.java
 *
 *  Lab 5 Starter Code
 *
 *
 * @author Mr May
 * @version 1.00 2016/7/21
 */
import mayflower.*;

public class Animation 
{
    private MayflowerImage[] frames;
    private int currentFrame;
    private int frameRate;
    
    public Animation(int rate, String[] filenames) 
    {
        frames = new MayflowerImage[filenames.length];
        
        for(int i=0; i < filenames.length; i++)
        {
            int n = i + 1;
            frames[i] = new MayflowerImage(filenames[i]);
        }
        
        currentFrame = 0;
        frameRate = rate;
    }
    
    public int getFrameRate()
    {
        return frameRate;
    }
    
    public MayflowerImage getNextFrame()
    {
        currentFrame = currentFrame % frames.length;
        MayflowerImage ret = frames[currentFrame];
        currentFrame = currentFrame + 1;
        return ret;
    }
    public void scale(double s)
    {
        for(MayflowerImage p : frames)
        {
            p.scale(s);
        }
    
    }
    
}