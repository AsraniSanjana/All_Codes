package p1;// p1 is the name of the folder class A is in

public class A
{
  public void display(){

 System.out.println("class A ");

}

}

/*

package p2;
import p1.*; // import p1.A;
import java.util.*;

public class B
{
  public static void main(String args[])
  { 
  A obj=new A();
obj.display();
  }
}


package p2;


public class B1
{
  public static void main(String args[])
  { 
  p1.A obj=new p1.A();
obj.display();
  }
}


// commands to run 

javac p1\A.java
javac p2\B.java
java p2.B
*/