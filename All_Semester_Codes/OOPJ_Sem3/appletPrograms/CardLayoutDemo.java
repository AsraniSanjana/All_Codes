import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class CardLayoutDEmo extends Applet implements ActionListener, MouseListener
{
    Checkbox mango,apple,rose,lotus,red,green;
    Panel p, fp , fop, cp;
    CardLayout c;
    Button Fruit,Flower,Colour;
    public void init()
    {
        Fruit = new Button("Fruit");
        Flower = new Button("Flower");
        Colour = new Button("Colour");
        
        // Adding the button control
        add(Fruit);
        add(Flower);
        add(Colour);
        
        // adding object of cardlayout
        c = new CardLayout();
        
        // adding objeect of panel 
        p = new Panel();
        p.setLayout(c);
        
        // adding checkbox
        
        mango = new Checkbox("Mango");
        apple = new Checkbox("Apple");
        
        rose = new Checkbox("Rose");
        lotus = new Checkbox("Lotus");
        
        red = new Checkbox("Red");
        green = new Checkbox("Green");
        
        Panel fp = new Panel();
        fp.add(mango);
        fp.add(apple);
        
        Panel fop = new Panel();
        fop.add(rose);
        fop.add(lotus);
        
        Panel cp = new Panel();
        cp.add(red);
        cp.add(green);
        
        p.add(fp,"Fruit");
        p.add(fop,"Flower");
        p.add(cp,"Colour");
        add(p);
        
        Fruit.addActionListener(this);
        Flower.addActionListener(this);
        Colour.addActionListener(this);
        addMouseListener(this);
    }
    
    public void mousePressed(MouseEvent m)
    {
        c.next(p);
    }
    
    public void mouseClicked(MouseEvent m)
    {
    }
    
    public void mouseEntered(MouseEvent m)
    {
    }
    
    public void mouseExited(MouseEvent m)
    {
    }
    
    public void mouseReleased(MouseEvent m)
    {
    }
    
    public void actionPerformed(ActionEvent e)
    {
     if(e.getSource()==Fruit)
        {
         c.show(p,"Fruit");
         }
     else if(e.getSource()==Flower)
        {
            c.show(p,"Flower");
        }
     else if(e.getSource() ==Colour)
       {
         c.show(p,"Colour");
        }
    }
}