import mayflower.Color;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Profile
{
    private String name;
    private int wins;
    private int losses;
    private int ties;
    private Color color;

    public Profile()
    {
        name = null;
        wins = 0;
        losses = 0;
        ties = 0;
        color = null;
    }

    public Profile(String name)
    {
        boolean found = false;
        try
        {
            Scanner s = new Scanner(new File("stats.txt"));
            while(s.hasNextLine() && found == false)
            {

            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        this.name = name;

    }

}
