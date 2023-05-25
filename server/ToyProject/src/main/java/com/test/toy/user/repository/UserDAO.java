package com.test.toy.user.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

            String sql = "select * from tblUser where id = ? and pw = ? and ing='y'";

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

	public int unregister(String id) {
		
		try {

			String sql = "update tblUser set pw = 'x', name='x', email = 'x', pic = 'x', profile = 'x', ing = 'n' where id = ?";

			pstat = con.prepareStatement(sql);

			pstat.setString(1, id);

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public List<LogDTO> listLog(Map<String, String> map) {
		
		try {

			String sql = "select lv, count(hour) as cnt from (select level - 1 as lv from dual connect by level <= 24) a left outer join (select to_char(regdate, 'hh24') as hour from tblBoard where id = ? and to_char(regdate, 'yyyymmdd') = ?) b on a.lv = b.hour group by lv order by lv asc";

			pstat = con.prepareStatement(sql);

			pstat.setString(1, map.get("id"));
			pstat.setString(2, String.format("%s%02d%02d"
	                  , map.get("year")
	                  , Integer.parseInt(map.get("month"))
	                  , Integer.parseInt(map.get("date"))));

			rs = pstat.executeQuery();

			List<LogDTO> list = new ArrayList<LogDTO>();

			while (rs.next()) {

				LogDTO dto = new LogDTO();

				dto.setHour(rs.getString("lv"));
				dto.setCnt(rs.getString("cnt"));

				list.add(dto);
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public List<LogDTO> checkLog(Map<String, String> map) {
		try {

			String sql = "select lv, count(dd) as cnt from (select level as lv from dual connect by level <= 31) a left outer join (select to_char(regdate, 'dd') as dd from tblBoard where id = ? and to_char(regdate, 'yyyymm') = ?) b on a.lv = b.dd group by lv order by lv";

			pstat = con.prepareStatement(sql);

			pstat.setString(1, map.get("id"));
			pstat.setString(2, String.format("%s%02d"
	                  , map.get("year")
	                  , Integer.parseInt(map.get("month"))));

			rs = pstat.executeQuery();

			List<LogDTO> list = new ArrayList<LogDTO>();

			while (rs.next()) {

				LogDTO dto = new LogDTO();

				dto.setHour(rs.getString("lv"));
				dto.setCnt(rs.getString("cnt"));

				list.add(dto);
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}



}
