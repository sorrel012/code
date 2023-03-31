package com.test.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.test.my.DBUtil;

public class Ex04_Select {
    
    public static void main(String[] args) {

//        m1();
//        m2();
//        m3();
        m4();

    } //main

    private static void m4() {
        
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        
        try {
            
            conn = DBUtil.open();
            stat = conn.createStatement();
            
            //사용자에게 부서 입력 받은 후 부서 명단 출력
            
            Scanner scan = new Scanner(System.in);
            
            System.out.print("부서명: ");
            String buseo = scan.nextLine();
            
            String sql = String.format("select * from tblInsa where buseo = '%s'", buseo);
            
            rs = stat.executeQuery(sql);
            
            System.out.println("==================================================");
            System.out.println("                      " + buseo);
            System.out.println("==================================================");
            System.out.println("[번호]\t[이름]\t[직위]\t   [급여]\t[수당]");
            
            while(rs.next()) {
                System.out.printf("%s\t%s\t%s\t%,12d\t%,d\n"
                                    , rs.getString("num")
                                    , rs.getString("name")
                                    , rs.getString("jikwi")
                                    , rs.getInt("basicpay")
                                    , rs.getInt("sudang"));
            }
            
            rs.close();
            stat.close();
            conn.close();
                
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private static void m3() {
        
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        
        try {
            
            conn = DBUtil.open();
            stat = conn.createStatement();
            
            // 결과셋: N행 1열
            String sql = "select name from tblInsa order by name";
            
            rs = stat.executeQuery(sql);
            
            while(rs.next()) { //커서가 EOF를 가리키면 false > 반복문 탈출!
                System.out.println("이름: " + rs.getString("name"));
            }
            
            //ResultSet > 커서가 어디 있는지 늘 주의★★★★
            
            rs.close();
            stat.close();
            conn.close();
                
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private static void m2() {
        
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        
        try {
            
            conn = DBUtil.open();
            stat = conn.createStatement();
            
            //결과셋 : 1행 N열
            String sql = "select name, age, address from tblAddress where seq = 3";
            
            rs = stat.executeQuery(sql);
            
            if(rs.next()) {
                System.out.println("이름: "+ rs.getString("name"));
                System.out.println("나이: "+ rs.getString("age"));
                System.out.println("주소: "+ rs.getString("address"));
                
            } else {
                System.out.println("데이터가 없음");
            }
            
            rs.close();
            stat.close();
            conn.close();
                
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private static void m1() {
        
        //단일값 반환
        // - 결과셋 : 1행 1열
        
       Connection conn = null;
       Statement stat = null;
       ResultSet rs = null;

       try {
           
           conn = DBUtil.open();
           stat = conn.createStatement();
           
//           String sql = "select count(*) as cnt from tblInsa";
           String sql ="select name from tblInsa where num = 1010";
           
           rs = stat.executeQuery(sql);
           
           //ResultSet == 오라클 커서(Cursor) ≒ 스트림, Iterator, 향상된 for문
           
           rs.next(); //커서를 한 줄 전진(이동)

           //현재 커서가 가리키고 있는 레코드 접근 > 특정 컬럼값 읽기
           // - rs.getXXX();
//           int count = rs.getInt(1); //index: 1부터 시작
//           int count = rs.getInt("cnt");        //number > int
//           String count2 = rs.getString("cnt"); //number > String
           
//           System.out.println("카운트: " + count);
//           System.out.println("카운트: " + count2);
           
           String name = rs.getString("name");
           
           System.out.println("이름: " + name);
           
           rs.close();
           stat.close();
           conn.close();
           

       } catch (Exception e) {
           e.printStackTrace();
       }

    }

}
