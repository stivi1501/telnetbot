package telnetbot;


public class telnetbot {
    
    public static void main(String[] args) {
    	
    telnet_plans tp;	
    tp=telnet_jdbc.jdbc();
	int maks=tp.lista.size();

    Runnable[] runners = new Runnable[maks];
    Thread[]   threads = new   Thread[maks];

    

for (int i=0;i<maks;i++)
{
	//System.out.println(tp.lista.get(i).device+" "+tp.lista.get(i).port+" "+tp.lista.get(i).user+" "+tp.lista.get(i).pass+" "+tp.lista.get(i).lo+" "+tp.lista.get(i).pa);
}
//int i=0;
    for(int i=0; i<maks; i++) 
     {
    	 runners[i] = new telnetbot_thread(tp.lista.get(i).device,tp.lista.get(i).port, tp.lista.get(i).user,tp.lista.get(i).pass,tp.lista.get(i).lo,tp.lista.get(i).pa);
     }       
   for(int i=0; i<maks; i++) 
    {threads[i] = new Thread(runners[i]);}
    for(int i=0; i<maks; i++) 
    {threads[i].start();}

    }
}    