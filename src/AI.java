import mayflower.Color;

import java.util.ArrayList;
import java.util.List;

public class AI extends player
{

    private GameWorld world;
    public AI(Color color,int p,GameWorld world) {
        super(color,p);
        this.world = world;
    }

    public String getNextMove()
    {
        List<String> min = new ArrayList<>();
        int mina = 50;
        for(Line line:world.getLines().values())
        {
            int at =0;
            List<square> squares = world.getLts().get(line);
            for(square square:squares)
            {
                at+=square.getValue();
                if(square.getValue()==3)
                {
                    return line.getAct();
                }
            }
            if(at<mina)
            {
                mina = at;
                min = new ArrayList<>();
                min.add(line.getAct());
            }
            else if(at==mina)
            {
                min.add(line.getAct());
            }

        }
        String ret = min.get((int)(Math.random()*min.size()));
        return ret ;
    }
}

