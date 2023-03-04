package p2;
class E extends packages3.A
{
  E()
  {
    pri_data=1;
    data=2;
    prot_data=3;
    pub_data=4;
   }
}

class F
{
  public static void main(String args[])
  {
    packages3.A obj = new packages3.A();
    obj.pri_data=1;
    obj.data=2;
    obj.prot_data=3;
    obj.pub_data=4;
  }
}