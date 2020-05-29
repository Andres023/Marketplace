package visual;

import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.Controller;
import world.Provider;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;

public class WelcomeAdminPanel extends JPanel implements ActionListener{

	private Controller ctrl;
	private Main main;
	
	private JTextField nameTxt;
	private JTextField companyNameTxt;
	private JTextField phoneTxt;
	private JTextField contactEmailTxt;
	private JTextField adressTxt;
	private JTextField emailTxt;
	private JPasswordField passwordTxt;
	private JPasswordField repeatPasswordTxt;
	private JButton registerProvider;
	private JButton back;
	private JButton next;
	private JButton apply;
	private JButton logOutBtn;
	private Choice providerTypeChoise;
	private JTextField serviceNameTxt;
	private JTextField costTxt;
	private JTextField originCityTxt;
	private JTextField destinyCityTxt;
	private JTextField offerIndication;
	private JButton searchOffers;
	private JRadioButton transportRadio;
	private JRadioButton hotelRadio;
	private JRadioButton foodRadio;
	
	private String [] services;
	private String [] serviceTmp;
	private String [] description;
	private String searchServices;
	private JLabel publishDate;
	private JLabel date;
	private int serviceIndex;
	private JTextField spacesTxt;
	
	public WelcomeAdminPanel(Controller ctrl, Main main) {
		this.ctrl = ctrl;
		this.main = main;
		
		setSize(900, 600);
		setLayout(null);
		
		JLabel title = new JLabel("BIENVENIDO(A) SE\u00D1OR(A): ");
		title.setFont(new Font("Arial", Font.BOLD, 20));
		title.setBounds(68, 50, 683, 38);
		add(title);
		
		JLabel welcomelbl = new JLabel("\u00BFQu\u00E9 desea hacer hoy?");
		welcomelbl.setFont(new Font("Tahoma", Font.PLAIN, 11));
		welcomelbl.setBounds(62, 110, 217, 20);
		add(welcomelbl);
		
		logOutBtn = new JButton("Cerrar sesi\u00F3n");
		logOutBtn.setBounds(672, 513, 138, 23);
		logOutBtn.addActionListener(this);
		add(logOutBtn);
		
		JLabel registerProviderLbl = new JLabel("Registar un nuevo proveedor");
		registerProviderLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		registerProviderLbl.setBounds(62, 153, 271, 33);
		add(registerProviderLbl);
		
		registerProvider = new JButton("Registrar");
		registerProvider.setBounds(190, 490, 89, 23);
		registerProvider.addActionListener(this);
		add(registerProvider);
		
		JLabel nameLbl = new JLabel("Nombre");
		nameLbl.setBounds(62, 200, 79, 14);
		add(nameLbl);
		
		JLabel companyNameLbl = new JLabel("Nombre de la empresa");
		companyNameLbl.setBounds(62, 230, 147, 14);
		add(companyNameLbl);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(237, 200, 210, 20);
		add(nameTxt);
		nameTxt.setColumns(10);
		
		companyNameTxt = new JTextField();
		companyNameTxt.setColumns(10);
		companyNameTxt.setBounds(237, 230, 210, 20);
		add(companyNameTxt);
		
		JLabel phoneLbl = new JLabel("Tel\u00E9fono");
		phoneLbl.setBounds(62, 260, 147, 14);
		add(phoneLbl);
		
		phoneTxt = new JTextField();
		phoneTxt.setColumns(10);
		phoneTxt.setBounds(237, 260, 210, 20);
		add(phoneTxt);
		
		JLabel contactEmailLbl = new JLabel("Correo de contacto");
		contactEmailLbl.setBounds(62, 290, 147, 14);
		add(contactEmailLbl);
		
		contactEmailTxt = new JTextField();
		contactEmailTxt.setColumns(10);
		contactEmailTxt.setBounds(237, 290, 210, 20);
		add(contactEmailTxt);
		
		JLabel adressLbl = new JLabel("Direcci\u00F3n");
		adressLbl.setBounds(62, 320, 147, 14);
		add(adressLbl);
		
		adressTxt = new JTextField();
		adressTxt.setColumns(10);
		adressTxt.setBounds(237, 320, 210, 20);
		add(adressTxt);
		
		JLabel providerTypeLbl = new JLabel("Tipo de proveedor");
		providerTypeLbl.setBounds(62, 350, 147, 14);
		add(providerTypeLbl);
		
		providerTypeChoise = new Choice();
		providerTypeChoise.add("");
		providerTypeChoise.add("Empresa");
		providerTypeChoise.add("Representante");
		providerTypeChoise.setBounds(237, 350, 210, 20);
		add(providerTypeChoise);
		
		JLabel emailLbl = new JLabel("Correo");
		emailLbl.setBounds(62, 380, 147, 14);
		add(emailLbl);
		
		emailTxt = new JTextField();
		emailTxt.setColumns(10);
		emailTxt.setBounds(237, 380, 210, 20);
		add(emailTxt);
		
		JLabel passwordLbl = new JLabel("Contrase\u00F1a");
		passwordLbl.setBounds(62, 410, 147, 14);
		add(passwordLbl);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(237, 410, 210, 20);
		add(passwordTxt);
		
		JLabel repeatPasswordLbl = new JLabel("Repita la contrase\u00F1a");
		repeatPasswordLbl.setBounds(62, 440, 147, 14);
		add(repeatPasswordLbl);
		
		repeatPasswordTxt = new JPasswordField();
		repeatPasswordTxt.setColumns(10);
		repeatPasswordTxt.setBounds(237, 440, 210, 20);
		add(repeatPasswordTxt);
		
		back = new JButton("<");
		back.setBounds(518, 456, 55, 23);
		back.addActionListener(this);
		add(back);
		
		next = new JButton(">");
		next.setBounds(755, 456, 55, 23);
		next.addActionListener(this);
		add(next);
		
		apply = new JButton("Actualizar");
		apply.setBounds(616, 456, 101, 23);
		apply.addActionListener(this);
		add(apply);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(501, 83, 361, 357);
		add(panel);
		panel.setLayout(null);
		
		JLabel serviceNameLbl = new JLabel("Nombre del servicio");
		serviceNameLbl.setBounds(10, 57, 138, 14);
		panel.add(serviceNameLbl);
		
		serviceNameTxt = new JTextField();
		serviceNameTxt.setColumns(10);
		serviceNameTxt.setBounds(141, 57, 205, 20);
		panel.add(serviceNameTxt);
		
		JLabel costLbl = new JLabel("Costo");
		costLbl.setBounds(10, 90, 46, 14);
		panel.add(costLbl);
		
		costTxt = new JTextField();
		costTxt.setColumns(10);
		costTxt.setBounds(141, 87, 205, 20);
		panel.add(costTxt);
		
		JLabel originCityLbl = new JLabel("Ciudad de Origen");
		originCityLbl.setBounds(10, 120, 127, 14);
		panel.add(originCityLbl);
		
		originCityTxt = new JTextField();
		originCityTxt.setColumns(10);
		originCityTxt.setBounds(141, 117, 205, 20);
		panel.add(originCityTxt);
		
		JLabel descriptionLbl = new JLabel("Descripci\u00F3n del paquete");
		descriptionLbl.setBounds(10, 156, 172, 14);
		panel.add(descriptionLbl);
		
		transportRadio = new JRadioButton("Transaporte");
		transportRadio.setBounds(10, 182, 109, 23);
		panel.add(transportRadio);
		
		hotelRadio = new JRadioButton("Hotel");
		hotelRadio.setBounds(10, 208, 109, 23);
		panel.add(hotelRadio);
		
		foodRadio = new JRadioButton("Alimento");
		foodRadio.setBounds(10, 234, 109, 23);
		panel.add(foodRadio);
		
		JLabel destinationCityLbl = new JLabel("Ciudad de destino");
		destinationCityLbl.setBounds(10, 270, 127, 14);
		panel.add(destinationCityLbl);
		
		destinyCityTxt = new JTextField();
		destinyCityTxt.setColumns(10);
		destinyCityTxt.setBounds(141, 267, 205, 20);
		panel.add(destinyCityTxt);
		
		JLabel servicesTitle = new JLabel("Administrar servicios");
		servicesTitle.setBounds(10, 11, 265, 33);
		panel.add(servicesTitle);
		servicesTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		offerIndication = new JTextField();
		offerIndication.setBounds(10, 314, 225, 20);
		panel.add(offerIndication);
		offerIndication.setColumns(10);
		
		searchOffers = new JButton("Buscar");
		searchOffers.setBounds(257, 313, 89, 23);
		searchOffers.addActionListener(this);
		panel.add(searchOffers);
		
		publishDate = new JLabel("Fecha de publicaci\u00F3n");
		publishDate.setBounds(190, 156, 127, 14);
		panel.add(publishDate);
		
		date = new JLabel("");
		date.setFont(new Font("Tahoma", Font.PLAIN, 11));
		date.setBounds(190, 182, 127, 19);
		panel.add(date);
		
		JLabel spaceslbl = new JLabel("Cupos");
		spaceslbl.setBounds(190, 217, 62, 14);
		panel.add(spaceslbl);
		
		spacesTxt = new JTextField();
		spacesTxt.setBounds(231, 215, 86, 20);
		panel.add(spacesTxt);
		spacesTxt.setColumns(10);
	}
	
