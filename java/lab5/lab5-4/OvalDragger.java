import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class OvalDragger extends Applet{
    int x; int y; int ballWidth; int ballHeight;
    MouseListner mL;
    DragListner dl;

    public void init(){
        x = (getWidth()/2)-(ballWidth/2);
        y = (getHeight()/2)-(ballHeight/2);
        ballWidth = 50;
        ballHeight = 50;
        mL = new MouseListner();
        dl = new DragListner();

        this.addMouseListener(mL);
        this.addMouseMotionListener(dl);
    }

    public void paint(Graphics g){  
        g.setColor(Color.BLUE);
        g.fillOval(x, y, ballWidth, ballHeight);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, ballWidth, ballHeight);
    }

    class MouseListner extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            x = e.getX() - (ballWidth/2);
            y = e.getY() - (ballHeight/2);
            repaint();
        }
    }

    class DragListner extends MouseAdapter{
        public void mouseDragged(MouseEvent e){
            x = e.getX() - (ballWidth/2);
            y = e.getY() - (ballHeight/2);
            repaint();
        }
    }
}