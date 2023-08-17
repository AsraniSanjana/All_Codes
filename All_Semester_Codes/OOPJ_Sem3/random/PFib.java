class Prime implements Runnable
{
 int c,i=2,j,n;
  int count=0;
 Prime()
 {}
   public void run()
  {
   while(count!=20)
   {
     j=2; 
     while(i%j!=0)
    {
      j++;
    }
   if(j==i)
       { System.out.println(" Prime number is : " + i);
      
         count++; }
    
   i++;
   } 
  }
}

class Fibonacci implements Runnable
{
  int n1,n2,n3,count,i;
  Fibonacci()
  {
    n1=0;
    n2=1; count=15;

    System.out.print(n1 + " " + n2);
   }
  public void run()
  {
   
    for(i=3; i<=count; i++)
    {
      n3 = n1 + n2;
      System.out.print(" " + n3);
      n1=n2;
      n2=n3;
    }
  }
}

class PFib
{
  public static void main(String args[])
  {
   
   Prime p = new Prime();
   Fibonacci f = new Fibonacci();
   Thread fib = new Thread(f,"fibonacci");
   Thread prime = new Thread(p,"prime");

   prime.start();
   fib.start();
  }
}