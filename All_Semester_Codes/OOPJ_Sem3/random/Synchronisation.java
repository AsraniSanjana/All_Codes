
import java.util.*;
import java.lang.*;
class Numbers {
   synchronized void printNumbers(int n) {for // 1 thread at a time
  //void printNumbers(int n) {for
    (int i=1 ; i<=10 ; i++) {
        System.out.println(n++); // will print even numbers if n is even
       // will print odd numbers if n is odd
        n++;
        try {
            //Thread.sleep(400); // to delay the op
        }
        catch (Exception e) {System.out.println(e);
        }
    }
    }
}
class MyThread1 extends Thread {
    Numbers t;
    public MyThread1(Numbers t) {
        this.t = t;
    }
    public void run() {
        t.printNumbers(0);  // 0,2,4,6,8,10,112,14,16,18
    }
}
class MyThread2 extends Thread {
    Numbers t;
    public MyThread2(Numbers t) {
        this.t = t;
    }
    public void run() {
        t.printNumbers(1);  // 1,3,5,7,9,11,13,15,17,19
    }
}
public class Synchronisation{
    public static void main(String args[]) {
        Numbers obj = new Numbers();
        MyThread1 t1 = new MyThread1(obj);
        MyThread2 t2 = new MyThread2(obj);
        t1.start();
        t2.start();
    }
}

