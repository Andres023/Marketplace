package mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import world.User;

/*
 * @autor Andrés Pájaro
 * 
 * Insert the client into the MYSQL DB and create 
 * the Person and User objects
 * 
 */
public class ClientManagement extends ConnectionManagement{
	
	public ClientManagement() {
		
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
	
}
