package com.test.mvc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.test.my.DBUtil;

public class AddressDAO {
	
	public int getCount() {
		
		try {
			
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
			
			con = DBUtil.open();
			
			String sql = "select count(*) as cnt from tblAddress";
			
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				return rs.getInt("cnt");
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}

}
