import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class practice2{
public static void main(String[] args) throws IOException{

   Integer arr[]= new Integer[4];
   for(int i=0;i<4;i++){
   arr[i] = Integer.parseInt(args[i]);

   }



//int[] arr={2,3,5,6};
int targetSum=11;





for(int i=0;i<arr.length;i++){

    for(int j=i+1;j<arr.length;j++){

        if((arr[i]+arr[j])==targetSum){
            System.out.print(arr[i] + " and " + arr[j] + " = " + targetSum);
        }

        

        /*
        arr[0] , arr[1] =   2,3    5
        arr[0] , arr[2] =   2,5    7
        arr[0] , arr[3] =   2,6    8

        arr[1] , arr[2]
        1,3

        2,3
        

         */



    }
}

} 
}