package com.test.jdbc;

import java.sql.Connection;

import com.test.my.DBUtil;

public class Ex02 {
	
	public static void main(String[] args) {

		Connection conn = DBUtil.open();
//		Connection conn = DBUtil.open("192.168.10.53", "team", "java1234");
		
		try {
			
			System.out.println(conn.isClosed());
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	} //main
	
}