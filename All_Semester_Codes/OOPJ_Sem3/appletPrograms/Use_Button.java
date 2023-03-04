// abstract windowing tool kit 
//frame k andar heading 
// new flowlayout se center align
// set bound se kahin pe b rakh skte instaed of center align
//array of objects of button class
//yeh applet ni h swing java gui hai
//applet awt swings : three things in gui
import java.awt.*;
class Use_Button
{
    public static void main(String args[])
    {
        Frame f=new Frame("this is a heading");
        f.setSize(400,200);
        f.setLayout(new FlowLayout());
        f.setVisible(true);
        Button b1=new Button("ok");
        Button b2=new Button("cancel");
        f.add(b1);
        f.add(b2);
    }}
    
    
        