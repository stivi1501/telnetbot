package telnetbot;

import java.util.ArrayList;
import java.util.List;


public class telnetbot {
    
    public static void main(String[] args) {
    	
    telnet_plans tp;	
    tp=telnet_jdbc.jdbc_plans();
    
    telnet_cmds tc;
    tc=telnet_jdbc.jdbc_cmd();
    
	int maks=tp.lista.size();
	
	tc.SearchCmdId("1");

    Runnable[] runners = new Runnable[maks];
    Thread[]   threads = new   Thread[maks];
    

    
    for(int i=0; i<maks; i++) 
     {
        	 runners[i] = new telnetbot_thread(tp.lista.get(i).device,tp.lista.get(i).port, tp.lista.get(i).user,tp.lista.get(i).pass,tp.lista.get(i).lo,tp.lista.get(i).pa,tc.SearchCmdId(tp.lista.get(i).cmd));
    	  
     }       
   for(int i=0; i<maks; i++) 
    {threads[i] = new Thread(runners[i]);}
    for(int i=0; i<maks; i++) 
    {threads[i].start();}
    }
}