import mayflower.event.EventListener;

public abstract class GameWorld implements EventListener
{
    private int[][] squares;
    private Dot[][] Dots;
    public GameWorld()
    {
        Dots = new Dot[5][5];
        for(Dot[] dots1: Dots)
        {
            for(Dot dot:dots1)
            {

            }
        }
        
    }
    @Override
    public void onEvent(String s)
    {

    }
}
