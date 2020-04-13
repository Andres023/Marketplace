package visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import controller.Controller;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JEditorPane;

public class WelcomeUserPanel extends JPanel implements ActionListener {
	
	private Controller ctrl;
	private Main main;
	
	private JTextField searchOffer;
	private JTextField searchProvider;
	private JButton logOutBtn;
	private JButton searchOfferBtn;
	private JButton searchProviderBtn;
	
	public WelcomeUserPanel(Controller ctrl, Main main) {
		this.ctrl = ctrl;
		this.main = main;
		
		setSize(900, 600);
		setLayout(null);
		
		JLabel title = new JLabel("BIENVENIDO(A) ESTIMADO(A): ");
		title.setFont(new Font("Arial", Font.BOLD, 20));
		title.setBounds(62, 50, 385, 38);
		add(title);
		
		JLabel welcomelbl = new JLabel("\u00BFQu\u00E9 desea hacer hoy?");
		welcomelbl.setFont(new Font("Tahoma", Font.PLAIN, 11));
		welcomelbl.setBounds(62, 116, 217, 20);
		add(welcomelbl);
		
		logOutBtn = new JButton("Cerrar sesi\u00F3n");
		logOutBtn.setBounds(672, 508, 138, 23);
		logOutBtn.addActionListener(this);
		add(logOutBtn);
		
		JLabel searchOfferLbl = new JLabel("Buscar ofertas\r\n");
		searchOfferLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		searchOfferLbl.setBounds(62, 170, 194, 33);
		add(searchOfferLbl);
		
		searchOffer = new JTextField();
		searchOffer.setBounds(62, 219, 291, 20);
		add(searchOffer);
		searchOffer.setColumns(10);
		
		searchOfferBtn = new JButton("Buscar");
		searchOfferBtn.setBounds(358, 218, 89, 23);
		searchOfferBtn.addActionListener(this);
		add(searchOfferBtn);
		
		JLabel searchProviderLbl = new JLabel("Buscar ofertas\r\n");
		searchProviderLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		searchProviderLbl.setBounds(62, 276, 194, 33);
		add(searchProviderLbl);
		
		searchProvider = new JTextField();
		searchProvider.setColumns(10);
		searchProvider.setBounds(62, 320, 291, 20);
		add(searchProvider);
		
		searchProviderBtn = new JButton("Buscar");
		searchProviderBtn.setBounds(358, 319, 89, 23);
		searchProvider.addActionListener(this);
		add(searchProviderBtn);
		
		JLabel transactionsLbl = new JLabel("Historial de transacciones");
		transactionsLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		transactionsLbl.setBounds(545, 97, 265, 33);
		add(transactionsLbl);
		
		JList list = new JList();
		list.setBounds(545, 288, 201, -107);
		add(list);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setBounds(519, 136, 291, 344);
		add(editorPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase(searchOffer.getText())) {
			
		}else if(e.getActionCommand().equalsIgnoreCase(searchProvider.getText())) {
			
		}else if(e.getActionCommand().equalsIgnoreCase(logOutBtn.getText())) {
			main.userWelcomeToMenu();
		}
	}
}
