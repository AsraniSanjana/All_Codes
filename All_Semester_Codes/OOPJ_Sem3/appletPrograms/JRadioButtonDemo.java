import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JRadioButtonDemo extends JApplet
implements ItemListener
{
    JTextField T;
    
    public void init()
    {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        
        JRadioButton c1 = new JRadioButton("captain");
        c1.addItemListener(this);
        cp.add(c1);
        
        JRadioButton c2 = new JRadioButton("iron");
        c2.addItemListener(this);
        cp.add(c2);
        
        JRadioButton c3 = new JRadioButton("thor");
        c3.addItemListener(this);
        cp.add(c3);
        
        T = new JTextField(5);
        cp.add(T);
        ButtonGroup bg = new ButtonGroup();
        bg.add(c1);
        bg.add(c2);
        bg.add(c3);
    }
    
    public void itemStateChanged(ItemEvent e)
    {
        JRadioButton chk = (JRadioButton)e.getItem();
        T.setText(chk.getText());
    }
}