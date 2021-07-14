import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.event.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NewScreen extends JFrame implements ActionListener,ItemListener
    {
        JLabel lnl,lnow,lnow1,lnow2,lname,lcno,lpno,lcost,latp,ltal,ldist,lem,lprof;
        JTextField tname,tname2,tname3,tcno,tpno,tcost,tatp,ttal,tdist,tem,tprof;
        JButton bsave,bnew,bexit;
        JComboBox ch;
        Font f;
	
	public int temp;
        public Connection cn;
        public Statement stm;
        public ResultSet rs;
        public String sql;
        public PreparedStatement prstm;
	Dimension screen 	= 	Toolkit.getDefaultToolkit().getScreenSize();
	

        NewScreen()
            {
                super("New Entry Screen....");
                setLayout(null);
                setSize(620,598);
                setVisible(true);
		setBackground(Color.white);
		setLocation((screen.width - 620)/2,((screen.height-598)/2)-17);	


                f = new Font("ALGERIAN",Font.BOLD,26);

                lnl = new JLabel("SHREE GANESH CONSTRUCTION");
                lnow = new JLabel("Name Of Work :- ");
                lnow1 = new JLabel("Proposed Construction Of");
                lnow2 = new JLabel("Building");
                lname = new JLabel("Name [F/M/L:-");
                lcno = new JLabel("Customer No. :-");
                lpno = new JLabel("Plot No. :-");
                lcost = new JLabel("COST :-");
                latp = new JLabel("At Post :-");
                ltal = new JLabel("Tal :-");
                ldist = new JLabel("Dist :-");
		lem = new JLabel("E-Mail ID :-");
		lprof = new JLabel("Profession :-");

                ch = new JComboBox();

                tname = new JTextField();
		tname2 = new JTextField();
		tname3 = new JTextField();
                tcno = new JTextField();
                tpno = new JTextField();
                tcost = new JTextField();
                tatp = new JTextField();
                ttal = new JTextField();
                tdist = new JTextField();
		tem = new JTextField();
		tprof = new JTextField();

                bsave = new JButton("Save");
                bnew = new JButton("New");
                
                
                bexit = new JButton("Exit");
ch.setForeground(new Color(91,59,221));

lnl.setForeground(new Color(141,41,21));
                
bsave.setForeground(new Color(41,41,221));
bnew.setForeground(new Color(41,41,221));
bexit.setForeground(new Color(41,41,221));
                add(lnl);                    add(lnow);
                add(lnow1);                    add(lnow2);
                add(lname);                    add(lcno);
                add(lpno);                    add(lcost);
                add(latp);                    add(ltal);
		 add(ldist);
		  add(lnl); 		      add(lprof);
                add(lem);
                lnl.setFont(f);

                lnl.setBounds(50,5,500,40);
                lnow.setBounds(5,75,100,40);
                lnow1.setBounds(105,75,150,40);
                lnow2.setBounds(420,75,100,40);
                lname.setBounds(5,115,100,40);
                lcno.setBounds(5,155,100,40);
                lpno.setBounds(5,195,100,40);
                lcost.setBounds(5,235,100,40);
                latp.setBounds(5,275,100,40);
                ltal.setBounds(5,315,100,40);
                ldist.setBounds(5,355,100,40);
		lem.setBounds(5,395,100,40);
		lprof.setBounds(5,435,100,40);

                add(ch);
                ch.addItem("[Select]");
                ch.addItem("Residential");
                ch.addItem("Official");
                ch.setBounds(260,75,150,30);

                add(tname);
		add(tname2); 			add(tname3); 
                add(tcno);
                add(tpno);                      add(tcost);
                add(tatp);                      add(ttal);
                add(tdist);
		add(tem);			add(tprof);

                tname.setBounds(105,125,120,20);
		tname2.setBounds(235,125,120,20);
		tname3.setBounds(365,125,120,20);
                tcno.setBounds(105,165,200,20);
                tpno.setBounds(105,205,200,20);
                tcost.setBounds(105,245,200,20);
                tatp.setBounds(105,285,200,20);
                ttal.setBounds(105,325,200,20);
                tdist.setBounds(105,365,200,20);
		tem.setBounds(105,405,200,20);
		tprof.setBounds(105,445,200,20);

                add(bsave);        
                add(bnew);
                
                add(bexit);                    

                bsave.setBounds(15,495,80,30);
                bnew.setBounds(105,495,80,30);
                
                bexit.setBounds(195,495,80,30);
                
				
                bsave.addActionListener(this);
                bnew.addActionListener(this);
                
                bexit.addActionListener(this);




		tname.setEnabled(false);
		tname2.setEnabled(false);
		tname3.setEnabled(false);
                tcno.setEnabled(false);
                tpno.setEnabled(false);
                tcost.setEnabled(false);
                tatp.setEnabled(false);
                ttal.setEnabled(false);
                tdist.setEnabled(false);
		tem.setEnabled(false);
		tprof.setEnabled(false);


//*****************Text Box Validations*********************

tname.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c=e.getKeyChar();
				if ((Character.isDigit(c)))
				{
					JOptionPane.showMessageDialog(null,"You should enter only Character value","ERROR",JOptionPane.ERROR_MESSAGE);
				
                                         e.consume();
			         }
                        }
		});

