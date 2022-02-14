import java.awt.*;  
import java.applet.*;  


public class Img extends Applet {  
  
  Image picture;  
  
  public void init() {  
    picture = getImage(getDocumentBase(),"resources/java.jpg");  
  }  
    
  public void paint(Graphics g) {  
    g.drawImage(picture,0,0,getWidth(),getHeight(), this);  
  }  
     
  } 