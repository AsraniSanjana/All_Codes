import java.awt.*;
import java.applet.*;
// change size and positions  of buttons 
/*
 * <applet code = " GridBagLayoutDemo");
 * width = 300
 * height = 100>
 * </applet>
 */

public class GridBagLayoutDemo extends Applet
{
    public void init()
    {
        Button b ;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        //gbc.fill = GridBagConstraints.VERTICAL;
        //gbc.fill = GridBagConstraints.BOTH;
        b = new Button("Button 1");
        gbc.gridx = 0;  // button 1 ka x
        gbc.gridy = 1; // button 1 ka y
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        add(b,gbc);
        
        
        b = new Button("Button 2");
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        add(b,gbc);
        
        
        b = new Button("Button 3");
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 7;
        gbc.gridheight = 1;
        add(b,gbc);
        
        
        
        b = new Button("Button 4");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 8;
        gbc.gridheight = 2;
        add(b,gbc);
        
        
        TextField t = new TextField("Hello Brother");
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        gbc.gridheight = 2; // only integerss
        t.setEditable(false);
        add(t,gbc);
    }
}