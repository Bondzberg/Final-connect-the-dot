import mayflower.Actor;

public class square extends Actor
{
    private int value;
    private int color;
    private GameWorld world;


    public square(GameWorld gameWorld)
    {
        value = 0;
        color = 0;
        world = gameWorld;

    }

    @Override
    public void act() {

    }
    public void incrementVlaue()
    {
        value++;
        if(value==4)
        {
            setImage(world.getpC().getImageS());
            world.setScored(true);
            world.getpC().setScore(world.getpC().getScore()+1);
        }
    }

    public int getValue() {
        return value;
    }
}
