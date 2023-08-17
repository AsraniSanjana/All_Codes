import java.io.*; 
import java.util.Scanner; 
  
public class EvenOddArraySum
{ 
    
    public static void main(String[] args) 
    { 
        Scanner sc=new Scanner(System.in);
        
        int n;    
        System.out.println("Enter the size of the array: ");
        n=sc.nextInt();   
        
        int arr[]=new int[n];  
        System.out.println("Enter the array elements: ");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();  
        }
        System.out.println("The Even Elements are...");
        printEven(arr,n);    
        
        System.out.println(" ");
        System.out.println("The Odd Elements are...");
        printOdd(arr,n);   
           
    } 
    
    
    static void printEven(int arr[], int n)
    { int sumEven=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]%2==0)
            {
                System.out.print(arr[i]+" ");
                sumEven+=arr[i];
               
            }
        } System.out.println("sum of all the even elements is :  " + sumEven);
    }
    
  
    static void printOdd(int arr[], int n)
    { int sumOdd=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]%2!=0)
            {
                System.out.print(arr[i]+" ");
                sumOdd+=arr[i];
            }
        }  System.out.println("sum of all the even elements is :  " + sumOdd);
    }
}