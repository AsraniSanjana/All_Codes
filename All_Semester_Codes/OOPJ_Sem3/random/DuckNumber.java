/*

import java.util.*;   
import java.io.*;   
import java.util.Scanner;  
  

public class DuckNumber{  
  
   public static boolean checkNumber(int number) {  
  
        
      while(number != 0) {  
  
         // check whether the last digit of the number is zero or not  
         if(number%10 == 0)  
            return true;    //returns true if the number is Duck  
  
         // divide the number by 10 to remove the last digit  
         number = number / 10;  
      }  
  
      return false; //return false if the number is not Duck  
   }  
     
    public static void main(String args[])   
    {     
        int n1;  
          
        Scanner sc=new Scanner(System.in);  
          
        System.out.print("Enter a number to check if its duck number or not : ");  
          
        n1 = sc.nextInt();  
 System.out.println();
      if (checkNumber(n1))   

            System.out.println(n1 + " is a Duck number");   
        else  
            System.out.println(n1 + " is not a Duck number");   
       
    }  
}  

*/

import java.util.Scanner;

public class DuckNumber
  {

    public static void main(String args[])
       {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a number : ");
        String nstr = sc.nextLine();
 
        int l = nstr.length();  
        int ctr = 0;  
        char chr;
 
        for(int i=1;i<l;i++)
        {
            chr = nstr.charAt(i); 
            if(chr=='0')
                ctr++;
        }
 
        char f = nstr.charAt(0); 
 
        if(ctr>0 && f!='0')
            System.out.println("Duck number");
        else
            System.out.println("Not a duck number");
    }
}
