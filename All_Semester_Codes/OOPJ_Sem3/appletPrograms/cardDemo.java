//using cardlayout component
 import java.awt.*;
 import java.awt.event.*;
 import java.applet.* ;


public class cardDemo extends Applet implements ActionListener,MouseListener {
 Checkbox mango,apple,rose, lotus,Red,Green; 
    Panel panel_obj; 
    CardLayout layout_obj;
    Button fruit,flower,colour;
    public void init() 
    { fruit=new Button("Fruit");
        flower=new Button("Flower"); 
        colour=new Button("Colour"); 
        
        add(fruit);
        add(flower);
        add(colour);
        //adding the button controls add(fruit); add(flower); add(colour); //getting object of Cardlayout layout_obj=new CardLayout(); //getting object of Panel panel_obj=new Panel(); panel_obj.setLayout(layout_obj); l/adding checkbox controls for fruits mango=new Checkbox("Mango"); apple=new Checkbox("Apple"); //adding checkbox controls for flowers rose=new Checkbox("Rose"); lotus=new Checkbox("Lotus"); //adding checkbox controls for colors Red=new Checkbox("Red"); 
    Green=new Checkbox("Green");

Panel fruit_pan=new Panel(); 
fruit_pan.add(mango); 
fruit_pan.add(apple);

Panel flower_pan=new Panel();
 flower_pan.add(rose); flower_pan.add(lotus);

Panel colour_pan=new Panel();

colour_pan.add(Red); 
colour_pan.add(Green);


panel_obj.add(fruit_pan,"Fruit");
 panel_obj.add(flower_pan,"Flower");
 panel_obj.add(colour_pan, "Colour");
 add(panel_obj);

//register the components to event listener 
fruit.addActionListener(this); 
flower.addActionListener(this); 
colour.addActionListener(this);
 addMouseListener(this); 
} 
 //following empty methods are necessary for mouse events
 public void mousePressed(MouseEvent m) 
 { layout_obj.next(panel_obj); 
    } 
public void mouseClicked(MouseEvent m) { 
}
 public void mouseEntered(MouseEvent m) {

flower.addActionListener(this);
}
public void mouseExited(MouseEvent m) {
} 
public void mouseReleased(MouseEvent m) 
{ 
} 
public void actionPerformed(ActionEvent e) 
{ if(e.getSource()==fruit) {
// usko print karo
layout_obj.show(panel_obj, "Fruit"); }
 else if(e.getSource()== flower) {

layout_obj.show(panel_obj, "Flower"); }
 else if(e.getSource()==colour) {

layout_obj.show(panel_obj, "Colour"); 
} 
}//end for actionPerformed method }
}
//end of class