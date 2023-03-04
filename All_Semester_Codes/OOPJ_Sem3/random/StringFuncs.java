
public class StringFuncs{
public static void main(String[] args) {   

// creating a string using default constructor string()
char array1name[]= {'s','t','y','l','e','s'};
String str1 = new String(array1name);       // str1 will have styles now
System.out.println(str1);

// creating a substring from the char array
String str2= new String(array1name,1,3); // starting from index1, have 3 characters  : in total 3 characters
System.out.println(str2); 

String str3 =new String();       // pass something here to initialze str3 with it 
str3=str1; // str3 will have styles now
System.out.println(str3); 

  String s5 = "Count me";
        System.out.println(s5.length()); // counts the length i.e. no. of characters in the string including the space between the letters
       

// string concatenation
int Rollno=01;
String Firstname="Sanjana";
String Lastname="Asrani";
String Fullname=Rollno + " " + Firstname + " " + Lastname;
System.out.println(Fullname); 

 // character or substring extraction
        String s1 = "FALlingStars";
        System.out.println(s1.charAt(2));  // to access certain character from a string
        char temp[]=new char[10];
        s1.getChars(3,7,temp,3); // 7-3=4 characters to be extracted from string s1 starting from index3, stored into string temp from index 3
        System.out.println(temp);

// STRING COMPARISON

  String s2 = "java";
        System.out.println(s2.equalsIgnoreCase("JaVa"));  // equals will check if both the strings i.e. one in parameter and other which is used to call are equal or not
                                                          // equalsIgnoreCase will give true if the two strings are palindromes , doesnt matter if some characters are uppercase or lowe.


String s3 = "AmriTa";
        System.out.println(s3.equals("amrita"));

// to compare parts of strings
boolean y;
String string1 = "honEy";
String string2 = "kidney";
y=string1.regionMatches(2,string2,2,3);  // part of string1 beginning form index2 is compared with part of string2 beginning from index 2 , 3 characters
System.out.println(y);

System.out.println(s1.regionMatches(true,2,string2,0,3));  // the true here means equalsignore case : uppercase A and lowercase a are equal

System.out.println(string1.startsWith("prog"));
System.out.println("programming".startsWith("prog"));   
System.out.println("programming".endsWith("Ming"));    // uppercase and lowercase are not equal;


System.out.println("there".compareTo("their"));
System.out.println(string1.compareTo(string2));


//SEARCH STRINGS
 String s4="StudyTonight";
        System.out.println(s4.indexOf('u'));   //returns the index within this string of the first occurrence of the specified character.
        System.out.println(s4.indexOf('t', 3));    // returns the index within this string of the first occurrence of the specified character, starting the search at the specified index.
        String subString="Ton";
        System.out.println(s4.indexOf(subString)); //returns the index within this string of the first occurrence of the specified substring.
        System.out.println(s4.indexOf(subString,7));   // returns the index within this string of the first occurrence of the specified substring, starting at the specified index.

        System.out.println(s4.indexOf('n')); 
        System.out.println(s4.indexOf("on"));  // searches the string on in string s4
        System.out.println(s4.indexOf('t'));  // searches from left to right returns index of first t found 
        System.out.println(s4.lastIndexOf('t')); // searches from right to left returns index of first t found 


// MODIFYING STRINGS

 String s6 = "SKY University";
        System.out.println(s6.replace('s','C'));  // replace the 's' with an 'C'

   String s7 = "0123456789";
        System.out.println(s7.substring(4));  // print the string starting from index 4
        System.out.println(s7.substring(4,7));   // print the string from index 4 ,7-4 =3 characters

 String s8 = "AbcdeF";
        System.out.println(s8.toLowerCase());  // will print the string in lowecase
        System.out.println(s8.toUpperCase());   // will print the string in all caps

 String s9 = "New";
  System.out.println(s9.concat("York")); // string concatenation

 String s10 = "    HYBE    LABELS   ";
 System.out.println(s10.trim());   // remove the leading and lagging places not the embedded(in-between) ones


// DATA CONVERSION USING valueOf()


// to convert any datatype to a string


Integer x =Integer.valueOf(9);
      Double c = Double.valueOf(5);



double d=3.98; // 3.98 is a number
//System.out.println(valueOf(d));  // the 3.98 printed will be a string not a number

double d1 = 102939939.939;
      boolean b = true;
      long l = 1232874;
      char[] arr = {'a', 'b', 'c', 'd', 'e', 'f','g' };

      System.out.println(String.valueOf(d1) );
      System.out.println(String.valueOf(b) );
      System.out.println(String.valueOf(l) );
      //System.out.println(String.valueOf(arr) );

String s= new String();

String strings="heyyyy";
char characters[];
characters=strings.toCharArray();
System.out.println(characters); // now each single character can be accessed
System.out.println(characters[1]);
//System.out.println(strings[2]);   wont work since string is not an array , we cant access a specific position






    }
} 

