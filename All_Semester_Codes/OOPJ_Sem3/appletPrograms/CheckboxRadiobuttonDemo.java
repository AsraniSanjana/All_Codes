import java.awt.*;  
class CheckboxRadiobuttonDemo{  
public static void main(String args[]){  
    Frame f= new Frame("Program for checkbox");  
    Checkbox c1,c2,c3;  
    f.setLayout(new FlowLayout());
    CheckboxGroup c=new CheckboxGroup();
    c1=new Checkbox("candy",c,true);   // candy will be already selected when applet window opens
    c2=new Checkbox("icecream",c,false);
    c3=new Checkbox("juice",c,false);
    f.add(c1); f.add(c2); f.add(c3);  
    f.setSize(400,400);   
    f.setVisible(true);  
}  
}