
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

    public String toString()
    {
        return "Wins: " + getWins() + " Losses: " + getLosses() + " Ties: " + getTies() +  " Color: " + getColor().toString();
    }
}
