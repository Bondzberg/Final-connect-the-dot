import mayflower.Actor;
import mayflower.Color;
import mayflower.World;
import mayflower.event.EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameWorld extends World implements EventListener
{
    private square[][] squares;
<<<<<<< HEAD
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
=======
    private HashMap<String,Line> lines;
    private HashMap<Line,List<square>> lts;
    private player p1;
    private player p2;
    private player pC;
    private boolean scored;

    public GameWorld(int x,int y)
    {
        lines = new HashMap<>();
        squares = new square[x-1][y-1];
        lts = new HashMap();
        p1 = new player(Color.MEGENTA,1);
        p2 = new player(Color.PINK,2);
        pC = p1;
        scored = false;
>>>>>>> cda4f9880a6e7ecd5f21f1b7e914241e2926b60d


        for(int c=0;c<squares.length;c++)
        {
            for(int r = 0;r<squares[0].length;r++)
            {
                squares[c][r] = new square(this);
                squares[c][r].setImage("imgs/empty.png");
<<<<<<< HEAD
                addObject(squares[c][r],c*50,r*50);
                //dts.get(Lines[c][r]).add(squares[c][r]);
               // dts.get(Lines[c+1][r]).add(squares[c][r]);
                //dts.get(Lines[c][r+1]).add(squares[c][r]);
                //dts.get(Lines[c+1][r+1]).add(squares[c][r]);

=======
                if(r==0)
                {
                    Line top = new Line("imgs/lines.png","t "+c+" "+r);
                    top.addEventListener(this);
                    lts.put(top,new ArrayList<>());
                    lines.put("t "+c+" "+r,top);
                    lts.get(top).add(squares[c][r]);
                    addObject(top,c*50,0);
                    Line bottom = new Line("imgs/lines.png","b "+c+" "+r);
                    lines.put("b "+c+" "+r,bottom);
                    lts.put(bottom,new ArrayList<>());
                    lts.get(bottom).add(squares[c][r]);
                    addObject(bottom,c*50,50);
                    bottom.addEventListener(this);
                }
                else
                {
                    lts.get(lines.get("b "+c+" "+(r-1))).add(squares[c][r]);
                    Line bottom = new Line("imgs/lines.png","b "+c+" "+r);
                    lines.put("b "+c+" "+r,bottom);
                    lts.put(bottom,new ArrayList<>());
                    lts.get(bottom).add(squares[c][r]);
                    addObject(bottom,c*50,r*50+50);
                    bottom.addEventListener(this);
                }
>>>>>>> cda4f9880a6e7ecd5f21f1b7e914241e2926b60d

                if(c==0)
                {
                    Line left = new Line("imgs/lines.png","l "+c+" "+r);
                    lines.put("l "+c+" "+r,left);
                    lts.put(left,new ArrayList<>());
                    lts.get(left).add(squares[c][r]);
                    addObject(left,-25,r*50+25);
                    left.setRotation(-90);
                    left.addEventListener(this);
                    Line right = new Line("imgs/lines.png","r "+c+" "+r);
                    lines.put("r "+c+" "+r,right);
                    lts.put(right,new ArrayList<>());
                    lts.get(right).add(squares[c][r]);
                    addObject(right,25,r*50+25);
                    right.setRotation(-90);
                    right.addEventListener(this);
                }
                else
                {
                    lts.get(lines.get("r "+(c-1)+" "+r)).add(squares[c][r]);
                    Line right = new Line("imgs/lines.png","r "+c+" "+r);
                    lines.put("r "+c+" "+r,right);
                    lts.put(right,new ArrayList<>());
                    lts.get(right).add(squares[c][r]);
                    addObject(right,c*50+25,r*50+25);
                    right.setRotation(-90);
                    right.addEventListener(this);
                }

                addObject(squares[c][r],c*50,r*50);
            }
        }
    }
    @Override
    public void onEvent(String s)
    {
<<<<<<< HEAD

        String[] cord = s.split(" ");
        int x = Integer.valueOf(cord[0]);
        int y = Integer.valueOf(cord[1]);
        if(selected != null)
=======
        List<square> i = lts.get(lines.get(s));
        for(square l:i)
>>>>>>> cda4f9880a6e7ecd5f21f1b7e914241e2926b60d
        {
            special(selected, Lines[x][y]);
        }
<<<<<<< HEAD
        else
            selected = Lines[x][y];
=======
        lines.get(s).clearEventListeners();
        Actor img = new Actor() {
            @Override
            public void act() {

            }
        };
        img.setImage(pC.getImageL());
        addObject(img,lines.get(s).getX(),lines.get(s).getY());
        img.setRotation(lines.get(s).getRotation());
        //lines.get(s).setDefaultImage("imgs/line "+pC.getNum());
        if(pC.equals(p1))
            pC=p2;
        else
            pC=p1;
>>>>>>> cda4f9880a6e7ecd5f21f1b7e914241e2926b60d

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

    public player getpC() {
        return pC;
    }
}
