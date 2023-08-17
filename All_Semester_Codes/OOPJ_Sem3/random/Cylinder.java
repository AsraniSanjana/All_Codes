
import java.util.Scanner;

public class Cylinder {
final static double PI = 3.141592; 
// PI's value is to be kept constant throughout the program, we have kept it final


public static void SurfaceArea(double h,double r){
double sa = 2 *PI * r * (r + h);
//PI=2.15;
System.out.println("Surface area of cylinder is : " + sa);
}
	
public static void Volume(double h,double r){
double volume = PI * r * r * h;
System.out.println("Surface area of cylinder is : " + volume);
}

        
	public static void main(String[] args) {
       
	Scanner sc = new Scanner(System.in);
                System.out.println("\n Please Enter the radius of a Cylinder : ");
		double radius = sc.nextDouble();
		System.out.println("\n Please Enter the Height of a Cylinder : ");
		double height = sc.nextDouble();
		
		SurfaceArea(height,radius);
                Volume(height,radius);
	}
}











/*

class Cylinder2 {
  final void area2() { // make this area to get that error of method overriding not possible
    System.out.println("AREA");
  }
}
public class Cylinder extends Cylinder2{
  void area() {
    System.out.println("SURFACE AREA");
  }
  public static void main(String[] args) {
Cylinder obj1=new Cylinder();
obj1.area();
  }
}

*/



















/*

final class Cylinder2 {
  public void area() {
    System.out.println("AREA");
  }
}
public class Cylinder extends Cylinder2{
  public static void main(String[] args) {
    
  }
}













*/





/*

final class Cylinder2 {
  public void area() {
    System.out.println("AREA");
  }
}
public class Cylinder {
  public static void main(String[] args) {
    Cylinder2 obj1=new Cylinder2();
obj1.area();
  }
}




*/














