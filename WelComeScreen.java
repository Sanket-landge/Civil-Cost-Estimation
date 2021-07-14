import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Toolkit;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.text.DateFormat;
import java.util.Date;
import java.text.*;
import java.lang.*;
import java.util.*;
import java.beans.PropertyVetoException;


public class WelComeScreen extends JFrame implements ActionListener
    {

	

	String sMSGBOX_TITLE	= "CIVIL ESTIMATION SYSTEM";
	
	
	static Date td ;
	
	

        MenuBar mb;
        Menu mf,me,mr,mt,ma;
        MenuItem mnew,mopen,mexit;
        MenuItem bc,pl,dw,tile,rccs,other;
        MenuItem abs;
	MenuItem cal,note,auth;
        Font f;
       String sUser;
	JLabel lblLogDetails,logtime,username;

 WelComeScreen(String user)
            {

            	 super("SHREE GANESH CONSTRUCTIONS LTD.");
		  
                setLayout(null);
                setSize(1290,900);
                setVisible(true);
		
		sUser = user;
		Date date=new Date();
    		String dd=date.toString();

		lblLogDetails = new JLabel("Logged User Details");
		
    		username = new JLabel();
       		logtime = new JLabel();
		
		username.setText(sUser);
		logtime.setText(dd);

		
	username.setBounds(350,50,120,30);
	lblLogDetails.setBounds(440,20,250,30);
	logtime.setBounds(470,50,250,30);
	
	add(username);
  	   add(lblLogDetails);
  	   add(logtime);

	f = new Font("Arial Black",Font.BOLD,14);
	username.setFont(f);
	logtime.setFont(f);

	f = new Font("Arial Black",Font.BOLD,18);
	lblLogDetails.setFont(f);


logtime.setForeground(Color.yellow);//new Color(41,41,221));
lblLogDetails.setForeground(Color.red);//(167,45,221));
username.setForeground(Color.yellow);//new Color(41,41,221));
 	   
                f = new Font("Arial Black",Font.BOLD,16);

                mb = new MenuBar();
                mb.setFont(f);
		
                mf = new Menu("File  ");
                me = new Menu("Estimation  ");
                mr = new Menu("Reports  ");
		mt=new Menu("Tool  ");
		ma=new Menu("About  ");

                mnew = new MenuItem("New");
                mopen = new MenuItem("Open");
                mexit = new MenuItem("Exit");

                bc = new MenuItem("Base Construction");
                pl = new MenuItem("Plaster");
                dw = new MenuItem("Door Window");
                tile = new MenuItem("Tile");
                rccs = new MenuItem("RCC Slab");
                other = new MenuItem("Other Work");
                
                abs = new MenuItem("Valuation Report ");
		
		cal=new MenuItem("Calculator");
		note=new MenuItem("Notepad");

		auth=new MenuItem("Authers");

                mb.add(mf);
                mb.add(me);
                mb.add(mr);
		mb.add(mt);
		mb.add(ma);

		

        

       // Row 1 Components -------------------------------------------
 		  JLabel  labelim1 = new JLabel(new ImageIcon("Images/ll.gif"));
    		labelim1.setBounds(500,165,120,120);
       		add(labelim1);

		/*JLabel  labelim12 = new JLabel(new ImageIcon("Images/G3.gif"));
    		labelim12.setBounds(800,0,220,220);
       		add(labelim12);    
   
     
                JLabel  labelim = new JLabel(new ImageIcon("Images/ee.jpg"));
    		labelim.setBounds(0,0,180,180);
       		add(labelim);
		*/
	        JLabel  labelim11 = new JLabel(new ImageIcon("Images/5555.jpg"));
    		labelim11.setBounds(0,0,1280,840);
		
       		add(labelim11);

                mf.add(mnew);
                mnew.addActionListener(this);

                mf.add(mopen);
                mopen.addActionListener(this);

                mf.add(mexit);
                mexit.addActionListener(this);

                me.add(bc);
                bc.addActionListener(this);

                me.add(pl);
                pl.addActionListener(this);

                me.add(dw);
                dw.addActionListener(this);

                me.add(tile);
                tile.addActionListener(this);

                me.add(rccs);
                rccs.addActionListener(this);

                me.add(other);
                other.addActionListener(this);
                			
		                
                mr.add(abs);
                abs.addActionListener(this);

		mt.add(cal);
		cal.addActionListener(this);

		mt.add(note);
		note.addActionListener(this);		

		ma.add(auth);
		auth.addActionListener(this);		


                setMenuBar(mb);

	setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

	addWindowListener(new WindowAdapter()
                    {
                        public void windowClosing(WindowEvent we)
                            {
		
			//System.exit(0);
			//setVisible(false);
			//dispose();
			ext();
			
                            }
                    });

   }
	public void ext()
	{

	
		try
  		      {
			int reply = JOptionPane.showConfirmDialog(this,"Are you sure  "+sUser.toUpperCase()+"  You Want to Exit From System ??","EXIT",JOptionPane.YES_NO_OPTION);
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
                if(ae.getSource() == mnew)
                    {
                        new NewScreen();
                    }

		if(ae.getSource() == auth)
                    {
			System.out.println("AUTHER");
                        new Author();
                    }
                if(ae.getSource() == mopen)
                    {
                        new OpenScreen();
			
                    }

                if(ae.getSource() == mexit)
                    {
		try
  		 {
		int reply = JOptionPane.showConfirmDialog(this,"Are you sure You Want to Exit From System ?",sMSGBOX_TITLE,JOptionPane.YES_NO_OPTION,
			JOptionPane.WARNING_MESSAGE);
		if (reply == JOptionPane.YES_OPTION)
			{
			
			setVisible(false);
			dispose();
			new Login();
			



			}
  		 }
		catch(Exception e)
			{}

			
			
                    }

                if(ae.getSource() == bc)
                    {
                        new BaseConScreen();
                    }

                if(ae.getSource() == pl)
                    {
                        new PlasterScreen();
                    }

                if(ae.getSource() == dw)
                    {
                        new DoorWinScreen();
                    }

                if(ae.getSource() == tile)
                    {
                        new TileScreen();
                    }

                if(ae.getSource() == rccs)
                    {
                        new RccSlabScreen();
                    }
		if(ae.getSource() == other)
                    {
                        new OtherWScreen();
                    }

                

                if(ae.getSource() == abs)
                    {
                        new AbstractSheetScreen();
                    }

		if(ae.getSource() == cal)
                    {
                      runComponents("Calc.exe");  
                    }
		if(ae.getSource() == note)
                    {
                      runComponents("Notepad.exe");
                    }


            }
	protected void runComponents(String sComponents)
	{
		Runtime rt = Runtime.getRuntime();
		try{rt.exec(sComponents);}
		catch(IOException evt){JOptionPane.showMessageDialog(null,evt.getMessage(),"Error Found",JOptionPane.ERROR_MESSAGE);}
	}


        public static void main(String args[])
            {
                new WelComeScreen("Ravi");    
            }
    }
