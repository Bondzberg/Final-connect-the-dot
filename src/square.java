import mayflower.Actor;

public class square extends Actor
{
    private int value;
    private int color;

    public square()
    {
        value = 0;
        color = 0;
    }

    @Override
    public void act() {
        if(value==4)
        {
            setImage("imgs/Button.png");
        }
    }
    public void incrementVlaue()
    {
        value++;
    }
}
