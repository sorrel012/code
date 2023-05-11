package com.test.mvc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.my.DBUtil;

public class AddressDAO {
	
	private Connection con = null;
	private Statement st = null;
	private ResultSet rs = null;
	
	public AddressDAO() {
		con = DBUtil.open();
	}
	
	public int getCount() {
		
		try {
			
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

	public ArrayList<AddressVO> list() {
		
		try {
			
			String sql = "select * from tblAddress";
			
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			//ResultSet > ArrayList<AddressVO>
			
			ArrayList<AddressVO> list = new ArrayList<AddressVO>();
			
			while(rs.next()) {
				//레코드 한 줄  AddressVO 담기
				AddressVO vo = new AddressVO();
				
				vo.setSeq(rs.getString("seq"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getString("age"));
				vo.setTel(rs.getString("tel"));
				vo.setAddress(rs.getString("address"));
				
				list.add(vo);
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
