import java.awt.*;
import java.applet.*;
public class GridDemo extends Applet 
{
    int n=2,m=3;
    public void init(){
        setLayout(new GridLayout(n,m));
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                switch(i)
                {
                    case 0: if(j==0)
                    add(new Button("red"));
                    //f.add(new Button("red"); for frame
                    else if(j==1)
                    add(new Button("blue"));
                    else if (j==2)
                    setForeground(Color.green);  // text ka colour green hoga
                    add(new Button("green"));
                    
                    break;
                    
                    
                    case 1: if(j==0)
                    add(new Button("purple"));
                    else if(j==1)
                    add(new Button("yellow"));
                    else if (j==2)
                    add(new Button("violet"));
                    break;
                    
                }}}}}
                    
                    
                    
                    