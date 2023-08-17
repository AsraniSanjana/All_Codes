class MySuper
{
public static void MyMethod()
{
System.out.println("Static Method in super class.");
}
}
public class Mysub extends MySuper{
public static void MyMethod()
{
System.out.println("static method in subclass.");
}
public void MyMethod()
{
System.out.println("Non-static method in subclass");
}
public static void main(String args[]){
MySuper s=new MySuper();
MyMethod();
}
}


