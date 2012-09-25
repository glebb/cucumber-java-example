

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	public static void main(String argv[]) throws Exception {
		String reply;
		Socket clientSocket = new Socket("localhost", 6789);
		DataOutputStream outToServer = new DataOutputStream(
				clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));
		outToServer.writeBytes(argv[0] + "\n");
		reply = inFromServer.readLine();
		System.out.println(reply);
		clientSocket.close();
	}
}