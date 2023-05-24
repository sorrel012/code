package com.test.toy.place.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
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

	public List<PlaceDTO> listPlace(String tag) {

		List<PlaceDTO> list = new ArrayList<PlaceDTO>();
		
		try {
			
			String sql = "";
			
			if (tag == null || tag.equals("")) {
				sql = "select tblPlace.*, (select name from tblUser where id = tblPlace.id) as uname from tblPlace order by seq desc";
				pstat = con.prepareStatement(sql);
			} else {

				sql = "select \r\n"
						+ "    tblPlace.*, \r\n"
						+ "    (select name from tblUser where id = tblPlace.id) as uname \r\n"
						+ "from tblPlace \r\n"
						+ "    where seq in (select pseq from tblPlaceHashTag\r\n"
						+ "                where hseq = (select seq from tblHashTag where tag = ?))\r\n"
						+ "    order by seq desc";

				pstat = con.prepareStatement(sql);
				pstat.setString(1, tag);
			}
			
			rs = pstat.executeQuery();


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
		
		return list;
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

	public void addHashTag(String tag) {
		
		try {

			String sql = "insert into tblHashTag (seq, tag) values (seqHashTag.nextVal, ?)";

			pstat = con.prepareStatement(sql);

			pstat.setString(1, tag);

			pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public String getHashTagSeq() {
		
		try {

			String sql = "select max(seq) as seq from tblHashTag";

			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {

				return rs.getString("seq");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public String getPlaceSeq() {
		
		try {

			String sql = "select max(seq) as seq from tblPlace";

			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {

				return rs.getString("seq");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public void addPlaceHashTag(HashMap<String, String> map) {
		
		try {

			String sql = "insert into tblPlaceHashTag (seq, pseq, hseq) values (seqPlaceHashTag.nextVal, ?, ?)";

			pstat = con.prepareStatement(sql);

			pstat.setString(1, map.get("pseq"));
			pstat.setString(2, map.get("hseq"));

			pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<String> getHashTag(String seq) {
		
		ArrayList<String> hashtag = new ArrayList<String>();
		
		try {
			
			String sql = "select tag from tblHashTag h inner join tblPlaceHashTag ph on h.seq = ph.hseq where ph.pseq = ?";
			
			pstat = con.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				hashtag.add(rs.getString("tag"));
			}
			
			return hashtag;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return hashtag;
	}

	public boolean checkHashTag(String tag) {
		
		try {

			String sql = "select count(*) as cnt from tblHashTag where tag = ?";

			pstat = con.prepareStatement(sql);

			pstat.setString(1, tag);

			rs = pstat.executeQuery();

			if (rs.next()) {
				return rs.getInt("cnt") > 0 ? false : true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}

	public String getHashTagSeq(String tag) {
		
		try {

			String sql = String.format("select seq as seq from tblHashTag where tag = '%s'", tag);

			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {

				return rs.getString("seq");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
