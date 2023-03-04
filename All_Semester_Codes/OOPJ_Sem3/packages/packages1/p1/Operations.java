/*
Develop a class OPerations that defines methods add(),subtract(),multiply(),divide().put this class into a package p1.import this class into anotehr file in some other 
package p1.import thsi  class into another file in some other package p2.write a main() method within a class into another file in package p2 to demonstrate 
the method of the imported class
*/





package p1;
public class Operations{
public static double add(double x,double y)
{
return (x+y);
}
public static double subtract(double x,double y)
{
return (x-y);
}
public static double multiply(double x,double y)
{
return (x*y);
}
public static double divide(double x,double y)
{
return (x/y);
}



}

/*
package P2;
import p1.Operations;
class Demo
{
public static void main(String args[])
{
System.out.println("Addition = " + Operations.add(5.5,6.5);
System.out.println("Subtraction = " + Operations.subtract(3.5,2.5);
System.out.println("Multiplication = " + Operations.multiply(5.3,6.5);
System.out.println("Division = " + Operations.divide(2.0,6.8);
}
}

*/