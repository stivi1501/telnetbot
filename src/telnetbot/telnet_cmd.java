package telnetbot;


public class telnet_cmd {
	
public String cmd_id;
public String lp;
public String type;
public String arg1;

public telnet_cmd(String r1,String r2,String r3,String r4) {
	//SELECT cmd_id,lp,type,arg1 FROM telnet_cmd ORDER BY lp
	this.cmd_id=r1;
	this.lp=r2;
	this.type=r3;
	this.arg1=r4;
}

}