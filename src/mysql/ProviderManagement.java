package mysql;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import world.Provider;
import world.Session;

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

	public String searchSales(Date sinceDate, Date fromDate, int provId) {
		openConnection();
		String sql = "SELECT ventas.IdVenta, servicios.nombreServicio, servicios.costo, personas.nombres, personas.apellidos, personas.numDoc, transacciones.fechaPago FROM ventas INNER JOIN servicios ON ventas.idServicio = servicios.idServicio INNER JOIN usuarios ON ventas.idUsuario = usuarios.idUsuario INNER JOIN personas ON personas.idPersona = usuarios.idPersona INNER JOIN transacciones ON transacciones.idTransaccion = ventas.idTransaccion WHERE ventas.idProveedor = ? AND transacciones.fechaPago BETWEEN ? AND ?;";
		String sales = "";
		try {
			PreparedStatement prepare = connection.prepareStatement(sql);
			prepare.setInt(1,provId);
			prepare.setDate(2, sinceDate);
			prepare.setDate(3, fromDate);
			ResultSet rs = prepare.executeQuery();
			
			while (rs.next()) {
				sales+=rs.getInt(1)+"/";
				sales+=rs.getString(2)+"/";
				sales+=rs.getInt(3)+"/";
				sales+=rs.getString(4)+"/";
				sales+=rs.getString(5)+"/";
				sales+=rs.getString(6)+"/";
				sales+=rs.getDate(7)+",";
			}
			
			return sales;
			
		}catch (Exception ex) {
			return null;
		}
		
	}

	public String searchSales(String clientDoc) {
		
		return null;
	}

}
