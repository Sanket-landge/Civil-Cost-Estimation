import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class SampleDialog extends JDialog implements ActionListener
    {
        JButton b;

        SampleDialog(Frame p,String t)
            {
                super(p,t,false);
                setLayout(new FlowLayout());
                setSize(300,100);

                add(new JLabel("U Entered Incorrect Login Name Or Password."));                

                add(b=new JButton("OK"));
                b.addActionListener(this);
            }

        public void actionPerformed(ActionEvent ae)
            {
                if(ae.getSource() == b)
                    {
                        dispose();
                    }
            }
    }
