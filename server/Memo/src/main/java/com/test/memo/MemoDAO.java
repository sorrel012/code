package com.test.memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.my.DBUtil;

public class MemoDAO {

    private Connection con;
    private Statement st;
    private PreparedStatement pstat;
    private ResultSet rs;

    public MemoDAO() {
        this.con = DBUtil.open();
    }

    public static void main(String[] args) {

        MemoDTO dto = new MemoDTO();

        dto.setMemo("메모");

        System.out.println(dto.getMemo());

    } //main

    public List<CategoryDTO> clist() {

        try {

            String sql = "select seq, name from tblCategory order by name asc";
            st = con.createStatement();
            rs = st.executeQuery(sql);

            List<CategoryDTO> clist = new ArrayList<CategoryDTO>();

            while(rs.next()) {

                CategoryDTO dto = new CategoryDTO();

                dto.setSeq(rs.getString("seq"));
                dto.setName(rs.getString("name"));

                clist.add(dto);

            }

            return clist;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int add(MemoDTO dto) {

        try {

            String sql = "insert into tblMemo values(seqMemo.nextVal, ?, default, ?)";
            pstat = con.prepareStatement(sql);

            pstat.setString(1, dto.getMemo());
            pstat.setString(2, dto.getCseq());

            return pstat.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public List<MemoDTO> list() {


        try {

            String sql = "select \r\n"
                    + "    tblMemo.*,\r\n"
                    + "    (select icon from tblCategory where seq = tblMemo.cseq) as icon,\r\n"
                    + "    (select color from tblCategory where seq = tblMemo.cseq) as color\r\n"
                    + "from tblMemo order by seq desc";
            st = con.createStatement();

            rs = st.executeQuery(sql);

            List<MemoDTO> list = new ArrayList<MemoDTO>();

            while(rs.next()) {

                MemoDTO dto = new MemoDTO();

                dto.setSeq(rs.getString("seq"));
                dto.setMemo(rs.getString("memo"));
                dto.setRegdate(rs.getString("regdate"));
                dto.setCseq(rs.getString("cseq"));

                dto.setIcon(rs.getString("icon"));
                dto.setColor(rs.getString("color"));

                list.add(dto);

            }

            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public MemoDTO get(String seq) {

        try {

            String sql = "select * from tblMemo where seq = ?";

            pstat = con.prepareStatement(sql);
            pstat.setString(1, seq);

            rs = pstat.executeQuery();

            if(rs.next()) {

                MemoDTO dto = new MemoDTO();

                dto.setSeq(rs.getString("seq"));
                dto.setMemo(rs.getString("memo"));
                dto.setRegdate(rs.getString("regdate"));
                dto.setCseq(rs.getString("cseq"));

                return dto;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public int edit(MemoDTO dto) {
        
        try {

            String sql = "update tblMemo set memo = ?, cseq = ? where seq = ?";
            pstat = con.prepareStatement(sql);

            pstat.setString(1, dto.getMemo());
            pstat.setString(2, dto.getCseq());
            pstat.setString(3, dto.getSeq());

            return pstat.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return 0;
    }

    public int del(String seq) {
        
        try {

            String sql = "delete from tblMemo where seq = ?";
            
            pstat = con.prepareStatement(sql);

            pstat.setString(1, seq);

            return pstat.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return 0;
    }
}
