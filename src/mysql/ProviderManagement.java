package mysql;

import java.sql.PreparedStatement;

import world.Provider;

public class ProviderManagement extends ConnectionManagement{

	public boolean registerProvider(Provider provider) {
		
		try {
			openConnection();
			
			String sql = "INSERT INTO proveedores (nombre, nombreEmpresa, telefono, correoContacto, direccion, tipoProveedor, correo, clave) VALUES (?,?,?,?,?,?,?,?)";
			
			PreparedStatement prepare = connection.prepareStatement(sql);
			prepare.setString(1, provider.getName());
			prepare.setString(2, provider.getCompanyName());
			prepare.setString(3,  provider.getPhoneNumber());
			prepare.setString(4, provider.getContactEmail());
			prepare.setString(5, provider.getAdress());
			prepare.setInt(6, provider.getProviderType());
			prepare.setString(7, provider.getEmail());
			prepare.setString(8, provider.getPassword());
			
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
			
		}catch (Exception ex) {
			closeConnection();
			return false;
		}
	}

}
