import java.applet.*;
import java.awt.*;

public class jokerface extends Applet{
public void paint(Graphics g)
{
Color customColor = new Color(144,238,144);
//g.setColor(customColor);
setBackground(customColor);

g.setColor(Color.darkGray);
g.fillOval(900,380,70,110);
g.fillOval(440,380,70,110);
g.setColor(Color.yellow);
g.fillOval(900,400,50,80);
g.fillOval(460,400,50,80);

//face
g.setColor(Color.white);
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
g.setColor(Color.green);
g.fillArc(647, 500, 120, 70, 0, -180);
// right triangle above eye
g.setColor(Color.black);
int x1[] = { 700+50,800+50,750+50 };
int y1[] = { 350,350,300};
g.drawPolygon(x1,y1,3);
g.fillPolygon (x1, y1, 3);
//left triangle above eye
g.setColor(Color.black);
int x2[] = { 700-150,800-150,750-150 };
int y2[] = { 350,350,300};
g.drawPolygon(x2,y2,3);
g.fillPolygon (x2, y2, 3);
//under eye triangles of joker .left below

g.setColor(Color.red);
int x3[] = { 700-150,800-150,750-150 };
int y3[] = { 350+65,350+65,400+65};
g.drawPolygon(x3,y3,3);
g.fillPolygon (x3, y3, 3);
//under eye triangles of joker .right below
g.setColor(Color.red);
int x4[] = { 700+50,800+50,750+50 };
int y4[] = { 350+65,350+65,400+65};
g.drawPolygon(x4,y4,3);
g.fillPolygon (x4, y4, 3);

Color mycolorpurple = new Color(128,0,128);
g.setColor(mycolorpurple);
//nose
g.drawOval(675,430,50,50);
g.fillOval(675,430,50,50);
//cap of joker
g.setColor(Color.blue);
int x[] = { 525,700,880 };
int y[] = { 250,100,250};
g.fillPolygon (x, y, 3);
//text
g.setColor(Color.black);
Font myFont = new Font("Courier", Font.BOLD | Font.ITALIC ,80);
g.setFont(myFont);
g.drawString("joker face", 150, 50);
}}