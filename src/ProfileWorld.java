import mayflower.Color;
import mayflower.Mayflower;
import mayflower.MayflowerImage;
import mayflower.World;
import mayflower.event.EventListener;
import mayflower.ui.Button;

import java.util.Map;

public class ProfileWorld extends World implements EventListener
{
    private Button back;
    private MenuWorld world;

    public ProfileWorld(MenuWorld world, Stats s)
    {
        this.world = world;
        setBackground("imgs/Background.png");
        back = new Button("imgs/Button.png", "back");
        back.addEventListener(this);
        back.getImage().scale(0.8);
        addObject(back, 300, 400);
        showText("Wins: " + s.getWins(), 100, 100);
        showText("Losses: " + s.getLosses(), 100, 175);
        showText("Ties: " + s.getTies(), 100, 250);
        showText("Color: " + s.getColor(), 100, 325);
    }

    public void onEvent(String s)
    {
        if(s.equals("back"))
        {
            Mayflower.setWorld(world);
        }
    }

    public void act()
    {

    }
}
