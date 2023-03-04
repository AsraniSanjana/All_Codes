#include<stdio.h>
#include<math.h>
#define SIZE 8

int main()
{

char binary[SIZE + 1], onesComp[SIZE + 1], twosComp[SIZE + 1];
    int i, carry=1;
int a[10],n,n1;


printf("Enter a number: ");
scanf("%d",&n);
void santrial( int n2,char onesComp[], char twosComp[])
{
        for(i=0; i<SIZE; i++){
        if(twosComp[i] == '1')
        {
            onesComp[i] = '0';
        }
        else if(twosComp[i] == '0')
        {
            onesComp[i] = '1';
        }
    }
    onesComp[SIZE] = '\0';

}

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
printf("%d",a[i]);
}
printf("\n enter the binary of %d u just got above, but in 8 bits:",n1);
 scanf("%s",binary);


 // making a function to Find ones complement of the binary number
  for(i=0; i<SIZE; i++)
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
    onesComp[SIZE] = '\0';


    // adding 1 to the ones complement
    for(i=SIZE-1; i>=0; i--)
    {
        if(onesComp[i] == '1' && carry == 1)
        {
            twosComp[i] = '0';
        }
        else if(onesComp[i] == '0' && carry == 1)
        {
            twosComp[i] = '1';
            carry = 0;
        }
        else
        {
            twosComp[i] = onesComp[i];
        }
    }
    twosComp[SIZE] = '\0';
    printf("Original decimal number= %d\n",  n1);
    printf(" binary = %s\n", binary);
    printf("Ones complement = %s\n", onesComp);
    printf("Twos complement = %s\n", twosComp); }



     else // negative number
    {


n1=abs(n);
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

    for(i=0; i<SIZE; i++)
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
    onesComp[SIZE] = '\0';


    // twos comp:adding 1 to the ones complement
    for(i=SIZE-1; i>=0; i--)
    {
        if(onesComp[i] == '1' && carry == 1)
        {
            twosComp[i] = '0';
        }
        else if(onesComp[i] == '0' && carry == 1)
        {
            twosComp[i] = '1';
            carry = 0;
        }
        else
        {
            twosComp[i] = onesComp[i];
        }
    }
    twosComp[SIZE] = '\0';

    printf("Original decimal number= -%d\n", n2);
    printf("binary of -%d= %s\n",n2,twosComp);
     santrial(n2,onesComp,twosComp);

    printf("Ones complement of -%d = %s\n",n2 ,onesComp);
    printf("Twos complement of -%d = %s\n",n2 ,binary);

} return 0;
}
