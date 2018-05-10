import mayflower.Keyboard;
import mayflower.Mayflower;

import java.util.HashMap;
import java.util.Map;

public class ClientRunner extends Mayflower
{
    public ClientRunner()
    {
        super("Client", 800, 600);
    }

    @Override
    public void init()
    {
        new ctdClient();
    }

    public static void main(String[] args)
    {
        new ClientRunner();
    }
}
