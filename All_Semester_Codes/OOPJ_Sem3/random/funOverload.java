
import java.util.Scanner;
class AddMain
{ 
public static int addition(int x,int y)
{
	return x+y;
}
 public static double addition(double x,double y)
{
	return x+y;
}
 public static String addition(String s1,String s2)
{
	return s1+s2;
}


public static void main(String[] arg)
{
double c;
Scanner sc=new Scanner(System.in);
System.out.println("Enter first number");
double a=sc.nextDouble();
System.out.println("Enter second number");
double b =sc.nextDouble();
c=addition(a,b);

System.out.println(" Addition of two numbers is : "+c);
System.out.println("enter 2 strings to concatenate them:");
String s1=sc.nextLine();
System.out.println("enter 2nd string to concatenate :");
String s2=sc.nextLine();
System.out.println(addition(s1,s2));


}



}



/*
}

    String strTest = "100";
    int iTest = Integer.parseInt(strTest);
    System.out.println("Actual String:"+ strTest);
    System.out.println("Converted to Int:" + iTest);
    //This will now show some arithmetic operation
    System.out.println("Arithmetic Operation on Int: " + (iTest/4));
  }
} */