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
			System.out.println("DB연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("DB 연결 오류 또는 쿼리 오류 입니다.");
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
	//삽입, 수정, 삭제 전용
	public static void executeQuery(String sql) {
		try {
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
