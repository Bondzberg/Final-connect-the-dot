import mayflower.net.Server;

import java.io.File;
import java.util.*;

public class ctdServer extends Server
{
    private Queue<Integer> waiting;

    private File playerStats;
    private HashMap<Integer,Integer> ptp;

    public ctdServer(int port) {
        super(port);
        waiting = new LinkedList();
        ptp = new HashMap<>();
    }

    @Override
    public void process(int i, String s)
    {
        int two =ptp.get(i);
        send(two,s+" "+(i%2+1));
        send(i,s+" "+(i%2+1));
    }

    @Override
    public void onJoin(int i) {
        System.out.println(i);
        waiting.add(i);
        if(waiting.size()>1)
        {
            int one = waiting.remove();
            int two = waiting.remove();
            ptp.put(one,two);
            ptp.put(two,one);
            send(one,String.valueOf("world " +5+" "+5));
            send(two,String.valueOf("world " +5+" "+5));
            send(one,String.valueOf("player " +(one%2+1)));
            send(two,String.valueOf("player " +(two%2+1)));
        }
    }

    @Override
    public void onExit(int i)
    {
        int two = ptp.get(i);
        send(two,"dis");

    }
}
