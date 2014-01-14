package chat_client_serveur_tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurMultiThread {

	public void lancer(int port, int NbClients) throws IOException {

		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("Serveur lancé, attente du client");

		for (int i = 1; i <= NbClients; ++i) {
			Socket socketClient = serverSocket.accept();
			new ThreadServeur(socketClient).start();
		}
		serverSocket.close();
	}

	public static void main(String[] args) throws IOException {

		new ServeurMultiThread().lancer(30001, 2);
	}
}
