import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
public class Flash extends JWindow 
{

   public Flash(String f1) 
{   
     JLabel labl    = new JLabel(new ImageIcon(f1));
        Color clr = new Color(0, 0, 0);    
    labl.setBorder(new LineBorder(clr, 1));  
      getContentPane().add(labl, BorderLayout.CENTER);   
     pack();    
    Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize(); 
       Dimension lSize = labl.getPreferredSize(); 
     setLocation(sSize.width/2  - (lSize.width/2), sSize.height/2 - (lSize.height/2));

    } 


  public void exit1()
 {  
   setVisible(false);  
 	 dispose();  
  }
}
