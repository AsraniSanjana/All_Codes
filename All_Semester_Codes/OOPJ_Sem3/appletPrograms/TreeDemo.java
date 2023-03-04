import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
public class  TreeDemo extends JApplet
{
    public void init()
    {
        Container contentPane=getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root",true);
        DefaultMutableTreeNode c1=new  DefaultMutableTreeNode("Child 1");
        root.add(c1);
        
         DefaultMutableTreeNode c2=new  DefaultMutableTreeNode("Child 2");
         root.add(c2);
         
          DefaultMutableTreeNode gc1 = new  DefaultMutableTreeNode("GrandChild 1");
          DefaultMutableTreeNode a = new  DefaultMutableTreeNode("A");
          DefaultMutableTreeNode b = new  DefaultMutableTreeNode("B");
          gc1.add(a);
          gc1.add(b);
           DefaultMutableTreeNode gc2 = new  DefaultMutableTreeNode("GrandChild 2");
            DefaultMutableTreeNode gc3 = new  DefaultMutableTreeNode("GrandChild 3");
            
            c2.add(gc1);
            c2.add(gc2);
            c2.add(gc3);
            
             DefaultMutableTreeNode c3 = new  DefaultMutableTreeNode(" Child 3");
             root.add(c3);
              DefaultMutableTreeNode c4 = new  DefaultMutableTreeNode(" Child 4");
              root.add(c4);
               DefaultMutableTreeNode c5 = new  DefaultMutableTreeNode("Child 5");
               root.add(c5);
               
               JTree tree = new JTree(root);
               contentPane.add(tree);
            }
        }