import mayflower.Actor;
import mayflower.Color;
import mayflower.Mayflower;
import mayflower.World;
import mayflower.event.EventListener;

import java.util.*;

public class GameWorld extends World implements EventListener
{
    private square[][] squares;

    private HashMap<String,Line> lines;
    private HashMap<Line,List<square>> lts;
    private player p1;
    private player p2;
    private player pC;
    private boolean scored;
    private boolean running;
    private Queue<Actor> actors;
    private Queue<Integer> x,y,rot;

    public GameWorld(int x,int y,boolean ai)
    {
        p1 = new player(Runner.playerStats.getColor(),1);
        p2 = new player(Color.PINK,2);
        if(ai)
            p2 = new AI(Color.PINK,2,this);
        pC = p1;
        init(x,y);
    }

    public GameWorld(int x,int y,player one,player two)
    {
        p1 = one;
        p2 = two;
        pC = p1;
        init(x,y);
    }

    public void init(int x, int y)
    {
        actors = new LinkedList<>();
        this.x = new LinkedList<>();
        this.y = new LinkedList<>();
        rot = new LinkedList<>();
        lines = new HashMap<>();
        squares = new square[x][y];
        lts = new HashMap();
        running = true;

        scored = false;
        showText("Current player: 1",250,20,p1.getColor());
        int offx = 220;
        int offy = 64;

        for(int c=0;c<squares.length;c++)
        {
            for(int r = 0;r<squares[0].length;r++)
            {
                squares[c][r] = new square(this);
                squares[c][r].setImage("imgs/empty.png");
                addObject(squares[c][r],c*55+5+offx,r*55+5+offy);
                Actor img = new Actor() {
                    @Override
                    public void act() {

                    }
                };
                img.setImage("imgs/corner.png");
                addObject(img,c*55+offx,r*55+offy);
                Actor img2 = new Actor() {
                    @Override
                    public void act() {

                    }
                };
                img2.setImage("imgs/corner.png");
                addObject(img2,(c+1)*55+offx,r*55+offy);
                Actor img4 = new Actor() {
                    @Override
                    public void act() {

                    }
                };
                img4.setImage("imgs/corner.png");
                addObject(img4,c+offx,(r+1)*55+offy);
                Actor img3 = new Actor() {
                    @Override
                    public void act() {

                    }
                };
                img3.setImage("imgs/corner.png");
                addObject(img3,(c+1)*55+offx,(r+1)*55+offy);
                if(r==0)
                {
                    Line top = new Line("imgs/lines.png","t "+c+" "+r);
                    top.addEventListener(this);
                    lts.put(top,new ArrayList<>());
                    lines.put("t "+c+" "+r,top);
                    lts.get(top).add(squares[c][r]);
                    addObject(top,c*50+5*(c+1)+offx,0+offy);
                    Line bottom = new Line("imgs/lines.png","b "+c+" "+r);
                    lines.put("b "+c+" "+r,bottom);
                    lts.put(bottom,new ArrayList<>());
                    lts.get(bottom).add(squares[c][r]);
                    addObject(bottom,c*50+5*(c+1)+offx,55+offy);
                    bottom.addEventListener(this);
                }
                else
                {
                    lts.get(lines.get("b "+c+" "+(r-1))).add(squares[c][r]);
                    Line bottom = new Line("imgs/lines.png","b "+c+" "+r);
                    lines.put("b "+c+" "+r,bottom);
                    lts.put(bottom,new ArrayList<>());
                    lts.get(bottom).add(squares[c][r]);
                    addObject(bottom,c*50+5*(c+1)+offx,r*55+55+offy);
                    bottom.addEventListener(this);
                }


                if(c==0)
                {
                    Line left = new Line("imgs/lines.png","l "+c+" "+r);
                    lines.put("l "+c+" "+r,left);
                    lts.put(left,new ArrayList<>());
                    lts.get(left).add(squares[c][r]);
                    left.setRotation(-90);
                    addObject(left,-23+offx,r*50+23+5*(r+1)+offy);
                    left.addEventListener(this);
                    Line right = new Line("imgs/lines.png","r "+c+" "+r);
                    lines.put("r "+c+" "+r,right);
                    lts.put(right,new ArrayList<>());
                    lts.get(right).add(squares[c][r]);
                    right.setRotation(-90);
                    addObject(right,32+offx,r*50+23+5*(r+1)+offy);
                    right.addEventListener(this);
                }
                else
                {
                    lts.get(lines.get("r "+(c-1)+" "+r)).add(squares[c][r]);
                    Line right = new Line("imgs/lines.png","r "+c+" "+r);
                    lines.put("r "+c+" "+r,right);
                    lts.put(right,new ArrayList<>());
                    lts.get(right).add(squares[c][r]);
                    addObject(right,c*55+32+offx,r*50+23+5*(r+1)+offy);
                    right.setRotation(-90);
                    right.addEventListener(this);
                }


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
        if(isDone())
        {
            for(int o = 0; o < 60; o++)
            {
                Winner a = new Winner();
                a.scale(.5);
                addObject(a, 350, 250);
            }

            String winner = "no one" ;
            Color wins = Color.BLACK;
            if(p1.getScore()>p2.getScore()) {
                winner = "player " + 1;
                wins = p1.getColor();
            }
            else if(p2.getScore()>p1.getScore()) {
                winner = "player " + 2;
                wins = p2.getColor();
            }
            showText(winner+" wins",250,500,wins);

            //addObject(new Winner(), 25, 25);
            running=false;

            return;

        }
        if(!scored) {
            if (pC.equals(p1)) {
                pC = p2;
                getTexts().clear();
                showText("Current player: 2",250,20,p2.getColor());
            }
            else {
                pC = p1;
                getTexts().clear();
                showText("Current player: 1",250,20,p1.getColor());
            }
        }
        scored = false;
        lines.remove(s);


    }

    public boolean isDone()
    {
        for(square[] square:squares)
        {
            for(square square1:square)
                if(square1.getValue()!=4)
                    return false;
        }
        return true;
    }

    @Override
    public void act()
    {


    }

    public void proccess(String s,int j)
    {
        if(j==pC.getNum()||j==2)
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

                if(isDone())
                {
                    running=false;
                    String winner = "no one" ;
                    Color wins = Color.BLACK;
                    if(p1.getScore()>p2.getScore()) {
                        winner = "player " + 1;
                        wins = p1.getColor();
                    }
                    else if(p2.getScore()>p1.getScore()) {
                        winner = "player " + 2;
                        wins = p2.getColor();
                    }
                    showText(winner+" wins",250,500,wins);

                    //addObject(new Winner(), 25, 25);

                    return;

                }
                if(!scored) {
                    if (pC.equals(p1)) {
                        pC = p2;
                        getTexts().clear();
                        showText("Current player: 2",250,20,p2.getColor());
                    }
                    else {
                        pC = p1;
                        getTexts().clear();
                        showText("Current player: 1",250,20,p1.getColor());
                    }
                }
                scored = false;
                lines.remove(s);



        }
    }

    public boolean isRunning() {
        return running;
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
