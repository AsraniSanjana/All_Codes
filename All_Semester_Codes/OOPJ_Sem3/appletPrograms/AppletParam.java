import java.awt.*;
import java.applet.*;
public class AppletParam extends Applet 
{
	String n,d,r;
	
	public void init()
	{
		n = getParameter("name");
		d = getParameter("div");
		r = getParameter("rollno");
	}
	public void paint(Graphics g)
	{
		g.drawString("Name is: " + n, 20, 20);
		g.drawString("Div is: " + d, 20, 40);
		g.drawString("Rollno. is: " + r, 20, 60);
	}
}
/*
	<applet code="MyApplet" height="300" width="500">
		<param name="name" value="Ramesh" />
		<param name="age" value="25" />
	</applet>
*/