package com.test.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import com.test.my.DBUtil;

public class Ex03_Statement {

    public static void main(String[] args) {

//        m1()
//        m2();
        m3();

    } //main
    
    private static void m3() {
        
        //UI + SQL
        // - 사용자 입력 > insert
        // - ex) 게시판 글쓰기
        
        Connection conn = null;
        Statement stat = null;
        
        Scanner scan = new Scanner(System.in);
        
        try {
            
            System.out.print("이름: ");
            String name = scan.nextLine();
            
            System.out.print("나이: ");
            String age = scan.nextLine();
            
            System.out.print("성별(m,f): ");
            String gender = scan.nextLine();
            
            System.out.print("전화번호: ");
            String tel = scan.nextLine();
            
            System.out.print("주소: ");;
            String address = scan.nextLine();
            
            conn = DBUtil.open();
            stat = conn.createStatement();
            
            String sql = String.format("insert into tblAddress (seq, name, age, gender, tel, address, regdate)\r\n"
                                    + "    values (seqAddress.nextVal, '%s', %s, '%s', '%s', '%s', default)", name, age, gender, tel, address);
            
            int result = stat.executeUpdate(sql);
            System.out.println(result);
            
            stat.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private static void m2() {
       
        Connection conn = null;
        Statement stat = null;
        
        try {
            
            //1. DB 연결
            conn = DBUtil.open();
            stat = conn.createStatement();
            
            //2. SQL 실행
//            String sql = update tblAddress set age = age + 1 where seq = 2";
//            String sql = "delete from tblAddress where seq = 2";
//            String sql = "create sequence seqTemp"; //무조건 반환값 0
//            String sql = "drop sequence seqTemp";
//            String sql = "drop table tblAddress";
            String sql = "create table tblAddress (\r\n"
                    + "    seq number primary key,\r\n"
                    + "    name varchar2(10) not null,\r\n"
                    + "    age number(3) not null check(age between 1 and 99),\r\n"
                    + "    gender char(1) not null check(gender in ('m', 'f')),\r\n"
                    + "    tel varchar2(15) not null,\r\n"
                    + "    address varchar2(300) not null,    \r\n"
                    + "    regdate date default sysdate not null\r\n"
                    + ")";
            
            int result = stat.executeUpdate(sql);
            System.out.println(result);
            
            
            //3. DB 종료
            stat.close();
            conn.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private static void m1() {
       
        //insert 실행
        //1. DB 연결
        //2. SQL 실행
        //3. DB 종료
        
        Connection conn = null;
        Statement stat = null;
        
        try {
            
            //1. DB 연결
            conn = DBUtil.open();
            
            if(!conn.isClosed()) {
                System.out.println("접속 성공");

                //2. SQL 실행
                // - 자바는 SQL을 모른다. > SQL을 문자열 취급한다.(아무 의미 없음)
                String sql = "insert into tblAddress (seq, name, age, gender, tel, address, regdate)\r\n"
                              + "values (seqAddress.nextVal, '아무개', 22, 'm', '010-5555-5555', '서울시 강남구 대치동 100', default)";
                
                // stat > SQL 실행 > 어느 DB + 어떤 계정으로 실행할지?
                stat = conn.createStatement();
                
                //SQL 실행
                //a. 반환값이 없는 쿼리 > select를 뺀 나머지
                //  > void excuteUpdate()
                //b. 반환값이 있는 쿼리 > select
                //  > ResultSet excuteQuery()
                
                // SQL Developer의 Ctrl + Enter와 동일!
                int result = stat.executeUpdate(sql); // 적용된 행의 개수 > 변수를 받지 않아도 된다.
                
                if(result == 1) {
                    System.out.println("SQL 실행 성공");
                } else {
                    System.out.println("SQL 실행 실패");
                }
                
            } else {
                System.out.println("접속 실패");
            }
            
            
            //3. DB 종료
            stat.close();
            conn.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    } //m1
}
