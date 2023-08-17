import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class practice{
public static void main(String[] args) throws IOException{
// int arr[]={2,3,8,9};
    
//     Scanner sc=new Scanner(System.in);
//     System.out.print("enter size of the array:");
// int arrSize=sc.nextInt();
//  int[] arr = new int[arrSize]; 
// System.out.print("enter an arry of integers:");
// for( int i=0; i<arrSize;i++){
// arr[i]=sc.nextInt();
// }

// InputStreamReader isr=new InputStreamReader(System.in);
//  BufferedReader br=new BufferedReader(isr);
//   System.out.print("enter size of the array:");
//        int arrSize=Integer.parseInt(br.readLine());
//        
//        for(int i=0;i<arrSize;i++)
//        {
//          //String str=br.readLine();
//          //String strArray[]=br.readLine().split(" ");
//          arr[i] = Integer.parseInt(br.readLine());
//        }


int[] arr={2,9,5,6};
int targetSum=11;





for(int i=0;i<arr.length;i++){

    for(int j=i+1;j<arr.length;j++){

        if((arr[i]+arr[j])==targetSum){
            System.out.print(arr[i] + " and " + arr[j] + " = " + targetSum +",");
        }

        

        /*
        arr[0] , arr[1] =   2,3    5
        arr[0] , arr[2] =   2,5    7
        arr[0] , arr[3] =   2,6    8

        arr[1] , arr[2]
        1,3

        2,3
        

         */



    }}

}
}