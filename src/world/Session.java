package world;

public class Session {
	
	//Important attributes for make query's based on the person that login
	private int id;
	private int typeOfPerson;
	
	//Constructor
	public Session(int id, int typeOfPerson) {
		this.id = id;
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
	
}
