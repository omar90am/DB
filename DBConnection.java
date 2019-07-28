

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class DBConnection {
	private Connection conn;
	private String host;
	private String user;
	private String uPass;

	public DBConnection() {
		this.host ="jdbc:postgresql://localhost:5432/employee";
		this.user = "postgres";;
		this.uPass = "3111990";
		this.createConnection();
	}

	public void createConnection() {

		try {
			conn = DriverManager.getConnection(host, user, uPass);//open connection
			System.out.println("connection is created!");
		} catch (SQLException e) {
			System.out.println("Please check the user name and the password or the url of the DB!");
		}
	}

	public void createStatments(String sql, int priKey, int id, String address, String district, int city_id, int postal_code,
			Date last_update) {
		PreparedStatement ps = null;
		java.sql.Date lastUpdateDate = convertUtileTosqlDate(last_update);
		{
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, priKey);
			ps.setInt(2, id);
			ps.setString(3, address);
			ps.setString(4, district);
			ps.setInt(5, city_id);
			ps.setInt(6, postal_code);
			ps.setDate(7, lastUpdateDate);
		} catch (SQLException e) {
			System.out.println("File Data Problem");
		}
		try {
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Problem in the Query or the Table");
		}
		}
	}

	private java.sql.Date convertUtileTosqlDate(java.util.Date tempDate) {
		java.sql.Date sDate = new java.sql.Date(tempDate.getTime());
		return sDate;
	}

	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("connection is not closed a problem occured!");
		}
	}
}