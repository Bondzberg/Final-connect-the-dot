import mayflower.World;
import mayflower.event.EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameWorld extends World implements EventListener
{
    private square[][] squares;
    private Dot[][] Dots;
    private HashMap<Dot,List<square>> dts;
    public GameWorld(int x,int y)
    {
        Dots = new Dot[x][y];
        squares = new square[x-1][y-1];
        dts = new HashMap();
        for(int c=0;c<y;c++)
        {
            for(int r = 0;r<x;r++)
            {
                Dots[c][r]=new Dot("imgs/Dot.png",c+" "+r);
                Dots[c][r].addEventListener(this);
                addObject(Dots[c][r],c*50,r*50);
                dts.put(Dots[c][r],new ArrayList<>());
            }
        }

        for(int c=0;c<squares.length;c++)
        {
            for(int r = 0;r<squares[0].length;r++)
            {
                squares[c][r] = new square();
                squares[c][r].setImage("imgs/empty.png");
                addObject(squares[c][r],c*50,r*50);
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
        List<square> i = dts.get(Dots[x][y]);
        for(square l:i)
        {
            l.incrementVlaue();
        }
    }

    @Override
    public void act() {

    }


    /*
    Jonathan's 4-26 code:
    if(isGameOver())
    {
        if(game.getWinner().equals(me))
        {
            graphics.setBackground("img/win.jpg");
        }
        else
            graphics.setBackground("img/lose.jpg");
    }
     */
}
