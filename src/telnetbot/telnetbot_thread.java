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

	for (int ll=1;ll<cmds.size();ll++) {System.out.println(device+":"+port+">>"+cmds.get(ll).type+' '+cmds.get(ll).arg1);};

/*
	try {
    try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();};
    su("guide");
    try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}; try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();};
    sendCommand2("shutdown -h now");
    try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();};
    disconnect();
    try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();};
    } catch (Exception e) {e.printStackTrace();}
    */
}
}    