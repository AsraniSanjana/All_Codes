import java.util.*;
class hamming
{
	public static void main(String[] args) 
	{
		System.out.println("\n\t\t\tHAMMING CODE\n");
		System.out.println("\t\t\tFOR SENDER :\n");
		System.out.print("Enter number of bits of data word : ");
		Scanner s1 = new Scanner(System.in);
		int d = s1.nextInt();
		int dataWord[] = new int[d];
		int r=1;
		//calculate number of parity bits needed using m+r+1<=2^r
		while(true)
		{
			if(d+r+1<=Math.pow(2,r))
			{
				break;
			}
			r++;
		}
		
		System.out.println("Enter Data word bit by bit :");
		for(int i=0;i<d;i++){
			dataWord[i] = s1.nextInt();}
		String msg ="";
		for(int i=0;i<d;i++){
				msg=msg+dataWord[i];}
			System.out.println("Number of Redundant/Parity bits needed : "+r);
			int transLength = msg.length()+r,temp=0,temp2=0,j=0;
			int transMsg[]=new int[transLength+1]; //+1 because starts with 1
			for(int i=1;i<=transLength;i++)
			{
				temp2=(int)Math.pow(2,temp);
				if(i%temp2!=0)
				{
					transMsg[i]=Integer.parseInt(Character.toString(msg.charAt(j)));
					j++;
				}
				else
				{
					temp++;
				}
			}
				
			for(int i=0;i<r;i++)
			{
				int smallStep=(int)Math.pow(2,i);
				int bigStep=smallStep*2;
				int start=smallStep,checkPos=start;
				System.out.print("Parity Bits to be checked for Position " + smallStep + ": " );
				while(true)
				{
					for(int k=start;k<=start+smallStep-1;k++)
					{
						checkPos=k;
						System.out.print(checkPos+",");
						if(k>transLength)
						{
							break;
						}
						transMsg[smallStep]^=transMsg[checkPos];
					}
					if(checkPos>transLength)
					{
						break;
					}
					else
					{
						start=start+bigStep;
					}
				}
				System.out.println();
			}	
			int senderCodeWord[] = new int[d+r];
			calcSenderCodeWord(senderCodeWord,dataWord,r,d);
			
			codeWord(senderCodeWord,d,r);
			System.out.print("Message Sent : ");
			for(int i=0;i<(d+r);i++)
				System.out.print(senderCodeWord[i]+"");
			
			int recCodeWord[] = new int[d+r];
			System.out.print("\nData word : ");
			for(int i=0;i<d;i++){
				System.out.print(dataWord[i]);}

			System.out.println("\n\n\t\t\tFor RECEIVER : \n");
		System.out.println("Enter Receieved Message : ");
		for(int i=0;i<(d+r);i++)
			recCodeWord[i] = s1.nextInt();
		int redBits[] = new int[r];
		boolean err = detectError(recCodeWord,redBits,d,r);
		if(err)
		{
			System.out.println("\nNo error Detected in  transmission.");
			System.out.println("\nExtracted Data word is : ");
			for(int i=0;i<d;i++)
				System.out.print(dataWord[i]+" ");
			System.out.println();
		}
		else
		{
			System.out.println("\nError Detected in data transmission.\n");
			System.out.println();
			correctError(recCodeWord,redBits,dataWord,d,r);
			System.out.println("Corrected Message is : ");
			for(int i=0;i<(d+r);i++)
				System.out.print(recCodeWord[i]+" ");
			System.out.println();
			System.out.println("\nExtracted Data word is : ");
			for(int i=0;i<d;i++)
				System.out.print(dataWord[i]+" ");
			System.out.println();
		}
	}

	public static void calcSenderCodeWord(int senderCodeWord[],int dataWord[], int r, int d)
	{
		int i, j, k=d-1, ind=1;
		boolean flag = false;
		for(i=(d+r-1);i>=0;i--)
		{
			flag=false;
			for(j=0;j<ind;j++)
			{
				if((int)Math.pow(2,j)==ind)
				{
					flag=true;
					break;
				}
			}
			if(flag)
			{
				senderCodeWord[i]=0;
			}
			else
			{
				senderCodeWord[i]=dataWord[k];
				k--;
			}
			ind++;
		}
	}

	public static void codeWord(int senderCodeWord[],int d, int r)
	{
		System.out.println("\nParity/Redundant Bits : ");
		int i,ind=1,j,k,xor=0,count;
		boolean flag=false;
		for(i=(d+r-1);i>=0;i--)
		{
			flag=false;
			xor=0;
			for(j=0;j<ind;j++)
			{
				if((int)Math.pow(2,j)==ind)
				{
					flag=true;
					break;
				}
			}
			if(flag)
			{
				k=d+r-ind;
				count=ind;
				while(k>=0)
				{
					xor=xor^(senderCodeWord[k]);
					k--;
					count--;
					if(count==0)
					{
						k=k-ind;
						count=ind;
					}
				}
				System.out.println("R"+(i-(d+r))+" = "+xor);
				senderCodeWord[i]=xor;
			}
			ind++;

		}
		System.out.println();
	}
	public static boolean detectError(int recCodeWord[], int redBits[],int d, int r)
	{
		codeWord(recCodeWord,d,r);
		int i,j,ind=1,rind=r-1;
		boolean flag=false;
		for(i=(d+r-1);i>=0;i--)
		{
			flag=false;
			for(j=0;j<ind;j++)
			{
				if((int)Math.pow(2,j)==ind)
				{
					flag=true;
					break;
				}
			}
			if(flag)
			{
				redBits[rind] = recCodeWord[i];
				rind--;
			}
			ind++;
		}
		for(i=0;i<r;i++)
		{
			if(redBits[i]==1)
			{
				return false;
			}
		}
		return true;
	}
	public static void correctError(int recCodeWord[],int redBits[], int dataWord[], int d, int r)
	{
		String binary = "";
		for(int i=0;i<r;i++)
		{
			binary=binary+redBits[i];
		}
		int decimal = Integer.parseInt(binary,2);
		System.out.println("Error detected at bit position "+decimal);
		int index = d+r-decimal;
		if(recCodeWord[index]==0)
		{
			recCodeWord[index]=1;
		}
		else
		{
			recCodeWord[index]=0;
		}
		int i,j,ind=1,dind=d-1;
		boolean flag=false;
		for(i=(d+r-1);i>=0;i--)
		{
			flag=false;
			for(j=0;j<ind;j++)
			{
				if((int)Math.pow(2,j)==ind)
				{
					flag=true;
					break;
				}
			}
			if(flag)
			{
				continue;
			}
			else
			{
				dataWord[dind]=recCodeWord[i];
				dind--;
			}
			ind++;
		}
	}
}