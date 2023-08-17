
/*

import java.lang.*;

class Numbers {

   boolean isPrime(int n) {
    for(int i=2; i<n; i++){
        // if the number is divisible by i, then n is not a prime number.
        if(n%i==0) return false;
    }
    //otherwise, n is prime number.
          return true;}
      synchronized void printPrime(int n) {
       for(int j=1; j<=20; j++){
           //check if current number is prime
           if(isPrime(j)) {
               System.out.print(j + " ");} } }
}
class MyThread1 extends Thread {
    Numbers t;
    public MyThread1(Numbers t) {
        this.t = t;
    }
    public void run() {
        t.printPrime(5);
    }}
class MyThread2 extends Thread {
    Numbers t;
    public MyThread2(Numbers t) {
        this.t = t;
    }
    public void run() {
        t.printPrime(7);
    }}

class MyThread3 extends Thread {
    Numbers t;
    public MyThread3(Numbers t) {
        this.t = t;
    }
    public void run() {
        t.printPrime(13);
    }}


public class Multithreading2  {
    public static void main(String args[]) {
        Numbers obj = new Numbers();
        // NOW THESE THREE THREADS CAN SWITCH LIKE THIS
        // MULTIPLICATION TABLE OF 7,13,5 OR 5,13,7 OR WHATEVER
        // BUT THE WHOLE THREAD WILL EXECUTE AT ONCE i.e. TABLE OF 5 COMPLETELY TOGETHER , 7 COMPLETELY TOGETHER, 13 COMPLETELY TOGETHER
        // THIS IS DUE TO SYNCHRONIZED KEYWORD
        // REMOVE IT TO SEE SWICTHING EVEN BETWEEN THE THREAD FUNCTIONS
        MyThread1 t1 = new MyThread1(obj);
        MyThread2 t2 = new MyThread2(obj);
        MyThread3 t3 = new MyThread3(obj);
        t1.start();
        t2.start();
        t3.start();
    }
}


*/



import java.lang.*;
class Numbers {

   synchronized void PrintMultiplicationTable(int n)
    {
        for(int i=1 ; i<=10 ; i++) {
        System.out.println(n+"*"+i+"="+i*n);

    }
    }
}
class MyThread1 extends Thread {
    Numbers t;
    public MyThread1(Numbers t) {
        this.t = t;
    }
    public void run() {
        t.PrintMultiplicationTable(5);
}}
class MyThread2 extends Thread {
    Numbers t;
    public MyThread2(Numbers t) {
        this.t = t;
    }
    public void run() {
        t.PrintMultiplicationTable(7);
}}

class MyThread3 extends Thread {
    Numbers t;
    public MyThread3(Numbers t) {
        this.t = t;
    }
    public void run() {
        t.PrintMultiplicationTable(13);
    }}


public class Multithreading2{
    public static void main(String args[]) {
        Numbers obj = new Numbers();
        // NOW THESE THREE THREADS CAN SWITCH LIKE THIS
        // MULTIPLICATION TABLE OF 7,13,5 OR 5,13,7 OR WHATEVER
        // BUT THE WHOLE THREAD WILL EXECUTE AT ONCE i.e. TABLE OF 5 COMPLETELY TOGETHER , 7 COMPLETELY TOGETHER, 13 COMPLETELY TOGETHER
        // THIS IS DUE TO SYNCHRONIZED KEYWORD
        // REMOVE IT TO SEE SWICTHING EVEN BETWEEN THE THREAD FUNCTIONS
        MyThread1 t1 = new MyThread1(obj);
        MyThread2 t2 = new MyThread2(obj);
        MyThread3 t3 = new MyThread3(obj);
        t1.start();
        t2.start();
        t3.start();
    }
}
