package mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Controller;

public class LoginManagement extends ConnectionManagement{

	public LoginManagement() {
	
	}
	
	//Verify if the user exist in the DB
	public int loginUser (String email, String password) {
		
		openConnection();
		
		String sql = "SELECT idUsuario FROM usuarios WHERE correo = ? AND clave = ?";
		try {
			//SQL 
			PreparedStatement prepare = connection.prepareStatement(sql);
			prepare.setString(1, email);
			prepare.setString(2, password);
			ResultSet resulSet = prepare.executeQuery();
			
			//ID user
			int id = -1;
			if(resulSet.next()){
				id = resulSet.getInt(1);
			}
			
			if(id > 0) {
				closeConnection();
				return id;
			}else {
				closeConnection();
				return -1;
			}
			
		} catch (SQLException ex) {
			System.out.println("ERROR");
			closeConnection();
			return -1;
		}
	}
	
	//Verfiy if the administrator exist in the DB
	public int loginAdmin (String email, String password) {
		openConnection();
		
		String sql = "SELECT idAdmin FROM administradores WHERE correo = ? AND clave = ?";
		try {
			//SQL 
			PreparedStatement prepare = connection.prepareStatement(sql);
			prepare.setString(1, email);
			prepare.setString(2, password);
			ResultSet resulSet = prepare.executeQuery();
			
			//ID user
			int id = -1;
			if(resulSet.next()){
				id = resulSet.getInt(1);
			}
			
			if(id > 0) {
				closeConnection();
				return id;
			}else {
				closeConnection();
				return -1;
			}
			
		} catch (SQLException ex) {
			System.out.println("ERROR");
			return -1;
		}
	}
	
	//Verfiy if the provider exist in the DB
		public int loginProvider (String email, String password, Controller ctrl) {
			openConnection();
			
			String sql = "SELECT idProveedor FROM proveedores WHERE correo = ? AND clave = ?";
			try {
				//SQL 
				PreparedStatement prepare = connection.prepareStatement(sql);
				prepare.setString(1, email);
				prepare.setString(2, password);
				ResultSet resulSet = prepare.executeQuery();
				
				//ID user
				int id = -1;
				if(resulSet.next()){
					id = resulSet.getInt(1);
				}
				
				if(id > 0) {
					ctrl.startSession(id, 3);
					closeConnection();
					return id;
				}else {
					closeConnection();
					return -1;
				}
				
			} catch (SQLException ex) {
				System.out.println("ERROR");
				closeConnection();
				return -1;
			}
		}
}
