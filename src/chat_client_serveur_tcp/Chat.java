package chat_client_serveur_tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

class Chat { // package protected
	// package protected
	void launchChat(Socket socket, String myName, String nameOfInterlocutor)
			throws IOException {
		FenetreChat fenetre = new FenetreChat("chat " + myName);
		fenetre.afficherMessage("Connecté au " + nameOfInterlocutor + " "
				+ socket.getInetAddress().getHostAddress());

		BufferedWriter emissionBuffer = new BufferedWriter(
				new OutputStreamWriter(socket.getOutputStream()));
		fenetre.champEnvoi.addActionListener(new ActionListenerChat(fenetre,
				emissionBuffer));

		BufferedReader receptionBuffer = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		
		String message = "";
		while (true) { // attente réseau et affichage message
			message = receptionBuffer.readLine();
			if (message == null)
				break;
			fenetre.afficherMessage(nameOfInterlocutor + ": " + message);
		}

		fenetre.afficherMessage("Le " + nameOfInterlocutor
				+ " à fermé la connection");
		socket.close();

	}

}