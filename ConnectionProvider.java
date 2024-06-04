package vocab;

import java.sql.Connection;

import java.sql.DriverManager;

public class ConnectionProvider {

	public static Connection getCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/word_list", "root", "fast");

			if (con != null) {
				System.out.println("Db connected");
			} else {
				System.out.println("Db not connected");
			}

			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public static void main(String[] args) {

		// ConnectionProvider cProvider = new ConnectionProvider();
		ConnectionProvider.getCon();

	}

}