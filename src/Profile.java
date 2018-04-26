import mayflower.Color;

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
        this.name = name;

    }

}
