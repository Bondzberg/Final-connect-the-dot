import mayflower.Color;
import mayflower.Mayflower;
import mayflower.MayflowerImage;
import mayflower.World;
import mayflower.event.EventListener;
import mayflower.ui.Button;

import javax.swing.*;
import java.util.Map;

public class MenuWorld extends World implements EventListener
{
    private Button play, profile,multiplayer;
    private player p1,p2;

    public MenuWorld(Stats s)
    {
        play = new Button("imgs/Button.png", "play");
        play.addEventListener(this);
        play.getImage().scale(0.8);
        addObject(play, 300, 300);
        showText("Play", 365, 355);
        profile = new Button("imgs/Button.png", "profile");
        profile.addEventListener(this);
        profile.getImage().scale(0.8);
        addObject(profile, 300, 400);
        play = new Button("imgs/Button.png", "play");
        multiplayer = new Button("imgs/Button.png", "multi");
        multiplayer.addEventListener(this);
        multiplayer.getImage().scale(0.8);
        addObject(multiplayer, 300, 500);
        showText("multiplayer",325,500);
        showText("Profile", 345, 455);
        showText("Connect The Dots!", 75, 70, 100, Color.RED);
    }

    public void onEvent(String s)
    {
        if(s.equals("play"))
        {
            boolean select = true;
            boolean Ai = false;
            while(select)
            {
                String ai = Mayflower.ask("do you want AI? y or n");
                if(ai.equals("y")||ai.equals("n"))
                {
                    select = false;
                }
                if(ai.equals("y"))
                {
                    Ai = true;
                }
            }
            java.awt.Color one = JColorChooser.showDialog(new JPanel(),"something", java.awt.Color.BLUE);
            Color onem = new Color(one.getRed(),one.getGreen(),one.getBlue());
            java.awt.Color two = JColorChooser.showDialog(new JPanel(),"something", java.awt.Color.BLUE);
            Color twom = new Color(two.getRed(),two.getGreen(),two.getBlue());
            Mayflower.setWorld(new GameWorld(5,5,Ai,onem,twom));
        }
        else if(s.equals("profile"))
        {
            Mayflower.setWorld(new ProfileWorld(this));
        }
        else if(s.equals("multi"))
        {
            new ctdClient();
        }
    }
    public void act()
    {

    }
}
