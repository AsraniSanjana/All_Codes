import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/*
 * <applet code="BorderLayoutDemo"
   width=300
   height=300>
  </applet>
  >
 */
public class ComboBox extends JApplet
implements ItemListener
{
    JLabel L;
    public void init()
    {
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        JComboBox co= new JComboBox();
         co.addItem("apple");
        co.addItem("orange");
        co.addItem("grapes");
        co.addItemListener (this);
        contentPane.add(co);
        
        L=new JLabel(new ImageIcon("apple.jfif"));
        contentPane.add(L);
    }
    public void itemStateChanged(ItemEvent e)
{
    String str=(String)e.getItem();
    L.setIcon(new ImageIcon(str + ".jfif"));
}
}