tcno.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c=e.getKeyChar();
				if (!(Character.isDigit(c)))
				{
					JOptionPane.showMessageDialog(null,"You should enter only numeric value","ERROR",JOptionPane.ERROR_MESSAGE);
				
                                        e.consume();
			         }
                         }
		});


tpno.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c=e.getKeyChar();
				if (!(Character.isDigit(c)))
				{
					JOptionPane.showMessageDialog(null,"You should enter only numeric value","ERROR",JOptionPane.ERROR_MESSAGE);
				
                                       e.consume();
			         }
                        }
		});

tcost.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c=e.getKeyChar();
				if (!(Character.isDigit(c)))
				{
					JOptionPane.showMessageDialog(null,"You should enter only numeric value","ERROR",JOptionPane.ERROR_MESSAGE);
				
                                        e.consume();
			         }
                        }
		});

tatp.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c=e.getKeyChar();
				if ((Character.isDigit(c)))
				{
					JOptionPane.showMessageDialog(null,"You should enter only Character value","ERROR",JOptionPane.ERROR_MESSAGE);
				        e.consume();
			        }
                        }
		});

ttal.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c=e.getKeyChar();
				if ((Character.isDigit(c)))
				{
					JOptionPane.showMessageDialog(null,"You should enter only Character value","ERROR",JOptionPane.ERROR_MESSAGE);
				        e.consume();
			         }
                         }
		});

tdist.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c=e.getKeyChar();
				if ((Character.isDigit(c)))
				{
					JOptionPane.showMessageDialog(null,"You should enter only Character value","ERROR",JOptionPane.ERROR_MESSAGE);
				
                                        e.consume();
			         }
                        }
		});

/*tem.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c=e.getKeyChar();
				if ((Character.isDigit(c)))
				{
					JOptionPane.showMessageDialog(null,"You should enter only Character value","ERROR",JOptionPane.ERROR_MESSAGE);
				
                                        e.consume();
			         }
                        }
		}); */

tprof.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c=e.getKeyChar();
				if ((Character.isDigit(c)))
				{
					JOptionPane.showMessageDialog(null,"You should enter only Character value","ERROR",JOptionPane.ERROR_MESSAGE);
				
                                        e.consume();
			         }
                        }
		});

tname2.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c=e.getKeyChar();
				if ((Character.isDigit(c)))
				{
					JOptionPane.showMessageDialog(null,"You should enter only Character value","ERROR",JOptionPane.ERROR_MESSAGE);
				
                                        e.consume();
			         }
                        }
		});


tname3.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c=e.getKeyChar();
				if ((Character.isDigit(c)))
				{
					JOptionPane.showMessageDialog(null,"You should enter only Character value","ERROR",JOptionPane.ERROR_MESSAGE);
				
                                        e.consume();
			         }
                        }
		});


