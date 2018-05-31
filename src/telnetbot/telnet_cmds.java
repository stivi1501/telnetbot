package telnetbot;

import java.util.ArrayList;
import java.util.List;

public class telnet_cmds {
	static List<telnet_cmd> lista = new ArrayList<telnet_cmd>();
	
	public List<telnet_cmd> SearchCmdId(String sci){
		System.out.println("_"+lista.size());
		List<telnet_cmd> listaTemp = new ArrayList<telnet_cmd>();
		for (int i=0;i<lista.size();i++) {
			if (sci.equals(lista.get(i).cmd_id)) {
				listaTemp.add(lista.get(i));
			}
		}
		return listaTemp;	
	}

}