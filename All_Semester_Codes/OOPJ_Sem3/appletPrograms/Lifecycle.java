import java.awt.*;
import java.applet.*;

public class Lifecycle extends Applet
{
    String msg;
    
    public void init()
    {
        setBackground(Color.red);
        setForeground(Color.black);
        msg=" INIT() ";
    }
    
    public void start()
    {
        msg=msg+" START() ";
    }
    
    public void paint(Graphics g)
    {
        msg=msg+" PAINT() ";
        g.drawString(msg,20,40);
        showStatus("Life cycle of Applet");
    }
    
    public void stop()
    {
        msg=msg+"STOP()";
    }
    
    public void destroy()
    {
        msg=msg+"DESTROY()";
    }
    
}