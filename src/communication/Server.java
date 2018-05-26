package communication;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
public class Server
{
	public static String line;
	public static int port;
	public static double host;
	static ServerSocket serversocket;
	static OutputStream outstream;
	static InputStream istream;
	static BufferedReader receiveRead;
	static PrintWriter printwrite;
	public static Socket sock;
	public static List<Socket> socketArray = new ArrayList<Socket>();
	
  public static void main(String[] args) throws Exception
  {
	  Server.port = 1543;
	  System.out.println("The server is running");
	  command();
  }

  public static void command() throws IOException
  {
	  BufferedReader br = new BufferedReader(new
              InputStreamReader(System.in));
	  line = (String) br.readLine();
	  if(line.equals("connect"))
	  {
		  serversocket = new ServerSocket(Server.port);
	      System.out.println("Server  ready for connecting");
	      sock = serversocket.accept( ); 
	      BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
	      outstream = sock.getOutputStream(); 
	      printwrite = new PrintWriter(outstream, true);
	      istream = sock.getInputStream();
	      receiveRead = new BufferedReader(new InputStreamReader(istream));
	      String receive, send;               
	      while(true)
	      {
	        if((receive = receiveRead.readLine()) != null)  
	        {
	           System.out.println("Program2:"+receive);
	           
	         
	        send = buffer.readLine(); 
	       
	       
	        printwrite.println(send);             
	       	 printwrite.flush();
	      }               
	  }
	  }

	  }
		  	
	  }
  
                      
