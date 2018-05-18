
import mayflower.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Stats
{
    private String name;
    private int wins;
    private int losses;
    private int ties;
    private Color color;

    public Stats(String name, int w, int l, int t, Color c)
    {
        this.name = name;
        wins = w;
        losses = l;
        ties = t;
        color = c;
    }
    public Stats(int w, int l, int t, Color c)
    {
        //this.name = name;
        wins = w;
        losses = l;
        ties = t;
        color = c;
    }

    public String getName() {return name;}

    public int getWins()
    {
        return wins;
    }

    public void incWins() {wins++;}

    public int getLosses()
    {
        return losses;
    }

    public void incLosses(){losses++;}

    public int getTies()
    {
        return ties;
    }

    public void incTies(){ties++;}

    public Color getColor()
    {
        return color;
    }

    public java.awt.Color getJavaColor()
    {
        return new java.awt.Color(color.getRed(),color.getGreen(),color.getBlue());
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String colorToString()
    {
        if(color == null)
        {
            return "None";
        }
        else if(color.equals(Color.BLUE))
        {
            return "Blue";
        }
        else if(color.equals(Color.YELLOW))
        {
            return "Yellow";
        }
        else if(color.equals(Color.BLACK))
        {
            return "Black";
        }
        else if(color.equals(Color.PINK))
        {
            return "Pink";
        }
        else if(color.equals(Color.RED))
        {
            return "Red";
        }
        else if(color.equals(Color.CYAN))
        {
            return "Cyan";
        }
        else if(color.equals(Color.DARK_GRAY))
        {
            return "Dark Gray";
        }
        else if(color.equals(Color.GRAY))
        {
            return "Gray";
        }
        else if(color.equals(Color.GREEN))
        {
            return "Green";
        }
        else if(color.equals(Color.LIGHT_GRAY))
        {
            return "Light Gray";
        }
        else if(color.equals(Color.ORANGE))
        {
            return "Orange";
        }
        else if(color.equals(Color.WHITE))
        {
            return "White";
        }
        return "Custom";
    }
    public String toString()
    {
        return "Wins: " + getWins() + " Losses: " + getLosses() + " Ties: " + getTies() +  " Color: " + colorToString();
    }
    public String toFileString()
    {
        return getName() + " " + getWins() + " " + getLosses() + " " + getTies() +  " " + color.getRed() + " " + color.getGreen() + " " + color.getBlue();
    }
}
