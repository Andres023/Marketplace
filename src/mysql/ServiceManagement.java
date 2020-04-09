package mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import world.Service;

public class ServiceManagement extends ConnectionManagement{
	
	public ServiceManagement() {
		try {
			openConnection();
		}catch (Exception ex) {
			
		}
	}
	
	public boolean registerService(Service service){
		try {
			//Declare the SQL statement
        	String sql=" INSERT INTO servicios (nombreServicio,costo,fechaPublicacion,ciudadOrigen) VALUES (?,?,?,?)";
        	
        	PreparedStatement prepare = connection.prepareStatement(sql);
        	
			if(!connection.isClosed()){
				prepare.setString(1, service.getName());
				prepare.setInt(2, service.getCost());
				prepare.setDate(3, service.getPublicationDate());
				prepare.setString(4, service.getOriginCity());

				int result = prepare.executeUpdate();
				
				//If the INSERT has been success, now we can INSERT the user info (email & password)
				if(result > 0) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
						
		}catch(SQLException ex) {
			Logger.getLogger(ClientManagement.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}
		
}