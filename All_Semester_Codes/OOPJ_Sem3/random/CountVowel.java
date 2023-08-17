
import java.io.*;
import java.util.Scanner;
public class CountVowel {
    public static void main(String[] args)
        throws IOException
    { 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to count no. of vowels present in it : ");
        String str= sc.nextLine();
        str = str.toLowerCase();
  
        // toCharArray() is used to convert 
        // string to char array
        char[] chars = str.toCharArray();
  
        int count = 0;
  
        for (int i = 0; i < str.length(); i++)
        {
            // check if char[i] is vowel
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e'
                || str.charAt(i) == 'i'
                || str.charAt(i) == 'o'
                || str.charAt(i) == 'u')
            {
                // count increments if there is vowel in
                // char[i]
                count++;
            }
        }
  
        // display total count of vowels in string
        System.out.println("Total no of vowels in string are: " + count);
    }
}