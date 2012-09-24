import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	public static void main(String argv[]) throws Exception {
		TennisGame game = new TennisGame();
		String clientSentence;
		ServerSocket socket = new ServerSocket(6789);

		while (true) {
			Socket connectionSocket = socket.accept();
			BufferedReader inFromClient = new BufferedReader(
					new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(
					connectionSocket.getOutputStream());
			clientSentence = inFromClient.readLine();
			
			if (clientSentence.startsWith("getScore")) {
				outToClient.writeBytes(game.scores());
			}
			else if (clientSentence.startsWith("p1")) {
				game.playerOneScores();
			}
			else if (clientSentence.startsWith("p2")) {
				game.playerTwoScores();
			}
			else if (clientSentence.startsWith("reset")) {
				game = new TennisGame();
			}
			else if (clientSentence.startsWith("bye")) {
				outToClient.writeBytes("\n");
				socket.close();
				break;
			}
			outToClient.writeBytes("\n");
		}
	}
}