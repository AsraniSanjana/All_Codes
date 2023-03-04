import java.awt.*;
import javax.swing.*;
public class TableDemo extends JApplet
{
    public void init()
    {
        Container contentPane=getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        final String[] th = { "Name", "City", "Salary","Destination"};
        final Object[][] mytable = {
            {"Pratham","ulhasnagar","1000","Accountant"},
            {"Dev","Pune","7000","Executive"},
            {"sagar","Chennai","10000", "Manager"}
        };
       
       JTable table = new JTable(mytable,th);
       
       int vs =ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
       int hs= ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
       JScrollPane mypane = new JScrollPane(table,vs,hs);
       contentPane.add(mypane, BorderLayout.CENTER);
    }
}