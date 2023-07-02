package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class ReservationPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ReservationPanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 27, 768, 768);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RESERV");
		lblNewLabel.setBounds(0, 0, 306, 157);
		panel.add(lblNewLabel);

	}

}
