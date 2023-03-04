import java.applet.*;
import java.awt.*;

public class ParameterTest extends Applet {

   public void paint(Graphics g) {
      setBackground(Color.gray);

      String str   = getParameter("font");
      String myString = getParameter("string");
      int mySize      = Integer.parseInt(getParameter("mySize"));
      
      Font f = new Font(str, Font.BOLD, mySize);
      g.setFont(f);
      g.setColor(Color.blue);
      g.drawString(myString, 80, 80);
      
    }
}
/*
<HTML> 
<HEAD> 
<TITLE>Java applet example - Passing applet parameters to Java applets</TITLE> 
</HEAD> 
<BODY> 
<APPLET CODE="ParameterTest" WIDTH="400" HEIGHT="50">
    <PARAM NAME="font"    VALUE="Dialog">
    <PARAM NAME="mySize"    VALUE="30">
    <PARAM NAME="string"  VALUE="I am Sakshi Bhojwani from D7B ">
    
</APPLET> 
</BODY> 
</HTML>*/