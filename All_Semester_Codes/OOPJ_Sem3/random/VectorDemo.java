import  java.util.*;
class Shopping
{
public static void main(String args[]){
Vector v=new Vector(5,2);
int i,choice,position;
boolean flag=false;
String str;
int index;
Scanner input =new Scanner(System.in);
for(i=0;i<args.length;i++)
v.addElement(args[i]);
do{

System.out.println("menu:");
System.out.println("1.delete an item:");
System.out.println("2.add an item at a specified location:");
System.out.println("3.add an item at the end of the list:");
System.out.println("4.display shopping list:");
System.out.println("5.exit:");
System.out.println("enter your choice:");
choice=input.nextInt();
switch(choice)
{
case 1:
System.out.println("enter the location of item you want to delete");
index=input.nextInt();
v.remove(index);

/*if(flag==false)
{System.out.println("item not in shopping list");}*/
break;
case 2:
System.out.println("enter the item you want to add into the  shopping list:");
str=input.nextLine();

System.out.println("enter the location you want to add the item at:");
System.out.println("location starts at 0");
position=input.nextInt();
v.insertElementAt(str,0);
break;
case 3:
System.out.println("enter the item you want to add into the  shopping list at the end:");
str=input.nextLine();
v.addElement(str);
break;
case 4:
System.out.println("shopping list is as shown:");
for(i=0;i<v.size();i++)
System.out.println(v.elementAt(i)+" ");
break;
case 5: break;
}}while(choice!=5);





}}