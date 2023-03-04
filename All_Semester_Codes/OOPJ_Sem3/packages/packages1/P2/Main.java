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

                                     //  ->or import p1.*

//dont import and write  .. extends p1.Rectangle






class Main{
public static void main(String []args){
Rectangle r=new Rectangle(5.5,7.5);
System.out.print("Area is : " +r.area());
Box b=new Box(1,2.5,3.7);
System.out.print("Volume is : "+ b.volume());
}}