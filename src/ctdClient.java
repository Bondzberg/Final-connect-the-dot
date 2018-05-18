

import mayflower.Color;
import mayflower.Mayflower;
import mayflower.World;
import mayflower.net.Client;

import javax.swing.*;
import java.awt.*;

public class ctdClient extends Client
{

    private ClientWorld world;

    private Color color;
    private Color color2;


    public ctdClient(Color col)
    {
        this.world = world;
        this.color = col;
        try {
            this.connect(Mayflower.ask("enter the ip of the server"), 1234);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(new Frame(), "No server detected at the IP address, creating a new server", "No server detected", JOptionPane.ERROR_MESSAGE);
            new ctdServer(1234);
            this.connect("localhost",1234);
        }
        send("Color: "+ color.getRed()+" "+color.getGreen()+" "+color.getBlue());
        Mayflower.setWorld(new World() {
            @Override
            public void act() {
                showText("please wait",400,300,color);
            }
        });
    }

    @Override
    public void process(String s) {
        String[] strings =s.split(" ");
        if(strings[0].equals("player"))
            world.setNum(Integer.valueOf(strings[1]));
        else if(strings[0].equals("world"))
        {
            int x = Integer.valueOf(Integer.valueOf(strings[1]));
            int y = Integer.valueOf(Integer.valueOf(strings[2]));
            ClientWorld world = new ClientWorld(x,y,false,this,color,color2);
            this.world = world;

        }
        else if(strings[0].equals("dis"))
        {
            world.win();
        }
        else if(strings[0].equals("Color:")||strings[0].equals("sColor:"))
        {
            color2 = new Color(Integer.parseInt(strings[1]),Integer.parseInt(strings[2]),Integer.parseInt(strings[3]));
            if(strings[0].substring(0,1).equals("s"))
            {
                Color temp = color;
                color = color2;
                color2 = temp;
            }
        }
        else
        {
            int value = Integer.valueOf(strings[strings.length-1]);
            String ss = strings[0]+ " " + strings[1] + " "+strings[2];
            world.proccess(ss,value);
        }

    }

    public ClientWorld getWorld() {
        return world;
    }

    public Color getColor() {
        return color;
    }

    public Color getColor2() {
        return color2;
    }

    @Override
    public void onDisconnect(String s)
    {

    }

    @Override
    public void onConnect()
    {

    }
}
