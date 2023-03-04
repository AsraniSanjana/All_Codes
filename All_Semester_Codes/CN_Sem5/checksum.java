import java.util.*;
class checksum
{
	static int[] bit1 = new int[3];
	static int[] bit2 = new int[3];
	static int[] bit3 = new int[3];
	static int[] bit4 = new int[3];
	static int[] bit5 = new int[3];
	static int[] bit0 = {0,0,1};
	static int[] ans = new int[4];
	static int[] rec = new int[3];
	static int[] rans = new int[3];
	static int pcar =0;
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		//Sender Side
		System.out.println("\n\n\t\tSender's side\n");
		System.out.println("Please Enter 1st 3 Bit Number : ");
		for(int i =0; i<3; i++)
			bit1[i] = sc.nextInt();
		add(bit1,ans,true);
		System.out.println("Please Enter 2nd 3 Bit Number : ");
		for(int i= 0; i<3;i++)
			bit2[i] = sc.nextInt();
		add(bit2,ans,true);
		System.out.println("Please Enter 3rd 3 Bit Number : ");
		for(int i = 0; i<3; i++)
			bit3[i] = sc.nextInt();
		add(bit3,ans,true);
		// System.out.println("Please Enter 4th 3 Bit Number : ");
		// for(int i=0;i<3;i++)
		// 	bit4[i] = sc.nextInt();
		// add(bit4,ans,true);
		System.out.println();
		for(int i=0;i<3;i++)
			System.out.print(bit1[i] + " ");
		System.out.println();
		for(int i=0;i<3;i++)
			System.out.print(bit2[i] + " ");
		System.out.println();
		for(int i=0;i<3;i++)
			System.out.print(bit3[i] + " ");
		System.out.println();
		// for(int i=0;i<3;i++)
		// 	System.out.print(bit4[i] + " ");
		// System.out.println();
		System.out.println("----------------");
		for(int i=0;i<3;i++)
			System.out.print(ans[i] + " ");
		if(pcar == 1)
		{
			add(bit0,ans,true);
			System.out.println();
			System.out.print("Wrap sum:");
			for(int i=0;i<3;i++)
				System.out.print(ans[i] + " ");
		}
		for(int i = 0; i<3 ; i++)
		{
			if(ans[i] == 1)
               ans[i] = 0;
			else
				ans[i] = 1;
		}
		System.out.println();
		System.out.print("After 1's complement (CHECKSUM) : ");
		for(int i =0; i<3;i++)
			System.out.print(ans[i] +" ");
		// System.out.println("\n"+pcar);
		
		//Reciver Sides
		pcar = 0;
		System.out.println();
		System.out.println();
		System.out.println("\n\t\tReceiver's side:\n");
		System.out.println("Please Enter 1st 3 Bit Number");
		for(int i =0; i<3; i++)
			bit1[i] = sc.nextInt();
		add(bit1,rans,true);
		System.out.println("Please Enter 2nd 3 Bit Number");
		for(int i= 0; i<3;i++)
			bit2[i] = sc.nextInt();
		add(bit2,rans,true);
		System.out.println("Please Enter 3rd 3 Bit Number");
		for(int i = 0; i<3; i++)
			bit3[i] = sc.nextInt();
		add(bit3,rans,true);
		// System.out.println("Please Enter 4th 3 Bit Number");
		// for(int i=0;i<3;i++)
		// 	bit4[i] = sc.nextInt();
		// add(bit4,rans,true);
		System.out.println("Enter The Checksum Code Received :");
		for(int i=0;i<3;i++)
			bit5[i] = sc.nextInt();
		add(bit5,rans,true);
		System.out.println();
		for(int i=0;i<3;i++)
			System.out.print(bit1[i] + " ");
		System.out.println();
		for(int i=0;i<3;i++)
			System.out.print(bit2[i] + " ");
		System.out.println();
		for(int i=0;i<3;i++)
			System.out.print(bit3[i] + " ");
		System.out.println();
		// for(int i=0;i<3;i++)
		// 	System.out.print(bit4[i] + " ");
		// System.out.println();
		for(int i=0;i<3;i++)
			System.out.print(bit5[i] + " ");
		System.out.println();
		System.out.println("----------------");
		for(int i=0;i<3;i++)
			System.out.print(rans[i] + " ");
		if(pcar == 1)		
		{
			add(bit0,rans,false);
			System.out.println();
			System.out.print("Wrap Sum:");
			for(int i=0;i<3;i++)
				System.out.print(rans[i] + " ");
		}

		
		
		for(int i = 0; i<3; i++)
		{
			if(rans[i] == 1)
				rans[i] = 0;
			else	
				rans[i] = 1;
		}
		System.out.println();
		System.out.print("After 1's complement: ");		
		for(int i = 0; i<3;i++)
			System.out.print(rans[i] +" ");	
		System.out.println();
		if(rans[0]==0 && rans[1]==0 && rans[2]==0)
		{
			System.out.println("No Error");
		}
		else
		{
			System.out.println("Error");
		}
		
	}
	static void add(int[] x, int[] ans1,boolean flag )
	{
		int carry=0;
		int temp;
		for(int i =2;i>=0;i--)
		{
			temp = carry+x[i]+ans1[i];
			if(temp==2)
			{
				carry = 1;
				ans1[i]= 0;
			}
			else if(temp==3)
			{
				ans1[i] = 1;
				carry  = 1;
			}
			else if(temp==1)
			{
				ans1[i] = 1;
				carry = 0;
			}
			else
			{
				ans1[i] = 0;
				carry =0;
			}
		}
		if(carry == 1)
		{
			pcar++;
			carry = 0;
		} 
		if(flag == true)
		{
			for(int i =0; i<3;i++)
			{
				ans[i] = ans1[i];
			}
		}
		else
		{
			for(int i =0; i<3;i++)
			{
				rec[i] = ans1[i];
			}
		}
		
		
	}
}
