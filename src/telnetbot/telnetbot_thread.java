package telnetbot;

import java.util.List;

public class telnetbot_thread extends telnet_bot  implements Runnable{
public List<telnet_cmd> cmds;

public telnetbot_thread(String server,int port, String user, String password, String lo, String pa,List<telnet_cmd> cmds) {
		super(server,port, user, password, lo, pa);
		this.cmds=cmds;
		// TODO Auto-generated constructor stub
	}

@Override
public void run() {
	
	
	for (int ll=0;ll<cmds.size();ll++) {
		//System.out.println(ll);
		//System.out.println("============================================================================");
		//System.out.println(device+":"+port+">>"+cmds.get(ll).type+'|'+cmds.get(ll).arg1);
		//System.out.println("============================================================================");
		if (cmds.get(ll).type.equals("wait")){try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();};};
		if (cmds.get(ll).type.equals("su")){su(cmds.get(ll).arg1);};
		if (cmds.get(ll).type.equals("cmd")){sendCommand2(sendCommand2("shutdown -h now"));};
	};


}
}    