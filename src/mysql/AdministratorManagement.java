package mysql;

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
	
}
