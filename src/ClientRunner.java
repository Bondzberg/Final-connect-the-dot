import mayflower.Keyboard;
import mayflower.Mayflower;
import mayflower.net.Server;

import javax.swing.*;
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

        /*try{
            new ctdClient();
        }catch(Exception e){
            new ctdServer(1234);
            new ctdClient();
        }*/

    }

    public static void main(String[] args)
    {
        new ClientRunner();
    }
}
