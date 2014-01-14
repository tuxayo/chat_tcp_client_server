package chat_client_serveur_tcp;

import java.io.IOException;
import java.net.Socket;

public class ThreadServeur extends Thread {
	private Socket socketClient;

	public ThreadServeur(Socket socketClient) {
		this.socketClient = socketClient;
	}

	public void run() {
		try {
			new Chat().launchChat(socketClient, /* myName= */"serveur",
			/* nameOfInterlocutor= */"client");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
