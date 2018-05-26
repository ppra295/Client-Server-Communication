package Project2;

import java.awt.*;
import javax.swing.*;
 
class MyBall extends Thread {
	
	int x1;
	int y1;
	int stime;
	int string_index;
	MyBallWindow myBallWindow;
	Color col;
	String string, sub_String;
	
	
	public MyBall(int x2,int y2,int sTime,MyBallWindow aabb,Color cColor) {
		string = "@*#@#*";
		string_index = 0;
		sub_String = "*";
		x1 = x2;
		y1 = y2;
		stime = sTime;
		myBallWindow = aabb;
		col = cColor;
		
	}
	
	
	
	public void run() {
		boolean b = true;
		
		while (true) {
			myBallWindow.repaint();;
			sub_String = string.substring(string_index, string_index + 1);
			string_index++;
			if (string_index >= 6) {
				string_index = 0;
				}
			if (y1 > 550) {
				b = false;
				}
			if(b == true) {
				y1 = y1+10;
				}
			if(b == false) {
				y1 = y1-10;
				
				if(y1==0) {
					b = true;
					y1=y1+10;
             }
         }
			 
			
			
			try {
				Thread.sleep(stime);
				}
			catch (Exception e) {
				
			}
       }
     }
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x1, y1-10, 50, 50);
		g.fillOval(x1, y1+10, 50, 50);
		g.setFont(new Font("Rome", Font.BOLD, 50));
		g.drawString(sub_String, x1, y1+30);
		g.setColor(col);
		g.fillOval(x1, y1, 50, 50);
		g.setColor(Color.black); 
		g.setFont(new Font("Monospaced", Font.BOLD, 50));
		g.drawString(sub_String, x1+10, y1+40);
		
	}
    
}
 
 
class MyBallWindow extends JFrame
{
   MyBall myBall[];
 
   public MyBallWindow()
   {
       myBall = new MyBall[2];
 
       myBall[0] = new MyBall(100, 0, 300, this ,Color.gray );
       myBall[1] = new MyBall(200, 0, 400, this , Color.pink );
       
       
       for (int i = 0; i < 2; i++)
       {
        myBall[i].start();  
       }
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(800, 800);
   setVisible(true);
   }  
   
   
 
   public void paint(Graphics g) {
	   for (int i = 0; i < 2; i++) {
		   
		   if (i == 0 && myBall[0].y1 == myBall[1].y1) {
			   swap(myBall[0],myBall[1]);
			   }
		   myBall[i].draw(g);
      }
   }
   
   void swap(MyBall a,MyBall b) {
	   Color col=a.col;
       a.col=b.col;
       b.col=col;
       
   }
   
   private void when(boolean b) {
    // TODO Auto-generated method stub
   
}
 
 
 
 
}