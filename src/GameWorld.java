import mayflower.World;
import mayflower.event.EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class GameWorld extends World implements EventListener
{
    private int[][] squares;
    private Dot[][] Dots;
    private HashMap<Dot,List<Integer>> dts;
    public GameWorld(int x,int y)
    {
        Dots = new Dot[x][y];
        squares = new int[x-1][y-1];
        dts = new HashMap();
        for(int c=0;c<y;c++)
        {
            for(int r = 0;r<x;r++)
            {
                Dots[c][r]=new Dot("placeholder",x+" "+y);
                Dots[c][r].addEventListener(this);
                addObject(Dots[c][r],c*10,r*10);

            }
        }

        for(int c=0;c<squares.length;c++)
        {
            for(int r = 0;r<squares[0].length;r++)
            {

                squares[c][r] = 0;
                dts.get(Dots[c][r]).add(squares[c][r]);
                dts.get(Dots[c+1][r]).add(squares[c][r]);
                dts.get(Dots[c][r+1]).add(squares[c][r]);
                dts.get(Dots[c+1][r+1]).add(squares[c][r]);

            }
        }


    }
    @Override
    public void onEvent(String s)
    {
        String[] cord = s.split(" ");
        int x = Integer.valueOf(cord[0]);
        int y = Integer.valueOf(cord[1]);
        List<Integer> i = dts.get(Dots[x][y]);
        for(int l:i)
        {
            l++;
        }
    }

    @Override
    public void act() {

    }
}
