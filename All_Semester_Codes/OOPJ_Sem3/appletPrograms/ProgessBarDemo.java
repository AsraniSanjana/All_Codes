import java.awt.*;
import javax.swing.*;

public class ProgessBarDemo 
{
    static JFrame f;
    static JProgressBar pbar;
    public static void main(String[]args)
    {
        f = new JFrame("Progress Bar Demo");
        f.setLayout(new FlowLayout());
        pbar=new JProgressBar(0,2000);
        pbar.setValue(0);
        pbar.setStringPainted(true);
        f.add(pbar);
        //f.setLayout(null);
        f.setSize(500,500);
        f.setVisible(true);
        fillBar();
    }
    public static void fillBar()
    {
        int i = 0;
        try
        {
            while(i<=2000)
            {
                pbar.setValue(i);
                Thread.sleep(100);
                i=i+20;
            }
        }
        catch(Exception e)
        {}
    }
}