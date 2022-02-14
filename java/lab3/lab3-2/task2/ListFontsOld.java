import java.applet.Applet;
import java.awt.*;

public class ListFontsOld extends Applet {

    String[] s;

    public void init() {
        s = Toolkit.getDefaultToolkit().getFontList();
    }

    public void paint(Graphics g) {
        for (int i = 0; i < s.length; i++) {
            Font f = new Font(s[i], Font.BOLD, 14);
            g.setFont(f);
            g.drawString(s[i], 50, 100+(50*i));
        }
    }

}