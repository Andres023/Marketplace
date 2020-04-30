package mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import world.Session;
import world.User;

/*
 * @autor Andrés Pájaro
 * 
 * Insert the client into the MYSQL DB and create 
 * the Person and User objects
 * 
 */
public class ClientManagement extends ConnectionManagement{
	
	//Contains important data about the person who is logged in 
	private Session session;
	
	public ClientManagement(Session session) {
		this.session = session;
	}
	
	public boolean registerPerson(User user){
		try {
			openConnection();
			
			//Declare the SQL statement
        	String sql=" INSERT INTO personas (nombres,apellidos,tipoDoc,numDoc,telefono,codigoPostal,fechaNacimiento,genero) VALUES (?,?,?,?,?,?,?,?)";
        	
        	PreparedStatement prepare = connection.prepareStatement(sql);
        	
			if(!connection.isClosed()){
				prepare.setString(1, user.getNames());
				prepare.setString(2, user.getLastnames());
				prepare.setInt(3, user.getDocType());
				prepare.setString(4, user.getDocNumber());
				prepare.setString(5, user.getPhoneNumber());
				prepare.setString(6, user.getPostalCode());
				prepare.setDate(7, user.getBirth());
				prepare.setInt(8, user.getGender());
				
				int result = prepare.executeUpdate();
				
				//If the INSERT has been success, now we can INSERT the user info (email & password)
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
			Logger.getLogger(ClientManagement.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}
	
	public boolean registerUser(User user) {
		
		try {
			
			openConnection();
			
			String sql = "INSERT INTO usuarios (idPersona, correo, clave) VALUES (?,?,?)";
			
			PreparedStatement prepare = connection.prepareStatement(sql);
			
			int id = getID(user);//Get the ID of the person to insert as FK in the user table
			
			if(id > 0) {
				prepare.setInt(1, id);
				prepare.setString(2, user.getEmail());
				prepare.setString(3, user.getPassword());
				
				int result = prepare.executeUpdate();
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
				connection.rollback();
				closeConnection();
				return false;
			}
		}catch (SQLException ex) {
			closeConnection();
			Logger.getLogger(ClientManagement.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	/*
	 * Return the ID that references to the person
	 */
	public int getID(User user){
		int id;
		String sql = "SELECT idPersona FROM personas WHERE numDoc = ?";
		try {
			PreparedStatement prepare = connection.prepareStatement(sql);
			prepare.setString(1, user.getDocNumber());
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

	public ArrayList<String> searchOfferByName(String offerName) {
		try {
			
			openConnection();
			
			String offerLike = "%"+offerName+"%";
			String sql = "SELECT idServicio, nombreServicio, costo, fechaPublicacion, ciudadOrigen, descripcion, ciudadDestino FROM servicios WHERE nombreServicio LIKE " + "\'"+offerLike+"\'" ;
			
			PreparedStatement prepare = connection.prepareStatement(sql);
			ResultSet resulSet = prepare.executeQuery();
			
			ArrayList<String> offer = new ArrayList<String>();
			
			if(resulSet.next()) {
				offer.add(resulSet.getInt(1)+"");
				offer.add(resulSet.getString(2));
				offer.add(resulSet.getInt(3)+"");
				offer.add(resulSet.getDate(4)+"");
				offer.add(resulSet.getString(5));
				offer.add(resulSet.getInt(6)+"");
				offer.add(resulSet.getString(7));
				
				closeConnection();
				
				return offer;
			}else {
				closeConnection();
				return null;
			}
		}catch(Exception ex) {
			closeConnection();
			return null;
		}
		
	}

	public int[] searchOfferDescription(int ID) {
		
		int description [] = new int [3]; 
		
		try {
			openConnection();
			String sql = "SELECT * FROM descripcion WHERE idDescripcion = " + ID;
			PreparedStatement prepare = connection.prepareStatement(sql);
			ResultSet resulSet = prepare.executeQuery();
			
			if(resulSet.next()) {
				
				description [0] = resulSet.getInt(2);
				description [1] = resulSet.getInt(3);
				description [2] = resulSet.getInt(4);
				
				closeConnection();
				
				return description;
			}else {
				closeConnection();
				return null;
			}
			
		}catch (Exception ex) {
			closeConnection();
			return null;
		}
	}
	
	//Access to the database and complete the transaction
	public boolean buyService(int userId, int serviceId) {
		
		try {
			openConnection();
			
			//Make the payment (NOT YET)
			
			//Give the service
			//1. Get the all information required in the database
			String sql = "SELECT proveedor FROM proveedores_servicios WHERE servicio = " + serviceId;
			PreparedStatement prepare = connection.prepareStatement(sql);
			ResultSet resulSet = prepare.executeQuery();
			int providerId;
			
			if(resulSet.next()) {
				providerId = resulSet.getInt(1);
			}else {
				return false;
			}
			
			connection.setAutoCommit(false);
			sql = "INSERT INTO ventas (idProveedor, idServicio, IdUsuario) VALUES (?,?,?)";
			prepare = connection.prepareStatement(sql);
			prepare.setInt(1, providerId);
			prepare.setInt(2, serviceId);
			prepare.setInt(3, userId);
			
			int resul = prepare.executeUpdate();
			if(resul > 0) {
				connection.commit();
				closeConnection();
				return true;
			}else {
				connection.rollback();
				closeConnection();
				return false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			closeConnection();
			return false;
		}
	}
	
}
