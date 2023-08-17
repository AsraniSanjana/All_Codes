class EvenOdd
 {
   public static void main(String args[]) 
     {
	int n;
        n=Integer.parseInt(args[0]);
	System.out.println("Odd Numbers from 1 to "+n+" are: ");
	for (int i = 1; i <= n; i++) 
          {
	   if (i % 2 != 0) 
           {
		System.out.print(i + " ");
	   }
	}
        System.out.println();
	System.out.println("Even Numbers from 1 to "+n+" are: ");
	for (int i = 1; i <= n; i++) 
          {
	   if (i % 2 == 0) 
           {
		System.out.print(i + " ");
	   }
	}      
   }
}