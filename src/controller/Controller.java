package controller;

import javax.swing.JOptionPane;

import mysql.ClientManagement;
import world.User;

/*
 * @author Andrés Pájaro
 * 
 * This class is the bridge between the world and the interface (Main class)
 * 
 */
public class Controller {
	
	public Controller() {
		
	}
	
	public void clientRegister(User user){

        //Create de registerClient Object
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

}
