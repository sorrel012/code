
-- 테이블 생성

-- 수업 코드 컨벤션
-- - 객체 생성 > 객체 접두어 사용
create table tblType (

--    num number
--    num number(3)
--    num number(4,2)

    txt1 char(10),
    txt2 varchar2(10)    

);

-- 테이블 삭제
drop table tblType;

-- 테이블이 생성되었는지 확인하는 방법
-- 1. SQL 명령어 > 모든 툴이 동일하게 반응
select * from tabs;

--2. 툴마다 기능이 다름


-- 데이터 추가하기
insert into tblType (num) values (100);
insert into tblType (num) values (200);
insert into tblType (num) values (300);

insert into tblType (num) values (3.14); --실수형 리터럴

insert into tblType (num) values (-100);

insert into tblType (num) values (1000);

insert into tblType (num) values (9.9);

insert into tblType (num) values (999);
insert into tblType (num) values (-999);

insert into tblType (num) values (3.14);
insert into tblType (num) values (3.142);
insert into tblType (num) values (3.149);

insert into tblType (num) values (99.99);
insert into tblType (num) values (-99.99);


insert into tblType (txt1) values ('A'); --문자열 리터럴

--10바이트 > 몇 글자 ? > 오라클 인코딩 > UTF-8 > 영어(1), 한글(3)
insert into tblType (txt1) values ('ABCDEFGHUJ');
insert into tblType (txt1) values ('ABCDEFGHUJK'); --오버플로우

insert into tblType (txt1) values ('가');
insert into tblType (txt1) values ('가나다');
insert into tblType (txt1) values ('가나다라'); --오버플로우

insert into tblType (txt1, txt2) values('ABC', 'ABC');


-- 데이터 확인
--1. 
select * from tblType;

-- 현재 시간
select sysdate from dual;