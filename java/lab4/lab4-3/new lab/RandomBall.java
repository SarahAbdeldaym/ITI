import java.applet.*;
import java.awt.*;

public class RandomBall extends Applet implements Runnable
{
    Thread th;
    int x;
    int y;
    int xDir;
    int yDir;

    public void init()
    {
        x = 0;
        y = (getHeight() / 2) - 50;
        xDir = 1;
        yDir = 1;
        
        th = new Thread(this);
        th.start();
    }

    public void paint(Graphics g)
    {  
        g.setColor(Color.BLUE);
        g.fillOval(x, y, 100, 100);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, 100, 100);
    }

    public void run(){
        while(true){
            if(x+100 >= this.getWidth())
            {
                xDir = -1;
            }
            else if(x <= 0)
            {
                xDir = 1;
            }
            
            if(xDir == 1)
            {
                x = x + 10;
            }
            else if(xDir == -1)
            {
                x = x - 10;
            }
            
            
            if(y+100 >= this.getHeight())
            {
                yDir = -1;
            }
            else if(y <= 0)
            {
                yDir = 1;
            }
            
            if(yDir == 1)
            {
                y = y + 10;
            }
            else if(yDir == -1)
            {
                y = y - 10;
            }
            
            repaint();
            try
            {
                Thread.sleep(35);
            }
            catch(Exception e)
             {
                 e.printStackTrace();
             }
        }
    }
}