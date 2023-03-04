//CONTIGUOUS FILE ALLOCATION ALGORIHTM
#include <stdio.h>
#include <stdlib.h>
void recurse(int files[]){
    int flag = 0, startBlock, len, j, k, ch;
    printf("Enter the starting block and the length of the files : ");
    scanf("%d%d", &startBlock, &len);
    for (j=startBlock; j<(startBlock+len); j++){
        if (files[j] == 0)
            flag++;
    }
    if(len == flag){
        for (int k=startBlock; k<(startBlock+len); k++){
            if (files[k] == 0){
                files[k] = 1;
                printf("%d\t%d\n", k, files[k]);
            }
        }
        if (k != (startBlock+len-1))
            printf("Success. The file was allocated to the disk.\n");
    }
    else
        printf("\nNot Enough contiguous space available , The file could not be allocated.\n");

    printf("\nDo you want to enter more files?\n");
    printf("\nPress 1 for YES, 2 for NO : \n");

    scanf("%d", &ch);
    if (ch == 1)
        recurse(files);
    else if (ch == 2)
        exit(0);
    return;
}
int main()
{
int files[50];
for(int i=0;i<50;i++)
files[i]=0;
printf("Files Allocated are : \n");
recurse(files);
return 0;
}
