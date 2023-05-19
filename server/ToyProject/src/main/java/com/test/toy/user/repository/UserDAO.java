package com.test.toy.user.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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

}
