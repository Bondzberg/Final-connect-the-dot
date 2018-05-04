import mayflower.*;
import mayflower.Color;
import mayflower.event.EventListener;
import mayflower.ui.Button;
import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ProfileWorld extends StatsWorld implements EventListener
{
    private Button back;
    private Button colorButton;
    private MenuWorld world;

    private Actor img;

    public ProfileWorld(MenuWorld world)
    {
        this.world = world;
        setBackground("imgs/Background.png");
        back = new Button("imgs/Button.png", "back");
        back.addEventListener(this);
        back.getImage().scale(0.8);
        colorButton = new Button("imgs/Button.png", "color");
        colorButton.addEventListener(this);
        colorButton.getImage().scale(.5);
        addObject(back, 300, 400);
        addObject(colorButton, 260, 290);
        showText("Back", 360, 455);
        showText("Wins: " + StatsWorld.playerStats.getWins(), 100, 100);
        showText("Losses: " + StatsWorld.playerStats.getLosses(), 100, 175);
        showText("Ties: " + StatsWorld.playerStats.getTies(), 100, 250);
        showText("Color: ", 100, 325);
        showText("Change Color", 15, 275, 322);
        MayflowerImage square = new MayflowerImage("imgs/squares.png");
        for(int r = 0;r<square.getWidth();r++)
        {

            for(int c =0;c<square.getHeight();c++)
            {

                square.setColorAt(r,c,StatsWorld.playerStats.getColor());
            }
        }
        img = new Actor(){
            public void act(){}
        };
        img.setImage(square);
        addObject(img, 200, 290);
    }

    public void onEvent(String s)
    {
        if(s.equals("back"))
        {
            Mayflower.setWorld(world);
        }
        else if(s.equals("color"))
        {
            java.awt.Color colour = JColorChooser.showDialog(new JPanel(),"something", java.awt.Color.BLUE);
            StatsWorld.playerStats.setColor(new Color(colour.getRed(),colour.getGreen(),colour.getBlue()));
            updateColor();
        }
    }

    public void act()
    {

    }

    public void updateColor()
    {
        MayflowerImage square = new MayflowerImage("imgs/squares.png");
        for(int r = 0;r<square.getWidth();r++)
        {

            for(int c =0;c<square.getHeight();c++)
            {
                square.setColorAt(r,c,StatsWorld.playerStats.getColor());
            }
        }
        img.setImage(square);
    }

}
