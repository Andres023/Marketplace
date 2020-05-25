package visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.Controller;
import mysql.ClientManagement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.fabric.xmlrpc.base.Array;

import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;


public class WelcomeUserPanel extends JPanel implements ActionListener {
	
	private Controller ctrl;
	private Main main;

	private JButton logOutBtn;
	private JButton searchOfferBtn;
	private JButton searchProviderBtn;
	private JButton buyServiceBtn;
	private JButton reserveServiceBtn;
	private JButton payReservation;
	
	private JTextField searchOffer;
	private JTextField textField;
	private JTextField costOffer;
	private JTextField publishDate;
	private JTextField originCity;
	private JTextField destinationCity;
	
	private JLabel nameOffer;
	private JLabel costLbl;
	private JLabel dateLbl;
	private JLabel origin;
	private JLabel destination;
	private JLabel transport;
	private JLabel hotel;
	private JLabel food;
	private JTextArea pendingPayTxt;
	private JLabel totalLbl;
	
	private JRadioButton transportRbtn;
	private JRadioButton hotelRbtn;
	private JRadioButton foodRbtn;
	
	private JPanel panelOffer;
	private JPanel cartPanel;
	
	private int description [];
	private int serviceId;
	private ArrayList<String> offer; // idServicio, nombreServicio, costo, fechaPublicacion, ciudadOrigen, descripcion, ciudadDestino
	private int totalCart = 0;
	private String cartIndexes = "";
	
	private BuyWindow buyWindow;
	private JButton backButton;
	private JPanel historyPanel;
	private JButton searchHistory;
	private JButton nextButton;
	private JLabel lblNewLabel_1;
	private JTextField dateTxt;
	private JTextArea historyArea;
	
	private int index = 0;
	
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
		welcomelbl.setBounds(62, 105, 217, 20);
		add(welcomelbl);
		
		logOutBtn = new JButton("Cerrar sesi\u00F3n");
		logOutBtn.setBounds(672, 508, 138, 23);
		logOutBtn.addActionListener(this);
		add(logOutBtn);
		
		searchOffer = new JTextField();
		searchOffer.setBounds(62, 180, 291, 20);
		add(searchOffer);
		searchOffer.setColumns(10);
		
		searchOfferBtn = new JButton("Buscar");
		searchOfferBtn.setBounds(358, 179, 89, 23);
		searchOfferBtn.addActionListener(this);
		add(searchOfferBtn);
		
		JLabel searchProviderLbl = new JLabel("Buscar proveedores\r\n");
		searchProviderLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		searchProviderLbl.setBounds(62, 451, 194, 33);
		add(searchProviderLbl);
		
		searchProviderBtn = new JButton("Buscar proveedores");
		searchProviderBtn.setBounds(265, 491, 171, 23);
		searchProviderBtn.addActionListener(this);
		add(searchProviderBtn);
		
		JLabel transactionsLbl = new JLabel("Historial de transacciones");
		transactionsLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		transactionsLbl.setBounds(500, 97, 265, 33);
		add(transactionsLbl);
		
		panelOffer = new JPanel();
		panelOffer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelOffer.setLayout(null);
		panelOffer.setBounds(62, 211, 385, 229);
		add(panelOffer);
		
		textField = new JTextField();
		panelOffer.add(textField);
		textField.setColumns(10);
		
		costOffer = new JTextField();
		costOffer.setEditable(false);
		costOffer.setBounds(60, 87, 114, 20);
		panelOffer.add(costOffer);
		costOffer.setColumns(10);
		
		publishDate = new JTextField();
		publishDate.setEditable(false);
		publishDate.setBounds(297, 149, 78, 20);
		panelOffer.add(publishDate);
		publishDate.setColumns(10);
		
		nameOffer = new JLabel("");
		nameOffer.setBounds(10, 20, 194, 33);
		panelOffer.add(nameOffer);
		nameOffer.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		originCity = new JTextField();
		originCity.setEditable(false);
		originCity.setColumns(10);
		originCity.setBounds(261, 87, 114, 20);
		panelOffer.add(originCity);
		
		destinationCity = new JTextField();
		destinationCity.setEditable(false);
		destinationCity.setColumns(10);
		destinationCity.setBounds(261, 118, 114, 20);
		panelOffer.add(destinationCity);
		
