

import mayflower.net.Client;


public class ClientWorld extends GameWorld
{
    private Client client;

    public ClientWorld(int x, int y, boolean ai) {
        super(x, y, ai);
        client = new ctdClient(this);
    }

    @Override
    public void onEvent(String s)
    {
        client.send(s);
    }
}
