import mayflower.World;
import mayflower.event.EventListener;

public class StatsWorld extends World implements EventListener
{
    public static Stats playerStats;

    public StatsWorld()
    {

    }

    public StatsWorld(Stats s)
    {
        playerStats = s;
    }

    public void onEvent(String s)
    {

    }

    public void act()
    {

    }

    public void saveStats()
    {

    }

    public void setStats(Stats s)
    {
        playerStats = s;
    }
}
