package com.test.toy.board;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.jdbc.DBUtil;

public class Dummy {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement pstat = null;
		
		con = DBUtil.open();
		
		try {
			
			String sql = "insert into tblBoard values (seqBoard.nextVal, ?, '내용', 'hong', default, default)";
			
			pstat = con.prepareStatement(sql);
			
			for(int i=0; i<250; i++) {
				
				pstat.setString(1, "게시판 페이징 처리중.."+i);
				pstat.executeUpdate();
				System.out.println(i);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	} //main
	
}
