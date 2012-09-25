import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private static BufferedReader inFromClient;
	private static DataOutputStream outToClient;
	
	public static void main(String argv[]) throws Exception {
		String clientSentence = "";
		ServerSocket socket = new ServerSocket(6789);

		while (!clientSentence.startsWith("bye")) {
			setupToListen(socket);
			clientSentence = inFromClient.readLine();
			responeToClient(clientSentence, socket);
		}
		socket.close();
	}

	private static void responeToClient(String clientSentence,
			ServerSocket socket) throws IOException {
		if (clientSentence.startsWith("reset")) {
			outToClient.writeBytes("reset received");
		}
		outToClient.writeBytes("\n"); // Default reply to not leave to client hanging.
	}

	private static void setupToListen(ServerSocket socket) throws IOException {
		Socket connectionSocket = socket.accept();
		inFromClient = new BufferedReader(
				new InputStreamReader(connectionSocket.getInputStream()));
		outToClient = new DataOutputStream(
				connectionSocket.getOutputStream());
	}
}