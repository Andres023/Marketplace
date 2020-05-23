package visual;

import javax.swing.JFrame;

import controller.Controller;
import world.Session;

/*
 * @author Andrés Pájaro
 * 
 */
public class Main extends JFrame{

	//Visual
	private MainPanel pnlMain;
	private UserRegisterPanel userRegister;
	private WelcomeUserPanel welcomeUser;
	private WelcomeAdminPanel welcomeAdmin;
	private WelcomeProviderPanel welcomeProvider;
	private AdministratorRegisterPanel adminRegister;
	
	//Controller
	private Controller ctrl; 
	
	public Main() {
		ctrl = new Controller(this);
		
		userRegister = new UserRegisterPanel(ctrl, this);
		welcomeUser = new WelcomeUserPanel(ctrl, this);
		welcomeAdmin = new WelcomeAdminPanel(ctrl, this);
		welcomeProvider = new WelcomeProviderPanel(ctrl, this);
		adminRegister = new AdministratorRegisterPanel(ctrl, this);
		
		setTitle("MARKETPLACE V1.0");
		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pnlMain = new MainPanel(this, welcomeUser, userRegister, ctrl);
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
	
	public void showUserWelcomePanel() {
		this.remove(pnlMain);
		this.add(welcomeUser);
		welcomeUser.printCart();
		screenRefresh();
	}
	
	public void showAdminWelcomePanel() {
		this.remove(pnlMain);
		this.add(welcomeAdmin);
		welcomeAdmin.searchOffers("");
		screenRefresh();
	}
	
	public void showProivderWelcomePanel() {
		this.remove(pnlMain);
		this.add(welcomeProvider);
		screenRefresh();
	}
	
	public void userWelcomeToMenu(){
		this.remove(welcomeUser);
		this.add(pnlMain);
		screenRefresh();
	}
	
	public void adminWelcomeToMenu() {
		this.remove(welcomeAdmin);
		this.add(pnlMain);
		screenRefresh();
	}
	
	public void providerWelcomeToMenu() {
		this.remove(welcomeProvider);
		this.add(pnlMain);
		screenRefresh();
	}
	public void screenRefresh() {
		this.revalidate();
		this.repaint();
		pnlMain.refresh();
	}
	
	public static void main(String[] args) {
		new Main();
	}

	
	
}
