import mayflower.Mayflower;
import mayflower.World;
import mayflower.event.EventListener;
import mayflower.ui.Button;

public class Runner extends Mayflower
{
    public Runner()
    {
        super("Project ultra secret", 800, 600);
    }
    public static void main(String[] args){
        new Runner();
    }
    public void init()
    {
        Mayflower.setWorld(new GameWorld(3,3));
    }
    public void main()
    {

    }
}
