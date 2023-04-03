package com.test.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.test.my.DBUtil;

public class Ex05_PreparedStatement {
    
    public static void main(String[] args) {
        
//        m1();
//        m2();
//        m3();
        m4();
        
    }

    private static void m4() {
        
        String name = "하하하";
        String age = "22";
        String gender = "m";
        String tel = "010-1234-5678";
        String address = "서울시 동대문구 이문동";
        
        Connection conn = null;
        PreparedStatement pstat = null;
        
        try {
            
            conn = DBUtil.open();
            
            
            String sql = "insert into tblAddress(seq, name, age, gender, tel, address, regdate) values (seqAddress.nextVal, ?, ?, ?, ?, ?, default)";
            pstat = conn.prepareStatement(sql);

            // 동일 SQL로 인식 > but 데이터만 바꾼다.
            // > 데이터를 뺀 나머지 부분에 대한 작업은 재사용이 된다.
            for(int i = 0; i < 10; i++) {

                pstat.setString(1, name + i);
                pstat.setString(2, age);
                pstat.setString(3, gender);
                pstat.setString(4, tel);
                pstat.setString(5, address);

                int result = pstat.executeUpdate();
                System.out.println(result);
            }
            pstat.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private static void m3() {
        
        //주소록 x 10명 추가(난수)
        /// - SQL 동일 + 데이터 상이 > 작업 반복
        
        String name = "하하하";
        String age = "22";
        String gender = "m";
        String tel = "010-1234-5678";
        String address = "서울시 동대문구 이문동 쌍용 8층";
        
        Connection conn = null;
        Statement stat = null;
        
        try {
            
            conn = DBUtil.open(); //1회
            stat = conn.createStatement(); //1회
            
            
            for(int i = 0; i <= 9; i++) {
            String sql = String.format("insert into tblAddress(seq, name, age, gender, tel, address, regdate) values (seqAddress.nextVal, '%s', %s, '%s', '%s', '%s', default)"
                                            , name + i, age, gender, tel, address) ; //10회
            
            int result = stat.executeUpdate(sql); //10회
            System.out.println(result);
            }
            
            stat.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }

    private static void m2() {
        
        //주소록> 행 추가(+사용자 입력)
        String name = "하하하";
        String age = "22";
        String gender = "m";
        String tel = "010-1234-5678";
        String address = "서울시 동대문구 이문동's 카페";
        
        Connection conn = null;
        PreparedStatement pstat = null;
        
        try {
            
            conn = DBUtil.open();
            
            // ?: 오라클 문법> > 오라클 매개변수
            String sql = "insert into tblAddress(seq, name, age, gender, tel, address, regdate) values (seqAddress.nextVal, ?, ?, ?, ?, ?, default)";
            pstat = conn.prepareStatement(sql);
            
            pstat.setString(1, name); //psat이 참조하는 SQL에서 첫 번째 매개변수에다 name을 대입해라
            pstat.setString(2, age);
            pstat.setString(3, gender);
            pstat.setString(4, tel);
            pstat.setString(5, address);
            
            int result = pstat.executeUpdate();
            System.out.println(result);
            
            pstat.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private static void m1() {
        
        //주소록> 행 추가(+사용자 입력)
        String name = "하하하";
        String age = "22";
        String gender = "m";
        String tel = "010-1234-5678";
        String address = "서울시 동대문구 이문동 쌍옹's 8층";
        
        address = address.replace("'", "''");
        
        Connection conn = null;
        Statement stat = null;
        
        try {
            
            conn = DBUtil.open();
            
            //비교 포인트!!
            //Statement
            
            String sql = String.format("insert into tblAddress(seq, name, age, gender, tel, address, regdate) values (seqAddress.nextVal, '%s', %s, '%s', '%s', '%s', default)"
                                            , name, age, gender, tel, address) ;
            stat = conn.createStatement();
            
            int result = stat.executeUpdate(sql);
            System.out.println(result);
            
            stat.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    } //main

}
