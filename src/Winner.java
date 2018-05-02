import mayflower.Actor;

/*
Nice to have: Mousing over the coins = play a noise and removes from screen
 */

public class Winner extends AnimatedActor
{
    // instance variables - replace the example below with your own
    private Animation spin;

    private int speedX;
    private int speedY;

    /**
     * Constructor for objects of class Coin
     */
    public Winner()
    {
        speedX = (int)(1 + Math.random()*3);
        speedY = (int)(1 + Math.random()*3);

        spin = new Animation(60, new String[]{
                "imgs/coin/Spin (1).png",
                "imgs/coin/Spin (2).png",
                "imgs/coin/Spin (3).png",
                "imgs/coin/Spin (4).png",
                "imgs/coin/Spin (5).png",
                "imgs/coin/Spin (6).png",
        });

        this.setAnimation(spin);
        spin.scale (.5);
    }

    public void act()
    {
        //Actor[] touching = getIntersectingObjects(AnimatedActor);  //gets an array of touching Actors
        // ^^^ might be used later to incorporate coin-collision

        if(this.getX() < 0)
        {
            speedX = -speedX;
        }
        if(this.getX() > 800)
        {
            speedX = -speedX;
        }
        if(this.getY() < 0)
        {
            speedY = -speedY;
        }
        if(this.getY() > 600)
        {
            speedY = -speedY;
        }

        super.act();
    }
}