import java.awt.*;  
class label{  
public static void main(String args[]){  
    Frame f= new Frame("Program for label");    // heading
     // applets mei showstatus mei footer hota h 
    Label l1,l2;  
    f.setLayout(new FlowLayout());  // center aligned labels
    l1=new Label("ok");
    l2=new Label("cancel");
    f.add(l1); 
    f.add(l2);  
    f.setSize(400,400);   // size of the label box
    f.setVisible(true);  
}  
}