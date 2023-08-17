import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class practice3{
public static void main(String[] args) throws IOException{



int[] arr={2,10,5,6};
int targetSum=11;




int sumMax=arr[0];
for(int i=0;i<arr.length;i++){

    for(int j=i+1;j<arr.length;j++){

        if((arr[i]+arr[j])>sumMax){
           sumMax= arr[i]+arr[j];

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
System.out.print("max sum is" + sumMax);
}
}