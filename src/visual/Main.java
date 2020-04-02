package visual;

import javax.swing.JFrame;

import controller.Controller;
/*
 * @author Andrés Pájaro
 * 
 */
public class Main extends JFrame{

	//Visual
	private MainPanel pnlMain;
	private UserRegisterPanel userRegister;
	private WelcomePanel welcome;
	
	//Controller
	private Controller ctrl; 
	
	public Main() {
		ctrl = new Controller(this);
		
		userRegister = new UserRegisterPanel(ctrl, this);
		welcome = new WelcomePanel(ctrl);
		
		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pnlMain = new MainPanel(this, welcome, userRegister, ctrl);
		this.add(pnlMain);
		
		setVisible(true);
		
	}
	
	/*
	 * 
	 */
	public void showRegisterPanel(UserRegisterPanel register) {
		this.remove(pnlMain);
		this.add(register);
		screenRefresh();
	}
	
	public void backToMenu(UserRegisterPanel userRegisterPanel) {
		this.remove(userRegisterPanel);
		this.add(pnlMain);
		screenRefresh();
	}
	
	public void showWelcomePanel() {
		this.remove(pnlMain);
		this.add(welcome);
		screenRefresh();
	}
	
	public void screenRefresh() {
		this.revalidate();
		this.repaint();
	}
	
	public static void main(String[] args) {
		new Main();
	}

	
	
}
