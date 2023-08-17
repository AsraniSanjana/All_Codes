
import java.io.*;
class Tree { 
// class Tree has following attributes
    int code, height, base, amount;
    int ucode, uheight, ubase, uamount;

    Tree(int c, int h, int b, int a)// constructor of Tree Class
    {
        code=c;
        height=h;
        base=b;
        amount=a;
    }
    void display()
    {
        System.out.println("Tree Code is: "+code);
        System.out.println("Tree height is: "+height+" feet.");
        System.out.println("Tree base is: "+base+" cm wide.");
        System.out.println("amount spent so far on the tree is : " +" Rs. " + amount);   
    }
    void update() throws IOException  // take updated tree information from user
    {   System.out.println();
        System.out.println();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter updated Tree Code : ");
        ucode=Integer.parseInt(br.readLine());
        System.out.print("Enter updated Tree Height : ");
        uheight=Integer.parseInt(br.readLine());
        System.out.print("Enter updated Tree base : ");
        ubase=Integer.parseInt(br.readLine());
        System.out.print("Enter updated amount spent on the tree : ");
        uamount=Integer.parseInt(br.readLine());
        code=ucode;
        height=uheight;
        base=ubase;
        amount=uamount;
    }
}

class Mango extends Tree {
    int yield;

    public Mango(int c, int h, int b, int a, int y) { // constructor of class Mango
        super(c, h, b, a); //...all same attributes as Parent class Tree  
        yield=y; // additional yield attribute 
    }
  
    void display()
    {
        System.out.println("Mango Tree Code is: "+code);
        System.out.println("Mango Tree height is: "+height+" feet.");
        System.out.println("Mango Tree base is: "+base+" cm wide.");
        System.out.println("amount spent so far on the mango tree is: "+amount+" Rs.");
        System.out.println("yield of the Mango Tree is: "+yield+" fruits.");
    }
}



public class Garden {  // main class Garden
    public static void main(String[] args) throws IOException{
        Tree t=new Tree(10,130,150,20);  // constructor call
        Mango m=new Mango(15,150,170,20,200);
        System.out.println("Information of the Tree is:");
        System.out.println("\n");
        t.display();
        System.out.println("\n");
        System.out.println("Information of the Mango Tree is:");
        System.out.println("\n");
        m.display();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.print("enter y to update and print the updated tree information : ");
        String input=br.readLine();
        if(input.equals("y"))
        {
            t.update();
            System.out.println("\n");
            System.out.println("updated tree information is: ");
            System.out.println("\n");
            t.display();
        }
     }
}