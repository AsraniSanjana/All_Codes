import java.util.Scanner;
public class SwitchCaseOperators{
    public static void main (String[]Args){
        Scanner s = new Scanner(System.in);
int n,m;
do
{
        System.out.println("Select 1 to perform arithmetic operations");
        System.out.println("Select 2 to perform assignment operations");
        System.out.println("Select 3 to perform relational operations");
        System.out.println("Select 4 to perform bitwise operations");
        System.out.println("Select 5 to perform logical operations");
        System.out.println("Select 6 to perform boolean operations");
        System.out.println("Select 7 to exit"); 
        System.out.println("enter your choice:"); 
 n = s.nextInt();
        switch(n)
{
 case 1: // ARITHMETIC OPERATION

        System.out.print("Enter first number: ");  
        int x= s.nextInt();
        System.out.print("Enter second number: ");  
        int y= s.nextInt();

    System.out.println("x + y =" + (x + y));
    System.out.println("x - y =" + (x - y));
    System.out.println("x * y =" + x * y);
    System.out.println("x / y =" + x / y);	
    System.out.println("x % y =" + x % y);
break;
 
case 2: // ASSIGNMENT OPERATORS
System.out.print("m= ");
 m= s.nextInt();
System.out.print("n= ");
 n= s.nextInt();
   
    System.out.println("n using +=: " +  (n+= m));  //  can be also written as var=var+x and  var+=x is shorthand assignment
    System.out.println("n using -=: " +  (n-= m));
    System.out.println("n using *=: " +   (n*= m));
    System.out.println("n using /=: " + (n/= m));
    n = m;
    System.out.println("m= " + n);
  break;

case 3:// RELATIONAL OPERATORS
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
break;

 case 4:// BITWISE OPERATORS
        System.out.print("Enter first num t:");
        int t = s.nextInt();
        System.out.print("Enter second num q:");
        int q = s.nextInt();
 System.out.println("t&q = " + (t & q)); // t=t&q or  t &= q;
        System.out.println("t|q = " + (t | q)); // bitwise or
   System.out.println("t^q = " + (t ^ q)); //   // bitwise xor
  System.out.println("~t = " + ~t);       // bitwise not
 
   // left shift <<
  System.out.println("t<<2:" + (t<<2));  // multiply t by 2

//right shift >>
 System.out.println("q>>2:" + (q>>2));   // divide q by 2 
break;


case 5: // LOGICAL OPERATORS 
  System.out.print("Enter first num t:");
        int d = s.nextInt();
        System.out.print("Enter second num q:");
        int e = s.nextInt();
     //   boolean var1 = (d&&e);     // nonzero integer is 1(true)
//System.out.println("d&&e=" + var1);  // will give true or false as output 
     //  boolean var2 = (d||e);
//System.out.println("d||e=" + var2);    
System.out.println("~d =" + (-d+1));  // tilde operator ~
                                            // negation operator !
break;
  case 6:// boolean operators

System.out.println("enter truth value of a, as in true or false");
boolean a1 = s.nextBoolean();
System.out.println("enter truth value of b");
        boolean b1 = s.nextBoolean();

        System.out.println("a = " + a1);
        System.out.println("b = " + b1);
        System.out.println("a|b = " + (a1 | b1));
        System.out.println("a&b = " + (a1 & b1));
        System.out.println("a^b = " + (a1 ^ b1));
        //System.out.println("!a&b|a&!b = " + (!a & b) | (a & !b));
        System.out.println("!a = " + !a1);
break; 
}}while(n!=7);
}}

