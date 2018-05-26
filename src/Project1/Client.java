package Project1;

import java.io.*;
import java.net.*;
public class Client {
	private static String hs;
	private static int port;
	
	public static void main(String[] args) throws Exception {
		Client.hs = "Divyesh";
		Client.port = 1892;
		Socket sock = new Socket(Client.hs, Client.port);
		
		System.out.println("client ready for chatting");
		
		InputStream inputS = sock.getInputStream();
		OutputStream oS = sock.getOutputStream();
		PrintWriter pw = new PrintWriter(oS, true);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader bReader = new BufferedReader(new InputStreamReader(inputS)); 
		
		String receiveMsg, sendMsg;
		
		while(!false)
	      {
			
	     
	        if((receiveMsg = bReader.readLine()) != null)  
	        {
	           System.out.println("Program2: "  +receiveMsg);         
	        }         
	        sendMsg = br.readLine(); 
		    pw.println(sendMsg);             
		    pw.flush();
      }               
    }                    
}  
