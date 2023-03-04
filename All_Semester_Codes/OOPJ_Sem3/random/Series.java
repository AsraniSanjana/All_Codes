/*
// sin series: sin x =x- x^3/3! + x^5/5! + x^7/7!+..
// cos series: cos x= 1- x^2/2! + x^4/4! - x^6/6!+...
import java.util.Scanner;
class Series
{
public static void main (String args[])
    { double terms,termc,sums=0,sumc=1;
        Scanner sc = new Scanner(System.in);
       System.out.println("Enter Angle in degrees : ");
        double angled=sc.nextDouble();  // input angle in degrees
   double angler= angled*Math.PI/180;   // same angle in radians
 System.out.println(" entered angle in radians is "+ angler);
System.out.println("enter how many terms:");
 int n=sc.nextInt();
sums=terms=angler;
termc=1;
double x=angler; 
for(int i=2;i<=n;i++)
{
terms=terms*(-x*x)/((2*i-2)*(2*i-1));
 int sums=sums+terms;
}
System.out.println("sine of "+ angled + " = " + sums); 
for( int j=1;j<=n;j++)
{ 
termc=termc*(-x*x)/((2*j)*(2*j-1));  
sumc=sumc+termc;
}

System.out.println("cosine of "+ angled + " = " + (sumc)); 
}}

*/



import java.util.Scanner;
class SineSeries
{
 public double x,term,sum;
 double series1(double s, int n)
 
 {  x=s;
  double terms=0,sums=0;
  x=x*(3.142/180.0);   //converting degree to radian
 
  terms=sums=x;
 for( int i=2;i<=n;i++)
 {
   terms=terms*(-x)(x)/(2*i-2)(2*i-1);
   sums=sums+terms;   
 }
  return sums;
 }

double series2(double s, int n)
 
 {  x=s;
  double termc=1,sumc=1;
  x=x*(3.142/180.0);   //converting degree to radian
 double terms,sums;

 for( int i=2;i<=n;i++)
 {
   termc=termc*(-x*x)/((2*j)*(2*j-1));  
   sumc=sumc+termc;   
 }
  return sumc;
 }

} 
class Series
{
public static void main(String agrs[])
{
  double q,r;
  Scanner input=new Scanner(System.in);
  System.out.println("enter the angle in degree\n");
 x=input.nextDouble();
System.out.println(" entered angle in radians is "+ x*Math.PI/180);

System.out.println("enter the number of terms\n");
int n=input.nextInt();
  SineSeries n1=new SineSeries();
  q=n1.series1(x,n);
System.out.println(r);
 CosineSeries n2=new CosineSeries();
r= n2.series2(x,n);
  System.out.println(r);
   

}

}














