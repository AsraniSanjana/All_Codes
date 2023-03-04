 #include<stdio.h>
#include<math.h>
//incomplete pgm dont refer
#define SIZE 8 //8 bit binary
// we are using 2s complement representation of signed numbers here.
//u can convert 1/2/3/4/5/6/7 bit binary to 8 bit ,by making an array function,.. in case u dont want to enter it yourself
void callOnesComp ( char *binary , char onesComp[])
{

 for( int i=0; i<SIZE; i++)
    {
        if(binary[i] == '1')
        {
            onesComp[i] = '0';
        }
        else if(binary[i] == '0')
        {
            onesComp[i] = '1';
        }
    }
    onesComp[SIZE] = '\0'; }

void callTwosComp ( char *binary,char onesComp[])
{
int j,x,carry;
    for( j=SIZE-1; j>=0; j--)
    {
        if (binary[7] == '1');
          {  twosComp[7] = '1';
              if (binary[6]==1)
               twosComp[6] = '1';
               if (binary[5]==1)
               twosComp[5] = '1';
               if (binary[4]==1)
               twosComp[4] = '1';
               if (binary[3]==1)
               twosComp[3] = '1';
               if (binary[2]==1)
               twosComp[2] = '1';
               if (binary[1]==1)
               twosComp[1] = '1';
               if (binary[0]==1)
               twosComp[0] = '1';
               }

            else if (binary[7] == '0')




    twosComp[SIZE] = '\0';

}




int main()
{    char binary[SIZE + 1], onesComp[SIZE + 1], twosComp[SIZE + 1];
    int i, carry=1;
int a[10],n,n1;
//system ("cls");
printf("Enter a number: ");
scanf("%d",&n);
if(n>=0) // positive number
{
n1=n;
for(i=0;n>0;i++)
{
a[i]=n%2;
n=n/2;
}
printf("\nBinary of %d is=",n1);
for(i=i-1;i>=0;i--)
{
printf("%d",a[i]); // storing numerous values inside a string or array or enum
}
printf("\n enter the binary of %d you just got above, but in 8 bits:",n1);
 scanf("%s",binary);

 callOnesComp(binary,onesComp);
 callTwosComp(onesComp,twosComp);



    printf("Original decimal number= %d\n",  n1);
    printf(" binary = %s\n", binary);
    printf("Ones complement = %s\n", onesComp);
    printf("Twos complement = %s\n", twosComp); }



     else // negative number
    {


n1=abs(n);// n1 has positive value of n
int n2=n1;
for(i=0;n1>0;i++)
{
a[i]=n1%2;
n1=n1/2;
}

printf("\nBinary of +%d is=",n2);
for(i=i-1;i>=0;i--)
{
printf("%d",a[i]);
}
printf("\n enter the binary of +%d u just got above, but in 8 bits:",n2);
 scanf("%s",binary);

 callOnesComp(binary,onesComp);
 callTwosComp(onesComp,twosComp);


    printf("Original decimal number= -%d\n",  n2);
    printf("binary of -%d = -%s\n",n2, twosComp);
    printf("Ones complement of -%d = %s\n",n2,onesComp);
    printf("Twos complement = %s\n", binary);

} return 0;
}









