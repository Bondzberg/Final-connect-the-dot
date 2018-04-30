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

    private HashMap<String,Line> lines;
    private HashMap<Line,List<square>> lts;
    private player p1;
    private player p2;
    private player pC;
    private boolean scored;

    public GameWorld(int x,int y,boolean ai)
    {
        lines = new HashMap<>();
        squares = new square[x][y];
        lts = new HashMap();
        p1 = new player(Color.BLUE,1);
        p2 = new player(Color.PINK,2);
        if(ai)
            p2 = new AI(Color.PINK,2,this);
        pC = p1;
        scored = false;
        showText("Current player: 1",200,20,p1.getColor());

        for(int c=0;c<squares.length;c++)
        {
            for(int r = 0;r<squares[0].length;r++)
            {
                squares[c][r] = new square(this);
                squares[c][r].setImage("imgs/empty.png");
                addObject(squares[c][r],c*50,r*50);
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
        System.out.println(s);
        List<square> i = lts.get(lines.get(s));
        for(square l:i)
            l.incrementVlaue();
        lines.get(s).clearEventListeners();

        Actor img = new Actor() {
            @Override
            public void act() {

            }
        };
        img.setImage(pC.getImageL());
        addObject(img,lines.get(s).getX(),lines.get(s).getY());
        img.setRotation(lines.get(s).getRotation());

        if(!scored) {
            if (pC.equals(p1)) {
                pC = p2;
                getTexts().clear();
                showText("Current player: 2",200,20,p2.getColor());
            }
            else {
                pC = p1;
                getTexts().clear();
                showText("Current player: 1",200,20,p1.getColor());
            }
        }
        scored = false;
        lines.remove(s);

    }

    @Override
    public void act()
    {


    }

    public void setScored(boolean scored) {
        this.scored = scored;
    }

    public player getpC() {
        return pC;
    }

    public HashMap<String, Line> getLines() {
        return lines;
    }

    public HashMap<Line, List<square>> getLts() {
        return lts;
    }


}
