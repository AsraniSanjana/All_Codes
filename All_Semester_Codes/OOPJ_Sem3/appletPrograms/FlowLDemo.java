//FLOWLAYOUT

import java.awt.*;
class FlowLDemo
{ 
  public static void main(String args[])
  {
   Frame f = new Frame(" ");
   f.setSize(400,400);
   f.setVisible(true);
   Checkbox b1 = new Checkbox("Sunday");
   Checkbox b2 = new Checkbox("Monday");
   Checkbox b3 = new Checkbox("Tuesday");
   Checkbox b4 = new Checkbox("Wednesday");
   Checkbox b5 = new Checkbox("Thursday");
   Checkbox b6 = new Checkbox("Friday");
   Checkbox b7 = new Checkbox("Saturday");

   f.setLayout(new FlowLayout(FlowLayout.RIGHT));
   f.add(b1);
   f.add(b2);
   f.add(b3);
   f.add(b4);
   f.add(b5);
   f.add(b6);
   f.add(b7);
 }
}