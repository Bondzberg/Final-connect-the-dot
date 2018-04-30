
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Stats
{
    private int wins;
    private int losses;
    private int ties;
    private Color color;

    public Stats(int w, int l, int t, String c)
    {
        wins = w;
        losses = l;
        ties = t;
        if(c.equals("Yellow"))
        {
            color = Color.YELLOW;
        }
        else if(c.equals("Blue"))
        {
            color = Color.BLUE;
        }
    }

    public int getWins()
    {
        return wins;
    }

    public int getLosses()
    {
        return losses;
    }

    public int getTies()
    {
        return ties;
    }

    public Color getColor()
    {
        return color;
    }

    public String colorToString()
    {
        if(color.equals(Color.BLUE))
        {
            return "Blue";
        }
        if(color.equals(Color.YELLOW))
        {
            return "Yellow";
        }
        if(color.equals(Color.BLACK))
        {
            return "Black";
        }
        if(color.equals(Color.PINK))
        {
            return "Pink";
        }
        if(color.equals(Color.RED))
        {
            return "Red";
        }
        if(color.equals(Color.CYAN))
        {
            return "Cyan";
        }
        if(color.equals(Color.DARK_GRAY))
        {
            return "Dark Gray";
        }
        if(color.equals(Color.GRAY))
        {
            return "Gray";
        }
        if(color.equals(Color.GREEN))
        {
            return "Green";
        }
        if(color.equals(Color.LIGHT_GRAY))
        {
            return "Light Gray";
        }
        if(color.equals(Color.MAGENTA))
        {
            return "Magenta";
        }
        if(color.equals(Color.ORANGE))
        {
            return "Orange";
        }
        if(color.equals(Color.WHITE))
        {
            return "White";
        }
        return null;
    }
    public String toString()
    {
        return "Wins: " + getWins() + " Losses: " + getLosses() + " Ties: " + getTies() +  " Color: " + colorToString();
    }
}
