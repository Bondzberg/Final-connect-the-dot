import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import mayflower.Mayflower;

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
        //gey
        Mayflower.setWorld(new MenuWorld());
    }
    public void main()
    {

    }
}
