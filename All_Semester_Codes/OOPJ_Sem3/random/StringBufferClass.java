public class StringBufferClass{
public static void main(String[] args) {   

StringBuffer s1=new StringBuffer("javaisgood");
System.out.println(s1);
System.out.println(s1.length()); // if s1 was a string, s1.string;
System.out.println(s1.capacity());  // capacity= 16 + length of s1

// character extraction methods
System.out.println(s1.charAt(4));


s1.setCharAt(0,'m');
System.out.println(s1);

        StringBuffer s2=new StringBuffer("FALlingStars");

        System.out.println(s2.charAt(2));  // to access certain character from a string
        char temp[]=new char[10];
        s2.getChars(3,7,temp,3); // 7-3=4 characters to be extracted from string s1 starting from index3, stored into string temp from index 3
        System.out.println(temp);

 StringBuffer sb1=new StringBuffer("MINT");
 StringBuffer sb2=new StringBuffer("CHOCO");
System.out.println(sb1.append(sb2));

sb2.insert(0,"LATE");  // we dont have to increase the string here, we can insert anthing anywhere and change the string
System.out.println(sb2);  // late will be inserted at index0 of stringbuffer sb2

 StringBuffer sb3=new StringBuffer("SILVERSPOON");
 System.out.println(sb3.reverse());


 StringBuffer sb4=new StringBuffer("SILVERSPOON");
 System.out.println(sb4.delete(6,12)); // delete from index6 to index12


 StringBuffer sb5=new StringBuffer("frog");
 System.out.println(sb5.deleteCharAt(1)); 


 StringBuffer sb6=new StringBuffer("THIS IS A COMPETITION");
 System.out.println(sb6.replace(5,7,"WAS")); 





}}