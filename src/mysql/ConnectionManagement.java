package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagement {
	
	//Connection 
	protected Connection connection;
	protected String url= "";
	
	//User and password of the DB
	protected String user = "root";
	protected String password = "";
		
	/*
	 * 
	 */
	public boolean openConnection(){
		try{
			url = "jdbc:mysql://localhost:3306/marketpalce";
			connection = DriverManager.getConnection(url, user, password);
			return true;
		}catch (SQLException ex){
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