	public boolean formValidate(){
		if(nameTxt.getText().length() > 0 && companyNameTxt.getText().length() > 0 && phoneTxt.getText().length() > 0 
				&& contactEmailTxt.getText().length() > 0 && contactEmailTxt.getText().length() > 0  &&  adressTxt.getText().length() > 0
				&&  providerTypeChoise.getSelectedItem().toString().length() > 0 && emailTxt.getText().length() > 0 
				&& passwordTxt.getText().length() > 0 && repeatPasswordTxt.getText().length() >0) {
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * When the administrator logs in, the system search the 
	 * available offers
	 */	
	public void searchOffers(String offerIndication) {
		services = null;
		serviceIndex = 0;
		searchServices = ctrl.adminSearchOffer(offerIndication);
		
		if(searchServices != null) {
			//System.out.println(searchServices);
			services = searchServices.split("/");
			showOffers();
		}
	}
	
	public void showOffers() {
		serviceTmp = services [serviceIndex].split(",");
		
		//Set the values on the interface
		serviceNameTxt.setText(serviceTmp[1]);
		costTxt.setText(serviceTmp[2]);
		date.setText(serviceTmp[3]);
		originCityTxt.setText(serviceTmp[4]);
		destinyCityTxt.setText(serviceTmp[6]);
		spacesTxt.setText(serviceTmp[7]);
		description = serviceTmp[8].split("-");
		
		showDescription();
	}
	
	public void showDescription() {
		//System.out.println(description[0]+description[1]+description[2]);
		
		if(description[0].equals("1")) {
			transportRadio.setSelected(true);
		}else {
			transportRadio.setSelected(false);
		}
		if(description[1].equals("1")) {
			hotelRadio.setSelected(true);
		}else {
			hotelRadio.setSelected(false);
		}
		if(description[2].equals("1")) {
			foodRadio.setSelected(true);
		}else {
			foodRadio.setSelected(false);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase(registerProvider.getText())) {
			if(formValidate()) {
				//Get the data of the provider form
				String name = nameTxt.getText();
				String companyName = companyNameTxt.getText();
				String phoneNumber = phoneTxt.getText();
				String contactEmail = contactEmailTxt.getText();
				String adress = adressTxt.getText();
				int providerType = -1;
				switch (providerTypeChoise.getSelectedItem()) {
				case "Empresa":
					providerType = 1;
					break;
				case "Representante":
					providerType = 2;
					break;
				}
				
				if(providerType > 0) {
					String email = emailTxt.getText();
					String password = passwordTxt.getText();
					String verifyPassword = repeatPasswordTxt.getText();
					if(password.equals(verifyPassword)) {
						
						//Create the provider object
						Provider provider = new Provider(name, companyName, phoneNumber, contactEmail, adress, providerType, email, verifyPassword);
						ctrl.providerRegister(provider);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
			}
		}else if(e.getActionCommand().equalsIgnoreCase(back.getText())) {
			if((serviceIndex -= 1) > -1) {
				showOffers();
			}else {
				JOptionPane.showMessageDialog(null, "Este servicio es el primero en la lista, no puede retroceder", "Primer servicio", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}else if(e.getActionCommand().equalsIgnoreCase(next.getText())) {
			if((serviceIndex += 1) < services.length) {
				showOffers();
			}else {
				JOptionPane.showMessageDialog(null, "Esté es el último servicio en la lista", "Último servicio", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}else if(e.getActionCommand().equalsIgnoreCase(apply.getText())) {
			
			//Update a service's info
			int idService = Integer.parseInt(serviceTmp[0]);
			String name = serviceNameTxt.getText();
			int cost = Integer.parseInt(costTxt.getText());
			String origin = originCityTxt.getText();
			int idDescription = Integer.parseInt(serviceTmp[5]);
			String destiny = destinyCityTxt.getText();
			int spaces = Integer.parseInt(spacesTxt.getText());
			
			String descriptions = "";
			
			//Find the state of description
			
			if(transportRadio.isSelected()) {
				descriptions+="1-";
			}else {
				descriptions+="0-";
			}
			if(hotelRadio.isSelected()) {
				descriptions+="1-";
			}else {
				descriptions+="0-";
			}
			if(foodRadio.isSelected()) {
				descriptions+="1-";
			}else {
				descriptions+="0-";
			}
			
			ctrl.updateService(idService,name,cost,origin,idDescription,destiny,descriptions, spaces);
			//System.out.println(idService+name+cost+date+origin+idDescription+destiny+descriptions);
			
		}else if(e.getActionCommand().equalsIgnoreCase(searchOffers.getText())) {
			if(offerIndication.getText().length() > 0) {
				searchOffers(offerIndication.getText());
				
			}else {
				JOptionPane.showMessageDialog(null, "No hay indicios para realizar la búsqueda", "Sin indicios", JOptionPane.WARNING_MESSAGE);
			}
			
		}else if(e.getActionCommand().equalsIgnoreCase(logOutBtn.getText())) {
			main.adminWelcomeToMenu();
		}
	}
}
