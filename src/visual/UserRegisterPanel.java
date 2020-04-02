package visual;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.Controller;
import world.User;

/*
 * Andrés Felipe Pájaro Jurado
 * 
 * User's interface to register & create an account 
 */
public class UserRegisterPanel extends JPanel implements ActionListener {

	//Utilities
	Main main;
	Controller ctrl;
	
	//Labels
	private JLabel title;
	private JLabel legend;
	private JLabel names;
	private JLabel lastnames;
	private JLabel docType;
	private JLabel docNumber;
	private JLabel phoneNumber;
	private JLabel postalCode;
	private JLabel birth;
	private JLabel gender;
	private JLabel email;
	private JLabel password;
	private JLabel repeatPasword;
	
	//Text Field
	private JTextField namesTxt;
	private JTextField lastnamesTxt;
	private JTextField docTypeTxt;
	private JTextField docNumberTxt;
	private JTextField phoneNumberTxt;
	private JTextField postalCodeTxt;
	private JTextField birthTxt;
	private JTextField genderTxt;
	private JTextField emailTxt;
	private JPasswordField passwordTxt;
	private JPasswordField repeatPaswordTxt;
	
	//Buttons
	private JButton submit;
	private JButton clean;
	private JButton backToMenuBtn;
	
	public UserRegisterPanel(Controller ctrl, Main main) {
		
		this.main = main;
		this.ctrl = ctrl;
		
		setLayout(null);
		setSize(900, 600);
		
		//Labels
		title = new JLabel("¡Estás a un paso de formar parte de Markteplace!");
		title.setFont(new Font("Arial", Font.BOLD, 25));
		title.setBounds(135, 20, 600, 25);
		this.add(title);
		
		
		legend = new JLabel("Por favor rellena los siguientes campos");
		legend.setFont(new Font("Arial", Font.PLAIN, 15));
		legend.setBounds(300, 70, 600, 25);
		this.add(legend);
		
		names = new JLabel("Nombres");
		names.setBounds(150, 110, 100, 25);
		this.add(names);
		
		lastnames = new JLabel("Apellidos");
		lastnames.setBounds(150, 150, 100, 25);
		this.add(lastnames);
		
		docType = new JLabel("Tipo de documento");
		docType.setBounds(150, 190, 120, 25);
		this.add(docType);
		
		docNumber = new JLabel("Número de documento");
		docNumber.setBounds(150, 230, 140, 25);
		this.add(docNumber);
		
		phoneNumber = new JLabel("Número de teléfono");
		phoneNumber.setBounds(150, 270, 140, 25);
		this.add(phoneNumber);
		
		postalCode = new JLabel("Código Postal");
		postalCode.setBounds(150, 310, 100, 25);
		this.add(postalCode);
		
		birth = new JLabel("Fecha de nacimiento");
		birth.setBounds(150, 350, 150, 25);
		this.add(birth);
		
		gender = new JLabel("Género");
		gender.setBounds(150, 390, 100, 25);
		this.add(gender);
		
		email = new JLabel("Correo electrónico");
		email.setBounds(150, 430, 100, 25);
		this.add(email);
		
		password = new JLabel("Contraseña");
		password.setBounds(150, 470, 100, 25);
		this.add(password);
		
		repeatPasword = new JLabel("Repita su contraseña");
		repeatPasword.setBounds(150, 510, 100, 25);
		this.add(repeatPasword);
		
		//Text Fields
		namesTxt = new JTextField();
		namesTxt.setBounds(300, 110, 300, 25);
		this.add(namesTxt);
		
		lastnamesTxt = new JTextField();
		lastnamesTxt.setBounds(300, 150, 300, 25);
		this.add(lastnamesTxt);
		
		docTypeTxt = new JTextField();
		docTypeTxt.setBounds(300, 190, 300, 25);
		this.add(docTypeTxt);

		docNumberTxt = new JTextField();
		docNumberTxt.setBounds(300, 230, 300, 25);
		this.add(docNumberTxt);
		
		phoneNumberTxt = new JTextField();
		phoneNumberTxt.setBounds(300, 270, 300, 25);
		this.add(phoneNumberTxt);
		
		postalCodeTxt = new JTextField();
		postalCodeTxt.setBounds(300, 310, 300, 25);
		this.add(postalCodeTxt);
		
		birthTxt = new JTextField();
		birthTxt.setBounds(300, 350, 300, 25);
		this.add(birthTxt);
		
		genderTxt = new JTextField();
		genderTxt.setBounds(300, 390, 300, 25);
		this.add(genderTxt);
		
		emailTxt = new JTextField();
		emailTxt.setBounds(300, 430, 300, 25);
		this.add(emailTxt);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(300, 470, 300, 25);
		this.add(passwordTxt);
		
		repeatPaswordTxt = new JPasswordField();
		repeatPaswordTxt.setBounds(300, 510, 300, 25);
		this.add(repeatPaswordTxt);

		//Buttons
		submit = new JButton("Registrame ahora");
		submit.setBounds(680, 216, 178, 25);
		submit.addActionListener(this);
		this.add(submit);
		clean = new JButton("Limpiar");
		clean.setBounds(680, 270, 178, 25);
		clean.addActionListener(this);
		this.add(clean);
		
		backToMenuBtn = new JButton("Volver");
		backToMenuBtn.setBounds(680, 327, 178, 23);
		backToMenuBtn.addActionListener(this);
		add(backToMenuBtn);
	}
	
	public void cleanForm() {
		namesTxt.setText("");
		lastnamesTxt.setText("");
		docTypeTxt.setText("");
		docNumberTxt.setText("");
		phoneNumberTxt.setText("");
		postalCodeTxt.setText("");
		birthTxt.setText("");
		genderTxt.setText("");
		emailTxt.setText("");
		passwordTxt.setText("");
		repeatPaswordTxt.setText("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("Registrame ahora")) {
			if(true) {
				//Personal info
				String names = namesTxt.getText();
				String lastnames = lastnamesTxt.getText();
				int docType = Integer.parseInt(docTypeTxt.getText());
				String docNumber = docNumberTxt.getText();
				String phoneNumber = phoneNumberTxt.getText();
				String postalCode = postalCodeTxt.getText();
				String date = birthTxt.getText();//Capture the String
				Date birth = Date.valueOf(date);//Convert the String to sql.Date
				int gender = Integer.parseInt(genderTxt.getText());
				
				//Account data
				String email = emailTxt.getText();
				String password = passwordTxt.getText();
				String verifyPassword = repeatPaswordTxt.getText();
				
				if(password.equals(verifyPassword)) {
					//Create the user
			        User user = new User(email, password, verifyPassword, names, lastnames, docType, docNumber, phoneNumber, postalCode, birth, gender); 
			        
			        ctrl.clientRegister(user);//Call the function, to register the new user
				}else {
					JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.WARNING_MESSAGE);
				}

			}else {
				JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
			}
		}else if(e.getActionCommand().equalsIgnoreCase("Limpiar")) {
			cleanForm();
		}else if(e.getActionCommand().contentEquals(backToMenuBtn.getText())) {
			main.backToMenu(this);
		}
	}

}