package simjinproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class hellsDB {
	public static Connection conn;
	public static java.sql.Statement stmt;
	public static void init() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:XE",
					"temp","1234");
			stmt = conn.createStatement();
			System.out.println("DB���� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC ����̹� �ε� ����");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("DB ���� ���� �Ǵ� ���� ���� �Դϴ�.");
			e.printStackTrace();
		
		}
	}
	public static ResultSet getResultSet(String sql) {
		try {
			Statement stmt = conn.createStatement();
			return stmt.executeQuery(sql);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	//����, ����, ���� ����
	public static void executeQuery(String sql) {
		try {
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
