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
        speed = 2+Math.random()*5;
        //speed = 9;
        direction = (int) (-179 + Math.random()*360);
        //direction = 55;
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
        //System.out.println("y: " + getCenterY());
        //System.out.println("x: " + getCenterX());
        //Actor[] touching = getIntersectingObjects(AnimatedActor);  //gets an array of touching Actors
        // ^^^ might be used later to incorporate coin-collision
        if(this.getX() <= -20)
        {
            if(direction <= 200)
            {
                direction = direction - 2*(90-(180 - direction));
                setRotation(direction);
            }
            else
            {
                direction = direction -(2*(90-(180-direction)));
                setRotation(direction);
            }
        }
        else if(this.getX() > 700)
        {

            if(direction < 0)
            {
                direction = direction - (2*(90 - Math.abs(direction)));
                setRotation(direction);
            }
            else
            {
                direction = direction + (2*(90 - Math.abs(direction)));
                setRotation(direction);
            }

        }
        else if(this.getY() <= -20 || (this.getY() >= 500))
        {
            direction = -direction;
            setRotation(direction);
        }

        move(speed);

        super.act();
    }
}