package chat_client_serveur_tcp;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FenetreChat extends JFrame {
	private static final long serialVersionUID = -468997914664765758L;
	JTextArea zoneDiscussion;
	JTextField champEnvoi;

	public FenetreChat(String titre) throws IOException {

		super(titre);

		setBounds(600, 300, 400, 400);

		Container conteneur = getContentPane();
		conteneur.setLayout(new BorderLayout(20, 20));

		zoneDiscussion = new JTextArea();
		conteneur.add(zoneDiscussion, BorderLayout.CENTER);

		JScrollPane barreDefilement = new JScrollPane(zoneDiscussion);
		conteneur.add(barreDefilement);

		zoneDiscussion.setEditable(false);

		champEnvoi = new JTextField();
		conteneur.add(champEnvoi, BorderLayout.SOUTH);

		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void afficherMessage(String msg) {
		zoneDiscussion.append(msg + "\n");
	}

	public void effacerChampEnvoi() {
		champEnvoi.setText("");
	}

	public String reccupererMessage() {
		return champEnvoi.getText();
	}

	public void capturerEntree(KeyListener listener) {
		champEnvoi.addKeyListener(listener);
	}

}
 