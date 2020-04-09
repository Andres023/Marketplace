package controller;

import javax.swing.JOptionPane;

import mysql.AdministratorManagement;
import mysql.ClientManagement;
import mysql.LoginManagement;
import visual.Main;
import world.Administrator;
import world.User;

/*
 * @author Andrés Pájaro
 * 
 * This class is the bridge between the world and the interface (Main class)
 * 
 */
public class Controller {
	
	Main main;
	
	public Controller(Main main) {
		this.main = main;
	}
	
	/*
	 * Register the client into the DB
	 */
	public void clientRegister(User user){

        //Create the registerClient Object
        ClientManagement register = new ClientManagement();
        
        //Insert the client in the DB
        boolean insertPerson = register.registerPerson(user);
        
        //If the insert has been success, now, insert the user
        if(insertPerson){
        	boolean insertUser = register.registerUser(user);
        	if(insertUser) {
	        	JOptionPane.showMessageDialog(null, "Los datos han sido insertados correctamente.\n"
	        			+ "Por favor inicie sesión", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        	}else {
        		JOptionPane.showMessageDialog(null, "Los datos no ha podido ser insertados.\n"
            			+ "Por favor inténtelo nuevamente", "Éxito", JOptionPane.WARNING_MESSAGE);
        	}
        }else {
        	JOptionPane.showMessageDialog(null, "Los datos no ha podido ser insertados.\n"
        			+ "Por favor inténtelo nuevamente", "Éxito", JOptionPane.WARNING_MESSAGE);
        }
	}
	
	/*
	 * Register the administrator into the DB
	 */
	public void adminRegister(Administrator admin){

        //Create the registerAdmin Object
        AdministratorManagement register = new AdministratorManagement();
        
        //Insert the person in the DB
        boolean insertPerson = register.registerPerson(admin);
        
        //If the insert has been success, now, insert the admin
        if(insertPerson){
        	boolean insertAdmin = register.registerAdmin(admin);
        	if(insertAdmin) {
	        	JOptionPane.showMessageDialog(null, "Los datos han sido insertados correctamente.\n"
	        			+ "Por favor inicie sesión", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        	}else {
        		JOptionPane.showMessageDialog(null, "Los datos no ha podido ser insertados.\n"
            			+ "Por favor inténtelo nuevamente", "Éxito", JOptionPane.WARNING_MESSAGE);
        	}
        }else {
        	JOptionPane.showMessageDialog(null, "Los datos no ha podido ser insertados.\n"
        			+ "Por favor inténtelo nuevamente", "Éxito", JOptionPane.WARNING_MESSAGE);
        }
	}
	public void login(String email, String password) {
		
		//Create the loginMangement object
		LoginManagement login = new LoginManagement();
		
		int loginStatus = login.login(email, password);
		
		if(loginStatus > 0) {
			System.out.println("Éxito");
			main.showWelcomePanel();
			
		}else {
			JOptionPane.showMessageDialog(null, "El correo o la contraseña son incorrectos.\n"
        			+ "Por favor inténtelo nuevamente", "Error", JOptionPane.WARNING_MESSAGE);
		}
	}

}
