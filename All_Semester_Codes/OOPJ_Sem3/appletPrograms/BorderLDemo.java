import java.applet.*;
import java.awt.*;

public class BorderLDemo extends Applet
{
    String msg="SANJANA ";
    public void init()
    {
        setLayout(new BorderLayout());
        add(new Button("North"),BorderLayout.NORTH);
        add(new Button("South"),BorderLayout.SOUTH);
        add(new Button("East"),BorderLayout.EAST);
        add(new Button("West"),BorderLayout.WEST);
        add(new TextArea(msg),BorderLayout.CENTER);
    }
}