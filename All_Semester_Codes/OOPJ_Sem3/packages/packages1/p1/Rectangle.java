/* create a superclass rectangle that contains length and width as instance variables. keep this class in a file within a package names as p1.
from this class extend a class named as box taht has additional data members depth. keep this class in package p2 . the methods o fthe superclass rectangle
should consists of constructor and area() . the subclass box should have constructor and volume(). wap showing calls to all the methods.
*/
// inheritance mei kbhi b protected hi rakh

package p1;
public class Rectangle
{
protected double length,width;
public Rectangle (double l,double w){
length=l;
width=w;// or this.width=width
}
public double area(){
return (length*width);
}}

/*
package p2;
import p1.Rectangle;
class Box extends Rectangle{
double depth;
Box (double l,double w, double d){
super(l,w);
depth=d;
}
double volume(){
return length*width*depth;
}}

// import karenge toh extends Rectangle-> either import p1.Rectangle  // packagename.classname 

                                       ->or import p1.*

//dont import and write  .. extends p1.Rectangle






class Main{
public static void main(Strings []args){
Rectangle r=new Rectangle(5.5,7.5);
Sytem.out.print("Area is : " +r.area());
Box b=new Box(1,2.5,3.7);
System.out.print("Volume is : " b.volume());
}}

*/
