package mysql;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import world.Administrator;

/*
 * @autor Andrés Pájaro
 * 
 * Insert the administrator into the MYSQL DB and create 
 * the Person and Admin objects
 * 
 */
public class AdministratorManagement extends ConnectionManagement{
	
	public AdministratorManagement() {

	}
	
	public boolean registerPerson(Administrator admin){
		try {
			openConnection();
			
			//Declare the SQL statement
        	String sql=" INSERT INTO personas (nombres,apellidos,tipoDoc,numDoc,telefono,codigoPostal,fechaNacimiento,genero) VALUES (?,?,?,?,?,?,?,?)";
        	
        	PreparedStatement prepare = connection.prepareStatement(sql);
        	
			if(!connection.isClosed()){
				prepare.setString(1, admin.getNames());
				prepare.setString(2, admin.getLastnames());
				prepare.setInt(3, admin.getDocType());
				prepare.setString(4, admin.getDocNumber());
				prepare.setString(5, admin.getPhoneNumber());
				prepare.setString(6, admin.getPostalCode());
				prepare.setDate(7, admin.getBirth());
				prepare.setInt(8, admin.getGender());
				
				int result = prepare.executeUpdate();
				
				//If the INSERT has been success, now we can INSERT the admin info (email & password)
				if(result > 0) {
					connection.commit();
					closeConnection();
					return true;
				}else {
					connection.rollback();
					closeConnection();
					return false;
				}
			}else {
				closeConnection();
				return false;
			}
						
		}catch(SQLException ex) {
			closeConnection();
			Logger.getLogger(AdministratorManagement.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}
	
	public boolean registerAdmin(Administrator admin) {
		
		openConnection();
		
		try {
			String sql = "INSERT INTO administradores (idPersona, correo, clave) VALUES (?,?,?)";
			
			PreparedStatement prepare = connection.prepareStatement(sql);
			
			int id = getID(admin);//Get the ID of the person to insert as FK in the admin table
			
			if(id > 0) {
				prepare.setInt(1, id);
				prepare.setString(2, admin.getEmail());
				prepare.setString(3, admin.getPassword());
				
				int result = prepare.executeUpdate();
				if(result > 0) {
					closeConnection();
					return true;
				}else {
					closeConnection();
					return false;
				}
			}else {
				closeConnection();
				return false;
			}
		}catch (SQLException ex) {
			closeConnection();
			Logger.getLogger(AdministratorManagement.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	/*
	 * Return the ID that references to the person
	 */
	public int getID(Administrator admin){
		int id;
		String sql = "SELECT idPersona FROM personas WHERE numDoc = ?";
		try {
			PreparedStatement prepare = connection.prepareStatement(sql);
			prepare.setString(1, admin.getDocNumber());
			ResultSet resulSet = prepare.executeQuery();
			
			if(resulSet.next()){
				id = resulSet.getInt(1);
			}else {
				id = -1;
			}
			
		} catch (SQLException ex) {
			id = -1;
			ex.printStackTrace();
		}
		return id;
	}

	public String searchOffer(String offerIndication) {
		double start = System.nanoTime();
		double end;

		String sql = "SELECT * FROM servicios";
		String services = "";
		int rows = 0;
		
		if(offerIndication.length() > 0) { //If the indication exist, filter the query
			sql += " WHERE nombreServicio LIKE" + "\'%"+offerIndication+"%\'" ;
		}
		
		openConnection();
		
		try {
			PreparedStatement prepare = connection.prepareStatement(sql);
			ResultSet rs= prepare.executeQuery();
			
			do {
				rows+=1;// Find the number of query's rows
			}while(rs.next());
			
			if(rows == 0) {
				closeConnection();
				return null; // Return false if not exist matches
			}else {
				rs = prepare.executeQuery();
				while(rs.next()) {
					services += rs.getInt(1)+",";
					services += rs.getString(2)+",";
					services += rs.getInt(3)+",";
					services += rs.getDate(4)+",";
					services += rs.getString(5)+",";
					services += rs.getInt(6)+",";
					services += rs.getString(7)+",";
					services += rs.getInt(8)+",";
					String condition = getDescription(rs.getInt(6));// Find the description using the ID
					if(condition != null) {
						services += condition+"/";
					}else {
						return null;
					}
				}
				
				closeConnection();
				end = System.nanoTime();
				double elapsedTime = (end-start)/1000000;
				System.out.println("Tiempo de ejecución: "+ elapsedTime + " Milisegundos");
				return services;
			}
			
		}catch (Exception ex) {
			ex.printStackTrace();
			closeConnection();
			return null;
		}
	}
	
	public String getDescription(int descriptionId) {
		
		String sql = "SELECT transporte, hotel, alimento FROM descripcion WHERE idDescripcion = ?";
		String description = "";
		
		try {
			PreparedStatement prepare = connection.prepareStatement(sql);
			prepare.setInt(1, descriptionId);
			ResultSet rs = prepare.executeQuery();
			
			if(rs.next()) {
				description += rs.getInt(1)+"-";
				description += rs.getInt(2)+"-";
				description += rs.getInt(3);
				return description;
			}else {
				return null;
			}
			
		} catch (Exception ex) {
			return null;
		}
	}

	/*
	 * Update the information of a service
	 */
	public boolean updateService(int idService, String name, int cost, String origin, int idDescription,
			String destiny, String descriptions, int spaces) {
		
		openConnection();
		
		try {
			connection.setAutoCommit(false);
			String sql = "UPDATE servicios SET nombreServicio = ?, costo = ?, ciudadOrigen= ?, ciudadDestino = ?, cupos = ? WHERE idServicio = ?";
			PreparedStatement prepare = connection.prepareStatement(sql);
			prepare.setString(1, name);
			prepare.setInt(2, cost);
			prepare.setString(3, origin);
			prepare.setString(4, destiny);
			prepare.setInt(5, spaces);
			prepare.setInt(6, idService);
			
			int result = prepare.executeUpdate();
			if(result > 0) {
				//Actualize the description
				if(updateDescription(idDescription, descriptions)) {
					connection.commit();
					closeConnection();
					return true;
				}else {
					closeConnection();
					return false;
				}
			}else {
				closeConnection();
				return false;
			}
		}catch(Exception ex) {
			closeConnection();
			return false;
		}
	}

	private boolean updateDescription(int idDescription, String descriptions) {
		String [] description = descriptions.split("-");
		String sql = "UPDATE descripcion SET transporte = ?, hotel = ?, alimento = ? WHERE idDescripcion = ?";
		
		try {
			PreparedStatement prepare = connection.prepareStatement(sql);
			prepare.setInt(1, Integer.parseInt(description[0]));
			prepare.setInt(2, Integer.parseInt(description[1]));
			prepare.setInt(3, Integer.parseInt(description[2]));
			prepare.setInt(4, idDescription);
			int result = prepare.executeUpdate();
			
			if(result > 0) {
				connection.commit();
				return true;
			}else {
				return false;
			}
			
		}catch (Exception ex) {
			return false;
		}
		
	}
	
}
