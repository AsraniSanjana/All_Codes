
import  java.applet.*;
import  java.awt.*;


  public class face extends Applet{
    
public void paint(Graphics g)
  {
Color customColor = new Color(10,100,255);
                g.setColor(customColor);
setBackground(Color.white);




g.setColor(Color.darkGray);
g.fillOval(900,380,70,110);
g.fillOval(440,380,70,110);

g.setColor(Color.yellow);
g.fillOval(900,400,50,80);
g.fillOval(460,400,50,80);


   //face
g.setColor(Color.blue);
g.fillOval(480,200,450,450);

//eye
g.setColor(Color.white);
 g.fillOval(750, 300, 100, 120);
g.fillOval(550, 300, 100, 120);



//undereye
g.setColor(Color.black);
g.fillOval(770, 340, 60, 75);
g.fillOval(570, 340, 60, 75);

//lens
g.setColor(Color.lightGray);
g.fillOval(790, 370, 20, 25);
g.fillOval(590, 370, 20, 25);

//g.setColor(Color.magenta);
//g.fillArc(550, 300, 85, 120, 280, 160);
//g.fillArc(550, 300, 85, 120, 280, 160);

g.setColor(Color.pink);
 g.fillArc(660, 500, 95, 95, 0, 180);
g.fillArc(647, 500, 120, 70, 0, -180);

//nose
//g.drawArc(680, 300, 150, 90, 90, 180);


//eyebro
g.setColor(Color.pink);
g.drawArc(752, 282, 95, 95, 0, 180);
g.drawArc(552, 282, 95, 95, 0, 180);

//lipslower
//g.setColor(Color.red);
 //g.fillArc(900, 400, 95, 95, 0, -180);

//cap of joker

g.setColor(Color.red);
int x[] = { 525,700,880,250 };
    int y[] = { 250,100,250,250};
g.fillPolygon (x, y, 4);

//text
g.setColor(Color.green);
//color myFont[]=new color(color.red,color.green,color.blue,color.yellow,color.pink,color.orange,color.magenta);
  Font myFont = new Font("Courier", Font.BOLD | Font.ITALIC ,80);

//for(i=0;i<c.length;i++)
              
                g.setFont(myFont);
              
                g.drawString("Joker face", 350, 50);

/*g.setColor(Color.green);
int p[] = { 6255,900,950, };
    int q[] = { 450,100,250,850};
g.fillPolygon (p, q, 4);*/

             

}
public void update()
{}
}