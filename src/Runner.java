import mayflower.Color;
import mayflower.Mayflower;
import mayflower.Timer;

import java.io.*;
import java.util.*;

public class Runner extends Mayflower
{
    public static ArrayList<Stats> s;
    public static Stats playerStats;
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
        //showBounds(true);
        ArrayList<Stats> stats = new ArrayList<Stats>();
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
                    Stats stat = new Stats(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), c);
                    stats.add(stat);
                }
            }
            s.close();
            name = Mayflower.ask("What is your profile name?");
            for(int i = 0; i < stats.size(); i++)
            {
                if(stats.get(i).getName().equals(name))
                {
                    playerStats = stats.get(i);
                    i = stats.size();
                }
            }
            if(playerStats == null)
            {
                playerStats = new Stats("guest", 0, 0, 0, new Color(255, 0,0));
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        s = stats;
        //Mayflower.setWorld(new GameWorld(5,5,false));

        Mayflower.setWorld(new MenuWorld(playerStats));
    }

    public void main()
    {

    }

    public static void saveStats() throws IOException
    {
        Scanner s = new Scanner("stats.txt");
        FileWriter fw = new FileWriter("stats.txt", false);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter a = new PrintWriter(bw, true);
        for(int i = 0; i < Runner.s.size(); i++)
        {
            a.println(Runner.s.get(i).toFileString());
        }
        a.close();
    }
}
