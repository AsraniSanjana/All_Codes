//jessica im very bored
//sanj ilyyyyy....by jessica 

import java.awt.*;
class MenuDemo{
    public static void main(String args[])
    {
        Frame f=new Frame("SANJANA ");
        f.setSize(400,400);
        f.setVisible(true);
        f.setBackground(Color.red);
        MenuBar mb;
        //menubar has file, edit,..:create obj of menubar:to add more menus
        // menu objects are save,open
        Menu menu1,menu2;
        MenuItem m1,m2,m3,m4,m5,m6;
        mb=new MenuBar();
        menu1=new Menu("File");
        m1=new MenuItem("New");
        m2=new MenuItem("open");
        m3=new MenuItem("save");
        
        
        // making a drop down menu
        //m4=new MenuItem("save as");
        menu2=new Menu("save-as");
        m5=new MenuItem(".pdf");
        m6=new MenuItem(".docx");
        menu2.add(m5);
        menu2.add(m6);
        menu1.add(menu2);
        menu2.add(m5);
        menu1.add(menu2);
        menu1.add(m1);
        menu1.add(m2);
        menu1.add(m3);
        menu1.add(menu2);
        mb.add(menu1);
        f.setMenuBar(mb);
    }}
        