		costLbl = new JLabel("Costo");
		costLbl.setBounds(10, 88, 46, 14);
		panelOffer.add(costLbl);
		
		dateLbl = new JLabel("Fecha de publicaci\u00F3n");
		dateLbl.setBounds(169, 152, 127, 14);
		panelOffer.add(dateLbl);
		
		origin = new JLabel("Origen");
		origin.setBounds(209, 93, 46, 14);
		panelOffer.add(origin);
		
		destination = new JLabel("Destino");
		destination.setBounds(209, 124, 46, 14);
		panelOffer.add(destination);
		
		transport = new JLabel("Transporte ");
		transport.setBounds(10, 115, 92, 14);
		panelOffer.add(transport);
		
		hotel = new JLabel("Hotel");
		hotel.setBounds(10, 135, 92, 14);
		panelOffer.add(hotel);
		
		food = new JLabel("Alimento");
		food.setBounds(10, 155, 92, 14);
		panelOffer.add(food);
		
		transportRbtn = new JRadioButton("");
		transportRbtn.setEnabled(false);
		transportRbtn.setBounds(75, 113, 31, 23);
		panelOffer.add(transportRbtn);
		
		hotelRbtn = new JRadioButton("");
		hotelRbtn.setEnabled(false);
		hotelRbtn.setBounds(75, 132, 31, 23);
		panelOffer.add(hotelRbtn);
		
		foodRbtn = new JRadioButton("");
		foodRbtn.setEnabled(false);
		foodRbtn.setBounds(75, 152, 31, 23);
		panelOffer.add(foodRbtn);
		
		backButton = new JButton("<");
		backButton.setBounds(73, 195, 89, 23);
		backButton.addActionListener(this);
		panelOffer.add(backButton);
		
		nextButton = new JButton(">");
		nextButton.setBounds(207, 195, 89, 23);
		nextButton.addActionListener(this);
		panelOffer.add(nextButton);
		
		buyServiceBtn = new JButton("Comprar");
		buyServiceBtn.setBounds(286, 17, 89, 23);
		buyServiceBtn.addActionListener(this);
		
		reserveServiceBtn = new JButton("Reservar");
		reserveServiceBtn.setBounds(286, 40, 89, 23);
		reserveServiceBtn.addActionListener(this);
		
		JLabel searchOfferLbl = new JLabel("Buscar ofertas\r\n");
		searchOfferLbl.setBounds(62, 136, 194, 33);
		add(searchOfferLbl);
		searchOfferLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel reservations = new JLabel("Carrito");
		reservations.setFont(new Font("Tahoma", Font.BOLD, 15));
		reservations.setBounds(500, 305, 265, 33);
		add(reservations);
		
		cartPanel = new JPanel();
		cartPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		cartPanel.setBounds(500, 349, 310, 135);
		add(cartPanel);
		cartPanel.setLayout(null);
		
		pendingPayTxt = new JTextArea("");
		pendingPayTxt.setEditable(false);
		pendingPayTxt.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pendingPayTxt.setBounds(10, 11, 290, 79);
		cartPanel.add(pendingPayTxt);
		
		payReservation = new JButton("Pagar");
		payReservation.setBounds(211, 101, 89, 23);
		payReservation.addActionListener(this);
		cartPanel.add(payReservation);
		
		totalLbl = new JLabel("");
		totalLbl.setBounds(10, 103, 191, 18);
		cartPanel.add(totalLbl);
		
		JLabel lblNewLabel = new JLabel("Consulta nuestra lista de proveedores");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(62, 495, 231, 14);
		add(lblNewLabel);
		
		historyPanel = new JPanel();
		historyPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		historyPanel.setBounds(500, 136, 310, 170);
		add(historyPanel);
		historyPanel.setLayout(null);
		
		searchHistory = new JButton("Revisar");
		searchHistory.setBounds(211, 136, 89, 23);
		searchHistory.addActionListener(this);
		historyPanel.add(searchHistory);
		
		lblNewLabel_1 = new JLabel("Desde Y-M-D");
		lblNewLabel_1.setBounds(10, 140, 95, 14);
		historyPanel.add(lblNewLabel_1);
		
		dateTxt = new JTextField();
		dateTxt.setBounds(101, 137, 86, 20);
		historyPanel.add(dateTxt);
		dateTxt.setColumns(10);
		
