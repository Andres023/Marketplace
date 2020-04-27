package visual;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.Controller;
import world.Service;

import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class WelcomeProviderPanel extends JPanel implements ActionListener{

	private Controller ctrl;
	private Main main;
	
	private JButton logOutBtn;
	private JButton showSales;
	private JButton showTrasactionsByClient;
	private JEditorPane services;
	private JTextField nameTxt;
	private JTextField costTxt;
	private JTextField originCityTxt;
	private JTextField destinationCityTxt;
	private JButton publish;
	
	private JRadioButton transportRadio;
	private JRadioButton hotelRadio;
	private JRadioButton foodRadio;
	
	public WelcomeProviderPanel(Controller ctrl, Main main) {
		
		this.ctrl = ctrl;
		this.main = main;
		
		setSize(900, 600);
		setLayout(null);
		
		JLabel title = new JLabel("BIENVENIDO(A) SE\u00D1OR(A): ");
		title.setFont(new Font("Arial", Font.BOLD, 20));
		title.setBounds(62, 50, 683, 38);
		add(title);
		
		JLabel welcomelbl = new JLabel("\u00BFQu\u00E9 desea hacer hoy?");
		welcomelbl.setFont(new Font("Tahoma", Font.PLAIN, 11));
		welcomelbl.setBounds(62, 110, 217, 20);
		add(welcomelbl);
		
		JLabel publishServiceLbl = new JLabel("Publicar oferta");
		publishServiceLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		publishServiceLbl.setBounds(62, 147, 194, 33);
		add(publishServiceLbl);
		
		services = new JEditorPane();
		services.setEditable(false);
		services.setBounds(512, 99, 297, 336);
		add(services);
		
		logOutBtn = new JButton("Cerrar sesi\u00F3n");
		logOutBtn.setBounds(672, 508, 138, 23);
		logOutBtn.addActionListener(this);
		add(logOutBtn);
		
		showSales = new JButton("Ventas globales");
		showSales.setBounds(512, 456, 138, 23);
		showSales.addActionListener(this);
		add(showSales);
		
		showTrasactionsByClient = new JButton("Ventas de un cliente");
		showTrasactionsByClient.setBounds(660, 456, 150, 23);
		showTrasactionsByClient.addActionListener(this);
		add(showTrasactionsByClient);
		
		JLabel serviceNameLbl = new JLabel("Nombre del servicio");
		serviceNameLbl.setBounds(62, 190, 138, 14);
		add(serviceNameLbl);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(193, 190, 229, 20);
		add(nameTxt);
		nameTxt.setColumns(10);
		
		JLabel costLbl = new JLabel("Costo");
		costLbl.setBounds(62, 223, 46, 14);
		add(costLbl);
		
		costTxt = new JTextField();
		costTxt.setBounds(193, 220, 229, 20);
		add(costTxt);
		costTxt.setColumns(10);
		
		JLabel originCityLbl = new JLabel("Ciudad de Origen");
		originCityLbl.setBounds(62, 253, 127, 14);
		add(originCityLbl);
		
		originCityTxt = new JTextField();
		originCityTxt.setColumns(10);
		originCityTxt.setBounds(193, 250, 229, 20);
		add(originCityTxt);
		
		JLabel descriptionLbl = new JLabel("Descripci\u00F3n del paquete");
		descriptionLbl.setBounds(62, 289, 172, 14);
		add(descriptionLbl);
		
		JLabel destinationCityLbl = new JLabel("Ciudad de destino");
		destinationCityLbl.setBounds(62, 403, 127, 14);
		add(destinationCityLbl);
		
		destinationCityTxt = new JTextField();
		destinationCityTxt.setBounds(193, 400, 229, 20);
		add(destinationCityTxt);
		destinationCityTxt.setColumns(10);
		
		publish = new JButton("Publicar");
		publish.setBounds(62, 456, 89, 23);
		publish.addActionListener(this);
		add(publish);
		
		transportRadio = new JRadioButton("Transaporte");
		transportRadio.setBounds(62, 315, 109, 23);
		add(transportRadio);
		
		hotelRadio = new JRadioButton("Hotel");
		hotelRadio.setBounds(62, 341, 109, 23);
		add(hotelRadio);
		
		foodRadio = new JRadioButton("Alimento");
		foodRadio.setBounds(62, 367, 109, 23);
		add(foodRadio);
	}
	
	public int findDescription(JRadioButton item) {
		if(item.isSelected()) {
			return 1; 
		}else {
			return 0;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase(publish.getText())) {
			System.out.println("publish");
			
			//Validate if the all JText are full
			if(nameTxt.getText().length() > 0 && costTxt.getText().length() > 0 && originCityTxt.getText().length() > 0
					&& destinationCityTxt.getText().length() > 0) {
				//Find the description of the service
				int trnsport = findDescription(transportRadio);
				int htel = findDescription(hotelRadio);
				int fod = findDescription(foodRadio);
				
				System.out.println(trnsport+" "+htel+" "+fod);
				
				//Check if at least one of the JRadioButton is selected
				if(trnsport == 0 && htel == 0 && fod == 0) {
					JOptionPane.showMessageDialog(null, "Por favor seleccione al menos item de descripción", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
				}else{
					
					String name = nameTxt.getText();
					int cost = Integer.parseInt(costTxt.getText());
					String originCity = originCityTxt.getText();
					String destinationCity = destinationCityTxt.getText();
					
					//Create the service object
					Service service = new Service(name, cost, originCity, destinationCity, trnsport, htel, fod);
					
					ctrl.publishService(service);
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
			}	
			
		}else if(e.getActionCommand().equalsIgnoreCase(showSales.getText())) {
			
		}else if(e.getActionCommand().equalsIgnoreCase(showTrasactionsByClient.getText())) {
			
		}else if(e.getActionCommand().equalsIgnoreCase(logOutBtn.getText())) {
			main.providerWelcomeToMenu();
		}
		
	}
}
