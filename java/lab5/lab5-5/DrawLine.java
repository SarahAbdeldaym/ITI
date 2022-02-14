import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class DrawLine extends Applet {
	
	int x1, y1, x2, y2 = 0;
	
	public void init(){
		
		MouseListener m1 = new MouseListener();
		this.addMouseListener(m1);

		MouseDrag m2 = new MouseDrag();
		this.addMouseMotionListener(m2);

		
	}
	
	public void paint(Graphics g){
		g.drawLine(x1,y1,x2,y2); 
	}

	class MouseListener extends MouseAdapter {

		public void mousePressed(MouseEvent e){
			
			x1 = e.getX();
			y1 = e.getY();
			x2 = x1;
			y2 = y1;
			repaint();

		}
		
	}
    class MouseDrag extends MouseAdapter {

		public void mouseDragged(MouseEvent e){
				
            x2 = e.getX();
            y2 = e.getY();
            repaint();
            
        }
		
	}

}