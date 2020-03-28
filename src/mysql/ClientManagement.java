package mysql;

import java.sql.Date;
import java.sql.PreparedStatement;
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
		try {
			openConnection();
		}catch (Exception ex) {
			
		}
	}
	
	public boolean registerClient(User user){
		try {
			//Declare the SQL statement
        	String sql="INSERT INTO usuarios (nombres,apellidos,tipoDoc,numDoc,telefono,codigoPostal,fechaNacimiento,genero) VALUES (?,?,?,?,?,?,?,?)";
        	
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
				
				return prepare.executeUpdate() > 0;
			}else {
				return false;
			}
						
		}catch(SQLException ex) {
			Logger.getLogger(ClientManagement.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

}
