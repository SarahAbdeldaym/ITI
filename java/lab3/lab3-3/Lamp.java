import java.applet.Applet;
import java.awt.*;

public class Lamp extends Applet
{

    public void paint(Graphics g)
    {
		Color myColor = new Color(255, 255, 152); 
		g.setColor(myColor);
		g.fillOval(50,50,300,70); // top oval
		
		g.fillOval(80,170, 40, 80); // left oval
		g.fillOval(280,170, 40, 80); // right oval
		g.fillOval(170,140, 70, 140); // central oval
		
		g.setColor(Color.black);
		
		g.drawLine(50,85,20,300); // left line
		g.drawLine(350,85,380,300); // right line
		
		// drawArc(int x, int y, int width, int length, int startAngle, int arcAngle)
		g.drawArc(20, 275, 360, 50, 180, 180);
		
		g.drawLine(190,325,175,400);
		g.drawLine(210,325,225,400);
		
		g.drawRect(50, 400, 300, 30);
		
    }
     
}