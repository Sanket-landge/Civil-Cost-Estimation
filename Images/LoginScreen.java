import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame implements ActionListener
    {
        JLabel name,lin,pass;
        JButton bin,can;
        JTextField tlin;
        JPasswordField pf;
        Font f1,f2;
        int c = 0;        
        String lname = "niru";
        String passw = "niru";

        LoginScreen()
            {
                setLayout(null);
                setSize(1024,768);
                setVisible(true);
				
                f1 = new Font("Times New Roman",Font.BOLD,36);
                f2 = new Font("Times New Roman",Font.BOLD,18);

                name = new JLabel("Shree Ganesh Construction");
                
                
                lin = new JLabel("Enter Login Name :-");
                pass = new JLabel("Enter Password :-");

                bin = new JButton("Login");
                can = new JButton("Cancel");

                tlin = new JTextField();
                pf = new JPasswordField();
                pf.setEchoChar('*');

                add(name);                      add(lin);
                add(pass);
                name.setFont(f1);
                lin.setFont(f2);
                pass.setFont(f2);

                name.setBounds(300,5,450,40);
                lin.setBounds(250,200,200,40);
                pass.setBounds(250,300,200,40);

                add(bin);                       add(can);

                bin.setBounds(270,400,200,40);
                can.setBounds(490,400,200,40);

                bin.addActionListener(this);
                can.addActionListener(this);

                add(tlin);                      add(pf);

                tlin.setBounds(460,210,200,30);
                pf.setBounds(460,310,200,30);

            }

        public void actionPerformed(ActionEvent e)
            {

                if(e.getSource() == can)
                    {
                        dispose();
                    }

                if(e.getSource() == bin)
                    {
                        String tlname = tlin.getText();
                        String tpassw = pf.getText();	
			String name=tlname.toUpperCase();			
		       int i=validation();
			if (i==1)
			{
                        if(lname.compareTo(tlname)==0 && passw.compareTo(tpassw)==0)
                            {
                                tlin.setText("");
                                pf.setText("");
				String dialogs="Login Successfull";
				String uname="Welcome "+name+" You are Login Successfully";
                             JOptionPane.showMessageDialog(null,uname,dialogs,JOptionPane.INFORMATION_MESSAGE);
		
                                new WelComeScreen();
                            }

                        if(lname.compareTo(tlname)!=0 || passw.compareTo(tpassw)!=0)
                            {
                                JOptionPane.showMessageDialog(null,"Sorry User Name Or Password Is Incorrect Login Failed","Error",JOptionPane.INFORMATION_MESSAGE);
				
                                c++;
                            }

                        if(c == 2)
                            {
                               JOptionPane.showMessageDialog(null,"Be CareFully You Are Last Attemp To Login","Error",JOptionPane.INFORMATION_MESSAGE);
				 
                            }

                        if(c >= 3)
                            {
				JOptionPane.showMessageDialog(null,"You Lost Three Attemps Of Login Sorry System Is Exiting","Error",JOptionPane.INFORMATION_MESSAGE);
				
                                dispose();
                            }
			}
			else
			{
			
			}		

                    }

            }

	public int validation()
	{

		if(pf.getText().equals("") && tlin.getText().equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter User Name & Password.","Error",JOptionPane.INFORMATION_MESSAGE);
		return 0;
		}
		else if(tlin.getText().equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter User Name.","Error",JOptionPane.INFORMATION_MESSAGE);
		return 0;
		}
		else if(pf.getText().equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Password.","Error",JOptionPane.INFORMATION_MESSAGE);
		return 0;
		}		
		else
		{
		return 1;
		}
	
	
	}

        public static void main(String args[])
            {
                new LoginScreen();   
            }
    }
