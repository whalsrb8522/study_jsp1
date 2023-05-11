package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
	// 싱글톤 패턴 변수
	private static DatabaseConnector dbc = new DatabaseConnector();
	private Connection conn = null;		// DB 접속을 위한 규격 
	
	// JDBCDriver
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	
	// mysql URL
	private String jdbcUrl = "jdbc:mysql://localhost/javadb";
	
	// 접속 계정
	String user = "javauser";
	String pw = "mysql";
	
	private DatabaseConnector() {
		try {
			Class.forName(jdbcDriver);		// 1. Driver 연결
			conn = DriverManager.getConnection(jdbcUrl, user, pw);		// 2. 계정 연결
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("연결 정보가 일치하지 않습니다.");
			e.printStackTrace();
		}
	}
	
	// 싱글톤 패턴 메소드
	public static DatabaseConnector getInstance() {
		return dbc;
	}
	
	public Connection getConnection() {
		return conn;
	}
}
