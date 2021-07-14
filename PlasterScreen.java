import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class PlasterScreen extends JFrame implements ActionListener
    {
        JLabel l1,l2,l3,l4,l5,l6,l7,l8,ll,lb;
        JLabel l9,l10,l11,l12,l13,l14,l15,l16,l17;
        JTextField tname,tcno,tno,tlen,tbred,tdepth,tquan,trate,t1,t2;
        JLabel ttno,ttlen,ttbred,ttdepth,ttquan,ttrate,ttamt;
        JButton bupdate,bsave,bexit,bcal,bnew;
        JComboBox ch;
        Font f;
	int i,temp;

        Connection cn;
        Statement stm;
        ResultSet rs;
        String sql;
        PreparedStatement prstm,prstm1;

	Dimension screen 	= 	Toolkit.getDefaultToolkit().getScreenSize();
	

        PlasterScreen()
            {
		super("Plaster Info......");            
                setLayout(null);
                setSize(620,638);
                setVisible(true);
		setLocation((screen.width - 620)/2,((screen.height-638)/2)-17);	


                f = new Font("Times New Roman",Font.BOLD,36);

                l1 = new JLabel("Plaster Information");
                l2 = new JLabel("Customer Name :- ");
                l3 = new JLabel("Customer No. :-");
                l4 = new JLabel("No. :-");
                l5 = new JLabel("Length (in m) :-");
                l6 = new JLabel("Breadth (in m) :-");
                l7 = new JLabel("Depth (in m) :-");
                l8 = new JLabel("Quantity (in m3) :-");
                l9 = new JLabel("Rate (Rs per m3) :-");
                l10 = new JLabel("Total No. :-");
                l11 = new JLabel("Total Length (in m) :-");
                l12 = new JLabel("Total Breadth (in m) :-");
                l13 = new JLabel("Total Depth (in m) :-");
                l14 = new JLabel("Total Quantity (in m3) :-");
                l15 = new JLabel("Rate (Rs per m3) :-");
                l16 = new JLabel("Total Amount (in Rs) :-");
                l17 = new JLabel("Item Work :-");
				ll = new JLabel("X");
				lb = new JLabel("X");
				
				
                ch = new JComboBox();

                tcno = new JTextField();
                tname = new JTextField();
                tno = new JTextField();
                tlen = new JTextField();
                tbred = new JTextField();
                tdepth = new JTextField();
                tquan = new JTextField();
                trate = new JTextField();
                ttno = new JLabel();
                ttlen = new JLabel();
                ttbred = new JLabel();
                ttdepth = new JLabel();
                ttquan = new JLabel();
                ttrate = new JLabel();
                ttamt = new JLabel();
                
                t1 = new JTextField();
				t2 = new JTextField();
				

                
                bupdate = new JButton("Update");
                bsave = new JButton("Save");
                
                
                
                bexit = new JButton("Exit");
                bcal = new JButton("Calculate");

                add(l1);                    add(l2);
                add(l3);                    add(l4);
                add(l5);                    add(l6);
                add(l7);                    add(l8);
                add(l9);                    add(l10);
                add(l11);                   add(l12);
                add(l13);                   add(l14);
                add(l15);                   add(l16);
                add(l17);	
                l1.setFont(f);

                l1.setBounds(100,5,500,40);
                l2.setBounds(5,75,150,40);
                l3.setBounds(5,115,150,40);
                l4.setBounds(5,205,100,40);
                l5.setBounds(5,245,100,40);
                l6.setBounds(5,295,100,40);
                l7.setBounds(5,335,100,40);
                l8.setBounds(5,375,100,40);
                l9.setBounds(5,415,150,40);
                l10.setBounds(400,205,150,40);
                l11.setBounds(400,245,150,40);
                l12.setBounds(400,295,150,40);
                l13.setBounds(400,335,150,40);
                l14.setBounds(400,375,150,40);
                l15.setBounds(400,415,150,40);
                l16.setBounds(400,455,150,40);
                l17.setBounds(5,155,100,40);

                add(ch);
                ch.addItem("Extended Plaster");
                ch.addItem("Limited Plaster");
                ch.setBounds(175,165,150,30);


                add(tcno);                  add(tno);
                add(tlen);       add(t1);   add(tbred);		add(t2);
                add(tdepth);     		    add(tquan);
                add(trate);                 add(ttno);
                add(ttlen);                 add(ttbred);
                add(ttdepth);               add(ttquan);
                add(ttrate);                add(ttamt);
                add(tname);

                tcno.setBounds(175,125,100,20);
                tname.setBounds(175,85,150,20);
                tno.setBounds(165,215,100,20);
                
                tlen.setBounds(165,255,100,20);
                add(ll);
                ll.setBounds(275,255,30,20);
                t1.setBounds(290,255,30,20);
                
                tbred.setBounds(165,305,100,20);
                add(lb);
                lb.setBounds(275,305,30,20);
                t2.setBounds(290,305,30,20);
                
                tdepth.setBounds(165,345,100,20);
         
                
                tquan.setBounds(165,385,100,20);
                trate.setBounds(165,425,100,20);
                ttno.setBounds(565,215,100,20);
                ttlen.setBounds(565,255,100,20);
                ttbred.setBounds(565,305,100,20);
                ttdepth.setBounds(565,345,100,20);
                ttquan.setBounds(565,385,100,20);
                ttrate.setBounds(565,425,100,20);
                ttamt.setBounds(565,465,100,20);







bnew = new JButton("New");
add(bnew);
bnew.setBounds(5,540,80,30);
bnew.addActionListener(this);                
bnew.setForeground(new Color(41,41,221));

                                  add(bupdate);
                add(bsave);                
                             
                                add(bexit);
				add(bcal);
				
                
                bupdate.setBounds(210,540,100,30);
                bsave.setBounds(100,540,100,30);
                           
                bexit.setBounds(430,540,100,30);
		bcal.setBounds(320,540,100,30);
		
				
				
                bsave.addActionListener(this);
                
                
                bexit.addActionListener(this);
                
                bupdate.addActionListener(this);
                
                bcal.addActionListener(this);

ttno.setForeground(new Color(41,41,221));
ttlen.setForeground(new Color(41,41,221));
ttbred.setForeground(new Color(41,41,221));
ttdepth.setForeground(new Color(41,41,221));
ttquan.setForeground(new Color(41,41,221));
ttrate.setForeground(new Color(41,41,221));
ttamt.setForeground(new Color(141,41,21));

ch.setForeground(new Color(91,59,221));

l1.setForeground(new Color(141,41,21));
                
bsave.setForeground(new Color(41,41,221));
bupdate.setForeground(new Color(41,41,221));
bexit.setForeground(new Color(41,41,221));
bcal.setForeground(new Color(41,41,221));



		tname.setEnabled(false);
		
                tcno.setEnabled(false);
		
		tno.setEnabled(false);
                tlen.setEnabled(false);
	        t1.setEnabled(false);
                tbred.setEnabled(false);
	        t2.setEnabled(false);
                tdepth.setEnabled(false);
		
	        tquan.setEnabled(false);
                trate.setEnabled(false);
                       
                ch.setEnabled(false);

				



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

tlen.addKeyListener(new KeyAdapter()
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

tbred.addKeyListener(new KeyAdapter()
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


tdepth.addKeyListener(new KeyAdapter()
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




tquan.addKeyListener(new KeyAdapter()
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

t1.addKeyListener(new KeyAdapter()
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


t2.addKeyListener(new KeyAdapter()
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


/*t3.addKeyListener(new KeyAdapter()
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
		}); */



//*****************Text Box Validations End*********************



				
                

                try
                    {
                        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						cn = DriverManager.getConnection("jdbc:odbc:avisun");
						stm = cn.createStatement();
                        /*rs = stm.executeQuery("select * from Plaster");
                        rs.next() ;
                        display();*/
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


			
              if(e.getSource()==bnew)
                {
	tcno.setEnabled(true); 
try
{
rs=stm.executeQuery("select * from Plaster where Custno=(select max(Custno) from Plaster)");
   
                           while(rs.next())
                           {

                                temp=((rs.getInt("Custno")) +1);
                                String t=Integer.toString(temp);
                                tcno.setText(t);
                            }
}
catch(Exception e12)
{}

		tname.setEnabled(true);
		
                
		
		tno.setEnabled(true);
                tlen.setEnabled(true);
	        t1.setEnabled(true);
                tbred.setEnabled(true);
	        t2.setEnabled(true);
                tdepth.setEnabled(true);
		
	        tquan.setEnabled(true);
                 trate.setEnabled(true);        
                

                    ch.setEnabled(true);
                }
                

                if(e.getSource()==bsave)
                    {
			i=validation();
			if(i==1)
			{
                        try
                            {
                                sql = "Insert into Plaster values("+tcno.getText()+ ",'" +tname.getText()+ "','"+ch.getSelectedItem().toString()+"'," +ttno.getText()+"," +ttlen.getText()+"," +ttbred.getText()+"," +ttdepth.getText()+"," +ttquan.getText()+","+ttamt.getText()+")";
                                prstm = cn.prepareStatement(sql);
                                prstm.execute() ;
                                
                                prstm.close();

				String	sql1 = "Update final set PAmt="+ttamt.getText()+" where Name='"+tname.getText()+"'";
                                prstm1 = cn.prepareStatement(sql1);
                                prstm1.execute() ;
                                prstm1.close();
                     JOptionPane.showMessageDialog(null,"Record Saved Successfully","Record Saved",JOptionPane.INFORMATION_MESSAGE);
		           
                        tcno.setText("");
                        tno.setText("");
                        tname.setText("");
                        tlen.setText("");
                        tbred.setText("");
                        tdepth.setText("");
                        tquan.setText("");
                        trate.setText("");
                        ttno.setText("");
                        ttlen.setText("");
                        ttbred.setText("");
                        ttdepth.setText("");
                        ttquan.setText("");
                        ttrate.setText("");
                        ttamt.setText("");
                        t1.setText("");
			t2.setText("");
			ch.setSelectedItem("[Select]");
                            }
                        catch (SQLException e1)
                            {
                                System.out.println(e1);
                            }
                    }
		   }
                    
                    if(e.getSource()==bcal)
                    {
                    	
                    	i=validation();
			if(i==1)
			{
                        int n,len,bre,depth,qua,q,t,rate,temp;                 
                        
                        ttlen.setText(String.valueOf(Integer.parseInt(tlen.getText())*Integer.parseInt(t1.getText())));
                        ttbred.setText(String.valueOf(Integer.parseInt(tbred.getText())*Integer.parseInt(t2.getText())));
		                ttdepth.setText(String.valueOf(Integer.parseInt(tdepth.getText())));                        
                        
                        n=Integer.parseInt(tno.getText());
                        len=Integer.parseInt(ttlen.getText());
                        bre=Integer.parseInt(ttbred.getText());
                        depth=Integer.parseInt(ttdepth.getText());
                        rate=Integer.parseInt(trate.getText());
                        q=Integer.parseInt(tquan.getText());
                        qua = len*bre;
                        
                        				
						ttno.setText(String.valueOf(n));
						
                        
						ttquan.setText(String.valueOf(qua));
						tquan.setText(String.valueOf(q));
                        ttrate.setText(String.valueOf(rate));
                                                	
                        
                        t=qua*rate;
                        ttamt.setText(String.valueOf(t));
			JOptionPane.showMessageDialog(null,"Calculations Are Completed Successfully","Calculations",JOptionPane.INFORMATION_MESSAGE);
		
                    }
		   }	


                if(e.getSource()==bupdate)
                    {
			i=validation();
			if(i==1)
			{
                        try
                            {
                                stm = cn.createStatement();
				          //sql = "Insert into Plaster values('" +tname.getText()+ "','"+ch.getSelectedItem().toString()+"'," +ttno.getText()+"," +ttlen.getText()+"," +ttbred.getText()+"," +ttdepth.getText()+"," +ttquan.getText()+","+ttamt.getText()+","+tcno.getText()+ ")";
                               stm.executeUpdate ("update Plaster set Custname='" +tname.getText()+ "',Itemwork='"+ch.getSelectedItem().toString()+"' ,No=" +ttno.getText()+" ,Lenght=" +ttlen.getText()+" ,Breadth=" +ttbred.getText()+" ,Depth=" +ttdepth.getText()+",Quantity=" +ttquan.getText()+",Totamount="+ttamt.getText()+ " where Custno="+tcno.getText());//where Custno='"+tcno.getText()+"'");
                               stm.close();
			JOptionPane.showMessageDialog(null,"Record Updated Successfully","Record Update",JOptionPane.INFORMATION_MESSAGE);
			
                        tcno.setText("");
                        tno.setText("");
                        tname.setText("");
                        tlen.setText("");
                        tbred.setText("");
                        tdepth.setText("");
                        tquan.setText("");
                        trate.setText("");
                        ttno.setText("");
                        ttlen.setText("");
                        ttbred.setText("");
                        ttdepth.setText("");
                        ttquan.setText("");
                        ttrate.setText("");
                        ttamt.setText("");
			t1.setText("");
			t2.setText("");
			ch.setSelectedItem("[Select]");
                        
                            }
                        catch (SQLException e1)
                            {
                                System.out.println(e1);
                            }
                    }
		   }
                

                


                if(e.getSource() == bexit)
                    {
		JOptionPane.showMessageDialog(null,"You Are Exit Successfully","Exit",JOptionPane.INFORMATION_MESSAGE);
		
                        dispose();
                    }

            }

 
  public int validation()
	{

		if((tname.getText().trim()).equals(""))
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
		else if((tlen.getText().trim()).equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Length In Meter","ERROR",JOptionPane.ERROR_MESSAGE);
		return 0;
		}	
		else if((tbred.getText().trim()).equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Breadth In Meter","ERROR",JOptionPane.ERROR_MESSAGE);
		return 0;
		}
		else if((tdepth.getText().trim()).equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Depth In Meter" ,"ERROR",JOptionPane.ERROR_MESSAGE);
		return 0;
		}	
		else if((tquan.getText().trim()).equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Quantity","ERROR",JOptionPane.ERROR_MESSAGE);
		return 0;
		}
		else if((trate.getText().trim()).equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Rate" ,"ERROR",JOptionPane.ERROR_MESSAGE);
		return 0;
		}
		else if((t1.getText().trim()).equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Length In Meter" ,"ERROR",JOptionPane.ERROR_MESSAGE);
		return 0;
		}
		else if((t2.getText().trim()).equals(""))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Breadth In Meter" ,"ERROR",JOptionPane.ERROR_MESSAGE);
		return 0;
		}
				
		else
		{
		return 1;
		}
	
	
	}       

        public static void main(String args[])
            {
            new PlasterScreen();
            }
    }

