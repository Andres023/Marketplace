package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import mysql.AdministratorManagement;
import mysql.ClientManagement;
import mysql.LoginManagement;
import mysql.ProviderManagement;
import mysql.ServiceManagement;
import visual.Main;
import world.Administrator;
import world.Provider;
import world.Service;
import world.Session;
import world.User;

/*
 * @author Andrés Pájaro
 * 
 * This class is the bridge between the world and the interface (Main class)
 * 
 */
public class Controller {
	
	private Main main;
	private Session session;
	
	public Controller(Main main) {
		this.main = main;
	}
	
	public void startSession(int id, int typeOfPerson) {
		session = new Session(id, typeOfPerson);
	}
	
	public void destroySession() {
		session.setId(0);
		session.setTypeOfPerson(0);
	}
	
	/*
	 * Register the client into the DB
	 */
	public void clientRegister(User user){

        //Create the registerClient Object
        ClientManagement register = new ClientManagement(session);
        
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
            			+ "Por favor inténtelo nuevamente", "Error", JOptionPane.WARNING_MESSAGE);
        	}
        }else {
        	JOptionPane.showMessageDialog(null, "Los datos no ha podido ser insertados.\n"
        			+ "Por favor inténtelo nuevamente", "Error", JOptionPane.WARNING_MESSAGE);
        }
	}
	
	/*
	 * Returns the offer data searched by name
	 */
	public ArrayList<String> searchOfferByName(String offerName) {
		System.out.println(session.getTypeOfPerson());
		
		ClientManagement client = new ClientManagement(session);
		ArrayList<String> offer = client.searchOfferByName(offerName);
		if(offer != null) {
			System.out.println(offer);
			return offer;
		}else {
			System.out.println("Algo flayó :c");
			return null;
		}
	}
	
	/*
	 * Returns the offer's description by ID
	 */
	public int [] searchOfferDescription(int ID) {
		ClientManagement client = new ClientManagement(session);
		int [] description = client.searchOfferDescription(ID);
		return description;
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
            			+ "Por favor inténtelo nuevamente", "Error", JOptionPane.WARNING_MESSAGE);
        	}
        }else {
        	JOptionPane.showMessageDialog(null, "Los datos no ha podido ser insertados.\n"
        			+ "Por favor inténtelo nuevamente", "Error", JOptionPane.WARNING_MESSAGE);
        }
	}
	
	/*
	 * Register the provider by an administrator into the DB
	 */
	public void providerRegister(Provider provider) {
		
		//Create the providerManagemet object
		ProviderManagement register = new ProviderManagement();
		
		//Insert the provider into the DB
		boolean insertProvider = register.registerProvider(provider);
        
        //If the insert has been success, now, insert the provider
        if(insertProvider){
        	JOptionPane.showMessageDialog(null, "Los datos han sido insertados correctamente.\n"
        			+ "Por favor inicie sesión", "Error", JOptionPane.INFORMATION_MESSAGE);
     
        }else {
        	JOptionPane.showMessageDialog(null, "Los datos no ha podido ser insertados.\n"
        			+ "Por favor inténtelo nuevamente", "Error", JOptionPane.WARNING_MESSAGE);
        }
		
	}

	/*
	 * The next three functions are used to verify if the login is possible
	 */
	
	public int userLogin(String email, String password) {
		
		//Create the loginMangement object
		LoginManagement login = new LoginManagement();
		
		int loginStatus = login.loginUser(email, password, this);
		
		if(loginStatus > 0) {
			System.out.println("Éxito");
			return 1; 
			
		}else {
			return -1;
		}
	}
	
	public int adminLogin(String email, String password) {
		
		//Create the loginMangement object
		LoginManagement login = new LoginManagement();
		
		int loginStatus = login.loginAdmin(email, password);
		
		if(loginStatus > 0) {
			System.out.println("Éxito");
			return 2;
				
		}else {
			return -1;
		}
		
	}
	
	public int providerLogin(String email, String password) {
		
		//Create the loginMangement object
		LoginManagement login = new LoginManagement();
		
		int loginStatus = login.loginProvider(email, password, this);
		
		if(loginStatus > 0) {
			System.out.println("Éxito");
			return 3;
				
		}else {
			return -1;
		}
	}
	
	public void showWelcomePanel(int typeofPerson) {
		//If typeOfPerson is equal than 1 show the userPanel
		//If typeOfPerson is equal than 2 show the administratorPanel
		if(typeofPerson == 1) {
			main.showUserWelcomePanel();
		}else if(typeofPerson == 2) {
			main.showAdminWelcomePanel();
		}else if(typeofPerson == 3) {
			main.showProivderWelcomePanel();
		}
	}

	/*
	 * Publish a service and make visible for users
	 */
	public void publishService(Service service) {
		
		 //Create the registerClient Object
		ServiceManagement register = new ServiceManagement(session);
        
        //Insert the service in the DB
        boolean publishService = register.registerService(service);
        
        if(publishService) {
        	JOptionPane.showMessageDialog(null, "Servicio publicado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }else {
        	JOptionPane.showMessageDialog(null, "No se han podido publicar el serivicio\nInténtelo nuevamente", "Error", JOptionPane.WARNING_MESSAGE);
        }
		
	}
	
	public void searchProvider() {
		
	}
	
	public void searchService() {
		
	}

}
