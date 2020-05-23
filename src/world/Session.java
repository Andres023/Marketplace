package world;

public class Session {
	
	//Important attributes for make query's based on the person that login
	private int id;
	private String docNumber;
	private int typeOfPerson;
	
	//Constructor
	public Session(int id, String docNumber, int typeOfPerson) {
		this.id = id;
		this.docNumber = docNumber;
		this.typeOfPerson = typeOfPerson;
	}
	
	
	//Setters & Getters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTypeOfPerson() {
		return typeOfPerson;
	}

	public void setTypeOfPerson(int typeOfPerson) {
		this.typeOfPerson = typeOfPerson;
	}


	public String getDocNumber() {
		return docNumber;
	}


	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}
	
	
}
