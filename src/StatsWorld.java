import com.sun.org.apache.xerces.internal.impl.XMLNSDocumentScannerImpl;
import mayflower.World;
import mayflower.event.EventListener;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StatsWorld extends World implements EventListener
{
    public static Stats playerStats;
    private String name;

    public StatsWorld()
    {

    }

    public StatsWorld(Stats s, String name)
    {
        playerStats = s;
        this.name = name;
    }

    public void onEvent(String s)
    {

    }

    public void act()
    {

    }

    public void saveStats() throws IOException
    {
        Scanner s = new Scanner("stats.txt");
        FileWriter a = new FileWriter("stats.txt");

        String line = s.nextLine();
        String[] arr = line.split(" ");
        int count = 0;
        boolean notFound = false;
        while(!arr[1].equals(name) || notFound == true)
        {
            count++;
            line = s.nextLine();
            if(line.equals(""))
                notFound = true;
            arr = line.split(" ");
        }
        if(notFound) count = 0;
        for(int i = 0; i < count; i++)
        {

        }

    }

    public void setStats(Stats s)
    {
        playerStats = s;
    }
}
