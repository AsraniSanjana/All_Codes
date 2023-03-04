//SCROLLBARS
import java.awt.*;
class Use_ScrollBars
{
  public static void main(String args[])
  {
   Frame f = new Frame(" ");
   Scrollbar h = new Scrollbar(Scrollbar.HORIZONTAL);
   Scrollbar v = new Scrollbar(Scrollbar.VERTICAL);
   f.setSize(300,300);
   f.setLayout(new FlowLayout());
   f.setVisible(true);
   f.add(h);
   f.add(v);
  }
}