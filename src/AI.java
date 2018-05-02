import mayflower.Color;

import java.util.List;

public class AI extends player
{

    private GameWorld world;
    private Thread thread;
    private Boolean working;
    public AI(Color color,int p,GameWorld world) {
        super(color,p);
        this.world = world;
        thread = new Thread1();
        thread.start();
        working = false;
    }

    public String getNextMove()
    {
        String min = "";
        int mins =-1;
        for(Line line:world.getLines().values())
        {
            List<square> squares = world.getLts().get(line);
            for(square square:squares)
            {
                if(square.getValue()>mins)
                {
                    min = line.getAct();
                }
                if(square.getValue()==3)
                {
                    return line.getAct();
                }
            }

        }
        return min;
    }


        public class Thread1 extends Thread {
            public void run() {
                while (world.isRunning()) {
                    if (world.getpC().getNum() == getNum() && !working) {
                        working = true;
                        world.onEvent(getNextMove());
                        working = false;
                    }
                    try {
                        sleep(17);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
}

