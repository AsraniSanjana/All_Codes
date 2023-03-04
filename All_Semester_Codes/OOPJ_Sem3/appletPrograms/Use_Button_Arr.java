import java.awt.*;
class Use_Button_Arr
{
  public static void main(String args[])
  {
   Frame f = new Frame(" ");
   f.setSize(400,200);
   f.setLayout(new FlowLayout());
   f.setVisible(true);
   Button b[] = new Button[5];
   String Fruits[] = {"Mango" , "Orange" , "Banana" , "Apple" , "Strawberry"};
   for(int i=0; i<5; i++)
   {
     b[i]=new Button(" " + Fruits[i]);
     f.add(b[i]);
   }
  }
}