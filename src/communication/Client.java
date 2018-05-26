package communication;


import java.io.*;
import java.net.*;
import java.sql.Array;

public class Client
{
	public static String line;
	public static int port;
	public static String host;
	public static Socket socket;
	public static String hs;	
	public static Array listModel;
	public static BufferedReader reader;
	public static PrintWriter printwrite;
	public static BufferedReader receiveRead;
	static OutputStream ostream;
	static InputStream istream;
  public static void main(String[] args) throws Exception
  {
	  	Client.hs = "Divyesh";
	  	Client.port = 1543;
		System.out.println("The client is running");
		command();		
    }
  public static void command() throws UnknownHostException, IOException
  {
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  line = (String) br.readLine();
	  
	  if(line.equals("connect"))
	  {
		 
		  socket = new Socket(Client.hs, Client.port);
		  reader = new BufferedReader(new InputStreamReader(System.in));
		  ostream = socket.getOutputStream(); 
		  printwrite = new PrintWriter(ostream, true);
	      istream = socket.getInputStream();
		  receiveRead = new BufferedReader(new InputStreamReader(istream));
		  System.out.println("Client is connected with Server");
		  System.out.println("Start the chitchat, type and press Enter key");
		  String receive, send;               
		  	while(true)
		  		{
		  			send = reader.readLine();  
		  			printwrite.println(send);
		  			
		  			printwrite.flush();        
		  			if((receive = receiveRead.readLine()) != null) 		  			
		  			{
		  				System.out.println("Program1:"+receive); 
		  			
		  			}         
		  		}               
	  }
	  }
}                        
