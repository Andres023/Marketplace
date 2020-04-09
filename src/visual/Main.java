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
	private AdministratorRegisterPanel adminRegister;
	
	//Controller
	private Controller ctrl; 
	
	public Main() {
		ctrl = new Controller(this);
		
		userRegister = new UserRegisterPanel(ctrl, this);
		welcome = new WelcomePanel(ctrl);
		adminRegister = new AdministratorRegisterPanel(ctrl, this);
		
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
	public void showUserRegisterPanel() {
		this.remove(pnlMain);
		this.add(userRegister);
		screenRefresh();
	}
	
	public void showAdministratorRegisterPanel() {
		this.remove(pnlMain);
		this.add(adminRegister);
		screenRefresh();
	}
	
	public void userToMenu() {
		this.remove(userRegister);
		this.add(pnlMain);
		screenRefresh();
	}
	
	public void adminToMenu() {
		this.remove(adminRegister);
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
