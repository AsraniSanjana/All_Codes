class A{
A( ){
System.out.println("A");
}
}
public class B extends A{
public static void main(String args[]){
B b1=new B( );
super( );
}
B(){
System.out.println("B");
}
}