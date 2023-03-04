import java.awt.*;  
class labelbutton{  
public static void main(String args[]){  
    Frame f= new Frame("Program for label button");  
    Button l1,l2;  
    f.setLayout(new FlowLayout());
    l1=new Button("ok");
    l1.setBackground(Color.pink);
    l2=new Button("cancel");
    l2.setBackground(Color.pink);
    f.add(l1); f.add(l2);  
    f.setSize(400,400);   
    f.setVisible(true);  
}  
}