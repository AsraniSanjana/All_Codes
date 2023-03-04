import java.awt.*;  
class label1{  
public static void main(String args[]){  
    Frame f= new Frame("Program for label");  
    Label l1,l2;  
    //f.setLayout(new FlowLayout());
    l1=new Label("     ok");
    l2=new Label("     cancel");
    f.add(l1); f.add(l2);  
    f.setSize(400,400);   
    f.setVisible(true);  
    l1.setBackground(Color.pink);
    l2.setBackground(Color.red);
    f.setLayout(null);
    l1.setBounds(200,300,50,50);
    l2.setBounds(400,600,100,100);
    
}  
}