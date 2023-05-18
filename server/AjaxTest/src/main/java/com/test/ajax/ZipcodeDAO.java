package com.test.ajax;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.DBUtil;


public class ZipcodeDAO {
    
    private Connection con;
    private Statement st;
    private PreparedStatement pstat;
    private ResultSet rs;

    public ZipcodeDAO() {
        this.con = DBUtil.open();
    }

    public List<ZipcodeDTO> search(String dong) {
        
        List<ZipcodeDTO> dlist = new ArrayList<ZipcodeDTO>();
        
        dong = "%"+dong+"%";
        
        try {
            
            String sql = "select zip,sido,gugun,dong from zipcode where dong like ?";
            
            pstat = con.prepareStatement(sql);
            pstat.setString(1, dong);
            
            rs = pstat.executeQuery();
            
            while(rs.next()) {
                
                ZipcodeDTO dto = new ZipcodeDTO();
                
                dto.setZip(rs.getString("zip"));
                dto.setSido(rs.getString("sido"));
                dto.setGugun(rs.getString("gugun"));
                dto.setDong(rs.getString("dong"));
                
                dlist.add(dto);
                
            }
            
            return dlist;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return dlist;
    }
    

}
