
/* 
    계정
    
    사용자 관련 > DCL
    - 계정 생성, 삭제, 접근 제어
    - 리소스 접근 권한 제어
    
    현재 사용 계정
    - system(X)
    - hr(O)

    프로젝트 계정 생성
    
    1. 계정 생성하기
        - 권한을 가지고 있는 계정만 가능 > 관리자급(sys,system)
        ~ create user 계정명 identified by 암호; > 계정 생성
        ~ alter user 계정명 identified by 암호; > 암호 변경
        ~ drop user 계정명; > 계정 삭제
    
    *** 새로 생성된 계정은 아무 권한이 없다. > 접속할 권한도 없다.
    
    2. 사용자에게 권한 부여하기    
        ~ grant 권한면 to 유저명;
        
    3. 사용자에게서 권한 제거하기
        ~ revoke 권한명 from 유저명;
    
    @ 권한 종류
        - create use
        - create session
        - create table
        - create view
        - create sequence
        - create procedure
    
    @ 권한의 집합 > role
        1. connect
            - 사용자 DB 접속 + 기본적 행동
            ~ ALTER SESSION, CREATE CLUSTER, CREATE DATABASE LINK, CREATE SEQUENCE, CREATE SESSION,
              CREATE SYNONYM, CREATE TABLE

        2. resource
            - 사용자가 객체 조작
            ~ CREATE CLUSTER, CREATE PROCEDURE, CREATE SEQUENCE, CREATE TABLE, CREATE TRIGGER
            
        3. dba
            - 준관리자급 권한
    
*/

create user hong identified by java1234;
alter user hong identified by 1111; --에러 아님!
drop user hong;


show user;

grant create session to hong;

grant create table to hong;


--프로젝트 진행 > 프로젝트용 계정

grant connect, resource, create view to team; --수업계정(hr)

grant connect, resource, dba to team; --학습용 > 프로젝트 계정


-- Java + Oracle 연동

