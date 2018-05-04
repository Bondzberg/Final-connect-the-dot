import mayflower.Actor;

/*
Nice to have: Mousing over the coins = play a noise and removes from screen
 */

public class Winner extends AnimatedActor
{
    // instance variables - replace the example below with your own
    private Animation spin;

    private double speed;
    private int direction;

    /**
     * Constructor for objects of class Coin
     */
    public Winner()
    {
        setImage("imgs/empty.png");
        speed = 1+Math.random()*9;
        direction = (int) (-180 + Math.random()*360);
        setRotation(direction);

        spin = new Animation(5, new String[]{
                "imgs/coin/Spin (1).png",
                "imgs/coin/Spin (2).png",
                "imgs/coin/Spin (3).png",
                "imgs/coin/Spin (4).png",
                "imgs/coin/Spin (5).png",
                "imgs/coin/Spin (6).png",
        });

        setAnimation(spin);
        spin.scale (.5);
    }

    public void act()
    {
        //Actor[] touching = getIntersectingObjects(AnimatedActor);  //gets an array of touching Actors
        // ^^^ might be used later to incorporate coin-collision

        if(this.getCenterX() < 100)
        {
            if(direction >= 0)
            {
                direction = direction - 2*(90-(180 - direction));
                setRotation(direction);
            }
            else
            {
                direction = direction + 2*(180 - Math.abs(direction));
                setRotation(direction);
            }

        }
        else if(this.getCenterX() > 700)
        {

            if(direction >= 0)
            {
                direction = direction + 2*(90 - direction);
                setRotation(direction);
            }
            else
            {
                direction = direction - 2*(90 - Math.abs(direction));
                setRotation(direction);
            }

        }
        else if(this.getCenterY() < 100)
        {
            direction = -direction;
            setRotation(direction);
        }
        else if(this.getCenterY() > 500)
        {
            direction = -direction;
            setRotation(direction);
        }

        move(speed);

        super.act();
    }
}