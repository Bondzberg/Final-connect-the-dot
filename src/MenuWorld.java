import mayflower.Color;
import mayflower.Mayflower;
import mayflower.MayflowerImage;
import mayflower.World;
import mayflower.event.EventListener;
import mayflower.ui.Button;

import java.util.Map;

public class MenuWorld extends StatsWorld implements EventListener
{
    private Button play, profile;
    private player p1,p2;

    public MenuWorld(Stats s)
    {
        super(s);
        play = new Button("imgs/Button.png", "play");
        play.addEventListener(this);
        play.getImage().scale(0.8);
        addObject(play, 300, 300);
        showText("Play", 365, 355);
        profile = new Button("imgs/Button.png", "profile");
        profile.addEventListener(this);
        profile.getImage().scale(0.8);
        addObject(profile, 300, 400);
        showText("Profile", 345, 455);
        showText("Connect The Dots!", 75, 70, 100, Color.RED);
    }

    public void onEvent(String s)
    {
        if(s.equals("play"))
        {
            Mayflower.setWorld(new GameWorld(5,5,true));
        }
        else if(s.equals("profile"))
        {
            Mayflower.setWorld(new ProfileWorld(this));
        }
    }
    public void act()
    {

    }
}
