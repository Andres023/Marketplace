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
	private JEditorPane services;
	
	public WelcomeAdminPanel(Controller ctrl, Main main) {
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
		
		JLabel servicesTitle = new JLabel("Administrar servicios");
		servicesTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		servicesTitle.setBounds(545, 88, 265, 33);
		add(servicesTitle);
		
		services = new JEditorPane();
		services.setEditable(false);
		services.setBounds(518, 125, 291, 310);
		add(services);
		
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
			
		}else if(e.getActionCommand().equalsIgnoreCase(next.getText())) {
			
		}else if(e.getActionCommand().equalsIgnoreCase(apply.getText())) {
			
		}else if(e.getActionCommand().equalsIgnoreCase(logOutBtn.getText())) {
			main.adminWelcomeToMenu();
		}
	}
}
