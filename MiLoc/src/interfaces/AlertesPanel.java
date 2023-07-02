package interfaces;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AlertesPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AlertesPanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 27, 768, 768);
		add(panel);
		
		JLabel lblNewLabel = new JLabel("AUCUNE ALERTE");
		lblNewLabel.setBounds(28, 27, 306, 157);
		add(lblNewLabel);
	}

}
