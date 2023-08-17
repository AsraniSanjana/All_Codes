import java.util.Scanner; 
class Hypotenuse {
 
static double findHypotenuse(double side1, double side2){ 
double h = Math.sqrt((side1 * side1) + (side2 * side2)); 
return h;
 }
 
public static void main(String s[]) { 

 Scanner sc = new Scanner(System.in);
System.out.print("Enter Height of the Right angled triangle: "); 
int side1= sc.nextInt();
System.out.println();
System.out.print("Enter Base of the Right angled triangle : "); 
int side2= sc.nextInt();
System.out.println();
double hypotenuse=findHypotenuse(side1, side2);
System.out.print("length of the hypotenuse is : " + hypotenuse);
}
} 