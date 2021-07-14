import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class Author extends JFrame implements ActionListener 
{
	public static JScrollPane AuthorJSP = new JScrollPane();

	Dimension screen 	= 	Toolkit.getDefaultToolkit().getScreenSize();

	JPanel 	jpnlMain  	= new JPanel();

	JButton bttnExit   	= new JButton("Cancel");
	JButton bttnInfo   	= new JButton("Short Info.");
				
	//JLabel 	lblPicture 	= new JLabel(new ImageIcon("Images/nn4.jpg"));
	JLabel  lblFullname = new JLabel("Fullname: Sanket Anil Landge");
	JLabel  lblMunicipal= new JLabel("Municipality: Warud(Amravati)");
	JLabel  lblCountry 	= new JLabel("Country: India");
	JLabel  lblCellNum	= new JLabel("Cellular Phone: +917066148782");
	JLabel  lblEmail 	= new JLabel("Email Add: sanketlandge20august@gmail.com@gmail.com");

      //JLabel 	lblPicture1	= new JLabel(new ImageIcon("Images/ss2.jpg"));
	JLabel  lblFullname1= new JLabel("Fullname: Arif Munshir Khan");
	JLabel  lblMunicipal1= new JLabel("Municipality: Warud(Amravati)");
	JLabel  lblCountry1	= new JLabel("Country: India");
	JLabel  lblCellNum1	= new JLabel("Cellular Phone: +919834363546");
	JLabel  lblEmail1	= new JLabel("Email Add: arifmkhan98@gmail.com");


	
	public Author()
	{
		super("About the Author");
		
		jpnlMain.setBackground(Color.pink );
		jpnlMain.setLayout(null);

		
		setSize(420,550);
               // setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocation((screen.width - 350)/2,((screen.height-400)/2)-40);
		setVisible(true);
		getContentPane().setLayout(new BorderLayout(0,0));
		getContentPane().add(BorderLayout.CENTER, jpnlMain);

		//lblPicture.setBounds(0,5,100,120);
		lblFullname.setBounds(140,10,200,50);
		lblMunicipal.setBounds(140,20,220,60);
		lblCountry.setBounds(140,40,200,50);
		lblCellNum.setBounds(140,55,200,50);
		lblEmail.setBounds(140,60,240,70);
		
		//lblPicture1.setBounds(0,130,100,120);
		lblFullname1.setBounds(140,135,200,50);
		lblMunicipal1.setBounds(140,145,220,60);
		lblCountry1.setBounds(140,165,200,50);
		lblCellNum1.setBounds(140,180,200,50);
		lblEmail1.setBounds(140,185,240,70);
		


	//	jpnlMain.add(lblPicture);
		jpnlMain.add(lblFullname);
		jpnlMain.add(lblMunicipal);
	              jpnlMain.add(lblCountry);
		jpnlMain.add(lblCellNum);
		jpnlMain.add(lblEmail);
		

		//jpnlMain.add(lblPicture1);
		jpnlMain.add(lblFullname1);
		jpnlMain.add(lblMunicipal1);
		jpnlMain.add(lblCountry1);
		jpnlMain.add(lblCellNum1);
		jpnlMain.add(lblEmail1);
		

	

		bttnExit.setBounds(230,440,100,24);
		bttnInfo.setBounds(130,440,100,24);
		bttnExit.setMnemonic(KeyEvent.VK_C);
		bttnInfo.setMnemonic(KeyEvent.VK_S);

		jpnlMain.add(bttnExit);
		jpnlMain.add(bttnInfo);

		bttnInfo.addActionListener(this);
		bttnExit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) 
	{
		Object object = event.getSource();
		if(object == bttnInfo){ShortInfo();}
		else
		{		
		setVisible(false);
		dispose();//Unload Form
		}
	}
	
	protected void ShortInfo()
	{
		try {
	    	JOptionPane.showConfirmDialog(this,
		"INFO:\n\nWe Are 3rd Year B.C.A. Students\nThis is Our  Project Work in Core Java. \n " +
			"\nThis Project is Based on Civil Estimation System.\nThis System is Developed Only for a Builders & Contractors\n& not for Customers.\n\n Our  Project Work Was in HTML(JavaScript & ASP)\n "+
			"Which Was a Web site for \n 'Online Flats Booking'.\n\nFor any Suggestions Just contact us at :- \n"+
			"Email Address:   \n 1. sanketlandge20august@gmail.com\n"+
			"2. arifmkhan98@gmail.com\n" +
			"\n \nThank You\n"+ 
			"" ,
			"",  		
          	JOptionPane.OK_OPTION,
          	JOptionPane.INFORMATION_MESSAGE);
		
		} catch(Exception e) {}
	}
	public static void main(String ar[])
	{
			new Author();
	}

}