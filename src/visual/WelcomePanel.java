package visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import controller.Controller;
import javax.swing.JLabel;
import java.awt.Font;

public class WelcomePanel extends JPanel implements ActionListener {
	
	Controller ctrl;
	
	public WelcomePanel(Controller ctrl) {
		this.ctrl = ctrl;
		
		setSize(900, 600);
		setLayout(null);
		
		JLabel title = new JLabel("BIENVENIDO");
		title.setFont(new Font("Arial", Font.BOLD, 80));
		title.setBounds(144, 116, 502, 136);
		add(title);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}
