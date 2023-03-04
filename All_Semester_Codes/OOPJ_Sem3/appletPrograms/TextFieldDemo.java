// textfield
import java.awt.*;
import javax.swing.*;
class TextFieldDemo
{
    public static void main(String args[])
    {
        JFrame f=new JFrame();
        f.setLayout(new FlowLayout());
        JTextField t=new JTextField("Hello",20); // 20 is column value:20 characters can be entered
        f.add(t);
        JTextField t1=new JTextField(20);// max 20 characters dal payenge ac to textbox , but hota h 
        f.add(t1);
        f.setSize(400,400);
        f.setVisible(true);
    }}
    // container is a predefined class in javaapplet