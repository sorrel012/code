package com.test.ajax;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.my.DBUtil;

public class AjaxDAO {
    
    private Connection con;
    private Statement st;
    private PreparedStatement pstat;
    private ResultSet rs;

    public AjaxDAO() {
        this.con = DBUtil.open();
    }

    public int count() {
        
        try {
            
            String sql = "select count(*) as cnt from tblMemo";
            
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

    public ResearchDTO getResearch(int seq) {
        
        try {
            
            String sql = "select * from tblResearch where seq = " + seq;
            
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            if(rs.next()) {
                
                ResearchDTO dto = new ResearchDTO();
                
                dto.setSeq(rs.getString("seq"));
                dto.setQuestion(rs.getString("question"));
                
                String[] item = {
                        rs.getString("item1"),
                        rs.getString("item2"),
                        rs.getString("item3"),
                        rs.getString("item4")
                };
                
                String[] cnt = {
                        rs.getString("cnt1"),
                        rs.getString("cnt2"),
                        rs.getString("cnt3"),
                        rs.getString("cnt4")
                };
                
                dto.setItem(item);
                dto.setCnt(cnt);
                
                return dto;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }

    public List<AddressDTO> listAddress() {
        
        List<AddressDTO> list= new ArrayList<AddressDTO>();
        
        try {
            
            String sql = "select * from tblAddress";
            
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()) {
                
                AddressDTO dto = new AddressDTO();
                
                dto.setSeq(rs.getString("seq"));
                dto.setName(rs.getString("name"));
                dto.setAge(rs.getString("age"));
                dto.setTel(rs.getString("tel"));
                dto.setAddress(rs.getString("address"));
                
                list.add(dto);
            }
            
            return list;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }

    public int checkID(String id) {
        
        try {
            
            String sql = "select count(*) as cnt from tblUser where id = ?";
            
            pstat = con.prepareStatement(sql);
            pstat.setString(1, id);
            
            rs = pstat.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("cnt");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return 0;
    }

    public List<ZipCode> search(String dong) {
        
        List<ZipCode> list = new ArrayList<ZipCode>();
                
        try {
            
            String sql = "select * from zipcode "
                    + "where dong like '%' || ? || '%'";
            
            pstat = con.prepareStatement(sql);
            pstat.setString(1, dong);
            
            rs = pstat.executeQuery();
            
            while(rs.next()) {
                ZipCode dto = new ZipCode();
                dto.setZip(rs.getString("zip"));
                dto.setSido(rs.getString("sido"));
                dto.setGugun(rs.getString("gugun"));
                dto.setDong(rs.getString("dong"));
                
                list.add(dto);
            }
            
            return list;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
