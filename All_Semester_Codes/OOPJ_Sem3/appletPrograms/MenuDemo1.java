//MEMBERS AND MENUS

import java.awt.*;
class MenuDemo1
{
  public static void main(String args[])
  {
   Frame f = new Frame(" ");
   f.setSize(400,400);
   f.setVisible(true);
   MenuBar mb;               //For adding more menus create object of menubar
   Menu menu1,menu2;
   MenuItem m1,m2,m3,m4,m5;
   mb=new MenuBar();
   menu1=new Menu("File");
   m1=new MenuItem("New");
   m2=new MenuItem("Open");
   m3=new MenuItem("Save");
   
   menu1.add(m1);
   menu1.add(m2);
   menu1.add(m3);
   menu2=new Menu("Save-as");
   m4=new MenuItem(".pdf");
   m5=new MenuItem(".docx");
   menu2.add(m4);
   menu2.add(m5);
   menu1.add(menu2);
   mb.add(menu1);
   
   f.setMenuBar(mb);
 }
}