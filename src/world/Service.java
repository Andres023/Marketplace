package world;
import java.util.Date;

public class Service {
    private int idServices;
    private String name;
    private int cost;
    private Date publicationDate;
    private String originCity;

    

	public Service(int idServices, String name, int cost, Date publicationDate, String originCity) {
        this.idServices = idServices;
        this.name = name;
        this.cost = cost;
        this.publicationDate = publicationDate;
        this.originCity = originCity;
    }

    public Service() {
    }

   
    public int getIdServices() {
		return idServices;
	}

	public void setIdServices(int idServices) {
		this.idServices = idServices;
	}

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

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getOriginCity() {
		return originCity;
	}

	public void setOriginCity(String originCity) {
		this.originCity = originCity;
	}  
}