package telnetbot;

public class telnet_plan {

	public String device="";
	public int port=0;
	public String user="";
	public String pass="";
	public String lo="";
	public String pa="";
	public String cmd="";

	
	telnet_plan(String devi,int por,String user,String pass,String lo,String pa,String cmd)
	{
		this.device=devi;
		this.port=por;
		this.user=user;
		this.pass=pass;
		this.lo=lo;
		this.pa=pa;
		this.cmd=cmd;
	}
}
