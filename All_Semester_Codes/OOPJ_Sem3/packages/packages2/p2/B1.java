// without importing the package p1
// packagename or foldername .classname 
package p2;


public class B1
{
  public static void main(String args[])
  { 
  p1.A obj=new p1.A();
obj.display();
  }
}
/*
// commands will be 
javac p1\A.java
javac p2\B1.java
java p2.B
*/