package mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginManagement extends ConnectionManagement{

	public LoginManagement() {
		try {
			openConnection();
		}catch (Exception ex) {
			
		}
	}
	
	public int login (String email, String password) {
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
				return id;
			}else {
				return -1;
			}
			
		} catch (SQLException ex) {
			System.out.println("ERROR");
			return -1;
		}
	}
}
