import mayflower.Color;
import mayflower.Mayflower;
import mayflower.MayflowerImage;
import mayflower.World;
import mayflower.event.EventListener;
import mayflower.ui.Button;

import java.util.Map;

public class ProfileWorld extends StatsWorld implements EventListener
{
    private Button back;
    private MenuWorld world;

    public ProfileWorld(MenuWorld world)
    {
        this.world = world;
        setBackground("imgs/Background.png");
        back = new Button("imgs/Button.png", "back");
        back.addEventListener(this);
        back.getImage().scale(0.8);
        addObject(back, 300, 400);
        showText("Back", 360, 455);
        showText("Wins: " + world.getStats().getWins(), 100, 100);
        showText("Losses: " + world.getStats().getLosses(), 100, 175);
        showText("Ties: " + world.getStats().getTies(), 100, 250);
        showText("Color: " + world.getStats().colorToString(), 100, 325);
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
    /*java.awt.Color colour = JColorChooser.showDialog(new JPanel(),"something", java.awt.Color.BLUE);
        color = new Color(colour.getBlue(),colour.getRed(),colour.getGreen());*/
}
