/* weather.csv
day,outlook,temperature,humidity,wind,playTennis
1,sunny,hot,high,weak,no
2,sunny,hot,high,strong,no
3,overcast,hot,high,weak,yes
4,rainy,mild,high,weak,yes
5,rainy,cool,normal,weak,yes
6,rainy,cool,normal,strong,no
7,overcast,cool,normal,strong,yes
8,sunny,mild,high,weak,no
9,sunny,cool,normal,weak,yes
10,rainy,mild,normal,weak,yes
11,sunny,mild,normal,strong,yes
12,overcast,mild,high,strong,yes
13,overcast,hot,normal,weak,yes
14,rainy,mild,high,strong,no

*/


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class naiveBayes{
    
    // public static String[] col0 = ReadColumn(0); 
    public static String[] col1 = ReadColumn(1); 
    public static String[][] col = {ReadColumn(0),ReadColumn(1),ReadColumn(2),ReadColumn(3),ReadColumn(4),ReadColumn(5)}; 
    public static int len = col1.length; // no of rows
    public static int no_of_cols=col.length; 
    public static int noY=0, noN=0;
    public static int no_of_records=0;
    public static Double p=0.0;

    public static int find_p(String attribute,String value,String Aclass,int Ano){  // Ano starts from 0
for(int j=1;j<len;j++){
     
    if(col[Ano][j].equalsIgnoreCase(value) && col[no_of_cols-1][j].equalsIgnoreCase(Aclass)) {
       // System.out.println(j+".\t\t\t\t"+col[0][j]+"\t\t\t\t"+col[1][j]);
        no_of_records++;
   
    }
    
    }
    if (Aclass.equalsIgnoreCase("yes")){
    p=((no_of_records)/(double) noY);}
    else p=((no_of_records)/(double) noN);
    

    //System.out.println("value of p="+p);
    p=0.0; // reseting the value of p for next fn call

return no_of_records;
    }

    
    public static int find_n(String attribute,String value,int Ano){
        
        for(int j=1;j<len;j++){
             
            if(col[0][j].equalsIgnoreCase(value)) {
                //System.out.println(j+".\t\t\t\t"+col[Ano][j]+"\t\t\t\t"+col[no_of_cols-1][j]);
                no_of_records++;
           
            }
            
            }
           
                p=((no_of_records)/(double) len-1);
               // System.out.println("value of p="+p);
            
           
        return no_of_records;
        
            }



    

    public static void main (String args[]) {

 Scanner sc = new Scanner(System.in);
/*code to get no of yes & no from whole dataset */
  for(int i = 1; i < len; i++)  
        {
           if(col[no_of_cols-1][i].equalsIgnoreCase("yes"))  
 {
                noY++;
            } else {
                noN++;
            }
        }

       


// System.out.println("===================printing the dataset===============");

// for(int j=0;j<len;j++){
//  System.out.println(j+".\t\t\t\t"+col[0][j]+"\t\t\t\t"+col[1][j]);
// }

System.out.println("no of records = "+(len-1));
System.out.println("n(yes) = "+noY); // no of yes
System.out.println("n(no) = "+noN);  // no of no

// System.out.println(no_of_cols()); isnt working
/* useless 
System.out.print("enter number of attributes/cols: ");// except class label
//takes an integer input   
int no_of_cols= sc.nextInt();
String[] values_ip = new String [no_of_cols];      
//consuming the <enter> from input above  
System.out.println("enter the values :"); 
sc.nextLine();   
for (int i = 0; i < values_ip.length; i++)   
{  
values_ip[i] = sc.nextLine();  // female,winter,above 31,no
}  

System.out.println("The following query is to be tested:");

// getting all attribute/coln names in an array. i=0 row of all columns attribute_taken:values_ip
String[] attributes_taken = new String [no_of_cols];   

for(int col_no=0;col_no<no_of_cols;col_no++){
    
attributes_taken[col_no]=col[col_no][0]; //gender,season,age_group,bought_umbrella
    }
for(int m=0;m<no_of_cols;m++){
// System.out.print("the values :"+values_ip[m]+",");
// System.out.println("the attribute :"+attributes_taken[m]);
// System.out.println(attributes_taken[m]+":"+values_ip[m]);

}
System.out.println();
System.out.println(find_p(attributes_taken[0],values_ip[0],values_ip[no_of_cols]));

*/


// if gender=female,season=rainy,age group=13-19,will he buy an umbrella. kid, teen, adult , old

System.out.println("p(yes)="+noY/((double)len-1));
System.out.println("p(no)="+noN/((double)len-1));
System.out.println();

/*
no_of_records=0;
System.out.println("p(sunny)="+(find_n("weather","sunny"))/((double)len-1));
no_of_records=0;
System.out.println("p(rainy)="+(find_n("weather","rainy"))/((double)len-1));
no_of_records=0;
System.out.println("p(overcast)="+(find_n("weather","overcast"))/((double)len-1));
*/
/*
double a=find_p("gender","female","yes");
double b=find_p("gender","female","no");

double c=find_p("season","rainy","yes");
double d=find_p("season","rainy","no");

double e=find_p("age_group","teen","yes");
double f=find_p("age_group","teen","no");

*/
// Ano=0 day,1 outlook,2 temp,humid,wind,playTennis
no_of_records=0;
double a=find_p("outlook","sunny","yes",1);
a=a/(double)noY;
no_of_records=0;
double b=find_p("outlook","sunny","no",1);
b=b/(double)noN;
no_of_records=0;

double c=find_p("temperature","cool","yes",2);
c=c/(double)noY;
no_of_records=0;
double d=find_p("temperature","cool","no",2);
d=d/(double)noN;
no_of_records=0;

double e=find_p("humiditity","high","yes",3);
e=e/(double)noY;
no_of_records=0;
double f=find_p("humiditity","high","no",3);
f=f/(double)noN;
no_of_records=0;

double g=find_p("wind","strong","yes",4);
g=g/(double)noY;
no_of_records=0;
double h=find_p("wind","strong","no",4);
h=h/(double)noN;
no_of_records=0;



double prob_yes=noY/((double)len-1);
double prob_no=noN/((double)len-1);
double prob_all_yes=prob_yes*a*c*e*g;
double prob_all_no=prob_no*b*d*f*h;
// if (prob_all_yes>prob_all_no)  { System.out.println("Predicted Yes."); }
// else System.out.println("Predicted no.");

System.out.println(a+",\t"+c+",\t"+e+",\t"+g);
System.out.println(b+",\t"+d+",\t"+f+",\t"+h);

System.out.println("P(all yes)="+prob_all_yes);
System.out.println("P(all no)="+prob_all_no);

System.out.println("P(predict yes)="+prob_all_yes/((double)prob_all_yes+prob_all_no));
System.out.println("P(predict no)="+prob_all_no/((double)prob_all_yes+prob_all_no));

    }// psvm band kiya

    
    //Function to read columns
    public static String[] ReadColumn(int col) {
        ArrayList<String> colData = new ArrayList<String>();

        try {
            FileReader fr = new FileReader("weather.csv");
            BufferedReader br = new BufferedReader(fr);
            String currentLine;

            while((currentLine = br.readLine()) != null) {
                String[] data = currentLine.split(",");
                colData.add(data[col]);
            } // while closed

            br.close();
        } // try band kiya
        catch(Exception e){
            return null;
        }

        return colData.toArray(new String[0]);
    } // readcoln method band hua

/* 



// fn to read number of cols
    public static int num_of_cols() {
        ArrayList<String> colData = new ArrayList<String>();

        try {
            int columns = 0;
String currentRow = null;

try (BufferedReader csvDataFile = new BufferedReader(new FileReader("weather.csv"))) {
currentRow = csvDataFile.readLine();
String[] headers = currentRow.split(",");
columns = headers.length;
// System.out.println("number of cols in the dataset weather.csv are :"+columns);
return columns;
} 


        } // try band kiya
        catch(Exception e){
            return 0;
        }

        
    } 
    */



        
} // class band hua 