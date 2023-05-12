package com.test.file;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.my.DBUtil;

//DAO, Data Access Object
// - DB 작업 담당자
// - 데이터 작업 담당자
public class FileDAO {
    
    private Connection con;
    private Statement st;
    private PreparedStatement pstat;
    private ResultSet rs;
    
    public FileDAO() {
        this.con = DBUtil.open();
    }

    public int add(FileDTO dto) {
        
        try {
            
            String sql = "insert into tblFile (seq, name, filename, regdate) values (seqFile.nextVal, ?, ?, default)";
            
            pstat = con.prepareStatement(sql);
            
            pstat.setString(1, dto.getName());
            pstat.setString(2, dto.getFilename());
            
            return pstat.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return 0;
    }

    public List<FileDTO> list() {
        
        try {
            
            String sql = "select seq, filename from tblFile order by seq desc";
            
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            List<FileDTO> list = new ArrayList<FileDTO>();
            
            while(rs.next()) {
                
                //레코드 1줄 > FileDTO 1개
                FileDTO dto = new FileDTO();
                
                dto.setSeq(rs.getString("seq"));
                dto.setFilename(rs.getString("filename"));
                
                list.add(dto);
                
            }
            
            return list;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }

    public FileDTO get(String seq) {
        
        
        try {
            
            String sql = "select * from tblFile where seq = ?";
            
            pstat = con.prepareStatement(sql);
            pstat.setString(1, seq);
            
            rs = pstat.executeQuery();
            
            
            if(rs.next()) {

                FileDTO dto = new FileDTO();
                
                dto.setSeq(rs.getString("seq"));
                dto.setName(rs.getString("name"));
                dto.setFilename(rs.getString("filename"));
                dto.setRegdate(rs.getString("regdate"));

                return dto;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
}
