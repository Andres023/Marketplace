package world;

public class Service {
    private String name;
    private int cost;
    private String originCity;
    private String destinationCity;
    private int transport;
    private int hotel;
    private int food;
    

	public Service(String name, int cost, String originCity, String destinationCity, int transport, int hotel, int food) {
        this.name = name;
        this.cost = cost;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.transport = transport;
        this.hotel = hotel;
        this.food = food;
	}

	//Setters & Getters
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	public String getOriginCity() {
		return originCity;
	}


	public void setOriginCity(String originCity) {
		this.originCity = originCity;
	}


	public String getDestinationCity() {
		return destinationCity;
	}


	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}


	public int getTransport() {
		return transport;
	}


	public void setTransport(int transport) {
		this.transport = transport;
	}


	public int getHotel() {
		return hotel;
	}


	public void setHotel(int hotel) {
		this.hotel = hotel;
	}


	public int getFood() {
		return food;
	}


	public void setFood(int food) {
		this.food = food;
	}
	
	

}