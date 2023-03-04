//APPLETS
/* CREATING APPLETS
awt-->Abstract Winodwing Toolkit
*/

import java.awt.*;     //Graphical features
import java.applet.*;  //because we are extending applet

/* <applet
   code="FirstApplet"
   width=300
   height=300>
   </applet>*/

public class FirstApplet extends Applet
{
  public void paint(Graphics g)
   {
      g.drawString("HelloWorld", 10,20);
   }
}