package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
private Connection conn;
	
	public DBConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		String connectionUrl = "jdbc:mysql://localhost:3306/QuanLyGiaiDau";
		String connectionUser = "root";
		String connectionPassword = "";
		this.conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
	}
	
	public Connection getConnection()
	{
		return this.conn;
	}
}
