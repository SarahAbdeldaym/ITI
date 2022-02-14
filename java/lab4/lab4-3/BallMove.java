import java.applet.*;
import java.awt.*;

import javafx.scene.paint.Color;

public class BallMove extends Applet implements Runnable
{
    Thread th ;
    int x;
    int y;
    boolean flagx;
    boolean flagy;


    public void init(){
        flagx = true;
		flagy = true;
        th = new Thread (this);
        th.start();
    }

    public void paint (Graphics g){
    
        g.fillOval(x,y, 40, 40);
        g.drawOval(x,y, 40, 40);
    }
    
    public void run (){
        while(true){
            try {
                    //x
                    if(flagx == true ){
                        if((x+40)<= getWidth()){
                            x +=20;
                        }
                        if((x+40) > getWidth()){
                            flagx= false;
                        }
                    }else{
                        if(x>0){
                            x =x - 20;
                        }
                        if(x<=0){
                            flagx=true;
                        }
                    }
                    //y
                    if(flagy ==true){
                        if((y+40)<= getHeight()){
                            x = x+20;
                        }
                        if((y+40)> getHeight()){
                            flagy=false;
                        }
                    }
                    else{
                        if(y>0){
                            y=y-20;
                        }
                        if(y <= 0){
                         flagy=false;}
                        }
                    }
                    catch(Exception ie){
                    {ie.printStackTrace();}
                    }   

                }
            
            
        }
    }