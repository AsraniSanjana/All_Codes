import java.io.*;
import java.lang.Exception;
// MULTIPLE EXCEPTIONS , ONE TRY-CATCH
// these all exceptions u should try in 1 program
/* number format,arithmetic(divide by zero), null pointer,arrayoutofboundexception,negativeindexofarray(its of cmd ig),stringindexoutofbound

class ExceptionHandling {
public static void main(String args[]) throws IOException{

InputStreamReader isr= new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(isr);


int flag=0;

do{
System.out.println("Enter integers a,b,c to calculate x=sqrt(a/(b-c))");
System.out.println("Enter a");
int a=Integer.parseInt(br.readLine());
System.out.println("Enter b");
int b=Integer.parseInt(br.readLine());
System.out.println("Enter c");
int c=Integer.parseInt(br.readLine());


try{

double x=Math.sqrt(a/(b-c));

flag=1;  // koi exception ni aya hoga tabhi hi toh yahan ayega 
System.out.println("The value of x is " + x);  

//else {
//throw new MyException();}

}  // try block ends here



catch(Exception e){

 if (b-c==0 && a==0 )
{ System.out.println(e);
System.out.print("0/0 is indeterminate form, please Re-");}

else if (b-c ==0)
{
System.out.println(e);
System.out.print("cant divide by zero, please Re-"); }

/*  root of a negative no. doesnt throw an exception , its value is Nan
else if ((a/(b-c))<0)

{System.out.println(e);
System.out.print("Cant take root of a negative number, please Re-"); }
*/
/*  number format exception generate karne ki koshish nakam since input is not inside try block.
else if( (a>=-32768 && a<=32767) ==false) 
{ System.out.println(e);
System.out.print("Dont enter alphabets or symbols, please Re-");}
*/


}  // catch ends here
}while(flag==0);


}}
/*


// 1.ARRAY ONE
System.out.print("\nEnter the number of elements you want to store in the array: "); 
int n=Integer.parseInt(br.readLine());

int[] array = new int[10];  
System.out.println("Enter the elements of the array: ");  

try{
for(int i=0; i<n; i++)  
{  
array[i]=Integer.parseInt(br.readLine());  
}  

}


catch(Exception e){  // catch(NumberFormatException e) works too // InputMismatchException doesnt work
 
System.out.println("You entered bad data. ");

} 
int sum=0;
   for (int j = 0; j < array.length; j++) {  
           sum = sum + array[j];  
        }  
        System.out.println("Sum of all the elements of an array: " + sum);  
}}


*/



