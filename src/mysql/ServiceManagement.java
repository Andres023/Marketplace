package mysql;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import world.Service;
import world.Session;

public class ServiceManagement extends ConnectionManagement{
	
	private Session session;
	
	public ServiceManagement(Session session) {
		this.session = session;
	}
	
	/*
	 * To insert the data of the service, first we need insert the values if the "descripcion"
	 * table and return the ID to insert as FK in the "servicios" table
	 */
	public int getIDDescription(Service service) {
		
		try {
			
			openConnection();
			
			String sql = "INSERT INTO descripcion (transporte,hotel,alimento) VALUES (?,?,?)";
			PreparedStatement prepare = connection.prepareStatement(sql);
			
			prepare.setInt(1, service.getTransport());
			prepare.setInt(2, service.getHotel());
			prepare.setInt(3, service.getFood());
			
			int result = prepare.executeUpdate();
			if(result > 0) {//Insert is complete, now we need the ID of the description that we just inserted
				
				sql = "SELECT MAX(idDescripcion) AS lastID FROM descripcion";
				prepare = connection.prepareStatement(sql);
				
				ResultSet resulSet = prepare.executeQuery();
				
				//Last service's ID
				int id = -1;
				if(resulSet.next()){
					id = resulSet.getInt(1);
				}
				
				if(id > 0) {
					connection.commit();
					closeConnection();
					return id;
				}else {
					connection.rollback();
					closeConnection();
					return -1;
				}
				
			}else {
				return -1;
			}
		}catch (Exception ex) {
			return -1;
		}
	}
	
	public int getIDService() {
		try {
			String sql = "SELECT MAX(idServicio) AS lastID FROM servicios";
			PreparedStatement prepare = connection.prepareStatement(sql);
			
			ResultSet resulSet = prepare.executeQuery();
			
			//Last service's ID
			int id = -1;
			if(resulSet.next()){
				id = resulSet.getInt(1);
			}
			
			if(id > 0) {
				return id;
			}else {
				return -1;
			}
				
		}catch (Exception ex) {
			return -1;
		}
	}
	
	/*
	 * Insert the service into the DB
	 */
	public boolean registerService(Service service){
			
		try {
			
			openConnection();
		
			int description = getIDDescription(service);
			
			if(description > 0) {
				
				connection.setAutoCommit(false);
				
				String sql = "INSERT INTO servicios (nombreServicio, costo, fechaPublicacion, ciudadOrigen, descripcion, ciudadDestino) VALUES (?,?,?,?,?,?)";
				PreparedStatement prepare = connection.prepareStatement(sql);
				
				Calendar c = Calendar.getInstance();
				int day = c.get(Calendar.DATE);
				int month = c.get(Calendar.MONTH);
				int year = c.get(Calendar.YEAR);
				
				String dateStr = year+"-"+month+"-"+day;
				System.out.println(dateStr);
				Date date = Date.valueOf(dateStr);
					
				prepare.setString(1, service.getName());
				prepare.setInt(2, service.getCost());
				prepare.setDate(3, date);
				prepare.setString(4, service.getOriginCity());
				prepare.setInt(5, description);
				prepare.setString(6, service.getDestinationCity());
				
				int result = prepare.executeUpdate();
				
				if(result > 0) { //After the INSERT, complete the relationship manyToMany
					
					sql = "INSERT INTO proveedores_servicios (proveedor, servicio) VALUES (?,?)";
					prepare = connection.prepareStatement(sql);
					
					prepare.setInt(1, session.getId());
					prepare.setInt(2,getIDService());
					
					result = prepare.executeUpdate();
					
					if(result > 0) {
						connection.commit();
						closeConnection();
						return true; //The INSERT has been success
					}else {
						connection.rollback();
						closeConnection();
						return false;
					}
				}else {
					connection.rollback();
					closeConnection();
					return false;
				}
			}else {
				connection.rollback();
				closeConnection();
				return false;
			}
		}catch(SQLException ex) {
			closeConnection();
			Logger.getLogger(ClientManagement.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}
	
	public void searchServiceByName() {
		
	}
		
}