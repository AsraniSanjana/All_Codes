import java.util.*;
class StringReplace {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
     System.out.println("Enter a string : ");
      String message = input.nextLine();
      String replace = message.replaceAll("an", " the ");
      System.out.println("String after replacing all 'an' with 'the' ....");
 System.out.println(replace);
    }}