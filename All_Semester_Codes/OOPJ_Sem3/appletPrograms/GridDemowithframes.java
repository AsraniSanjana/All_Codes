import java.awt.*;
public class GridDemowithframes
{
  public static void main(String args[])
  {
    int n=2,m=3;
    Frame f = new Frame("  ");
    f.setSize(400,400);
    f.setVisible(true);
    f.setLayout(new GridLayout(n,m));
    for(int i=0; i<n; i++)
    {
      for(int j=0; j<m; j++)
       {
         switch(i)
         {
           case 0 : if(j==0)
                    f.add(new Button("RED"));
                    else if(j==1)
                    f.add(new Button("GREEN"));
                    else if(j==2)
                    f.add(new Button("BLUE"));
                    break;
           case 1 : if(j==0)
                    f.add(new Button("RED"));
                    else if(j==1)
                    f.add(new Button("GREEN"));
                    else if(j==2)
                    f.add(new Button("BLUE"));
                    break;
          }
       }
     }
  }
}