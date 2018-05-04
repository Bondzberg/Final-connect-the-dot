

import mayflower.net.Client;

public class ctdClient extends Client
{

    private ClientWorld world;


    public ctdClient()
    {
        //this.world = world;
        this.connect("localhost",1234);
    }

    @Override
    public void process(String s) {
        String[] strings =s.split(" ");
        if(strings[0].equals("player"))
            world.setNum(Integer.valueOf(strings[1]));
        else if(strings[0].equals("world"))
        {
            int x = Integer.valueOf(Integer.valueOf(strings[1]));
            int y = Integer.valueOf(Integer.valueOf(strings[2]));
            ClientWorld world = new ClientWorld(x,y,false,this);
            this.world = world;

        }
        else if(strings[0].equals("dis"))
        {
            world.win();
        }
        else
        {
            int value = Integer.valueOf(strings[strings.length-1]);
            String ss = strings[0]+ " " + strings[1] + " "+strings[2];
            world.proccess(ss,value);
        }

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
