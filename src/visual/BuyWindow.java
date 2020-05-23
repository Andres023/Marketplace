package visual;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import controller.Controller;
import visual.WelcomeUserPanel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class BuyWindow extends JFrame implements ActionListener{
	
	private WelcomeUserPanel user;
	
	private JTextField docNumber;
	private JTextField cardNumber;
	private JTextField dueDate;
	private JTextField securityCode;
	private JButton submitBtn;
	
	private String reserveStatus;
	private int cost;
	private Controller ctrl;
	private String [] transaction;
	private String typePay;
	
	public BuyWindow(WelcomeUserPanel user, String reserveStatus, int cost, Controller ctrl, String typePay) {
		
		this.user = user;
		this.reserveStatus = reserveStatus;
		this.cost = cost;
		this.ctrl = ctrl;
		this.typePay = typePay;
		
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
		
		docNumber = new JTextField();
		docNumber.setBounds(168, 34, 180, 20);
		panelUser.add(docNumber);
		docNumber.setColumns(10);
		
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

	public boolean validateForm() {
		if(docNumber.getText().length() > 0 || cardNumber.getText().length() > 0 
		|| dueDate.getText().length() > 0 || securityCode.getText().length() > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase(submitBtn.getText())) {
			if(validateForm()) {
				
				String doc = docNumber.getText();
				Date due = Date.valueOf(dueDate.getText());
				int code = Integer.parseInt(securityCode.getText());
				String card = cardNumber.getText();
				
				if(ctrl.makePay(doc, due, code, card, cost, this)){
					System.out.println("Comprar");			
					if(typePay.equals("BUY")) {
						user.makeTransaction(reserveStatus, transaction);
					}else if(typePay.equals("CART")) {
						user.pendingPays(reserveStatus, transaction);
					}
					
					this.dispose();
				}
			}else {
				JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	public String[] getTransaction() {
		return transaction;
	}

	public void setTransaction(String[] transaction) {
		this.transaction = transaction;
	}
	
	
}
