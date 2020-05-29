package visual;

import java.awt.Choice;
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
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;

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
	private JTextField docNumberTxt;
	private JTextField phoneNumberTxt;
	private JTextField postalCodeTxt;
	private JTextField emailTxt;
	private JPasswordField passwordTxt;
	private JPasswordField repeatPaswordTxt;
	
	//Buttons
	private JButton submit;
	private JButton clean;
	private JButton backToMenuBtn;
	
	//Drop-Down List
	private Choice docTypeChoice;
	private Choice genderTypeChoice;

	//Birth with Format
	private String birthFormat;
	private JSpinner dayChoise;
	private JSpinner monthChoise;
	private JSpinner yearChoise;
	
	
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
		birth.setBounds(150, 350, 120, 25);
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
		
		//Drop-Down List for the document type
		docTypeChoice = new Choice();
		docTypeChoice.addItem("");
		docTypeChoice.addItem("CC");
		docTypeChoice.addItem("CE");
		docTypeChoice.addItem("PA");
		docTypeChoice.addItem("TI");
		docTypeChoice.setBounds(300, 190, 300, 25);
		this.add(docTypeChoice);

		docNumberTxt = new JTextField();
		docNumberTxt.setBounds(300, 230, 300, 25);
		this.add(docNumberTxt);
		
		phoneNumberTxt = new JTextField();
		phoneNumberTxt.setBounds(300, 270, 300, 25);
		this.add(phoneNumberTxt);
		
		postalCodeTxt = new JTextField();
		postalCodeTxt.setBounds(300, 310, 300, 25);
		this.add(postalCodeTxt);
		
		//Brith
		
		//Drop-Down List for the gender
		genderTypeChoice = new Choice();
		genderTypeChoice.addItem("");
		genderTypeChoice.addItem("Masculino");
		genderTypeChoice.addItem("Femenino");
		genderTypeChoice.addItem("Otro");
		genderTypeChoice.setBounds(300, 390, 300, 25);
		this.add(genderTypeChoice);
		
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
		
		dayChoise = new JSpinner();
		dayChoise.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		dayChoise.setBounds(448, 352, 39, 20);
		add(dayChoise);
		
		monthChoise = new JSpinner();
		monthChoise.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		monthChoise.setBounds(384, 352, 54, 20);
		add(monthChoise);
		
		yearChoise = new JSpinner();
		yearChoise.setModel(new SpinnerNumberModel(1950, 1950, 2020, 1));
		yearChoise.setBounds(300, 352, 74, 20);
		add(yearChoise);
		
		JLabel lblNewLabel = new JLabel("(YYYY-MM-DD)");
		lblNewLabel.setBounds(509, 355, 82, 14);
		add(lblNewLabel);
	}
	
	public void cleanForm() {
		namesTxt.setText("");
		lastnamesTxt.setText("");
		docNumberTxt.setText("");
		phoneNumberTxt.setText("");
		postalCodeTxt.setText("");
		emailTxt.setText("");
		passwordTxt.setText("");
		repeatPaswordTxt.setText("");
	}
	
	public boolean formValidate() {
		birthFormat();
		if(namesTxt.getText().length() > 0 && lastnamesTxt.getText().length() > 0 && docTypeChoice.getSelectedItem().toString().length() > 0
				&& docNumberTxt.getText().length() > 0 && phoneNumberTxt.getText().length() > 0 && postalCodeTxt.getText().length() > 0 
				&& getBirthFormat().length() > 0 && genderTypeChoice.getSelectedItem().toString().length() > 0 && emailTxt.getText().length() > 0 
				&& passwordTxt.getText().length() > 0 && repeatPaswordTxt.getText().length() > 0) {
			//System.out.println("Lleno");
			return true;
		}else {
			//System.out.print("Incompleto");
			return false;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("Registrame ahora")) {
			if(formValidate() ) {
				//Personal info
				String names = namesTxt.getText();
				String lastnames = lastnamesTxt.getText();
				int docType = docTypeConvertion();
				String docNumber = docNumberTxt.getText();
				String phoneNumber = phoneNumberTxt.getText();
				String postalCode = postalCodeTxt.getText();
				String date = getBirthFormat();//Capture the String
				Date birth = Date.valueOf(date);//Convert the String to sql.Date
				int gender = genderTypeConvertion();
				
				//Account data
				String email = emailTxt.getText();
				String password = passwordTxt.getText();
				String verifyPassword = repeatPaswordTxt.getText();
				
				if(password.equals(verifyPassword)) {
					if(password.length() < 19) {
						//Create the user
				        User user = new User(email, password, verifyPassword, names, lastnames, docType, docNumber, phoneNumber, postalCode, birth, gender); 
				        
				        ctrl.clientRegister(user);//Call the function, to register the new user
					}else {
						JOptionPane.showMessageDialog(null, "Las contraseñas es demasiado larga", "Error", JOptionPane.WARNING_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.WARNING_MESSAGE);
				}

			}else {
				JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
			}
		}else if(e.getActionCommand().equalsIgnoreCase(clean.getText())) {
			cleanForm();
		}else if(e.getActionCommand().contentEquals(backToMenuBtn.getText())) {
			main.userToMenu();
		}
	}

	private int genderTypeConvertion() {
		if(genderTypeChoice.getSelectedItem().equalsIgnoreCase("Masculino")) {
			return 1;
		}else if(genderTypeChoice.getSelectedItem().equalsIgnoreCase("Femenino")) {
			return 2;
		}else if(genderTypeChoice.getSelectedItem().equalsIgnoreCase("Otro")) {
			return 3;
		}else {
			return -1;
		}
	}

	private int docTypeConvertion() {
		if(docTypeChoice.getSelectedItem().equalsIgnoreCase("CC")) {
			return 1;
		}else if(docTypeChoice.getSelectedItem().equalsIgnoreCase("CE")) {
			return 2;
		}else if(docTypeChoice.getSelectedItem().equalsIgnoreCase("PA")) {
			return 3;
		}else if(docTypeChoice.getSelectedItem().equalsIgnoreCase("TI")){
			return 4;
		}else {
			return -1;
		}
	}

	public void birthFormat() {
		setBirthFormat(yearChoise.getValue()+"-"+monthChoise.getValue()+"-"+dayChoise.getValue());
	}
	
	public String getBirthFormat() {
		return birthFormat;
	}

	public void setBirthFormat(String birthFormat) {
		this.birthFormat = birthFormat;
	}
}