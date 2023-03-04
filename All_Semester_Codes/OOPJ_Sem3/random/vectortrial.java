import java.util.*;
class vectortrial{
public static void main(String args[]){ 

 Vector v=new Vector(2,10);
v.add(1);
v.add(2);
v.add("geeks");

System.out.print("\nvector elements are : ");
for(int i=0;i<v.size();i++)
System.out.print(v.elementAt(i)+"\t       ");

v.add(1,68);
System.out.print("\nvector elements are : ");
for(int i=0;i<v.size();i++)
System.out.print(v.elementAt(i)+"\t       ");

v.remove(2);
System.out.print("\nvector elements are : ");
for(int i=0;i<v.size();i++)
System.out.print(v.elementAt(i)+"\t       ");

v.add(100);
v.add(200);
v.add(300);
v.add(400);
v.add(500);
v.add(3,600);

System.out.print("\nvector elements are : ");
for(int i=0;i<v.size();i++)
System.out.print(v.elementAt(i)+"\t       ");

v.set(4,16732496);


System.out.print("\nvector elements are : ");
for(int i=0;i<v.size();i++)
System.out.print(v.elementAt(i)+"\t       ");

v.remove(3);
System.out.print("\nvector elements are : ");
for(int i=0;i<v.size();i++)
System.out.print(v.elementAt(i)+"\t       ");

v.removeElement(500);
System.out.print("\nvector elements are : ");
for(int i=0;i<v.size();i++)
System.out.print(v.elementAt(i)+"\t       ");





}}