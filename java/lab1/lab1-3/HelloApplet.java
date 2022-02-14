//package appletPackage;
import java.applet.Applet;
import java.awt.Graphics;

public class HelloApplet extends Applet
{
	
		public void paint(Graphics g){
			String params=getParameter("param"); 
			//g.drawString("Hello Java", 50, 100);
			g.drawString(params, 50, 120);
		}
				
				
}