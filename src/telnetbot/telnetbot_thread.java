package telnetbot;



public class telnetbot_thread extends telnet_bot  implements Runnable{



public telnetbot_thread(String server,int port, String user, String password, String lo, String pa,String cmd) {
		super(server,port, user, password, lo, pa,cmd);
		// TODO Auto-generated constructor stub
	}

@Override
public void run() {
	try {
    try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();};
    su("guide");
    try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}; try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();};
    sendCommand2("shutdown -h now");
    try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();};
    disconnect();
    try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();};
    } catch (Exception e) {e.printStackTrace();}
}
}    