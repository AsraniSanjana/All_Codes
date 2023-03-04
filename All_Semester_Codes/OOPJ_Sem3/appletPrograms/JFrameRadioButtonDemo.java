import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JFrameRadioButtonDemo implements ItemListener

{
    JTextField T;
    JFrameRadioButtonDemo()//constructor
    {
    
    JRadioButton c1,c2,c3;
    JFrame f;

    
       
    
    f = new JFrame("RadioButton using Frame ");  
    f.setSize(400,400);  
    f.setLayout(new FlowLayout());
    f.setVisible(true);
       f.setLayout(new FlowLayout());
        
        c1= new JRadioButton("cypher");
        c1.addItemListener(this);
        f.add(c1);
        
         c2 = new JRadioButton("Reyna");
        c2.addItemListener(this);
        f.add(c2);
        
        c3 = new JRadioButton("jett");
        c3.addItemListener(this);
        f.add(c3); 
        
        T = new JTextField(5);
        f.add(T);
        ButtonGroup bg = new ButtonGroup();
        bg.add(c1);
        bg.add(c2);
        bg.add(c3);
    }
    
    public static void main(String args[])
    {
        JFrameRadioButtonDemo j=new JFrameRadioButtonDemo();}
     public void itemStateChanged(ItemEvent e)
    {
        
        JRadioButton chk = (JRadioButton)e.getItem();
        T.setText(chk.getText());
    }
}