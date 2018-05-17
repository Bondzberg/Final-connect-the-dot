import mayflower.*;
import mayflower.Color;
import mayflower.event.EventListener;
import mayflower.ui.Button;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Map;

public class ProfileWorld extends World implements EventListener
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
        showText("Wins: " + Runner.playerStats.getWins(), 100, 100);
        showText("Losses: " + Runner.playerStats.getLosses(), 100, 175);
        showText("Ties: " + Runner.playerStats.getTies(), 100, 250);
        showText("Color: ", 100, 325);
        showText("Change Color", 15, 275, 322);
        MayflowerImage square = new MayflowerImage("imgs/squares.png");
        for(int r = 0;r<square.getWidth();r++)
        {

            for(int c =0;c<square.getHeight();c++)
            {

                square.setColorAt(r,c,Runner.playerStats.getColor());
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
            try
            {
                Runner.saveStats();
            }
            catch(IOException e)
            {

            }
            Mayflower.setWorld(world);
        }
        else if(s.equals("color"))
        {
            java.awt.Color colour = JColorChooser.showDialog(new JPanel(),"something", java.awt.Color.BLUE);
            if(colour != null)
            {
                Runner.playerStats.setColor(new Color(colour.getRed(),colour.getGreen(),colour.getBlue()));
            }
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
                square.setColorAt(r,c,Runner.playerStats.getColor());
            }
        }
        img.setImage(square);
    }

}
