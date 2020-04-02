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
	
	//Controller
	private Controller ctrl; 
	
	public Main() {
		ctrl = new Controller();
		
		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pnlMain = new MainPanel();
		this.add(new RegisterPanel(ctrl));
		
		setVisible(true);
		
	}
	public static void main(String[] args) {
		
		new Main();
		
	}
	
}
