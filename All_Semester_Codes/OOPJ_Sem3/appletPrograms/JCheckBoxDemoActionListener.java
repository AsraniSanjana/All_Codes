import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class JCheckBoxDemoActionListener extends JApplet
implements ActionListener
{
    JTextField T;
    public void init()
    {
     Container contentPane=getContentPane();
     contentPane.setLayout(new FlowLayout());
     
     JCheckBox c1=new JCheckBox("jett");
     c1.setActionCommand("jett");
     c1.addActionListener(this);
     contentPane.add(c1);
     
     
     JCheckBox c2=new JCheckBox("Reyna");
     c2.setActionCommand("Reyna");
     c2.addActionListener(this);
     contentPane.add(c2);
     
     
     JCheckBox c3=new JCheckBox("cypher");
     
     c3.setActionCommand("cypher");
     c3.addActionListener(this);
     contentPane.add(c3);
     
     T=new JTextField(20);
     contentPane.add(T);
     ButtonGroup c=new ButtonGroup();
     c.add(c1);
     c.add(c2);
     c.add(c3);
     
     
    }
    public void actionPerformed(ActionEvent e)
    {
        T.setText(e.getActionCommand());
    }
}