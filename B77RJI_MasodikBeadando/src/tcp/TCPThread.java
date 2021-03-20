package tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TCPThread implements Runnable {
	
	private Socket s = null;
	
	
	public TCPThread(Socket s) 
	{
		this.s = s; 
		
	}

	@Override
	public void run() {
		
		try {
			System.out.println("[SERVER] Client Connected!");
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String szoveg = br.readLine();
			System.out.println("[SERVER] Received: "+szoveg);
			
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String format = sdf.format(date);
			String fileName = "Received "+format+".txt";
			
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName,true)));
			pw.println((new Date()).toString()+" "+szoveg);
			System.out.println("[SERVER] Writing Finished!");
			
			pw.flush();
			br.close();
			pw.close();
			System.out.println("[SERVER] Waiting...");
		} catch (IOException e) {
			
			System.out.println(e);
		}
		
	}

}
