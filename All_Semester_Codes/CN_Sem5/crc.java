import java.util.*;
class crc
{        public static void main(String[] args) {
		int[] data ;
		int[] div;
		int[] divisor;
		int[] rem;
		int[] crc;
		int data_bits,divisor_bits,tot_bits;
		Scanner s = new Scanner(System.in);
		System.out.println("\n\t\t\tCRC\n");
		System.out.println("\t\tSENDER'S SIDE : \n");
		System.out.print("Enter Number of Data Bits : ");
		data_bits= s.nextInt();
		data= new int[data_bits];	
		System.out.println("Enter The Data Bits : ");
		for(int i=0;i<data_bits;i++)
			data[i] = s.nextInt();
        	System.out.print("Enter The Number of Bits of Divisor : ");
		divisor_bits= s.nextInt();
		int r = divisor_bits - 1;
		divisor = new int[divisor_bits];
		System.out.println("Enter The Divisor Bits : ");
		for(int i=0; i<divisor_bits ; i++)
			divisor[i] = s.nextInt();
		System.out.print("Data Bits Are : ");
		for(int i=0; i<data_bits ; i++)
			System.out.print(data[i] + "");
		System.out.print("\nDivisor Bits Are : ");
		for(int i=0; i<divisor_bits; i++)
			System.out.print(divisor[i] + "");
		System.out.print("\nNumber of redundant bits are : " + r);
		tot_bits = data_bits+divisor_bits-1;
		div = new int[tot_bits];
		rem = new int[tot_bits];
		crc = new int[tot_bits];
		for(int i=0;i<data.length;i++)
			div[i] = data[i];
		System.out.print("\nDividend (after appending 0's) : ");
		for(int i=0;i<div.length;i++)
			System.out.print(div[i]+"");
		System.out.println();
		for(int j=0;j<div.length ;j++)
			rem[j] = div[j];
		rem = divide(div,divisor,rem);
		System.out.print("\nThe value of the redundant bits(CRC) is : ");
		for(int k =data_bits; k<tot_bits; k++)
			System.out.print(rem[k]+"");
		for(int i=0;i<div.length;i++)
			crc[i] = (div[i] ^ rem[i]);
		System.out.print("\nCODEWORD transmitted is  : ");
		for(int i=0;i<crc.length;i++)
			System.out.print(crc[i] + "");
		
		System.out.println("\n\n\t\tRECEIVER'S SIDE :\n");
		System.out.println("\nEnter the CODEWORD received : ");
		for(int i=0;i<crc.length;i++)
		crc[i] = s.nextInt();
		System.out.print("Received codeword is : ");
		for(int i =0; i<crc.length ; i++)
			System.out.print(crc[i] + "");
		for(int j=0; j<crc.length; j++)
			rem[j] = crc[j];
		rem = divide(crc,divisor,rem);
		System.out.print("\nRemainder is : ");
		for(int k=0;k<rem.length;k++)
			System.out.print(rem[k]+"");
		for(int i=0;i<rem.length; i++)
		{
			if(rem[i]!=0)
			{
                System.out.print("\nMessage Received has error.\nMessage rejected. \n\n");
				break;
			}
			if(i==rem.length-1)
                System.out.print("\nMessage Received has no error. \nMessage is accepted. \n\n");
		}
	}
	static int[] divide(int div[], int divisor[], int rem[])
	{
		int cur=0;
		while(true)
		{
			for(int i=0; i<divisor.length;i++)
				rem[cur+i] = (rem[cur+i] ^ divisor[i] );
			while(rem[cur] == 0 && cur!=rem.length-1)
				cur++;
			if((rem.length-cur)<divisor.length)
				break;
		}
		return rem;
	}
}
