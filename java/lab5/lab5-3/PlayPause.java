import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class PlayPause extends Applet implements Runnable{

    Button startButton;
    Button pauseButton;
    boolean flagX;
    boolean flagY;
    int x;
    int y;
    Thread th;
    volatile int flag;
    public void init(){
        x=80;
        y=300;
        flagX = true;
        flagY = true;
        flag =0;
        th = new Thread (this);
        startButton = new Button("start");
        pauseButton = new Button("pause");

        add(startButton);
        add(pauseButton);

        StartActionListener start=new StartActionListener();
        startButton.addActionListener(start);

        PauseActionListener pause =new PauseActionListener();
        pauseButton.addActionListener(pause);

        th.start();

    }

    public void paint(Graphics g){
        g.fillOval(x, y,40,40);
    }


 
    public void run()
	{
		while(true)
		{	if(flag ==1){
			try
			{
				//x
				if(flagX==true)
				{
					if((x+40) < getWidth())
					{x+=20;
					
					}
				
					if((x+40) >= getWidth())
					{flagX=false;}
				}
				
				else
				{
					if(x>0)
					{x-=20; }
				
					if(x<=0)
					{flagX=true;}
				}
				
				//y
				if(flagY==true)
				{
					if((y+40) < getHeight())
					{y+=20;
					
					}
				
					if((y+40) >= getHeight())
					{flagY=false;}
				}
				
				else
				{
					if(y>0)
					{y-=20; }
				
					if(y<=0)
					{flagY=true;}
				}
				
				repaint();
				th.sleep(15);
            }	
			
		catch(InterruptedException ie)
			{ie.printStackTrace();}
		}
    }
    }
		


    class StartActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ev){
            if(flag == 1){
                flag=0;
            }
            if(flag == 0){
                flag =1;
            }
        }
    }

        class PauseActionListener implements ActionListener {
            public void actionPerformed(ActionEvent ev){
               flag =0;
            } 
        }
     
}