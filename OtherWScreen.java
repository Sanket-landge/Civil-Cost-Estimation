/*import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;
import java.sql.*;
*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.event.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class OtherWScreen extends JFrame implements ActionListener
    {
        JLabel l1,l2,l3,l4,l5,l6,l9;
        JTextField tcno,tname,tno,trate,ttamt;
        JButton bupdate,bsave,bcal,bExit,bnew;
        JComboBox ch;
        Font f;
	int temp;
        Connection cn;
        Statement stm;
        ResultSet rs;
        String sql;
        PreparedStatement prstm;
	Dimension screen 	= 	Toolkit.getDefaultToolkit().getScreenSize();
	
        OtherWScreen()
            {
		super("Other WOrk Window Information ........");
                setLayout(null);
                setSize(690,608);
                setVisible(true);
		setLocation((screen.width - 690)/2,((screen.height-608)/2)-17);	

                f = new Font("ALGERIAN",Font.BOLD,36);

                l1 = new JLabel("Other Work Window");
                l2 = new JLabel("Customer Name :- ");
                l3 = new JLabel("Customer No. :-");
                l4 = new JLabel("Item Work :-");
                l5 = new JLabel("Quantity. :-");
                l6 = new JLabel("Rate (Rs per m3) :-");
                
                l9 = new JLabel("Total Amount (in Rs) :-");


                ch = new JComboBox();

                tcno = new JTextField();
                tname = new JTextField();
                tno = new JTextField();
                trate = new JTextField();
                
                ttamt = new JTextField();

                
                bupdate = new JButton("Update");
                bsave = new JButton("Save");
                bcal = new JButton("Calculate");
                bExit = new JButton("Exit");
                
                add(l1);                    add(l2);
                add(l3);                    add(l4);
                add(l5);                    add(l6);
                
                add(l9);
                l1.setFont(f);

                l1.setBounds(100,5,500,40);
                l2.setBounds(5,75,150,40);
                l3.setBounds(5,115,150,40);
                l4.setBounds(5,155,150,40);
                l5.setBounds(5,285,150,40);
                l6.setBounds(5,325,150,40);
                
                l9.setBounds(5,365,150,40);
                              
                add(ch);
		ch.addItem("[Select]");
                ch.addItem("W.C.C Unit");
                ch.addItem("G.C.C Unit");
                ch.setBounds(175,165,150,30);


                add(tcno);                  add(tno);
                add(trate);                 
                                add(ttamt);
                add(tname);

                tcno.setBounds(175,125,100,20);
                tname.setBounds(175,85,150,20);
                tno.setBounds(175,295,100,20);
                trate.setBounds(175,335,100,20);
                
                ttamt.setBounds(175,375,100,20);



bnew = new JButton("New");
add(bnew);
bnew.setBounds(5,450,80,30);
bnew.addActionListener(this);                
bnew.setForeground(new Color(41,41,221));

                                 add(bupdate);
                add(bsave);                 add(bcal);
                add(bExit);                  

               
                bupdate.setBounds(105,450,150,30);
                bsave.setBounds(265,450,80,30);
                bcal.setBounds(355,450,80,30);
                bExit.setBounds(455,450,80,30);
                

                bsave.addActionListener(this);
                bcal.addActionListener(this);
                
                
                bupdate.addActionListener(this);
                bExit.addActionListener(this);

ttamt.setForeground(Color.red);//new Color(141,241,21));

                
		
ch.setForeground(new Color(91,59,221));

l1.setForeground(new Color(141,41,21));
bcal.setForeground(new Color(41,41,221)); 

bupdate.setForeground(new Color(41,41,221));               
bsave.setForeground(new Color(41,41,221));


bExit.setForeground(new Color(41,41,221));



		
		tname.setEnabled(false);
		
                tcno.setEnabled(false);
		
		tno.setEnabled(false);
                
		
	        ttamt.setEditable(false);
                trate.setEnabled(false);
                     
                ch.setEnabled(false);



                try
                    {
                        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        cn = DriverManager.getConnection("Jdbc:Odbc:avisun");
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


tno.addKeyListener(new KeyAdapter()
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

ttamt.addKeyListener(new KeyAdapter()
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

trate.addKeyListener(new KeyAdapter()
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




//*****************Text Box Validations End*********************




            setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

	addWindowListener(new WindowAdapter()
                    {
                        public void windowClosing(WindowEvent we)
                            {
		
			ext();
			
                            }
                    });

 	}


	public int validation()
	{

		if(tname.getText().equals("")    && tcno.getText().equals("")
		    && tno.getText().equals("")  && trate.getText().equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter All Fields Dont Leave Blank","ERROR",JOptionPane.ERROR_MESSAGE);
		return 0;
		}
		else if(ch.getSelectedItem().equals("[Select]"))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Item Work ","ERROR",JOptionPane.ERROR_MESSAGE);
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

		else if((tno.getText().trim()).equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Plot Number","ERROR",JOptionPane.ERROR_MESSAGE);
		return 0;
		}
		else if((trate.getText().trim()).equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Cost In Ruppees","ERROR",JOptionPane.ERROR_MESSAGE);
		return 0;
		}	
		
		else
		{
		return 1;
		}
	
	
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


		if(e.getSource()==bnew)
                {
	tcno.setEnabled(true); 
try
{
rs=stm.executeQuery("select * from Other where Cust_no=(select max(Cust_no) from Other)");
   
                           while(rs.next())
                           {

                                temp=((rs.getInt("Cust_no")) +1);
                                String t=Integer.toString(temp);
                                tcno.setText(t);
                            }
}
catch(Exception e12)
{}

		tname.setEnabled(true);
		
                
		
		tno.setEnabled(true);
                
		
	        //ttamt.setEnabled(true);
                 trate.setEnabled(true);        
                

                    ch.setEnabled(true);
                }
                

                if(e.getSource()==bsave)
                    {

		int i=validation();
		  if(i==1)
		  {
                        try
                            {
                                sql = "insert into Other values(" +tcno.getText()+ ",'" +tname.getText()+"','" +ch.getSelectedItem().toString()+"'," +tno.getText()+","+trate.getText()+","+ttamt.getText()+")";
                                prstm = cn.prepareStatement(sql);
                                prstm.execute() ;
			
		JOptionPane.showMessageDialog(null,"Record Saved Successfully","Record Saved",JOptionPane.INFORMATION_MESSAGE);
		
                               
                                prstm.close();
                            }
                        catch (SQLException e1)
                            {
                                System.out.println(e1);
                            }
		   }
		  	
		
			/*
			tcno.setText("");
                        tno.setText("");
                        tname.setText("");
                        trate.setText("");
                       ttamt.setText("");
                        
                        ch.setSelectedItem("[Select]");*/
                    }

                if(e.getSource()==bupdate)
                    {	
			int i=validation();
		  if(i==1)
		  {

                        try
                            {
				stm = cn.createStatement();
                               

                                sql = "update Other set Name='"+tname.getText()+"', item_work= '"+ch.getSelectedItem()+"',No="+tno.getText()+",Rate="+trate.getText()+",Amount="+ttamt.getText()+" where cust_no="+tcno.getText()+"";
                                prstm = cn.prepareStatement(sql);
                                prstm.execute();
		
		JOptionPane.showMessageDialog(null,"Item Changed Successfully","Change Item",JOptionPane.INFORMATION_MESSAGE);
		
                                
                                prstm.close();
                            }
                        catch (SQLException e1)
                            {
                                System.out.println(e1);
                            }
			}
			/*
			tcno.setText("");
                        tno.setText("");
                        tname.setText("");
                        trate.setText("");
                        
                        ttamt.setText("");
                        ch.setSelectedItem("[Select]");*/
                    }

                if(e.getSource()==bcal)
                    {

		   int i=validation();
		   if(i==1)
		   {
                     int n,len,bre,depth,qua,q,t,rate,temp;                 
                        
                        
                        n=Integer.parseInt(tno.getText());
                        
                        rate=Integer.parseInt(trate.getText());
                        
                        				
						
						
                        
			
                        
                        t=n*rate;
			f = new Font("ALGERIAN",Font.BOLD,16);
                        ttamt.setText(String.valueOf(t));
			ttamt.setFont(f);
		JOptionPane.showMessageDialog(null,"Calculations Completed Successfully","Calculations",JOptionPane.INFORMATION_MESSAGE);
		
                    
		  }
 

		    }

                if(e.getSource() == bExit)
                    {
		JOptionPane.showMessageDialog(null,"You Are Exit Successfully","Exit",JOptionPane.INFORMATION_MESSAGE);
		
                         dispose();
                    }

            }

        public static void main(String args[])
            {
            new OtherWScreen();
            }
    }

