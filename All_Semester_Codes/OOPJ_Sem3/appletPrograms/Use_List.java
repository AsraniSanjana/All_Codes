// 10 mtlb 10 rows 
//20 mtlb 20 columns
//LIST
import java.awt.*;
class Use_List
{
  public static void main(String args[])
  {
   Frame f = new Frame(" ");
   f.setSize(200,300);
   f.setLayout(new FlowLayout());
   f.setVisible(true);

   List flower = new List(4,false);
   //(4); same
   //(y,true); -> can select more than 1
   flower.add("Rose");
   flower.add("Jasmine");
   flower.add("Lotus");
   flower.add("Lily");
   f.add(flower);
  }
}