import java.applet.*;
import java.awt.*;
import java.awt.event.*;


public class MovingText extends Applet{
    int x=50 ; 
	int y =50; 

    public void init(){
        Listener key = new Listener();
            this.addKeyListener(key);
    }

    public void paint(Graphics g){
        g.drawString("java", x, y);
    }

    public class Listener extends KeyAdapter {
            public void keyPressed(KeyEvent ev){
                switch(ev.getKeyCode()){
                   case KeyEvent.VK_UP:
                    y-=30;
                    repaint();
                    break;
                    case KeyEvent.VK_DOWN:
                    y+=30;
                    repaint();
                    break;
                    case KeyEvent.VK_LEFT:
                    x-=30;
                    repaint();
                    break;
                    case KeyEvent.VK_RIGHT:
                    x+=30;
                    repaint();
                    break;
                }
            }

    }
} 