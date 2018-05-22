package telnetbot;


public class telnetbot {
    
    public static void main(String[] args) {
  
	int maks=1;

    Runnable[] runners = new Runnable[maks];
    Thread[]   threads = new   Thread[maks];
    
int i=0;
telnet_jdbc.jdbc();

/*
  //  for(int i=0; i<=maks; i++) 
     {

    		 runners[i] = new telnetbot_thread("192.168.1.5", "stivi", "guide","login: ","Password: ");;
  
    }       
    //for(int i=0; i<maks; i++) 
    {threads[i] = new Thread(runners[i]);}
    //for(int i=0; i<maks; i++) 
    {threads[i].start();}

*/
    }
}    