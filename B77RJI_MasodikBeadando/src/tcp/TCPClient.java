package tcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {

	private static final String SERVER_IP = "localhost";
	private static final int SERVER_PORT = 1234;

	public static void main(String[] args) throws IOException {
		Socket s = new Socket(SERVER_IP,SERVER_PORT);
		
		String szoveg = "Valami";
		System.out.println("Elkülödtt: "+szoveg);
		
		PrintWriter pw = new PrintWriter(s.getOutputStream());
		pw.println(szoveg);
		pw.flush();
		pw.close();
		s.close();
	}

}
