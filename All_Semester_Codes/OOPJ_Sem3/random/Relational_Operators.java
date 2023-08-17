/*							
import java.util.*;
class ArithmeticOp
{
    public static void main(String args[])
    {
	int num1,num2;
        double output=0;
	char operator;
        Scanner sc=new Scanner(System.in);
	System.out.println("Enter num1 operator num2");
	num1=sc.nextInt();
     	operator=sc.next().charAt(0);
      num2=sc.nextInt();
        switch(operator)
	{
		case '+': 
			output=num1+num2;
			break;
		case '-':
			output=num1-num2;
			break;
		case '*':
			output=num1*num2;
			break;
		case '/':
			output=num1/num2;
			break;
		case '%':
			output=num1%num2;
			break;
                



		default :
			System.out.println("invalid operation");
			break;
	}
	System.out.println("The Output Is:"+output);
   }
}
*/

import java.util.Scanner;
public class Relational_Operators 
{
    public static void main(String args[]) 
    {
        Scanner s= new Scanner(System.in);
        System.out.print("Enter first integer:");
        int a = s.nextInt();
        System.out.print("Enter second integer:");
        int b = s.nextInt();
        System.out.println("a == b : " + (a == b) );
        System.out.println("a != b : " + (a != b) );
        System.out.println("a > b : " + (a > b) );
        System.out.println("a < b : " + (a < b) );
        System.out.println("b >= a : " + (b >= a) );
        System.out.println("b <= a : " + (b <= a) );
    }
}