		historyArea = new JTextArea();
		historyArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		historyArea.setEditable(false);
		historyArea.setBounds(10, 11, 290, 113);
		historyPanel.add(historyArea);
		
	}
	
	/*
	 * Show the user's pending pays
	 */
	public void printCart() {
		pendingPayTxt.setText("");
		totalCart = 0;	
		cartIndexes = "";
		String txt = "";
		ResultSet rs = ctrl.searchCart();
		if(rs != null) {
			
			try {
				do {
					int id = rs.getInt(1);
					cartIndexes += id+"/";
					txt += pendingPayTxt.getText() + "Reserva No. " + id + " " + rs.getString(2) + " valor: " + rs.getInt(3) + "\n";
					//Sum the total of cart
					totalCart += rs.getInt(3);
				}while (rs.next());
			} catch (SQLException ex) {
				pendingPayTxt.setText("Ha ocurrido un error a la hora de procesar el carrito");
				totalLbl.setText("Total: $0");
				ex.printStackTrace();
			}
			pendingPayTxt.setText(txt);
			totalLbl.setText("Total: $" + totalCart);
			System.out.println(totalCart);
			System.out.println(cartIndexes);
		}else {
			System.out.println("no");
			pendingPayTxt.setText("Actualmente no hay pagos pendientes");
			totalLbl.setText("Total: $0");
		}
	}
	
	/*
	 * Calls the controller to buy the service
	 */
	public void makeTransaction(String reserveStatus, String [] transaction) {
		ctrl.makeTransaction(serviceId, reserveStatus, transaction, "", this);
	}
	
	public void pendingPays(String reserveStatus, String [] transaction) {
		String [] reserv = cartIndexes.split("/");
		
		
		for (int i = 0; i < reserv.length; i++) {
			ctrl.makeTransaction(Integer.parseInt(reserv[i]), reserveStatus, transaction, "CART", this);
		}
	}

	private void paintOffers() {
		//Show the service information

		serviceId = Integer.parseInt(offer.get(0+index));System.out.println(serviceId+index);
		
		nameOffer.setText(offer.get(1+index));
		costOffer.setText(offer.get(2+index) + " COP");
		publishDate.setText(offer.get(3+index));
		originCity.setText("De: " + offer.get(4+index));
		destinationCity.setText("A: " + offer.get(6+index));
		
		description = ctrl.searchOfferDescription(Integer.parseInt(offer.get(5+index)));
		if(description[0] == 1) {
			transportRbtn.setSelected(true);
		}else {
			transportRbtn.setSelected(false);
		}
		if(description[1] == 1) {
			hotelRbtn.setSelected(true);
		}else {
			hotelRbtn.setSelected(false);
		}
		if(description [2] == 1) {
			foodRbtn.setSelected(true);
		}else {
			foodRbtn.setSelected(false);
		}
		
		//Show the buy button
		panelOffer.add(buyServiceBtn);
		panelOffer.add(reserveServiceBtn);
		this.repaint();
	}
	
	private void viewProviderList(ArrayList<String> data) {
		JFrame providersWindow = new JFrame();
		providersWindow.setTitle("Proveedores");
		providersWindow.setSize(500,500);
		providersWindow.setLocationRelativeTo(null);
		providersWindow.setResizable(false);
		providersWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		String title [] = {"PROVEEDOR", "EMPRESA", "TELÉFONO", "CORREO", "DIRECCIÓN"};
		
		DefaultTableModel model = new DefaultTableModel(null, title) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column == 5) {
					return true;
				}else {
					return false;
				}
			}
		};
		
		model.addRow(title);
		
		String [] row = new String [5];
		int index = 0;
		boolean condition = true;
		int i;
		
		while(condition) {
			for (i = 0; i < data.size(); i++) {
				row [index] = data.get(i);
				index += 1;
				if(index == 5) {
					model.addRow(row);
					index = 0;
				}
			}
			if(i == data.size()) {
				condition = false;
			}
		}
		
		JTable tabla = new JTable(model);
		tabla.setBounds(0,0,500,500);
		
		
		JPanel pnl = new JPanel();
		pnl.setBounds(0,0,500,500);
		pnl.setLayout(null);
		pnl.add(tabla);
		
		providersWindow.setVisible(true);
		providersWindow.getContentPane().add(pnl);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase(searchOfferBtn.getText())) {
			if(searchOffer.getText().length() > 0) {
				
				this.offer = ctrl.userSearchOffer(searchOffer.getText());
				if(offer != null) {
					
					paintOffers();
				}else {
					JOptionPane.showMessageDialog(null, "No existen ofertas que coincidan con su búsqueda", "Búsqueda no encontrada", JOptionPane.WARNING_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Por favor ingrese un indicio para realizar la búsqueda", "Sin entradas", JOptionPane.WARNING_MESSAGE);
			}
			
		}else if(e.getActionCommand().equalsIgnoreCase(searchProviderBtn.getText())) {
			ArrayList<String> data = ctrl.searchProvider();
			
			viewProviderList(data);
			
			
		}else if(e.getActionCommand().equalsIgnoreCase(logOutBtn.getText())) {
			ctrl.destroySession();
			main.userWelcomeToMenu();
		}else if(e.getActionCommand().equalsIgnoreCase(buyServiceBtn.getText())) {
			int option = JOptionPane.showConfirmDialog(null, "Está a punto de comprar este servicio\n¿Está seguro que desea continuar?", "¿Continuar?", JOptionPane.YES_NO_OPTION);
			if(option == JOptionPane.YES_OPTION) {
				if(new ClientManagement(null).searchSpaces(Integer.parseInt(offer.get(0))) > 0) {
					buyWindow = new BuyWindow(this, "ReservIncomplete", Integer.parseInt(offer.get(2+index)), ctrl, "BUY");
				}else {
					JOptionPane.showMessageDialog(null, "Este servicio ha agotado sus cupos", "Sin cupos", JOptionPane.ERROR_MESSAGE);
				}
				
				System.out.println(offer);System.out.println(offer.get(2));
			}else {
				option = JOptionPane.showConfirmDialog(null, "No es necesario comprar el servicio ahora,\npuede reservarlo y pagarlo más adelante\n¿Desea hacer una reserva?", "¿Reservar?", JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_NO_OPTION) {
					ctrl.makeReservation(serviceId);
				}
			}
		}else if(e.getActionCommand().equalsIgnoreCase(reserveServiceBtn.getText())) {
			int option = JOptionPane.showConfirmDialog(null, "Esta a puento de reservar este servicio\n¿Desea continuar?", "¿Reservar?", JOptionPane.YES_NO_OPTION);
			if(option == JOptionPane.YES_NO_OPTION) {
				if(ctrl.makeReservation(serviceId)) {
					printCart();
				}
			}
		}else if(e.getActionCommand().equalsIgnoreCase(payReservation.getText())) {
			int option = JOptionPane.showConfirmDialog(null, "Está a punto de realizar el pago de estas reserva\n¿Está seguro que desea continuar?", "¿Continuar?", JOptionPane.YES_NO_OPTION);
			if(option == JOptionPane.YES_OPTION) {
				int cost = Integer.parseInt(totalLbl.getText().substring(8));
				System.out.println(cost);
				buyWindow = new BuyWindow(this, "ReservComplete", cost, ctrl, "CART");
				printCart();
				repaint();
			}
		}else if(e.getActionCommand().equalsIgnoreCase(searchHistory.getText())) {
			String date = dateTxt.getText();
			try {
				Date dateFromat = Date.valueOf(date);
				String history = ctrl.searchHistory(dateFromat);
				System.out.println(history);
				String msg = "";
				if (history != null) {
					String [] transactions = history.split(",");
					String [] transTemp;
					
					for (int i = 0; i < transactions.length; i++) {
						transTemp = transactions[i].split("/");
						msg += transTemp[1] + " el día: " + transTemp[3] + "\n";
					}
					historyArea.setText(msg);
				}else {
					historyArea.setText("No hay transacciones realizadas después de esta fecha.");
				}
				
			}catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "La fecha ingresada no es válida", "Fecha inválida", JOptionPane.ERROR_MESSAGE);
			}
		}else if (e.getActionCommand().contentEquals(nextButton.getText())) {
			if((index+=7) < offer.size()) {
				paintOffers();
			}else {
				JOptionPane.showMessageDialog(null, "Este es último servicio en la lista de resultados", "Última posición", JOptionPane.INFORMATION_MESSAGE);
			}
		}else if(e.getActionCommand().contentEquals(backButton.getText())) {
			if((index-=7) > 0) {
				paintOffers();
			}else {
				JOptionPane.showMessageDialog(null, "Este es primer servicio en la lista de resultados", "Primera posición", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
