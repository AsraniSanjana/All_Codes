/*

//UTIL EXCEPTIONS USING SCANNER (IM)



//import java.io.*;  // if using buffered reader : numberformat exeception will be thrown.
//import java.lang.Exception;
import java.util.*;  // if using util.scanner : inputmismatch error will be shown.. no need to write throws IOException 


class MultiCatch 
{

public static void main(String args[]) 
{ int flag=0;
do{
 
Scanner in = new Scanner(System.in); 

 try 
{

System.out.print("Enter an int numerator : "); 
//String x = in.nextLine();
//int m =  Integer.parseInt(x); //(if Entered numerator is a integer , no exception will be thrown.) 
int m=in.nextInt();
System.out.print("Enter an int denominator : "); 
//String y = in.nextLine();// if we write similarly for both, we will always get numberformat exception.
//int n =  Integer.parseInt(y); //(if Entered denominator is a integer , no exception will be thrown.) 

int n = in.nextInt();

double z = m/n;   

//System.out.println(x+"/"+y+"="+z); 
System.out.println(m+"/"+n+"="+z); 
flag=1; 
} 

catch(ArithmeticException e) 
{   System.out.println(e + " Occured.");
  System.out.println("Denominator cant be zero.");

  }  

catch(InputMismatchException e1)   {  //thrown by scanner. it throws the InputMismatchException if expected datatype was int we entered string or double
System.out.println(e1 + " Occured.");
System.out.println("enter only numbers!");  
} 


 catch(NumberFormatException e2)   { // here this wont ever run
   // if we try to convert one datatype to other 
System.out.println(e2 + " Occured.");
System.out.println("cant convert an int to other datatype."); 


  }  


 

}while(flag==0);

 } 
//end of main() 
}//end of class


*/



// IOEXCEPTIONS USING BUFFERED READER (NF)



import java.io.*;
import java.util.InputMismatchException;



class MultiCatch
{

    public static void main(String args[])  throws IOException
    { int flag=0;
        do{

            BufferedReader inp= new BufferedReader (new InputStreamReader(System.in));
            try
            {

                System.out.print("Enter an int numerator : ");
                int n= Integer.parseInt(inp.readLine());

                System.out.print("Enter an int denominator : ");
                int d= Integer.parseInt(inp.readLine());


                double z = n/d;

                System.out.println(n+"/"+d+"="+z);
                flag=1;
            }

            catch(ArithmeticException e)
            {
                System.out.println(e + " Occured.");
                System.out.println("Denominator cant be zero.");
                System.out.print("Re-");


            }

            catch(InputMismatchException e1)   { // here this wont ever run
 //thrown by scanner. it throws the InputMismatchException if expected datatype was int we entered string or double
                System.out.println(e1 + " Occured.");
                System.out.println("enter only numbers!");
                System.out.print("Re-");
            }


            catch(NumberFormatException e2)   {    // if we try to convert one datatype to other
                System.out.println(e2 + " Occured.");
                System.out.println("Enter Only Integer Numbers . ");
                System.out.print("Re-");

            }




        }while(flag==0);

    }
//end of main() 
}//end of class