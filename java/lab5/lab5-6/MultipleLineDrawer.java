import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MultipleLineDrawer extends Applet {
	
	int x1, y1, x2, y2 = 0;   //point cordinates 

	int lines = 0; //the index of the array 
	
	ArrayList<Line> arr = new ArrayList<Line>(); //creating array of obj that save every line i draw 
	
	public void init(){
		
		MouseListener m1 = new MouseListener(); // to implement class MouseListener methods
		this.addMouseListener(m1);

		MouseDrag m2 = new MouseDrag();   // to implement class MouseDrag methods
		this.addMouseMotionListener(m2);
		
	}
	
	public void paint(Graphics g){
		
		for(int i = 0; i < lines; i++){ //34an kol mara y3ml paint fe l index sa7
			arr.get(i).draw(g);
		}
		g.drawLine(x1,y1,x2,y2);
	
	}

	class MouseListener extends MouseAdapter {

		public void mousePressed(MouseEvent e){
			
			x1 = e.getX();
			y1 = e.getY();
			x2=x1;
			y2=y1;
			repaint();

		}
		public void mouseReleased(MouseEvent e){
				
			if(x1 != e.getX() || y1 != e.getY()){  //lw no2ta gdeda aly wa2f feha al mouse m4 nfs awl no2ta
				
				x2 = e.getX();
				y2 = e.getY();
				arr.add(new Line(x1,y1,x2,y2)); 
				lines++;
				repaint();
			}
				
		}
	}

	class MouseDrag extends MouseAdapter {

		public void mouseDragged(MouseEvent e){
					
				x2 = e.getX();
				y2 = e.getY();
				repaint();
				
			}
			
		}
	
		
		
		
	

	class Line{
		
		int x1,y1,x2,y2;
		
		Line(int locX1,int locY1,int locX2,int locY2)  //constructor 
		{
			x1 = locX1;
			y1 = locY1;
			x2 = locX2;
			y2 = locY2;
		}
		
		public void draw(Graphics g){
			
			g.drawLine(x1,y1,x2,y2); 
		}
		
	}
}

