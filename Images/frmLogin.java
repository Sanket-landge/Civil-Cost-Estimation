
import java.util.*;
import java.text.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.table.*;
import javax.swing.plaf.metal.*;

public class frmLogin extends JFrame implements ActionListener
{
	public static JPanel jpnlMain  	 = new JPanel();
	
	final static String error      	 = "ERROR";		
	final static String genexception = "GENERAL EXCEPTION";		
	final static String relogin 	 = "SORRY LOG-IN FAILED ! PLEASE RE-LOGIN !";
	final static String login   	 = "LOG-IN";
	final static String DBUserName 	 = "niru";
	final static String DBPassword 	 = "niru";
	JTextField txtUserName;
	JPasswordField txtPassword ;
	JButton bttnLogin,bttnCancel;
	int c=0;
	String lname = "niru";
        String passw = "niru";


	Dimension screen 	= 	Toolkit.getDefaultToolkit().getScreenSize();
	
	            
	public frmLogin()
	{	super("SNP CONSTRUCTION");

		
	bttnLogin  	= new JButton("Log-in",new ImageIcon("Images/switch.gif"));
	bttnLogin.setBounds(10,110,105,25);
	bttnLogin.addActionListener(this);	
	bttnLogin.setMnemonic('L');
         
        bttnCancel  	= new JButton("Cancel",new ImageIcon("Images/cancel.gif"));
	bttnCancel.setBounds(130,110,105,25);
	bttnCancel.addActionListener(this);
		

	JLabel lblHeader	= new JLabel();
	lblHeader.setIcon(new ImageIcon("Images/line.gif"));
	lblHeader.setBounds(0,0,750,40);
		
	JLabel lblCaption	= new JLabel("WELCOME TO SNP CONSTRUCTION'S LTD.");
	lblCaption.setBounds(5,2,500,40);
	lblCaption.setForeground(new Color(255,255,255));

	JLabel lblUserName	= new JLabel("Username:");
	lblUserName.setBounds(5,50,105,20);
	
	JLabel lblPassword	= new JLabel("Password:");
	lblPassword.setBounds(5,72,105,20);

	txtUserName		= new JTextField(10);
	txtUserName.setBounds(70,50,170,20);

	 txtPassword 	= new JPasswordField(10);
	txtPassword.setBounds(70,72,170,20);
	txtPassword.setFont(new Font("Dialog", Font.BOLD, 14));

		jpnlMain.setBackground(Color.WHITE);
		jpnlMain.setLayout(null);
		
		//Add Labels
		jpnlMain.add(lblCaption);
		jpnlMain.add(lblHeader);
		jpnlMain.add(lblUserName);
		jpnlMain.add(lblPassword);

		//Add TextBox
		jpnlMain.add(txtUserName);
		jpnlMain.add(txtPassword);

		//Add Buttons
		jpnlMain.add(bttnLogin);
		jpnlMain.add(bttnCancel);
		getContentPane().setLayout(new BorderLayout(0,0));
		getContentPane().add(BorderLayout.CENTER, jpnlMain);

		setVisible(true);
		setSize(255,170);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setLocation((screen.width - 255)/2,((screen.height-170)/2)-17);	
 	}

	public static void main(String s[])
	{
		try
		{
	frmLogin f1=new frmLogin();

		}
		
		catch(Exception e)
		{
		JOptionPane.showMessageDialog(null,"OTHER Exception");
		
		}
	}
	

	 public void actionPerformed(ActionEvent e)
            {

                if(e.getSource() == bttnCancel)
                    {
                        dispose();
                    }

                if(e.getSource() == bttnLogin)
                    {
                        String tlname = txtUserName.getText();
                        String tpassw = txtPassword.getText();	
			String name=tlname.toUpperCase();	
		
		       int i=validation();
			if (i==1)
			{
                        if(lname.compareTo(tlname)==0 && passw.compareTo(tpassw)==0)
                            {
                                txtUserName.setText("");
                                txtPassword.setText("");
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
                               JOptionPane.showMessageDialog(null,"Be CareFully You Are Last Attemp To Login","WARNING",JOptionPane.INFORMATION_MESSAGE);
				 
                            }

                        if(c >= 3)
                            {
				JOptionPane.showMessageDialog(null,"You Lost Three Attemps Of Login Sorry System Is Exiting","WARNING",JOptionPane.INFORMATION_MESSAGE);
				
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

		if(((txtUserName.getText()).trim()).equals("") && ((txtPassword.getText()).trim()).equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter User Name & Password.","Error",JOptionPane.INFORMATION_MESSAGE);
		return 0;
		}
		else if(((txtUserName.getText()).trim()).equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter User Name.","Error",JOptionPane.INFORMATION_MESSAGE);
		return 0;
		}
		else if(((txtPassword.getText()).trim()).equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Password.","Error",JOptionPane.INFORMATION_MESSAGE);
		return 0;
		}		
		else
		{
		return 1;
		}
	
	
	}
			
}
