package visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import controller.Controller;

import javax.swing.JButton;

public class MainPanel extends JPanel implements ActionListener {
	
	//Components
	private Main main;
	private WelcomePanel welcome;
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
	private JButton registerProviderBtn;
	private JLabel lblNewLabel;
	
	public MainPanel(Main main, WelcomePanel welcome, UserRegisterPanel register, Controller ctrl) {
		
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
		registerUserBtn.setBounds(360, 448, 176, 40);
		registerUserBtn.addActionListener(this);
		add(registerUserBtn);
		
		registerAdminBtn = new JButton("Administrador");
		registerAdminBtn.setBounds(100, 451, 192, 35);
		registerAdminBtn.addActionListener(this);
		add(registerAdminBtn);
		
		registerProviderBtn = new JButton("Proveedor");
		registerProviderBtn.setBounds(621, 448, 176, 40);
		registerProviderBtn.addActionListener(this);
		add(registerProviderBtn);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(registerAdminBtn.getText())){
			System.out.println("1");
			
		}else if(e.getActionCommand().equals(registerUserBtn.getText())){
			main.showRegisterPanel(register);
			System.out.println("2");
			
		}else if(e.getActionCommand().equals(registerProviderBtn.getText())){
			System.out.println("3");
			
		}else if(e.getActionCommand().equals(loginBtn.getText())) {
			//Get data of the login form
			String email = emailTxt.getText();
			String password = passwordTxt.getText();
			
			//Calls the login function
			ctrl.login(email, password);
			
			System.out.println("Login");
		}
	}
}
