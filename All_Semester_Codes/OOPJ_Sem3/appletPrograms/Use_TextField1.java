//TEXTFIELD CUSTOMIZED
import java.awt.*;
class Use_TextField1
{
  public static void main(String args[])
  {
   Frame f = new Frame(" ");
   f.setSize(200,300);
   f.setVisible(true);
   Label L1 = new Label("Enter your name here : ");
   TextField t = new TextField(10);  
   t.setBounds(200,200,200,20);
   L1.setBounds(200,190,200,20);
   f.setLayout(null);
   f.add(L1);
   f.add(t);
  }
}