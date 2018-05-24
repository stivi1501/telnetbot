package telnetbot;
import java.io.InputStream;
import java.io.PrintStream;
 
import org.apache.commons.net.telnet.TelnetClient;


public class telnet_bot {
    
    private TelnetClient telnet = new TelnetClient();
    private InputStream in;
    private PrintStream out;
    private String prompt = "$";
 


	public telnet_bot(String server,int portt, String user, String password, String lo,String pa,String cmd) {
        try 
        {
            telnet.connect(server, portt);
            in = telnet.getInputStream();
            out = new PrintStream(telnet.getOutputStream());
            readFroServerUntil(lo);
            writeToServer(user);
            readFroServerUntil(pa);
            writeToServer(password);
            readFroServerUntil(prompt + " ");
        } catch (Exception e) {e.printStackTrace();}
    }
 
    public void su(String password) {
        try {
        	writeToServer("sudo su");
            prompt = "#";
            writeToServer(password);
            readFroServerUntil(": ");
        } catch (Exception e) {e.printStackTrace();}
    }
    
    public String readFroServerUntil(String pattern) {
        try {
            char lastChar = pattern.charAt(pattern.length() - 1);
            StringBuffer sb = new StringBuffer();
            boolean found = false;
            char ch = (char) in.read();
            while (true) {
                System.out.print(ch);
                sb.append(ch);
                if (ch == lastChar) {
                    if (sb.toString().endsWith(pattern)) {return sb.toString();}
                }
                ch = (char) in.read();
            }
        } catch (Exception e) { e.printStackTrace();}
        return null;
    }
 
    public void writeToServer(String value) {
        try {
            out.println(value);
            out.flush();
            System.out.println(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public String sendCommand1(String command) {
        try {
        	writeToServer(command);
            return readFroServerUntil( ": ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String sendCommand2(String command) {
        try {
        	writeToServer(command);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
 
    public void disconnect() {
        try {
            telnet.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 

}    