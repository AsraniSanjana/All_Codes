import java.applet.*;
import java.awt.*;

public class BorderLDemo3 extends Applet
{
    String msg="      ";
    public void init()
    {
        setLayout(new BorderLayout());
        add(new TextField(""),BorderLayout.NORTH);
        add(new TextField(""),BorderLayout.SOUTH);
        add(new Button(""),BorderLayout.EAST);
        add(new Button(""),BorderLayout.WEST);
        add(new Button("Sanjana"),BorderLayout.CENTER);
    }
}