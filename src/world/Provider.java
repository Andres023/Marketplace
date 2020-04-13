package world;

/*
 * @author Andrés Felipe Pájaro Jurado
 * 
 * Class provider has the attributes to insert into the DB
 */
public class Provider{
	
	private String name;
	private String companyName;
	private String phoneNumber;
	private String contactEmail;
	private String adress;
	private int providerType;
	private String email;
	private String password;
	
	
	public Provider (String name, String companyName, String phoneNumber, String contactEmail, String adress, int providerType, String email, String password) {
		
		//Initialize the attributes of the provider
		this.name = name;
		this.companyName = companyName;
		this.phoneNumber = phoneNumber;
		this.contactEmail = contactEmail;
		this.adress = adress;
		this.providerType = providerType;
		this.email = email;
		this.password = password;
		
	}

	//Setters & Getters
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getContactEmail() {
		return contactEmail;
	}


	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public int getProviderType() {
		return providerType;
	}


	public void setProviderType(int providerType) {
		this.providerType = providerType;
	}


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
