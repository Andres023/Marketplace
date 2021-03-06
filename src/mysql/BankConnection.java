package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BankConnection {
	
	//Connection 
	protected Connection connection;
	protected String driver = "com.mysql.jdbc.Driver";
	
	//User and password of the DB
	protected String user = "root";
	protected String password = "";
		
	/*
	 * 
	 */
	public boolean openConnection(){
		try{
			Class.forName(driver).newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/cuentas_bancarias?user="+user+"&password="+password);
			connection.setAutoCommit(false);
			return true;
		}catch (Exception ex){
			return false;
		}
	}
	/*
	 * 
	 */
	public boolean closeConnection(){
		try{
			connection.close();
			return true;
		}catch(SQLException ex){
			return false;
		}
	}

}
