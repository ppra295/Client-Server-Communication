package Java_5440;

public class CreateProcess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			System.out.println("Create a process to execute notepad.exe");
			Process process = Runtime.getRuntime().exec("notepad.exe");
			System.out.println("Notepad is now open in other window.");
			
		}
		catch (Exception ex) {}
	}

}
