package visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controller.Controller;

import javax.swing.JButton;

public class MainPanel extends JPanel implements ActionListener {
	
	//Components
	private Main main;
	private WelcomeUserPanel welcome;
	private UserRegisterPanel register;
	private Controller ctrl;
	
	//Interface
	private JLabel title;
	private JLabel password;
	private JLabel email;
	
	private JTextField emailTxt;
	private JPasswordField passwordTxt;
	
	private JButton loginBtn;
	private JButton registerUserBtn;
	private JButton registerAdminBtn;
	private JLabel lblNewLabel;
	
	public MainPanel(Main main, WelcomeUserPanel welcome, UserRegisterPanel register, Controller ctrl) {
		
		//Components
		this.main = main;
		this.welcome = welcome;
		this.register = register;
		this.ctrl = ctrl;
		
		//Window
		setSize(900,600);
		setLayout(null);		
		
		//Form
		title = new JLabel("Marketplace");
		title.setFont(new Font("Arial", Font.BOLD, 50));
		title.setBounds(309, 35, 316, 107);
		add(title);
		
		email = new JLabel("Correo");
		email.setFont(new Font("Arial", Font.PLAIN, 25));
		email.setBounds(100, 172, 105, 40);
		add(email);
		
		emailTxt = new JTextField();
		emailTxt.setBounds(303, 177, 335, 35);
		add(emailTxt);
		emailTxt.setColumns(10);
		
		password = new JLabel("Contraseña");
		password.setFont(new Font("Arial", Font.PLAIN, 25));
		password.setBounds(100, 270, 145, 40);
		add(password);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(303, 270, 335, 35);
		add(passwordTxt);
		passwordTxt.setColumns(10);
		
		//Buttons
		loginBtn = new JButton("Inciar Sesion");
		loginBtn.setBounds(693, 262, 152, 48);
		loginBtn.addActionListener(this);
		add(loginBtn);
		
		lblNewLabel = new JLabel("¿No tiene una cuenta? Registrate como:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(320, 366, 274, 40);
		add(lblNewLabel);
		
		registerUserBtn = new JButton("Usuario");
		registerUserBtn.setBounds(550, 448, 176, 40);
		registerUserBtn.addActionListener(this);
		add(registerUserBtn);
		
		registerAdminBtn = new JButton("Administrador");
		registerAdminBtn.setBounds(206, 451, 192, 35);
		registerAdminBtn.addActionListener(this);
		add(registerAdminBtn);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(registerAdminBtn.getText())){
			main.showAdministratorRegisterPanel();
			//System.out.println("1");
			
		}else if(e.getActionCommand().equals(registerUserBtn.getText())){
			main.showUserRegisterPanel();
			//System.out.println("2");
			
		}else if(e.getActionCommand().equals(loginBtn.getText())) {
			//Get data of the login form
			String email = emailTxt.getText();
			String password = passwordTxt.getText();
			
			//Calls the login functions to verify if the person that wants login is a user, administrator 
			//or a not registered person
			if(ctrl.userLogin(email, password) == 1) {
				//System.out.print("User");
				ctrl.showWelcomePanel(1);
				
			}else if(ctrl.adminLogin(email, password) == 2){
				//System.out.print("Admin");
				ctrl.showWelcomePanel(2);
			}else if(ctrl.providerLogin(email, password) == 3){
				//System.out.println("Provider");
				ctrl.showWelcomePanel(3);
			}else
				JOptionPane.showMessageDialog(null, "El correo o la contraseña son incorrectos.\n"
	        			+ "Por favor inténtelo nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
			}
	}

	public void refresh() {
		emailTxt.setText("");
		passwordTxt.setText("");
	}
}
