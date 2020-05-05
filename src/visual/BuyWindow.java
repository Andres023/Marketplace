package visual;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyWindow extends JFrame implements ActionListener{
	
	private WelcomeUserPanel user;
	
	private JTextField textField;
	private JTextField cardNumber;
	private JTextField dueDate;
	private JTextField securityCode;
	private JButton submitBtn;
	
	private String reserveStatus;
	
	public BuyWindow(WelcomeUserPanel user, String reserveStatus) {
		
		this.user = user;
		this.reserveStatus = reserveStatus;
		
		setTitle("Compar un servicio");
		setSize(425,460);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel titleLbl = new JLabel("\u00A1Este serivico ya casi es tuyo!");
		titleLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		titleLbl.setBounds(68, 23, 270, 40);
		getContentPane().add(titleLbl);
		
		JLabel legend1 = new JLabel("Por favor ingrese los siguientes datos");
		legend1.setBounds(97, 74, 275, 23);
		getContentPane().add(legend1);
		
		JPanel panelUser = new JPanel();
		panelUser.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelUser.setBounds(25, 130, 358, 70);
		getContentPane().add(panelUser);
		panelUser.setLayout(null);
		
		JLabel legend2 = new JLabel("N\u00FAmero de identificaci\u00F3n");
		legend2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		legend2.setBounds(10, 37, 160, 14);
		panelUser.add(legend2);
		
		textField = new JTextField();
		textField.setBounds(168, 34, 180, 20);
		panelUser.add(textField);
		textField.setColumns(10);
		
		JLabel titleUser = new JLabel("Datos del usuario");
		titleUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		titleUser.setBounds(10, 11, 121, 20);
		panelUser.add(titleUser);
		
		JPanel panelCard = new JPanel();
		panelCard.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelCard.setBounds(25, 218, 358, 135);
		getContentPane().add(panelCard);
		panelCard.setLayout(null);
		
		JLabel title2 = new JLabel("Datos bancarios");
		title2.setFont(new Font("Tahoma", Font.BOLD, 12));
		title2.setBounds(10, 15, 121, 20);
		panelCard.add(title2);
		
		JLabel legend3 = new JLabel("N\u00FAmero de la tarjeta");
		legend3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		legend3.setBounds(10, 50, 160, 14);
		panelCard.add(legend3);
		
		cardNumber = new JTextField();
		cardNumber.setColumns(10);
		cardNumber.setBounds(168, 47, 180, 20);
		panelCard.add(cardNumber);
		
		JLabel legend4 = new JLabel("Fecha de vencimiento");
		legend4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		legend4.setBounds(10, 75, 160, 14);
		panelCard.add(legend4);
		
		JLabel legend5 = new JLabel("C\u00F3digo de seguridad");
		legend5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		legend5.setBounds(10, 100, 160, 14);
		panelCard.add(legend5);
		
		dueDate = new JTextField();
		dueDate.setColumns(10);
		dueDate.setBounds(168, 72, 180, 20);
		panelCard.add(dueDate);
		
		securityCode = new JTextField();
		securityCode.setColumns(10);
		securityCode.setBounds(168, 97, 180, 20);
		panelCard.add(securityCode);
		
		submitBtn = new JButton("Confirmar");
		submitBtn.addActionListener(this);
		submitBtn.setBounds(148, 375, 110, 23);
		getContentPane().add(submitBtn);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase(submitBtn.getText())) {
			System.out.println("Comprar");
			user.makeTransaction(reserveStatus);
			this.dispose();
		}
	}
}
