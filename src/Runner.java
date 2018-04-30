<<<<<<< HEAD
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import mayflower.Mayflower;
=======
import mayflower.Mayflower;
import mayflower.World;
import mayflower.event.EventListener;
import mayflower.ui.Button;
>>>>>>> parent of abefd37... Merge branch 'master' of https://github.com/Bondzberg/Final-connect-the-dot

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
<<<<<<< HEAD
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
=======
        Mayflower.setWorld(new GameWorld(3,3));
>>>>>>> parent of abefd37... Merge branch 'master' of https://github.com/Bondzberg/Final-connect-the-dot
    }
    public void main()
    {

    }
}
