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
    

    //View 서블릿에게 번호를 받아 일치하는 레코드 반환
    public BoardDTO get(String seq) {
        
        try {

            String sql = "select \r\n"
                    + "    tblBoard.*,\r\n"
                    + "    (select name from tblUser where id = tblBoard.id) as name    \r\n"
                    + "from tblBoard\r\n"
                    + "    where seq = ?";

            pstat = con.prepareStatement(sql);

            pstat.setString(1, seq);

            rs = pstat.executeQuery();

            if (rs.next()) {

                BoardDTO dto = new BoardDTO();

                dto.setSeq(rs.getString("seq"));
                dto.setSubject(rs.getString("subject"));
                dto.setContent(rs.getString("content"));
                dto.setId(rs.getString("id"));
                dto.setRegdate(rs.getString("regdate"));
                dto.setReadcount(rs.getString("readcount"));
                dto.setName(rs.getString("name"));

                return dto;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return null;
    }

    //View 서블릿에게번호를 받아 조회수 +1 증가
    public void updateReadcount(String seq) {
        
        try {

            String sql = "update tblBoard set readcount = readcount + 1 where seq = ?";

            pstat = con.prepareStatement(sql);

            pstat.setString(1, seq);

            pstat.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    //게시글 수정 내용 update
    public int edit(BoardDTO dto) {
        
        try {

            String sql = "update tblBoard set subject = ?, content = ? where seq = ?";

            pstat = con.prepareStatement(sql);

            pstat.setString(1, dto.getSubject());
            pstat.setString(2, dto.getContent());
            pstat.setString(3, dto.getSeq());

            return pstat.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return 0;
    }

    public int del(String seq) {
        
        try {

            String sql = "delete from tblBoard where seq = ?";

            pstat = con.prepareStatement(sql);

            pstat.setString(1, seq);

            return pstat.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return 0;
    }
    
    
}