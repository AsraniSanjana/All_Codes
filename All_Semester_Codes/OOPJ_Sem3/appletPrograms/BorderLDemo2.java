import java.applet.*;
import java.awt.*;
public class BorderLDemo2 extends Applet 
{
    String msg=" ";
    public void init ()
    {
        setBackground(Color.green);
        setLayout(new BorderLayout());
        add(new Button ("North"), BorderLayout.NORTH);
        add(new Button ("South"), BorderLayout.SOUTH);
        add(new Button ("East"), BorderLayout.EAST);
        add(new Button ("West"), BorderLayout.WEST);
    }
    
        public Insets getInsets()
        {
            return new Insets(20,20,20,20);
        }}