import java.util.*;
class VectorClass{
public static void main(String args[]){  

                                                                      Vector v=new Vector(2,10);  // initial capacity is 2 and increment is 10
                                                                      System.out.println("initial capacity : " + v.capacity());
                                                                      System.out.println("initial size : " + v.size());
                                                                   System.out.print("\ninserting 10 ...");
                                                                       Integer iobj1 = Integer.valueOf(10);
                                                                       v.addElement(iobj1);  // index0
System.out.print("\nvector elements are : ");
for(int i=0;i<v.size();i++)
System.out.print(v.elementAt(i)+"\t");
                                                                       System.out.print("\ninserting 11... ");
                                                                       Integer iobj2 = Integer.valueOf(11);
                                                                       v.addElement(iobj2);   // index1
System.out.print("\nvector elements are : ");
for(int i=0;i<v.size();i++)
System.out.print(v.elementAt(i)+"\t");
                                                                      System.out.print("\ninserting 12... ");
                                                                      Integer iobj3 = Integer.valueOf(12);
                                                                      v.addElement(iobj3);   // index2
System.out.print("\nvector elements are : ");
for(int i=0;i<v.size();i++)
System.out.print(v.elementAt(i)+"\t");
                                                                      System.out.println("\ncapacity after 3 additions : " + v.capacity());
                                                                      System.out.println("first element : " + v.firstElement());
                                                                      System.out.println("last element : " + v.lastElement());

                                                                      Double dobj1=new Double(2.2);
                                                                      System.out.print("\nreplacing index2 with 2.2 ....");
                                                                      v.setElementAt(dobj1,2);  
                                                                     

System.out.print("\nvector elements are : ");
for(int i=0;i<v.size();i++)
System.out.print(v.elementAt(i)+"\t");

                                                                      Integer iobj4 = Integer.valueOf(134);
                                                                      System.out.print("\ninserting 134 at index1...");
                                                                      v.insertElementAt(iobj4,1);   // index1 pe 134 dalo and right shift element after that

System.out.print("\nvector elements are : ");
for(int i=0;i<v.size();i++)
System.out.print(v.elementAt(i)+"\t");


                                                                      if(v.contains(10))
                                                                      {
                                                                      System.out.println("\nour vector has 10 : true"); }
                                                                      


                                                                       System.out.print("\ndeleting 11... ");
                                                                       v.removeElement(11);  

System.out.print("\nvector elements are : ");
for(int i=0;i<v.size();i++)
System.out.print(v.elementAt(i)+"\t");                                                                    

/*
System.out.println();
Vector v2=new Vector(3,5);
char arr[];

System.out.println("enter 4 words to create a vector of them...");
Scanner sc= new Scanner(System.in);


 //String name = sc.next();  taking string input to store all the words in an array 
 for(int j=0;j<5;j++)
{//for reading array
            arr[j]=sc.nextLine();

v2.addElement(arr[j]);}


System.out.println("enter 1st word:");
String s1= sc.nextLine();
v2.addElement(s1);
System.out.println("enter 2nd word:");
String s2= sc.nextLine();
v2.addElement(s2);
System.out.println("enter 3rd word:");
String s3= sc.nextLine();
v2.addElement(s3);








System.out.print("\nvector2 elements are : ");
for(int i=0;i<v2.size();i++)
System.out.print(v2.elementAt(i)+"\t");

*/




}}
/*
int i=10;
Integer iobj1 = new Integer(i);
v.addElement(iobj1);

Integer iobj2 = new Integer(12);
the both above generate a warning 
 */ 