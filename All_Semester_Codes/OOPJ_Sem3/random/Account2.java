

import java.util.*;
import java.io.*;
import java.util.Scanner;
class Account {
    public static  int min=500;
    String name;
    int Account_num;
    public float o_Price;
    Scanner sc=new Scanner(System.in);
    public void get_info()    {
        System.out.println("Enter Name :");
        name=sc.nextLine();
        System.out.println("Enter Account Number :");
        Account_num=sc.nextInt();
        System.out.println("Enter opening Amount must>500 :");
        o_Price=sc.nextFloat();
        if(o_Price <500)        {
            System.out.println("Enter opening Amount must>500:");
        }
    }
    public void show()    {
        System.out.println("Updated Information -> ");
        System.out.println("Name:"+name);
        System.out.println("Account_number:"+Account_num);
        System.out.println("Account Balance :"+o_Price);
    }
}
class  Current  extends Account {
    float deposit,withdraw,penalty;
    public void deposit()   {
        System.out.println("Enter Amount to deposit : ") ;
        deposit =sc.nextFloat();
        show();
        o_Price=o_Price+deposit;
        System.out.println("Balance After Deposit is : "+o_Price) ;
    }
    public void check_Bal()   {
        if(o_Price<500) {
        o_Price=o_Price-150;
        System.out.println("Rs. 150 have been debited from your account since you went under the balance . Current Balanace : Rs. "+o_Price); }
    }
    public void withdraw_Bal()   {
        System.out.println("Enter Amount to withdraw");
        withdraw=sc.nextFloat();
        show();       /*if(o_Price<500)
    {           System.out.println("For withdrawal Balance must >500 Rupee");       }*/

        if(withdraw<o_Price){
            o_Price=o_Price-withdraw;
            System.out.println("After Withdrawal Balance is : "+o_Price);
        }
        else       {

            System.out.println("Insufficient Balance . After Withdrawal , Balance turns out to be less than 500 rs...Withdrawal failed");
            System.out.println("deducing 500 rupees as a penalty!");
            o_Price=o_Price-500;
        }        check_Bal();
    }
}






class Saving extends Account {
    float deposit,withdraw,intr;
    public void deposit()   {
        System.out.println("Enter Amount to deposit : ") ;
        deposit =sc.nextFloat();
        show();
        o_Price=o_Price+deposit;
        System.out.println("Total Amount is :"+o_Price) ;
    }
    public void check_intrest()   {
        intr=(o_Price*5)/100; //  5% interest
        o_Price=o_Price+intr;
        System.out.println("Total Amount with interest is :"+o_Price) ;
    }
    public void withdraw_Bal()   {
        System.out.println("Enter Amount to withdraw:");
        withdraw=sc.nextFloat();
        show();
        if(withdraw<o_Price){
            o_Price=o_Price-withdraw;
            System.out.println("After Withdrawal Balance: "+o_Price);
        }
        else
        {           System.out.println("Insufficent Balance!");
        }
    }
}



public class Account2 {
    static String ch;
    public static void main(String[] args) {
        int count=0;
        Scanner sc=new Scanner(System.in);
        Current  cu=new Current ();
        Saving  sav=new Saving ();
        System.out.println("Choose Account type:");
        System.out.println("Press c  for Current Account:");
        System.out.println("Press s  for Saving Account:");
        ch=sc.nextLine();   if(ch.equalsIgnoreCase("c"))   {
            cu.get_info();
            cu.check_Bal();
            while(count!=4)       {
                System.out.println("1.Display Account Details\n2.Deposit Money\n3.Withdraw Money\n4.Exit");
                System.out.println("Enter Your Choice");
                int cho=sc.nextInt();
                switch(cho)           {
                    case 1: cu.show();
                        break;
                    case 2: cu.deposit();
                        break;
                    case 3: cu.withdraw_Bal();
                        break;
                    case 4: System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Choice!");
                }
            }
        }
        else if(ch.equalsIgnoreCase("s"))   {
            sav.get_info();
            while(count!=5)       {
                System.out.println("1.Display Account info\n2.Deposit Money\n3.Withdraw Money\n4.Interest\n5.Exit");
                System.out.println("Enter Your Choice");
                int cho=sc.nextInt();           switch(cho)
                {               case 1: sav.show();
                    break;
                    case 2: sav.deposit();
                        break;
                    case 3: sav.withdraw_Bal();
                        break;
                    case 4: sav.check_intrest();
                        break;
                    case 5: System.exit(0);
                        break;
                    default:
                        System.out.println("Wrong Choice!");
                }
            }
        }
        else   {       System.out.println("Wrong choice!");
        }
    }
}





















