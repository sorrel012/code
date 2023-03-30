package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Ex01 {
	
	public static void main(String[] args) {

		try {

			Connection conn = null;
			
			//연결 문자열, Connection String > 오라클 접속 정보
			String url = "jdbc:oracle:thin:@localhost:1525:x"; 	//The Network Adapter could not establish the connection
			String id = "hr";									//invalid username/password; logon denied
			String pw = "java1234";								//invalid username/password; logon denied
			
			//JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");	//ClassNotFoundException
			
			//DB 접속
			conn = DriverManager.getConnection(url, id, pw);
			
			System.out.println(conn.isClosed()); //접속 상태 확인
			
			conn.close();
			
			System.out.println(conn.isClosed()); //접속 상태 확인
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	} //main
	
}
