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

	public static telnet_plans jdbc() 
	{
		
	telnet_plans lis = null;
		
	String r1 = "";
	String r2 = "";
	String r3 = "";
	String r4 = "";		
	String polaczenieURL = "jdbc:mysql://"+hostt+"/CERBER?user="+loginn+"&password="+pasww;
	//String query = "Select ip,nn,time_cmd,type FROM cerber_plan_temp where id="+ii+" limit 1"; 
	//Select ip,nn,time_cmd,type FROM cerber_plan_temp t1,cerber_plan_lp t2 where id=70-min_lp AND t1.lp=t2.lp limit 1
	String query = "SELECT device FROM `telnetbot`.`telnet_device`"; 
	Connection conn = null;           
	try {
	     conn = DriverManager.getConnection(polaczenieURL);
	      Class.forName("com.mysql.jdbc.Driver");
	      Statement stmt = conn.createStatement();
	      ResultSet rs = stmt.executeQuery(query);
	      while (rs.next()) 
	          {
	    	  r1=rs.getString(1);
	    	  lis.lista.add(new telnet_plan(r1,23));
	    	 // r2=rs.getString(2);
	    	 // r3=rs.getString(3);
	    	 // r4=rs.getString(4);	
	    	  System.out.println(" " + r1);
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
