import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class JbuttonDemo extends JApplet
implements ActionListener
{
    JTextField T;
    public void init()
    {
     Container contentPane=getContentPane();
     contentPane.setLayout(new FlowLayout());
     ImageIcon jett = new ImageIcon("jett.jpg");
     JButton B1=new JButton(jett);
     B1.setActionCommand("jett");
     B1.addActionListener(this);
     contentPane.add(B1);
     
     ImageIcon Reyna = new ImageIcon("Reyna.jpg");
     JButton B2=new JButton(Reyna);
     B2.setActionCommand("Reyna");
     B2.addActionListener(this);
     contentPane.add(B2);
     
     ImageIcon cypher = new ImageIcon("cypher.jpg");
     JButton B3=new JButton(cypher);
     
     B3.setActionCommand("cypher");
     B3.addActionListener(this);
     contentPane.add(B3);
     
     T=new JTextField(20);
     contentPane.add(T);
    }
    public void actionPerformed(ActionEvent e)
    {
        T.setText(e.getActionCommand());
    }
}