package mysql;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import visual.BuyWindow;

public class BankManagement extends BankConnection{
	
	private int balance;
	private int cost;
	
	//Account data
	private String docNumber;
	private Date dueDate;
	private int securityCode;
	private String cardNumber;
	private int ownerId;
	
	public BankManagement(String docNumber, Date dueDate, int securityCode, String cardNumber, int cost) {
		this.docNumber = docNumber;
		this.dueDate = dueDate;
		this.securityCode = securityCode;
		this.cardNumber = cardNumber;
		this.cost = cost;
	}
	
	/*
	 * Verify if the account exists and if the user 
	 * have enough money
	 */
	public String searchMoney(){
		double start = System.nanoTime();
		double end;

		openConnection();
		
		try {
			ownerId = -1;
			
			String sql = "SELECT idTitular FROM cuentas WHERE docTitular = ? AND fechaVencimiento = ? AND codigoSeguridad = ? AND numeroTarjeta = ?";
			PreparedStatement prepare = connection.prepareStatement(sql);
			prepare.setString(1, docNumber);
			prepare.setDate(2, dueDate);
			prepare.setInt(3, securityCode);
			prepare.setString(4, cardNumber);
			
			ResultSet resulSet = prepare.executeQuery();
			
			if(resulSet.next()) { //Validates if the data account matches any in the database
				
				ownerId = resulSet.getInt(1);
				
				sql = "SELECT saldo FROM saldos WHERE idTitular = " + ownerId;
				prepare = connection.prepareStatement(sql);
				resulSet = prepare.executeQuery();
				
				if(resulSet.next()) {// Find the account balance
					this.balance = resulSet.getInt(1);
					closeConnection();
					end = System.nanoTime();
					double elapsedTime = (end-start)/1000000;
					System.out.println("Tiempo de ejecución: "+ elapsedTime + " Milisegundos");
					return "CORRECT";
				}else {
					closeConnection();
					return "ERROR";
				}
			}else {
				closeConnection();
				return "NO_ACCOUNT";
			}
			
		} catch (Exception ex) {
			closeConnection();
			return "ERROR";
		}
	}
	
	
	/*
	 * Make the pay and discount into the database
	 */
	public String makePay(BuyWindow window) {
		
		String state = searchMoney();
		
		switch (state) {
		case "CORRECT":
			//Make the pay
			if(cost <= this.balance) {
				int newBalance = balance - cost;
				try {
					openConnection();
					
					
					String sql = "UPDATE saldos SET saldo = ? WHERE idTitular = ?";
					PreparedStatement prepare = connection.prepareStatement(sql);
					prepare.setInt(1, newBalance);
					prepare.setInt(2, ownerId);
					int result = prepare.executeUpdate();
					
					if(result > 0) {
						//Get the day of the transaction (Today)
						Calendar c = Calendar.getInstance();
						int day = c.get(Calendar.DATE);
						int month = c.get(Calendar.MONTH);
						int year = c.get(Calendar.YEAR);
						
						String [] transaction = {"COMPRA PAQUETE TURÍSTICO", "Débito" , (year+"-"+month+"-"+day)};
						window.setTransaction(transaction);
						connection.commit();
						closeConnection();
						return state;
					}else {
						connection.rollback();
						closeConnection();
						return "ERROR";
					}
		
				}catch(Exception ex) {
					closeConnection();
					return "ERROR";
				}
				
			}else {
				return "ERROR";
			}
		case "NO_BALANCE":
			//Account hasn't enough balance
			return state;
		case "NO_ACCOUNT":
			//Account doesn't exists
			return state;
		case "ERROR":
			//An error has occurred
			return state;
		default:
			return "ERROR";
		}
	}
	
}
