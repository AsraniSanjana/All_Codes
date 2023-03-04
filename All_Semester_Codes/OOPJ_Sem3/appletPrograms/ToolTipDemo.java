import java.awt.*;
import javax.swing.*;
public class ToolTipDemo
{
    public static void main(String args[])
    {
        JFrame f = new JFrame("Tool Tip");
        JLabel l = new JLabel ("Name:");
        JTextField t = new JTextField("",10);
        t.setToolTipText("Enter Your name");
        JButton B = new JButton("submit");
        B.setToolTipText("click to submit");
        f.setLayout(new FlowLayout());
        f.add(l);
        f.add(t);
        f.add(B);
        f.setSize(500,500);
        f.setVisible(true);
    }
}