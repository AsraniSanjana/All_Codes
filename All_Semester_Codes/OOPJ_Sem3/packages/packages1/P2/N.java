package P2;
import p1.*;
import java.util.*;

public class N
{
  public static void main(String args[])
  { 
    int e1,e2;
    Scanner input = new Scanner(System.in);
    System.out.println("Enter e1 : ");
    e1=input.nextInt();

    System.out.println("Enter e2 : ");
    e2=input.nextInt();

   
    A obj = new A();
   // obj.swap(e1,e2);

A.swap(e1,e2);
  }
}