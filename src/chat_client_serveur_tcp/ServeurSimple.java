package chat_client_serveur_tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurSimple {

	public void lancer(int port) throws IOException {

		ServerSocket serverSocket = new ServerSocket(port);
		Socket socketClient = serverSocket.accept();

		new Chat().launchChat(socketClient, /* myName= */"serveur",
		/* nameOfInterlocutor= */"client");

	}

	public static void main(String[] args) throws IOException {

		new ServeurSimple().lancer(30001);
	}
}
