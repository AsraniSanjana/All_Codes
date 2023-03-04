//CREATING LABELS USING APPLETS
import java.awt.*;
import java.applet.*;
public class Use_Label extends Applet
{
   public void init()
   {
       Label L1 = new Label("OK");
       Label L2 = new Label("Cancel");
       add(L1);
       add(L2);
    }
}