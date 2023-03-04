import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class JCheckBoxDemoItemListener extends JApplet
implements ItemListener
{
    JTextField T;
    public void init()
    {
     Container contentPane=getContentPane();
     contentPane.setLayout(new FlowLayout());
     
     JCheckBox c1=new JCheckBox("jett");
     
     c1.addItemListener(this);
     contentPane.add(c1);
     
     
     JCheckBox c2=new JCheckBox("Reyna");
     
     c2.addItemListener(this);
     contentPane.add(c2);
     
     
     JCheckBox c3=new JCheckBox("cypher");
     

     c3.addItemListener(this);
     contentPane.add(c3);
     
     T=new JTextField(20);
     contentPane.add(T);
     ButtonGroup c=new ButtonGroup();
     c.add(c1);
     c.add(c2);
     c.add(c3);
     
     
    }
    public void itemStateChanged(ItemEvent e)
    {
        JCheckBox chk=(JCheckBox)e.getItem();
        T.setText(chk.getText());
    }
}