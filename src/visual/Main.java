package visual;

import controller.Controller;
/*
 * @author Andr�s P�jaro
 * 
 */
public class Main {

	Controller ctrl; 
	
	public Main() {
		ctrl = new Controller();
	}
	public static void main(String[] args) {
		
		new Main().ctrl.clientRegister();
		
	}
	
}
