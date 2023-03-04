package packages3;
public class A
{
private int pri_data;
int data;
protected int prot_data;
public int pub_data;
public A(){
pri_data=1;
data=2;
prot_data=3;
pub_data=4;
}}
class B extends A{
B(){
pri_data=1;
data=2;
prot_data=3;
prot_data=4;
}}
class C{
C(){
A obj =new A();
obj.pri_data=1;
obj.data=2;
obj.prot_data=4;
obj.pub_data=4;
}}