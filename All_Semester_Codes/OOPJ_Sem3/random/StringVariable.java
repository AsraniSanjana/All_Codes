import java.io.*;
import java.lang.*;
import java.util.Scanner; 

 
class StringVariable {
    public static void main(String[] args)
    {   Scanner sc = new Scanner(System.in);
        System.out.println("enter a string : ");
        String s1 = sc.nextLine();
        String s2 = new String(s1);
 
        // Prints the String.
        System.out.println("string u entered is : " + s2);
 

    }
}