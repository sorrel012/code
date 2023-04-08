package com.db.project;

import java.sql.Connection;
import java.sql.Statement;

import com.test.my.DBUtil;

public class JDBC {

    public static void main(String[] args) {
        
        Connection conn = null;
        Statement stat = null;
        
        try {
            
            //1. DB 연결
            conn = DBUtil.open("59.5.203.65", "db", "java1234");
            
            if(!conn.isClosed()) {
                
                String sql =  String.format("update tblScore set student_seq = %d\r\n"
                                                + "    where student_seq = %d", 749, 929);
                
                stat = conn.createStatement();
                
                stat.executeUpdate(sql);                
                
            } else {
                System.out.println("접속 실패");
            }
            
            
            //3. DB 종료
            stat.close();
            conn.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    } //main
    
}
