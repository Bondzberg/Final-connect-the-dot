import mayflower.Color;
import mayflower.Mayflower;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Runner extends Mayflower
{
    public StatsWorld s;
    private Stats playerStats;
    private String name;

    public Runner()
    {
        super("Project ultra secret", 800, 600);
    }
    public static void main(String[] args){
        new Runner();
    }
    public void init()
    {
        Map<String, Stats> stats = new HashMap<String, Stats>();
        try
        {
            Scanner s = new Scanner( new File("stats.txt"));
            while(s.hasNextLine())
            {
                String sentence = s.nextLine();
                String[] arr = sentence.split(" ");
                if(!arr[4].equals("null"))
                {
                    Color c = new Color(Integer.parseInt(arr[4]), Integer.parseInt(arr[5]), Integer.parseInt(arr[6]));
                    Stats stat = new Stats(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), c);
                    stats.put(arr[0], stat);
                }
            }
            s.close();
            name = Mayflower.ask("What is your profile name?");
            if(stats.containsKey(name))
            {
                playerStats = stats.get(name);
            }
            else
            {
                playerStats = new Stats(0, 0, 0, new Color(255, 0,0));
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        s = new StatsWorld(playerStats, name);
        //Mayflower.setWorld(new GameWorld(5,5,false));

        Mayflower.setWorld(new MenuWorld(StatsWorld.playerStats));
    }


    public void main()
    {

    }
}
