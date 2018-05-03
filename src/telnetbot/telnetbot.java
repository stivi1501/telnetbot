package telnetbot;
import java.io.InputStream;
import java.io.PrintStream;
 
import org.apache.commons.net.telnet.TelnetClient;


public class telnetbot {
    
    private TelnetClient telnet = new TelnetClient();
    private InputStream in;
    private PrintStream out;
    private String prompt = "$";
 
    public telnetbot(String server, String user, String password) {
        try {
            // Connect to the specified server
            telnet.connect(server, 23);
 
            // Get input and output stream references
            in = telnet.getInputStream();
            out = new PrintStream(telnet.getOutputStream());
 
            // Log the user on
            readFroServerUntil("login: ");
            writeToServer(user);
            readFroServerUntil("Password: ");
            writeToServer(password);
 
            // Advance to a prompt
            readFroServerUntil(prompt + " ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public void su(String password) {
        try {
        	writeToServer("sudo su");
            prompt = "#";
            writeToServer(password);
            readFroServerUntil(": ");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                    if (sb.toString().endsWith(pattern)) {
                        return sb.toString();
                    }
                }
                ch = (char) in.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
 
    public static void main(String[] args) {
        try {
            telnetbot telnet = new telnetbot("192.168.1.5", "stivi", "guide");
            try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();};
            telnet.su("guide");
            telnet.sendCommand2("shutdown -h now");
           // telnet.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}    