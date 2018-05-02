import mayflower.World;
import mayflower.event.EventListener;

public class StatsWorld extends World implements EventListener
{
    private Stats playerStats;

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

    public Stats getStats()
    {
        return playerStats;
    }

    public void setPlayerStats(Stats s)
    {
        playerStats = s;
    }
}
