// working of different types of operators 
import java.util.Scanner;

public class Operators{
    public static void main (String[]Args){
        Scanner input = new Scanner(System.in);
        int x,y;
       char op;
op=input.next().charAt(0);
        
            System.out.print("Enter first number: ");  int a = input.nextInt();
            System.out.print("Enter second number: ");  int b= input.nextInt();

        System.out.println("Select an operator +,-,*,/");
              // ARITHMETIC OPERATORS
        switch(op){
            case '+': 
              System.out.println("a + b =" + (a + b));
  break;
    case '-':
    System.out.println("a - b = " + (a - b) );
break;
     case '*':
    System.out.println("a * b = " + a * b);
break;
     case '/':
    System.out.println("a / b = " + a / b);	
break;

     case '%':
    System.out.println("a % b = " + a % b);
break;

}






  /* ASSIGNMENT OPERATORS 

System.out.print("Enter x to assign it to variable var");

 x= input.nextInt();
 case '=' :    var = x;
    System.out.println("var= " + var);
break;
     case '+=' : var += x;  //  can be also written as var=var+x; 
                          break;  // var+=x; is shorthand assignment
    System.out.println("var using +=: " + var);
case '-=' : var -= x;  // var=var-x;
break;
    System.out.println("var using -=: " + var);
  break;
      case '*=' : var *= x;
    System.out.println("var using *=: " + var);
break;
  case '/=' :  var /= x;
    System.out.println("var using /=: " + var);
break;  */











   /* RELATIONAL OPERATORS
System.out.println("a is " + a + " and b is " + b);

    case '==' :
    System.out.println(a == b);  
break;
       case '!=' :
    System.out.println(a != b); 
break;
       case '>' :
    System.out.println(a > b);  
break;
     case '<' :
    System.out.println(a < b); 
break;
     case '>=' :
    System.out.println(a >= b); 
break;
         case '<=' :
    System.out.println(a <= b);  
break;
*/











 /*
// LOGICAL OPERATORS
case'&&':

break;
 
   case'||':

break;

case'!':

   
break;
*/







 /*  
// INCREMENT AND DECREMENT OPERATOR
System.out.print("Enter a value for x");
System.out.print("Enter a value for y");

 // increment operator
    
    System.out.println("++y=" + (++y));
break;
 // decrement operator

    System.out.println("--y=" + (--y));
   break;
*/
/*

   // BITWISE OPERATORS
 System.out.println("a&b = " + (a & b)); // a=a&b or  a &= b;
 
      case '|' :  // bitwise or
        
        System.out.println("a|b = " + (a | b));
break;
    case '^' :// bitwise xor
        
       
        System.out.println("a^b = " + (a ^ b));
 break;
    case '~' :     // bitwise not
       
        System.out.println("~a = " + ~a);
 break;
*/
  }
}
