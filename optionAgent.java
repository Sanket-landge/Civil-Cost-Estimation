

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.sql.ResultSet;
public class optionAgent  implements ActionListener 
{
 JFrame agent = new JFrame("Agent codes...") ;  
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model) ;
    JScrollPane scrlPane = new JScrollPane(tabGrid);
   JButton b1;
   
    Dimension screen 	= 	Toolkit.getDefaultToolkit().getScreenSize();
	
    public optionAgent()
    {
       
    agent.setSize(1000,538);
    agent.setFont(new Font ("ariel",0,13));
    agent.setLayout(null);
    agent.setVisible(true);    
    agent.setLocation((screen.width - 1000)/2,((screen.height-538)/2)-17);	
       
                
               
		
 
         scrlPane.setBounds(5, 5, 1000,400);
    agent.add(scrlPane);
    tabGrid.setFont(new Font ("Verdana",0,13));
    
     model.addColumn("Construction_type");
    model.addColumn("Cust_First_Name");
    model.addColumn("Middle_Name"); 
    model.addColumn("Last_Name");
    model.addColumn("Custno");
    model.addColumn("Plotno");
    model.addColumn("Cost_of_plot");
    model.addColumn("A/P");
    model.addColumn("Tal");
    model.addColumn("Dist");
    model.addColumn("Email");
    model.addColumn("Prof");


      try
            {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection cn = DriverManager.getConnection ("jdbc:odbc:avisun");
                Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = st.executeQuery("select * from New");
                int r = 0;
                while(rs.next())
                {
                	model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)});
                }
    
	    }
           catch(Exception e){}
    
    b1=new JButton("OK");
  
    b1.setFont(new Font ("Verdana",0,13));
    b1.setBounds(400, 450, 75, 30);
    b1.setVisible(true);
    b1.addActionListener(this);
    agent.add(b1);

b1.setForeground(new Color(41,41,221));
agent.setForeground(new Color(41,41,221));    
    
   

	 	
	
	}

 
   
 
    
    public static void main(String args [])
{
   optionAgent c = new optionAgent();
}

    public void actionPerformed(ActionEvent ae) {
         if(ae.getSource()==b1)
    {
	JOptionPane.showMessageDialog(null,"You Are Exit Successfully","Exit",JOptionPane.INFORMATION_MESSAGE);
		
        agent.setVisible(false);
        
    }
    
    
}
}
