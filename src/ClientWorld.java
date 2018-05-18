

import mayflower.Color;
import mayflower.Mayflower;
import mayflower.net.Client;


public class ClientWorld extends GameWorld
{
    private ctdClient client;
    private int num;

    public ClientWorld(int x, int y, boolean ai,ctdClient client,Color one,Color two) {
        super(x, y, ai, one,two);
        this.client = client;
        Mayflower.setWorld(this);
    }

    @Override
    public void act() {
        super.act();
        Color color = client.getColor();
        if(client.getWorld().getNum()==2)
            color = client.getColor2();
        showText("you are Player "+client.getWorld().getNum(),500,400,color);
    }

    public void onEvent(String s)
    {
        if(s.equals("back"))
        {
            Mayflower.setWorld(new MenuWorld(Runner.playerStats));
            client.disconnect();
            Mayflower.setWorld(new MenuWorld(Runner.playerStats));
            return;
        }
        client.send(s);
    }

    public void setNum(int i)
    {
        num = i;
    }

    public int getNum() {
        return num;
    }
    public void win()
    {

    }
}
