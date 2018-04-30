
import mayflower.Color;
import mayflower.MayflowerImage;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.io.File;

public class player
{
    private int score;
    private MayflowerImage imageS;
    private MayflowerImage imageL;
    private int num;
    private Color color;

    public player(Color color,int p)
    {
        num = p;
        this.color = color;
        MayflowerImage square = new MayflowerImage("imgs/squares.png");
        for(int r = 0;r<square.getWidth();r++)
        {

            for(int c =0;c<square.getHeight();c++)
            {

                square.setColorAt(r,c,color);
            }
        }
        imageS = square;
        MayflowerImage line = new MayflowerImage("imgs/lines.png");
        for(int r = 0;r<line.getWidth();r++)
        {
            for(int c =0;c<line.getHeight();c++)
            {
                //if(line.getColorAt(r,c)!=null)
                    line.setColorAt(r,c,color);
            }
        }
        imageL = line;
    }

    public MayflowerImage getImageL() {
        return imageL;
    }

    public MayflowerImage getImageS() {
        return imageS;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNum() {
        return num;
    }

    public Color getColor() {
        return color;
    }
}
