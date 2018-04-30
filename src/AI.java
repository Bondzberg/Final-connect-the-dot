import javafx.concurrent.Task;
import mayflower.Color;

import java.util.List;

public class AI extends player
{

    private GameWorld world;
    private Thread thread;
    public AI(Color color,int p,GameWorld world) {
        super(color,p);
        this.world = world;
        thread = new Thread1();
        thread.start();
    }

    public String getNextMove()
    {
        String min = "";
        int mins =5;
        for(Line line:world.getLines().values())
        {
            List<square> squares = world.getLts().get(line);
            for(square square:squares)
            {
                if(square.getValue()<mins)
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
                if(world.getpC().getNum()==getNum())
                    world.onEvent(getNextMove());
                try {
                    sleep(17);
                    run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }


    /*class Thread
    {
        private java.lang.Thread thread;
        public Thread()
        {
            Task task = new Task<Void>() {
                @Override
                protected Void run() throws Exception {
                    while (true) {
                        if(world.getpC().equals(this))
                            world.onEvent(getNextMove());
                        java.lang.Thread.sleep(17);
                    }

                }
            };
            thread = new java.lang.Thread(task);
            thread.start();
        }
    }*/
}

