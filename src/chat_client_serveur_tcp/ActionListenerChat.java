package chat_client_serveur_tcp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;

import chat_client_serveur_tcp.FenetreChat;

public class ActionListenerChat implements ActionListener {

	private FenetreChat fenetre;
	private BufferedWriter emissionBuffer;
	private String messageAEnvoyer; // pour pas redéclarer à chaque fois qu'on envoie un message

	public ActionListenerChat(FenetreChat fenetre, BufferedWriter emissionBuffer) {
		this.fenetre = fenetre;
		this.emissionBuffer = emissionBuffer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		messageAEnvoyer = fenetre.reccupererMessage();
		try {
			emissionBuffer.write(messageAEnvoyer);
			emissionBuffer.newLine();
			emissionBuffer.flush();
		} catch (IOException e1) {
			System.err.println("Fail d'envoi");
			e1.printStackTrace();
		}
		fenetre.afficherMessage("Moi: " + messageAEnvoyer);
		fenetre.effacerChampEnvoi();
	}
}
