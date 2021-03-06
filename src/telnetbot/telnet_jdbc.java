package telnetbot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class telnet_jdbc {
	static String loginn="root";
	static String pasww="";
	static String hostt="localhost";

	public static telnet_cmds jdbc_cmd() 
	{	
	telnet_cmds lis = new telnet_cmds();	
	String r1 = "";
	String r2 = "";
	String r3 = "";
	String r4 = "";
	
	String polaczenieURL = "jdbc:mysql://"+hostt+"/telnetbot?user="+loginn+"&password="+pasww;
	String query = "SELECT cmd_id,lp,type,arg1 FROM telnet_cmd ORDER BY lp;"; 
	Connection conn = null;        
	try {
	     conn = DriverManager.getConnection(polaczenieURL);
	      Class.forName("com.mysql.jdbc.Driver");
	      Statement stmt = conn.createStatement();
	      ResultSet rs = stmt.executeQuery(query);
	      while (rs.next()) 
	          {
	    	  r1=rs.getString(1);
	    	  r2=rs.getString(2);
	    	  r3=rs.getString(3);
		      r4=rs.getString(4);

		     // System.out.println(r1+" "+r2+" "+r3+" "+r4);
		      
	    	  lis.lista.add(new telnet_cmd(r1,r2,r3,r4));
	    	  }
	     conn.close();
	}
	catch(ClassNotFoundException wyjatek) {System.out.println("Problem ze sterownikiem");}
	catch(SQLException wyjatek) {
		                         System.out.println("SQLException: " + wyjatek.getMessage());
		                         System.out.println("SQLState: "     + wyjatek.getSQLState());
		                         System.out.println("VendorError: "  + wyjatek.getErrorCode());
		                        }
	
	return lis;
	} 
	
	public static telnet_plans jdbc_plans() 
	{
		
	telnet_plans lis = null;
		
	String r1 = "";
	int r2 = 0;
	String r3 = "";
	String r4 = "";
	String r5 = "";
	String r6 = "";
	String r7 = "";
	
	String polaczenieURL = "jdbc:mysql://"+hostt+"/telnetbot?user="+loginn+"&password="+pasww;
	String query = "SELECT  device,socket,user,pass,lo,pa,cmd_id FROM `telnetbot`.`telnet_device` ORDER BY cmd_id,lp"; 
	Connection conn = null;           
	try {
	     conn = DriverManager.getConnection(polaczenieURL);
	      Class.forName("com.mysql.jdbc.Driver");
	      Statement stmt = conn.createStatement();
	      ResultSet rs = stmt.executeQuery(query);
	      while (rs.next()) 
	          {
	    	  r1=rs.getString(1);
	    	  r2=rs.getInt(2);
		      r3=rs.getString(3);
		      r4=rs.getString(4);	
		      r5=rs.getString(5);	
		      r6=rs.getString(6);
		      r7=rs.getString(7);	
		      
	    	  
	    	  lis.lista.add(new telnet_plan(r1,r2,r3,r4,r5,r6,r7));
	    	  }
	     conn.close();
	}
	catch(ClassNotFoundException wyjatek) {System.out.println("Problem ze sterownikiem");}
	catch(SQLException wyjatek) {
		                         System.out.println("SQLException: " + wyjatek.getMessage());
		                         System.out.println("SQLState: "     + wyjatek.getSQLState());
		                         System.out.println("VendorError: "  + wyjatek.getErrorCode());
		                        }
	
	return lis;
} 	
}
