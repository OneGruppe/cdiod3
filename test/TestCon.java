

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TestCon{

	Statement stmt = null;
	Connection connection = null;

	String driverName = "com.mysql.jdbc.Driver";

	String serverName = "91.100.3.26"; // Use this server. 
	String portNumber = "9865";
	//String url ="jdbc:mysql://91.100.3.26:9865/projektoplaeg3";
	String url ="jdbc:mysql://91.100.3.26:9865/CDIO3";

	String username = "Eclipse-bruger"; // You should modify this.
	String password = "ySmTL37uDjYZmzyn";

	public boolean doConnection(){ 
		try {
			// Load the JDBC driver
			Class.forName(driverName);

			// Create a connection to the database
			connection = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			// Could not find the database driver 
			System.out.println("ClassNotFoundException : "+e.getMessage());
			return false;
		} catch (SQLException e) {
			// Could not connect to the database
			System.out.println(e.getMessage()); 
			return false;
		}
		return true; 
	}

	public ArrayList<String> showListOfRoles() {
		ArrayList<String> roomsArray = new ArrayList<String>();
		String query = "SELECT * FROM roles";

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			int i = 1;
			while (rs.next()) {
				String room = rs.getString("role");
				roomsArray.add("Rolle " + i + ": " + room);
				i++;
			}
			return roomsArray;

		} catch (SQLException e) {
			// Could not connect to the database
			System.out.println(e.getMessage()); 
			return null;
		}
	}
}