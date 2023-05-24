package com.test.toy.place.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.DBUtil;

public class PlaceDAO {

	private Connection con;
	private PreparedStatement pstat;
	private Statement st;
	private ResultSet rs;
	
	public PlaceDAO() {
		this.con = DBUtil.open();
	}

	public int addPlace(PlaceDTO dto) {
		
		try {

			String sql = "insert into tblPlace (seq, name, content, pic, regdate, id) values (seqPlace.nextVal, ?, ?, ?, default, ?)";

			pstat = con.prepareStatement(sql);
					
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getPic());
			pstat.setString(4, dto.getId());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public List<PlaceDTO> listPlace() {
		
		try {

			String sql = "select tblPlace.*, (select name from tblUser where id = tblPlace.id) as uname from tblPlace order by seq desc";

			st = con.createStatement();
			rs = st.executeQuery(sql);

			List<PlaceDTO> list = new ArrayList<PlaceDTO>();

			while (rs.next()) {

				PlaceDTO dto = new PlaceDTO();

				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setPic(rs.getString("pic"));
				dto.setUname(rs.getString("uname"));
				dto.setId(rs.getString("id"));

				list.add(dto);
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public PlaceDTO get(String seq) {
		
		try {

			String sql = "select tblPlace.*, (select name from tblUser where id = tblPlace.id) as uname from tblPlace where seq = ?";

			pstat = con.prepareStatement(sql);

			pstat.setString(1, seq);

			rs = pstat.executeQuery();

			if (rs.next()) {

				PlaceDTO dto = new PlaceDTO();

				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setPic(rs.getString("pic"));
				dto.setUname(rs.getString("uname"));
				dto.setId(rs.getString("id"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));

				return dto;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
