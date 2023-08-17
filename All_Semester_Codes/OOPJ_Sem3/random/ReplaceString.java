import java.util.*;
public class ReplaceString{
  public static void main(String[] args) {
    Scanner input=new Scanner(System.in);
    System.out.print("Input the String : ");
    String str=input.nextLine();
    System.out.print("Input the String/Character you want to replace : ");
    //char c = input.next().charAt(0);
   String c = input.nextLine();
    System.out.print("Input the String/Character you want ' " + c +  " ' to be replaced with : ");
    //char r = input.next().charAt(0);
      String r = input.nextLine();
    
       System.out.println("String Before : " + str);

        String replacedstring=str.replace(c, r);
        System.out.println("String after replacement : " + replacedstring);
        
      }
}