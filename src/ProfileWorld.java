import mayflower.*;
import mayflower.Color;
import mayflower.event.EventListener;
import mayflower.ui.Button;
import org.w3c.dom.css.Rect;

import java.awt.*;
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
        showText("Wins: " + StatsWorld.playerStats.getWins(), 100, 100);
        showText("Losses: " + StatsWorld.playerStats.getLosses(), 100, 175);
        showText("Ties: " + StatsWorld.playerStats.getTies(), 100, 250);
        showText("Color: ", 100, 325);
        MayflowerImage square = new MayflowerImage("imgs/squares.png");
        for(int r = 0;r<square.getWidth();r++)
        {

            for(int c =0;c<square.getHeight();c++)
            {

                square.setColorAt(r,c,StatsWorld.playerStats.getColor());
            }
        }
        Actor img = new Actor(){
            public void act(){}
        };
        addObject(img, 200, 200);
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
