import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;
import java.sql.*;
import java.awt.print.*;


 class AbstractSheetScreen extends JFrame implements ActionListener 
    {
        JLabel lnl,lcno,llr,lls,lls2,lpno,lconstype,lconsamt,lfuramt,lotheramt,ldoorwinamt,lplamt,lslabamt,ltileamt,ltamt,lname,
         tcno,tpno,tconstype,tconsamt,tfuramt,totheramt,tdoorwinamt,tplamt,tslabamt,ttileamt,ttamt;
        JButton bclear,bprint,bexit,disp;
        JComboBox ch;
        Font f;

		Connection cn;
        Statement stm;
        ResultSet rs;
	Dimension screen 	= 	Toolkit.getDefaultToolkit().getScreenSize();
	

        AbstractSheetScreen()
            {
		super("Valuation Report");
                setLayout(null);
                setSize(600,668);
                setVisible(true);
		setLocation((screen.width - 600)/2,((screen.height-668)/2)-17);	

                f = new Font("ALGERIAN",Font.BOLD,26);
		Font f2 = new Font("ALGERIAN",Font.BOLD,20);

                lnl = new JLabel("SHREE GANESH CONTRUCTION");
		llr = new JLabel("Valuation Report");
                
                lname = new JLabel("Name :- ");
                lcno = new JLabel("Number :-");
                lpno = new JLabel("Plot No. :-");
                lconstype = new JLabel("Construction Type :-");
                lconsamt = new JLabel("Contruction Amount(in Rs) :-");
                //lfuramt = new JLabel("Furniture Amount(in Rs) :-");
                //lotheramt = new JLabel("Other Amount(in Rs) :-");
                ldoorwinamt = new JLabel("Doorwin Amount(in Rs) :-");
                lplamt = new JLabel("Plaster Amount(in Rs) :-");
                lslabamt = new JLabel("Slab Amount(in Rs) :-");
                ltileamt = new JLabel("Tile Amount(in Rs) :-");
                ltamt = new JLabel("Total Amount(in Rs) :-");
		lls = new JLabel("Engineer Sign ");
                lls2 = new JLabel("[ Shree Ganesh Const .]");
                	
               ch = new JComboBox();

                tcno = new JLabel();
                tpno = new JLabel();
                tconstype = new JLabel();
                tconsamt = new JLabel();
               // tfuramt = new JLabel();
               // totheramt = new JLabel();
               tdoorwinamt = new JLabel();
                tplamt = new JLabel();
                tslabamt = new JLabel();
                ttileamt = new JLabel();
                ttamt = new JLabel();

                bclear = new JButton("Clear");
                bprint = new JButton("Print");
                bexit = new JButton("Exit");
                disp = new JButton("Dispaly");

		add(llr);			add(lls);
                add(lnl);                   add(lname);
                add(lcno);                  add(lpno);
                add(lconstype);             add(lconsamt);
                //add(lfuramt);               add(lotheramt);
                add(ldoorwinamt);	    add(lls2);
                add(lplamt);                add(lslabamt);
                add(ltileamt);              add(ltamt);

                lnl.setFont(f);
		llr.setFont(f2);

                lnl.setBounds(60,5,550,40);
		llr.setBounds(150,45,300,25);
                lname.setBounds(5,75,100,40);
                lcno.setBounds(5,115,150,40);
                lpno.setBounds(5,155,150,40);
                lconstype.setBounds(5,195,150,40);
                lconsamt.setBounds(5,235,170,40);
                //lfuramt.setBounds(5,275,150,40);
                //lotheramt.setBounds(5,315,150,40);
                ldoorwinamt.setBounds(5,275,150,40);
                lplamt.setBounds(5,355,150,40);
                lslabamt.setBounds(5,395,150,40);
                ltileamt.setBounds(5,435,150,40);
                ltamt.setBounds(5,475,150,40);
		lls.setBounds(450,570,150,20);
		lls2.setBounds(430,590,150,20);
                add(ch);
               
                ch.setBounds(185,75,150,30);

                add(tcno);                  add(tpno);
                add(tconstype);             add(tconsamt);
                add(tdoorwinamt);
                //add(tfuramt);               add(totheramt);
                add(tplamt);                add(tslabamt);
                add(ttileamt);              add(ttamt);

                tcno.setBounds(185,125,200,20);
                tpno.setBounds(185,165,200,20);
                tconstype.setBounds(185,205,200,20);
                tconsamt.setBounds(185,245,200,20);
                //tfuramt.setBounds(185,285,200,20);
                //totheramt.setBounds(185,325,200,20);
                tdoorwinamt.setBounds(185,285,200,20);
                tplamt.setBounds(185,365,200,20);
                tslabamt.setBounds(185,405,200,20);
                ttileamt.setBounds(185,445,200,20);
                ttamt.setBounds(185,485,200,20);

                add(bclear);            add(bprint);
                add(bexit);		add(disp);

                bclear.setBounds(15,550,80,30);
                bprint.setBounds(105,550,80,30);
                bexit.setBounds(195,550,80,30);
				disp.setBounds(105,600,80,30);
                bclear.addActionListener(this);
                bprint.addActionListener(this);
                bexit.addActionListener(this);
		disp.addActionListener(this);

tcno.setForeground(new Color(41,41,221));
tpno.setForeground(new Color(41,41,221));
tconstype.setForeground(new Color(41,41,221));
tconsamt.setForeground(new Color(41,41,221));
tdoorwinamt.setForeground(new Color(41,41,221));
tplamt.setForeground(new Color(41,41,221));
tslabamt.setForeground(new Color(41,41,221));
ttileamt.setForeground(new Color(41,41,221));
ttamt.setForeground(new Color(141,41,21));

ch.setForeground(new Color(91,59,221));

lnl.setForeground(new Color(141,41,21));
 llr.setForeground(new Color(141,41,21));
lls.setForeground(new Color(41,41,221));
 lls2.setForeground(new Color(141,41,21));
              
bclear.setForeground(new Color(41,41,221));
bprint.setForeground(new Color(41,41,221));
bexit.setForeground(new Color(41,41,221));
disp.setForeground(new Color(41,41,221));

				
		try
                {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                cn = DriverManager.getConnection("Jdbc:Odbc:avisun");
                stm = cn.createStatement();
        
                rs = stm.executeQuery("Select * from New");
                
                ch.addItem("[select]");
                while(rs.next())
                {
                ch.addItem(rs.getString(2));
                }
                
                }
                catch(Exception e)
                {
                	System.out.println(e);
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
        public void actionPerformed(ActionEvent ae)
            {
            	int t=0;
                if(ae.getSource() == bexit)
                    {
		JOptionPane.showMessageDialog(null,"You Are Exit Successfully","EXIT",JOptionPane.INFORMATION_MESSAGE);
		
                        dispose();
                    }

		     if(ae.getSource()==bclear)
		    {
		        tcno.setText("");
                        tpno.setText("");
                        tconstype.setText("");
                        tconsamt.setText("");
                        tdoorwinamt.setText("");
                        tplamt.setText("");
                        tslabamt.setText("");
                        ttileamt.setText("");
                        ttamt.setText("");
                        ch.setSelectedItem("[Select]");
		JOptionPane.showMessageDialog(null,"Fields Was Cleared Successfully","Clared Screen",JOptionPane.INFORMATION_MESSAGE);
		
		    }

                    if(ae.getSource()==bprint)
                     {
			bprint.setVisible(false);
    		        bexit.setVisible(false);
    			
    			PrinterJob printJob = PrinterJob.getPrinterJob();
	
  		    // Get and change default page format settings if necessary.
     
        	//printJob.setPrintable(this);
        if (printJob.printDialog())
         {
            try 
               {
                printJob.print();  
                
            } 
            catch (Exception PrintException) 
            {
                PrintException.printStackTrace();
            }
               	
			
    		
    		printJob.cancel();	
    		
 
        }
        
        printJob.cancel();
       		bprint.setVisible(true);
    		bexit.setVisible(true);
     
     
    	}

			


                      
                    if(ae.getSource() == disp)
                    {
			int i=validation();
			if(i==1)
			{
                    	try
                	{
                			
                		System.out.println("Select * from Final where name = '"+ch.getSelectedItem().toString()+"'");
                        rs = stm.executeQuery("Select * from Final where name = '"+ch.getSelectedItem().toString()+"'");
                        while(rs.next())
                        {
                             t = rs.getInt(5)+rs.getInt(6)+rs.getInt(7)+rs.getInt(8)+rs.getInt(9);//+rs.getInt(10)
	 stm.execute("Update Final set Total = "+t+" where name = '"+ch.getSelectedItem().toString()+"'");
                        }
                     //   stm.execute("Update Final set Total = "+t+" where name = '"+ch.getSelectedItem().toString()+"'");
                        System.out.println("Update Final set Total = "+t+" where name = '"+ch.getSelectedItem().toString()+"'");
                        
                        rs = stm.executeQuery("Select * from Final where name = '"+ch.getSelectedItem().toString()+"'");
                        
                       /* while(rs.next())
                        {
                        
                                tcno.setText(String.valueOf(rs.getInt(2)));
		                tpno.setText(String.valueOf(rs.getInt(3))); 
        		        tconstype.setText(String.valueOf(rs.getString(4)));
			tslabamt.setText(String.valueOf(rs.getInt(5)));
			 tdoorwinamt.setText(String.valueOf(rs.getInt(6)));
        		        tplamt.setText(String.valueOf(rs.getInt(7)));
        		        tconsamt.setText(String.valueOf(rs.getInt(8)));
        		       ttamt.setText(String.valueOf(rs.getInt(9)));
                                        ttileamt.setText(String.valueOf(rs.getInt(10))); */
                		
			JOptionPane.showMessageDialog(null,"Report Generated SuccessFully","Display Record",JOptionPane.INFORMATION_MESSAGE);
		/*		
                		//System.out.println("Select * from Final where name = '"+ch.getSelectedItem().toString()+"'");
                        rs = stm.executeQuery("Select * from Final where name = '"+ch.getSelectedItem().toString()+"'");
                        while(rs.next())
                        {
                             t=rs.getInt(+rs.getInt(5)+rs.getInt(6)+rs.getInt(7)+rs.getInt(8));
                        }
                        stm.execute("Update Final set Total = "+t+" where name = '"+ch.getSelectedItem().toString()+"'");
                        System.out.println("Update Final set Total = "+t+" where name = '"+ch.getSelectedItem().toString()+"'");
                     
                        rs = stm.executeQuery("Select * from Final where name = '"+ch.getSelectedItem().toString()+"'");
                        System.out.println("out" +rs.getInt(2));
                        while(rs.next())
                        {
                        
                                tcno.setText(String.valueOf(rs.getInt(1)));
		                tpno.setText(String.valueOf(rs.getInt(2))); 
        		        tconstype.setText(String.valueOf(rs.getString(3)));
        		        tconsamt.setText(String.valueOf(rs.getInt(4)));
        		        tdoorwinamt.setText(String.valueOf(rs.getInt(5)));
        		        tplamt.setText(String.valueOf(rs.getInt(6)));
                   		tslabamt.setText(String.valueOf(rs.getInt(7)));
                		ttileamt.setText(String.valueOf(rs.getInt(8))); 
                		ttamt.setText(String.valueOf(rs.getInt(9)));
			JOptionPane.showMessageDialog(null,"Report Generated SuccessFully","Display Record",JOptionPane.INFORMATION_MESSAGE);*/
		
                    }
                	}
                	catch(Exception e)
                	{
                	//   System.out.println(e);
	e.printStackTrace();
                	}
		     }	
                    }
            }

public int validation()
	{

		if(ch.getSelectedItem().equals("[select]") )
		{
			tcno.setText("");
                        tpno.setText("");
                        tconstype.setText("");
                        tconsamt.setText("");
                        tdoorwinamt.setText("");
                        tplamt.setText("");
                        tslabamt.setText("");
                        ttileamt.setText("");
                        ttamt.setText("");
                        ch.setSelectedItem("[Select]");
		JOptionPane.showMessageDialog(null,"Please Select Customer Name","Error",JOptionPane.ERROR_MESSAGE);
		
		return 0;
		}
		else
		return 1;
	}	

        public static void main(String args[])
            {
            new AbstractSheetScreen();
            }
    }


