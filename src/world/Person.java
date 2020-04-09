package world;

import java.sql.Date;

/*
 * @author Andrés Pájaro
 * 
 * Person it's the parent class from which users
 * and administrators extends.
 * 
 */
public class Person{

	//Attributes
	protected String names;
	protected String lastnames;
	protected int docType;
	protected String docNumber;
	protected String phoneNumber;
	protected String postalCode;
	protected Date birth;
	protected int gender;
	
	//Constructor
	public Person(String names, String lastnames, int docType, String docNumber, String phoneNumber, String postalCode, Date birth, int gender) {
		this.names = names;
		this.lastnames = lastnames;
		this.docType = docType;
		this.docNumber = docNumber;
		this.phoneNumber = phoneNumber;
		this.postalCode = postalCode;
		this.birth = birth;
		this.gender = gender;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLastnames() {
		return lastnames;
	}

	public void setLastnames(String lastnames) {
		this.lastnames = lastnames;
	}

	public int getDocType() {
		return docType;
	}

	public void setDocType(int docType) {
		this.docType = docType;
	}

	public String getDocNumber() {
		return docNumber;
	}

	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}	

}
