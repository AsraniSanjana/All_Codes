import java.util.Scanner;

public class VampireNumber {
    private int vampire = 0;
    private int part1 = 0;
    private int part2 = 0;

    public int getVampire() {
        return vampire;
    }

    public void setVampire(int vampire) {
        this.vampire = vampire;
    }

    public int getPart1() {
        return part1;
    }

    public int getPart2() {
        return part2;
    }

    public int calc(int n1, int n2, int n3, int n4){
        int t1;
        int t2;
        t1 = n1*10 + n2;
        t2 = n3*10 + n4;
        this.part1 = t1;
        this.part2 = t2;
        return t1*t2;
    }

    public boolean isVampire(int number){
        if(number%100 == 0)
            return false;
        int result= 0;
        int n1 = number/100;
        int n2 = number%100;

        int t1, t2, t3, t4;
        t1 = n1/10;
        t2 = n1%10;
        t3 = n2/10;
        t4 = n2%10;

        result = calc(t1,t2,t3,t4);
        if(result == number){
            setVampire(number);
            return true;
        }
        result = calc(t1,t2,t4,t3);
        if(result == number){
            setVampire(number);
            return true;
        }
        result = calc(t2,t1,t3,t4);
        if(result == number){
            setVampire(number);
            return true;
        }
        result = calc(t2,t1,t4,t3);
        if(result == number){
            setVampire(number);
            return true;
        }

        result = calc(t1,t3,t2,t4);
        if(result == number){
            setVampire(number);
            return true;
        }
        result = calc(t1,t3,t4,t2);
        if(result == number){
            setVampire(number);
            return true;
        }
        result = calc(t3,t1,t2,t4);
        if(result == number){
            setVampire(number);
            return true;
        }
        result = calc(t3,t1,t4,t2);
        if(result == number){
            setVampire(number);
            return true;
        }

        result = calc(t1,t4,t2,t3);
        if(result == number){
            setVampire(number);
            return true;
        }
        result = calc(t1,t4,t3,t2);
        if(result == number){
            setVampire(number);
            return true;
        }
        result = calc(t4,t1,t2,t3);
        if(result == number){
            setVampire(number);
            return true;
        }
        result = calc(t4,t1,t3,t2);
        if(result == number){
            setVampire(number);
            return true;
        }

        return false;
    }

    public static void main(String[] args){
        VampireNumber vnum=new VampireNumber();
        System.out.print("Enter  the four digit number : ");
        Scanner sc=new Scanner(System.in);
        int number =sc.nextInt();
        if(number<1000  || number>10000)
        {
           System.out.print("Please enter a four digit nuber");
            number= sc.nextInt();
        }
        else
        {
            if(vnum.isVampire(number)){
                System.out.println(number + " is a vampire number. ");
                System.out.println("Since " + vnum.getVampire() + " = " + vnum.getPart1() + " * " + vnum.getPart2() + ".");

            }
            else{
                System.out.println(number + " is not a vampire number. ");
            }
        }

    }
}