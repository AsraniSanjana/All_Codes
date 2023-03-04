 #include <stdio.h>
 #include<time.h>
int main()
{
    int a[1000],i,n,min,max;

    clock_t time;
   time = clock();
    printf("Enter size of the array : ");
    scanf("%d",&n);

    printf("Enter elements in array : ");
    for(i=0; i<n; i++)
    {
        scanf("%d",&a[i]);
    }

    min=max=a[0];
    for(i=1; i<n; i++)
    {
         if(min>a[i])
		  min=a[i];
		   if(max<a[i])
		    max=a[i];
    }
     printf ("Entered Array is : \n");
 for (i=1;i<=n;i++)
  printf ("%d,",a[i]);

     printf("\nminimum element in the array is : %d",min);
          printf("\nmaximum element in the array is : %d",max);
          time = clock() - time;
             double time_taken = ((double)time)/CLOCKS_PER_SEC; // calculate the elapsed time
   printf("\nThe program took %f seconds to execute\n", time_taken);

    return 0;
}
