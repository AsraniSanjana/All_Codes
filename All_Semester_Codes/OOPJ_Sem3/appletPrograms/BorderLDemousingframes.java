import java.awt.*;
public class BorderLDemousingframes
{
  public static void main(String args[])
  {
    Frame f = new Frame("  ");
    f.setSize(400,400);
    f.setVisible(true);
    f.setLayout(new BorderLayout());
    String msg= "   ";
    f.add(new Button("North"),BorderLayout.NORTH);
    f.add(new Button("South"),BorderLayout.SOUTH);
    f.add(new Button("East"),BorderLayout.EAST);
    f.add(new Button("West"),BorderLayout.WEST);
    f.add(new TextArea(msg),BorderLayout.CENTER);
  }
}