
 
import java.awt.*;
import java.awt.event.*;


import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.applet.*;
import java.awt.*;
public class LoginApplet extends Applet implements ActionListener{
TextField t1,t2,t3;
Label l1,l2,l3,messageLabel;
Button b1,b2;
public void init(){
   
    Frame f=new Frame("");
    f.setSize(700,700);
    f.setVisible(true);
    l1=new Label("Enter your Username : " );
    t1=new TextField(20);
    
    
    l2=new Label("Enter your Password : " );
    t2=new TextField(20);
    //t2.setEchoChar('*');
    
        l1.setBounds(50,100,150,25);
        t1.setBounds(225,100,300,25);
        l2.setBounds(50,150,150,25);
		t2.setBounds(225,150,300,25);
		
		f.add(l1);
		f.add(t1);
		f.add(l2);
        f.add(t2);
        
    Label messageLabel = new Label();
    messageLabel.setBounds(125,400,400,35);
    f.add(messageLabel);
    
        
    b1=new Button("Login");
    b1.setBounds(125,200,100,25);
    f.add(b1);
    b1.addActionListener(this);
    

    
    b2 = new Button("Reset");
    b2.setBounds(150,200,200,25);
    f.add(b2);
    b2.addActionListener(this);
   
    l3=new Label("Please Login.");
    f.add(l3);
    
   
    t3=new TextField(20);
    f.add(t3);
    
    
		
	
		
}
public void actionPerformed(ActionEvent event){
    
    		if(event.getSource()==b2) {// if reset was pressed
			t1.setText(" " );
			t2.setText(" ");
			t3.setText(" ");
		}
		
		
    if(event.getSource()==b1){ // if b1 was pressed
        if((t1.getText().equals("sanjana") && (t2.getText().equals("sanju"))) ||
           (t1.getText().equals("amrita") && (t2.getText().equals("amu"))) ||
           (t1.getText().equals("vanita") && (t2.getText().equals("vani")))) {
        l3.setText("Login Successfull!");
        t3.setText("Welcome " + t1.getText());
                    /*messageLabel.setForeground(Color.green);
					messageLabel.setText("Login successful");
					messageLabel.setText("Hello "+t1.getText());
					*/
				//g.drawString("merci beaucoop!Q!", 300, 300);
                  }
					
				
    
    else {
        //messageLabel.setForeground(Color.red);
		//messageLabel.setText("Wrong password");
        l3.setText("Login Failed!");
    }
    
} }}
    