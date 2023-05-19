package com.test.toy.board.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.DBUtil;

public class BoardDAO {

    private Connection con;
    private Statement st;
    private PreparedStatement pstat;
    private ResultSet rs;

    public BoardDAO() {
        this.con = DBUtil.open();
    }

    public int add(BoardDTO dto) {
        
        try {

            String sql = "insert into tblBoard (seq, subject, content, id, regdate, readcount) values (seqBoard.nextVal, ?, ?, ?, default, default)";

            pstat = con.prepareStatement(sql);

            pstat.setString(1, dto.getSubject());
            pstat.setString(2, dto.getContent());
            pstat.setString(3, dto.getId());
            

            return pstat.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return 0;
    }

    
    //Board 서블릿이 게시판 목록 요청
    public List<BoardDTO> list() {
        
        try {

            String sql = "select * from vwBoard";

            st = con.createStatement();
            rs = st.executeQuery(sql);

            List<BoardDTO> list = new ArrayList<BoardDTO>();

            while (rs.next()) {

                BoardDTO dto = new BoardDTO();

                dto.setSeq(rs.getString("seq"));
                dto.setSubject(rs.getString("subject"));
                dto.setId(rs.getString("id"));
                dto.setRegdate(rs.getString("regdate"));
                dto.setReadcount(rs.getString("readcount"));
                
                dto.setName(rs.getString("name"));
                
                dto.setIsnew(rs.getDouble("isnew"));

                list.add(dto);
                
            }

            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
        
    }
    
    
}
