import java.applet.Applet; //abstract class
import java.awt.Graphics;

public class MovingWord extends Applet implements Runnable
{
    Thread th;
    int x;
    String st;
    int stWidth;

    public void init(){
        x = 0;
        st = "java world";
        th = new Thread (this);   
        th.start();
    }

    public void paint (Graphics g){
        g.drawString(st,x%getWidth() ,150);
        stWidth = g.getFontMetrics().stringWidth(st);   
    }

    public void run (){
        while (true){
            try { 
                if(x <= getWidth()){
                    Thread.sleep(1000);
                    repaint();
                    x+=30;
                }else {
                    x=-stWidth;
                   repaint();
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace();}
               
        }
    }
}