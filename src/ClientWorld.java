

import mayflower.Mayflower;
import mayflower.net.Client;


public class ClientWorld extends GameWorld
{
    private Client client;
    private int num;

    public ClientWorld(int x, int y, boolean ai,ctdClient client) {
        super(x, y, ai);
        this.client = client;
        Mayflower.setWorld(this);
    }

    @Override
    public void onEvent(String s)
    {
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
