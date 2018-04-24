import mayflower.Color;
import mayflower.MayflowerImage;
import mayflower.World;
import mayflower.event.EventListener;
import mayflower.ui.Button;

public class MenuWorld extends World implements EventListener
{
    private Button play;

    public MenuWorld()
    {
        play = new Button("imgs/Button.png", "play");
        play.addEventListener(this);
        play.getImage().scale(0.8);
        addObject(play, 300, 400);
        showText("Play", 365, 455);
        showText("Connect The Dots!", 75, 70, 100, Color.RED);
    }

    public void onEvent(String s)
    {
        if(s.equals("play"))
        {
            System.out.println("a");
        }
    }

    public void act()
    {

    }
}