//*****************Text Box Validations End*********************

                
               

                try {
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				    cn = DriverManager.getConnection("jdbc:odbc:avisun");
                    stm = cn.createStatement();

			 
                    }

                catch (ClassNotFoundException e)
                    {
                        e.printStackTrace();
                    }
                catch (SQLException e)
                    {
                        e.printStackTrace();
                    }
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
			int reply = JOptionPane.showConfirmDialog(this,"Are you sure You Want to Exit From System ?","EXIT",JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION)
		
			{
			
			dispose();
			new Login();
			
			}
  		      }
		catch(Exception ee)
			{}
	}

        public void actionPerformed(ActionEvent e)
            {
              if(e.getSource()==bsave)
		
                {
		  int i=validation();
		  if(i==1)
		  {
                  try
                    {
                      
		      sql = "Insert into New values('"+ch.getSelectedItem().toString()+"','"+tname.getText()+"','"+tname2.getText()+"','"+tname3.getText()+"'," +tcno.getText()+ "," +tpno.getText()+ "," +tcost.getText()+",'"+tatp.getText()+"','" +ttal.getText()+"','" +tdist.getText()+"','"+tem.getText()+"','"+tprof.getText()+"')";
                      boolean b = stm.execute(sql);
                      
                      sql = "Insert into Final (Name,No,P_no,Type,CAmt) values ('"+tname.getText()+"',"+tcno.getText()+","+tpno.getText()+",'"+ch.getSelectedItem().toString()+"',"+tcost.getText()+")";
                      b = stm.execute(sql);
                      
                      System.out.print("Successful Update");
                      
                      JOptionPane.showMessageDialog(null,"Record Saved Successfully","Record Saved",JOptionPane.INFORMATION_MESSAGE);
		
                      
                      
		       tname.setText("");
                    tcno.setText("");
                    tpno.setText("");
                    tcost.setText("");
                    tatp.setText("");
                    ttal.setText("");
                    tdist.setText("");
                    ch.setSelectedItem("[Select]");
                    tname2.setText("");
		    tname3.setText("");
		     tem.setText("");
  		    tprof.setText("");
                    }
                  catch (SQLException e1)
                    {
                      System.out.println(e1);
                    }
		 }
                }

              if(e.getSource()==bnew)
                {
	tcno.setText("0");
	tcno.setEnabled(true); 
try
{
rs=stm.executeQuery("select * from New where Custno=(select max(Custno) from New)");
   
                           while(rs.next())
                           {

                                temp=((rs.getInt("Custno")) +1);
                                String t=Integer.toString(temp);
                                tcno.setText(t);
                            }
}
catch(Exception e12)
{}
tcno.setEditable(false); 
                    tname.setEnabled(true);
		tname2.setEnabled(true);
		tname3.setEnabled(true);
                
                tpno.setEnabled(true);
                tcost.setEnabled(true);
                tatp.setEnabled(true);
                ttal.setEnabled(true);
                tdist.setEnabled(true);
		tem.setEnabled(true);
		tprof.setEnabled(true);


                    ch.setSelectedItem("[Select]");
                }


              if(e.getSource()==bexit)
                {
		JOptionPane.showMessageDialog(null,"You Are Exit Successfully","EXIT",JOptionPane.INFORMATION_MESSAGE);
		
		dispose();
                }

             
            }

        

        public void itemStateChanged(ItemEvent e)
            {

            }


	public int validation()
	{
		int email=0;
		 email=tem.getText().length();
		int ind1=0;
		int cnt1=email-5;
		
		ind1=(tem.getText().indexOf('@'));
		

		if(ch.getSelectedItem().equals("[Select]") && tname.getText().equals("") 
		    && tcno.getText().equals("") && tpno.getText().equals("") &&
		    tatp.getText().equals("") && ttal.getText().equals("") 
		    && tcost.getText().equals("") && tdist.getText().equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter All Fields Dont Leave Blank","ERROR",JOptionPane.ERROR_MESSAGE);
		return 0;
		}
		else if(ch.getSelectedItem().equals("[Select]"))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Construction Type","ERROR",JOptionPane.ERROR_MESSAGE);
		return 0;
		}
		else if((tname.getText().trim()).equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Name","ERROR",JOptionPane.ERROR_MESSAGE);
		return 0;
		}
		else if((tcno.getText().trim()).equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Customer Number","ERROR",JOptionPane.ERROR_MESSAGE);
		return 0;
		}

		else if((tpno.getText().trim()).equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Plot Number","ERROR",JOptionPane.ERROR_MESSAGE);
		return 0;
		}
		else if((tcost.getText().trim()).equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Cost In Ruppees","ERROR",JOptionPane.ERROR_MESSAGE);
		return 0;
		}	
		else if((tatp.getText().trim()).equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Your At Post","ERROR",JOptionPane.ERROR_MESSAGE);
		return 0;
		}
		else if((ttal.getText().trim()).equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Your Taluka" ,"ERROR",JOptionPane.ERROR_MESSAGE);
		return 0;
		}	
		else if((tdist.getText().trim()).equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Your District","ERROR",JOptionPane.ERROR_MESSAGE);
		return 0;
		}
		else if((tem.getText().trim()).equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Your Proper E-Mail ID","ERROR",JOptionPane.ERROR_MESSAGE);
		return 0;
		}
		else if((tname2.getText().trim()).equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Miaddle Name","ERROR",JOptionPane.ERROR_MESSAGE);
		return 0;
		}
		else if((tname3.getText().trim()).equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Your Last Name","ERROR",JOptionPane.ERROR_MESSAGE);
		return 0;
		}
		else if((tprof.getText().trim()).equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Your Profession","ERROR",JOptionPane.ERROR_MESSAGE);
		return 0;
		}
		else if(email<=15 )
		{
		JOptionPane.showMessageDialog(null,"Please Enter Proper E-Mail ID Length","ERROR",JOptionPane.ERROR_MESSAGE);
		return 0;
		}
		/*else if( ind1<=cnt1)
		{
		JOptionPane.showMessageDialog(null,"Please Enter Your E-Mail ID With '@' Sign","ERROR",JOptionPane.ERROR_MESSAGE);
		return 0;
		}	*/		
		else
		{
		return 1;
		}
	
	
	}
        
        public static void main(String args[])
            {
                new NewScreen();
		//setBackground(Color.red);
            }
    }

