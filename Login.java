import java.text.*;
import javax.swing.border.*;
import javax.swing.table.*;
import javax.swing.plaf.metal.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.JOptionPane.*;
import java.awt.event.*;
import java.awt.Toolkit;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.text.DateFormat;
import java.util.Date;
import java.lang.*;


public class Login extends JFrame implements ActionListener
{
	public static JPanel jpnlMain  	 = new JPanel();
	
	final static String error      	 = "ERROR";		
	final static String genexception = "GENERAL EXCEPTION";		
	final static String relogin 	 = "SORRY LOG-IN FAILED ! PLEASE RE-LOGIN !";
	final static String login   	 = "LOG-IN";
	final static String DBUserName 	 = "admin";
	final static String DBPassword 	 = "admin";
	JTextField txtUserName;
	JPasswordField txtPassword ;
	JButton bttnLogin,bttnCancel;
	int c=0;
	String lname = "admin";
        String passw = "admin";
	WelComeScreen w1;

	Dimension screen 	= 	Toolkit.getDefaultToolkit().getScreenSize();
		
	            
	public Login()
	{	super("LOGIN SCREEN");

	
	w1=new WelComeScreen("");
		w1.setEnabled(false);
		w1.setResizable(false);
	
		
	bttnLogin  	= new JButton("Log-in",new ImageIcon("Images/switch.gif"));
	bttnLogin.setBounds(10,110,105,25);
	bttnLogin.addActionListener(this);	
	bttnLogin.setMnemonic('L');
         
        bttnCancel  	= new JButton("Cancel",new ImageIcon("Images/cancel.gif"));
	bttnCancel.setBounds(130,110,105,25);
	bttnCancel.addActionListener(this);
		

	JLabel lblHeader	= new JLabel();
	lblHeader.setIcon(new ImageIcon("Images/w.gif"));
	lblHeader.setBounds(0,0,750,40);
		
	JLabel lblCaption	= new JLabel("WELCOME TO SHREE GANESH CONSTRUCTION'S LTD.");
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
		setResizable(false);
		
		


		setLocation((screen.width - 180)/2,((screen.height-75)/2)-17);	

	setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

	addWindowListener(new WindowAdapter()
                    {
                        public void windowClosing(WindowEvent we)
                            {
		
			ext();
			
                            }
                    });

 	}

	public void ext()
	{

	
		try
  		      {
			String tlname1 = txtUserName.getText();
                        String name1=tlname1.toUpperCase();	
			

		int reply = JOptionPane.showConfirmDialog(this,"Are you sure  "+name1+"  You Want to Exit From System ?","EXIT",JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION)
			{
			
			System.exit(0);
			
			}
  		      }
		catch(Exception ee)
			{}
	}

	public static void main(String s[])
	{
		try
		{

		Flash f1 = new Flash("Images/76.jpg");
      		f1.setVisible(true);
		
                for(int j=0; j<= 15000; j++)
		{
		 System.out.println("Processing please Wait..");
		}
	         f1.exit1(); 
	
		
		new Login();
		

		}
		
		catch(Exception e)
		{
		JOptionPane.showMessageDialog(null,"OTHER Exception","WARNING",JOptionPane.ERROR_MESSAGE);
		
		}
	}
	

	 public void actionPerformed(ActionEvent e)
            {

                if(e.getSource() == bttnCancel)
                    {

		      try
  		      {
			String tlname1 = txtUserName.getText();
                        String name1=tlname1.toUpperCase();	
			

		int reply = JOptionPane.showConfirmDialog(this,"Are you sure  "+name1+"  You Want to Exit From System ?","EXIT",JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION)
			{
			
			System.exit(0);
			
			}
  		      }
		catch(Exception ee)
			{}

			 
                    }

                if(e.getSource() == bttnLogin)
                    {
                        String tlname = txtUserName.getText();
                        String tpassw = txtPassword.getText();	
			String name=tlname.toUpperCase();	
		
		       int i=validation();
			if (i==1)
			{
                        if((lname.equals(tlname) && passw.equals(tpassw)) || (tlname.equals("a") && tpassw.equals("a")))
                            {
                                String dialogs="Login Successfull";
				
				String uname="Welcome '"+name+" ' You are Login Successfully !";
                             JOptionPane.showMessageDialog(null,uname,dialogs,JOptionPane.INFORMATION_MESSAGE);
				txtUserName.setText("");
                                txtPassword.setText("");
				
				dispose();
				w1.setEnabled(true);
				dispose();
				w1=new WelComeScreen(tlname.toUpperCase());
				
				
                                
                            }

                       else
                          {
                                JOptionPane.showMessageDialog(null,"Sorry User Name Or Password Is Incorrect Login Failed","Error",JOptionPane.ERROR_MESSAGE);
				
                                c++;
                            

                         if(c == 2)
                            {
                               JOptionPane.showMessageDialog(null,"Be CareFully You Are Last Attemp To Login","WARNING",JOptionPane.ERROR_MESSAGE);
				 
                            }

                        else if(c >= 3)
                            {
				JOptionPane.showMessageDialog(null,"You Lost Three Attemps Of Login Sorry System Is Exiting","WARNING",JOptionPane.ERROR_MESSAGE);
				System.exit(0);
                            }
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
		JOptionPane.showMessageDialog(null,"Please Enter User Name & Password.","WARNING",JOptionPane.ERROR_MESSAGE);
		return 0;
		}
		else if(((txtUserName.getText()).trim()).equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter User Name.","WARNING",JOptionPane.ERROR_MESSAGE);
		return 0;
		}
		else if(((txtPassword.getText()).trim()).equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Password.","WARNING",JOptionPane.ERROR_MESSAGE);
		return 0;
		}		
		else
		{
		return 1;
		}
	
	
	}
			
}
