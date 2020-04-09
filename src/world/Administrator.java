package world;

import java.sql.Date;

public class Administrator extends Person{
	
	//Attributes
	private String email;
	private String password;
	
	//Constructor
	public Administrator(String email, String password, String verifyPassword, String names, String lastnames, int docType, String docNumber, String phoneNumber, String postalCode, Date birth, int gender) {
		super(names, lastnames, docType, docNumber, phoneNumber, postalCode, birth, gender);
		if(verfifyPassword(password, verifyPassword)) {
			this.email = email;
			this.password = password;
		}
	}
	
	/*
	 * This method verify both password, the first time that the user is instantiated
	 * 
	 */
	public boolean verfifyPassword(String password, String verifyPassword) {
		if(password.equals(verifyPassword)) {
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * Allows the user enter to the marketplace's menu
	 */
	public boolean login() {
		
		return false;
	}
	
	/*
	 * 
	 */
	public void transactionHistory() {
		
	}
	
	/*
	 * 
	 */
	public boolean pay() {
		return false;
	}
	
	/*
	 * 
	 */
	public void searchProvider() {
		
	}

	//Setters & Getters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

}
