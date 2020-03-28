package controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import mysql.ClientManagement;
import world.User;

/*
 * @author Andrés Pájaro
 * 
 * This class is the bridge between the world and the interface (Main class)
 * 
 */
public class Controller {
	
	//Utilities
	private Scanner sc = new Scanner(System.in);
	private SimpleDateFormat format = new SimpleDateFormat("YYYY/MM/DD");
	private boolean insert; 
	
	public Controller() {
		
	}
	
	public void clientRegister(){
		//Personal info (This will go on an decent interface xD)
		System.out.println("Nombre");
		String names = sc.nextLine();
		
		System.out.println("Apellidos");
		String lastnames = sc.nextLine();
		
		System.out.println("TipoDocumento");
		int docType = sc.nextInt();
		
		System.out.println("Documento");
		String docNumber = sc.next();
		
		System.out.println("Telefono");
		String phoneNumber = sc.next();
		
		System.out.println("Codigo POSTAL");
		String postalCode = sc.next();
		
		System.out.println("Nacimiento");
		String fecha = sc.next();
		Date birth = null;
		try {
			birth = format.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("Genero");
		int gender = sc.nextInt();
		
		//Account data
		System.out.println("Correo");
		String email = sc.next();
		
		System.out.println("Clave");
		String password = sc.next();
		
		System.out.println("Clave");
		String verifyPassword = sc.next();
		
		//Create the user
        User user = new User(email, password, verifyPassword, names, lastnames, docType, docNumber, phoneNumber, postalCode, birth, gender); 
        
        //Create de registerClient Object
        ClientManagement register = new ClientManagement();
        
        //Insert the client in the DB
        insert = register.registerClient(user);
        System.out.println(insert);
	}

}
