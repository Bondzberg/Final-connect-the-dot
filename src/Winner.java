import mayflower.Actor;

public class Winner extends Actor
{
    private int speedX;
    private int speedY;

    public Winner()
    {
        speedX = (int)(1 + Math.random()*4);
        speedY = (int)(1 + Math.random()*4);
        setImage("imgs/winner.png");
        //BOUNDS???
    }
    public void act()
    {
        setLocation(getCenterX() + speedX, getCenterY() + speedY );
    }
}
