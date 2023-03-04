// wajp to demonstrate passing parameters to applets
import java.awt.*;
import java.applet.*;
/*
 <applet 
 code="paramtest"
 width=400
 heigth=400>
 <PARAM NAME=ename VALUE = ABC>
 <PARAM NAME = ecode VALUE=123>
 </applet>
 */

public class paramtest extends Applet
{
    String s1,s2;
    int c;
    public void init()
    {
        setBackground(Color.black);
        setForeground(Color.green);
    }
    public void start()
    {
        s1=getParameter("ename");
        if(s1==null)
        s1="not found";
        s2=getParameter("ecode");
        if(s2!=null)
        c=Integer.parseInt(s2);
    }
    public void paint(Graphics g)
    {
        g.drawString("Employee name: " + s1,20,40);
        g.drawString("Employee code: " + c,20,60);
        showStatus("passing parameters to applet");
    }}
        
        
        
        
        
        
        
        
        
        
        
        
        