package tcp;


import java.io.IOException;
import java.net.ServerSocket;


public class TCPSzerver {

	private static final int PORT = 1234;

	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket(PORT);
		System.out.println("[SERVER] Waiting for client!");
		while(true) 
		{
			new Thread(new TCPThread(ss.accept())).start();
		}
	}

}
