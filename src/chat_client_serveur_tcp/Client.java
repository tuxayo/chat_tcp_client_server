package chat_client_serveur_tcp;

import java.io.IOException;
import java.net.Socket;

public class Client {

	public void lancer(String hostname, int port) throws IOException {

		Socket socketServer = new Socket(hostname, port);

		new Chat().launchChat(socketServer, /* myName= */"client",
		/* nameOfInterlocutor= */"serveur");

	}

	public static void main(String[] args) throws IOException {

		new Client().lancer("localhost", 30001);
	}
}
