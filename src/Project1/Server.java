package Project1;

import java.io.*;
import java.net.*;
public class Server {
  public static int port;
  public static Socket sock;
  static ServerSocket serversocket;
  
  public static void main(String[] args) throws Exception {
	  
	  String receiveMsg, sendMsg; 
	  
	  Server.port = 1892;
	  System.out.println("Server  ready for chatting");
	  serversocket = new ServerSocket(Server.port);
	  sock = serversocket.accept( );
	  
	  InputStream inputS = sock.getInputStream();
	  OutputStream oS = sock.getOutputStream();
	  
	  PrintWriter pw = new PrintWriter(oS, true);
	  
	 
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  BufferedReader bReader = new BufferedReader(new InputStreamReader(inputS)); 
     
	               
      while(!false)
      {
    	  sendMsg = br.readLine(); 
          pw.println(sendMsg);             
          pw.flush();
          
          if((receiveMsg = bReader.readLine()) != null)  
        {
           System.out.println("Program1: "  +receiveMsg);         
        }         
       
      }               
    }                    
}                        