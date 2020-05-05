package visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.Controller;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;


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
	private JTextField searchProvider;
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
	private JLabel pendingPayLbl;
	
	private JRadioButton transportRbtn;
	private JRadioButton hotelRbtn;
	private JRadioButton foodRbtn;
	
	private JPanel panelOffer;
	
	private int description [];
	private int serviceId;
	
	private BuyWindow buyWindow;
	
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
		searchProviderLbl.setBounds(62, 425, 194, 33);
		add(searchProviderLbl);
		
		searchProvider = new JTextField();
		searchProvider.setColumns(10);
		searchProvider.setBounds(62, 472, 291, 20);
		add(searchProvider);
		
		searchProviderBtn = new JButton("Buscar");
		searchProviderBtn.setBounds(358, 469, 89, 23);
		searchProvider.addActionListener(this);
		add(searchProviderBtn);
		
		JLabel transactionsLbl = new JLabel("Historial de transacciones");
		transactionsLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		transactionsLbl.setBounds(500, 97, 265, 33);
		add(transactionsLbl);
		
		panelOffer = new JPanel();
		panelOffer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelOffer.setLayout(null);
		panelOffer.setBounds(62, 211, 385, 203);
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
		dateLbl.setBounds(167, 155, 127, 14);
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
		transportRbtn.setBounds(72, 107, 31, 23);
		panelOffer.add(transportRbtn);
		
		hotelRbtn = new JRadioButton("");
		hotelRbtn.setEnabled(false);
		hotelRbtn.setBounds(72, 126, 31, 23);
		panelOffer.add(hotelRbtn);
		
		foodRbtn = new JRadioButton("");
		foodRbtn.setEnabled(false);
		foodRbtn.setBounds(72, 146, 31, 23);
		panelOffer.add(foodRbtn);
		
		buyServiceBtn = new JButton("Comprar");
		buyServiceBtn.setBounds(286, 11, 89, 23);
		buyServiceBtn.addActionListener(this);
		
		reserveServiceBtn = new JButton("Reservar");
		reserveServiceBtn.setBounds(286, 40, 89, 23);
		reserveServiceBtn.addActionListener(this);
		
		JLabel searchOfferLbl = new JLabel("Buscar ofertas\r\n");
		searchOfferLbl.setBounds(62, 136, 194, 33);
		add(searchOfferLbl);
		searchOfferLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel reservations = new JLabel("Pagos pendientes");
		reservations.setFont(new Font("Tahoma", Font.BOLD, 15));
		reservations.setBounds(500, 291, 265, 33);
		add(reservations);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(500, 335, 310, 109);
		add(panel);
		panel.setLayout(null);
		
		pendingPayLbl = new JLabel("...");
		pendingPayLbl.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pendingPayLbl.setBounds(10, 11, 290, 32);
		panel.add(pendingPayLbl);
		
		payReservation = new JButton("Pagar");
		payReservation.setBounds(211, 75, 89, 23);
		payReservation.addActionListener(this);
		panel.add(payReservation);
	}
	
	/*
	 * Calls the controller to buy the service
	 */
	public void makeTransaction(String reserveStatus) {
		ctrl.makeTransaction(serviceId, reserveStatus);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase(searchOfferBtn.getText())) {
			if(searchOffer.getText().length() > 0) {
				
				ArrayList<String> offer = ctrl.searchOfferByName(searchOffer.getText());
				if(offer != null) {
					
					//Show the service information

					serviceId = Integer.parseInt(offer.get(0));System.out.println(serviceId);
					
					nameOffer.setText(offer.get(1));
					costOffer.setText(offer.get(2) + " COP");
					publishDate.setText(offer.get(3));
					originCity.setText("De: " + offer.get(4));
					destinationCity.setText("A: " + offer.get(6));
					
					description = ctrl.searchOfferDescription(Integer.parseInt(offer.get(5)));
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
				}else {
					JOptionPane.showMessageDialog(null, "No existen ofertas que coincidan con su búsqueda", "Búsqueda no encontrada", JOptionPane.WARNING_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Por favor ingrese un indicio para realizar la búsqueda", "Sin entradas", JOptionPane.WARNING_MESSAGE);
			}
			
		}else if(e.getActionCommand().equalsIgnoreCase(searchProviderBtn.getText())) {
			
		}else if(e.getActionCommand().equalsIgnoreCase(logOutBtn.getText())) {
			ctrl.destroySession();
			main.userWelcomeToMenu();
		}else if(e.getActionCommand().equalsIgnoreCase(buyServiceBtn.getText())) {
			int option = JOptionPane.showConfirmDialog(null, "Está a punto de comprar este servicio\n¿Está seguro que desea continuar?", "¿Continuar?", JOptionPane.YES_NO_OPTION);
			if(option == JOptionPane.YES_OPTION) {
				buyWindow = new BuyWindow(this, "ReservIncomplete");
			}else {
				option = JOptionPane.showConfirmDialog(null, "No es necesario comprar el servicio ahora,\npuede reservarlo y pagarlo más adelante\n¿Desea hacer una reserva?", "¿Reservar?", JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_NO_OPTION) {
					ctrl.makeReservation(serviceId);
				}
			}
		}else if(e.getActionCommand().equalsIgnoreCase(reserveServiceBtn.getText())) {
			int option = JOptionPane.showConfirmDialog(null, "Esta a puento de reservar este servicio\n¿Desea continuar?", "¿Reservar?", JOptionPane.YES_NO_OPTION);
			if(option == JOptionPane.YES_NO_OPTION) {
				ctrl.makeReservation(serviceId);
			}
		}else if(e.getActionCommand().equalsIgnoreCase(payReservation.getText())) {
			int option = JOptionPane.showConfirmDialog(null, "Está a punto de realizar el pago de está reserva\n¿Está seguro que desea continuar?", "¿Continuar?", JOptionPane.YES_NO_OPTION);
			if(option == JOptionPane.YES_OPTION) {
				buyWindow = new BuyWindow(this, "ReservComplete");
			}
		}
	}
}
