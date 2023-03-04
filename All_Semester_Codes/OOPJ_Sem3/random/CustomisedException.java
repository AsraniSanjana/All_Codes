import java.io.*;
import java.lang.Exception;
//2.2. userdefined exceptions

class MyException extends Exception{
public String toString()
{return " Some Exception Occured";
}
} 
class CustomisedException {
public static void main(String args[]) throws IOException{

InputStreamReader isr= new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(isr);


System.out.println("Enter a number");
int a=Integer.parseInt(br.readLine());


try{


if (true) {throw new MyException();}


}  // try block ends here




catch(MyException e)
{ if (a==0)
{System.out.println(e);  // will print the return statement wali string
System.out.print("java.lang.ArithmeticException:/ by zero Caught");}
else if(a==1)
{System.out.println(e);
System.out.print("java.lang.NullPointerException Caught");}
else{
System.out.print("no Exception Caught");

}

}


}}



// 1.ARRAY ONE
/*System.out.print("\nEnter the number of elements you want to store in the array: "); 
int n=Integer.parseInt(br.readLine());

int[] array = new int[10];  
System.out.println("Enter the elements of the array: ");  

try{
for(int i=0; i<n; i++)  
{  
array[i]=Integer.parseInt(br.readLine());  
}  

}


catch(NumberFormatException e){  // catch(Exception e) works too // InputMismatchException doesnt work
 
System.out.println("You entered bad data. ");

} 
int sum=0;
   for (int j = 0; j < array.length; j++) {  
           sum = sum + array[j];  
        }  
        System.out.println("Sum of all the elements of an array: " + sum);  

*/







