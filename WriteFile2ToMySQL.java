package vocab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class WriteFile2ToMySQL {

	public static void main(String[] args) {

		Statement stmt = null;
		ResultSet rs = null;
		BufferedReader reader;

		Connection con = ConnectionProvider.getCon();

		int i = 0;
		String sql;

		try {
			System.out.println("Connected to the database");
			//stmt = con.createStatement();
			// rs = stmt.executeQuery("USE vocabulary");
			reader = new BufferedReader(new FileReader("english-words.txt"));
			String line = reader.readLine();
			// System.out.println(line);
			// while (line != null) {
			// System.out.println(line);
			// // read next line
			// sql = "INSERT INTO word_list(word) VALUES ('" + line + "');";
			// stmt.execute(sql);
			// line = reader.readLine();}
			
			System.out.println("Disconnected from database");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try

		{   
			stmt = con.createStatement();
			sql = "select * from word_list";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("word"));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
