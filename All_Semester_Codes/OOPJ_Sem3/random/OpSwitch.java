import java.util.Scanner;
public class OpSwitch
{
   public static void main(String args[])
   {   
        Scanner s = new Scanner(System.in);
        while(true)
        {
            System.out.println("");
            System.out.println("Enter the two numbers to perform operations ");
            System.out.print("Enter the first number : ");
            int x = s.nextInt();
            System.out.print("Enter the second number : ");
            int y = s.nextInt();
           



            System.out.println("Choose the operation you want to perform ");  //: arithmetic operators
                                                                              //  : relational operators
                                                                              //        : boolean operators
                                                                              //        :logical operators
                                                                              //        :bitwise operators
                                                                              //        : increment decrement operators  
            System.out.println("Choose 1 for ADDITION");
            System.out.println("Choose 2 for SUBTRACTION");
            System.out.println("Choose 3 for MULTIPLICATION");
            System.out.println("Choose 4 for DIVISION");
            System.out.println("Choose 5 for MODULUS");

            System.out.println("Choose 6 for relational operator ");
            System.out.println("Choose 7 for boolean operator ");
            System.out.println("Choose 8 for increment decrement operator ");

            System.out.println("Choose 9 bitwise operator");
  System.out.println("Choose 10 to exit");
     


            int n = s.nextInt();
            switch(n)
            {
                case 1:
                int add;
                add = x + y;
                System.out.println("Result : "+add);
                break;
 
                case 2:
                int sub;
                sub = x - y;
                System.out.println("Result : "+sub);
                break;
 
                case 3:
                int mul;
                mul = x * y;
                System.out.println("Result : "+mul);
                break;
 
                case 4:
                float div;
                div = (float) x / y;
                System.out.print("Result : "+div);
                break;
 
                case 5:
                int mod;               
                mod = x % y;
                System.out.println("Result : "+mod);
                break;
                   


          case 6:  // relational operators
         System.out.println("x == y : " + (x == y) );
         System.out.println("x != y : " + (x != y) );
         System.out.println("x > y : " + (x > y) );
         System.out.println("x < y : " + (x < y) );
         System.out.println("y >= x : " + (y >= x) );
         System.out.println("x <= y : " + (x <= y) );
break;


        case 7:// boolean operators
System.out.println("enter truth value of a");
boolean a = s.nextBoolean();
System.out.println("enter trut value of b");
        boolean b = s.nextBoolean();

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a|b = " + a | b);
        System.out.println("a&b = " + a & b);
        System.out.println("a^b = " + a ^ b);
        System.out.println("!a&b|a&!b = " + (!a & b) | (a & !b));
        System.out.println("!a = " + !a);
break;



 
                case 8: // increment decrement operators
             int  d,e;
       
        System.out.print("Enter any integer d:");
        d = s.nextInt();
 
        System.out.print("Enter any integer d:");
        e = s.nextInt();
     
        System.out.println("Result after Increment d:" + ++d);
        System.out.println("Result after decrement e:" + --e);
        
case 9: // bitwise operations
while(true)
        {
            System.out.println("");
            System.out.println("Press 1 for Right Shift >> by 2:");
            System.out.println("Press 2 for Left Shift << by 2:");
            System.out.println("Press 3 for Bitwise AND & :");
            System.out.println("Press 4 for Bitwise OR by 2:");
            System.out.println("Press 5 for Bitwise Exclusive OR:");
            System.out.println("Press 6 for Bitwise NOT:");
            System.out.println("Press 7 to Exit:");
            System.out.println("");
System.out.print("Enter First number:");
        m = s.nextInt();
        System.out.print("Enter Second number:");
        n = s.nextInt();
            System.out.print("Option:");
            x = s.nextInt();

           while(true)
        {
            System.out.println("");
            System.out.println("Press 1 for Right Shift by 2:");
            System.out.println("Press 2 for Left Shift by 2:");
            System.out.println("Press 3 for Bitwise AND:");
            System.out.println("Press 4 for Bitwise OR by 2:");
            System.out.println("Press 5 for Bitwise Exclusive OR:");
            System.out.println("Press 6 for Bitwise NOT:");
            System.out.println("Press 7 to Exit:");
            System.out.println("");
            System.out.print("Option:");
            x = s.nextInt();
            switch(x)
            {
                case 1:
                a = m << 2;
                System.out.println("Result after left shift by 2:"+a);
                break;
 
                case 2:
                a = n >> 2;
                System.out.println("Result after right shift by 2:"+a);   
                break;
 
                case 3:
                a = m & n;
                System.out.println("Result after bitwise AND:"+a);  
                break;
 
                case 4:  
                a = m | n;
                System.out.println("Result after bitwise OR:"+a);
                break;
 
                case 5:
                a = m ^ n;
                System.out.println("Result after bitwise Exclusive OR:"+a);
                break;    
 
                case 6:
                a = ~ m;
                System.out.println("Result after bitwise NOT:"+a);
                break;    
 
                case 7:
                System.exit(0);
            }
     
            }
               break;
   break;

}
  }      }
    }
}