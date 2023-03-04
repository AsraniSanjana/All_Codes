import javax.swing. *;
import java.awt.*;
import java.awt.event.*;
 

class LoginFrame extends JFrame implements ActionListener {
JLabel label1, label2, label3, label4, label5;
JTextField t1, t2;
JTextArea ta1;
JButton ok, clear;
JTextArea screen;
LoginFrame() {
setTitle("Login Page");
setSize(300, 380);
setLocationRelativeTo(null);
setDefaultCloseOperation (EXIT_ON_CLOSE);
Container c = getContentPane();
c.setLayout(null);
label1=new JLabel("Username");
label1.setBounds (20,50, 100, 20);
c.add(label1);
t1=new JTextField();
t1.setBounds (130, 50, 100, 20);
c.add(t1);
label2=new JLabel("Password");
label2.setBounds (20,100,100,20);
c.add(label2);
t2=new JTextField();
t2.setBounds (130, 100, 100, 20);
c.add(t2);
//t2.setEchoChar('#');

	
	
	
screen=new JTextArea();
screen.setBounds(100,250,200,350);
c.add(screen);

c.setBackground(Color.GREEN);
clear=new JButton("RESET");
clear.setBounds(100,200,80,20);
c.add(clear);

ok=new JButton("OK");
ok.setBounds(100,150,80,20);
c.add(ok);


ok.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
String username = t1.getText();
String password = t2.getText();

screen.setText("Username : "+ username + "\n Password :" + password);
}
});
setVisible(true);
clear.addActionListener(new ActionListener() {
public void actionPerformed (ActionEvent e) {
t1.setText("");
t2.setText("");

screen.setText("");
}
});
setVisible(true);
}

public void actionPerformed (ActionEvent e) {}
}
class LoginForm {
public static void main(String args[]) {
LoginFrame frame = new LoginFrame();
}
}




