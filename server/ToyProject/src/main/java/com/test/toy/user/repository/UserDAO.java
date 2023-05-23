package com.test.toy.user.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.jdbc.DBUtil;

public class UserDAO {

    private Connection con;
    private Statement st;
    private PreparedStatement pstat;
    private ResultSet rs;

    public UserDAO() {
        this.con = DBUtil.open();
    }

    public int register(UserDTO dto) {
        
        try {

            String sql = "insert into tblUser (id, pw, name, email, pic, profile, lv) values (?, ?, ?, ?, ?, ?, 1)";

            pstat = con.prepareStatement(sql);
                
            pstat.setString(1, dto.getId());
            pstat.setString(2, dto.getPw());
            pstat.setString(3, dto.getName());
            pstat.setString(4, dto.getEmail());
            pstat.setString(5, dto.getPic());
            pstat.setString(6, dto.getProfile());

            return pstat.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return 0;
    }

    public UserDTO login(UserDTO dto) {
        
        try {

            String sql = "select * from tblUser where id = ? and pw = ?";

            pstat = con.prepareStatement(sql);

            pstat.setString(1, dto.getId());
            pstat.setString(2, dto.getPw());

            rs = pstat.executeQuery();

            if (rs.next()) {

                UserDTO result = new UserDTO();

                result.setId(rs.getString("id"));
                result.setLv(rs.getString("lv"));

                return result;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }

	public UserDTO get(String id) {
		
		try {

			String sql = "select * from tblUser where id = '" + id + "'";

			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {

				UserDTO dto = new UserDTO();
				
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setLv(rs.getString("lv"));
				dto.setPic(rs.getString("pic"));
				dto.setProfile(rs.getString("profile"));
				
				return dto;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	//DAO의 메소드 1개 > 딱 1개의 SQL만 실행할 것!
	public Map<String, String> getCount(String id) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		try {
			
			String sql = "select count(*) as cnt from tblBoard where id = ?";
			
			pstat = con.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				map.put("bcount", rs.getString("cnt"));
			}
			
			rs.close();
			pstat.close();
			
			
			
			sql = "select count(*) as cnt from tblComment where id = ?";
			
			pstat = con.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				map.put("ccount", rs.getString("cnt"));
			}
			
			rs.close();
			pstat.close();
			
			return map;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return map;
	}

}
