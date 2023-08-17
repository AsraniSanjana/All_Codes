
import java.util.*;
import java.io.*;

class  VectorDemoBookList
{
    public static void main(String args[])
    {
        Vector itemList = new Vector();
        String str,item;
        int i,j,len,choice,pos;

        len=args.length;
        for(i=0;i<len;i++)
            itemList.addElement(args[i]);

        while(true)
        {
            System.out.println("\nChoose your choice ...\n");
                    System.out.println("1) Delete  a book ");
                            System.out.println("2) Add a book at Specified Location ");
                                    System.out.println("3) Add a book at  the End of the list");
                                            System.out.println("4) Display List of Books available in the Department ");
                                                    System.out.println("5) Exit");
                                                            System.out.print("Enter your choice : ");
                                                                  //  System.out.flush();
            try{
                BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
                str=obj.readLine();
                choice=Integer.parseInt(str);
                switch(choice)
                {
         case 1 :    System.out.print("Enter the Book name you want to be deleted : \n");
                            str=obj.readLine();
                        itemList.removeElement(str);  //string is not needed to convert object type
                      // as it is already object of class String
                        len=itemList.size();
                        System.out.println("Updated Book List :");
                        for(i=0;i<itemList.size();i++)
                        {
                            System.out.println((i+1)+") "+itemList.elementAt(i));
                        }
                        break;
                    case 2 :     System.out.println("Enter the Book name  to be Inserted : ");
                            //System.out.flush();
                        item=obj.readLine();
                        System.out.println("Enter the Position of new book to be added at : ");
                                str=obj.readLine();
                        pos=Integer.parseInt(str);
                        itemList.insertElementAt(item,pos-1);
                        System.out.println("Updated Book List :");
                        for(i=0;i<itemList.size();i++)
                        {
                            System.out.println((i+1)+") "+itemList.elementAt(i));
                        }
                        break;
                    case 3 :     System.out.println("Enter the book name to be Inserted : ");
                            //System.out.flush();
                        item=obj.readLine();
                        itemList.addElement(item);
                        System.out.println("Updated Book List :");
                        for(i=0;i<itemList.size();i++)
                        {

                            System.out.println((i+1)+") "+itemList.elementAt(i));
                        }

                        break;
                    case 4 :
                        System.out.println("The following books are available in the CMPN department...");
                        for(i=0;i<itemList.size();i++)
                        {
                            System.out.println((i+1)+") "+itemList.elementAt(i));
                        }
                        break;
                    case 5 :     System.out.println("\nThank You for maintaining a record for books.....");
                           // System.exit(1);
                        break;
                    default :     System.out.println("\nEntered Choice is Invalid Try Again");
                }
            }
            catch(Exception e) {}
        }
    }
}

/*
STRING BUFFER CLASS METHODS
 StringBuffer sb=new StringBuffer("Hello ");  
1. sb.append("Java");
2. sb.insert(1,"Java");     prints HJavaello  
3. sb.replace(1,3,"Java");  prints HJavalo  
4. sb.delete(1,3);          prints Hlo  from index1 , 3-1=2 chars
5. sb.reverse();  
6. 




If the number of character increases from its current capacity, it increases the capacity by (oldcapacity*2)+2.
............................................................................................................................................................


STRING CLASS METHODS 

Java String Methods
String charAt()
String compareTo()
String concat()
String contains()
String endsWith()
String equals()
equalsIgnoreCase()
String format()
String getBytes()
String getChars()
String indexOf()
String intern()
String isEmpty()
String join()
String lastIndexOf()
String length()
String replace()
String replaceAll()
String split()
String startsWith()
String substring()
String toCharArray()
String toLowerCase()
String toUpperCase()
String trim()
String valueOf()
............................................................................................................................................................


VECTOR CLASS METHODS

Vector v1 = new Vector();

v.add(3);
v.set(4, 50));// replace index4 with 50
v.remove(1);  // delete index1
print all elements :
  // for loop
        for (int i = 0; i < v.size(); i++) {
 
            System.out.print(v.get(i) + " ");
        }

............................................................................................................................................................


APPLET FUNCTIONS 

USING PSVM

////////////////////////////////////////////////////////////////////

USING PAINT(GRAPHICS )

///////////////////////////////////////////////////////////////////

 


............................................................................................................................................................

difference bewteen string and stringbuffer

The String class is immutable .
String object is immutable i.e. it’s object can’t be reassigned again whereas, the object of StringBuffer is mutable.
It is slower during concatenation.
consumes more memory when we concatenate too many strings because every time it creates new instance.	
 The length of the String object is fixed : Once you initialize the String object, you can not modify that object again.

StringBuffer objects provide more functionality to the strings as compared to the class String. Hence, it is preferable to work with StringBuffer instead of class String.
............................................................................................................................................................

input mismatch vs numberformat


//import java.io.*;  // if using buffered reader : numberformat exeception will be thrown.
//import java.lang.Exception;
import java.util.*;  // if using util.scanner : inputmismatch error will be shown.. no need to write throws IOException 
............................................................................................................................................................

inside .lang

exception class, math class, random class

inside . util 

scanner class ,vector class,  Provides the classes necessary to create an applet and the classes an applet uses to communicate with its applet context. Contains all of the classes for creating user interfaces and for painting graphics and images.

............................................................................................................................................................


null string , String a ; or String a=null; -> nullpointer exception
empty string , String a="";
blank string ,  String a="";


String str = scnr.nextLine();
 int j = Integer.valueOf(str);


int.ParseInt or valueof  to convert commandline string to int

int to string

int i=200;  
String s=String.valueOf(i);  
System.out.println(i+100);//300 because + is binary plus operator  
System.out.println(s+100);//200100 because + is string concatenation operator  









*/