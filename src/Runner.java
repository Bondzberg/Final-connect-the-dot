import mayflower.Mayflower;
import mayflower.World;
import mayflower.event.EventListener;
import mayflower.ui.Button;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Runner extends Mayflower
{
    public Runner()
    {
        super("Project ultra secret", 800, 600);
    }
    public static void main(String[] args){
        new Runner();
    }
    public void init()
    {

        Mayflower.setWorld(new GameWorld(3,3));


        Map<String, Stats> stats = new HashMap<String, Stats>();
        try
        {
            Scanner s = new Scanner( new File("stats.txt"));
            while(s.hasNextLine())
            {
                String sentence = s.nextLine();
                String[] arr = sentence.split(" ");
                Stats stat = new Stats(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), arr[4]);
                stats.put(arr[0], stat);
            }
            s.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        System.out.println(stats.get("Player2"));
        Mayflower.setWorld(new GameWorld(5,5));

    }
    public void main()
    {

    }
}
