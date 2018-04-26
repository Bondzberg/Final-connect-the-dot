import mayflower.World;
import mayflower.event.EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameWorld extends World implements EventListener
{
    private square[][] squares;
    private Line[][] Lines;
    private HashMap<Line,List<square>> dts;
    private Line selected;

    public GameWorld(int x,int y)
    {
        Lines = new Line[x*2-1][y];
        squares = new square[x-1][y-1];
        dts = new HashMap();
        selected = null;

        for(int c=0;c<2*y-1;c++)
        {
            int z = x-1;
            if(c%2==1)
            {
                z++;
            }
            for(int r = 0;r<z;r++)
            {
                Lines[c][r] = new Line("imgs/line.png",c+" "+r);
                Lines[c][r].addEventListener(this);
                addObject(Lines[c][r],c*50+50,r*50+50);
                dts.put(Lines[c][r],new ArrayList<>());
                Lines[c][r].addEventListener(this);
                if(c%2==1) {
                    Lines[c][r].setRotation(90);
                    Lines[c][r].move(50);
                }
            }
        }


        for(int c=0;c<squares.length;c++)
        {
            for(int r = 0;r<squares[0].length;r++)
            {
                squares[c][r] = new square();
                squares[c][r].setImage("imgs/empty.png");
                addObject(squares[c][r],c*50,r*50);
                //dts.get(Lines[c][r]).add(squares[c][r]);
               // dts.get(Lines[c+1][r]).add(squares[c][r]);
                //dts.get(Lines[c][r+1]).add(squares[c][r]);
                //dts.get(Lines[c+1][r+1]).add(squares[c][r]);


            }
        }


    }
    @Override
    public void onEvent(String s)
    {

        String[] cord = s.split(" ");
        int x = Integer.valueOf(cord[0]);
        int y = Integer.valueOf(cord[1]);
        if(selected != null)
        {
            special(selected, Lines[x][y]);
        }
        else
            selected = Lines[x][y];

    }

    @Override
    public void act()
    {


    }

    public void special(Line dot1,Line dot2)
    {
        List<square> i = dts.get(dot1);
        List<square> t = dts.get(dot2);
        i.retainAll(t);
        while(i.size()>1)
        {
            square square = i.get(0);
            square.incrementVlaue();
            dts.get(dot1).remove(square);
            dts.get(dot2).remove(square);
            i.remove(0);
        }

        if(i.size()==0)
            selected =null;


    }
}
