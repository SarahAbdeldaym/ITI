import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Button;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 


public class IncrementDecrement extends Applet 
{

    int counter ;
    Button buttonOne; //to make a refrense 
    Button buttonTwo;

    public void init(){
        buttonOne = new Button("increment");  //to draw object ( type button) and assign the refrence to it 
       buttonOne.addActionListener(new ButtonOneListener());
        add(buttonOne);
        buttonTwo = new Button("decrement");
        buttonTwo.addActionListener(new ButtonTwoListener());
        add(buttonTwo);
        }

    public void paint(Graphics g){
        g.drawString("the counter value is "+ counter, 50, 200); //to draw counter performance

    }
    

    class ButtonOneListener implements ActionListener {
        public void actionPerformed(ActionEvent ev){
                counter ++;
                repaint();
        }
    }
    class ButtonTwoListener implements ActionListener {
        public void actionPerformed(ActionEvent ev){
                counter --;
                repaint();
        }
    }





}