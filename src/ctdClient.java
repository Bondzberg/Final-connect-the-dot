

import mayflower.net.Client;

public class ctdClient extends Client
{

    private ClientWorld world;

    public ctdClient(ClientWorld world)
    {
        this.world = world;
    }

    @Override
    public void process(String s) {
        world.proccess(s);
    }

    @Override
    public void onDisconnect(String s)
    {

    }

    @Override
    public void onConnect()
    {

    }
}
