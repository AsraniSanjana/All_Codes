
abstract class Shape{

    Shape(){System.out.println("Shape is Created!");}   // a constructor in abstract class

    public static void trial(){ 
        System.out.println("non abstract and static  method!");
    }
    abstract  public void area();

    public void trial2(){
        System.out.println("non abstract , non static method");
    }

    static void trial3()
    {
        System.out.println(
                "Static , non-abstract method implemented.");
    }
   
}
class Rectangle extends Shape{
    static void shape1Rect()
    {
        System.out.println(
                "Static method in Rectangle implemented.");
    }

    public void area(){
        System.out.println("area func of rectangle!");
    }
}
class Circle extends Shape{
    public void area(){
        System.out.println("area func of circle!");
    }
}
class Triangle extends Shape{
    public void area(){
        System.out.println("area func of triangle!");
       
    }
}

public class ShapeAbstract {
    public static void main(String[] args) {
    
        Triangle obj1=new Triangle();
    obj1.area();
        Rectangle obj2=new Rectangle();
        obj2.area();
        Circle obj3=new Circle();
        obj3.area();
   
      Shape.trial(); //  trial is static
        Rectangle obj=new Rectangle();
         obj.trial2();
        
        Shape.trial3();
   Rectangle.shape1Rect();
Shape obj9 = new Shape();
        
    }
}

/*
import java.io.*;
 
// super-class A
abstract class A {
 
    // abstract static method func
    // it has no body
    abstract static void func();
}
 
// subclass class B
class B extends A {
 
    // class B must override func() method
    static void func()
    {
        System.out.println(
            "Static abstract"
            + " method implemented.");
    }
}
 
// Driver class
public class ShapeAbstract {
    public static void main(String args[])
    {
 
        // Calling the abstract
        // static method func()
        B.func();
    }
}
*/
/*
// THEORY

    Abstraction is a process of hiding the implementation details and showing only functionality to the user.

There are two ways to achieve abstraction in java

1.Abstract class
1.1.An abstract class must be declared with an abstract keyword.
1.2.It needs to be extended and its method implemented.
1.3.It can have abstract and non-abstract methods.
1.4.It cannot be instantiated.
1.5.It can have constructors and static methods also(function call: classname.functionname)
1.6.It can have final methods which will force the subclass not to change the body of the method.

2.Interface










 */